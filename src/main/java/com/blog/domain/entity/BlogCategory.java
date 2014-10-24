package com.blog.domain.entity;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午1:53
 * 博文类型
 */
public class BlogCategory {
    /**
     * 博文类型id
     */
    private long id;
    /**
     * 用户类型，默认0，为系统
     */
    private long uid;
    /**
     * 类型名称
     */
    private String name;
    /**
     * 状态 -1：删除，0：有效
     */
    private int status;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
