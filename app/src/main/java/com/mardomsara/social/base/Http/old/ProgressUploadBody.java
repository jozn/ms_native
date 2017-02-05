package com.mardomsara.social.base.Http.old;

import com.mardomsara.social.base.Http.listener.UploadProgressListener;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
@Deprecated
public class ProgressUploadBody extends ResponseBody {

    private final ResponseBody responseBody;
	//ME: for potential memory leak
    private final WeakReference<UploadProgressListener> weakReference;// = new WeakReference<UploadProgressListener>();
//    private final UploadProgressListener progressListener ;
    private BufferedSource bufferedSource;

    public ProgressUploadBody(ResponseBody responseBody, UploadProgressListener progressListener) {
      this.responseBody = responseBody;
//      this.progressListener = progressListener;
	this.weakReference = new WeakReference<UploadProgressListener>(progressListener);
    }

    @Override
    public MediaType contentType() {
      return responseBody.contentType();
    }

    @Override
    public long contentLength() {
      return responseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
      if (bufferedSource == null) {
        bufferedSource = Okio.buffer(source(responseBody.source()));
      }
      return bufferedSource;
    }

    private Source source(Source source) {
      return new ForwardingSource(source) {
		  UploadProgressListener progressListener;
        long totalBytesRead = 0L;

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
          long bytesRead = super.read(sink, byteCount);
          // read() returns the number of bytes read, or -1 if this source is exhausted.
          totalBytesRead += bytesRead != -1 ? bytesRead : 0;
			progressListener = weakReference.get();
			if( progressListener!= null){
				progressListener.onUploadProgress(totalBytesRead, responseBody.contentLength(), bytesRead == -1);
			}
          return bytesRead;
        }
      };
    }
  }