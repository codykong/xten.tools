package com.blog.service;

import com.blog.domain.common.Page;
import com.blog.domain.vo.comment.CommentVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-23
 * Time: 下午3:19
 * To change this template use File | Settings | File Templates.
 */

public interface CommentService {
    /**
     * 保存评论
     * @param commentVO
     * @return
     */
    boolean saveComment(CommentVO commentVO);

    /**
     * 获取该博客的一定数量的评论
     * @param sourceId
     * @param page
     * @return
     */
    List<CommentVO> getComments(long sourceId,Page page);

    /**
     * 赞同讨论内容
     * @param CommentId
     * @return
     */
    boolean support(long CommentId);

    /**
     * 获取对该博客的直接评论数
     * @param sourceId
     * @param type
     * @return
     */
    int getTotalNum(long sourceId,int type);

}
