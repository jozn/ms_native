package com.mardomsara.social.ui.cells.chats.msgs;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.mardomsara.social.App;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.interfaces.MessageProgressListener;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgFile;
import com.mardomsara.social.ui.views.FullScreenImage;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.wigets.ChatMediaNetworkLoader;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
		//		App.getBus().register(this);
		run();
	}

	void unbind(@NonNull Message message){
		message.messageProgressListener = null;
//		App.getBus().unregister(this);
	}

	void run(){
		showImage();
		image_holder.x.loading_progress.setIndeterminate(false);

		MsgFile msgFile = msg.getMsgFile();
		if(msgFile == null)return;
		if(msg.MsgFile_Status >0 );

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
			if(msgFile.Status == Constants.Msg_Media_To_Push_And_Upload){
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
		try {
			ImageView image_view = image_holder.x.msg_image;
			MsgFile msgFile = msg.getMsgFile();

			File file = new File(msgFile.LocalSrc);
			if (msgFile!=null && file.exists()) {

				int max_width = (int) (AndroidUtil.getScreenWidth() * 0.80);
				AppUtil.log("width: "+max_width+AndroidUtil.getScreenResolution()+AndroidUtil.getDensity());
				max_width = AndroidUtil.pxToDp(max_width);
				ViewHelper.setImageSizesWithMaxPx(image_view, max_width -2,max_width, msgFile.Width,msgFile.Height);
				file.toURI();
				Uri u2 =Uri.fromFile(file);
				image_view.setImageURI(u2);

				image_view.setOnClickListener((v)->{
					FullScreenImage window = new FullScreenImage();
					window.text = msg.Text;
					window.imageUri = u2 ;//msg.getMediaLocalSrc();
					window.show();
				});
			}else {
				image_view.setVisibility(View.GONE);
			}
		}catch (Exception e){
			e.printStackTrace();
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
		image_holder.x.loading_progress.setProgress(2);
		msg.messageProgressListener = this;
		image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.VISIBLE);
		image_holder.x.icon_action_btn.setText(iconClose);
		image_holder.x.loading_holder.setOnClickListener((v)->{msg.cancelUploading();});
	}

	void hideUi(){

	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	void so(Message msg){

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
