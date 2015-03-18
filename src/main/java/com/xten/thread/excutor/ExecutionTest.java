package com.xten.thread.excutor;

import com.blog.common.utils.RandomGenerator;

import java.util.Random;

/**
 * Created by xten on 15/3/18.
 */
public class ExecutionTest {

    public static void main(String[] args) {

        WebService taskExecutionWebService=new TaskExecutorServiceWebService();

        for(int i=0;i<=10;i++){
            int j= new Random().nextInt(100);
            long start=System.currentTimeMillis();
            taskExecutionWebService.executeWebRequest(j,start);
            System.out.println("query is:"+j+",take:"+(System.currentTimeMillis()-start));
        }
    }
}
