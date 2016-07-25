package com.mardomsara.social.helpers;

import android.net.Uri;

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
}
