package com.mardomsara.social.ui.cells.chats.msgs;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.mardomsara.social.App;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
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

class MsgImageWrapper {
	@NonNull ChatMediaNetworkLoader image_holder;
	Message msg;

	public MsgImageWrapper(@NonNull ChatMediaNetworkLoader image_holder) {
		this.image_holder = image_holder;
	}

	void bind(@NonNull Message msg){
		this.msg = msg;
		showImage();
		App.getBus().register(this);
		image_holder.x.loading_progress.setIndeterminate(false);

		if(msg.MsgFile_Status >0 );

		if(msg.isMsgByMe()){
			if(msg.MsgFile_Status == Constants.Msg_Media_To_Push_And_Upload || true){
				if( msg.isNetWorkTransferring()){//show uploading

					showUploading();
				}else { //show retry
					showUploadRetery();
				}
			}else { // already uploaded
				image_holder.x.loading_holder.setVisibility(View.GONE);
			}
		} else {
			if(msg.MsgFile_Status == Constants.Msg_Media_To_Push_And_Upload){
				if( msg.isNetWorkTransferring()){//show uploading
					showDownloading();

				}else { //show retry
					showDownload();
				}
			}else { // already downloaded
				image_holder.x.loading_holder.setVisibility(View.GONE);
			}
		}

		/*image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.VISIBLE);

		image_holder.x.loading_progress.setIndeterminate(true);*/

		/*image_holder.x.loading_holder.setOnClickListener((v)->{
			msg.retryUploading();
			image_holder.x.icon_action_btn.setText("&"+System.identityHashCode(image_holder.x.loading_progress) );
		});*/

		/*msg.messageProgressListener = (bytesRead,contentLength, done) ->{
			AndroidUtil.runInUiNoPanic(()->{
				AppUtil.log("Progress Listener "+msg.MessageKey +" " + image_holder.x.loading_progress.getId() + " " +bytesRead+ " "+ contentLength + " "+done);
				image_holder.x.loading_progress.setProgress((bytesRead/contentLength)*100);

			});
		};*/

//			image_holder.x.loading_progress.setProgress(95.0f);

		/*if(msgFile.Status == Constants.Msg_Media_To_Push_And_Upload || msgFile.Status == Constants.Msg_Media_To_Download){
			image_holder.x.cancel_btn.setText("\uf3b5");//"{ion-android-close");
		}else {
			image_holder.x.cancel_btn.setText("\uf2f5");//"{ion-upload}");

		}*/
		image_holder.x.icon_action_btn.setTextSize(16);


	}

	void unbind(@NonNull Message message){
		App.getBus().unregister(this);
	}

	void showImage(){
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
	}

	void showDownload(){
		image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.GONE);
		image_holder.x.icon_action_btn.setText("&");
		image_holder.x.loading_holder.setOnClickListener((v)->{msg.retryDownloading();});
	}

	void showDownloading(){
		image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.VISIBLE);
		image_holder.x.icon_action_btn.setText("close X");
		image_holder.x.loading_holder.setOnClickListener((v)->{msg.cancelDownloading();});
	}

	void showUploadRetery(){
		image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.GONE);
		image_holder.x.icon_action_btn.setText("^");
		image_holder.x.loading_holder.setOnClickListener((v)->{
			showUploading();
			msg.retryUploading();
		});
	}

	void showUploading(){
		image_holder.x.loading_progress.setProgress(5);
		msg.messageProgressListener = (bytesRead,contentLength, done) ->{
			AppUtil.log("Progress Listener "+bytesRead+ " "+ contentLength + " "+done);
			AndroidUtil.runInUiNoPanic(()->{
				AppUtil.log("Progress Listener UI "+msg.MessageKey +" " + image_holder.x.loading_progress.getId() + " " +bytesRead+ " "+ contentLength + " "+done);
				image_holder.x.loading_progress.setProgress((bytesRead/contentLength)*100);

			});
		};
		image_holder.x.loading_holder.setVisibility(View.VISIBLE);
		image_holder.x.loading_progress.setVisibility(View.VISIBLE);
		image_holder.x.icon_action_btn.setText("up X");
		image_holder.x.loading_holder.setOnClickListener((v)->{msg.cancelUploading();});
	}

	void hideUi(){

	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	void so(Message msg){

	}




}
