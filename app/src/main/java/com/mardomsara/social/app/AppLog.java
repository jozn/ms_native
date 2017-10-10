package com.mardomsara.social.app;

import android.util.Log;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.lang.*;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * Created by Hamid on 10/4/2017.
 */

public class AppLog {

	static Date start = new Date();

	static WebSocket webSocket;
	static boolean connected = false;
	private static LogWriter wsLogger;
	private static LogWriter rpcLogger;
	private static LogWriter inboxLogger;
	private static LogWriter settingLogger;
	private static LogWriter homeLogger;
	private static LogWriter pushLogger;
	private static LogWriter execptionsLogger;
	private static String wsUrl = "ws://192.168.1.250:5000/ws_log";

	public static LogWriter getWsLogger() {
		if (wsLogger == null) {
			wsLogger = newLogger("ws");
		}
		return wsLogger;
	}

	public static LogWriter getRpcMsgLogger() {
		if (rpcLogger == null) {
			rpcLogger = newLogger("msg-rpc");
		}
		return rpcLogger;
	}

	public static LogWriter getInboxLogger() {
		if (inboxLogger == null) {
			inboxLogger = newLogger("inbox");
		}
		return inboxLogger;
	}

	public static LogWriter getSettingLogger() {
		if (settingLogger == null) {
			settingLogger = newLogger("setting");
		}
		return settingLogger;
	}

	public static LogWriter getHomeLogger() {
		if (homeLogger == null) {
			homeLogger = newLogger("home");
		}
		return homeLogger;
	}

	public static LogWriter getPushLogger() {
		if (pushLogger == null) {
			pushLogger = newLogger("home");
		}
		return pushLogger;
	}

	public static LogWriter getExecptionsLogger() {
		if (execptionsLogger == null) {
			execptionsLogger = newLogger("execptions");
		}
		return execptionsLogger;
	}

	private static LogWriter newLogger(String moudle) {
		tryConnect();
		return new LogWriter(moudle);
	}

	private static void tryConnect() {
		if (connected) return;
		WSConnectionListener wsConnectionListener = new WSConnectionListener();
		OkHttpClient client;// = new OkHttpClient.Builder();
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		builder.connectTimeout(1, TimeUnit.SECONDS);
		builder.readTimeout(1 * 3600, TimeUnit.SECONDS);
		builder.writeTimeout(1 * 3600, TimeUnit.SECONDS);
		client = builder.build();
		Request request = new Request.Builder()
			.url(wsUrl)
			.build();
		client.newWebSocket(request, wsConnectionListener);
//        WebSocketCall.create(client, request).enqueue(wsConnectionListener);
	}

	static class RowLog {
		public String Module;
		public long Time;
		public String Severity;
		public String Text;
		public long Version;
	}

	public static class LogWriter {

		String moudle;

		public LogWriter(String moudle) {
			this.moudle = moudle;
		}

		public LogWriter line() {
			writeToWs("v", "==================================================================================================================");
			return this;
		}

		public LogWriter e(Exception e) {
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PrintStream ps = new PrintStream(baos, true, "utf-8");
				e.printStackTrace(ps);
//				String content = new String(baos.toByteArray(), StandardCharsets.UTF_8);
				writeToWs("e", baos.toString(StandardCharsets.UTF_8.name()));
				ps.close();
				e.printStackTrace();
			}catch (Exception e2){
				e2.printStackTrace();
			}

			return this;
		}

		public void v(String logTxt) {
			writeToWs("v", logTxt);
		}

		public void d(String logTxt) {
			writeToWs("d", logTxt);
		}

		public void w(String logTxt) {
			writeToWs("w", logTxt);
		}

		public void e(String logTxt) {
			writeToWs("e", logTxt);
		}

		public void json(Object object) {
			writeToWs("d", AppUtil.toJson(object));
		}

		private void writeToWs(String severity, String text) {
			tryConnect();
			if (AppLog.webSocket != null) {
				RowLog rowLog = new RowLog();
				rowLog.Module = moudle;
				rowLog.Severity = severity;
				rowLog.Text = text;
				rowLog.Time = AppUtil.getTime();
				rowLog.Version = start.getTime()/1000;

				rowLog.Text = rowLog.Text + "\n=========================================================================================================================================";

				AndroidUtil.runInUiNoPanic(()->{
					try {
						String toSendStr = AppUtil.toJson(rowLog);
						webSocket.send(toSendStr);
					} catch (Exception e) {
						e.printStackTrace();
						Log.d("AppLog", "websocket Exception: - isConnected: "+ AppLog.connected);
					}
				});

			}else {
				Log.d("AppLog", "websocket is null - isConnected: "+ AppLog.connected);
			}

		}
	}

	static class WSConnectionListener extends WebSocketListener {

		@Override
		public void onOpen(WebSocket webSocket, Response response) {
			AppLog.webSocket = webSocket;
			AppLog.connected = true;
			Log.d("AppLog", " websocket is now open");
		}

		@Override
		public void onMessage(WebSocket webSocket, String text) {
			super.onMessage(webSocket, text);
		}

		@Override
		public void onMessage(WebSocket webSocket, ByteString bytes) {
			super.onMessage(webSocket, bytes);

		}

		@Override
		public void onClosing(WebSocket webSocket, int code, String reason) {
			super.onClosing(webSocket, code, reason);
			AppLog.connected = false;
		}

		@Override
		public void onClosed(WebSocket webSocket, int code, String reason) {
			super.onClosed(webSocket, code, reason);
			AppLog.connected = false;
		}

		@Override
		public void onFailure(WebSocket webSocket, Throwable t, Response response) {
			super.onFailure(webSocket, t, response);
			AppLog.connected = false;
		}

	}
}
