package com.mardomsara.social.service;

import android.util.Log;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.app.NetEventRouter;
import com.mardomsara.social.base.CmdResRegistery;
import com.mardomsara.social.base.Command;
import com.mardomsara.social.base.NetEventHandler;
import com.mardomsara.social.base.WSCall;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ws.WebSocket;
import okhttp3.ws.WebSocketCall;
import okhttp3.ws.WebSocketListener;
import okio.Buffer;

import static okhttp3.ws.WebSocket.TEXT;

/**
 * Created by Hamid on 9/11/2016.
 */
public class WS {
    private static String wsUrl = "ws://192.168.0.10:5000/ws?UserId="+ Session.getUserId();
    private static String LOGTAG = "WS";
    private static WS instance;

    private STATUS status = STATUS.CLOSED;

    private Executor sequnceSendThread = Executors.newSingleThreadExecutor();
    WSConnection connection;

    int delayReconnect = 5;//seconds

//    private Thread senderThread;
    BlockingQueue<String> wsSendChannel = new LinkedBlockingQueue<>();
    BlockingQueue<byte[]> wsSendChannelBinary = new LinkedBlockingQueue<>();
    //for now use just single thread, maybe using multi thread could cause data racing or others bug
    ExecutorService reciverHandlerExecuter = Executors.newSingleThreadExecutor();
    WebSocket webSocket;

    public static NetEventHandler CommandsReceivedToServer_Handler = (data)->{
        Long[] ids = JsonUtil.fromJson(data, Long[].class);
        if(ids == null) return;
        logIt("CommandsReceivedToServer_Handler " + ids.toString());
        DB.db.deleteFromCommand().ClientNanoIdIn(ids).execute();

    };

    private WS() {
        instance = this;
        Log.d(LOGTAG, "WSService onCreate");
        runSenderThread();
        connectToServer();
        connectionCheker();
    }

    void connectionCheker(){
        Runnable r = ()->{
            int t = 5;
            while (true){
                try {
                    if(status == STATUS.CLOSED){
                        Thread.sleep(t * 1000);
                        connectToServer();
                        t += t;
                    }else {
                        t = 5;
                    }
                }catch (Exception e){

                }finally {

                }
            }
        };
        delayReconnect += delayReconnect;
        Executors.newSingleThreadExecutor().execute(r);

    }

    public static WS getInstance(){
        if(instance == null){
            instance = new WS();
        }
        return instance;
    }

