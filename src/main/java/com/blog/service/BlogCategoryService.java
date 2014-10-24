package com.blog.service;

import com.blog.domain.entity.BlogCategory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午2:18
 * To change this template use File | Settings | File Templates.
 */
public interface BlogCategoryService {

    List<BlogCategory> getChannels();

    List<BlogCategory> getCategorys(long uid);
}
