package com.mardomsara.social.models_old.interfaces;

public interface MessageProgressListener {
	void onProgress(long bytesRead, long contentLength, boolean done);
	void onCancel();
	void onStatusChanged();//cancel, finished, error
}