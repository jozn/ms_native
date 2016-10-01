package com.mardomsara.social.base.Http2;

import android.util.Log;

import com.google.gson.Gson;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.tables.User;

import java.io.File;
import java.lang.reflect.Type;
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

    /*static Gson g = new Gson();
    public <T> T fromJson(String str , Class<T> cls){
        T j = null;
        try {
            j = g.fromJson(str,cls);
//            Class<?> cl = j.Load.getClass();
        }catch (Exception e){
            Log.e("JSON: ","error in JsonUtil.fromJson parsing: "+e.toString() );
            e.printStackTrace();
        }
        return j;
    }

    Class<T> cls2;*/
    /*public T fromJson2(Class<T> cls){
        T j = null;
        try {
            cls2 = cls;
//            Class<?> cl = j.Load.getClass();
        }catch (Exception e){
            Log.e("JSON: ","error in JsonUtil.fromJson parsing: "+e.toString() );
            e.printStackTrace();
        }
        return j;
    }*/
    public <K>  void doAsync(CallBack<K> callBack){
        AndroidUtil.runInBackground(()->{
            Result res = Sender.Send(this);

            Result<K> res2 = new Result<K>();//How we can be generic type(pass generic to Result) and avoid making another object
            res2.ok = res.ok;
            res2.data = res.data;
            res2.bytes = res.bytes;
            res2.response = res.response;

            if(callBack != null){
                callBack.callback(res);
            }
        });
    }

    public  <T>void doAsyncJson(Class<T> cls,CallBack<T> callBack){
        AndroidUtil.runInBackground(()->{
            Result res = Sender.Send(this);
            Result<T> res2 = new Result<T>();//How we can be generic type(pass generic to Result) and avoid making another object
            res2.ok = res.ok;
            res2.data = res.data;
            res2.bytes = res.bytes;
            res2.response = res.response;


            if(res2.data !=  null && res2.data.length() > 0){// && res.data.indexOf("Status")>0){
                T json = JsonUtil.fromJson(res2.data,cls);
                if(json != null ){
                    res2.ok =true;
                    res2.parsedJson = json;
                }else {
                    res2.ok = false;
                }
                if(callBack != null){
                    callBack.<T>callback(res2);
                }
            }


        });
    }

    void prcessCallback(Result res){
        /*if(res.data !=  null && res.data.length() > 0 && res.data.indexOf("Status")>0){
            Type collectionType = new TypeToken<User<T>>(){}.getType();
            res.parseJson(res,cls2)

        }*/
    }

    ////////////////////////////// internal Classes ////////////////////////
    static class Req2 {
        
    }
}
