package com.mardomsara.social.models_realm.pb_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.*;



public class RealmChatView extends RealmObject {
		 @PrimaryKey 
		public String ChatKey;//0 				 PB 3
		public long ChatId;//1 				 PB 1
		public int RoomTypeEnumId;//2 				 PB 5
		public int UserId;//3 				 PB 7
		public int PeerUserId;//4 				 PB 9
		public long GroupId;//5 				 PB 11
		public int CreatedTime;//6 				 PB 13
		public long UpdatedMs;//7 				 PB 15
		public long DirectLastMessageId;//8 				 PB 17
		public long LastSeenMessageId;//9 				 PB 19
		public int LastSeqSeen;//10 				 PB 21
		public int LastSeqDelete;//11 				 PB 23
		public int CurrentSeq;//12 				 PB 25
		public PB_UserView User;//13 				 PB 100
	

	public static RealmChatView fromPB(PB_ChatView pb){
		RealmChatView r = new RealmChatView();
		
	    r.ChatKey = pb.getChatKey();//0
	    r.ChatId = pb.getChatId();//1
	    r.RoomTypeEnumId = pb.getRoomTypeEnumId();//2
	    r.UserId = pb.getUserId();//3
	    r.PeerUserId = pb.getPeerUserId();//4
	    r.GroupId = pb.getGroupId();//5
	    r.CreatedTime = pb.getCreatedTime();//6
	    r.UpdatedMs = pb.getUpdatedMs();//7
	    r.DirectLastMessageId = pb.getDirectLastMessageId();//8
	    r.LastSeenMessageId = pb.getLastSeenMessageId();//9
	    r.LastSeqSeen = pb.getLastSeqSeen();//10
	    r.LastSeqDelete = pb.getLastSeqDelete();//11
	    r.CurrentSeq = pb.getCurrentSeq();//12
	    r.User = pb.getUser();//13

	    return r;
	}

}
	/*
	folding

	PBFlatTypes.PB_ChatView t = new PBFlatTypes.PB_ChatView();
    t.ChatKey = pb.getChatKey();
    t.ChatId = pb.getChatId();
    t.RoomTypeEnumId = pb.getRoomTypeEnumId();
    t.UserId = pb.getUserId();
    t.PeerUserId = pb.getPeerUserId();
    t.GroupId = pb.getGroupId();
    t.CreatedTime = pb.getCreatedTime();
    t.UpdatedMs = pb.getUpdatedMs();
    t.DirectLastMessageId = pb.getDirectLastMessageId();
    t.LastSeenMessageId = pb.getLastSeenMessageId();
    t.LastSeqSeen = pb.getLastSeqSeen();
    t.LastSeqDelete = pb.getLastSeqDelete();
    t.CurrentSeq = pb.getCurrentSeq();
    t.User = pb.getUser();
	*/

	/*
	PBFlatTypes.PB_ChatView t = new PBFlatTypes.PB_ChatView();
	t.ChatKey = ;
	t.ChatId = ;
	t.RoomTypeEnumId = ;
	t.UserId = ;
	t.PeerUserId = ;
	t.GroupId = ;
	t.CreatedTime = ;
	t.UpdatedMs = ;
	t.DirectLastMessageId = ;
	t.LastSeenMessageId = ;
	t.LastSeqSeen = ;
	t.LastSeqDelete = ;
	t.CurrentSeq = ;
	t.User = ;
	*/

	/*
	PB_ChatView t = new PB_ChatView();
	t.ChatKey = m.getChatKey() ;
	t.ChatId = m.getChatId() ;
	t.RoomTypeEnumId = m.getRoomTypeEnumId() ;
	t.UserId = m.getUserId() ;
	t.PeerUserId = m.getPeerUserId() ;
	t.GroupId = m.getGroupId() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.UpdatedMs = m.getUpdatedMs() ;
	t.DirectLastMessageId = m.getDirectLastMessageId() ;
	t.LastSeenMessageId = m.getLastSeenMessageId() ;
	t.LastSeqSeen = m.getLastSeqSeen() ;
	t.LastSeqDelete = m.getLastSeqDelete() ;
	t.CurrentSeq = m.getCurrentSeq() ;
	t.User = m.getUser() ;
	
*/
