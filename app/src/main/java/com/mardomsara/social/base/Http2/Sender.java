package com.mardomsara.social.base.Http2;

import com.mardomsara.social.base.OkhttpMimeTypes;
import com.mardomsara.social.helpers.AppUtil;

import java.io.IOException;
import java.net.URL;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Sender<T> {

    static final OkHttpClient client = new OkHttpClient();

    public static Result Send(Req req){
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
            RequestBody dataToSend = null;
            MultipartBody.Builder b = new MultipartBody.Builder();
            rb.post(Util.buildOthersFormParamsForUpload(b,req.form));

            dataToSend = RequestBody.create(OkhttpMimeTypes.MEDIA_TYPE_FILE_GENERAL, req.file);
            b.addFormDataPart("file",req.file.getName(),dataToSend);
            b.setType(MultipartBody.FORM);

            rb.post(b.build());
        }

        if(req.action == Action.UPLOAD) {
            RequestBody dataToSend = null;
            MultipartBody.Builder b = new MultipartBody.Builder();
            rb.post(Util.buildOthersFormParamsForUpload(b,req.form));

            dataToSend = RequestBody.create(OkhttpMimeTypes.MEDIA_TYPE_FILE_GENERAL, req.file);
            b.addFormDataPart("file",req.file.getName(),dataToSend);
            b.setType(MultipartBody.FORM);

            rb.post(b.build());
        }

        if(req.action == Action.DOWNLOAD) {
            rb.get();
            Request request = rb.build();
            Result  res = _doSend(request,false);//don't read result to strings
            return res;
        }

        Request request = rb.build();

        Result  res = _doSend(request,true);
        return res;
    }

    static Result _doSend(Request request, boolean setBody){
        AppUtil.log("sending Http to :"+request.url().toString());
        Response response = null;
        String body= "";
        Result res = new Result();
        try {
            response = client.newCall(request).execute();
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




}
