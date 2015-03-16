package com.xten.thread.syntools.test;


import com.google.gson.Gson;
import com.xten.thread.syntools.BounderHashSet;

/**
 * Created by xten on 15/3/16.
 */
public class TestSemaphore {

    public static void main(String[] args) {

        final BounderHashSet<String> bounderHashSet=new BounderHashSet<String>(5);


        Thread addThread=new Thread(){

            public void run(){
                for(int i=0;i<=20;i++){
                    try {
                        bounderHashSet.add(i);
                        System.out.println("addThread:" + new Gson().toJson(bounderHashSet));
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        addThread.start();


        Thread removeThread=new Thread(){

            public void run(){
                for(int i=0;i<=20;i++){
                    try {
                        bounderHashSet.remove(i);
                        System.out.println("removeThread:"+new Gson().toJson(bounderHashSet));
                        Thread.sleep(70);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        removeThread.start();

    }
}
