package com.blog.domain.entity;

import com.google.gson.Gson;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-19
 * Time: 下午5:34
 * To change this template use File | Settings | File Templates.
 */
public class Comment {

    /**
     * 评论主键id
     */
    private long id;
    /**
     * 评论内容id，包括博客和评论
     */
    private long source_id;
    /**
     * 祖先id
     */
    private long ancestor_id;
    /**
     * 级别
     */
    private int level;
    /**
     * 用户id
     */
    private long uid;
    /**
     * 用户姓名
     */
    private String user_name;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论类型 1：博客，2：评论
     */
    private int type;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 更新时间
     */
    private Date update_time;
    /**
     * 支持数
     */
    private int support_count;
    /**
     * 评论数
     */
    private int comment_count;
    /**
     * 状态：-1：无效，0:有效
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

    public long getSource_id() {
        return source_id;
    }

    public void setSource_id(long source_id) {
        this.source_id = source_id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
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

    public long getAncestor_id() {
        return ancestor_id;
    }

    public void setAncestor_id(long ancestor_id) {
        this.ancestor_id = ancestor_id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
