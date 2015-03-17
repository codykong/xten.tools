package com.xten.thread.cache;

import java.util.concurrent.ExecutionException;

/**
 * Created by xten on 15/3/16.
 */
public interface Computable {

    String computer(int i) throws ExecutionException, InterruptedException;
}
