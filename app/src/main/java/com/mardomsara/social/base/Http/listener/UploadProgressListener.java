package com.mardomsara.social.base.Http.listener;

public interface UploadProgressListener {
	void onUploadProgress(long bytesRead, long contentLength, boolean done);
}