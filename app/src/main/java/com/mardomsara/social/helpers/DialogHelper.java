package com.mardomsara.social.helpers;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mardomsara.social.R;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.List;

/**
 * Created by Hamid on 2/19/2016.
 */
public class DialogHelper {

    public static void toastLong(String text){
        Toast.makeText(AppUtil.getContext(),text,Toast.LENGTH_LONG).show();
    }

    public static void toastShort(String text){
        Toast.makeText(AppUtil.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    public static void toast(String text){
        Toast.makeText(AppUtil.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    static float _dialogWidth = 0.80f;

    public static void simpleAlert(Context ctx, String title, String body){
//        alertViewWithListner22(ctx);
        LayoutInflater inf = LayoutInflater.from(ctx);
        LinearLayout simple = (LinearLayout) inf.inflate(R.layout.dialog_simple_alert,null);
        TextView vTitle = (TextView) simple.findViewById(R.id.title);
        TextView vBody = (TextView) simple.findViewById(R.id.body);
        TextView vClose = (TextView) simple.findViewById(R.id.close);
        vTitle.setText(title);
        vBody.setText(body);
        vClose.setText("بستن");


        ViewHolder vh = new ViewHolder(simple);
        final DialogPlus dialog = DialogPlus.newDialog(ctx)
                .setContentHolder(vh)
                .setGravity(Gravity.CENTER)
                .setMargin(10, 10, 10, 10)
                .setContentWidth((int)Math.round(AndroidUtil.getScreenWidth()*_dialogWidth))
                .create();

        dialog.show();
//        vClose.setOnClickListener(v -> dialog.dismiss());
        vClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public static void simpleMenu(List<MenuItem> items){
        Context ctx = AppUtil.getContext();
        LayoutInflater inf = LayoutInflater.from(AppUtil.getContext());
        int margin = AndroidUtil.dpToPx(5);//window is 10dp - 5 is based on fisagores
        OnItemClickListener listener = (dialog, item, view , position)->{
            dialog.dismiss();
            items.get(position).listener.onClick(view);
        };
        ArrayAdapter adapter = new ArrayAdapter(ctx, R.layout.dialog_simple_menu_string);
        for(MenuItem item: items){
            adapter.add(item.name);
        }
//        adapter.addAllStart(new String[]{"Ass", "dff", "Hjj","Ass",});// "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj",});

        DialogPlus dialog = DialogPlus.newDialog(ctx)
                .setAdapter(adapter)
                .setExpanded(false)
                .setGravity(Gravity.CENTER)
                .setContentWidth((int)Math.round(AndroidUtil.getScreenWidth()*_dialogWidth))
                .setMargin(margin,margin,margin,margin)
                .setOnItemClickListener(listener)
                .create();
        dialog.show();
    }

    public static void simpleMenu2(List<String> options){
        Context ctx = AppUtil.getContext();
        LayoutInflater inf = LayoutInflater.from(AppUtil.getContext());
        int margin = AndroidUtil.dpToPx(5);//window is 10dp - 5 is based on fisagores

        ArrayAdapter adapter = new ArrayAdapter(ctx, R.layout.dialog_simple_menu_string);
        adapter.addAll(new String[]{"Ass", "dff", "Hjj","Ass",});// "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj",});

        DialogPlus dialog = DialogPlus.newDialog(ctx)
                .setAdapter(adapter)
                .setExpanded(false)
                .setGravity(Gravity.CENTER)
                .setContentWidth((int)Math.round(AndroidUtil.getScreenWidth()*_dialogWidth))
                .setMargin(margin,margin,margin,margin)
                .create();
        dialog.show();

    }

    public static DialogPlus alertView(Context ctx, View v) {
        ViewHolder vh = new ViewHolder(v);
        DialogPlus dialog = DialogPlus.newDialog(ctx)
                .setContentHolder(vh)
                .setGravity(Gravity.CENTER)
                .create();
        dialog.show();
        return dialog;
    }

    public static DialogPlus alertViewWithListner(Context ctx,View v, OnClickListener clik) {
        ViewHolder vh = new ViewHolder(v);
        DialogPlus dialog = DialogPlus.newDialog(ctx)
                .setContentHolder(vh)
                .setOnClickListener(clik)
                .setGravity(Gravity.CENTER)
                .create();
        dialog.show();
        return dialog;
    }

    public static DialogPlus alertViewWithListner22(Context ctx) {
//        UserRowViewHolder vh = new UserRowViewHolder(v);
        ArrayAdapter adapter = new ArrayAdapter(ctx, R.layout.row_users_unregisterd_contact);
        adapter.addAll(new String[]{"Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj",});

        DialogPlus dialog = DialogPlus.newDialog(ctx)
                .setAdapter(adapter)
                .setExpanded(true)

                .create();
        dialog.show();
        return dialog;
    }



        //TODO: remove
    //deprectaed
    public static void simpleAlert2(Context ctx, String title, String body){
        LayoutInflater inf = LayoutInflater.from(ctx);
        TextView vTitle = (TextView) inf.inflate(R.layout.dialog_simple_title, null);
        TextView vBody = (TextView) inf.inflate(R.layout.dialog_simple_body, null);
        TextView vClose = (TextView) inf.inflate(R.layout.dialog_simple_close, null);
        vTitle.setText(title);
        vBody.setText(body);
        vClose.setText("بستن");

        ViewHolder vh = new ViewHolder(vBody);
        final DialogPlus dialog = DialogPlus.newDialog(ctx)
                .setContentHolder(vh)
                .setHeader(vTitle)
                .setFooter(vClose)
                .setFooter(R.layout.fragment_footer_bar)
//                .setExpanded(false, 120)  // This will enable the expand feature, (similar to android L share dialog)
                .setGravity(Gravity.CENTER)
                .setMargin(10, 10, 10, 10)
                .setPadding(20, 20, 20, 20)
                .create();

        dialog.show();
//        new DialogPlusBuilder(ctx).setOrReplace
//        vClose.setOnClickListener(v-> dialog.dismiss());
        vClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public static class MenuItem{
        public View.OnClickListener listener;
        public String name;

        public MenuItem(String name, View.OnClickListener listener) {
            this.name = name;
            this.listener = listener;
        }


    }
}
