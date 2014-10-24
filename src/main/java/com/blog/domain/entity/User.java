package com.blog.domain.entity;

import java.util.Date;

/**
 * 用户登录
 * @author kongqingyu
 * @Time 2013-3-22 下午5:30:45
 */
public class User {

    private String name;	//用户名

    private String pwd;	//密码

    private String email; 	//用户邮箱

    private String nick; 	 //用户昵称

    private long id;//用户id

    private Date create_time;   //创建时间


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }


    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
