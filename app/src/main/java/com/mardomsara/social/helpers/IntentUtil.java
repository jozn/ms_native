package com.mardomsara.social.helpers;

import android.content.Intent;
import android.net.Uri;

/**
 * Created by Hamid on 7/1/2016.
 */
public class IntentUtil {

    public static void sendSmsTo(String number, String text) {
        Uri uri = Uri.parse("smsto:" + number);
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", text);
        AppUtil.getContext().startActivity(it);
    }

    public static void sendSmsTo(String number, int stringId) {
        sendSmsTo(number, AndroidUtil.getString(stringId));
    }


}
