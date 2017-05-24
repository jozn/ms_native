package com.mardomsara.social.pipe_pb;

import com.mardomsara.social.helpers.TimeUtil;

class CallRespondCallback {
	public PipeCallBack success;
	public Runnable error;
	public Runnable reachedServer;
	long timeoutAtMs = TimeUtil.getTimeMs() + 5000;//5second timeout
	long clientCallId = TimeUtil.getTimeNano();

	String responseClass;

	CallRespondCallback(PipeCallBack success, Runnable error, long clientCallId) {
		this.success = success;
		this.error = error;
		this.clientCallId = clientCallId;
	}

	CallRespondCallback(Runnable success, Runnable error, long clientCallId) {
		this.reachedServer = success;
		this.error = error;
		this.clientCallId = clientCallId;
	}

}