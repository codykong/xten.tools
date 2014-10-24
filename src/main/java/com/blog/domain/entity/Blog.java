package com.blog.domain.entity;

import com.google.gson.Gson;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-9-18
 * Time: 下午5:42
 * To change this template use File | Settings | File Templates.
 */
public class Blog {

    private long id;	//博文主键
    private long uid;	//用户主键
    private String title;	//博文标题
    private String content;	//博文内容
    private String content_txt;     //纯文本博文内容
    private int type;	//博文类型
    private String area_code;	//地址代码
    private Date create_time;	//发布时间
    private Date update_time;	//更新时间
    private int view_count;	//浏览了次数
    private int support_count;	//赞同数
    private int comment_count;	//评论数
    private int status;	//状态，0：无效，1：有效

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }



    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getSupport_count() {
        return support_count;
    }

    public void setSupport_count(int support_count) {
        this.support_count = support_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getContent_txt() {
        return content_txt;
    }

    public void setContent_txt(String content_txt) {
        this.content_txt = content_txt;
    }

}
