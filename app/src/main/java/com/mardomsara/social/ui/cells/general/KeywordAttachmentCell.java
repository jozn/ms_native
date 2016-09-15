package com.mardomsara.social.ui.cells.general;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.orhanobut.hawk.Hawk;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Hamid on 6/15/2016.
 */
//todo [update DON'T] migrate to dataBinding: on xml set onClick={callback_listener.onPhotoClick()}
public class KeywordAttachmentCell implements RecentImagesCell.onRecentImageClicked{
    @Bind(R.id.attach_video) View attach_video;
    @Bind(R.id.attach_gallery) View attach_gallery;
    @Bind(R.id.attach_camera) View attach_camera;
    @Bind(R.id.attach_file) View attach_file;

    @Bind(R.id.attachment_top) View attachment_top;

    @Bind(R.id.close_send_btn) View close_send_btn;
    @Bind(R.id.close_icon) TextView close_icon;
    @Bind(R.id.close_text) TextView close_text;

    @Bind(R.id.frame_layout) ViewGroup frame_layout;


    Callbacks callback_listener;
    RecentImagesCell recentImagesCell;
    PopupWindow attachWindow;

    int keyboardSize = Hawk.get(Config.KEYBOARD_HEIGHT, Config.KEYBOARD_HEIGHT_DEFAULT);

    public KeywordAttachmentCell(Callbacks listener, View bottom_container) {
        callback_listener = listener;
        View popupView = AppUtil.inflate(R.layout.cells_keywoard_attachment);
        ButterKnife.bind(this,popupView);

        attachWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);//keyboardSize);

        //view containg icons
        View main_content = popupView.findViewById(R.id.attachment_main);
        main_content.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, keyboardSize));
//        close_send_btn.setOnClickListener((v)->{
//                attachWindow.close_send_btn();
//            });
        setRecentImages();
        _updateCloseBtn();

        attachWindow.showAtLocation(bottom_container, Gravity.END,0,15000);
    }

    void setRecentImages(){
        recentImagesCell = new RecentImagesCell(frame_layout);
        recentImagesCell.insertInto(frame_layout);
        recentImagesCell.setListener(this);
    }

    /*public void bindToView(MessagesTable msg) {

    }*/

    //// Recent Images callbacks //////////////
    @Override
    public void onRecentImageAdded(String filePath) {

    }

    @Override
    public void onRecentImageRemoved(String filePath) {

    }

    @Override
    public void onRecentImageClicked(String filePath) {
        _updateCloseBtn();
    }

    void _updateCloseBtn(){
        int size = recentImagesCell.getSelected().size();
        if(size >0 ){
            close_icon.setText("\uf2f6");
            close_text.setText("بفرس("+size +")");
            close_icon.setTextColor(AndroidUtil.getColor(R.color.btn_send));
        }else {//clse
            close_icon.setText("\uf404");
            close_text.setText("بستن");
            close_icon.setTextColor(AndroidUtil.getColor(R.color.btn_close));

        }
    }

    public void dismiss(){
        attachWindow.dismiss();
    }

    @OnClick(R.id.close_send_btn)
    void sendRecentImagesOrClose(){
        int size = recentImagesCell.getSelected().size();
        if(size >0 ){
            callback_listener.onRecentImagesClick(recentImagesCell.getSelected());
        }else {//clse
           dismiss();
        }
    }

    @OnClick(R.id.attachment_top)
    void topClicked(){
        dismiss();
    }

    @OnClick(R.id.attach_video)
    public void attach_video(){
        callback_listener.onVideoClick();
    }

    @OnClick(R.id.attach_camera)
    public void attach_camera(){
        callback_listener.onCameraPhotoClick();
    }

    @OnClick(R.id.attach_gallery)
    public void setAttach_gallery(){
        callback_listener.onGalleryClick();
    }

    @OnClick(R.id.attach_file)
    public void setAttach_file(){
        callback_listener.onFileClick();
    }

    @OnClick(R.id.attach_location)
    public void setAttach_location(){
        callback_listener.onLocationClick();
    }

    public interface Callbacks {
        void onCameraPhotoClick();
        void onGalleryClick();
        void onVideoClick();
        void onAudioClick();
        void onLocationClick();
        void onFileClick();
        void onContactClick();
        void onRecentImagesClick(List<String> imagesPath);


    }
}
//dep
//    private static KeywordAttachmentView makeNew(){
////        return new KeywordAttachmentView(AppUtil.inflate(R.layout.empty));
//    }
