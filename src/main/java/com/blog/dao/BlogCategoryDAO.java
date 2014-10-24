package com.blog.dao;

import com.blog.domain.entity.BlogCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 */
public interface BlogCategoryDAO {

    @Insert("INSERT INTO ch_blog_category (uid,name,status) values (#{uid},#{name},#{status})")
    void addCategory(BlogCategory blogCategory);

    @Select("Select * from ch_blog_category WHERE uid=#{uid} and status=0")
    List<BlogCategory> getCategorys(long uid);

    @Update("UPDATE ch_blog_category SET status=-1 WHERE id=#{id}")
    void delCategory(long id);

	
	
	
}
