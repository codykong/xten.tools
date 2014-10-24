package com.blog.service.impl;

import com.blog.common.utils.DateUtil;
import com.blog.dao.BlogDAO;
import com.blog.dao.CommentDAO;
import com.blog.domain.common.Page;
import com.blog.domain.entity.Comment;
import com.blog.domain.vo.comment.CommentVO;
import com.blog.service.CommentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-23
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    private static final Log logger = LogFactory.getLog(CommentServiceImpl.class);
    /**
     * 面向博客评论
     */
    private static int COMMENT_TO_BLOG=1;

    private static int COMMENT_TO_COMMENT=2;
    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private BlogDAO blogDAO;

    @Override
    public boolean saveComment(CommentVO commentVO) {

        try {
            commentDAO.save(transVOToComment(commentVO));

            addCommentCount(commentVO.getType(),commentVO.getSourceId(),commentVO.getBlogId());
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public List<CommentVO> getComments(long sourceId, Page page) {

        List<CommentVO> commentVOs=new ArrayList<CommentVO>();
        try {
            List<Comment> comments = commentDAO.getComments(sourceId, page.getOffset(), page.getPageSize());

            List<Long> ids=new ArrayList<Long>();
            for(Comment comment:comments){
                ids.add(comment.getId());
            }
            List<Comment> childComments=commentDAO.getCommentsByIds(ids);

            for(Comment comment:comments){
                commentVOs.add(transCommentToVO(comment));
                System.out.println(comment.toString());
                commentVOs.addAll(getChildComments(comment.getId(),childComments));
            }

        } catch (Exception e) {
             logger.error(e.getMessage(), e);
        }
        return commentVOs;
    }

    @Override
    public boolean support(long commentId) {

        boolean res;
        try {
            commentDAO.addSupportCount(commentId);
            res=true;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            res=false;
        }
        return res;
    }

    @Override
    public int getTotalNum(long sourceId, int type) {

        int totalNum=0;

        try {
            totalNum=commentDAO.getTotalNum(sourceId,type);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return totalNum;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private List<CommentVO> getChildComments(long pId,List<Comment> childComments){
        List<CommentVO> commentVOs=new ArrayList<CommentVO>();
        for(Comment comment:childComments){
            if(comment.getSource_id()==pId){
                commentVOs.add(transCommentToVO(comment));
                System.out.println(comment.toString());
                commentVOs.addAll(getChildComments(comment.getId(), childComments));
            }
        }

        return commentVOs;
    }

    /**
     * 增加评论数量
     * @param type
     * @param commentId
     * @return
     */
    private boolean addCommentCount(int type,long commentId,long blogId){
        try {

            blogDAO.addCommentCount(blogId);

            if(type==COMMENT_TO_COMMENT){
                commentDAO.addCommentCount(commentId);
            }

            return true;
        } catch (Exception e) {
            logger.error("增加评论数量失败："+e.getMessage(),e);
            return false;
        }
    }

    private CommentVO transCommentToVO(Comment comment){
        CommentVO commentVO=new CommentVO();
        commentVO.setUid(comment.getUid());
        commentVO.setUserName(comment.getUser_name());
        commentVO.setContent(comment.getContent());
        commentVO.setCreateTime(DateUtil.toStringYYYYMMDD_HH_mm_ss(comment.getCreate_time()));
        commentVO.setId(comment.getId());
        commentVO.setAncestorId(comment.getAncestor_id());
        commentVO.setLevel(comment.getLevel());
        commentVO.setType(comment.getType());
        commentVO.setSourceId(comment.getSource_id());
        commentVO.setSupportCount(comment.getSupport_count());
        commentVO.setCommentCount(comment.getComment_count());
        return commentVO;
    }

    private Comment transVOToComment(CommentVO commentVO){
        Comment comment=new Comment();
        comment.setSource_id(commentVO.getSourceId());
        comment.setAncestor_id(commentVO.getAncestorId());
        comment.setUid(commentVO.getUid());
        comment.setUser_name(commentVO.getUserName());
        comment.setContent(commentVO.getContent());
        comment.setType(commentVO.getType());
        comment.setCreate_time(new Date());
        comment.setUpdate_time(new Date());
        comment.setLevel(commentVO.getLevel());
        comment.setStatus(0);
        return  comment;
    }


}
