package com.mardomsara.social.helpers;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.mardomsara.social.R;

/**
 * Created by Hamid on 5/9/2016.
 */
public class NotificationUtil {

    /**
     * use for make local notification from application
     *
     * @param mContext
     * @param title    for the Notification
     * @param message  for the notification
     * @param mIntent  for open activity to open on touch of notification
     */
    @SuppressLint("NewApi")
    @SuppressWarnings({"static-access"})
    public static void sendLocatNotification(Context mContext, String title,
                                             String message, Intent mIntent) {
        System.out.println("called: " + title + " : " + message);
        int appIconResId = 0;
        PendingIntent pIntent = null;
        if (mIntent != null)
            pIntent = PendingIntent.getActivity(mContext, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        final PackageManager pm = mContext.getPackageManager();
        String packageName = mContext.getPackageName();
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = pm.getApplicationInfo(packageName,
                    PackageManager.GET_META_DATA);
            appIconResId = applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // Notification notification = new Notification.Builder(mContext)
        // .setSmallIcon(appIconResId).setWhen(System.currentTimeMillis())
        // .setContentTitle(title).setContentText(message)
        // .setContentIntent(pIntent).getNotification();

        Notification notification;
        if (mIntent == null) {
            notification = new Notification.Builder(mContext)
                    .setSmallIcon(appIconResId).setWhen(System.currentTimeMillis())
                    .setContentTitle(message)
                    .setStyle(new Notification.BigTextStyle().bigText(message))
                    .setAutoCancel(true)
                    .setContentText(message)
                    .setContentIntent(PendingIntent.getActivity(mContext, 0, new Intent(), 0))
                    .getNotification();

        } else {
            notification = new Notification.Builder(mContext)
                    .setSmallIcon(appIconResId).setWhen(System.currentTimeMillis())
                    .setContentTitle(message)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setStyle(new Notification.BigTextStyle().bigText(message))
                    .setContentIntent(pIntent).getNotification();
        }
        // Remove the notification on click
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        // Play default notification sound
        notification.defaults |= Notification.DEFAULT_SOUND;

        // Vibrate if vibrate is enabled
        notification.defaults |= Notification.DEFAULT_VIBRATE;

        NotificationManager manager = (NotificationManager) mContext
                .getSystemService(mContext.NOTIFICATION_SERVICE);
        // manager.notify(0, notification);
        manager.notify(R.string.app_name, notification);
    }

}
