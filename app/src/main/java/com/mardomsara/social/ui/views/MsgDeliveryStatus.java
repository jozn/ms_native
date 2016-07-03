package com.mardomsara.social.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mardomsara.social.App;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;

/**
 * Created by Hamid on 6/5/2016.
 */
public class MsgDeliveryStatus extends TextView {
    String _wating = "\uf402"; //ion-ios-clock-outline
    String _recived_server = "\uf383";//ion-android-done
    String _recived_peer = "\uf382";//ion-android-done-all
    String _seen_peer = "\uf382";//ion-android-done-all
    String seenColor = "";
    String geryColor = "";

    public static final int Msg_Wainting = 1 ;
    public static final int Msg_Recived_Server = 2 ;
    public static final int Msg_Recived_Peer = 3 ;
    public static final int Msg_Seen_Peer = 4 ;

    public MsgDeliveryStatus() {
        this(App.getContext());
    }
    public MsgDeliveryStatus(Context context) {
        super(context);
    }

    public MsgDeliveryStatus(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MsgDeliveryStatus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static MsgDeliveryStatus getNew(){
        MsgDeliveryStatus res = new  MsgDeliveryStatus().setStatus(Msg_Wainting);
//        res.setLayoutParams(new L);
        return res;
    }

    public MsgDeliveryStatus setStatus(int status){
        params();
        switch (status){
            case Msg_Wainting:
                setText(_wating);
                break;

            case Msg_Recived_Server:
                setText(_recived_server);
                break;

            case Msg_Recived_Peer:
                setText(_recived_peer);
                break;

            case Msg_Seen_Peer:
                setText(_seen_peer);
//                setTextColor(0x3333aa);
                break;
        }
        return this;
    }

    void params(){
        setTextSize(AndroidUtil.dpToPx(10));
        setTypeface(FontCache.get(AndroidUtil.getString(R.string.font_ionic)));
//        setTypeface(FontCache.get("fonts/ionic.ttf"));
//        setTextColor(0x444444);
    }
}
