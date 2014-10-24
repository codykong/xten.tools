package com.blog.common.interceptor;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



/**
 * 根据cookie 判断是否登录
 * @author kongqingyu
 * @date 2013-3-20 下午9:06:48
 */
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

	private final static Log logger = LogFactory.getLog(CookieTools.class);
	
	@Autowired
	private CookieTools cookieTools;
	
	public static final String DEFAULT_COOKIE_NAME = "colhunter";
	
	private String loginUrlpassport= "";

	@Override
	public final boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) {
		
		if(!cookieTools.validateCookie(request) ){
			logger.info("cookie is Illegal");
			response.setHeader( "Pragma", "no-cache" );
	        response.addHeader( "Cache-Control", "must-revalidate" );
	        response.addHeader( "Cache-Control", "no-cache" );
	        response.addHeader( "Cache-Control", "no-store" );
	        response.setDateHeader("Expires", 0);
			String queryString = request.getQueryString();
			String url =(queryString == null || "".equals(queryString)) ? request.getRequestURL().toString(): request.getRequestURL().append("?").append(queryString).toString();
	        StringBuffer buffer = new StringBuffer();
	        buffer.append(loginUrlpassport).append("ReturnUrl=").append(java.net.URLEncoder.encode(url));
			try {
				response.sendRedirect("/login");
			} catch (IOException e) {

				logger.error("跳转失败");
			}
            return false;
		}else{
			return true;
		}
	}
	/**
	 * This implementation is empty.
	 */
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		FormsAuthenticationTicket.remove();
	}

	
}
