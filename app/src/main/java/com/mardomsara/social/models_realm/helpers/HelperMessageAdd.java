package com.mardomsara.social.models_realm.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.HashUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.UtilText;
import com.mardomsara.social.lib.NanoTimestamp;
import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.models_realm.RealmChatViewHelper;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

import org.apache.commons.io.FileUtils;

import java.io.File;

import io.realm.Realm;
import ir.ms.pb.PB_MessageFileView;
import ir.ms.pb.RoomMessageDeliviryStatusEnum;
import ir.ms.pb.RoomMessageTypeEnum;

/**
 * Created by Hamid on 9/11/2017.
 */

public final class HelperMessageAdd {

	public static void addNewTextMessage(@NonNull RealmChatView chatView, @NonNull String text) {
		Realm realm = AppRealm.getChatRealm();

		RealmMessageView r = new RealmMessageView();

		r.MessageId = NanoTimestamp.getNano();//0
		r.MessageKey = HelperMessageUtil.getNewMessageKey(chatView.RoomKey);//0
		r.RoomKey = chatView.RoomKey;//1
		r.UserId = chatView.UserId;//2
		r.MessageFileId = 0;//3
		r.MessageTypeEnumId = RoomMessageTypeEnum.TEXT_VALUE;//4
		r.Text = text;//5
		r.CreatedSe = (int) AppUtil.getTime();//6
		r.PeerReceivedTime = 0;//7
		r.PeerSeenTime = 0;//8
		r.DeliviryStatusEnumId = RoomMessageDeliviryStatusEnum.NEED_TO_SINK_VALUE;//9
		r.ChatKey = chatView.ChatKey;//10
		r.RoomTypeEnumId = chatView.RoomTypeEnumId;//11
		r.IsByMe = true;//12

		if (UtilText.isJustEmoji(text)) {
			r.MessageTypeEnumId = RoomMessageTypeEnum.EMOJI_VALUE;//4
		}

		String chatKey = chatView.ChatKey;

		RealmMessageView lastMsg;
		realm.beginTransaction();
		lastMsg = realm.copyToRealmOrUpdate(r);
		realm.commitTransaction();
		Helper.showDebugMessage("lastMsg: " + lastMsg.Text);

		HelperMessagesSinker.sinkAll();

		RealmChatView chatView2 = RealmChatViewHelper.getChatByChatKey(AppRealm.getChatRealm(), chatKey);
		if (chatView2 != null) {
			AppRealm.getChatRealm().executeTransaction((re) -> {
				chatView2.UpdatedMs = AppUtil.getTimeMs();
				chatView2.LastMessage = lastMsg;
			});
		}

	}

	public static void addSingleImageMessage(@NonNull RealmChatView chatView, @NonNull String text, String path, final boolean deleteOriginal) {
		Log.i("MSG", "addSingleImageMessage(): " + path + " " + deleteOriginal);
		if (path == null || path.equals("")) return;
		File fileOriginal = new File(path);
		if (!fileOriginal.exists()) {
			_showToastFileAreNotExist();
			return;
		}

		RealmMessageView messageView = getNewMessage(chatView);
		if (messageView != null) {
			messageView.MessageFileView = getNewRealmMessageFileView(chatView, path);
			if (messageView.MessageFileView == null) return;
			messageView.MessageFileId = messageView.MessageFileView.MessageFileId;

			String outputSentSrc = HelperMessageFilePather.getMessageFileOutputNameForNewSentImage(messageView.MessageFileView.MessageFileId, FileUtil.getFileExtensionWithDot(path));
			ImageUtil.resizeImage(path, outputSentSrc, 1080);
			File resizedFile = new File(outputSentSrc);

			messageView.MessageFileView.LocalSrc = outputSentSrc;

			if (!resizedFile.exists()) {
				_showToastFileAreNotExist();
				return;
			}

			if (text == null || text.equals("")) {
				messageView.MessageTypeEnumId = RoomMessageTypeEnum.IMAGE_VALUE;
				messageView.Text = "";
			} else {
				messageView.MessageTypeEnumId = RoomMessageTypeEnum.IMAGE_TEXT_VALUE;
				messageView.Text = text;
			}

			saveNewMessageWithChatViewUpdate_Here(chatView.ChatKey, messageView);
		}

		HelperMessagesSinker.sinkAll();
	}

