package com.mardomsara.social.base.Http;

import com.mardomsara.social.base.Http.listener.CallBack;
import com.mardomsara.social.base.Http.listener.DownloadProgressListener;
import com.mardomsara.social.base.Http.listener.UploadProgressListener;
import com.mardomsara.social.helpers.AndroidUtil;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Request;
import okio.BufferedSink;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Req<T> {
    Action action = Action.GET;
    String absUrl;
    URL _finalUrl;//todo: make this private
    String method = "GET";
    Map<String, String> headers = Http.defaultHeaders();
    Map<String, String> urlQueryParams = new HashMap<>();
    Map<String, String> form = new HashMap<>();
    private Map<String, String[]> headersMulti;//??
    //        public File[] files;

    //// For Uploads
    File file;
    String fileDownloadDest;

    /// For Progress
    DownloadProgressListener downloadProgress;
    UploadProgressListener uploadProgress;

	Request okHttpRequset;
	Call okHttpCall;

    public Req(Action action, String absUrl) {
        this.action = action;
        this.absUrl =absUrl;
    }

    //for respnse
    Class jsonClass;

    public Req setQueryParam(String key, String value){
        urlQueryParams.put(key,value);
        return this;
    }
    public Req setQueryParam(String key, Object valueNum){
        urlQueryParams.put(key, valueNum.toString());
        return this;
    }

    public Req setFormParam(String key, String value){
        form.put(key,value);
        return this;
    }

    public Req setHeader(String key, String value){
        headers.put(key,value);
        return this;
    }

    /*public Req JsonInto(Class cls){
        jsonClass = cls;
        return this;
    }*/

    public Req setDownloadProgress (DownloadProgressListener listener){
        downloadProgress = listener;
        return this;
    }

    public Req  setUploadProgress (UploadProgressListener listener){
        uploadProgress = listener;
        return this;
    }

	public void cancel(){
		if(okHttpCall != null){
			okHttpCall.cancel();
		}
	}

    //generics dosn't work, just set for futuer maybe
    public <K> Req doAsync(CallBack<K> callBack){
        if(action == Action.DOWNLOAD){
            throw new IllegalArgumentException("In Http2 for uploads actions doAsyncDownload(...) must be called in doAsyncDownload(), not doAsync(...)");
        }
        AndroidUtil.runInBackground(()->{
            Result res = Sender.Send(this);

            if(callBack != null){
                callBack.callback(res);
            }
        });
		return this;
    }

    //
    public Req doAsyncDownload(CallBack callBack){
        if(action != Action.DOWNLOAD){
            throw new IllegalArgumentException("In Http2 doAsyncDownload() must be called just fro uploads.");
        }
        AndroidUtil.runInBackground(()->{
            Result res = Sender.Send(this);

            File downloadedFile = new File(fileDownloadDest);

            BufferedSink sink = null;
            try {
                byte[] bs= res.response.body().bytes();
                FileUtils.writeByteArrayToFile(downloadedFile,bs);
                //TODO: the below way is slow but more correct fix it
//            sink = Okio.buffer(Okio.sink(downloadedFile));
//            sink.writeAll(res.response.body().source());
//            sink.close();
                res.ok = true;
            } catch (Exception e) {
                res.ok = false;
                e.printStackTrace();
            }

            if(callBack != null){
                callBack.callback(res);
            }
        });
		return this;
    }

}
