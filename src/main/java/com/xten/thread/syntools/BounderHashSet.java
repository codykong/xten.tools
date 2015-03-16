package com.xten.thread.syntools;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by xten on 15/3/16.
 */
public class BounderHashSet<t> {
    private final Set<Object> set;
    private final Semaphore sem;

    public BounderHashSet(int bound){
        this.set= Collections.synchronizedSet(new HashSet<Object>());
        sem=new Semaphore(bound);
    }

    public boolean add(Object o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded=false;
        try {
            wasAdded=set.add(o);
            return wasAdded;
        } finally {
            if(!wasAdded){
                sem.release();
            }
        }


    }

    public boolean remove(Object o){
        boolean wasRemove=set.remove(o);
        if(wasRemove){
            sem.release();
        }
        return wasRemove;
    }
}
