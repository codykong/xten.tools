package com.blog.domain.vo.comment;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-19
 * Time: 下午5:34
 * To change this template use File | Settings | File Templates.
 */
public class CommentVO {

    /**
     * 评论主键id
     */
    private long id;
    /**
     * 评论内容id，包括博客和评论
     */
    private long sourceId;
    /**
     * 评论的第一级评论祖先
     */
    private long ancestorId;
    /**
     * 评论的博客id
     */
    private long blogId;
    /**
     * 评论的级别
     */
    private int level;
    /**
     * 用户id
     */
    private long uid;
    /**
     * 用户姓名
     */
    private String userName;
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
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 支持数
     */
    private int supportCount;
    /**
     * 评论数
     */
    private int commentCount;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getSupportCount() {
        return supportCount;
    }

    public void setSupportCount(int supportCount) {
        this.supportCount = supportCount;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getAncestorId() {
        return ancestorId;
    }

    public void setAncestorId(long ancestorId) {
        this.ancestorId = ancestorId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }
}
