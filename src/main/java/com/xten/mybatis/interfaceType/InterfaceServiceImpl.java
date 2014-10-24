package com.xten.mybatis.interfaceType;

import com.xten.mybatis.entity.SpringMybatisType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-6-19
 * Time: 下午5:51
 * To change this template use File | Settings | File Templates.
 */

public class InterfaceServiceImpl implements InterfaceService {

    @Autowired
    private InterfaceDAO interfaceDAO;

    @Override
    public void testSelect() {
        Integer type=1;
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        ids.add(6);

        List<SpringMybatisType> springMybatisTypes=interfaceDAO.testSelect(type,ids);
        System.out.println(springMybatisTypes);
    }
}
