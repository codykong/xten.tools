package com.xten.thread.cache;

import java.util.Random;

/**
 * Created by xten on 15/3/17.
 */
public class CacheTest {

    public static void main(String[] args){

        CacheClient client=new CacheClient(new ExpensiveFunction());

        for(int i=0;i <100;i ++){
            int number = new Random().nextInt(10);
            long start=System.currentTimeMillis();
            String res=client.computer(number);
            System.out.println("arg:"+number+"，res:" + res+"，cost:" + (System.currentTimeMillis() - start));

        }
    }
}
