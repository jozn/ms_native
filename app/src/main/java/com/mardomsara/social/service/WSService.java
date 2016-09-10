package com.mardomsara.social.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.mardomsara.social.App;
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
public class WSService extends Service {
    private static String LOGTAG = "WSService";
    private static Executor _exe ;
    private static WSService _serviceInstance;
    public static WSClient wsclient;
    public WSService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App.init(this);
        _serviceInstance = this;
        Log.d(LOGTAG, "WSService onCreate");
        _exe = Executors.newSingleThreadExecutor();
        connectToServer();
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOGTAG, "WSService  onStartCommand");

        return Service.START_STICKY;
    }


    static void send(String command){
        _runService();
        //WORKAROUND carsh: somethimse for first time connection wsclient maybe null
        if(_serviceInstance == null || _serviceInstance.wsclient == null){
            try {
                WSClient.wsSendChannel.put(command);//send to chanel
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{//most of the times
            _serviceInstance.wsclient.sendString(command);//preferd way of sending msg to chanel - checks threads
        }
    }

    public static void sendCommand(Command command){
        command.makeDataReady();
        WSCall res = new WSCall();
        res.Commands = new Command[]{command};
        String ws_res = JsonUtil.toJson(res);
        send(ws_res);
    }

    //TODO: implement
    public static void sendAnStoreCommand(Command command) {
        sendCommand(command);
    }

        public static void sendCommandForRespone(Command command, NetEventHandler handler){
        CmdResRegistery.register(command.ResId, handler);
        sendCommand(command);
    }

    public static void sendBinary(byte[] bytes){
        Log.d(LOGTAG, " sendBinary");
        _runService();
        //WORKAROUND carsh: somethimse for first time connection wsclient maybe null
        if(_serviceInstance == null || _serviceInstance.wsclient == null){
            try {
                WSClient.wsSendChannelBinary.put(bytes);//send to chanel
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{//most of the times
            _serviceInstance.wsclient.sendBinary(bytes);//preferd way of sending msg to chanel - checks threads
        }

    }
    static void connectToServer(){
        Log.d(LOGTAG, " connectToServer");
        //just make sure there is only one conncetion open to server
        if(wsclient != null && wsclient.webSocket != null ){
//            try {
//                wsclient.webSocket.close(1100," closed new connection");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        wsclient = new WSClient();
        wsclient.tryConnect();
    }

    private static void _runService(){
        if(_serviceInstance == null) {
            Intent i = new Intent(App.context,WSService.class);
            App.context.startService(i);
        }
    }

    @Override
    public void onDestroy() {
        Log.d(LOGTAG, "WSService onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
