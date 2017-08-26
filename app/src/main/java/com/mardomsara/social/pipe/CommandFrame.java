package com.mardomsara.social.pipe;

import android.os.Handler;
import android.os.Looper;

import com.mardomsara.social.helpers.TimeUtil;

class CommandFrame {
	private ErrorCallback error;

	private SuccessCallback successCallback;
	private long timeoutAtMs = TimeUtil.getTimeMs() + 5000;//5second timeout
	private long clientCallId = TimeUtil.getTimeNano();
	Status status = Status.NOTHING;

	CommandFrame(SuccessCallback success, ErrorCallback error, long clientCallId) {
		this.successCallback = success;
		this.error = error;
		this.clientCallId = clientCallId;

		setDelayer();
	}

	void setDelayer(){
		getHandler().postDelayed(()->{
			if(status == Status.NOTHING){
				if(error != null){
					error.onError(null);
				}
			}
			status= Status.ERROR;
			Pipe.CommandFrameMap.remove(clientCallId);
		},timeoutAtMs);
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