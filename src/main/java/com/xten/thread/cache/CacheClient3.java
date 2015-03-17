package com.xten.thread.cache;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by xten on 15/3/17.
 */
public class CacheClient3 implements Computable {


    private Cache cache;
    private final Computable computable;

    public CacheClient3(Computable c, Cache cache){
        this.computable=c;
        this.cache=cache;
    }

    @Override
    public  String computer(final int i) throws ExecutionException, InterruptedException {

        while (true) {
            Future<String> f=cache.get(i);
            Thread.sleep(500);
            if(f==null){
                Callable<String> callable=new Callable<String>() {
                    public String call() throws Exception {
                        return computable.computer(i);
                    }
                };
                FutureTask<String> task=new FutureTask<String>(callable);
                f=cache.put(i,task);
                if(f==null){
                    f=task;
                    task.run();

                }


            }


            return f.get();
        }


    }
}
