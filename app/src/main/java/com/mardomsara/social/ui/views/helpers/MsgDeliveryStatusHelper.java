package com.mardomsara.social.ui.views.helpers;

import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 6/6/2016.
 */
public class MsgDeliveryStatusHelper {
    static String _wating = "\uf402"; //ion-ios-clock-outline
    static String _recived_server = "\uf383";//ion-android-done
    static String _recived_peer = "\uf382";//ion-android-done-all
    static String _seen_peer = "\uf382";//ion-android-done-all
    static String seenColor = "";
    static String geryColor = "";

    public static final int Msg_Wainting = 1 ;
    public static final int Msg_Recived_Server = 2 ;
    public static final int Msg_Recived_Peer = 3 ;
    public static final int Msg_Seen_Peer = 4 ;


    public static void forMsg(MessagesTable msg, TextView textView){
        if(msg == null || textView == null) return;
        String icon =_wating;
        int color = R.color.light_gery_dark;
        if(msg.getIsByMe() == 1) {

            if(msg.isReceivedToServer()) icon =  _recived_server;
            if(msg.isReceivedToPeer()) icon =  _recived_peer;
            if(msg.issSeenByPeer()) color = R.color.colorAccent;

            textView.setTypeface(FontCache.get(AndroidUtil.getString(R.string.font_ionic)));
            textView.setText(icon);
        }
    }
}
