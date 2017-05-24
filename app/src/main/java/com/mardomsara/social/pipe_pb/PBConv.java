package com.mardomsara.social.pipe_pb;

import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.User;

import java.util.ArrayList;
import java.util.List;

import ir.ms.pb.PB_Message;
import ir.ms.pb.PB_UserWithMe;

/**
 * Created by Hamid on 5/24/2017.
 */

public class PBConv {
	public static Message PB_Message_toNew_Message(PB_Message pb_message){
		 Message message = new Message();
		message.NanoId =0;
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

		message.MsgFile_LocalSrc = pb_message.getMsgFileLocalSrc();
		message.MsgFile_Status = pb_message.getMsgFileStatus();

		return message;
	}

	public static PB_Message Message_toNew_PB_Message(Message msg){
		PB_Message.Builder b = PB_Message.newBuilder();
//		b.setNanoId(0);
		b.setMessageKey(msg.MessageKey);
		b.setRoomKey(msg.RoomKey);
		b.setUserId(msg.UserId);
		b.setRoomTypeId(msg.RoomTypeId);
		b.setMessageTypeId(msg.MessageTypeId);
		b.setText(msg.Text);
		b.setExtraJson(msg.ExtraJson);
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

		b.setMsgFileLocalSrc(msg.MsgFile_LocalSrc);
		b.setMsgFileStatus(msg.MsgFile_Status);

		return b.build();
	}

	public static List<PB_Message> Message_toNew_PB_Message_List(List<Message > msgs){
		List<PB_Message > list = new ArrayList<>();
		for (Message message : msgs){
			list.add(Message_toNew_PB_Message(message));
		}
		return list;
	}

	public static User PB_UserWithMe_toNew_User(PB_UserWithMe pb_user){
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
}
