package com.blog.domain.vo.comment;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-24
 * Time: 上午10:48
 * To change this template use File | Settings | File Templates.
 */
public class CommentDiscussVO {

    /**
     * 当前评论，如果第一级评论，则该对象为空
     */
    private CommentVO commentVO;
    /**
     * 对于该评论的一系列子评论
     */
    private List<CommentDiscussVO> childComments;
    /**
     * 是否有子评论
     */
    private boolean hasChild;
    /**
     * 评论级别
     */
    private int level;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }

    public CommentVO getCommentVO() {
        return commentVO;
    }

    public void setCommentVO(CommentVO commentVO) {
        this.commentVO = commentVO;
    }

    public List<CommentDiscussVO> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<CommentDiscussVO> childComments) {
        this.childComments = childComments;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
