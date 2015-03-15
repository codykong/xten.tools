package com.xten.mock;


import com.xten.mock.service.InterfaceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Date: 15-1-7
 * Time: 下午5:50
 */
public class MockTest {

    public static void main(String[] args){

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring/mock/mock.xml");
            InterfaceService interfaceService =context.getBean(InterfaceService.class);
            System.out.println(interfaceService.mockInterface());
        } catch (BeansException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
