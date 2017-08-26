package com.mardomsara.social.pipe;

/**
 * Created by Hamid on 8/22/2017.
 */
public class ErrorReason {

	private Reason reason;

	public ErrorReason(Reason reason) {
		this.reason = reason;
	}

	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public enum  Reason{
		NO_CONNECTIONS,
		TIMEOUT,
		WRONG_RESPONE,
	}
}

