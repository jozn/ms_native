package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import android.support.annotation.NonNull;

import com.mardomsara.base_rv.entity.MultiItemEntity;
import com.mardomsara.social.base.Http.Req;
import com.mardomsara.social.base.Http.listener.DownloadProgressListener;
import com.mardomsara.social.base.Http.listener.UploadProgressListener;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.models.interfaces.MessageProgressListener;
import com.mardomsara.social.models_realm.helpers.HelperMessageFile;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

/**
 * Created by Hamid on 9/10/2017.
 */

public class RealmMessageViewWrapper implements MultiItemEntity, UploadProgressListener, DownloadProgressListener {
	@NonNull public RealmMessageView messageView;
	public MessageProgressListener messageProgressListener;
	public transient Req req;
	private boolean isNetWorkTransferring = false;

	@Override
	public int getItemType() {
		return messageView.MessageTypeEnumId;
	}

	@Override
	public void onUploadProgress(long bytesRead, long contentLength, boolean done) {

	}

	@Override
	public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {

	}

	public boolean isNetWorkTransferring() {
		return isNetWorkTransferring;
	}

	public void setNetWorkTransferring(boolean netWorkTransferring) {
		isNetWorkTransferring = netWorkTransferring;
		if (messageProgressListener != null) {
			messageProgressListener.onStatusChanged();
		}
	}

	public void cancelUploading() {
		Helper.showDebugMessage("cancelUploading ");
		setNetWorkTransferring(false);
		if (req != null) {
			req.cancel();
		}
	}

	public void retryUploading() {
		Helper.showDebugMessage("upload ");
		setNetWorkTransferring(true);
		AndroidUtil.runInBackgroundNoPanic(() -> {
//			if(MessageTypeId == Constants.MESSAGE_IMAGE){
			/*File file = new File(MsgFile_LocalSrc);
			MsgsCallToServer.sendNewPhoto(this, file, null, false);*/
//			}
		});
	}

	public void retryDownloading() {
		Helper.showDebugMessage("retryDownloading");
		setNetWorkTransferring(true);
//		MessageModel.downloadForceMessageMediaFile(this);
		RealmMessageFileView f = messageView.MessageFileView;
		if (f != null) {
			HelperMessageFile.setLocalPathInNecessary(f);
			HelperMessageFile.downloadForceMessageMediaFile(f.ServerSrc, f.LocalSrc, this);
		}
	}

	public void cancelDownloading() {
		setNetWorkTransferring(false);
		if (req != null) {
			req.cancel();
		}
	}

}
