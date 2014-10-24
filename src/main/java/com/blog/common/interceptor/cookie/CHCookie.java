package com.blog.common.interceptor.cookie;

import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;

import com.blog.common.utils.DesUtils;


public class CHCookie {

    /**
     * 加密工具
     */
    private DesUtils desUtils;
    /**
     * cookie的名字
     */
    private String name;
    /**
     * cookie的domain
     */
    private String domain;
    /**
     * cookie的路径
     */
    private String path;
    /**
     * cookie的过期时间 单位：秒
     */
    private int expiry;
    /**
     * cookie的key
     * 
     * @see #encrypt
     */
    private String key;
    /**
     * 是否加密cookie
     * 
     * @see #key
     */
    private boolean encrypt;



    public Cookie newCookie(String value) throws Exception {
        String newValue;
        if (!StringUtils.isEmpty(value)) {
            newValue = isEncrypt() ? desUtils.encrypt(value) : value;
        } else {
            newValue = value;
        }
        Cookie cookie = new Cookie(name, newValue);
        if (!StringUtils.isBlank(domain)) {
            cookie.setDomain(domain);
        }
        if (!StringUtils.isBlank(path)) {
            cookie.setPath(path);
        }
        if (expiry > 0) {
            cookie.setMaxAge(expiry);
        }
        return cookie;
    }

    public String getValue(String value) throws Exception {
        if (!StringUtils.isEmpty(value)) {
            return isEncrypt() ? desUtils.decrypt(value) : value;
        } else {
            return value;
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }


}