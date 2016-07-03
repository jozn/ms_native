package com.mardomsara.social.ui.views.helpers;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 6/6/2016.
 */
public class ViewHelper {

    public static void setViewSizeDp(View view, int width_dp , int height_dp){
//        ViewGroup.LayoutParams sizes = new ViewGroup.LayoutParams(AndroidUtil.dpToPx(width_dp),
        ViewGroup.LayoutParams sizes = new LinearLayout.LayoutParams(AndroidUtil.dpToPx(width_dp),
                AndroidUtil.dpToPx(height_dp));
        view.setLayoutParams(sizes);
    }

    //set an image with aspect ration
    //Deprectaed -- useless??
    public static void __setImageSizesWithMaxDp(View view, int maxWidth_dp , int width_dp , int height_dp){
        if(maxWidth_dp> width_dp){
            setViewSizeDp(view, width_dp, height_dp);
        }else {
            float aspect = width_dp/maxWidth_dp;
            int newWidt = (int) (height_dp * aspect);
            setViewSizeDp(view, maxWidth_dp, newWidt);
        }
    }

    //equal width for all images
    public static void setImageSizesWithMaxPx(View view, int maxWidth_dp , int width_px , int height_px){
        setImageSizesWithMaxPx(view,maxWidth_dp,maxWidth_dp,width_px,height_px);
    }

    public static void setImageSizesWithMaxPx(View view,int minWidt_dp ,int maxWidth_dp , int width_px , int height_px){
        int max_width_px = AndroidUtil.dpToPx(maxWidth_dp);

        if(minWidt_dp>0){
            int min_width_px = AndroidUtil.dpToPx(minWidt_dp);
            if(min_width_px > width_px) {
                float ratio = (float)min_width_px / (float)width_px;
                height_px = (int)((float)height_px * ratio);
                width_px = min_width_px;
            }
        }

        int width,height =0;
        ViewGroup.LayoutParams sizes;
        if(max_width_px> width_px){
//            sizes = new LinearLayout.LayoutParams(width_px,height_px);
            width = width_px;
            height = height_px;
        }else {
            float aspect = (float) max_width_px / (float) width_px; // <1
            int newHeight_px = Math.round(height_px * aspect);
//            sizes = new LinearLayout.LayoutParams(max_width_px, max_width_px);
            width = max_width_px;
            height = newHeight_px;
        }
//        ViewGroup parent = view.getParent();
        if(view.getParent() instanceof LinearLayout){
            sizes = new LinearLayout.LayoutParams(width,height);
        }else if(view.getParent() instanceof FrameLayout){
            sizes = new FrameLayout.LayoutParams(width,height);
        }else if(view.getParent() instanceof RelativeLayout){
            sizes = new RelativeLayout.LayoutParams(width,height);
        }else{
            sizes = new ViewGroup.LayoutParams(width,height);
        }
//        Log.d("Image","setImageSizesWithMaxPx() imageView Sizes: "+width +" "+ height);

        view.setLayoutParams(sizes);
    }

    //////////////////////////////////////////////////////////////

    static String _wating = "\uf402"; //ion-ios-clock-outline
    static String _recived_server = "\uf383";//ion-android-done
    static String _recived_peer = "\uf382";//ion-android-done-all
    static String _seen_peer = "\uf382";//ion-android-done-all
//    static String seenColor = "";
    static String geryColor = "";

    static int defualtColor = Color.argb(255, 100, 100, 100);
    static int seenColor = Color.argb(255, 50, 50, 255);
    public static final int Msg_Wainting = 1 ;
    public static final int Msg_Recived_Server = 2 ;
    public static final int Msg_Recived_Peer = 3 ;
    public static final int Msg_Seen_Peer = 4 ;



    public static void msgDelviryStatusText(MessagesTable msg, TextView textView){
        if(msg == null || textView == null) return;
        String icon =_wating;
        boolean isSeen = false;
        int color = R.color.light_gery_dark;
        if(msg.getIsByMe() == 1) {

            if(msg.isReceivedToServer()) icon =  _recived_server;
            if(msg.isReceivedToPeer()) icon =  _recived_peer;
            if(msg.issSeenByPeer()) isSeen = true;
//            if(msg.issSeenByPeer()) color = R.color.colorAccent;

            textView.setTypeface(FontCache.get(AndroidUtil.getString(R.string.font_ionic)));
            textView.setText(icon);
            if(isSeen){
                textView.setTextColor(seenColor);
            }else {
                textView.setTextColor(defualtColor);
            }
        }
    }
    ///////////////////////////////////////////////////////////////////
}
