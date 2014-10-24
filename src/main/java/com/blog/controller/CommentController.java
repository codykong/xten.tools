package com.blog.controller;

import com.blog.common.interceptor.LoginContext;
import com.blog.domain.common.AjaxVO;
import com.blog.domain.common.Page;
import com.blog.domain.vo.comment.CommentVO;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-9-4
 * Time: 下午4:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "save")
    @ResponseBody
    public AjaxVO<String> save(CommentVO commentVO){

        AjaxVO ajaxVO=null;
        try {
            Long uid = LoginContext.getLoginContext().getUserId();
            commentVO.setUid(uid);
            commentVO.setUserName("TEST");
            boolean res=commentService.saveComment(commentVO);
            if(res){
                ajaxVO=AjaxVO.success("/comment/list");

            }else{
                ajaxVO=AjaxVO.fail("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxVO=AjaxVO.fail("");
        }finally {
            return ajaxVO;
        }
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public AjaxVO<List<CommentVO>> get(Long blogId,int index,int size){

        AjaxVO ajaxVO=null;
        Page page=new Page();
        page.setPageIndex(index);
        page.setPageSize(size);
        try {
            List<CommentVO> list=commentService.getComments(blogId,page);

            ajaxVO=AjaxVO.success(list);


        } catch (Exception e) {
            e.printStackTrace();
            ajaxVO=AjaxVO.fail("");
        }finally {
            return ajaxVO;
        }
    }

    /**
     * 赞一下
     * @param sourceId
     * @return
     */
    @RequestMapping(value = "support", method = RequestMethod.POST)
    @ResponseBody
    public AjaxVO<String> support(Long sourceId){

        AjaxVO ajaxVO=null;
        try {
            boolean res=commentService.support(sourceId);
            if(res){
                ajaxVO=AjaxVO.success("/blog/list");

            }else{
                ajaxVO=AjaxVO.fail("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxVO=AjaxVO.fail("");
        }finally {
            return ajaxVO;
        }
    }




}
