package com.xten.mybatis.interfaceType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 14-6-19
 * Time: 下午5:48
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceDAOTest {

    public static void main(String[] args){
        final Log logger = LogFactory.getLog(InterfaceDAOTest.class);

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring/mybatis/mybatis-interface.xml");
            InterfaceService interfaceService =context.getBean(InterfaceService.class);
            interfaceService.testSelect();
        } catch (BeansException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
