package com.blog.common.base.spring;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

/**
 * 静态文件版本号
 * @author kongqingyu
 * @Time 2013-4-25 下午4:35:16
 */
public class ResourcePathExposer implements ServletContextAware {
	
	private ServletContext servletContext;
	
	private String resourceRoot;	//静态文件路径
	
	private String version;		//静态文件版本号
	
	public void initVersion(){
		
		resourceRoot="/resouces-"+version;
		getServletContext().setAttribute("resourceRoot", 
				getServletContext().getContextPath()+resourceRoot);

	}
	
	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String getResourceRoot() {
		return resourceRoot;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	

}
