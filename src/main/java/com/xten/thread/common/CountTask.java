package com.xten.thread.common;

/**
 * Created by kongqingyu on 15-3-15.
 */
public class CountTask implements Runnable {
    @Override
    public void run() {

        for(int i=5;i>0;i--){
            System.out.println(i);
            try {
                Thread.sleep(11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
