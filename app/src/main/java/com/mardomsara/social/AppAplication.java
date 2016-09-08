package com.mardomsara.social;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Hamid on 6/17/2016.
 */
public class AppAplication extends Application {

    public static RefWatcher getRefWatcher(Context context) {
//        AppAplication application = (AppAplication) context.getApplicationContext();
//        return application.refWatcher;
        return refWatcher;
    }

    static RefWatcher refWatcher;

    @Override public void onCreate() {
        super.onCreate();
//        LeakCanary.install(this);
        //refWatcher = LeakCanary.install(this);
    }
}
