package com.mardomsara.social.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.google.gson.Gson;
import com.mardomsara.social.App;
import com.mardomsara.social.app.Singletons;
import com.mardomsara.social.lib.TinyDB;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

/**
 * Created by Hamid on 3/18/2016.
 */
public class AppUtil {
    public static Context _context;
    private static SharedPreferences store;
    private static Gson gson = new Gson();

    public static ViewGroup global_window;

    public static URL toUrl(String str){
        URL u = null;
        try {
            u = new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public static URI toUri(String str){
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    static TinyDB tinyDBStore;
    public static TinyDB getStore(){
        if(tinyDBStore == null){
            tinyDBStore = new TinyDB(getContext(),"store");
        }
        return tinyDBStore;
    }

    static TinyDB tinyDBCache;
    public static TinyDB getCacheStore(){
        if(tinyDBCache == null){
            tinyDBCache = new TinyDB(getContext(),"store_cache");
        }
        return tinyDBCache;
    }

    public static Context getContext(){
        return _context;
    }

    public static<T> T  fromJson(String str,  Class<T> cls){
      return new Gson().fromJson(str,cls);
    }
    public static String  toJson(Object obj){
      return gson.toJson(obj);
    }

    public static void log(String str){
        Log.d(Thread.currentThread().getName(),""+ str);
    }
    public static void log(Object obj){
        Log.d(Thread.currentThread().getName(),""+ toJson(obj));
    }
    public static void error(String str){
        Log.e(Thread.currentThread().getName(), "" + str);
    }

    public static long getTimeMs(){
        return new Date().getTime();
    }

    public static long getTime(){
        return (new Date().getTime())/1000;
    }

    //deprecated : moved to AndroidUtil
    public static void runInBackgeound(Runnable r){
        Singletons.getThreadPool().execute(r);
    }

    public static View inflate(int id){
        return LayoutInflater.from(_context).inflate(id,null,false);
    }

    public static View inflate(int id, ViewGroup parent){
        return LayoutInflater.from(_context).inflate(id,parent,false);
    }

	public static View inflate(int id, ViewGroup parent,boolean attach){
		return LayoutInflater.from(_context).inflate(id,parent,attach);
	}

    public static void runInUi(Runnable r)
    {
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                r.run();
            }
        }.executeOnExecutor(Singletons.getThreadPool());
    }

    static int hw1,hw2 =0;
    static ViewTreeObserver.OnGlobalLayoutListener _listener = null;
    public static void listanAndSaveKewordSize(View windowView){
        int h1 =  windowView.getHeight();
         _listener = new ViewTreeObserver.OnGlobalLayoutListener(){
            public void onGlobalLayout(){
                AppUtil.log("windowView.addOnGlobalLayoutListener");
                int heightDiff = h1- windowView.getHeight();
                if(hw1 == 0) {
                    hw1 = windowView.getHeight();
                }else {
                    hw2= windowView.getHeight();
                    if (Math.abs(hw1-hw2)>150){
                        int kybordSize = Math.abs(hw1-hw2);
//                        Hawk.put(Config.KEYBOARD_HEIGHT,kybordSize);
                    }
                };
            }
        };
        windowView.getViewTreeObserver().addOnGlobalLayoutListener(_listener);
    }

    //Importnat : must be called : it's gc problem
    public static void unRegisterKeywoardlistaner(View windowView){
        if(_listener != null){
            windowView.getViewTreeObserver().removeOnGlobalLayoutListener(_listener);
        }
        _listener =null;
    }

    private static int statusBarPerviuos = View.SYSTEM_UI_FLAG_VISIBLE;
	public static void dimStatusBar(){
		View decorView = App.getActivity().getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
		statusBarPerviuos = decorView.getSystemUiVisibility();
		decorView.setSystemUiVisibility(uiOptions);
	}

	public static void unDimStatusBar(){
		View decorView = App.getActivity().getWindow().getDecorView();
		decorView.setSystemUiVisibility(statusBarPerviuos);
	}
}
