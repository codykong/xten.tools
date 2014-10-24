package com.blog.passport.vo;

/**
 * 用户登录vo
 * @author kongqingyu
 * @date 2013-3-20 下午10:02:47
 */
public class PassportInfoVO {

    private long uid;

	private String userName;	//用户名
	
	private String userPwd;	//密码
	
	private String userEmail; 	//用户邮箱


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
