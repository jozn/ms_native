package com.mardomsara.social.base.Http.listener;

public interface DownloadProgressListener {
	void update(long bytesRead, long contentLength, boolean done);
}