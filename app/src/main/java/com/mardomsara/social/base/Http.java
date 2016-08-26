package com.mardomsara.social.base;

import android.util.Log;

import com.mardomsara.social.helpers.AppUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hugo.weaving.DebugLog;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * Created by Hamid on 3/4/2016.
 */
public class Http {
    private static final OkHttpClient client = new OkHttpClient();

    public static String simpleGet(String path){
        Result r = get(path);
        return r.data;
    }

    public static Result get(String path){
        Req rq = new Req();
//        rq._finalUrl = AppUtil.toUrl(_getStrWithParams(path,rq));
        Result r = masterSend(rq);
        return r;
    }

    //deprecated
    public static Result get(Req rq){
//        Req rq = new Req();
//        rq._finalUrl = AppUtil.toUrl(_getStrWithParams(rq.absPath,rq));
        Result r = masterSend(rq);
        return r;
    }

    //deprecated
    public static Result post(String path){
        Req rq = new Req();
        rq.absPath = path;
//        rq._finalUrl = AppUtil.toUrl(_getStrWithParams(path,rq));
        Result r = masterSendPost(rq);
        return r;
    }

    @DebugLog
    public static Result download(Req rq){
//        rq._finalUrl = AppUtil.toUrl(_getStrWithParams(rq.absPath,rq));
        Request request = new Request.Builder()
                .url(rq.buildFinalUrlFromPath())
                .build();

        Result res = _doSend(request,false);
        try {
            res.bytes = res.response.body().bytes();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("download",res.response.toString());
//            Log.d("download",res.response.body());
        }
        return  res;
    }

    public static Result masterSend(Req req){
        Request request = new Request.Builder()
                .url(req.buildFinalUrlFromPath())
                .method(req.method, null)
                .headers(req.getToHeaders())
                .build();
        return _doSend(request,true);
    }

    public static Result masterSendPost(Req req){
        Request request = new Request.Builder()
                .url(req.buildFinalUrlFromPath())
//                .method(req.method, null)
                .headers(req.getToHeaders())
                .post(req.getFormParams())
                .build();
        return _doSend(request,true);
    }

    public static Result uploadFile(Req req){
        if(req.file == null){//
            return new Result();
        }
        RequestBody dataToSend = null;
//        MultipartBuilder b = new M
        MultipartBody.Builder b = new MultipartBody.Builder();
        req.buildOthersFormParams(b);
        dataToSend = RequestBody.create(OkhttpMimeTypes.MEDIA_TYPE_FILE_GENERAL, req.file);
        b.addFormDataPart("file",req.file.getName(),dataToSend);
        b.setType(MultipartBody.FORM);

        URL url = req.buildFinalUrlFromPath();
        Request request = new Request.Builder()
                .url(url)
                .headers(req.getToHeaders())
                .post(b.build())
                .build();
        AppUtil.log("Url size: "+ url.toString().length());
        return _doSend(request,true);
    }

    public static void downloadFile(String address, String filePath){
        downloadFile(address, filePath,null , null);
    }

    public static void downloadFile(String address, String filePath, Runnable callBack , Runnable errBack){
        Req req = new Req();
        req._finalUrl = AppUtil.toUrl(address);

        Request request = new Request.Builder()
                .url(req._finalUrl)
                .headers(req.getToHeaders())
                .get()
                .build();
        Result res = _doSend(request,false);
        File downloadedFile = new File(filePath);

        BufferedSink sink = null;
        try {
            byte[] bs= res.response.body().bytes();
            FileUtils.writeByteArrayToFile(downloadedFile,bs);
            if(callBack != null) callBack.run();

            //TODO: the below way is slow but more correct fix it
//            sink = Okio.buffer(Okio.sink(downloadedFile));
//            sink.writeAll(res.response.body().source());
//            sink.close();

        } catch (Exception e) {
            e.printStackTrace();
            if(errBack != null) errBack.run();
        }

    }

    @DebugLog
    private static Result _doSend(Request request, boolean setBody){
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
            if(res.data.indexOf("Status") >= 0 ){
                res.ok = true;
            }
            res.response = response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  res;
    }

    private static String _getStrWithParams(String path, Req rq){
        return path+"?"+rq.getUrlParams();
    }

    public static Map<String, String> defaultHeaders(){
        Map<String, String> h = new HashMap();
        h.put("X-ms-client","1");
        return  h;
    }
    public static Map<String, String> _getDefualturlParams(){
        Map<String, String> h = new HashMap();
        h.put("session","14dsad");
        h.put("user_id","6");
        return  h;
    }

//    public static _getDefultQueue(){
//        client.newCall()
//    }

    public static class Req {
        public String absPath;
        public URL _finalUrl;//todo: make this private
        public String method = "GET";
        public Map<String, String> headers = defaultHeaders();
        public Map<String, String> urlParams = new HashMap<>();
        public Map<String, String> form = new HashMap<>();
        private Map<String, String[]> headersMulti;//??
//        public File[] files;
        public File file;

        public Headers getToHeaders(){
            Headers.Builder hs = new Headers.Builder();
            for(String k: headers.keySet() ){
                hs.add(k,headers.get(k));
            }
            return hs.build();
        }

        public RequestBody getFormParams(){
            FormBody.Builder fb =new FormBody.Builder() ;
            for(String k: form.keySet() ){
                fb.add(k,form.get(k));
            }
            return fb.add("asd","eeeeee")
                    .add("asdsa","werwe")
                    .build();
        }

        public RequestBody buildOthersFormParams(MultipartBody.Builder b){
//            FormBody.Builder fb =new FormBody.Builder() ;
            for(String k: form.keySet() ){
                b.addFormDataPart(k,form.get(k));
            }
            return b.addFormDataPart("asd","eeeeee")
                    .addFormDataPart("asdsa","werwe")
                    .build();
        }
        public String getUrlParams(){
            List<String> ls = new ArrayList<>();
            for (String k : urlParams.keySet()){
                ls.add(""+k+"="+urlParams.get(k));
            }

            Map<String, String> defs = Http._getDefualturlParams();
            for (String k : defs.keySet()){
                ls.add(""+k+"="+defs.get(k));
            }
            //todo: kind of urlencode ?
            return StringUtils.join(ls.toArray(), "&");
        }

        public URL buildFinalUrlFromPath(){
           String urlLast = StringUtils.indexOf(absPath, "?")<0 ? absPath+"?"+getUrlParams() : absPath+"&"+getUrlParams();
            return _finalUrl = AppUtil.toUrl(urlLast);
        }
    }

    public static class  Result{
        public boolean ok = false;
        public String data = "";
        public Response response;
        public byte[] bytes;
    }


    void _play(){
        /*AndroidNetworking.post("")
                .addBodyParameter("","")
                .setUserAgent("")
                .build();

*/
    }

}

//    //depreceated
//
//    public static String get2(String absPath){
//        Req rq = new Req();
////        rq._finalUrl = toUrl(absPath);
//        Request request = new Request.Builder()
//                ._finalUrl(absPath)
//                .build();
//
//        String response = "";
//        Response response = null;
//        try {
//            response = client.newCall(request).execute();
////            client.
//            response = response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (!response.isSuccessful()){
//
//        };
//
//        return response;
//    }
//
//    public static String masterSend(){
//        Request request = new Request.Builder()
//                ._finalUrl("https://publicobject.com/helloworld.txt")
//                .build();
//
//        Response response = null;
//        try {
//            response = client.newCall(request).execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (!response.isSuccessful()){
//
//        };
//
//        return  "";
//    }