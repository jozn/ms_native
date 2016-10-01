package com.mardomsara.social.base.Http2;

import android.util.Log;

import com.google.gson.Gson;

import okhttp3.Response;

public class Result<T>{
    protected boolean ok = false;
    public String data = "";
    public T parsedJson = null;
    public Response response;
    public byte[] bytes;

    public boolean isOk(){
        return ok;
    }

    /////////////////// Statics //////////////////////
    static Gson g = new Gson();
    //copy of JsonUtil.fromJson(...)
    public static <T> T fromJson(Result result , Class<T> cls){
        T j = null;
        try {
            j = g.fromJson(result.data,cls);
        }catch (Exception e){
            Log.e("JSON: ","error in Result.fromJson parsing: "+e.toString() );
            e.printStackTrace();
        }

        if(j == null){
            result.ok = false;
            result.parsedJson = j;
        }else {
            result.ok = true;
        }

        return j;
    }
}