package com.xten.mybatis.entity;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-6-20
 * Time: 下午7:01
 * To change this template use File | Settings | File Templates.
 */
public class SpringMybatisType {
    private Integer id;
    private String name;
    private int type;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
