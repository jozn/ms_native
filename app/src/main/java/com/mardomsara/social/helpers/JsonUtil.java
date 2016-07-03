package com.mardomsara.social.helpers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mardomsara.social.json.HttpBaseProtocol;
import com.mardomsara.social.json.UserListFollow;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Hamid on 3/4/2016.
 */
public class JsonUtil {

    //could be null - check it
    public static <T> T fromJson(String str , Class<T> cls){
        Gson g = new Gson();
        T j = null;
        try {
            j = g.fromJson(str,cls);
//            Class<?> cl = j.Payload.getClass();
        }catch (Exception e){
            Log.e("JSON: ","error in JsonUtil.fromJson parsing: "+e.toString() );
            e.printStackTrace();
        }
        return j;
    }

    public static String toJson(Object obj) {
        Gson g = new Gson();
        return g.toJson(obj);
    }

    static void sa(){
        Gson g = new Gson();

    }
//    public static <T> HttpBaseProtocol<T> fromJson(String str){
//        Gson g = new Gson();
//        Type fooType = new TypeToken<HttpBaseProtocol<UserListFollow[]>>() {}.getType();
////        Type fooType = new TypeToken<HttpBaseProtocol<T>>() {}.getType();
//
//        HttpBaseProtocol<T> j;
//        try {
//            j = g.fromJson(str,fooType);
//            Class<?> cl = j.Payload.getClass();
//            //if we have array in json Gson will produce ArrayList but we need puer java array: User[] so
//            //we do litlte Reflection hack
//            if( cl.getName().equals("java.util.ArrayList")){
//               Object[] tt =  ( (ArrayList<Object>)j.Payload ).toArray();
//                T t = (T)tt;
//               j.Payload = t;
//            }
//        }catch (Exception e){
//            Log.e("JSON: ","error in JsonUtil.fromJson parsing: "+e.toString() );
//            e.printStackTrace();
//            j = new HttpBaseProtocol<T>();//???????? is this good??????
//        }
////        b.Payload =
//        return j;
//    }
}
