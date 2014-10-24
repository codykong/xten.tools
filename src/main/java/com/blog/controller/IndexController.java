package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	/**
	 * 网址自动跳入主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "text/html")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		
		return "redirect:" +"/blog/list";
	}
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET,produces = "text/html")
	public String welcome(){
        return "redirect:" +"/blog/list";
	}


    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET,produces = "text/html")
    public String register(){

        return "passport/register";
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET,produces = "text/html")
    public String login(){

        return "passport/login";
    }

	
}
