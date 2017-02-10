package com.mardomsara.social.ui.cells.chats.msgs;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.mardomsara.social.app.Constants;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgFile;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.wigets.ChatMediaNetworkLoader;

import java.io.File;

/**
 * Created by Hamid on 2/10/2017.
 */

class MsgPhotoChanger {
	public static void setImage2(@NonNull Message msg , @NonNull ChatMediaNetworkLoader image_holder){
		ImageView image_iew = image_holder.x.msg_image;
		if(msg.MsgFile_Status >0 );
		MsgFile msgFile = msg.getMsgFile();
		if (msgFile!=null) {
			image_iew.setVisibility(View.VISIBLE);

			if(msg.isMsgByMe()){
				if(msg.MsgFile_Status == Constants.Msg_Media_To_Push_And_Upload){
					if( msg.isNetWorkTransferring()){//show uploading
						image_holder.x.loading_holder.setVisibility(View.VISIBLE);
						image_holder.x.loading.setVisibility(View.VISIBLE);
						image_holder.x.icon_action_btn.setText("close X");
						image_holder.x.loading_holder.setOnClickListener((v)->{msg.cancelUploading();});
						msg.messageProgressListener = (bytesRead,contentLength, done) ->{
							AppUtil.log("Progress Listener "+bytesRead+ " "+ contentLength + " "+done);
						};
					}else { //show retry
						image_holder.x.loading_holder.setVisibility(View.VISIBLE);
						image_holder.x.loading.setVisibility(View.GONE);
						image_holder.x.icon_action_btn.setText("^");
						image_holder.x.loading_holder.setOnClickListener((v)->{msg.retryUploading();});
					}
				}else { // already uploaded
					image_holder.x.loading_holder.setVisibility(View.GONE);
				}
			} else {
				if(msg.MsgFile_Status == Constants.Msg_Media_To_Push_And_Upload){
					if( msg.isNetWorkTransferring()){//show uploading
						image_holder.x.loading_holder.setVisibility(View.VISIBLE);
						image_holder.x.loading.setVisibility(View.VISIBLE);
						image_holder.x.icon_action_btn.setText("close X");
						image_holder.x.loading_holder.setOnClickListener((v)->{msg.cancelDownloading();});

					}else { //show retry
						image_holder.x.loading_holder.setVisibility(View.VISIBLE);
						image_holder.x.loading.setVisibility(View.GONE);
						image_holder.x.icon_action_btn.setText("&");
						image_holder.x.loading_holder.setOnClickListener((v)->{msg.retryDownloading();});
					}
				}else { // already downloaded
					image_holder.x.loading_holder.setVisibility(View.GONE);
				}
			}

			/*image_holder.x.loading_holder.setVisibility(View.VISIBLE);
			image_holder.x.loading.setVisibility(View.VISIBLE);

			image_holder.x.loading.setIndeterminate(true);
			image_holder.x.loading.setIndeterminate(false);

			image_holder.x.loading_holder.setOnClickListener((v)->{
				msg.retryUploading();
				image_holder.x.icon_action_btn.setText("&"+image_holder.x.loading.hashCode() );
			});*/

			/*msg.messageProgressListener = (bytesRead,contentLength, done) ->{
				AndroidUtil.runInUiNoPanic(()->{
					AppUtil.log("Progress Listener "+msg.MessageKey +" " + image_holder.x.loading.getId() + " " +bytesRead+ " "+ contentLength + " "+done);
					image_holder.x.loading.setProgress((bytesRead/contentLength)*100);

				});
			};*/

//			image_holder.x.loading.setProgress(95.0f);

			/*if(msgFile.Status == Constants.Msg_Media_To_Push_And_Upload || msgFile.Status == Constants.Msg_Media_To_Download){
				image_holder.x.cancel_btn.setText("\uf3b5");//"{ion-android-close");
			}else {
				image_holder.x.cancel_btn.setText("\uf2f5");//"{ion-upload}");

			}*/
			image_holder.x.icon_action_btn.setTextSize(16);

			File file = new File(msgFile.LocalSrc);
			int max_width = (int) (AndroidUtil.getScreenWidth() * 0.80);
			AppUtil.log("width: "+max_width+AndroidUtil.getScreenResolution()+AndroidUtil.getDensity());
			max_width = AndroidUtil.pxToDp(max_width);
			ViewHelper.setImageSizesWithMaxPx(image_iew, max_width -2,max_width, msgFile.Width,msgFile.Height);
			file.toURI();
			Uri u2 =Uri.fromFile(file);
			image_iew.setImageURI(u2);

			Float p = 10f;
			image_iew.setOnClickListener((v)->{
				image_holder.x.loading.setProgress(image_holder.x.loading.getMaxProgress()+10);

				;
				/*FullScreenImage window = new FullScreenImage();
				window.text = msg.Text;
				window.imageUri = u2 ;//msg.getMediaLocalSrc();
				window.show();*/
			});
		}else {
			image_iew.setVisibility(View.GONE);
		}
	}
}
