package com.mardomsara.social.base;

/**
 * Created by Hamid on 1/4/2016.
 */
public class HttpResponseJsonProtocol<T> {
    public String Status;
//    UserListFollowJson[] UserListFollow;
//    Object[] UserListFollow;
    public T[] Payload;
    public int ServerTime;
    public int Version;
    public int ResTime;
}
