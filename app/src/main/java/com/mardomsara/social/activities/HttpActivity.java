package com.mardomsara.social.activities;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.models.UserListFollowJson;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;

public class HttpActivity extends AppActivity {
    TextView mTextView;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        runOnUiThread();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        Fresco.initialize(this);

        //// Request a string response from the provided URL.
        Log.d("MS", "HttpActivity");
        mTextView = (TextView) findViewById(R.id.textView2);
//        final TextView status = (TextView) findViewById(R.id.status2);
        //final LinearLayout ll = (LinearLayout) findViewById(R.id.layout_activity);
//        RecyclerView
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="http://192.168.0.10:5000/followings?username=atash2174";
//        StringRequest stringRequest = new AppHttpRequest( url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
//                       // mTextView.setText("Response is: "+ response.substring(0,400));
//                        Type fooType = new TypeToken<HttpResponseJsonProtocol<UserListFollowJson>>() {}.getType();
//                        HttpResponseJsonProtocol<UserListFollowJson> res = new Gson().fromJson(response.toString(), fooType);
//                        ListView ls = (ListView) findViewById(R.id.list3);
//                        ArrayList<UserListFollowJson> list = new ArrayList<UserListFollowJson>(){};
//                        UserListFollowJson[] list2 = new UserListFollowJson[res.Payload.length];
//                        for (int i=0;i<res.Payload.length;i++){
//                            list2[i] = res.Payload[i];
//                        }
//                        for (UserListFollowJson r: res.Payload){
//                            list.add(r);
//                        }
//                        Log.d("MS",res.Payload.toString());
//                        ls.setAdapter(new MyRowAdaptor(HttpActivity.this, 0, 0, res.Payload));
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("MS", error.toString());
//                try {
//                    mTextView.setText(error.toString());
//                }catch (Exception e){
//                   // mTextView.setText("Exesption: ");
//                }
//            }
//        });
////        stringRequest
//// Add the request to the RequestQueue.
//        queue.add(stringRequest);
    }

    public class MyRowAdaptor extends ArrayAdapter<UserListFollowJson> {
        UserListFollowJson[] str ;
        final Activity ctx;
        View.OnClickListener ev ;
        public MyRowAdaptor(Activity ctx1,int layouy, int textView ,UserListFollowJson[] srows){
//            super(ctx1,layouy,textView,srows);
            super(ctx1,R.layout.list_user_follow_row,R.id.user,srows);
            str = srows;
            ctx = ctx1;
            ev = (new View.OnClickListener() {
                @Override
                public void onClick(View e) {
                    Toast.makeText(ctx, "Event:: " +e.toString(),Toast.LENGTH_LONG).show();
                    Log.d("MS-event",e.toString());mTextView.setText(e.toString());
                }
            });

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            final UserListFollowJson s = str[position];
            Log.d("LIST",position +" "+ parent);
            View v = convertView;
            if(v == null){
                v =  ctx.getLayoutInflater().inflate(R.layout.list_user_follow_row,null,false);
            }else{
                //TextView t = (TextView) v.findViewById(R.id.user);
            }
            TextView t = (TextView) v.findViewById(R.id.user);
            t.setText(s.FullName);

            final View v2 = v;
            TextView t2 = (TextView) v.findViewById(R.id.textView2);
            t2.setOnClickListener(ev);
//            t2.setOnClickListener((e) -> {
//                Toast.makeText(context, "Event:: " +e.toString(),Toast.LENGTH_LONG).show();
//                Log.d("MS-event",e.toString());mTextView.setText(e.toString());
//                v2.setBackgroundColor(0xa2a567);
//                });
            Uri imageUri = Uri.parse("http://localhost:5000/"+s.AvatarSrc);
            SimpleDraweeView draweeView = (SimpleDraweeView) v.findViewById(R.id.my_image_view);
            draweeView.setImageURI(imageUri);

//            v.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    Toast.makeText(context, "You Clicked " + s.toString(), Toast.LENGTH_LONG).show();
//                }
//            });
            return  v;
        }
    }

}

//StringRequest stringRequest = new AppHttpRequest( _finalUrl,
//        new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                // Display the first 500 characters of the response string.
//                // mTextView.setText("Response is: "+ response.substring(0,400));
//                Type fooType = new TypeToken<HttpResponseJsonProtocol<UserListFollowJson>>() {}.getType();
//                HttpResponseJsonProtocol<UserListFollowJson> response = new Gson().fromJson(response.toString(),fooType);
//                for(UserListFollowJson s :response.UserListFollow ){
//                    Log.d("MS", s.FullName);
//                    TextView txt = new TextView(getApplicationContext());
//                    txt.setText(s.FullName);
//
//                    ll.addView(txt);
//                }
//                GsonBuilder builder = new GsonBuilder();
//                String jss=  builder.setPrettyPrinting().create().toJson(response);
//                mTextView.setText(jss);
//            }
//        }, new Response.ErrorListener() {
//    @Override
//    public void onErrorResponse(VolleyError error) {
//        Log.d("MS", error.toString());
//        try {
//            mTextView.setText(error.toString());
//        }catch (Exception e){
//            mTextView.setText("Exesption: ");
//        }
//    }
//});
