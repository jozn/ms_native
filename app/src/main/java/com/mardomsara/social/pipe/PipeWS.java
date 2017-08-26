package com.mardomsara.social.pipe;

import android.util.Log;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.models.flusher.FlushStoredDataToServer;
//import com.mardomsara.social.pipe.del.Pipe;

import org.greenrobot.essentials.io.FileUtils;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import ir.ms.pb.PB_CommandReachedToClient;
import ir.ms.pb.PB_CommandToServer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.Buffer;
import okio.ByteString;

class PipeWS {
    private static String wsUrl = "ws://192.168.0.10:5000/ws_pb_call?user_id="+ Session.getUserId();
    private static String LOGTAG = "WS";
    private static PipeWS instance;

    private STATUS status = STATUS.CLOSED;

//    private Executor sequnceSendThread = Executors.newSingleThreadExecutor();
    WSConnectionListener wsConnectionListener;

    int delayReconnect = 5;//seconds

//    private Thread senderThread;
//    BlockingQueue<Call_DEP> wsSendChannel = new LinkedBlockingQueue<>();
    BlockingQueue<PB_CommandToServer> wsSendChannel = new LinkedBlockingQueue<>();
//    BlockingQueue<byte[]> wsSendChannelBinary = new LinkedBlockingQueue<>();

    //for now use just single thread, maybe using multi thread could cause data racing or others bug
    ExecutorService singleReciverHandlerExecuter = Executors.newSingleThreadExecutor();
    WebSocket webSocket;

    private PipeWS() {
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

    public static PipeWS getInstance(){
        if(instance == null){
            instance = new PipeWS();
        }
        return instance;
    }

	public boolean isOpen(){
		return status == STATUS.OPEN;
	}


	void sendCall(PB_CommandToServer pb_commandToServer){
		try {
			wsSendChannel.put(pb_commandToServer);//sendString to chanel
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void cancelCall(PB_CommandToServer pb_commandToServer){
		try {
			wsSendChannel.remove(pb_commandToServer);//sendString to chanel
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    void connectToServer(){
        Log.i(LOGTAG, " connectToServer");
        //just make sure there is only one conncetion open to server
        if(wsConnectionListener != null && webSocket != null ){
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
        wsConnectionListener = new WSConnectionListener(this);
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
		client.newWebSocket(request,wsConnectionListener);
//        WebSocketCall.create(client, request).enqueue(wsConnectionListener);
    }

    static int ii = 0;
    void runSenderThread() {
        Log.i(LOGTAG, "runSenderThread called");
        Runnable run = ()->{
            String body = "";
            RequestBody req;
            while (true) {
                try {
                    if(webSocket != null && status == STATUS.OPEN){
                        PB_CommandToServer call = wsSendChannel.take();
						if(call == null) continue;
//						body = JsonUtil.toJson(call);
                        Log.i(LOGTAG, "sending PB_CommandToServer from WSchanel" + call.toString());
//                        req = RequestBody.create(TEXT, body);
						byte[] data = call.toByteArray();
//						Log.i("MSG_add: ", Base64.encodeBytes(data) );
						ii++;
						FileUtils.writeBytes(new File(AppFiles.PHOTO_DIR_PATH + ""+ii), data );
//                        req = RequestBody.create(BINARY, call.toByteArray());
						if(status == STATUS.OPEN){
							webSocket.send(ByteString.of(call.toByteArray()));
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


	void sendToServer_CallReceivedToAndroid(long ServerCallId){
		PB_CommandReachedToClient pb = PB_CommandReachedToClient.newBuilder().setServerCallId(ServerCallId).build();
		Runnable r = ()->{};
		Pipe.send(Constants.PB_CommandReachedToClient, pb, null,null);
		/*Call_DEP call = new Call_DEP("CallReceivedToClient");
		call.ClientCallId = 0;//tell server don't respond
		call.ServerCallId = ServerCallId;

		sendCall(call);*/
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

    void onFailure(Throwable e, Response response) {
        Log.i(LOGTAG, "onFailure: IOException - Response:" + e.toString() );
        status = STATUS.CLOSED;
        prepareForReqonecting();
    }

    void onMessage(ByteString message) {
		try {
			String body =  message.toString();
			AndroidUtil.runInBackgroundNoPanic(()->{
				RouterForDataReceived.handleNetWSMessage(message);
			});
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(message != null){
				//message.close();
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

    static class WSConnectionListener extends WebSocketListener {
		PipeWS ws;

        WSConnectionListener(PipeWS ws) {
            this.ws = ws;
        }

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            ws.onOpen(webSocket, response);
        }

		@Override
		public void onMessage(WebSocket webSocket, String text) {
			super.onMessage(webSocket, text);
		}

		@Override
		public void onMessage(WebSocket webSocket, ByteString bytes) {
			super.onMessage(webSocket, bytes);
			ws.onMessage(bytes);
		}

		@Override
		public void onClosing(WebSocket webSocket, int code, String reason) {
			super.onClosing(webSocket, code, reason);
		}

		@Override
		public void onClosed(WebSocket webSocket, int code, String reason) {
			super.onClosed(webSocket, code, reason);
			ws.onClose(code,reason);
		}

		@Override
		public void onFailure(WebSocket webSocket, Throwable t, Response response) {
			super.onFailure(webSocket, t, response);
			ws.onFailure(t,response);
		}

    }

    enum STATUS {
        OPEN,
        CLOSED,
        CONNECTING
    }

}
