package com.mardomsara.social.models_realm.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;

import com.mardomsara.social.app.MSRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.HashUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.UtilText;
import com.mardomsara.social.lib.NanoTimestamp;
import com.mardomsara.social.models_realm.RealmChatViewHelper;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

import org.apache.commons.io.FileUtils;

import java.io.File;

import io.realm.Realm;
import ir.ms.pb.RoomMessageDeliviryStatusEnum;
import ir.ms.pb.RoomMessageTypeEnum;

/**
 * Created by Hamid on 9/11/2017.
 */

public final class HelperMessageAdd {

	public static void addNewTextMessage(@NonNull RealmChatView chatView, @NonNull String text) {
		Realm realm = MSRealm.getChatRealm();

		RealmMessageView r = new RealmMessageView();

		r.MessageId = NanoTimestamp.getNano();//0
		r.RoomKey = chatView.ChatKey;//1
		r.UserId = chatView.UserId;//2
		r.MessageFileId = 0;//3
		r.MessageTypeEnumId = RoomMessageTypeEnum.TEXT_VALUE;//4
		r.Text = text;//5
		r.Time = (int) AppUtil.getTime();//6
		r.PeerReceivedTime = 0;//7
		r.PeerSeenTime = 0;//8
		r.DeliviryStatusEnumId = RoomMessageDeliviryStatusEnum.NEED_TO_SINK_VALUE;//9
		r.ChatId = chatView.ChatId;//10
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

		RealmChatView chatView2 = RealmChatViewHelper.getChatByChatKey(MSRealm.getChatRealm(), chatKey);
		if (chatView2 != null) {
			MSRealm.getChatRealm().executeTransaction((re) -> {
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
			String outputSentSrc = HelperMessageFilePather.getMessageFileOutputNameForSent(messageView.MessageFileView.MessageFileId, FileUtil.getFileExtensionWithDot(path));
			ImageUtil.resizeImage(path, outputSentSrc, 1080);
			File resizedFile = new File(outputSentSrc);

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

			messageView.MessageFileView = setPhotoParams_ME(messageView, path);
			messageView.MessageFileView.LocalSrc = outputSentSrc;
			messageView.MessageFileId = messageView.MessageFileView.MessageFileId;

			saveNewMessageWithChatViewUpdate_Here(chatView.ChatKey, messageView);
		}
	}

	private static RealmMessageFileView setPhotoParams_ME(RealmMessageView msg, String filePath) {
		RealmMessageFileView r = new RealmMessageFileView();
		try {

			File file = new File(filePath);

			Bitmap mBitmap = BitmapFactory.decodeFile(filePath);

			r.MessageFileId = NanoTimestamp.getNano();//0
			r.Name = "";//1
			r.Size = (int) file.length();//2
			r.FileTypeEnumId = 0;//3
//			r.MimeType = file.getName();//4
			r.Width = mBitmap.getWidth();//5
			r.Height = mBitmap.getHeight();//6
			r.Duration = 0;//7
			r.Extension = FileUtil.getFileExtensionWithDot(filePath);//8
//			r.ThumbData64 ="" ;//9
			r.ServerSrc = "";//10
			r.ServerPath = "";//11
			r.ServerThumbPath = "";//12
			r.BucketId = "";//13
			r.ServerId = 0;//14
			r.CanDel = 1;//15
			r.CreatedSe = (int) AppUtil.getTime();//16

			r.RemoteMessageFileId = 0;
			r.HashMd5 = HashUtil.toMD5(FileUtils.readFileToByteArray(file));

			/*msgFile.Thumb64 = ImageUtil.blurThumbnailToBase64(mBitmap);
			msgFile.ThumbData = ImageUtil.blurThumbnailToBytesArray(mBitmap);
			msgFile.Height = mBitmap.getHeight();
			msgFile.Width = mBitmap.getWidth();
			msgFile.LocalSrc = filePath;
			msgFile.Size = (int)file.length();
			msgFile.Name = file.getName();
			msgFile.Duration = 0;
			msgFile.Origin = Constants.Msg_Media_Origin_Here;*/
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
		r.RoomKey = chatView.ChatKey;//1
		r.UserId = chatView.UserId;//2
		r.MessageFileId = 0;//3
		r.MessageTypeEnumId = RoomMessageTypeEnum.TEXT_VALUE;//4
		r.Text = "";//5
		r.Time = (int) AppUtil.getTime();//6
		r.PeerReceivedTime = 0;//7
		r.PeerSeenTime = 0;//8
		r.DeliviryStatusEnumId = RoomMessageDeliviryStatusEnum.NEED_TO_SINK_VALUE;//9
		r.ChatId = chatView.ChatId;//10
		r.RoomTypeEnumId = chatView.RoomTypeEnumId;//11
		r.IsByMe = true;//12

		return r;
	}

	private static void saveNewMessageWithChatViewUpdate_Here(String chatKey, RealmMessageView newMsg) {
//		String chatKey = chatView.ChatKey;
		Realm realm = MSRealm.getChatRealm();
		RealmMessageView lastMsg;
		realm.beginTransaction();
		lastMsg = realm.copyToRealmOrUpdate(newMsg);
		realm.commitTransaction();
		Helper.showDebugMessage("lastMsg: " + lastMsg.Text);

		RealmChatView chatView2 = RealmChatViewHelper.getChatByChatKey(MSRealm.getChatRealm(), chatKey);
		if (chatView2 != null) {
			MSRealm.getChatRealm().executeTransaction((re) -> {
				chatView2.UpdatedMs = AppUtil.getTimeMs();
				chatView2.LastMessage = lastMsg;
//				re.copyToRealmOrUpdate(chatView2);
			});
		}
	}
}
