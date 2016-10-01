package com.mardomsara.social.helpers;

import android.util.Log;

import com.google.gson.Gson;
import com.mardomsara.social.base.Http2.Result;

/**
 * Created by Hamid on 3/4/2016.
 */
public class JsonUtil {

    static Gson g = new Gson();
    //could be null - check it
    public static <T> T fromJson(String str , Class<T> cls){
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

    public static <T> T fromJsonHttp(Result result , Class<T> cls){
        T j = null;
        try {
            j = g.fromJson(result.data,cls);
//            Class<?> cl = j.Load.getClass();
        }catch (Exception e){
            Log.e("JSON: ","error in JsonUtil.fromJson parsing: "+e.toString() );
            e.printStackTrace();
        }
        return j;
    }

    public static String toJson(Object obj) {
//        Gson g = new Gson();
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
//            Class<?> cl = j.Load.getClass();
//            //if we have array in json Gson will produce ArrayList but we need puer java array: User[] so
//            //we do litlte Reflection hack
//            if( cl.getName().equals("java.util.ArrayList")){
//               Object[] tt =  ( (ArrayList<Object>)j.Load ).toArray();
//                T t = (T)tt;
//               j.Load = t;
//            }
//        }catch (Exception e){
//            Log.e("JSON: ","error in JsonUtil.fromJson parsing: "+e.toString() );
//            e.printStackTrace();
//            j = new HttpBaseProtocol<T>();//???????? is this good??????
//        }
////        b.Load =
//        return j;
//    }
}
