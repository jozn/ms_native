package com.mardomsara.social.helpers;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

/**
 * Created by Hamid on 2/19/2016.
 */
public class RoomHelper {
/*    public static void roomRowOpttions(Context ctx, RoomsListTable room) {

//        UserRowViewHolder vh = new UserRowViewHolder(v);
//        DialogPlus dialog = DialogPlus.newDialog(ctx)
//                .setContentHolder(vh)
//                .setGravity(Gravity.CENTER)
//                .create();
//        dialog.show();
    }*/
    public static DialogPlus alertView(Context ctx, View v) {
        ViewHolder vh = new ViewHolder(v);
        DialogPlus dialog = DialogPlus.newDialog(ctx)
//                .setOnClickListener(v.)
                .setContentHolder(vh)
                .setGravity(Gravity.CENTER)
                .create();
        dialog.show();
        return dialog;
    }
}
