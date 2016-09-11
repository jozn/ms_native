package com.mardomsara.social.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.mardomsara.social.App;
import com.mardomsara.social.app.LifeCycle;
import com.mardomsara.social.base.CmdResRegistery;
import com.mardomsara.social.base.Command;
import com.mardomsara.social.base.NetEventHandler;
import com.mardomsara.social.base.WSCall;
import com.mardomsara.social.helpers.JsonUtil;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Hamid on 3/20/2016.
 */
public class BackgroundService extends Service {
    private static String LOGTAG = "BackgroundService";

    public BackgroundService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App.init(this);
        LifeCycle.initFromBackground(getApplicationContext());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOGTAG, "BackgroundService  onStartCommand");

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(LOGTAG, "BackgroundService onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
