package com.xten.thread.cache;


import java.util.concurrent.*;

/**
 * Created by xten on 15/3/17.
 */
public class CacheClient2 implements Computable {


    private Cache cache;
    private final Computable computable;

    public CacheClient2(Computable c,Cache cache){
        this.computable=c;
        this.cache=cache;
    }

    @Override
    public  String computer(final int i) throws ExecutionException, InterruptedException {

        Future<String> f=cache.get(i);
        Thread.sleep(500);
        if(f==null){
            Callable<String> callable=new Callable<String>() {
                public String call() throws Exception {
                    return computable.computer(i);
                }
            };
            FutureTask<String> task=new FutureTask<String>(callable);
            f=task;
            cache.put(i,f);
            task.run();


        }


        return f.get();


    }
}
