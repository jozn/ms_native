package com.mardomsara.social.models_realm.pb_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.*;


public class RealmMessageView extends RealmObject {
		 @PrimaryKey 
		public long MessageId;//0 				 PB 1
		public String RoomKey;//1 				 PB 3
		public int UserId;//2 				 PB 5
		public long MessageFileId;//3 				 PB 7
		public int MessageTypeEnumId;//4 				 PB 9
		public String Text;//5 				 PB 11
		public int Time;//6 				 PB 13
		public int PeerReceivedTime;//7 				 PB 15
		public int PeerSeenTime;//8 				 PB 17
		public int DeliviryStatusEnumId;//9 				 PB 19
		public long ChatId;//10 				 PB 30
		public int RoomTypeEnumId;//11 				 PB 31
		public boolean IsByMe;//12 				 PB 33
		public boolean RemoteId;//13 				 PB 50
		public RealmMessageFileView File;//14 				 PB 100
	

	public static RealmMessageView fromPB(PB_MessageView pb){
		RealmMessageView r = new RealmMessageView();
		
		r.MessageId = pb.getMessageId();//0
		r.RoomKey = pb.getRoomKey();//1
		r.UserId = pb.getUserId();//2
		r.MessageFileId = pb.getMessageFileId();//3
		r.MessageTypeEnumId = pb.getMessageTypeEnumId();//4
		r.Text = pb.getText();//5
		r.Time = pb.getTime();//6
		r.PeerReceivedTime = pb.getPeerReceivedTime();//7
		r.PeerSeenTime = pb.getPeerSeenTime();//8
		r.DeliviryStatusEnumId = pb.getDeliviryStatusEnumId();//9
		r.ChatId = pb.getChatId();//10
		r.RoomTypeEnumId = pb.getRoomTypeEnumId();//11
		r.IsByMe = pb.getIsByMe();//12
		r.RemoteId = pb.getRemoteId();//13
		//r.File = pb.getFile();//14

	    return r;
	}

}
	/*
	folding

	//sett
	RealmMessageView r = new RealmMessageView();
	
	r.MessageId = ;//0
	r.RoomKey = ;//1
	r.UserId = ;//2
	r.MessageFileId = ;//3
	r.MessageTypeEnumId = ;//4
	r.Text = ;//5
	r.Time = ;//6
	r.PeerReceivedTime = ;//7
	r.PeerSeenTime = ;//8
	r.DeliviryStatusEnumId = ;//9
	r.ChatId = ;//10
	r.RoomTypeEnumId = ;//11
	r.IsByMe = ;//12
	r.RemoteId = ;//13
	r.File = ;//14

	//sett - no tag number 
	RealmMessageView r = new RealmMessageView();
	
	r.MessageId = ;
	r.RoomKey = ;
	r.UserId = ;
	r.MessageFileId = ;
	r.MessageTypeEnumId = ;
	r.Text = ;
	r.Time = ;
	r.PeerReceivedTime = ;
	r.PeerSeenTime = ;
	r.DeliviryStatusEnumId = ;
	r.ChatId = ;
	r.RoomTypeEnumId = ;
	r.IsByMe = ;
	r.RemoteId = ;
	r.File = ;

	//get
	
	m. = r.MessageId ;//0
	m. = r.RoomKey ;//1
	m. = r.UserId ;//2
	m. = r.MessageFileId ;//3
	m. = r.MessageTypeEnumId ;//4
	m. = r.Text ;//5
	m. = r.Time ;//6
	m. = r.PeerReceivedTime ;//7
	m. = r.PeerSeenTime ;//8
	m. = r.DeliviryStatusEnumId ;//9
	m. = r.ChatId ;//10
	m. = r.RoomTypeEnumId ;//11
	m. = r.IsByMe ;//12
	m. = r.RemoteId ;//13
	m. = r.File ;//14

	//get - no tag number
	
	m. = r.MessageId ;
	m. = r.RoomKey ;
	m. = r.UserId ;
	m. = r.MessageFileId ;
	m. = r.MessageTypeEnumId ;
	m. = r.Text ;
	m. = r.Time ;
	m. = r.PeerReceivedTime ;
	m. = r.PeerSeenTime ;
	m. = r.DeliviryStatusEnumId ;
	m. = r.ChatId ;
	m. = r.RoomTypeEnumId ;
	m. = r.IsByMe ;
	m. = r.RemoteId ;
	m. = r.File ;
	
*/
