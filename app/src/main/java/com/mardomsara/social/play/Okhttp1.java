package com.mardomsara.social.play;

import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.HttpBaseProtocol;
import com.mardomsara.social.json.UserListFollow;

//
////import com.squareup.okhttp.Callback;
//
//import java.io.IOException;
//
//import okhttp3.Callback;
//import okhttp3.Headers;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
///**
// * Created by Hamid on 2/18/2016.
// */
public class Okhttp1 {
    void run(){
    String s = "asd";
//      Class c =  s.getClass();
//      HttpBaseProtocol<UserListFollow> jj= JsonUtil.fromJson("adas");
//        jj.Payload.AmIFollowing = false;
    }
}
//    private final OkHttpClient client = new OkHttpClient();
//
//    public void run() throws Exception {
//        Request request = new Request.Builder()
//                ._finalUrl("http://publicobject.com/helloworld.txt")
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override public void onFailure(Request request, IOException throwable) {
//                throwable.printStackTrace();
//            }
//
//            @Override public void onResponse(Response response) throws IOException {
//                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//                Headers responseHeaders = response.headers();
//                for (int i = 0; i < responseHeaders.size(); i++) {
//                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//                }
//
//                System.out.println(response.body().string());
//            }
//        });
//    }
//}
