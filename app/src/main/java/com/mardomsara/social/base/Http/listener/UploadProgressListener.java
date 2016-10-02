package com.mardomsara.social.base.Http.listener;

public interface UploadProgressListener {
	void update(long bytesRead, long contentLength, boolean done);
}