package com.mardomsara.social.base.Http.listener;

public interface ProgressListener {
	void update(long bytesRead, long contentLength, boolean done);
}