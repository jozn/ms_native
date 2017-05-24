package com.mardomsara.social.pipe_pb;

/**
 * Created by Hamid on 3/31/2016.
 */
public  interface  PipeNetEventHandler<T> {
    void handle(T data);
}
