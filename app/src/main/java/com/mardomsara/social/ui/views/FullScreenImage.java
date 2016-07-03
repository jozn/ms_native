package com.mardomsara.social.ui.views;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.photodraweeview.PhotoDraweeView;

/**
 * Created by Hamid on 6/22/2016.
 */
public class FullScreenImage {
    @Bind(R.id.window) View window;
    @Bind(R.id.top_nav) View top_nav;
    @Bind(R.id.back_btn) View back_btn;
//    @Bind(R.id.image_view) SimpleDraweeView image_view;
    @Bind(R.id.image_view) PhotoDraweeView image_view;
    @Bind(R.id.text_view) TextView text_view;
    String TAG = "FullScreenImage";
    PopupWindow attachWindow;
    View popupView = AppUtil.inflate(R.layout.widget_full_screen_image, AppUtil.global_window);

    public String text;
    public Uri imageUri;
    public String imageUrlPath;
    public File imageFile;

    Nav.OnBackPressHandler backHandler = ()->{
        close();
        return true;
    };

    public FullScreenImage() {
        this.attachWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this, popupView);
        Nav.addCustomOnBackPressHandler(backHandler);

    }

    private void close() {
        Nav.removeCustomOnBackPressHandler(backHandler);
        attachWindow.dismiss();
    }

    @OnClick(R.id.back_btn)
    void onBack(View v){
        Log.d(TAG,"onBack()");
        close();
    }

    @OnClick(R.id.window)
    void onChange(View v){
    }

    public void show(){
        Log.d(TAG,"show()"+ imageUrlPath + text);
//        if(imageFile != null){
//            image_view.setImageURI(Uri.fromFile(imageFile));
//        }else {
//            image_view.setImageURI(imageUrlPath);
//        }
        int max_width = (AndroidUtil.getScreenWidth());
//        image_view.setLayoutParams(new RelativeLayout.LayoutParams(max_width, 700));
        text_view.setText(text);
//        image_view.setImageURI(imageUri);
        setFresco();
        attachWindow.showAtLocation(AppUtil.global_window, Gravity.CENTER,0,0);

    }

    void setFresco(){
        PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
        controller.setUri(imageUri);
        controller.setOldController(image_view.getController());
        controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                if (imageInfo == null || image_view == null) {
                    return;
                }
                image_view.update(imageInfo.getWidth(), imageInfo.getHeight());
            }
        });
        image_view.setController(controller.build());
    }



}
