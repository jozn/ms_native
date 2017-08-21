package com.mardomsara.social.models.realm;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Hamid on 8/21/2017.
 */

public class RealmMessageView extends RealmObject {
	@PrimaryKey
	public long MessageId;
	public String RoomKey;
	public int UserId;
	public long MessageFileId;
	public int MessageTypeEnum;
	public String Text;
	public int Time;
	public int PeerReceivedTime;
	public int PeerSeenTime;
	public int DeliviryStatusEnum;
	public int PeerUserId;
}
