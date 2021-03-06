package com.mardomsara.social.base.Http;

import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.HttpJsonList;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.lang.reflect.Type;

import okhttp3.Response;

public class Result<T>{
    protected boolean ok = false;
    public String data = "";
    public T parsedJson = null;
    @Nullable public Response response;
    public byte[] bytes;

    public boolean isOk(){
        return ok;
    }

    /////////////////// Statics //////////////////////

    static Moshi moshi = new Moshi.Builder().build();
    public static <T> HttpJson<T> fromJson(Result result , Class<T> cls){
        HttpJson<T> j = null;
        //////// Moshi ////////////
        Type listOfCardsType = Types.newParameterizedType(HttpJson.class, cls);

		Long t1 = TimeUtil.getTimeMs();
        JsonAdapter<HttpJson<T>> jsonAdapter = moshi.adapter(listOfCardsType);

        try {
            j = jsonAdapter.fromJson(result.data);
        }catch (Exception e){
            Log.e("JSON: ","error in Result.fromJson parsing: "+e.toString() );
            e.printStackTrace();
        }

		AppUtil.log("Json time ms : " + (TimeUtil.getTimeMs() -t1) );

        if(j == null){
            result.ok = false;
            result.parsedJson = j;
        }else {
            result.ok = true;
        }

        return j;
    }

    public static <T> HttpJsonList<T> fromJsonList(Result result, Class<T> cls ){
        HttpJsonList<T> j = null;
        //////// Moshi ////////////
        Type listOfObjects = Types.newParameterizedType(HttpJsonList.class, cls);

		Long t1 = TimeUtil.getTimeMs();

        JsonAdapter<HttpJsonList<T>> jsonAdapter = moshi.adapter(listOfObjects);
        try {
            j = jsonAdapter.fromJson(result.data);
        }catch (Exception e){
            Log.e("JSON: ","error in Result.fromJsonList parsing: "+e.toString() );
            e.printStackTrace();
        }
		AppUtil.log("Json time ms : " + (TimeUtil.getTimeMs() -t1));
		//// TODO: 1/12/2017 check for list.size == 0 set ok to false
		if(j == null){
            result.ok = false;
            result.parsedJson = null;
        }else {
            result.ok = true;
        }

        return j;
    }

    ////////////// Old/////////////////////
    static Gson g = new Gson();
    //copy of JsonUtil.fromJson(...)
    @Deprecated
    public static <T> T fromJson_bk_gson(Result result , Class<T> cls){
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