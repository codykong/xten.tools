package com.xten.thread.start.thread;


/**
 * Created by kongqingyu on 15-3-15.
 */
public class ExtendThread {

    public static void main(String[] args) {

        for(int i=5;i>0;i--){
            System.out.println("Main Thread:"+i);
            new NewThread(i,i+"_thread");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main Thread exist;");
    }
}
