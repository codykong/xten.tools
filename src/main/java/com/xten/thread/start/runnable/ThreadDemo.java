package com.xten.thread.start.runnable;

/**
 * Created by kongqingyu on 15-3-15.
 */
public class ThreadDemo {

    public static void main(String[] args) {

        for(int i=5;i>0;i--){
            System.out.println("Main Thread:"+i);
            new NewThread(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main Thread exist;");
    }
}
