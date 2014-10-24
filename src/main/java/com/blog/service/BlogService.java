package com.blog.service;

import com.blog.domain.common.Page;

import com.blog.domain.vo.blog.BlogPreviewVO;
import com.blog.domain.vo.blog.BlogVO;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-9-4
 * Time: 下午4:36
 * To change this template use File | Settings | File Templates.
 */
public interface BlogService {

    /**
     * 根据用户id查询博客列表
     * @param uid
     * @param page  分页类
     * @return
     */
    public List<BlogPreviewVO> quePreviews(Long uid,Page page);

    /**
     * 查询分享列表
     * @return
     */
    public List<BlogPreviewVO> queShares();

    /**
     * 查询用户全部博客数量
     * @return
     */
    public int getTotalNum();

    /**
     * 保存博客
     * @param blogVO
     * @return
     */
    public boolean save(BlogVO blogVO);

    /**
     * 查询博客详情
     * @param blogId
     * @return
     */
    public BlogVO queDetail(Long blogId);

    /**
     * 博客支持数量+1
     * @param blogId
     * @return
     */
    public boolean support(Long blogId);





}
