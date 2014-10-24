package com.blog.passport.dao;

import com.blog.domain.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface PassportDao {

	/**
	 * 查询用户信息
	 * @return
	 */
	@Select("SELECT id,name,pwd FROM ch_user WHERE name=#{name}")
    User findUserByID(@Param("name") String name);
	
	//@SelectProvider(type=LoginSqlProvider.class,method="findUserInfobyUID")
	//UserInfo findUserInfobyUID(@Param("UID") String UID);
	
	/**
	 * 用户信息注册
	 */
	@Insert("INSERT INTO ch_user (name,pwd,email,nick) VALUES (#{name},#{pwd},#{email},#{nick})")
	void regist(User user);
	
	
	
}
