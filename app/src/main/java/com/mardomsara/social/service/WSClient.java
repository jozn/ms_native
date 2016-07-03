package com.mardomsara.social.service;

import android.util.Log;

import com.mardomsara.social.app.NetEventRouter;
import com.mardomsara.social.base.CmdResRegistery;
import com.mardomsara.social.base.Command;
import com.mardomsara.social.base.Session;
import com.mardomsara.social.base.WSCall;
import com.mardomsara.social.helpers.AppUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import hugo.weaving.DebugLog;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ws.WebSocket;
import okhttp3.ws.WebSocketCall;
import okhttp3.ws.WebSocketListener;
import okio.Buffer;

import static okhttp3.ws.WebSocket.BINARY;
import static okhttp3.ws.WebSocket.TEXT;

/**
 * Created by Hamid on 3/20/2016.
 */
public class WSClient implements WebSocketListener {
    private String LOGTAG = "WSClient";
    private String wsUrl = "ws://192.168.0.10:5000/ws?UserId="+ Session.getUserId();
    public WebSocket webSocket;
//    private boolean isOpen = false;
    private STATUS staus = STATUS.CLOSED;
    private Thread senderThread;
    private Thread senderThreadBinary;
    public static BlockingQueue<String> wsSendChannel = new LinkedBlockingQueue<>();
    public static BlockingQueue<byte[]> wsSendChannelBinary = new LinkedBlockingQueue<>();
    //for now use just single thread, maybe using multi thread could cause data racing or others bug
    public static ExecutorService reciverHandlerExecuter = Executors.newSingleThreadExecutor();

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        Log.d(LOGTAG, "onOpen: Response:" + response.message());
        this.webSocket = webSocket;
        staus = STATUS.OPEN;
        runSenderThread();
        //        isOpen = true;
//        sendString("hhhhh");
//        sendString("hhhhh2222");
//        sendString("HHHHHHHHHHHHHHHHHEEEEEELLLLLLLLOOOOOOO");
    }

    @DebugLog
    @Override
    public void onFailure(IOException e, Response response) {
        Log.d(LOGTAG, "onFailure: IOException - Response:" + e.toString() );
//        isOpen = false;
        staus = STATUS.CLOSED;
    }

    @Override
    public void onMessage(ResponseBody message) throws IOException {
        String body =  message.string();
        Log.d(LOGTAG, Thread.currentThread().getName() + "onMessage: message :" + body);
//        Command com = AppUtil.fromJson(body, Command.class);
        WSCall res = AppUtil.fromJson(body, WSCall.class);
        Log.d("ws", ""+res);

        if(res.Commands == null) return;
        List<Long> recied = new ArrayList<>();
        Runnable r = ()->{
            for(Command comStr : res.Commands){
                if(comStr.Name.equals(CmdResRegistery.CMD_RES) ){
                    CmdResRegistery.tryRunCmd(comStr);
                }else {
                    NetEventRouter.handle(comStr.Name ,comStr.Data);
                }
                recied.add(comStr.CmdId);
            }
            Command reviedCmd = Command.getNew("CommandsReceived");
            reviedCmd.setData(recied);
            WSService.sendCommand(reviedCmd);
        };
        reciverHandlerExecuter.execute(r);
//        new Thread(r).start();
    }

    @Override
    public void onPong(Buffer payload) {
        Log.d(LOGTAG, "onPong: payload:" + payload);
    }

    @Override
    public void onClose(int code, String reason) {
        Log.d(LOGTAG, "onClose: code - reason: :" + code + " " + reason);
//        isOpen = false;
        staus = STATUS.CLOSED;
    }

    public void tryConnect() {
        if(staus == STATUS.CONNECTING || staus == STATUS.OPEN ) return;//OPEN or CONNECTING return;
        staus = STATUS.CONNECTING;
        OkHttpClient client;// = new OkHttpClient.Builder();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(4*3600, TimeUnit.SECONDS);
        builder.writeTimeout(4*3600, TimeUnit.SECONDS);
        client = builder.build();
        Request request = new Request.Builder()
//                .url("ws://echo.websocket.org")
                .url(wsUrl)
                .build();
        WebSocketCall.create(client, request).enqueue(this);
    }

    //TODO2 culd be a source of bug: try to connect and sending multi
    //// TODO: 3/28/2016 clean this up: conection mechansim must not be send command functionalities
    public void sendString(String s) {
        tryConnect();
        //maybe senderThread is dead?
        if(senderThread == null || !senderThread.isAlive()){
            runSenderThread();
        }
        wsSendChannel.add(s);
    }

    public void runSenderThread() {
        Log.d(LOGTAG, "runSenderThread called");
        Runnable run = ()->{
            String body = "";
            RequestBody req;
            while (true) {
                try {
                    body = wsSendChannel.take();
                    Log.d(LOGTAG, "sending text from WSchanel" + body);
                    req = RequestBody.create(TEXT, body);
//                    webSocket
                    webSocket.sendMessage(req);
//                }catch (IOException e) {
//                    e.printStackTrace();
//                    try {
//                        //because server ws commands is event driven we can add things to end of quee
//                        //COMMENTED:  culd be a source of bug
////                        wsSendChannel.put(body);
//                    } catch (InterruptedException e1) {}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        senderThread = new Thread(run);
        senderThread.start();
    }

    //TODO2 culd be a source of bug: try to connect and sending multi
    //// TODO: 3/28/2016 clean this up: conection mechansim must not be send command functionalities
    public void sendBinary(byte[] b) {
        Log.d(LOGTAG, "Clint sendBinary called");
        tryConnect();
        //maybe senderThread is dead?
        if(senderThreadBinary == null || !senderThreadBinary.isAlive()){
            runSenderThreadBinary();
        }
        wsSendChannelBinary.add(b);
    }
    public void runSenderThreadBinary() {
        Log.d(LOGTAG, "runSenderThreadBinary called");
        Runnable run = ()->{
            byte[] body = null;
            RequestBody req;
            while (true) {
                try {
                    body = wsSendChannelBinary.take();
                    Log.d(LOGTAG, "sending Binary from WSchanel" + body);
                    req = RequestBody.create(BINARY, body);
                    webSocket.sendMessage(req);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        senderThreadBinary = new Thread(run);
        senderThreadBinary.start();
    }
    enum STATUS{
        OPEN,
        CLOSED,
        CONNECTING
    }
}

//    //deprecated

//public void sendString(String s) {
//    if (webSocket ==null){return;}
//    RequestBody r = RequestBody.create(TEXT, s);
//    try {
//        webSocket.sendMessage(r);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}

//                if ( comStr.Name.equals("time") ){
////                    HelloCommand.time(comStr.Data);
//                    HelloCommand.addMesage.handle(comStr.Data);
//                }else{
//                    HelloCommand.hello(body);
//                }
