package com.blog.domain.entity;

import com.blog.domain.entity.base.BaseEntity;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
public class Tag extends BaseEntity {


    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
