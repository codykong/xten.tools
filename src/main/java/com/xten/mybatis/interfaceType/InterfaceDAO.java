package com.xten.mybatis.interfaceType;

import com.xten.mybatis.entity.SpringMybatisType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-6-19
 * Time: 下午5:45
 * To change this template use File | Settings | File Templates.
 */
public interface InterfaceDAO {

    @SelectProvider(type=InterfaceSqlProvider.class, method="testSelect")
    public List<SpringMybatisType> testSelect(@Param("type") Integer type, @Param("ids") List<Integer> ids);

    @SelectKey(before=false,keyProperty="id",resultType=Long.class,statementType= StatementType.STATEMENT,
            statement="SELECT LAST_INSERT_ID() AS id")
    @Insert("INSERT INTO spring_mybatis_type (id,name,type) VALUES (#{id},#{name},#{type})")
    public void testInsert(SpringMybatisType springMybatisType);

}
