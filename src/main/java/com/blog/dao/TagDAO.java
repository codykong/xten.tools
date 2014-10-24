package com.blog.dao;

import com.blog.dao.provider.TagSqlProvider;
import com.blog.domain.entity.Tag;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午5:16
 * To change this template use File | Settings | File Templates.
 */
public interface TagDAO {

    @SelectKey(before=false,keyProperty="id",resultType=Long.class,statementType= StatementType.STATEMENT,
            statement="SELECT LAST_INSERT_ID() AS id")
    @Insert("INSERT INTO ch_tag (name,status,type,create_time,update_time) VALUES(#{name},0,1,NOW(),NOW())")
    void addTag(Tag tag);

/*    @Insert("INSERT INTO ch_blog_tag (blog_id,tag_id,status,create_time,update_time) VALUES(#{blog_id},#{tag_id},#{status}," +
            "#{type},NOW(),NOW())")
    void addBlogTagR(BlogTagR blogTagR);*/

    @SelectProvider(type=TagSqlProvider.class,method="getTagsByNames")
    List<Tag> getTagsByNames(@Param("names") List<String> names);

    @InsertProvider(type=TagSqlProvider.class,method="addBlogTagR")
    void addBlogTagR(@Param("tagIds") List<Long> tagIds,@Param("blogId") Long blogId );

    List<Tag> getPersonalTags(long uid);
}
