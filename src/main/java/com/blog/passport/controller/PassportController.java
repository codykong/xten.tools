package com.blog.passport.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.blog.common.utils.ResultUtil;
import com.blog.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.common.data.DataEnum.LoginResEnum;
import com.blog.passport.service.PassportService;
import com.blog.passport.vo.PassportInfoVO;



@Controller
@RequestMapping("/passport")
public class PassportController {

	@Autowired
	private PassportService passportService;
	
	/**
	 * 注册信息
	 * @param passportInfoVO
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute PassportInfoVO passportInfoVO, Model view) {

		//用户注册信息验证
		if(!passportService.validateRegist(passportInfoVO)){
			
			return "error/error";
		}
		
		if(passportService.regist(passportInfoVO)){
			return "redirect:" +"/index";
		}else{
			return "error/error";
		}

	}
	
	/**
	 * 用户登陆验证
	 * @param passportInfoVO
	 * @param response
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute PassportInfoVO passportInfoVO,HttpServletResponse response, Model view){

        ResultUtil<User> resultUtil=passportService.validateUser(passportInfoVO);

        int permission=resultUtil.getCode();
		
		if(permission==LoginResEnum.USER.getValue()){
			
			Cookie cookie = new Cookie("colhunter",String.valueOf(resultUtil.getResult().getId()));
			cookie.setMaxAge(3600);
			cookie.setPath("/");
			response.addCookie(cookie);
			return "redirect:" +"/index";
		}else{
			return "error/error";
		}
		
		
		
	}
	
}
