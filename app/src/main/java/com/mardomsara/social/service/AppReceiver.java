package com.mardomsara.social.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.common.utils.Common;
import com.mardomsara.social.R;
import com.mardomsara.social.activities.MainAppActivity;

import java.util.Date;

public class AppReceiver extends BroadcastReceiver {
    public AppReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String act = intent.getAction();
        Log.d("reciver", "recived: " + act);
        Toast.makeText(context, "recived: " + act, Toast.LENGTH_LONG).show();
//        Intent int2 = new Intent(MainAppActivity.class);
        Common.sendLocatNotification(context, "Recive broadcast", act, null);
        int num  =(int)new Date().getTime();
       Notification notification = new Notification.Builder(context)
                .setSubText("subbb"+(int)new Date().getTime())
                .setNumber((int)new Date().getTime())
                .setContentText("cont " + act)
               .setContentTitle("titl"+context.getPackageResourcePath()+(int)new Date().getTime())
               // .setContentInfo("info " + context.getPackageName())
               .setAutoCancel(false)
               .setSmallIcon(R.drawable.ic_rotate_right)

               .getNotification();

        NotificationManager manager = (NotificationManager) context
                .getSystemService(context.NOTIFICATION_SERVICE);
        // manager.notify(0, notification);
//        manager.notify(R.string.app_name, notification);
        manager.notify("مردم",num, notification);
//        manager.notify()

        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
