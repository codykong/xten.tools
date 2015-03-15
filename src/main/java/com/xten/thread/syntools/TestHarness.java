package com.xten.thread.syntools;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kongqingyu on 15-3-15.
 */
public class TestHarness {
    public long timeTasks(int nThreads,final Runnable task) throws InterruptedException {
        final CountDownLatch startGate=new CountDownLatch(1);
        final CountDownLatch endGate=new CountDownLatch(nThreads);
        for(int i=0;i<nThreads;i++){
            Thread t=new Thread(){
                public void run(){
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long start=System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end=System.nanoTime();
        return end-start;

    }




}
