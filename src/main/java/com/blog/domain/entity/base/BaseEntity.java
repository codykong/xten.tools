package com.blog.domain.entity.base;

import com.google.gson.Gson;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午5:56
 * To change this template use File | Settings | File Templates.
 */
public class BaseEntity {

    private long id;
    private Date create_time;
    private Date update_time;

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


    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
