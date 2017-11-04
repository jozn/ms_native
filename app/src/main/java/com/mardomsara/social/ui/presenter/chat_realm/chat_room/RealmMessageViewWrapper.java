package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import android.support.annotation.NonNull;

import com.mardomsara.base_rv.entity.MultiItemEntity;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Req;
import com.mardomsara.social.base.Http.listener.DownloadProgressListener;
import com.mardomsara.social.base.Http.listener.UploadProgressListener;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.models_old.interfaces.MessageProgressListener;
import com.mardomsara.social.models_realm.helpers.HelperMessageFile;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

import org.greenrobot.essentials.io.FileUtils;

import java.io.File;
import java.io.IOException;

import ir.ms.pb.PB_ChatParam_AddNewMessage;
import ir.ms.pb.PB_CommandToServer;
import ir.ms.pb.PB_MessageView;
import ir.ms.pb.RPC;
import ir.ms.pb.RPC_API;
import ir.ms.pb.RoomMessageTypeEnum;

/**
 * Created by Hamid on 9/10/2017.
 */

public class RealmMessageViewWrapper implements MultiItemEntity, UploadProgressListener, DownloadProgressListener {
	@NonNull
	public RealmMessageView messageView;
	public Long MessageBankKey;
	public MessageProgressListener messageProgressListener;
	public transient Req req;
	private boolean isNetWorkTransferring = false;

	private RealmMessageViewWrapper() {
	}

	public RealmMessageViewWrapper(@NonNull RealmMessageView messageView) {
		this.messageView = messageView;
		MessageBankKey = Long.valueOf(messageView.MessageId);
	}

	@Override
	public int getItemType() {
		return messageView.MessageTypeEnumId;
	}

	@Override
	public void onUploadProgress(long bytesRead, long contentLength, boolean done) {
		if(done){
			setNetWorkTransferring(false);
		}

		if (messageProgressListener != null) {
			messageProgressListener.onProgress(bytesRead, contentLength, done);
		}
	}

	@Override
	public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
		if(done){
			setNetWorkTransferring(false);
		}

		if (messageProgressListener != null) {
			messageProgressListener.onProgress(bytesRead, contentLength, done);
		}
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
		AndroidUtil.runInUiNoPanic(()->{
			Helper.showDebugMessage("upload ");
			setNetWorkTransferring(true);
			AndroidUtil.runInBackgroundNoPanic(() -> {
//			if(MessageTypeId == Constants.MESSAGE_IMAGE){
			/*File file = new File(MsgFile_LocalSrc);
			MsgsCallToServer.sendNewPhoto(this, file, null, false);*/
//			}
			});

			switch (RoomMessageTypeEnum.forNumber(messageView.MessageTypeEnumId)){
				case TEXT:
				case EMOJI:
					PB_MessageView.Builder pb_messageView_builder =RealmMessageView.toPB_Builder(messageView);
					PB_ChatParam_AddNewMessage param = PB_ChatParam_AddNewMessage.newBuilder()
						.setMessageView(pb_messageView_builder.build())
						.build();
					RPC.RPC_Chat.AddNewMessage(param,null,null);
					break;
				default:
					uploadMsg();
			}
		});

	}

	public void retryDownloading() {
		Helper.showDebugMessage("retryDownloading");
		setNetWorkTransferring(true);
//		MessageModel.downloadForceMessageMediaFile(this);
		RealmMessageFileView f = messageView.MessageFileView;
		if (f != null) {
			HelperMessageFile.setLocalPathInNecessary(f);
			req = HelperMessageFile.downloadForceMessageMediaFile(f.ServerSrc, f.LocalSrc, this);
		}
	}

	public void cancelDownloading() {
		setNetWorkTransferring(false);
		if (req != null) {
			req.cancel();
		}
	}

	private void uploadMsg(){
		PB_MessageView.Builder pb_messageView_builder =RealmMessageView.toPB_Builder(messageView);
		byte[] fileBytes = null;
		if(messageView.MessageFileView != null){
			pb_messageView_builder.setMessageFileView(RealmMessageFileView.toPB(messageView.MessageFileView));
			/////////////////
			File file = new File(messageView.MessageFileView.LocalSrc);
			try {
				fileBytes = FileUtils.readBytes(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		PB_ChatParam_AddNewMessage.Builder pb_msgParam_addNewMessageBuilder = PB_ChatParam_AddNewMessage.newBuilder()
			.setMessageView(pb_messageView_builder.build());

		if(fileBytes != null){
			pb_msgParam_addNewMessageBuilder.setBlob(com.google.protobuf.ByteString.copyFrom(fileBytes));
		}

		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommand(RPC_API.RPC_Chat.AddNewMessage)
			.setData(pb_msgParam_addNewMessageBuilder.build().toByteString())
			.build();

		req = Http.sendBlobPath("/v1/rpc_call",pb_commandToServer.toByteArray())
			.setUploadProgress(this)
			.doAsyncUi(
				(result)->{
					//Helper.showDebugMessage("sendNewPhoto "+result.isOk());
					setNetWorkTransferring(false);
					if (result.isOk()){
						Helper.showDebugMessage("Message (media) was uploaded - " + result.toString());
						/*//Helper.showDebugMessage("sendNewPhoto ok");
						msg.setMsgFile_Status((Constants.Msg_Media_Uploaded));
						msg.setToPush(0);
						msg.ServerReceivedTime = TimeUtil.getTimeSec();
						msg.saveWithRoom();
						if(deleteOrginal == true &&  fileOriginal != null){
							fileOriginal.delete();
						}

						MsgReceivedToServerEvent.publishNew(msg);
						sendRecivedEvent(msg);*/
					}else {

					}
				});
	}

}
