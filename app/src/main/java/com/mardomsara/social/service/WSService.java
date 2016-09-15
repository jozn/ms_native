package com.mardomsara.social.service;

import android.util.Log;

import com.mardomsara.social.app.DB;
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
@Deprecated
public class WSService {
    private static String LOGTAG = "WSService";
    private static WSService _serviceInstance;

    private Executor _exe = Executors.newSingleThreadExecutor();
    public WSClient wsclient;

    int delayReconnect = 5;//seconds

    public WSService() {
        _serviceInstance = this;
        Log.d(LOGTAG, "WSService onCreate");
//        _exe = Executors.newSingleThreadExecutor();
        connectToServer();
    }

    public static WSService getInstance(){
        if(_serviceInstance == null){
            _serviceInstance = new WSService();
        }
        return _serviceInstance;
    }


    private void send(String command){
//        _runService();
        //WORKAROUND carsh: somethimse for first time connection connection maybe null
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
        getInstance().send(ws_res);
    }

    public static void sendAnStoreCommand(Command command) {
        Runnable r = ()->{
            try {
                command.makeDataReady();
                DB.db.insertIntoCommand(command);
                sendCommand(command);
            }catch (Exception e){
                e.printStackTrace();
            }
        };

        getInstance()._exe.execute(r);
    }

    public static void sendCommandForResponse(Command command, NetEventHandler handler){
        CmdResRegistery.register(command.ResId, handler);
        sendCommand(command);
    }

    public static void sendBinary(byte[] bytes){
        Log.d(LOGTAG, " sendBinary");
//        _runService();
        //WORKAROUND carsh: somethimse for first time connection connection maybe null
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

    void connectToServer(){
        Log.d(LOGTAG, " connectToServer");
        //just make sure there is only one conncetion open to server
        if(wsclient != null && wsclient.webSocket != null ){
//            try {
//                connection.webSocket.close(1100," closed new connection");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        wsclient = new WSClient();
        wsclient.tryConnect();
    }

    boolean isReconnectingRunning = false;
    void onClientConnectionFinished(){
        if(isReconnectingRunning) return;

        Runnable r = ()->{
            try {
                isReconnectingRunning = true;
                Thread.sleep(delayReconnect * 1000);
                connectToServer();
            }catch (Exception e){

            }finally {

            }
        };
        Executors.newSingleThreadExecutor().execute(r);
    }

    void onClientConnectionSuccess(){
        isReconnectingRunning = false;
        delayReconnect = 5;
    }

}
