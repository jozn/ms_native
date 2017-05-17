package com.mardomsara.social.pipe;

import android.util.Log;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.pipe.from_net_calls.FlushStoredDataToServer;

import java.io.IOException;
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
    private static String wsUrl = "ws://192.168.0.10:5000/ws_call?user_id="+ Session.getUserId();
    private static String LOGTAG = "WS";
    private static WS instance;

    private STATUS status = STATUS.CLOSED;

//    private Executor sequnceSendThread = Executors.newSingleThreadExecutor();
    WSConnection connection;

    int delayReconnect = 5;//seconds

//    private Thread senderThread;
    BlockingQueue<Call> wsSendChannel = new LinkedBlockingQueue<>();
//    BlockingQueue<byte[]> wsSendChannelBinary = new LinkedBlockingQueue<>();

    //for now use just single thread, maybe using multi thread could cause data racing or others bug
    ExecutorService singleReciverHandlerExecuter = Executors.newSingleThreadExecutor();
    WebSocket webSocket;

    private WS() {
        instance = this;
        Log.i(LOGTAG, "WSService onCreate");
		AndroidUtil.runInBackgroundNoPanic(()->{
			runSenderThread();
			connectToServer();
			connectionChecker();
		});
    }

    void connectionChecker(){
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

	public boolean isOpen(){
		return status == STATUS.OPEN;
	}

	void sendCall(Call call){
		try {
			wsSendChannel.put(call);//sendString to chanel
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void cancelCall(Call call){
		try {
			wsSendChannel.remove(call);//sendString to chanel
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    void connectToServer(){
        Log.i(LOGTAG, " connectToServer");
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

    void tryConnect() {
        connection = new WSConnection(this);
        if(status == STATUS.CONNECTING || status == STATUS.OPEN ) return;//OPEN or CONNECTING return;
        status = STATUS.CONNECTING;
        OkHttpClient client;// = new OkHttpClient.Builder();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(1*3600, TimeUnit.SECONDS);
        builder.writeTimeout(1*3600, TimeUnit.SECONDS);
        client = builder.build();
        Request request = new Request.Builder()
                .url(wsUrl)
                .build();
        WebSocketCall.create(client, request).enqueue(connection);
    }

    void runSenderThread() {
        Log.i(LOGTAG, "runSenderThread called");
        Runnable run = ()->{
            String body = "";
            RequestBody req;
            while (true) {
                try {
                    if(webSocket != null && status == STATUS.OPEN){
                        Call call = wsSendChannel.take();
						if(call == null) continue;
						body = JsonUtil.toJson(call);
                        Log.i(LOGTAG, "sending text from WSchanel" + body);
                        req = RequestBody.create(TEXT, body);
						if(status == STATUS.OPEN){
							webSocket.sendMessage(req);
						}else {
							tryConnect();
							try {
								wsSendChannel.offer(call);
							}catch (Exception e){
								e.printStackTrace();
							}
							return;
						}
                    }else {
						return; //we must reconnect again
//                        Thread.sleep(200);
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
		Call call = AppUtil.fromJson(body, Call.class);
		Log.i("ws", ""+call);

		if(call == null) return;

		Runnable r = ()->{
			try {
				if (call.ServerCallId != 0) {//respond call
					sendToServer_CallReceivedToAndroid(call.ServerCallId);
				}
				if (call.Name.equals("CallReceivedToServer")) {
					CallRespondCallbacksRegistery.trySucceeded(call.ClientCallId);
					return;
				}

				WSCallRouter.handle(call.Name, call);
			}catch (Exception e){
				e.printStackTrace();
			}
		};
		singleReciverHandlerExecuter.execute(r);
	}

	void sendToServer_CallReceivedToAndroid(long ServerCallId){
		Call call = new Call("CallReceivedToClient");
		call.ClientCallId = 0;//tell server don't respond
		call.ServerCallId = ServerCallId;

		sendCall(call);
	}

    /////////////////////// Websocket Connection callbacks ////////////////////////////////////
    void onOpen(WebSocket webSocket, Response response) {
        Log.i(LOGTAG, "onOpen: Response:" + response.message());
        this.webSocket = webSocket;
        status = STATUS.OPEN;
        isReconnectingRunning = false;
        delayReconnect = 5;

		runSenderThread();

		FlushStoredDataToServer.flushAllMessages();
//        sendStoredCommands();
    }

    void onFailure(IOException e, Response response) {
        Log.i(LOGTAG, "onFailure: IOException - Response:" + e.toString() );
        status = STATUS.CLOSED;
        prepareForReqonecting();
    }

    void onMessage(ResponseBody message) {
		try {
			String body =  message.string();
			AndroidUtil.runInBackgroundNoPanic(()->{
				handleNetMessage(body);
			});
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(message != null){
				message.close();
			}
		}
    }

    void onPong(Buffer payload) {
        Log.i(LOGTAG, "onPong: payload:" + payload);
    }

    void onClose(int code, String reason) {
        logIt("onClose: code - reason: :" + code + " " + reason);
        status = STATUS.CLOSED;
        prepareForReqonecting();
    }

    static void logIt(String msg){
        Log.i(LOGTAG,"Thread: "+Thread.currentThread().getName() + " " + msg);
    }

    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    static class WSConnection implements WebSocketListener {
		WS ws;

        WSConnection(WS ws) {
            this.ws = ws;
        }

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
