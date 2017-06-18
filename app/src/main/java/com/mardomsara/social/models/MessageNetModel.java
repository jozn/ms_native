package com.mardomsara.social.models;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.app.Events;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgFile;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.pipe_pb.PBConv;

import java.util.ArrayList;
import java.util.List;

import ir.ms.pb.PB_Message;
import ir.ms.pb.PB_MsgEvent;
import ir.ms.pb.PB_PushMsgAddMany;
import ir.ms.pb.PB_PushMsgEvents;
import ir.ms.pb.PB_UserWithMe;

/**
 * Created by Hamid on 6/16/2017.
 */

//NONE OF THE METHODS ARE CALLED FROM THE UI THREADS -- ALL ARE IN BACKGROUND THREADS -- like pipe sequence thread handle
public class MessageNetModel {
	public static void onNewMessagesFromPipe(PB_PushMsgAddMany pbPushMsgAddMany) {
		List<String> msgkeys = new ArrayList<>();

		DB.db.transactionSync(() -> {
			for (PB_Message pbMsg : pbPushMsgAddMany.getMessagesList()) {
				Message msgRow = PBConv.PB_Message_toNew_Message(pbMsg);
				MessageModel.setParamsForNewMsgRecivedFromNet(msgRow);
				handleNewMsgFunctionalityForDifferentTypes(msgRow);

				msgkeys.add(msgRow.MessageKey);
				msgRow.saveWithRoom();
			}
		});

		DB.db.transactionSync(() -> {
			for (PB_UserWithMe pbMsg : pbPushMsgAddMany.getUsersList()) {
				User userRow = PBConv.PB_UserWithMe_toNew_User(pbMsg);
				UserModel.saveNewUser(userRow);
			}
		});

		for (PB_UserWithMe pbMsg : pbPushMsgAddMany.getUsersList()) {
			handleNewUser(PBConv.PB_UserWithMe_toNew_User(pbMsg));
		}

		Events.publish(new Events.NewMessages(msgkeys));

		Helper.showDebugMessage("Msg: " + pbPushMsgAddMany.getMessagesList().size() + " Users: " + pbPushMsgAddMany.getUsersList().size());
	}

	public static void onNewMessagesEventsFromPipe(PB_PushMsgEvents data) {
		List<String> msgkeys = new ArrayList<>();

		DB.db.transactionSync(() -> {
			for (PB_MsgEvent meta : data.getEventsList()) {
				switch (meta.getEventType()) {
					case Constants.MESSAGE_PUSH_EVENT_RECEIVED_TO_PEER:
						DB.db.updateMessage()
							.PeerReceivedTime(meta.getAtTime())//updtaed
							.MessageKeyEq(meta.getMessageKey())
							.RoomKeyEq(meta.getRoomKey())
							.execute();
						break;

					case Constants.MESSAGE_PUSH_EVENT_SEEN_BY_PEER:
						DB.db.updateMessage()
							.PeerSeenTime(meta.getAtTime())//updtaed
							.MessageKeyEq(meta.getMessageKey())
							.RoomKeyEq(meta.getRoomKey())
							.execute();
						break;

					case Constants.MESSAGE_PUSH_EVENT_DELETED_FROM_SERVER:
						DB.db.updateMessage()
							.ServerDeletedTime(meta.getAtTime())//updtaed
							.MessageKeyEq(meta.getMessageKey())
							.RoomKeyEq(meta.getRoomKey())
							.execute();
						break;

					default:
						AppUtil.error(" Msg Event from pipe is unknowen " + meta.getEventType());
				}

				msgkeys.add(meta.getMessageKey());
			}
		});

		Events.publish(new Events.MsgsMetaInfoChanged(msgkeys));

	}


	private static void handleNewUser(User user) {
		UserModel.saveNewUser(user);
	}

	//don't block return fast
	private static void handleNewMsgFunctionalityForDifferentTypes(Message msg) {
		MsgFile msgFile;
		switch (msg.MessageTypeId) {
			case Constants.MESSAGE_TEXT:
				break;

			case Constants.MESSAGE_IMAGE:
				msgFile = msg.MsgFile;
				if (msgFile != null) {
					String $fileName = AppFiles.PHOTO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() + "$" + msgFile.Extension;
					String fileName = FileUtil.createNextName($fileName);
					msgFile.LocalSrc = fileName;
					msgFile.Origin = Constants.Msg_Media_Origin_Server;
					msg.MsgFile_LocalSrc = fileName;
					msg.setMsgFile_Status(Constants.Msg_Media_To_Download);
//					msg.saveWithRoom();
						/*HttpOld.downloadFile(msgFile.ServerSrc,fileName,
							()->{//callback
								msg.setMsgFile_Status(Constants.Msg_Media_Downloaded);
								msg.saveWithRoom();
								MessageModel.publishMsgGeneralChangeEvent(msg);

							},
							()->{//errorback

							});*/
				}
				break;

			case Constants.MESSAGE_VIDEO:
				msgFile = msg.MsgFile;
				if (msgFile != null) {
					String $fileName = AppFiles.VIDEO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() + "$" + msgFile.Extension;
					String fileName = FileUtil.createNextName($fileName);
					msg.MsgFile_LocalSrc = fileName;
					msgFile.LocalSrc = fileName;
					msgFile.Origin = Constants.Msg_Media_Origin_Server;
					msg.setMsgFile_Status(Constants.Msg_Media_To_Download);
					msg.saveWithRoom();
					HttpOld.downloadFile(msgFile.ServerSrc, fileName,
						() -> {//callback
							msg.setMsgFile_Status(Constants.Msg_Media_Downloaded);
							MessageModel.setVideoExtraParams(msgFile, fileName);
							msg.saveWithRoom();
							MessageModel.publishMsgGeneralChangeEvent(msg);
						},
						() -> {//errorback

						});
				}

				break;
		}
	}

}
