package com.xten.thread.cache;

import org.bson.util.annotations.GuardedBy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/**
 * Created by xten on 15/3/17.
 */
public class Cache {

    @GuardedBy("this")
    private  ConcurrentHashMap<Integer,Future<String>> cache;

    public Cache(){
        if(null==cache){
            cache=new ConcurrentHashMap<Integer, Future<String>>();
        }
    }

    public Future<String> get(int i){
        return cache.get(i);

    }

    public Future<String> put(Integer i,Future<String> f){
        return cache.putIfAbsent(i, f);
    }
}
