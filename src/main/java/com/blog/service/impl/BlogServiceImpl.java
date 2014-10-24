package com.blog.service.impl;

import com.blog.common.data.BlogEnum;
import com.blog.common.utils.DateUtil;
import com.blog.common.utils.ParamUtil;
import com.blog.dao.BlogDAO;
import com.blog.domain.common.Page;
import com.blog.domain.vo.blog.BlogVO;
import com.blog.service.BlogService;
import com.blog.domain.entity.Blog;
import com.blog.domain.vo.blog.BlogPreviewVO;
import com.blog.service.TagService;
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
 * Date: 13-9-4
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    private static final Log LOG = LogFactory.getLog(BlogServiceImpl.class);

    @Autowired
    private BlogDAO blogDAO;

    @Autowired
    private TagService tagService;

    @Override
    public List<BlogPreviewVO> quePreviews(Long uid,Page page) {

        List<BlogPreviewVO> previewVOs= new ArrayList<BlogPreviewVO>();
        try {
            List<Blog> blogs = blogDAO.getByUid(uid,page.getOffset(),page.getPageSize(),0);
            for (Blog blog : blogs) {
                BlogPreviewVO previewVO = new BlogPreviewVO();
                previewVO.setbId(blog.getId());
                previewVO.setTitle(blog.getTitle());
                previewVO.setContent(ParamUtil.subString(blog.getContent_txt(),0,100)+"......");
                previewVO.setPublishTime(DateUtil.toStringYYYYMMDD_HH_mm_ss(blog.getCreate_time()));
                previewVO.setType(BlogEnum.Type.fromValue(blog.getType()).getName());
                previewVO.setCommentCount(blog.getComment_count());
                previewVO.setSupportCount(blog.getSupport_count());
                previewVO.setViewCount(blog.getView_count());
                previewVOs.add(previewVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return previewVOs;
    }

    @Override
    public List<BlogPreviewVO> queShares() {
        List<BlogPreviewVO> previewVOs= new ArrayList<BlogPreviewVO>();
        try {
            List<Blog> blogs = blogDAO.queShares(10, 0);
            for (Blog blog : blogs) {
                BlogPreviewVO previewVO = new BlogPreviewVO();
                previewVO.setbId(blog.getId());
                previewVO.setTitle(ParamUtil.subString(blog.getTitle(), 0, 10));
                previewVOs.add(previewVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return previewVOs;
    }

    @Override
    public int getTotalNum() {
        int totalCount=0;
        try{
            totalCount=blogDAO.getTotalCount(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return totalCount;
    }

    @Override
    public boolean save(BlogVO blogVO) {

        try {
            Blog blog=new Blog();
            blog.setUid(blogVO.getUid());
            blog.setTitle(blogVO.getTitle());
            blog.setContent(blogVO.getContent());
            blog.setContent_txt(blogVO.getContentTxt());
            blog.setCreate_time(new Date());
            blog.setUpdate_time(new Date());
            blog.setStatus(blogVO.getStatus());
            blog.setType(Integer.valueOf(blogVO.getType()));

            blogDAO.save(blog);
            boolean tagRes=tagService.addTag(blogVO.getTags(),blogVO.getbId());
            if(!tagRes){
                LOG.error("添加标签失败，tag="+blogVO.getTags()+",blogId="+blogVO.getbId());
            }
            return true;
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            return false;
        }

    }

    @Override
    public BlogVO queDetail(Long blogId) {

        try {
            addView(blogId);

            Blog blog=blogDAO.getDetailById(blogId);
            BlogVO blogVO=new BlogVO();
            blogVO.setTitle(blog.getTitle());
            blogVO.setContent(blog.getContent());
            blogVO.setCommentCount(blog.getComment_count());
            blogVO.setSupportCount(blog.getSupport_count());
            blogVO.setViewCount(blog.getView_count());
            blogVO.setPublishTime(DateUtil.toStringYYYYMMDD_HH_mm_ss(blog.getCreate_time()));
            blogVO.setType(BlogEnum.Type.fromValue(blog.getType()).getName());
            blogVO.setbId(blog.getId());
            return blogVO;
        } catch (Exception e) {
            e.printStackTrace();
            return new BlogVO();
        }
    }

    @Override
    public boolean support(Long blogId) {

        try {
            blogDAO.addSupportCount(blogId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 增加博客浏览次数
     * @param blogId
     * @return
     */
    private boolean addView(Long blogId){

        try {
            blogDAO.addViewCount(blogId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
