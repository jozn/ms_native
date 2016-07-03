package com.mardomsara.social.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.sw926.imagefileselector.AppLogger;

import org.apache.commons.io.FileUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestWebSocketActivity extends Activity {
    /** Called when the activity is first created. */
    @Bind(R.id.base64) TextView btn;
    @Bind(R.id.txt) TextView txt;
    @Bind(R.id.dl) TextView dl;
    @Bind(R.id.img) ImageView img;
    @Bind(R.id.img2) ImageView img2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_main_popup);

        ButterKnife.bind(this);
        final Button btnOpenPopup = (Button)findViewById(R.id.openpopup);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.activity_test_web_socket, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);

                Button btnDismiss = (Button)popupView.findViewById(R.id.close_send_btn);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                    }});

//                popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
                popupWindow.setHeight(540);
                popupWindow.showAtLocation(btnOpenPopup, Gravity.END,400,1200);

            }});
    }

    @OnClick(R.id.base64)
    public void onClick(View v){
        Bitmap bm = ImageUtil.getBitmapFromDrawable(R.drawable.sample2);
//        bm.compress()
        String s = ImageUtil.createBase64(bm);

        Bitmap bm2 = ImageUtil.base64ToBitmap(s);

        img.setImageBitmap(ImageUtil.base64ToBitmap(s));
        Bitmap cbm = ImageUtil.compress(bm2);
//        byte[] bts2 = ImageUtil.compressToBytes(bm);
//        byte[] bts2 = ImageUtil.compressToBytes(
//                ImageUtil.fastblur(ImageUtil.getResizedBitmapRatio(bm,250),1,10));
//        byte[] bts2 = ImageUtil.compressToBytes(
//                ImageUtil.getResizedBitmapRatio(ImageUtil.fastblur(bm,1,25),250));
//        byte[] bts2 = ImageUtil.compressToBytes(ImageUtil.fastblur(bm,0.25f,10));
//        img2.setImageBitmap(ImageUtil.fastblur(bm,1,10));

        txt.setText("size: " +s.length() + " ->"
                + "compresed : " + s.substring(0,200));

        byte[] bts2 = ImageUtil.blurThumbnail(bm);
        String path = Environment.getExternalStorageDirectory().getPath()+"/out22.jpg";
        String z = Environment.getExternalStorageDirectory().getPath()+"/z1.jpg";
        String z2 = Environment.getExternalStorageDirectory().getPath()+"/z2.jpg";
        File fz1= new File(z);
        File fz2= new File(z2);

        Bitmap zm = BitmapFactory.decodeFile(z);
        img2.setImageBitmap(ImageUtil.fastblur(zm,1,10));
        try {

            OutputStreamWriter ow = new FileWriter(path);
            OutputStream os = new FileOutputStream(path);
            BufferedOutputStream bo = new BufferedOutputStream(os);
            bo.write(bts2,0,bts2.length);
            bo.flush();

            FileUtils.writeByteArrayToFile(fz1,ImageUtil.compressAndResizeToBytes(bm,250,30));
            FileUtils.writeByteArrayToFile(fz2,ImageUtil.compressAndResizeToBytes(ImageUtil.fastblur(zm,1,10),250,30));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ////////////////////////
//        FileChooserFileUtils.writeByteArrayToFile();
    }

    @OnClick(R.id.dl)
    public void onClickDl(View v){
        String f = Environment.getExternalStorageDirectory().getPath()+"/zz_"+ LangUtil.getRandomString(4) +".jpg";
        AndroidUtil.runInBackground(()->{
            Http.downloadFile("http://localhost:5000/public/5.jpg", f ,
                    ()->{
                        File ff = new File(f);
                        Uri u =  Uri.parse(f);
                        AppLogger.d("in seting img");
                        if(ff.exists()){
                            AndroidUtil.runInUi(()->img.setImageURI(u));
                        }
                    },null

                    );});
    }


}


////        AppWebSocket ws = new AppWebSocket(URI.create("ws://echo.websocket.org"));
//AppWebSocket ws = new AppWebSocket(URI.create("ws://192.168.0.10:5000/ws"));
//try {
//        ws.tryConnect();
////            ws.send("{Command: 'hello'}");
//        }catch (Exception e){
//        Log.e("WEBSOCKEt", e.toString());
//        }