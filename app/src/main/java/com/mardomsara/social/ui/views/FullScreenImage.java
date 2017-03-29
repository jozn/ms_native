package com.mardomsara.social.ui.views;

import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.X;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Hamid on 6/22/2016.
 */
public class FullScreenImage {

	X.FullScreenImage x = new X.FullScreenImage(AppUtil.global_window);
	String TAG = "FullScreenImage";
    PopupWindow attachWindow;

    public String text;
    public Uri imageUri;
    public String imageUrlPath;
    public File imageFile;

    Nav.OnBackPressHandler backHandler = ()->{
        close();
        return true;
    };

    int cliked = 0;

    public FullScreenImage() {
        this.attachWindow = new PopupWindow(
                x.root,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        Nav.addCustomOnBackPressHandler(backHandler);

        x.back_btn.setOnClickListener((v)->{
            close();
        });

        x.text_view.setOnClickListener((v)->{
           toggle();
        });

        x.top_nav.setOnClickListener((v)->{
            toggle();
        });

		x.back_btn.setOnClickListener(this::onBack);

        x.image_view.setOnPhotoTapListener((view,x,y)-> toggle());

		View decorView = App.getActivity().getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
		decorView.setSystemUiVisibility(uiOptions);
    }

    void toggle(){
        if(cliked == 0){
            x.top_nav.setVisibility(View.GONE);
            x.text_view.setVisibility(View.GONE);
            cliked = 1;
        }else {
			x.top_nav.setVisibility(View.VISIBLE);
			x.text_view.setVisibility(View.VISIBLE);
            cliked = 0;
        }
    }

    private void close() {
        Nav.removeCustomOnBackPressHandler(backHandler);
        attachWindow.dismiss();
    }

    void onBack(View v){
        Log.d(TAG,"onBack()");
        close();
    }

    public void show(){
        Log.d(TAG,"show()"+ imageUrlPath + text);
        int max_width = (AndroidUtil.getScreenWidth());
		x.text_view.setText(text);
        setPicaso();
        attachWindow.showAtLocation(AppUtil.global_window, Gravity.CENTER,0,0);

    }

	void setPicaso(){
		Picasso.with(x.root.getContext())
			.load(imageUri)
			.into(x.image_view);

	}



}
