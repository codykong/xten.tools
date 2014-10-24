package com.blog.service;

import com.blog.domain.entity.Tag;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */
public interface TagService {

    boolean addTag(String tagNames,long blogId);

    Tag getPersonalTags(long uid);
}
