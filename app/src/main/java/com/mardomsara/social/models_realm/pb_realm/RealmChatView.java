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
		public long LastMessageId;//8 				 PB 17
		public long LastDeletedMessageId;//9 				 PB 18
		public long LastSeenMessageId;//10 				 PB 19
		public int LastSeqSeen;//11 				 PB 21
		public int LastSeqDelete;//12 				 PB 23
		public int CurrentSeq;//13 				 PB 25
		public RealmUserView UserView;//14 				 PB 100
		public int SharedMediaCount;//15 				 PB 200
		public int UnseenCount;//16 				 PB 205
		public RealmMessageView FirstUnreadMessage;//17 				 PB 210
		public RealmMessageView LastMessage;//18 				 PB 212
	

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
		r.LastMessageId = pb.getLastMessageId();//8
		r.LastDeletedMessageId = pb.getLastDeletedMessageId();//9
		r.LastSeenMessageId = pb.getLastSeenMessageId();//10
		r.LastSeqSeen = pb.getLastSeqSeen();//11
		r.LastSeqDelete = pb.getLastSeqDelete();//12
		r.CurrentSeq = pb.getCurrentSeq();//13
		//r.UserView = pb.getUserView();//14
		r.SharedMediaCount = pb.getSharedMediaCount();//15
		r.UnseenCount = pb.getUnseenCount();//16
		//r.FirstUnreadMessage = pb.getFirstUnreadMessage();//17
		//r.LastMessage = pb.getLastMessage();//18

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
	r.LastMessageId = ;//8
	r.LastDeletedMessageId = ;//9
	r.LastSeenMessageId = ;//10
	r.LastSeqSeen = ;//11
	r.LastSeqDelete = ;//12
	r.CurrentSeq = ;//13
	r.UserView = ;//14
	r.SharedMediaCount = ;//15
	r.UnseenCount = ;//16
	r.FirstUnreadMessage = ;//17
	r.LastMessage = ;//18

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
	r.LastMessageId = ;
	r.LastDeletedMessageId = ;
	r.LastSeenMessageId = ;
	r.LastSeqSeen = ;
	r.LastSeqDelete = ;
	r.CurrentSeq = ;
	r.UserView = ;
	r.SharedMediaCount = ;
	r.UnseenCount = ;
	r.FirstUnreadMessage = ;
	r.LastMessage = ;

	//get
	
	m. = r.ChatKey ;//0
	m. = r.ChatId ;//1
	m. = r.RoomTypeEnumId ;//2
	m. = r.UserId ;//3
	m. = r.PeerUserId ;//4
	m. = r.GroupId ;//5
	m. = r.CreatedTime ;//6
	m. = r.UpdatedMs ;//7
	m. = r.LastMessageId ;//8
	m. = r.LastDeletedMessageId ;//9
	m. = r.LastSeenMessageId ;//10
	m. = r.LastSeqSeen ;//11
	m. = r.LastSeqDelete ;//12
	m. = r.CurrentSeq ;//13
	m. = r.UserView ;//14
	m. = r.SharedMediaCount ;//15
	m. = r.UnseenCount ;//16
	m. = r.FirstUnreadMessage ;//17
	m. = r.LastMessage ;//18

	//get - no tag number
	
	m. = r.ChatKey ;
	m. = r.ChatId ;
	m. = r.RoomTypeEnumId ;
	m. = r.UserId ;
	m. = r.PeerUserId ;
	m. = r.GroupId ;
	m. = r.CreatedTime ;
	m. = r.UpdatedMs ;
	m. = r.LastMessageId ;
	m. = r.LastDeletedMessageId ;
	m. = r.LastSeenMessageId ;
	m. = r.LastSeqSeen ;
	m. = r.LastSeqDelete ;
	m. = r.CurrentSeq ;
	m. = r.UserView ;
	m. = r.SharedMediaCount ;
	m. = r.UnseenCount ;
	m. = r.FirstUnreadMessage ;
	m. = r.LastMessage ;
	
*/
