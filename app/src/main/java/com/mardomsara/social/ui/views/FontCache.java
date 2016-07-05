package com.mardomsara.social.ui.views;

import android.content.Context;
import android.graphics.Typeface;

import com.mardomsara.social.App;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;

import java.util.Hashtable;

/**
 * Created by Hamid on 6/5/2016.
 */
public class FontCache {

    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    public static Typeface get(String name) {
        Context context = App.getContext();
        Typeface tf = fontCache.get(name);
        if(tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            }
            catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }

    public static Typeface getIonic(){
        return get(AndroidUtil.getString(R.string.font_ionic));
    }

    public static Typeface getLinear(){
        return get(AndroidUtil.getString(R.string.font_linear));
    }
}
