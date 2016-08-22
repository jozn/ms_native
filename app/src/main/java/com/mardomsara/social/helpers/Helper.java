package com.mardomsara.social.helpers;

import android.net.Uri;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Hamid on 5/2/2016.
 */
public class Helper {
    public static Uri PathToUserAvatarUri(String path){
        return  PathToUserAvatarUri(path,50);
    }

    public static Uri PathToUserAvatarUri(String path, int sizeDp){
//        return  Uri.parse("http://localhost:5000/"+path);
        int px = AndroidUtil.dpToPx(sizeDp);
        int t = 100;
        if (px <= 50 ){
            t = 50;
        } else if (px <= 100 ) {
            t = 100;
        }else if (px <= 200 ) {
            t = 200;
        }else {
            t = 400;
        }

        return  Uri.parse(path.replace("%s", ""+t ));
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
