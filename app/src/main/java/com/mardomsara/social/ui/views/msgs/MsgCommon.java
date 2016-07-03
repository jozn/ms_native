package com.mardomsara.social.ui.views.msgs;

import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.SubscriptSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.extra.MsgExtraPhotoThumbnail;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.social.ui.views.FullScreenImage;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import java.io.File;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCommon {
    public static String msgRawTime2(MessagesTable msg){
        return FormaterUtil.timeToClockTimeMs(msg.getCreatedMs());
    }

    public static String msgRawTime(MessagesTable msg){
        return FormaterUtil.timeToClockTimeMs(msg.getCreatedMs());
    }

    public static void setImage(MessagesTable msg , ImageView image_iew){
        File file = new File(msg.getMediaLocalSrc());
        int max_width = (int) (AndroidUtil.getScreenWidth() * 0.8);
        AppUtil.log("width: "+max_width+AndroidUtil.getScreenResolution()+AndroidUtil.getDensity());
        max_width = AndroidUtil.pxToDp(max_width);
//        ViewGroup.LayoutParams sizes = new ViewGroup.LayoutParams(AndroidUtil.dpToPx(msg.getMediaWidth()),
//                AndroidUtil.dpToPx(msg.getMediaWidth()));
//        msg_image.setLayoutParams(sizes);

        ViewHelper.setImageSizesWithMaxPx(image_iew, max_width, msg.getMediaWidth(),msg.getMediaHeight());
//        ViewHelper.setViewSizeDp(msg_image,msg.getMediaWidth(),msg.getMediaHeight());
//        msg_image.setLayoutParams();
        file.toURI();
        Uri u2 =Uri.fromFile(file);
//        msg_image.setAspectRatio(1.33f);
        image_iew.setImageURI(u2);

        image_iew.setOnClickListener((v)->{
            FullScreenImage window = new FullScreenImage();
            window.text = msg.getText();
            window.imageUri = u2 ;//msg.getMediaLocalSrc();
            window.show();
        });
//        image_iew.setBackground();
    }
    public static void setVideoImage(MessagesTable msg , ImageView msg_image) {
        //        URI uri = AppUtil.(msg.getMediaLocalSrc());
//        msg_image.
//        Uri u = Uri.parse(msg.getMediaLocalSrc());
        Uri u = Uri.parse("http://localhost:5000/public/photo/1_960.jpg");
//        int max_width = msg_content_holder.getLayoutParams().width;//px
//        int max_width = msg_content_holder.getWidth();;//px

        int max_width = (int) (AndroidUtil.getScreenWidth() * 0.88);
        AppUtil.log("width: "+max_width+AndroidUtil.getScreenResolution()+AndroidUtil.getDensity());
        max_width = AndroidUtil.pxToDp(max_width);
        MsgExtraPhotoThumbnail thumbnail = JsonUtil.fromJson(msg.getExtraJson(),MsgExtraPhotoThumbnail.class);
        if(thumbnail != null){
            File file = new File(thumbnail.LocalSrc);
//        ViewGroup.LayoutParams sizes = new ViewGroup.LayoutParams(AndroidUtil.dpToPx(msg.getMediaWidth()),
//                AndroidUtil.dpToPx(msg.getMediaWidth()));
//        msg_image.setLayoutParams(sizes);

//        ViewHelper.setImageSizesWithMaxPx(msg_image, max_width, msg.getMediaWidth(),msg.getMediaHeight());
            ViewHelper.setImageSizesWithMaxPx(msg_image, max_width, thumbnail.Width , thumbnail.Height );
            file.toURI();
            Uri u2 =Uri.fromFile(file);
//        msg_image.setAspectRatio(1.33f);
            msg_image.setImageURI(u2);
//            msg_content_holder.requestLayout();

        }

    }

        ////////////////////////////////////////////////
    ///////////////////////////////////////////////

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

    ////////////////////////////////////////////////
    //////////////////////////////////////////////


    void __play(){
//        SubscriptSpan
//        BackgroundColorSpan
//        ForegroundColorSpan

//        ImageSpan
//        TextView;
//        SpannableStringBuilder
//        new String(new int[] {0x1F607}, 0, 1)
    }
}
