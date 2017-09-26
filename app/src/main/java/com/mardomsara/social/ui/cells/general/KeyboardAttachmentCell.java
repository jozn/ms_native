package com.mardomsara.social.ui.cells.general;

import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.models_old.stores.Store;
import com.mardomsara.social.models_old.stores.StoreConstants;
import com.mardomsara.social.ui.X;

import java.util.List;

/**
 * Created by Hamid on 6/15/2016.
 */
//todo [onDownloadProgress DON'T] migrate to dataBinding: on xml setOrReplace onClick={callback_listener.onPhotoClick()}
public class KeyboardAttachmentCell implements RecentImagesCell.onRecentImageClicked{

	X.KeywoardAttachment x;

    @NonNull
	KeyboardAttachmentListener callback_listener;
    @NonNull RecentImagesCell recentImagesCell;
    @NonNull PopupWindow attachWindow;

    int keyboardSize = Store.getInt(StoreConstants.KEYBOARD_SIZE, (int) (AndroidUtil.getScreenHeight()/2.5));

    public KeyboardAttachmentCell(KeyboardAttachmentListener listener, View bottom_container) {
        callback_listener = listener;
		x = new X.KeywoardAttachment();

        attachWindow = new PopupWindow(
                x.root,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);//keyboardSize);

        //view containg icons
        View main_content = x.root.findViewById(R.id.attachment_main);
        main_content.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, keyboardSize));

        setRecentImages();
        _updateCloseBtn();
		setListerns();

        attachWindow.showAtLocation(bottom_container, Gravity.END,0,15000);
    }

    void setRecentImages(){
        recentImagesCell = new RecentImagesCell(x.frame_layout);
        recentImagesCell.insertInto(x.frame_layout);
        recentImagesCell.setListener(this);
    }

    void setListerns(){
		x.close_send_btn.setOnClickListener((v) -> sendRecentImagesOrClose() );
		x.attachment_top.setOnClickListener((v) -> topClicked() );
		x.attach_video.setOnClickListener((v) -> attach_video() );
		x.attach_camera.setOnClickListener((v) -> attach_camera() );
		x.attach_gallery.setOnClickListener((v) -> attach_gallery() );
		x.attach_audio.setOnClickListener((v) -> attach_audio() );
		x.attach_file.setOnClickListener((v) -> attach_file() );
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
        int size = recentImagesCell.getSelected().size();
        if(size >0 ){
            x.close_icon.setText("\uf2f6");
            x.close_text.setText("بفرس("+size +")");
            x.close_icon.setTextColor(AndroidUtil.getColor(R.color.btn_send));
        }else {//clse
            x.close_icon.setText("\uf404");
            x.close_text.setText("بستن");
            x.close_icon.setTextColor(AndroidUtil.getColor(R.color.btn_close));

        }
    }

    public void dismiss(){
        attachWindow.dismiss();
    }

    void sendRecentImagesOrClose(){
        int size = recentImagesCell.getSelected().size();
        if(size >0 ){
            callback_listener.onRecentImagesSendClicked(recentImagesCell.getSelected());
        }else {//clse
           dismiss();
        }
    }

    void topClicked(){
        dismiss();
    }

    public void attach_video(){
        callback_listener.onVideoClick();
    }

    public void attach_camera(){
        callback_listener.onCameraPhotoClick();
    }

    public void attach_gallery(){
        callback_listener.onGalleryClick();
    }

    public void attach_audio(){
        callback_listener.onAudioClick();
    }


	public void attach_file(){
		callback_listener.onFileClick();
	}


    public interface KeyboardAttachmentListener {
        void onCameraPhotoClick();
        void onGalleryClick();
        void onVideoClick();
        void onAudioClick();
        void onLocationClick();
        void onFileClick();
        void onContactClick();
        void onRecentImagesSendClicked(List<String> imagesPath);
    }
}
