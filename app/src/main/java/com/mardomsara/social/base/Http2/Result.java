package com.mardomsara.social.base.Http2;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.HttpJsonList;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.lang.reflect.Type;
import java.util.List;

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

    static Moshi moshi = new Moshi.Builder().build();
    public static <T> HttpJson<T> fromJson(Result result , Class<T> cls){
        HttpJson<T> j = null;
        //////// Moshi ////////////
        Type listOfCardsType = Types.newParameterizedType(HttpJson.class, cls);

        JsonAdapter<HttpJson<T>> jsonAdapter = moshi.adapter(listOfCardsType);

        try {
            j = jsonAdapter.fromJson(result.data);
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

    public static <T> HttpJsonList<T> fromJsonList(Result result, Class<T> cls ){
        HttpJsonList<T> j = null;
        //////// Moshi ////////////
        Type listOfObjects = Types.newParameterizedType(HttpJsonList.class, cls);

        JsonAdapter<HttpJsonList<T>> jsonAdapter = moshi.adapter(listOfObjects);
        try {
            j = jsonAdapter.fromJson(result.data);
        }catch (Exception e){
            Log.e("JSON: ","error in Result.fromJsonList parsing: "+e.toString() );
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

    ////////////// Old/////////////////////
    static Gson g = new Gson();
    //copy of JsonUtil.fromJson(...)
    public static <T> T fromJson_bk(Result result , Class<T> cls){
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

    public static <T> HttpJson<T> fromJson2(Result result , Class<T> cls){
        Type type = new TypeToken<HttpJson<T>>(){}.getType();
        HttpJson<T> j = null;
        try {
            j = g.fromJson(result.data,type);
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


    /*public static <T> HttpJson<T> fromJsonList(Result result , Class<T> cls){
        Moshi moshi = new Moshi.Builder().build();

        Type listOfCardsType = Types.newParameterizedType(List.class, cls);

        JsonAdapter<List<Card>> jsonAdapter = moshi.adapter(listOfCardsType);

        List<Card> cards = jsonAdapter.fromJson(json);
    }*/

    /*class HttpBaseAdapter {
        @FromJson
        Event eventFromJson(EventJson eventJson) {
            Event event = new Event();
            event.title = eventJson.title;
            event.beginDateAndTime = eventJson.begin_date + " " + eventJson.begin_time;
            return event;
        }

        @ToJson EventJson eventToJson(Event event) {
            EventJson json = new EventJson();
            json.title = event.title;
            json.begin_date = event.beginDateAndTime.substring(0, 8);
            json.begin_time = event.beginDateAndTime.substring(9, 14);
            return json;
        }
    }*/
}