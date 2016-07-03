package com.mardomsara.social.events.from_server;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.mardomsara.social.App;
import com.mardomsara.social.app.Singletons;
import com.mardomsara.social.base.NetEventHandler;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.UserListFollow;

/**
 * Created by Hamid on 3/28/2016.
 */
public class HelloCommand {

    public static void time(String data){
//        Common.showAlertDialog(App.context,"HelloCommand",data,true);
        Log.d("WS", "Thread: " + Thread.currentThread().getName() + " HelloCommand onClose");
        new  AsyncTask<Void, Void, Void>() {

            protected Void doInBackground(Void... param) {
                //Do some work
                return null;
            }

            protected void onPostExecute(Void param) {
                //Print Toast or open dialog
                UserListFollow bl = Singletons.getGson().fromJson(data,UserListFollow.class);
                Toast.makeText(App.context, "" + bl.AvatarSrc,Toast.LENGTH_LONG).show();
//                Log.d("WS", "Thread: " + Thread.currentThread().getName() + " data "+ data);
                AppUtil.log("data"+data);
            }
        }.executeOnExecutor(Singletons.getThreadPool());

    }

    public static NetEventHandler addMesage = (data)->{
        Log.d("WS", "Thread: " + Thread.currentThread().getName() + " HelloCommand onClose");
        new  AsyncTask<Void, Void, Void>() {

            protected Void doInBackground(Void... param) {
                //Do some work
                return null;
            }

            protected void onPostExecute(Void param) {
                //Print Toast or open dialog
                UserListFollow bl = Singletons.getGson().fromJson(data,UserListFollow.class);
                Toast.makeText(App.context, "Hamid " + bl.AvatarSrc,Toast.LENGTH_LONG).show();
//                Log.d("WS", "Thread: " + Thread.currentThread().getName() + " data "+ data);
                AppUtil.log("data"+data);
            }
        }.executeOnExecutor(Singletons.getThreadPool());
    };

    public static NetEventHandler addMesage2 = new NetEventHandler(){

        @Override
        public void handle(String data) {
                Log.d("WS", "Thread: " + Thread.currentThread().getName() + " HelloCommand onClose");
                new  AsyncTask<Void, Void, Void>() {

                    protected Void doInBackground(Void... param) {
                        //Do some work
                        return null;
                    }

                    protected void onPostExecute(Void param) {
                        //Print Toast or open dialog
                        UserListFollow bl = Singletons.getGson().fromJson(data,UserListFollow.class);
                        Toast.makeText(App.context, "Hamid " + bl.AvatarSrc,Toast.LENGTH_LONG).show();
//                Log.d("WS", "Thread: " + Thread.currentThread().getName() + " data "+ data);
                        AppUtil.log("data"+data);
                    }
                }.executeOnExecutor(Singletons.getThreadPool());
            };

    } ;
}
