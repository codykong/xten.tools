package com.blog.common.interceptor.cookie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * cookie操作工具
 * @author kongqingyu
 * @Time 2013-5-27 下午3:54:16
 */
public class CookieUtils {
    private Map<String, CHCookie> cookieMap;

    /**
     * 从cookie中取值值，会自动解密(如果是加密保存)。
     * 
     * @param servletRequest
     * @param name
     * @return
     * @throws Exception 
     */
    public String getCookieValue(HttpServletRequest servletRequest, String name) throws Exception {
        Cookie[] cookies = servletRequest.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals(name)) {
                    if (cookieMap != null && cookieMap.containsKey(name)) {
                        CHCookie chCookie = cookieMap.get(name);
                        return chCookie.getValue(cookie.getValue());
                    }
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 删除cookie，不管有没有定义都能删除
     * 
     * @param servletResponse
     * @param name
     * @throws Exception 
     */
    public void deleteCookie(HttpServletResponse servletResponse, String name) throws Exception {
        Cookie cookie;
        if (cookieMap != null && cookieMap.containsKey(name)) {
            CHCookie chCookie = cookieMap.get(name);
            cookie = chCookie.newCookie(null);
        } else {
            cookie = new Cookie(name, null);
        }
        cookie.setPath("/");
        cookie.setMaxAge(0);
        servletResponse.addCookie(cookie);
    }

    /**
     * 设置cookie值，必须定义后才能设置。
     * 
     * @param servletResponse
     * @param name
     * @param value
     * @throws Exception 
     */
    public void setCookie(HttpServletResponse servletResponse, String name, String value) throws Exception {
        if (cookieMap != null && cookieMap.containsKey(name)) {
            CHCookie chCookie = cookieMap.get(name);
            Cookie cookie = chCookie.newCookie(value);
            servletResponse.addCookie(cookie);
        } else {
            throw new RuntimeException("Cookie " + name + " is undefined!");
        }
    }

    /**
     * 设置cookie定义值
     * 
     * @param chCookieList
     */
    public void setchCookie(List<CHCookie> chCookieList) {
        if (chCookieList != null) {
            HashMap<String, CHCookie> chCookieHashMap = new HashMap<String, CHCookie>(chCookieList.size());
            for (CHCookie chCookie : chCookieList) {
                chCookieHashMap.put(chCookie.getName(), chCookie);
            }
            cookieMap = chCookieHashMap;
        }
    }

    /**
     * 删除所有状态没有设置过期的cookie
     * 
     * @param request
     * @param response
     * @throws Exception 
     */
    public void invalidate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (cookieMap != null && cookieMap.size() > 0) {
            for (Map.Entry<String, CHCookie> entry : cookieMap.entrySet()) {
                String key = entry.getKey();
                CHCookie chCookie = entry.getValue();
                if (chCookie.getExpiry() < 1) {
                    if (StringUtils.isNotEmpty(getCookieValue(request, key))) {
                        deleteCookie(response, key);
                    }
                }
            }
        }
    }

}