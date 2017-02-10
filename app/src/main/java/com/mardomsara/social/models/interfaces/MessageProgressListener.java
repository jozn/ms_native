package com.mardomsara.social.models.interfaces;

public interface MessageProgressListener {
	void onProgress(long bytesRead, long contentLength, boolean done);
}