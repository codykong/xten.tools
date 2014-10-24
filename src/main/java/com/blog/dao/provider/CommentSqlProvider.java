package com.blog.dao.provider;

import org.apache.ibatis.jdbc.SqlBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-24
 * Time: 上午11:00
 * To change this template use File | Settings | File Templates.
 */
public class CommentSqlProvider extends SqlBuilder {

    public String getCommentsByIds(Map<String, Object> parameters){


        BEGIN();
        SELECT("*");
        FROM("ch_comment");
        WHERE("status=0");
        WHERE(getWhereSql(parameters));
        return SQL();
    }

    private String getWhereSql(Map<String, Object> parameters){
        List<Long> ids=(List<Long>)parameters.get("ids");
        StringBuilder sbIds=new StringBuilder();
        sbIds.append("ancestor_id in (");
        for(Long id:ids){
            sbIds.append(id);
            sbIds.append(",");
        }

        String sIds=sbIds.substring(0,sbIds.lastIndexOf(","));
        sIds=sIds+")";

        return sIds;
    }


}
