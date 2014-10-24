package com.blog.service.impl;

import com.blog.dao.TagDAO;
import com.blog.domain.entity.Tag;
import com.blog.service.TagService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
@Service("tagService")
public class TagServiceImpl implements TagService{

    private static Log LOG= LogFactory.getLog(TagServiceImpl.class);

    @Autowired
    private TagDAO tagDAO;

    @Override
    public boolean addTag(String tagNames,long blogId) {

        boolean res=false;
        try {
            tagNames=tagNames.replace("，",",");
        /*1. 将以逗号分割的标签转为list，以便于查询和操作*/
            List<String> names=new ArrayList<String>();
            Collections.addAll(names,tagNames.split(","));

        /*2.查询出已经存在的tag名称*/
            List<Tag> tags=tagDAO.getTagsByNames(names);

        /*3. 标签id集合，用于存储博客标签关系*/
            List<Long> tagIds=new ArrayList<Long>();
        /*3.1 将已经存在的标签id加入到tagIds中，并将其从标签名集合中移除，不存在的标签则直接插入*/
            for(Tag tag:tags){
                if(names.contains(tag.getName())){
                    names.remove(tag.getName());
                    tagIds.add(tag.getId());
                }
            }
        /*3.2 不存在的标签则直接插入，并获取id*/
            for(String name:names){
                Tag tag=new Tag();
                tag.setName(name);
                tagDAO.addTag(tag);
                tagIds.add(tag.getId());
            }

        /*4. 存储博客标签关系*/
            tagDAO.addBlogTagR(tagIds,blogId);
            res=true;
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
        }finally {
            return res;
        }


    }

    @Override
    public Tag getPersonalTags(long uid) {

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
