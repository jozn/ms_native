package com.mardomsara.social.pipe;

import android.os.Handler;
import android.os.Looper;

import com.mardomsara.social.app.AppLog;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.Timer;
import java.util.TimerTask;

class CommandFrame {
	private ErrorCallback error;

	private SuccessCallback successCallback;
	private long timeoutMs = 5000;//5second timeout
	private long clientCallId = TimeUtil.getTimeNano();
	private Status status = Status.NOTHING;

	CommandFrame(SuccessCallback success, ErrorCallback error, long clientCallId) {
		this.successCallback = success;
		this.error = error;
		this.clientCallId = clientCallId;

		setDelayer();
	}

	void setDelayer(){
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				Helper.showDebugMessage("getHandler().postDelayed(()->{}");

				AppLog.getWsLogger().d("===> Pipes CommandFrame Delayer:  clientCallId: " +clientCallId + " Status: "+status.toString());

				if(status == Status.NOTHING){
					if(error != null){
						error.onError(null);
					}
				}
				status= Status.ERROR;
				Pipe.CommandFrameMap.remove(clientCallId);
			}
		}, timeoutMs);
	}


	void setDelayer2(){
		getHandler().postDelayed(()->{
			Helper.showDebugMessage("getHandler().postDelayed(()->{}");
			if(status == Status.NOTHING){
				if(error != null){
					error.onError(null);
				}
			}
			status= Status.ERROR;
			Pipe.CommandFrameMap.remove(clientCallId);
		}, timeoutMs);
	}
	//////////////////////////////////////////
	static Handler handler;
	static Handler getHandler(){
		if(handler == null){
			handler = new Handler(Looper.getMainLooper());
		}
		return handler;
	}

	public SuccessCallback getSuccessCallback() {
		return successCallback;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	enum Status {
		NOTHING,
		SUCCESS,
		ERROR,
	}

}