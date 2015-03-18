package com.xten.thread.excutor;

import com.xten.thread.common.CountTask;

import java.lang.reflect.WildcardType;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by xten on 15/3/18.
 */
public class TaskExecutionWebService implements WebService {

    private static final int THREAD_NUM=5;
    private static final Executor exec= Executors.newFixedThreadPool(THREAD_NUM);


    @Override
    public void executeWebRequest(final int i,final long startTime){

        Runnable executeTask=new Runnable() {
            @Override
            public void run() {
                CountTask task=new CountTask();
                try {
                    task.longTimeRun(i,startTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ;

        exec.execute(executeTask);


    }
}
