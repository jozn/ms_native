package com.mardomsara.social.base.Http2;

import com.mardomsara.social.app.API;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 9/30/2016.
 */
public class Http2 {
    public static Req get(String absUrl){
        Req req = new Req(Action.GET, absUrl);
        return req;
    }

    //like: getPath("like")
    public static Req getPath(String path){
        Req req = new Req(Action.GET, API.BASE_URL_STR+path);
        return req;
    }

    public static Req post(String absUrl){
        Req req = new Req(Action.POST, absUrl);
        return req;
    }

    public static Req postPath(String path){
        Req req = new Req(Action.POST, API.BASE_URL_STR+path);
        return req;
    }

    public static Req upload(String absUrl){
        Req req = new Req(Action.UPLOAD, absUrl);
        return req;
    }

    public static Req uploadPath(String path){
        Req req = new Req(Action.UPLOAD, API.BASE_URL_STR+path);
        return req;
    }

    //////////////////////////////// Privets /////////////////////////////////
    static Map<String, String> defaultHeaders(){
        Map<String, String> h = new HashMap();
        h.put("X-ms-client","1");
        return  h;
    }

    static Map<String, String> _getDefualturlParams(){
        Map<String, String> h = new HashMap();
        h.put("session","14dsad");
        h.put("user_id","6");
        return  h;
    }

    public enum  Action {
        GET,
        POST,
        UPLOAD,
    }


}
