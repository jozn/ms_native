package com.mardomsara.social.base.Http;

import com.mardomsara.social.base.Http.listener.DownloadProgressListener;
import com.mardomsara.social.base.Http.listener.ProgressListener;
import com.mardomsara.social.base.Http.listener.UploadProgressListener;
import com.mardomsara.social.base.Http.old.ProgressUploadBody;
import com.mardomsara.social.base.OkhttpMimeTypes;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Sender<T> {

    static final OkHttpClient defualtClient = getDefulatOkHttpClient();//new OkHttpClient();

    public static Result Send(Req req){
		OkHttpClient okHttpClient = defualtClient;

        Request.Builder rb = new Request.Builder();
        //common: headers, url query params
        rb.url(Util.buildFinalUrlFromPath(req.absUrl,req.urlQueryParams))
                .headers(Util.headersToOkHttpHeaders(req.headers));

        ////////////////////Methods funcs /////////////////////////

        if(req.action == Action.GET) {
            rb.get();
        }

        if(req.action == Action.POST) {
            rb.post(Util.formsToOkHttpFormParams(req.form));
        }

        if(req.action == Action.UPLOAD) {
			/*if(req.uploadProgress != null){
				OkHttpClient.Builder upClientBuilder = defualtClient.newBuilder();
				addUploadInterceptor(upClientBuilder,req.uploadProgress);
				okHttpClient = upClientBuilder.build();
			}*/
            RequestBody dataToSend = null;
            MultipartBody.Builder b = new MultipartBody.Builder();
            rb.post(Util.buildOthersFormParamsForUpload(b,req.form));

            dataToSend = RequestBody.create(OkhttpMimeTypes.MEDIA_TYPE_FILE_GENERAL, req.file);
            b.addFormDataPart("file",req.file.getName(),dataToSend);
            b.setType(MultipartBody.FORM);
			RequestBody body = b.build();
			if(req.uploadProgress != null){
				body = new ProgressRequestBody(body,req.uploadProgress);
			}
            rb.post(body);
//            rb.post(b.build());
        }

        if(req.action == Action.DOWNLOAD) {
			if(req.downloadProgress != null){
				OkHttpClient.Builder downloadClientBuilder = defualtClient.newBuilder();
				addDownloadInterceptor(downloadClientBuilder,req.downloadProgress);
				okHttpClient = downloadClientBuilder.build();
			}
            rb.get();
            Request request = rb.build();
            Result  res = _doSend(request,false,okHttpClient,req);//don't read result to strings
            return res;
        }

        Request request = rb.build();

        Result  res = _doSend(request,true,okHttpClient,req);
        return res;
    }

    static Result _doSend(Request request, boolean setBody, OkHttpClient client,Req req ){
        AppUtil.log("sending Http to :"+request.url().toString());
        Response response = null;
        String body= "";
        Result res = new Result();
        try {
            Call call = client.newCall(request);
			req.okHttpCall = call;
            response = call.execute();
            if(setBody){
                body = response.body().string();
            }
            res.data = body;
            /*if(res.data.indexOf("Status") >= 0 ){
                res.ok = true;
            }*/
            if(response.isSuccessful()){
                res.ok = true;
            }
            res.response = response;
        } catch (IOException e) {
            res.ok = false;
            e.printStackTrace();
        }
        return  res;
    }


	static final ProgressListener progressListener = new ProgressListener() {
		@Override public void update(long bytesRead, long contentLength, boolean done) {
			AndroidUtil.runInUi(()->{
				System.out.println(bytesRead);
				System.out.println(contentLength);
				System.out.println(done);
				System.out.format("%d%% done\n", (100 * bytesRead) / contentLength);

			});
		}
	};


	static OkHttpClient getDefulatOkHttpClient(){
		OkHttpClient client = new OkHttpClient.Builder()
			/*.addNetworkInterceptor(new Interceptor() {
				@Override public Response intercept(Chain chain) throws IOException {
					Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
						.body(new ProgressDownloadBody(originalResponse.body(), progressListener))
						.build();
				}
			})*/
			.build();
		return client;
	}

	static void addDownloadInterceptor(OkHttpClient.Builder builder, DownloadProgressListener listener){
		builder.addNetworkInterceptor(new Interceptor() {
				@Override public Response intercept(Chain chain) throws IOException {
					Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
						.body(new ProgressDownloadBody(originalResponse.body(), listener))
						.build();
				}
			});
	}

	static void addUploadInterceptor(OkHttpClient.Builder builder, UploadProgressListener listener){
		builder.addNetworkInterceptor(new Interceptor() {
			@Override public Response intercept(Chain chain) throws IOException {
				Response originalResponse = chain.proceed(chain.request());
				return originalResponse.newBuilder()
					.body(new ProgressUploadBody(originalResponse.body(), listener))
					.build();
			}
		});
	}



}
