package com.mardomsara.social.ui.views.helpers;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

/**
 * Created by Hamid on 6/6/2016.
 */
public class ViewHelper {

    public static int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
    public static int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;

    public static void setViewSizeDp(View view, int width_dp , int height_dp){
//        ViewGroup.LayoutParams sizes = new ViewGroup.LayoutParams(AndroidUtil.dpToPx(width_dp),
        ViewGroup.LayoutParams sizes = new LinearLayout.LayoutParams(AndroidUtil.dpToPx(width_dp),
                 AndroidUtil.dpToPx(height_dp));
        view.setLayoutParams(sizes);
    }

    //setOrReplace an image with aspect ration
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
        if(view.getParent() instanceof ViewGroup){
            ((ViewGroup)view.getParent()).requestLayout();
            AppUtil.log("request relayout");
        }
    }

    public static void setViewSizesPrecentaion(View view, float percent){
        int width = (int) (AndroidUtil.getScreenWidth() * percent);
        ViewGroup.LayoutParams sizes;
        if(view.getParent() instanceof LinearLayout){
            sizes = new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT);
        }else if(view.getParent() instanceof FrameLayout){
            sizes = new FrameLayout.LayoutParams(width,FrameLayout.LayoutParams.WRAP_CONTENT);
        }else if(view.getParent() instanceof RelativeLayout){
            sizes = new RelativeLayout.LayoutParams(width,-2);
        }else{
            sizes = new ViewGroup.LayoutParams(width,-2);
        }
//        Log.d("Image","setImageSizesWithMaxPx() imageView Sizes: "+width +" "+ height);

        view.setLayoutParams(sizes);
    }
    public static int[] calculateImageSizesWithMaxPx(View view,int minWidt_dp ,int maxWidth_dp , int width_px , int height_px) {
        int max_width_px = AndroidUtil.dpToPx(maxWidth_dp);

        if (minWidt_dp > 0) {
            int min_width_px = AndroidUtil.dpToPx(minWidt_dp);
            if (min_width_px > width_px) {
                float ratio = (float) min_width_px / (float) width_px;
                height_px = (int) ((float) height_px * ratio);
                width_px = min_width_px;
            }
        }

        int width, height = 0;
        ViewGroup.LayoutParams sizes;
        if (max_width_px > width_px) {
//            sizes = new LinearLayout.LayoutParams(width_px,height_px);
            width = width_px;
            height = height_px;
        } else {
            float aspect = (float) max_width_px / (float) width_px; // <1
            int newHeight_px = Math.round(height_px * aspect);
//            sizes = new LinearLayout.LayoutParams(max_width_px, max_width_px);
            width = max_width_px;
            height = newHeight_px;
        }
        return new int[]{width,height};
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

    ///////////////////////////////////////////////////////
    ///////////// Views Shourtcuts ////////////////////////

    public static RecyclerView newRecyclerViewMatch(){
        RecyclerView recyclerView = new RecyclerView(AppUtil.getContext());
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return recyclerView;
    }

    public static LinearLayout newLnearLayout(int width, int height){
        LinearLayout view = new LinearLayout(AppUtil.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        return view;
    }

    public static RecyclerView newRecyclerViewWraped(){
        RecyclerView recyclerView = new RecyclerView(AppUtil.getContext());
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        recyclerView.setBackgroundColor(Color.RED);
        return recyclerView;
    }

    public static SwipeRefreshLayout newSwipeRefreshLayout(int width, int height){
        SwipeRefreshLayout view = new SwipeRefreshLayout(AppUtil.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        return view;
    }

    public static ImageView newImageView(int width, int height){
        ImageView view = new ImageView(AppUtil.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        return view;
    }
    ///////////////////////////////////////////////////////////////////
}
