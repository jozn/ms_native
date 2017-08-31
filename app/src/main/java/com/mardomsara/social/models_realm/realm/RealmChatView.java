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

	public long sharedMediaCount = 0;
	public RealmMessageView firstUnreadMessage;
	public RealmMessageView lastMessage;
	public RealmUserView user;

	// add: setting, notifaction , group, draft
}
