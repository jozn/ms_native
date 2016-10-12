package com.mardomsara.social.pipe;

import com.mardomsara.social.helpers.TimeUtil;

/**
 * Created by Hamid on 10/5/2016.
 */
public class CallRespondCallback {
	public Runnable success;
	public Runnable error;
	public long timeoutAtMs = TimeUtil.getTimeMs() + 5000;//5second timeout
	public long clientCallId;
	Call call;

	private CallRespondCallback(long clientCallId, Runnable success) {
		this.clientCallId = clientCallId;
		this.success = success;
	}

	public CallRespondCallback(Call call, Runnable success, Runnable error) {
		this.clientCallId = call.ClientCallId;
		this.call = call;
		this.success = success;
		this.error = error;
	}
}

/*type callRespondCallback struct {
	success         func()
	error          func()
	tiomeoutAt   int64 // time second // now + 10 sec
	clientCallId int64 // time nano
}*/
