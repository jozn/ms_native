package com.mardomsara.social.ui.presenter.dialogs;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.ui.BasePresenter;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnClickListener;

/**
 * Created by Hamid on 2/19/2016.
 */
public class RoomListRowOptionsPresenter  extends BasePresenter implements View.OnClickListener, OnClickListener {
    TextView goProfile;
    TextView delete;
    TextView clear;


    @Override
    public View buildGrandView() {
        grandView = inflater.inflate(R.layout.dialog_options_room_row2, null);
        setBinders();
//        setListeners();
        return  grandView;
    }

    @Override
    public View buildView() {
        grandView = inflater.inflate(R.layout.dialog_options_room_row2, null);
        setBinders();
//        setListeners();
        return  grandView;
    }


    void setBinders(){
        goProfile =  getTextView(R.id.profile);
        delete = getTextView(R.id.delete);
        clear = getTextView(R.id.clear);
    }


    public void onClick(View v) {
        Log.d("dialog", "goProfile");
        Nav.push(Router.getHomePage());
    }

    @Override
    public void onClick(DialogPlus dialog, View view) {
        Log.d("dialog", "DialogPlus");
        switch (view.getId()){
            case R.id.profile:
                Log.d("dialog", "goProfile");
                dialog.dismiss();
                Nav.goToBranch("profile");
                break;

            case R.id.delete:
                dialog.dismiss();
                Nav.goToBranch("search");
                break;

            case R.id.clear:
                Nav.goToBranch("search");
                dialog.dismiss();
                break;
        }
        //Nav.push(Router.getHomePage());
    }

//    @Override
//    public View buildGrandView() {
//        View l =  inflater.inflate(R.layout.dialog_options_room_row, null);
//        TextView text = (TextView) l.findViewById(R.id.text);
//        ListView list = (ListView) l.findViewById(R.id.list_view);
//        String[] ss = new String[]{"kjaskjsa","شی شسیتشسد","نن اذ ششسشس"," شیشس"};
//        ArrayAdapter<String> adaptor = new ArrayAdapter(context,
//                R.layout.dialog_options_room_row,
//                R.id.text,
//                ss);
//
//        list.setAdapter(adaptor);
//        return  l;
//    }
}


//    void setListeners(){
//        goProfile.setOnLongClickListener((v) -> {
//            Log.d("dialog", "goProfile");
//            closeDialog();
//            Nav.goToBranch("profile");
//            return true;
//        });
//
//        delete.setOnClickListener(new TextView.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("dialog", "goProfile");
//                Nav.push(Router.getHomePage());
//            }
//        });
//
//        clear.setOnClickListener(this);
//
//        img.setOnClickListener((v) -> {
//            Log.d("dialog", "searc");
//            Nav.goToBranch("search");
//        });
//
//    }