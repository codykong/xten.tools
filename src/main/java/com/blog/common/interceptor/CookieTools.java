package com.blog.common.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;



public class CookieTools {

private final static Log logger = LogFactory.getLog(CookieTools.class);
	
	private String AuthenticationKey;

	private String cookieName;
	
		
	public boolean validateCookie(HttpServletRequest request){
		try {
			// 将dotnet的cookie转换成ticket对象，放入上下文中。
			if (!parseDotnetTicket(request)) {

				logger.info("--create loginContext failed--");
				return false;
				
			}

		} catch (Exception e) {
			logger.error("--parseDotnetTicket error--", e);
			return false;
		}
		return true;
	}
	
	/**
	 * 将票据进行解密，判断票据是否过期
	 * @param request
	 * @return
	 */
	private boolean parseDotnetTicket(HttpServletRequest request) {

		Cookie loginCookie = null;
		Cookie[] cookies = request.getCookies();
		LoginContext loginContext=new LoginContext();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				String cliCookie = cookie.getName();
				if (cliCookie.equals(cookieName)) {
					loginCookie = cookie;
					break;
				}
			}
		}

		if (loginCookie == null) {
			
			logger.info("--login cookie is null--");
			return false;
		}
		loginCookie.setMaxAge(-1);
		if (StringUtils.hasText(loginCookie.getValue())) {
			
			loginContext.setUserId(Long.valueOf(loginCookie.getValue()));
			LoginContext.setLoginContext(loginContext);
			logger.info("--create loginContext success--"+ loginContext.getUserName());
			return true;
				
		} else {
			
			logger.info("--login cookie value is blank--");
			return false;
		}

	}

	public void setAuthenticationKey(String authenticationKey) {
		AuthenticationKey = authenticationKey;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

}