    private void sendString(String command){
        try {
            wsSendChannel.put(command);//sendString to chanel
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sendCommand(Command command){
        command.makeDataReady();
        WSCall res = new WSCall();
        res.Commands = new Command[]{command};
        String ws_res = JsonUtil.toJson(res);
        getInstance().sendString(ws_res);
    }

    public static void sendCommands(List<Command> commands){
        for(Command c : commands){
//            c.makeDataReady();
            c.prepareAfterLoadFromDB();
            AppUtil.log("Command XXX: "+c.toString());
//            c.Data.replace("\\\\","\\");
            sendCommand(c);
        }

        /*WSCall res = new WSCall();
        res.Commands = commands.toArray(new Command[]{});
        String ws_res = JsonUtil.toJson(res);
        getInstance().sendString(ws_res);*/
    }

    public static void sendAnStoreCommand(Command command) {
        Runnable r = ()->{
            try {
                command.makeDataReady();
                command.insert();
//                DB.db.insertIntoCommand(command);
                sendCommand(command);
            }catch (Exception e){
                e.printStackTrace();
            }
        };

        getInstance().sequnceSendThread.execute(r);
    }

    public static void sendCommandForResponse(Command command, NetEventHandler handler){
        CmdResRegistery.register(command.ResId, handler);
        sendCommand(command);
    }

    void connectToServer(){
        Log.d(LOGTAG, " connectToServer");
        //just make sure there is only one conncetion open to server
        if(connection != null && webSocket != null ){
//            closeConnection();
        }

        tryConnect();
    }

    void closeConnection(){
        try {
            if(webSocket != null ){
                webSocket.close(1100,"asd");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    boolean isReconnectingRunning = false;
    void prepareForReqonecting(){
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
        delayReconnect += delayReconnect;
//        Executors.newSingleThreadExecutor().execute(r);
    }

    void sendStoredCommands(){
        List<Command> cmds =  DB.db.selectFromCommand().toList();
        sendCommands(cmds);
    }

    void tryConnect() {
        connection = new WSConnection(this);
        if(status == STATUS.CONNECTING || status == STATUS.OPEN ) return;//OPEN or CONNECTING return;
        status = STATUS.CONNECTING;
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
        WebSocketCall.create(client, request).enqueue(connection);
    }

    void runSenderThread() {
        Log.d(LOGTAG, "runSenderThread called");
        Runnable run = ()->{
            String body = "";
            RequestBody req;
            while (true) {
                try {
                    if(webSocket != null && status == STATUS.OPEN){
                        body = wsSendChannel.take();
                        Log.d(LOGTAG, "sending text from WSchanel" + body);
                        req = RequestBody.create(TEXT, body);
                        webSocket.sendMessage(req);
                    }else {
                        Thread.sleep(200);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Executors.newSingleThreadExecutor().execute(run);
    }

    void handleNetMessage(String body){
        logIt("onMessage: message :" + body);
        WSCall res = AppUtil.fromJson(body, WSCall.class);
        Log.d("ws", ""+res);

        if(res.Commands == null) return;
        List<Long> serverNanosRecied = new ArrayList<>();
        Boolean sendCmdsRecived = true;
        Runnable r = ()->{
            for(Command comStr : res.Commands){
                try {//handle catches errors
                    //responed to server servers commands recived
                    if(comStr.ServerNanoId > 0){
                        serverNanosRecied.add(comStr.ServerNanoId);
                    }

                    if(comStr.Name.equals(CmdResRegistery.CMD_RES) ){//for request->responsed command
                        CmdResRegistery.tryRunCmd(comStr);
                    }else {
                        NetEventRouter.handle(comStr.Name ,comStr.Data);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(serverNanosRecied.size() > 0){
                Command reviedCmd = Command.getNew("CommandsReceivedToClient");
                reviedCmd.setData(serverNanosRecied);
                sendCommand(reviedCmd);
            }
        };
        reciverHandlerExecuter.execute(r);
    }

    /////////////////////// Websocket Connection callbacks ////////////////////////////////////
    void onOpen(WebSocket webSocket, Response response) {
        Log.d(LOGTAG, "onOpen: Response:" + response.message());
        this.webSocket = webSocket;
        status = STATUS.OPEN;
        isReconnectingRunning = false;
        delayReconnect = 5;
        sendStoredCommands();
    }

    void onFailure(IOException e, Response response) {
        Log.d(LOGTAG, "onFailure: IOException - Response:" + e.toString() );
        status = STATUS.CLOSED;
        prepareForReqonecting();
    }

    void onMessage(ResponseBody message) {
        try {
            String body =  message.string();
            handleNetMessage(body);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void onPong(Buffer payload) {
        Log.d(LOGTAG, "onPong: payload:" + payload);
    }

    void onClose(int code, String reason) {
        logIt("onClose: code - reason: :" + code + " " + reason);
        status = STATUS.CLOSED;
        prepareForReqonecting();
    }

    static void logIt(String msg){
        Log.d(LOGTAG,"Thread: "+Thread.currentThread().getName() + " " + msg);
    }

    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    static class WSConnection implements WebSocketListener {
        public WebSocket webSocket;

        public WSConnection(WS ws) {
            this.ws = ws;
        }

        WS ws;
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            ws.onOpen(webSocket, response);
        }

        @Override
        public void onFailure(IOException e, Response response) {
            ws.onFailure(e,response);
        }

        @Override
        public void onMessage(ResponseBody message) throws IOException {
            ws.onMessage(message);
        }

        @Override
        public void onPong(Buffer payload) {
            ws.onPong(payload);
        }

        @Override
        public void onClose(int code, String reason) {
            ws.onClose(code,reason);
        }

    }

    enum STATUS {
        OPEN,
        CLOSED,
        CONNECTING
    }

}
