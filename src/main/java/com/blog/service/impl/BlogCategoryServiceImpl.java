package com.blog.service.impl;

import com.blog.dao.BlogCategoryDAO;
import com.blog.domain.entity.BlogCategory;
import com.blog.service.BlogCategoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午2:20
 * To change this template use File | Settings | File Templates.
 */
public class BlogCategoryServiceImpl implements BlogCategoryService {

    private static final Log logger = LogFactory.getLog(BlogCategoryServiceImpl.class);

    @Autowired
    BlogCategoryDAO blogCategoryDAO;

    private static int CHANNEL_ID=1;

    @Override
    public List<BlogCategory> getChannels() {
        List<BlogCategory> categories= Collections.EMPTY_LIST;
        try {
            categories=blogCategoryDAO.getCategorys(CHANNEL_ID);

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return categories;
    }

    @Override
    public List<BlogCategory> getCategorys(long uid) {

        List<BlogCategory> categories= Collections.EMPTY_LIST;
        try {
            categories=blogCategoryDAO.getCategorys(uid);

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return categories;
    }


}
