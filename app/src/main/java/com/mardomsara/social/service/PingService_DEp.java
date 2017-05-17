package com.mardomsara.social.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Deprecated
public class PingService_DEp extends Service {
    private String LOGTAG = "service";
    private Executor _exe ;
    public PingService_DEp() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOGTAG, "PingService onCreate");
        _exe = Executors.newSingleThreadExecutor();
//        SimpleDataChangedNotifier

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOGTAG, "PingService  onStartCommand");
//        return super.onStartCommand(intent, flags, startId);
        _exe.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    for (int i=0; i< 10000000; i++){
                        Thread.sleep(200);
                        //EventBus.getDefault().post(new RoomListsTable().setRoomName("romm-"+i));
                        //Log.d(LOGTAG, "slepp "+i);
                    }
                }catch (Exception e){
                }
            }
        });

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(LOGTAG, "PingService onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
