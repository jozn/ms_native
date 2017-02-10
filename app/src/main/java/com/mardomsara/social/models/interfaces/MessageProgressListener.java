package com.mardomsara.social.models.interfaces;

public interface MessageProgressListener {
	void onProgress(long bytesRead, long contentLength, boolean done);
	void onCancel();
	void onStatusChanged();//cancel, finished, error
}