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

	//sett
	RealmChatView r = new RealmChatView();
	
	r.ChatKey = ;//0
	r.ChatId = ;//1
	r.RoomTypeEnumId = ;//2
	r.UserId = ;//3
	r.PeerUserId = ;//4
	r.GroupId = ;//5
	r.CreatedTime = ;//6
	r.UpdatedMs = ;//7
	r.DirectLastMessageId = ;//8
	r.LastSeenMessageId = ;//9
	r.LastSeqSeen = ;//10
	r.LastSeqDelete = ;//11
	r.CurrentSeq = ;//12
	r.User = ;//13

	//sett - no tag number 
	RealmChatView r = new RealmChatView();
	
	r.ChatKey = ;
	r.ChatId = ;
	r.RoomTypeEnumId = ;
	r.UserId = ;
	r.PeerUserId = ;
	r.GroupId = ;
	r.CreatedTime = ;
	r.UpdatedMs = ;
	r.DirectLastMessageId = ;
	r.LastSeenMessageId = ;
	r.LastSeqSeen = ;
	r.LastSeqDelete = ;
	r.CurrentSeq = ;
	r.User = ;

	//get
	
	m. = r.ChatKey ;//0
	m. = r.ChatId ;//1
	m. = r.RoomTypeEnumId ;//2
	m. = r.UserId ;//3
	m. = r.PeerUserId ;//4
	m. = r.GroupId ;//5
	m. = r.CreatedTime ;//6
	m. = r.UpdatedMs ;//7
	m. = r.DirectLastMessageId ;//8
	m. = r.LastSeenMessageId ;//9
	m. = r.LastSeqSeen ;//10
	m. = r.LastSeqDelete ;//11
	m. = r.CurrentSeq ;//12
	m. = r.User ;//13

	//get - no tag number
	
	m. = r.ChatKey ;
	m. = r.ChatId ;
	m. = r.RoomTypeEnumId ;
	m. = r.UserId ;
	m. = r.PeerUserId ;
	m. = r.GroupId ;
	m. = r.CreatedTime ;
	m. = r.UpdatedMs ;
	m. = r.DirectLastMessageId ;
	m. = r.LastSeenMessageId ;
	m. = r.LastSeqSeen ;
	m. = r.LastSeqDelete ;
	m. = r.CurrentSeq ;
	m. = r.User ;
	
*/
