package com.xten.mybatis.interfaceType;

import org.apache.ibatis.jdbc.SqlBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-6-20
 * Time: 下午7:14
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceSqlProvider extends SqlBuilder {

    public String testSelect(Map<String, Object> parameters){
        Integer type=(Integer)parameters.get("type");
        BEGIN();
        SELECT("*");
        FROM("spring_mybatis_type");
        WHERE("type="+type);
        WHERE(getWhereSql(parameters));
        return SQL();
    }

    private String getWhereSql(Map<String, Object> parameters){
        List<Integer> ids=(List<Integer>)parameters.get("ids");
        StringBuilder sbIds=new StringBuilder();
        sbIds.append("id in (");
        for(Integer id:ids){
            sbIds.append(id);
            sbIds.append(",");
        }
        String sIds=sbIds.substring(0,sbIds.lastIndexOf(","));
        sIds=sIds+")";
        return sIds;
    }
}
