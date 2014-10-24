package com.blog.domain.vo.blog;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-9-18
 * Time: 下午5:47
 * To change this template use File | Settings | File Templates.
 */
public class BlogPreviewVO {

    /**
     * 博文主键
     */
    private long bId;
    /**
     * 博文标题
     */
    private String title;
    /**
     * 博文内容
     */
    private String content;
    /**
     *博文类型
     */
    private String type;
    /**
     *发布时间
     */
    private String publishTime;
    /**
     * 更新时间
     */
    private int updateTime;
    /**
     * 浏览量
     */
    private int viewCount;
    /**
     * 赞量
     */
    private int supportCount;
    /**
     * 评论数
     */
    private int commentCount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getbId() {
        return bId;
    }

    public void setbId(long bId) {
        this.bId = bId;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getSupportCount() {
        return supportCount;
    }

    public void setSupportCount(int supportCount) {
        this.supportCount = supportCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
