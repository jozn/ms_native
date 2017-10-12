package com.mardomsara.social.models_realm.pb_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.*;


public class RealmChatView extends RealmObject {
		 @PrimaryKey 
		public String ChatKey;//0 				 PB 1
		public String RoomKey;//1 				 PB 3
		public int RoomTypeEnumId;//2 				 PB 5
		public int UserId;//3 				 PB 7
		public int PeerUserId;//4 				 PB 9
		public long GroupId;//5 				 PB 11
		public int CreatedSe;//6 				 PB 13
		public long UpdatedMs;//7 				 PB 15
		public long LastMessageId;//8 				 PB 17
		public long LastDeletedMessageId;//9 				 PB 19
		public long LastSeenMessageId;//10 				 PB 21
		public int LastSeqSeen;//11 				 PB 23
		public int LastSeqDelete;//12 				 PB 25
		public int CurrentSeq;//13 				 PB 27
		public RealmUserView UserView;//14 				 PB 100
		public int SharedMediaCount;//15 				 PB 200
		public int UnseenCount;//16 				 PB 205
		public RealmMessageView FirstUnreadMessage;//17 				 PB 210
		public RealmMessageView LastMessage;//18 				 PB 212
	

	public static RealmChatView fromPB(PB_ChatView pb){
		RealmChatView r = new RealmChatView();
		pb.newBuilderForType();
		r.ChatKey = pb.getChatKey();//0
		r.RoomKey = pb.getRoomKey();//1
		r.RoomTypeEnumId = pb.getRoomTypeEnumId();//2
		r.UserId = pb.getUserId();//3
		r.PeerUserId = pb.getPeerUserId();//4
		r.GroupId = pb.getGroupId();//5
		r.CreatedSe = pb.getCreatedSe();//6
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

	public static PB_ChatView toPB(RealmChatView rV){//realmView
		PB_ChatView.Builder pbB = PB_ChatView.newBuilder();
		
		pbB.setChatKey(rV.ChatKey);//0
		pbB.setRoomKey(rV.RoomKey);//1
		pbB.setRoomTypeEnumId(rV.RoomTypeEnumId);//2
		pbB.setUserId(rV.UserId);//3
		pbB.setPeerUserId(rV.PeerUserId);//4
		pbB.setGroupId(rV.GroupId);//5
		pbB.setCreatedSe(rV.CreatedSe);//6
		pbB.setUpdatedMs(rV.UpdatedMs);//7
		pbB.setLastMessageId(rV.LastMessageId);//8
		pbB.setLastDeletedMessageId(rV.LastDeletedMessageId);//9
		pbB.setLastSeenMessageId(rV.LastSeenMessageId);//10
		pbB.setLastSeqSeen(rV.LastSeqSeen);//11
		pbB.setLastSeqDelete(rV.LastSeqDelete);//12
		pbB.setCurrentSeq(rV.CurrentSeq);//13
		//r.UserView = pb.getUserView();//14
		pbB.setSharedMediaCount(rV.SharedMediaCount);//15
		pbB.setUnseenCount(rV.UnseenCount);//16
		//r.FirstUnreadMessage = pb.getFirstUnreadMessage();//17
		//r.LastMessage = pb.getLastMessage();//18

		return pbB.build();
    	}

	public static PB_ChatView.Builder toPB_Builder(RealmChatView rV){//realmView
		PB_ChatView.Builder pbB = PB_ChatView.newBuilder();
		
		pbB.setChatKey(rV.ChatKey);//0
		pbB.setRoomKey(rV.RoomKey);//1
		pbB.setRoomTypeEnumId(rV.RoomTypeEnumId);//2
		pbB.setUserId(rV.UserId);//3
		pbB.setPeerUserId(rV.PeerUserId);//4
		pbB.setGroupId(rV.GroupId);//5
		pbB.setCreatedSe(rV.CreatedSe);//6
		pbB.setUpdatedMs(rV.UpdatedMs);//7
		pbB.setLastMessageId(rV.LastMessageId);//8
		pbB.setLastDeletedMessageId(rV.LastDeletedMessageId);//9
		pbB.setLastSeenMessageId(rV.LastSeenMessageId);//10
		pbB.setLastSeqSeen(rV.LastSeqSeen);//11
		pbB.setLastSeqDelete(rV.LastSeqDelete);//12
		pbB.setCurrentSeq(rV.CurrentSeq);//13
		//r.UserView = pb.getUserView();//14
		pbB.setSharedMediaCount(rV.SharedMediaCount);//15
		pbB.setUnseenCount(rV.UnseenCount);//16
		//r.FirstUnreadMessage = pb.getFirstUnreadMessage();//17
		//r.LastMessage = pb.getLastMessage();//18

		return pbB;
    	}



}
	/*
	folding

	//sett
	RealmChatView r = new RealmChatView();
	
	r.ChatKey = ;//0
	r.RoomKey = ;//1
	r.RoomTypeEnumId = ;//2
	r.UserId = ;//3
	r.PeerUserId = ;//4
	r.GroupId = ;//5
	r.CreatedSe = ;//6
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
	r.RoomKey = ;
	r.RoomTypeEnumId = ;
	r.UserId = ;
	r.PeerUserId = ;
	r.GroupId = ;
	r.CreatedSe = ;
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
	m. = r.RoomKey ;//1
	m. = r.RoomTypeEnumId ;//2
	m. = r.UserId ;//3
	m. = r.PeerUserId ;//4
	m. = r.GroupId ;//5
	m. = r.CreatedSe ;//6
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
	m. = r.RoomKey ;
	m. = r.RoomTypeEnumId ;
	m. = r.UserId ;
	m. = r.PeerUserId ;
	m. = r.GroupId ;
	m. = r.CreatedSe ;
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


	//for PB.Builder
	PB_ChatView.Builder b = PB_ChatView.newBuilder();
	
	b.setChatKey(r.ChatKey);//0
	b.setRoomKey(r.RoomKey);//1
	b.setRoomTypeEnumId(r.RoomTypeEnumId);//2
	b.setUserId(r.UserId);//3
	b.setPeerUserId(r.PeerUserId);//4
	b.setGroupId(r.GroupId);//5
	b.setCreatedSe(r.CreatedSe);//6
	b.setUpdatedMs(r.UpdatedMs);//7
	b.setLastMessageId(r.LastMessageId);//8
	b.setLastDeletedMessageId(r.LastDeletedMessageId);//9
	b.setLastSeenMessageId(r.LastSeenMessageId);//10
	b.setLastSeqSeen(r.LastSeqSeen);//11
	b.setLastSeqDelete(r.LastSeqDelete);//12
	b.setCurrentSeq(r.CurrentSeq);//13
	//r.UserView = pb.getUserView();//14
	b.setSharedMediaCount(r.SharedMediaCount);//15
	b.setUnseenCount(r.UnseenCount);//16
	//r.FirstUnreadMessage = pb.getFirstUnreadMessage();//17
	//r.LastMessage = pb.getLastMessage();//18


	//for PB.Builder - empty
	PB_ChatView.Builder b = PB_ChatView.newBuilder();
	
	b.setChatKey();//0
	b.setRoomKey();//1
	b.setRoomTypeEnumId();//2
	b.setUserId();//3
	b.setPeerUserId();//4
	b.setGroupId();//5
	b.setCreatedSe();//6
	b.setUpdatedMs();//7
	b.setLastMessageId();//8
	b.setLastDeletedMessageId();//9
	b.setLastSeenMessageId();//10
	b.setLastSeqSeen();//11
	b.setLastSeqDelete();//12
	b.setCurrentSeq();//13
	//r.UserView = pb.getUserView();//14
	b.setSharedMediaCount();//15
	b.setUnseenCount();//16
	//r.FirstUnreadMessage = pb.getFirstUnreadMessage();//17
	//r.LastMessage = pb.getLastMessage();//18



	
*/
