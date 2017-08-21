package com.mardomsara.social.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

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

}
