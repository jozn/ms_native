package com.mardomsara.social.play;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.common.utils.Common;
import com.mardomsara.social.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//import butterknife.Bind;
//import butterknife.OnClick;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttp2Activity extends AppCompatActivity {

    @Bind(R.id.button2) Button btn2;
//    @Bind(R.id.button) Button btn;
//    @Bind(R.id.text) TextView text;
     Button btn;
     TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp2);

        btn = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });

        ButterKnife.bind(this);
    }


    void load(){
        URL url = null;
        try {
            url = new URL("http://headers.jsontest.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Request r = new Request.Builder().addHeader("asd","vvvvasdasd").get().url(url).build();
        OkHttpClient client = new OkHttpClient();

        client.newCall(r).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
             //   text.setText(call.request().toString());
                Common.showAlertDialog(getBaseContext(),"err",e.toString(),false);
            }

            @Override
            public void onResponse(Call call,final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String s = "";
                        try {
                            Common.showAlertDialog(Okhttp2Activity.this,"err",response.body().toString(),false);
                            s = response.body().string();
                            Log.d("http", "" + s.length());
                            text.setText(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        });
    }

    @OnClick(R.id.button2)
    public void run()  {
        final Request request = new Request.Builder()
//                ._finalUrl("https://api.github.com/repos/square/okhttp/issues")
                .url("http://jsonplaceholder.typicode.com/posts")
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                .addHeader("Accept", "application/vnd.github.v3+json")
                .build();

        final OkHttpClient client = new OkHttpClient();


        new AsyncTask<Integer, Integer, Integer>() {
            Response response ;
            String st;
            protected Integer doInBackground(Integer... urls) {
                int count = urls.length;
                long totalSize = 1110;
                try{
                    //Thread.sleep(15000);
                }catch (Exception e){

                }
                Log.d("ms","Async !!!!!!!!!!!");
                long x = (long)urls[0];
                try {
                    response = client.newCall(request).execute();
                    st = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return urls[0];// urls[0];
            }

            protected void onProgressUpdate(Integer... progress) {
//        setProgressPercent(progress[0]);
                text.setText(st);
            }

            protected void onPostExecute(Integer result) {
                text.setText(""+st);
            }
        }.execute(560);

//        new AsyncTask<String,String,String>(){
//
//            @Override
//            protected String doInBackground(Object[] params) {
//                try {
//
//                    response = client.newCall(request).execute();
//                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return "";
//            }
//        }.execute("");


//        System.out.println("Server: " + response[0].header("Server"));
//        System.out.println("Date: " + response[0].header("Date"));
//        System.out.println("Vary: " + response[0].headers("Vary"));
    }


}
