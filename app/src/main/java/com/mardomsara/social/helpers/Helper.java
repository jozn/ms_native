package com.mardomsara.social.helpers;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.models.stores.Store;
import com.mardomsara.social.models.stores.StoreConstants;
import com.mardomsara.social.ui.views.EmojiKeyboard_OLD;
import com.squareup.picasso.Picasso;

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

    public static void SetAvatar(ImageView draweeView, String urlPath){
        Uri imageUri = Helper.PathToUserAvatarUri(urlPath);
        Picasso.with(AppUtil.getContext())
                .load(imageUri)
                .into(draweeView);
    }

    //Can be called from any thread
    public static void showMessage(String text){
        AndroidUtil.runInUi(()->{
            Toast.makeText(AppUtil.getContext(),text,Toast.LENGTH_SHORT).show();
        });
    }

	public static void showMessageShort(String text){
		AndroidUtil.runInUi(()->{
			Toast.makeText(AppUtil.getContext(),text,Toast.LENGTH_SHORT).show();
		});
	}

    public static void showDebugMessage(String text){
		if( ! Config.IS_DEBUG) return;
        AndroidUtil.runInUi(()->{
            Toast.makeText(AppUtil.getContext(),text,Toast.LENGTH_SHORT).show();
        });
    }

	public static void showCommingSoonMessage(){
		showMessageShort("به زودی در نسخه های بعد...");
	}

	public static int getAndroidKeyboardSize(){
		return Store.getInt(StoreConstants.KEYBOARD_SIZE, (int) (AndroidUtil.getScreenHeight()/2.5));
	}

	public static void toastLong(String text){
		AndroidUtil.runInUi(()->{
			Toast.makeText(AppUtil.getContext(),text,Toast.LENGTH_LONG).show();
		});
	}

	public static void toastShort(String text){
		AndroidUtil.runInUi(()->{
			Toast.makeText(AppUtil.getContext(),text,Toast.LENGTH_SHORT).show();
		});
	}

	public static void closeKeyboard(){
		EmojiKeyboard_OLD.closeEmojiKeyboard();
	}


}
