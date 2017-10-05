package com.mardomsara.social.del.pipe_pb;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Created by Hamid on 3/31/2016.
 */
public  interface PipeNetEventHandler<T> {
    void handle(byte[] data) throws InvalidProtocolBufferException;
}
