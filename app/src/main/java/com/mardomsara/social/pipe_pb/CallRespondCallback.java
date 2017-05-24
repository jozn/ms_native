package com.mardomsara.social.pipe_pb;

import com.mardomsara.social.helpers.TimeUtil;

/**
 * Created by Hamid on 10/5/2016.
 */
class CallRespondCallback {
	public CommandCallBack success;
	public Runnable error;
	long timeoutAtMs = TimeUtil.getTimeMs() + 5000;//5second timeout
	long clientCallId = TimeUtil.getTimeNano();

	CallRespondCallback(CommandCallBack success, Runnable error) {
		this.success = success;
		this.error = error;
	}

	public CallRespondCallback(CommandCallBack success, Runnable error, long clientCallId) {
		this.success = success;
		this.error = error;
		this.clientCallId = clientCallId;
	}
}

/*type callRespondCallback struct {
	success         func()
	error          func()
	tiomeoutAt   int64 // time second // now + 10 sec
	clientCallId int64 // time nano
}*/
