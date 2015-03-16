package com.xten.thread.syntools.test;

import com.xten.thread.common.CountTask;
import com.xten.thread.syntools.TestHarness;

/**
 * Created by kongqingyu on 15-3-15.
 */
public class TestLatch {
    public static void main(String[] args) {
        TestHarness harness=new TestHarness();
        try {
            System.out.println(harness.timeTasks(3,new CountTask()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
