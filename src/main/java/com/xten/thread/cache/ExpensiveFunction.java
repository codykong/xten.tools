package com.xten.thread.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xten on 15/3/16.
 */
public class ExpensiveFunction implements Computable {

    List<String> results=new ArrayList();

    public ExpensiveFunction(){
        for(int i=0;i<10;i++){
            results.add(String.valueOf(i));
        }
    }


    @Override
    public String computer(int i) {
        try {
            Thread.sleep(2000);
            System.out.println("isComputer:"+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return results.get(i);
    }
}
