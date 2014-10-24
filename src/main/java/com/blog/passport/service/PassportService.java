package com.blog.passport.service;

import com.blog.common.utils.ResultUtil;
import com.blog.domain.entity.User;
import com.blog.passport.vo.PassportInfoVO;
import org.springframework.stereotype.Service;

/**
 * 用户登录
 * @author kongqingyu
 * @date 2013-3-20 下午9:58:59
 */
@Service
public interface PassportService {

	/**
	 * 判断用户是否登录
	 * @param
	 * @return
	 */
    ResultUtil<User> validateUser(PassportInfoVO passportInfoVO);
	
	/**
	 * p判断用户信息是否符合要求
	 * @param loginVO
	 * @return
	 */
	boolean validateRegist(PassportInfoVO loginVO);
	
	
	/**
	 * 用户信息注册
	 * @param loginVO
	 * @return
	 */
	boolean regist(PassportInfoVO loginVO);
}
