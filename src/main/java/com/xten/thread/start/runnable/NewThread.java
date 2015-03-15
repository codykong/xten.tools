package com.xten.thread.start.runnable;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by kongqingyu on 15-3-15.
 */
public class NewThread implements Runnable {

    Thread t;
    NewThread(int i){
        t=new Thread(this,"Demo Thread");
        System.out.println("Child Threads:"+i+t);
        t.start();
    }

    @Override
    public void run() {
        for(int i=5;i>0;i--){
            System.out.println("Child Thread:"+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exist Child Thread.");
    }
}


