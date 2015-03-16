package com.xten.thread.cache;

import org.bson.util.annotations.GuardedBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xten on 15/3/16.
 */
public class CacheClient implements Computable {

    @GuardedBy("this")
    private final Map<Integer,String> cache=new HashMap<Integer, String>();
    private final Computable computable;

    public CacheClient(Computable c){
        this.computable=c;
    }

    @Override
    public synchronized String computer(int i) {

        String result=cache.get(i);
        if(result==null){
            result=computable.computer(i);
            cache.put(i,result);
        }

        return result;

    }
}
