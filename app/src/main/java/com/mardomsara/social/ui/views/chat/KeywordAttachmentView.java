package com.mardomsara.social.ui.views.chat;

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
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.ui.presenter.chats.old.ChatEntryPresenter;
import com.mardomsara.social.ui.views.RecentImagesView;
import com.orhanobut.hawk.Hawk;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Hamid on 6/15/2016.
 */
//todo migrate to dataBinding: on xml set onClick={callback_listner.onPhotoClick()}
public class KeywordAttachmentView implements RecentImagesView.onRecentImageClicked{
    @Bind(R.id.attach_video) View attach_video;
    @Bind(R.id.attach_gallery) View attach_gallery;
    @Bind(R.id.attach_camera) View attach_camera;
    @Bind(R.id.attach_file) View attach_file;

//    @Bind(R.id.gridview) TwoWayGridView gridview;

    @Bind(R.id.attachment_top) View attachment_top;

    @Bind(R.id.close_send_btn) View close_send_btn;
    @Bind(R.id.close_icon) TextView close_icon;
    @Bind(R.id.close_text) TextView close_text;

    @Bind(R.id.frame_layout) ViewGroup frame_layout;


    Callbacks callback_listner;
    RecentImagesView recentImagesView;
    PopupWindow attachWindow;
    public ChatEntryPresenter chatEntryPresenter;

    int kybordSize = Hawk.get(Config.KEYBOARD_HEIGHT, Config.KEYBOARD_HEIGHT_DEFAULT);

    public KeywordAttachmentView(Callbacks listner, View bottom_container) {
        callback_listner = listner;
        View popupView = AppUtil.inflate(R.layout.keywoard_attachment);
        ButterKnife.bind(this,popupView);

        attachWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);//kybordSize);

        //view containg icons
        View main_content = popupView.findViewById(R.id.attachment_main);
        main_content.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,kybordSize));
//        close_send_btn.setOnClickListener((v)->{
//                attachWindow.close_send_btn();
//            });
        setRecentImages();
        _updateCloseBtn();

        attachWindow.showAtLocation(bottom_container, Gravity.END,0,15000);
    }

    void setRecentImages(){
        recentImagesView = new RecentImagesView();
        recentImagesView.insertInto(frame_layout);
        recentImagesView.setListener(this);
    }

    public void bindToView(MessagesTable msg) {

    }

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
        int size = recentImagesView.getSelected().size();
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
        int size = recentImagesView.getSelected().size();
        if(size >0 ){
            callback_listner.onRecentImagesClick(recentImagesView.getSelected());
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
        callback_listner.onVideoClick();
    }

    @OnClick(R.id.attach_camera)
    public void attach_camera(){
        callback_listner.onCameraPhotoClick();
    }

    @OnClick(R.id.attach_gallery)
    public void setAttach_gallery(){
        callback_listner.onGalleryClick();
    }

    @OnClick(R.id.attach_file)
    public void setAttach_file(){
        callback_listner.onFileClick();
    }

    @OnClick(R.id.attach_location)
    public void setAttach_location(){
        callback_listner.onLocationClick();
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
