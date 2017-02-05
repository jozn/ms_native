package com.mardomsara.social.base.Http.listener;

public interface DownloadProgressListener {
	void onDownloadProgress(long bytesRead, long contentLength, boolean done);
}