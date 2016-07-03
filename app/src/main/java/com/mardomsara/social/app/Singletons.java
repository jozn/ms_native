package com.mardomsara.social.app;

import com.google.gson.Gson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Hamid on 3/4/2016.
 */
public class Singletons {

    private static Gson _gson;
    private static ExecutorService _threadPool;
    private static ExecutorService _threadSingle;

    public static Gson getGson(){
        if (_gson == null){
            _gson = new Gson();
        }
        return _gson;
    }

    public static ExecutorService getThreadPool(){
        if(_threadPool == null){
            _threadPool = Executors.newCachedThreadPool();
        }
        return _threadPool;
    }

    public static ExecutorService getSingleThread(){
        if(_threadSingle == null){
            _threadSingle = Executors.newSingleThreadExecutor();
        }
        return _threadSingle;
    }
}
