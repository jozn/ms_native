package com.mardomsara.social.helpers;

import android.net.Uri;

/**
 * Created by Hamid on 5/2/2016.
 */
public class Helper {
    public static Uri PathToUserAvatarUri(String path){
        return  Uri.parse("http://localhost:5000/"+path);
    }
}
