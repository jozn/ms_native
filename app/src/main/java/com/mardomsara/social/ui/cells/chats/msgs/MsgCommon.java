package com.mardomsara.social.ui.cells.chats.msgs;

import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgFile;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.social.ui.views.FullScreenImage;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.wigets.ChatMediaNetworkLoader;

import java.io.File;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCommon {
    public static String msgRawTime2(Message msg){
        return FormaterUtil.timeToClockTimeMs(msg.CreatedMs);
    }

    public static String msgRawTime(Message msg){
        return FormaterUtil.timeToClockTimeMs(msg.CreatedMs);
    }

    public static void setTextForImages(Message msg , TextView textView){
        String txt = msg.Text;
        textView.setText(txt);
        if(txt == null || txt.equals("")){
            textView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.VISIBLE);
        }
    }

    public static void setImage_DEP(Message msg , ImageView image_iew){
		MsgFile msgFile = msg.getMsgFile();
		if (msgFile!=null) {
			image_iew.setVisibility(View.VISIBLE);
			File file = new File(msgFile.LocalSrc);
			int max_width = (int) (AndroidUtil.getScreenWidth() * 0.80);
			AppUtil.log("width: "+max_width+AndroidUtil.getScreenResolution()+AndroidUtil.getDensity());
			max_width = AndroidUtil.pxToDp(max_width);
			ViewHelper.setImageSizesWithMaxPx(image_iew, max_width -2,max_width, msgFile.Width,msgFile.Height);
			file.toURI();
			Uri u2 =Uri.fromFile(file);
			image_iew.setImageURI(u2);

			image_iew.setOnClickListener((v)->{
				FullScreenImage window = new FullScreenImage();
				window.text = msg.Text;
				window.imageUri = u2 ;//msg.getMediaLocalSrc();
				window.show();
			});
		}else {
			image_iew.setVisibility(View.GONE);
		}
    }

	//////////////////////// Image and Network Loader ////////////////////////////////
	@Deprecated
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
						image_holder.x.loading_progress.setVisibility(View.VISIBLE);
						image_holder.x.icon_action_btn.setText("close X");
						image_holder.x.loading_holder.setOnClickListener((v)->{msg.cancelUploading();});
						/*msg.messageProgressListener = (bytesRead,contentLength, done) ->{
							AppUtil.log("Progress Listener "+bytesRead+ " "+ contentLength + " "+done);
						};*/
					}else { //show retry
						image_holder.x.loading_holder.setVisibility(View.VISIBLE);
						image_holder.x.loading_progress.setVisibility(View.GONE);
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
						image_holder.x.loading_progress.setVisibility(View.VISIBLE);
						image_holder.x.icon_action_btn.setText("close X");
						image_holder.x.loading_holder.setOnClickListener((v)->{msg.cancelDownloading();});

					}else { //show retry
						image_holder.x.loading_holder.setVisibility(View.VISIBLE);
						image_holder.x.loading_progress.setVisibility(View.GONE);
						image_holder.x.icon_action_btn.setText("&");
						image_holder.x.loading_holder.setOnClickListener((v)->{msg.retryDownloading();});
					}
				}else { // already downloaded
					image_holder.x.loading_holder.setVisibility(View.GONE);
				}
			}

			/*image_holder.x.loading_holder.setVisibility(View.VISIBLE);
			image_holder.x.loading_progress.setVisibility(View.VISIBLE);

			image_holder.x.loading_progress.setIndeterminate(true);
			image_holder.x.loading_progress.setIndeterminate(false);

			image_holder.x.loading_holder.setOnClickListener((v)->{
				msg.retryUploading();
				image_holder.x.icon_action_btn.setText("&"+image_holder.x.loading_progress.hashCode() );
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
				image_holder.x.loading_progress.setProgress(image_holder.x.loading_progress.getMaxProgress()+10);

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

	public static void setVideoImage(Message msg , ImageView msg_image) {
		int max_width = (int) (AndroidUtil.getScreenWidth() * 0.88);
		AppUtil.log("width: "+max_width+AndroidUtil.getScreenResolution()+AndroidUtil.getDensity());
		max_width = AndroidUtil.pxToDp(max_width);
		MsgFile msgFile = msg.getMsgFile();
		if(msgFile != null){
			File file = new File(msgFile.LocalSrc);
			ViewHelper.setImageSizesWithMaxPx(msg_image, max_width, msgFile.Width , msgFile.Height );
			file.toURI();
			Uri u2 =Uri.fromFile(file);
			msg_image.setImageURI(u2);
		}
	}


    ///////////////////////////////////////////////

    static String _wating = "\uf402"; //ion-ios-clock-outline
    static String _recived_server = "\uf383";//ion-android-done
    static String _recived_peer = "\uf382";//ion-android-done-all
    static String _seen_peer = "\uf382";//ion-android-done-all
    //    static String seenColor = ""
    static String geryColor = "";

    static int defualtColor = Color.argb(255, 100, 100, 100);
    static int seenColor = Color.argb(255, 50, 50, 255);

    public static void msgDeliveryStatusText(Message msg, TextView textView){
        if(msg == null || textView == null) return;
        String icon =_wating;
        boolean isSeen = false;
        int color = R.color.light_gery_dark;
        if(msg.IsByMe == 1) {

            if(msg.isReceivedToServer()) icon =  _recived_server;
            if(msg.isReceivedToPeer()) icon =  _recived_peer;
            if(msg.issSeenByPeer()) isSeen = true;
//            if(msg.issSeenByPeer()) color = R.color.colorAccent;

            textView.setTypeface(FontCache.get(AndroidUtil.getString(R.string.font_ionic)));
            textView.setText(icon);
            if(isSeen){
                textView.setTextColor(seenColor);
            }else {
                textView.setTextColor(defualtColor);
            }
        }
    }
}
