package com.mardomsara.social.pipe.del;

import android.support.annotation.NonNull;

import com.google.protobuf.ByteString;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgFile;
import com.mardomsara.social.models.tables.MsgSeen;
import com.mardomsara.social.models.tables.User;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ir.ms.pb.PB_Message;
import ir.ms.pb.PB_MsgFile;
import ir.ms.pb.PB_MsgSeen;
import ir.ms.pb.PB_UserWithMe;

/**
 * Created by Hamid on 5/24/2017.
 */

public class PBConv {
	public static Message PB_Message_toNew_Message(PB_Message pb_message) {
		Message message = new Message();
		message.NanoId = 0;
		message.MessageKey = pb_message.getMessageKey();
		message.RoomKey = pb_message.getRoomKey();
		message.UserId = pb_message.getUserId();
		message.RoomTypeId = pb_message.getRoomTypeId();
		message.MessageTypeId = pb_message.getMessageTypeId();
		message.Text = pb_message.getText();
		message.ExtraJson = pb_message.getExtraJson();
		message.IsByMe = pb_message.getIsByMe();
		message.IsStared = pb_message.getIsStared();
		message.CreatedMs = pb_message.getCreatedMs();
		message.CreatedDeviceMs = pb_message.getCreatedDeviceMs();
		message.SortId = pb_message.getSortId();
		message.PeerSeenTime = pb_message.getPeerSeenTime();
		message.ServerReceivedTime = pb_message.getServerReceivedTime();
		message.PeerReceivedTime = 0;
		message.ServerDeletedTime = pb_message.getServerDeletedTime();
		message.ISeenTime = pb_message.getISeenTime();
		message.ToPush = pb_message.getToPush();

//		message.MsgFile_LocalSrc = pb_message.getMsgFileLocalSrc();
//		message.MsgFile_Status = pb_message.getMsgFileStatus();

		if (pb_message.getFile() != null) {
			message.MsgFile = PB_MsgFile_to_MsgFIle(pb_message.getFile());
		}

		return message;
	}

	public static PB_Message Message_toNew_PB_Message(Message msg) {
		PB_Message.Builder b = PB_Message.newBuilder();
//		b.setNanoId(0);

		b.setMessageKeyBytes(toUtf8(msg.MessageKey));
		b.setRoomKeyBytes(toUtf8(msg.RoomKey));
		b.setUserId(msg.UserId);
		b.setRoomTypeId(msg.RoomTypeId);
		b.setMessageTypeId(msg.MessageTypeId);
		b.setTextBytes(toUtf8(msg.Text));
		b.setExtraJsonBytes(toUtf8(msg.ExtraJson));
		b.setIsByMe(msg.IsByMe);
		b.setIsStared(msg.IsStared);
		b.setCreatedMs(msg.CreatedMs);
		b.setCreatedDeviceMs(msg.CreatedDeviceMs);
		b.setSortId(msg.SortId);
		b.setPeerSeenTime(msg.PeerSeenTime);
		b.setServerReceivedTime(msg.ServerReceivedTime);
//		b.setPeerReceivedTime(0;
		b.setServerDeletedTime(msg.ServerDeletedTime);
		b.setISeenTime(msg.ISeenTime);
		b.setToPush(msg.ToPush);

		b.setMsgFileLocalSrcBytes(toUtf8(msg.MsgFile_LocalSrc));
		b.setMsgFileStatus(msg.MsgFile_Status);

		if (msg.getMsgFile() != null) {
			b.setFile(MsgFile_to_PB_MsgFile(msg.getMsgFile(), true));
		}

		return b.build();
	}

	public static List<PB_Message> Message_toNew_PB_Message_List(List<Message> msgs) {
		List<PB_Message> list = new ArrayList<>();
		for (Message message : msgs) {
			list.add(Message_toNew_PB_Message(message));
		}
		return list;
	}

