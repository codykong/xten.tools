package com.xten.thread.visibility;

/**
 * Created by xten on 15/3/14.
 */
public class NoVisibility {

    private static boolean ready;
    private static  int number;

    public static void main(String args[]) throws InterruptedException {
        new ReaderThread().start();
        number=42;
        ready=true;
        Thread.sleep(1000l);
        System.out.print(number+1);
    }


    private static class ReaderThread extends Thread{

        public void run(){
            System.out.println(ready);
            while (!ready){
                Thread.yield();
            }
            System.out.print(number);
        }
    }
}
