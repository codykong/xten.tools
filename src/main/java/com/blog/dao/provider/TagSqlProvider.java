package com.blog.dao.provider;

import org.apache.ibatis.jdbc.SqlBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-1-9
 * Time: 下午5:40
 * To change this template use File | Settings | File Templates.
 */
public class TagSqlProvider extends SqlBuilder {

    public String getTagsByNames(Map<String,Object> parameters){

        BEGIN();
        SELECT("id,name");
        FROM("ch_tag");
        WHERE(getTagsByNamesWhere(parameters));

        return  SQL();
    }

    public String addBlogTagR(Map<String,Object> parameters){
        List<Long> tagIds=(List<Long>)parameters.get("tagIds");
        Long blogId=(Long) parameters.get("blogId");

        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO `ch_blog_tag_r` (blog_id,tag_id,status,create_time,update_time) VALUES ");
        for(Long tagId:tagIds){
            sb.append("(#{blogId},"+tagId+",0,NOW(),NOW()),");
        }

        return sb.substring(0,(sb.lastIndexOf(",")));

    }

    private String  getTagsByNamesWhere(Map<String,Object> parameters){
        List<String> names=(List<String>)parameters.get("names");
        StringBuilder sb=new StringBuilder("name in ( ");
        for(String name:names){
            sb.append("'");
            sb.append(name);
            sb.append("',");
        }

        return sb.substring(0,(sb.lastIndexOf(",")))+" )";
    }
}
