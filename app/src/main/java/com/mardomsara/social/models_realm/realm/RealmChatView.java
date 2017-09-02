package com.mardomsara.social.models_realm.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.RoomTypeEnum;

/**
 * Created by Hamid on 8/21/2017.
 */

public class RealmChatView extends RealmObject {
	@PrimaryKey
	public long ChatId;
	public String ChatKey;
	public int RoomTypeEnumId;
	public int UserId;
	public int LastSeqSeen;
	public int LastSeqDelete;
	public int PeerUserId;
	public long GroupId;
	public int CreatedTime;
	public int CurrentSeq;
	public long UpdatedMs;
	// end of flat types//

	public long DirectLastMessageId = 0;
	public long LastSeenMessageId = 0;

	public long sharedMediaCount = 0;
	public long unseenCount = 0;

	public RealmMessageView firstUnreadMessage;
	public RealmMessageView lastMessage;
	public RealmUserView user;

	// add: setting, notifaction , group, draft

	public String getRoomName(){
		if(user != null){
			return user.FirstName + user.LastName;
		}
		return "name+" + ChatId;
	}

	public String getRoomAvatarUrl(){
		if(user != null){
			return user.AvatarUrl;
		}
		return "http://192.168.0.10:5000/upload/avatar/1/21_mOId_200.jpg";
	}

	public int getUserId(){
		if(user != null){
			return user.UserId;
		}
		return 12;
	}
}
