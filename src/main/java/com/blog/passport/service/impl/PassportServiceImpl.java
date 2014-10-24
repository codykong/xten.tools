package com.blog.passport.service.impl;

import com.blog.common.utils.ResultUtil;
import com.blog.domain.entity.User;
import com.blog.passport.dao.PassportDao;
import com.blog.passport.vo.PassportInfoVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.common.data.DataEnum.LoginResEnum;
import com.blog.passport.service.PassportService;

@Service
public class PassportServiceImpl implements PassportService {

	private static final Log logger = LogFactory.getLog(PassportServiceImpl.class);
	
	@Autowired
	private PassportDao passportDao;

	/**
	 * 用户登录验证
	 */
	public ResultUtil<User> validateUser(PassportInfoVO passportInfoVO) {

        ResultUtil<User> passportResult=new ResultUtil<User>();
		try{
			User user = passportDao.findUserByID(passportInfoVO.getUserName());

			if (null == user) {
                passportResult.setCode(LoginResEnum.NOUSER.getValue());
                passportResult.setMessage("不存在该用户");
				return passportResult;	//不存在该用户
	
			} else if (user.getPwd().equalsIgnoreCase(passportInfoVO.getUserPwd())) {

                passportResult.setCode(LoginResEnum.USER.getValue());
                passportResult.setMessage("用户登录成功");
                passportResult.setResult(user);
                return passportResult;	//用户登录成功
				
			} else {
                passportResult.setCode(LoginResEnum.PWDWRONG.getValue());
                passportResult.setMessage("用户密码错误");
                return passportResult;	//用户密码错误
			}
		}catch(Exception e){
			logger.error("系统内部错误："+e.getMessage(),e);
            passportResult.setCode(LoginResEnum.ERROR.getValue());
            passportResult.setMessage("系统内部错误");
            return passportResult;
		}
		
	}
	
	public boolean validateRegist(PassportInfoVO passportInfoVO){
		
		if(passportInfoVO.getUserName().length()>30||passportInfoVO.getUserName().length()<5){
			
			return false;
		}else if(passportInfoVO.getUserPwd().length()>30||passportInfoVO.getUserPwd().length()<6){
			return false;
		}else{
			return true;
		}
				
	}
	
	/**
	 * 用户注册
	 */
	public boolean regist(PassportInfoVO passportInfoVO){
		
		User user =new User();
		user.setName(passportInfoVO.getUserName());
		user.setPwd(passportInfoVO.getUserPwd());
		user.setEmail(passportInfoVO.getUserEmail());
		user.setNick(passportInfoVO.getUserName());
		try{
			passportDao.regist(user);
			return true;
		}catch (Exception e) {
			logger.error("注册失败的用户信息：");
			return false;
		}

	}

}
