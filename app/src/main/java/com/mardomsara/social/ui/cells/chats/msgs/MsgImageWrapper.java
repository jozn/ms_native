package com.mardomsara.social.ui.cells.chats.msgs;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.mardomsara.social.R;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.interfaces.MessageProgressListener;
import com.mardomsara.social.models.Message;
import com.mardomsara.social.models.MsgFile;
import com.mardomsara.social.ui.views.FullScreenImage_Fresco;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.wigets.ChatMediaNetworkLoader;

import java.io.File;

/**
 * Created by Hamid on 2/10/2017.
 */

class MsgImageWrapper implements MessageProgressListener {
	private final String iconClose = "\uf404";
	private final String iconUpload = "\uf40a";
	private final String iconDownload = "\uf407";

	@NonNull ChatMediaNetworkLoader image_holder;
	Message msg;

	public MsgImageWrapper(@NonNull ChatMediaNetworkLoader image_holder) {
		this.image_holder = image_holder;
	}

	void bind(@NonNull Message msg) {
		this.msg = msg;
		msg.messageProgressListener = this;
		run();
	}

	void unbind(@NonNull Message message){
		message.messageProgressListener = null;
	}

	void run(){
		showImage();
		image_holder.x.loading_progress.setIndeterminate(false);

		MsgFile msgFile = msg.getMsgFile();
		if(msgFile == null)return;//should not happen
		File file = new File(msgFile.LocalSrc);

		if(msg.isMsgByMe()){
			if(msg.needPush()){
				if( msg.isNetWorkTransferring()){//show uploading
					showUploading();
				}else { //show retry
					showUploadRetery();
				}
			}else { // already uploaded
				image_holder.x.loading_holder.setVisibility(View.GONE);
			}
		} else {
			if( (!file.exists()) || msgFile.Status < Constants.Msg_Media_Downloaded){
				if( msg.isNetWorkTransferring()){//show uploading
					showDownloading();

				}else { //show retry
					showDownload();
				}
			}else { // already downloaded
				image_holder.x.loading_holder.setVisibility(View.GONE);
			}
		}

		image_holder.x.icon_action_btn.setTextSize(TypedValue.COMPLEX_UNIT_DIP,42);
	}

	void showImage(){
		ImageView image_view = image_holder.x.msg_image;
		MsgFile msgFile = msg.getMsgFile();

		try {
			image_view.setVisibility(View.VISIBLE);

			File file = new File(msgFile.LocalSrc);
			if (msgFile!=null ) {
				int max_width = (int) (AndroidUtil.getScreenWidth() * 0.80);
				AppUtil.log("width: "+max_width+AndroidUtil.getScreenResolution()+AndroidUtil.getDensity());
				max_width = AndroidUtil.pxToDp(max_width);
				ViewHelper.setImageSizesWithMaxPx(image_view, max_width -2,max_width, msgFile.Width,msgFile.Height);

				if(file.exists()){
					file.toURI();
					Uri u2 =Uri.fromFile(file);
					image_view.setImageURI(u2);

					image_view.setOnClickListener((v)->{
						FullScreenImage_Fresco window = new FullScreenImage_Fresco();
						window.text = msg.Text;
						window.imageUri = u2 ;
						window.show();
					});
				}else {//just file don't exists
					image_view.setImageDrawable(AndroidUtil.getResources().getDrawable(R.drawable.image_background));
					if(msg.isMsgByMe()){ //msg is by this user and this file is deleted we can't do anything

					}else {//try download

					}
				}
			}else {//should not happen but for more reliability
				image_view.setVisibility(View.INVISIBLE);
			}
		}catch (Exception e){
			e.printStackTrace();
			image_view.setVisibility(View.INVISIBLE);
		}
	}

	void showDownload(){
		image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.GONE);
		image_holder.x.icon_action_btn.setText(iconDownload);
		image_holder.x.loading_holder.setOnClickListener((v)->{msg.retryDownloading();});
	}

	void showDownloading(){
		image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.VISIBLE);
		image_holder.x.icon_action_btn.setText(iconClose);
		image_holder.x.loading_holder.setOnClickListener((v)->{msg.cancelDownloading();});
		image_holder.x.loading_progress.setProgress(2);
	}

	void showUploadRetery(){
		image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.GONE);
		image_holder.x.icon_action_btn.setText(iconUpload);
		image_holder.x.loading_holder.setOnClickListener((v)->{
//			showUploading();
			msg.retryUploading();
		});
	}

	void showUploading(){
//		msg.messageProgressListener = this;
		image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.VISIBLE);
		image_holder.x.icon_action_btn.setText(iconClose);
		image_holder.x.loading_holder.setOnClickListener((v)->{msg.cancelUploading();});
		image_holder.x.loading_progress.setProgress(2);
	}

	void hideUi(){
		image_holder.x.loading_holder.setVisibility(View.GONE);
	}

	@Override
	public void onProgress(long bytesRead, long contentLength, boolean done) {
		AndroidUtil.runInUiNoPanic(()->{
			AppUtil.log("Progress Listener UI "+msg.MessageKey +" " + image_holder.x.loading_progress.getId() + " " +bytesRead+ " "+ contentLength + " "+done);
			image_holder.x.loading_progress.setProgress((bytesRead/contentLength)*100);
		});
	}

	@Override
	public void onCancel() {
		AndroidUtil.runInUiNoPanic(()-> run() );
	}

	@Override
	public void onStatusChanged() {
		AndroidUtil.runInUiNoPanic(()-> run() );
	}
}