	private static RealmMessageFileView getNewRealmMessageFileView(RealmChatView chatView, String filePath) {
		RealmMessageFileView r = new RealmMessageFileView();
		try {
			File file = new File(filePath);
			Bitmap mBitmap = BitmapFactory.decodeFile(filePath);
			PB_MessageFileView.Builder b = PB_MessageFileView.newBuilder();

			b.setMessageFileId(NanoTimestamp.getNano());//0
			b.setMessageFileKey(HelperMessageUtil.getNewMessageKey(chatView.RoomKey));//1
			b.setOriginalUserId(Session.getUserId());//2
			b.setName(file.getName());//3
			b.setSize((int) file.length());//4
			b.setFileTypeEnumId(RoomMessageTypeEnum.IMAGE_VALUE);//5
			b.setWidth(mBitmap.getWidth());//6
			b.setHeight(mBitmap.getHeight());//7
			b.setDuration(0);//8
			b.setExtension(FileUtil.getFileExtensionWithDot(filePath));//9
			b.setHashMd5(HashUtil.toMD5(FileUtils.readFileToByteArray(file)));//10
			b.setHashAccess(0);//11
			b.setCreatedSe((int) AppUtil.getTime());//12
			b.setServerSrc("");//13
			b.setServerPath("");//14
			b.setServerThumbPath("");//15
			b.setBucketId("");//16
			b.setServerId(0);//17
			b.setCanDel(0);//18
			b.setServerThumbLocalSrc("");//19
			b.setRemoteMessageFileId(0);//20
			b.setLocalSrc(filePath);//21
			b.setThumbLocalSrc("");//22
//			b.setMessageFileStatusId();//23

			r = RealmMessageFileView.fromPB(b.build());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return r;
	}

	private static void _showToastFileAreNotExist() {
		Helper.showMessage("فایل موجود نیست");
	}


	private static RealmMessageView getNewMessage(RealmChatView chatView) {
		RealmMessageView r = new RealmMessageView();

		r.MessageId = NanoTimestamp.getNano();//0
		r.MessageKey = HelperMessageUtil.getNewMessageKey(chatView.RoomKey);
		r.RoomKey = chatView.RoomKey;//1
		r.UserId = chatView.UserId;//2
		r.MessageFileId = 0;//3
		r.MessageTypeEnumId = RoomMessageTypeEnum.TEXT_VALUE;//4
		r.Text = "";//5
		r.CreatedSe = (int) AppUtil.getTime();//6
		r.PeerReceivedTime = 0;//7
		r.PeerSeenTime = 0;//8
		r.DeliviryStatusEnumId = RoomMessageDeliviryStatusEnum.NEED_TO_SINK_VALUE;//9
		r.ChatKey = chatView.ChatKey;//10
		r.RoomTypeEnumId = chatView.RoomTypeEnumId;//11
		r.IsByMe = true;//12

		return r;
	}

	private static void saveNewMessageWithChatViewUpdate_Here(String chatKey, RealmMessageView newMsg) {
//		String chatKey = chatView.ChatKey;
		Realm realm = AppRealm.getChatRealm();
		RealmMessageView lastMsg;
		realm.beginTransaction();
		lastMsg = realm.copyToRealmOrUpdate(newMsg);
		realm.commitTransaction();
		Helper.showDebugMessage("lastMsg: " + lastMsg.Text);

		RealmChatView chatView2 = RealmChatViewHelper.getChatByChatKey(AppRealm.getChatRealm(), chatKey);
		if (chatView2 != null) {
			AppRealm.getChatRealm().executeTransaction((re) -> {
				chatView2.UpdatedMs = AppUtil.getTimeMs();
				chatView2.LastMessage = lastMsg;
//				re.copyToRealmOrUpdate(chatView2);
			});
		}
	}
}
