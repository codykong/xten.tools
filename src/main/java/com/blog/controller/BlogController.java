package com.blog.controller;

import com.blog.domain.common.AjaxVO;
import com.blog.domain.common.Page;
import com.blog.domain.vo.blog.BlogVO;
import com.blog.service.BlogService;
import com.blog.domain.vo.blog.BlogPreviewVO;
import com.blog.common.interceptor.LoginContext;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-9-4
 * Time: 下午4:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {


    @Autowired
    private BlogService blogService;


    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "list")
     public String queBlogPreview(@ModelAttribute("page") Page page,
                                  Model view) {
        try {
            Long uid = LoginContext.getLoginContext().getUserId();

            List<BlogPreviewVO> previewVOs = Collections.EMPTY_LIST;
            int totalCount=blogService.getTotalNum();
            if(0!=totalCount){
                previewVOs = blogService.quePreviews(uid,page);
            }

            List<BlogPreviewVO> shares=blogService.queShares();
            page.setTotalNum(totalCount);

            view.addAttribute("page", page);
            view.addAttribute("previews",previewVOs);
            view.addAttribute("shares",shares);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index/index";
    }

    @RequestMapping(value = "post")
    public String post() {
        return "blog/postBlog";
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public AjaxVO<String> save(BlogVO blogVO){

        AjaxVO ajaxVO=null;
        try {
            Long uid = LoginContext.getLoginContext().getUserId();
            blogVO.setUid(uid);
            boolean res=blogService.save(blogVO);
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

    @RequestMapping(value = "details/{blogId}")
    public String queBlogDetail(@PathVariable("blogId") Long blogId ,Model view) {
        try {

            BlogVO blogVO= blogService.queDetail(blogId);

            view.addAttribute("blog", blogVO);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "blog/viewBlog";
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
            boolean res=blogService.support(sourceId);
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

    /**
     * 赞一下
     * @param blogId
     * @return
     */
    @RequestMapping(value = "comment", method = RequestMethod.POST)
    @ResponseBody
    public AjaxVO<String> comment(Long blogId){

        AjaxVO ajaxVO=null;
        try {
            boolean res=blogService.support(blogId);
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


/*    @RequestMapping(value = "personalCategory")
    @ResponseBody
    public AjaxVO<String> getPersonalCategory(long uid){

        AjaxVO ajaxVO=null;
        try {
            List<BlogCategory> categories=blogCategoryService.getCategorys(uid);

            ajaxVO=AjaxVO.success(categories);

        } catch (Exception e) {
            e.printStackTrace();
            ajaxVO=AjaxVO.fail("");
        }finally {
            return ajaxVO;
        }
    }*/


}
