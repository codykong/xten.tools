package com.xten.thread.cache;

import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Created by xten on 15/3/17.
 */
public class CacheTest {

    public static void main(String[] args){

        /**
         * cacheClient
         */
//        CacheClient client=new CacheClient(new ExpensiveFunction());
//
//        for(int i=0;i <100;i ++){
//            int number = new Random().nextInt(10);
//            long start=System.currentTimeMillis();
//            String res=client.computer(number);
//            System.out.println("arg:"+number+"，res:" + res+"，cost:" + (System.currentTimeMillis() - start));
//
//        }
          final Cache cache=new Cache();

        for(int i=0;i<10;i++){
            Thread thread=new Thread(){

                public void run(){
                    int sleepTime=new Random().nextInt(100);
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Computable client=new CacheClient3(new ExpensiveFunction(),cache);
                    int number = new Random().nextInt(10);
                    long start=System.currentTimeMillis();
                    String res= null;
                    try {
                        res = client.computer(number);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("arg:"+number+"，res:" + res+"，cost:" + (System.currentTimeMillis() - start)+",sleepTime"+sleepTime);

                }

            };

            thread.start();

        }


    }
}
