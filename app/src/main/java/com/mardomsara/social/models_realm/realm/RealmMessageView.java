package com.mardomsara.social.models_realm.realm;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.RoomTypeEnum;

/**
 * Created by Hamid on 8/21/2017.
 */

public class RealmMessageView extends RealmObject {
	@PrimaryKey
	public long MessageId;
	public String RoomKey;
	public int UserId;
	public long MessageFileId;
	public int MessageTypeEnumId;
	public String Text;
	public int Time;
	public int PeerReceivedTime;
	public int PeerSeenTime;
	public int DeliviryStatusEnumId;
	public long ChatId;
//	public ir.ms.pb.RoomTypeEnum RoomTypeEnum;
	public boolean IsByMe;
	// END OF FLAT TYPES

	public RealmMessageFileView fileView;

	//add repley to, forward from, system log, contact, postView, TagView, UserView, GroupView, profileView
}
