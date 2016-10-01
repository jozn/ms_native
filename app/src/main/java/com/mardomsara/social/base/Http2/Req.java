package com.mardomsara.social.base.Http2;

import com.mardomsara.social.helpers.AndroidUtil;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Req<T> {
    Http2.Action action = Http2.Action.GET;
    String absUrl;
    URL _finalUrl;//todo: make this private
    String method = "GET";
    Map<String, String> headers = Http2.defaultHeaders();
    Map<String, String> urlQueryParams = new HashMap<>();
    Map<String, String> form = new HashMap<>();
    private Map<String, String[]> headersMulti;//??
    //        public File[] files;
    File file;

    public Req(Http2.Action action, String absUrl) {
        this.action = action;
        this.absUrl =absUrl;
    }

    //for respnse
    Class jsonClass;

    public Req setQueryParam(String key, String value){
        urlQueryParams.put(key,value);
        return this;
    }
    public Req setQueryParam(String key, Object valueNum){
        urlQueryParams.put(key, valueNum.toString());
        return this;
    }

    public Req setFormParam(String key, String value){
        form.put(key,value);
        return this;
    }

    public Req setHeader(String key, String value){
        headers.put(key,value);
        return this;
    }

    public Req JsonInto(Class cls){
        jsonClass = cls;
        return this;
    }

    //generics dosn't work, just set for futuer maybe
    public <K>  void doAsync(CallBack<K> callBack){
        AndroidUtil.runInBackground(()->{
            Result res = Sender.Send(this);

            if(callBack != null){
                callBack.callback(res);
            }
        });
    }

}
