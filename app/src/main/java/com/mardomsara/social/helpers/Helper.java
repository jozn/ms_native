package com.mardomsara.social.helpers;

import android.net.Uri;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Hamid on 5/2/2016.
 */
public class Helper {
    public static Uri PathToUserAvatarUri(String path){
        return  Uri.parse("http://localhost:5000/"+path);
    }

    public static void SetAvatar(SimpleDraweeView draweeView, String urlPath){
        Uri imageUri = Helper.PathToUserAvatarUri(urlPath);
        draweeView.setImageURI(imageUri);

    }

    //Can be called from any thread
    public static void showMessage(String text){
        AndroidUtil.runInUi(()->{
            Toast.makeText(AppUtil.getContext(),text,Toast.LENGTH_SHORT).show();
        });
    }

}
