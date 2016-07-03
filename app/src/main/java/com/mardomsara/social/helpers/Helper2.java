package com.mardomsara.social.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.common.utils.Common;
import com.mardomsara.social.R;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;

/**
 * Created by Hamid on 2/13/2016.
 */
public class Helper2 {
    public static String stringArrayToString(String[] arr, String sep){
        StringBuffer str = new StringBuffer();
        for (String s: arr){
            str.append(s+sep);
        }
        return str.toString();
    }

    /**
     * Function to display simple Alert DialogHelper or Toast
     *
     * @param context - application context
     * @param title   - alert dialog title
     * @param message - alert message
     * @param toast   - show as toast or dialog
     */
    public static void showAlertDialog(Context context, String title, String message, boolean toast) {
        if (toast) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        } else {
            TextView tit = new TextView(context);
            TextView body = new TextView(context);
            tit.setText("منا ل انان");
            body.setText("hندشسنتی ionjlkkdnaskldjasd");
            AlertDialog alertDialog = null;
            if (!((Activity) context).isFinishing()) {
                if (alertDialog == null)
                    alertDialog = new AlertDialog.Builder(context).create();
                // Setting DialogHelper Title
                alertDialog.setCustomTitle(tit);
                alertDialog.setView(body);
//                alertDialog.setContentView(R.layout.hello_world);
                alertDialog.setTitle(title);
                // Setting DialogHelper Message
                alertDialog.setMessage(message);
                // Setting OK Button
//                alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
                // Showing Alert Message
                alertDialog.show();
//                alertDialog.setView();
            }
        }
    }
    public static void showAlert(Context ctx){
        DialogPlus dialog = DialogPlus.newDialog(ctx)
                //.setAdapter(adapter)
                .setContentHolder(new ViewHolder(R.layout.hello_world))
//                .setOnItemClickListener(new OnItemClickListener() {
//                    @Override
//                    public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
//                    }
//                })
                .setExpanded(true)  // This will enable the expand feature, (similar to android L share dialog)
                .setGravity(Gravity.CENTER)
                .setExpanded(false, 120)
                .create();
        dialog.show();
    }

    public static void showAlert2(Context ctx){
        DialogPlus dialog = DialogPlus.newDialog(ctx)
                //.setAdapter(adapter)
                .setContentHolder(new ViewHolder(R.layout.hello_world))
                .setFooter(R.layout.fragment_footer_bar)
//                        .setContentHeight()
//                .setOnItemClickListener(new OnItemClickListener() {
//                    @Override
//                    public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
//                    }
//                })
                .setExpanded(false, 120)  // This will enable the expand feature, (similar to android L share dialog)
                .setGravity(Gravity.CENTER)

                .create();
        dialog.show();
    }


}