	public static User PB_UserWithMe_toNew_User(PB_UserWithMe pb_user) {
		User u = new User();
		u.UserId = pb_user.getUserId();
		u.IsFollowing = pb_user.getFollowingType();
		u.AvatarUrl = pb_user.getAvatarUrl();
		u.StatusText = "";
		u.StatusId = 0;
		u.UnseenMessageCount = 0;
		u.UserName = pb_user.getUserName();
		u.FirstName = pb_user.getFirstName();
		u.LastName = pb_user.getLastName();
		u.FullName = pb_user.getFullName();
		u.PrivacyProfile = pb_user.getPrivacyProfile();
		u.FollowingType = pb_user.getFollowingType();
		u.About = pb_user.getAbout();
		u.About = pb_user.getAbout();

		u.AppVersion = pb_user.getAppVersion();
		u.UpdatedTime = pb_user.getUpdatedTime();
		u.Phone = pb_user.getPhone();

		return u;
	}

	public static PB_MsgSeen MsgSeen_to_PB_MsgSeen(MsgSeen seen) {
		PB_MsgSeen pb_msgSeen = PB_MsgSeen.newBuilder()
			.setUserId(seen.PeerUserId)
			.setMessageKey(seen.MsgKey)
			.setRoomKeyBytes(toUtf8(seen.RoomKey))
			.setAtTime(seen.AtTime)
			.build();

		return pb_msgSeen;
	}

	public static List<PB_MsgSeen> MsgSeen_to_PB_MsgSeen_List(List<MsgSeen> seens) {
		List<PB_MsgSeen> list = new ArrayList<>();
		for (MsgSeen s : seens) {
			list.add(MsgSeen_to_PB_MsgSeen(s));
		}
		return list;
	}

	@NonNull
	public static MsgFile PB_MsgFile_to_MsgFIle(PB_MsgFile p) {
//		Helper.showDebugMessage("ServerSrc: " +p.getServerSrc());
		MsgFile f = new MsgFile();
		f.LocalSrc = "";
		f.Hash = "";
		f.ServerSrc = p.getServerSrc();
		f.FileType = p.getFileType();
		f.Status = 0;
		f.Origin = Constants.Msg_Media_Origin_Server;
		f.Name = p.getName();
		f.Size = p.getSize();
		f.Duration = p.getDuration();
		f.Height = p.getHeight();
		f.Width = p.getWidth();
		f.Extension = p.getExtension();

		//FIXME add thumbs metas to server and PB
		f.ThumbSize = 0;
		f.ThumbHeight = 0;
		f.ThumbWidth = 0;
		f.Thumb64 = "";
		if (p.getThumbData() != null) {
			f.ThumbData = p.getThumbData().toByteArray();
		}
		f.ThumbLocalSrc = "---";
		f.CreatedMs = TimeUtil.getTimeMs();

		return f;
	}

	@NonNull
	public static PB_MsgFile MsgFile_to_PB_MsgFile(MsgFile f, boolean withData) {
//		Helper.showDebugMessage("ServerSrc: " +f.getServerSrc());
//		MsgFile p = PB_MsgFile.newBuilder();
		PB_MsgFile.Builder mfB = PB_MsgFile.newBuilder()
			.setServerSrc(f.ServerSrc)
			.setFileType(f.FileType)
			.setMimeType("")//// FIXME: 6/20/2017 this
			.setName(f.Name)
			.setSize(f.Size)
			.setDuration(f.Duration)
			.setHeight(f.Height)
			.setWidth(f.Width)
			.setExtension(f.Extension);

		//TODO add other thums to pb
		/*p.ThumbSize = 0;
		p.ThumbHeight = 0;
		p.ThumbWidth = 0;
		p.Thumb64 = "";*/
		if (f.ThumbData != null) {
			mfB.setThumbData(ByteString.copyFrom(f.ThumbData)); //
		}
		if (withData) {
			File file = new File(f.LocalSrc);
			if (file != null && file.exists()) {
				try {
					mfB.setData(ByteString.copyFrom(FileUtils.readFileToByteArray(file)));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		PB_MsgFile pb_msgFile = mfB.build();

		return pb_msgFile;
	}

	static ByteString toUtf8(String str) {
		return ByteString.copyFromUtf8(str);
	}

}
