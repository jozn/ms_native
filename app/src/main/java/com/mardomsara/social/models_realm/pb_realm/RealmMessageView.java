package com.mardomsara.social.models_realm.pb_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.*;


public class RealmMessageView extends RealmObject {
		 @PrimaryKey 
		public long MessageId;//0 				 PB 1
		public String MessageKey;//1 				 PB 3
		public String RoomKey;//2 				 PB 5
		public int UserId;//3 				 PB 7
		public long MessageFileId;//4 				 PB 9
		public int MessageTypeEnumId;//5 				 PB 11
		public String Text;//6 				 PB 13
		public int CreatedSe;//7 				 PB 15
		public int PeerReceivedTime;//8 				 PB 17
		public int PeerSeenTime;//9 				 PB 19
		public int DeliviryStatusEnumId;//10 				 PB 21
		public String ChatKey;//11 				 PB 30
		public int RoomTypeEnumId;//12 				 PB 31
		public boolean IsByMe;//13 				 PB 33
		public long RemoteId;//14 				 PB 50
		public RealmMessageFileView MessageFileView;//15 				 PB 100
	

	public static RealmMessageView fromPB(PB_MessageView pb){
		RealmMessageView r = new RealmMessageView();
		
		r.MessageId = pb.getMessageId();//0
		r.MessageKey = pb.getMessageKey();//1
		r.RoomKey = pb.getRoomKey();//2
		r.UserId = pb.getUserId();//3
		r.MessageFileId = pb.getMessageFileId();//4
		r.MessageTypeEnumId = pb.getMessageTypeEnumId();//5
		r.Text = pb.getText();//6
		r.CreatedSe = pb.getCreatedSe();//7
		r.PeerReceivedTime = pb.getPeerReceivedTime();//8
		r.PeerSeenTime = pb.getPeerSeenTime();//9
		r.DeliviryStatusEnumId = pb.getDeliviryStatusEnumId();//10
		r.ChatKey = pb.getChatKey();//11
		r.RoomTypeEnumId = pb.getRoomTypeEnumId();//12
		r.IsByMe = pb.getIsByMe();//13
		r.RemoteId = pb.getRemoteId();//14
		//r.MessageFileView = pb.getMessageFileView();//15

	    return r;
	}

}
	/*
	folding

	//sett
	RealmMessageView r = new RealmMessageView();
	
	r.MessageId = ;//0
	r.MessageKey = ;//1
	r.RoomKey = ;//2
	r.UserId = ;//3
	r.MessageFileId = ;//4
	r.MessageTypeEnumId = ;//5
	r.Text = ;//6
	r.CreatedSe = ;//7
	r.PeerReceivedTime = ;//8
	r.PeerSeenTime = ;//9
	r.DeliviryStatusEnumId = ;//10
	r.ChatKey = ;//11
	r.RoomTypeEnumId = ;//12
	r.IsByMe = ;//13
	r.RemoteId = ;//14
	r.MessageFileView = ;//15

	//sett - no tag number 
	RealmMessageView r = new RealmMessageView();
	
	r.MessageId = ;
	r.MessageKey = ;
	r.RoomKey = ;
	r.UserId = ;
	r.MessageFileId = ;
	r.MessageTypeEnumId = ;
	r.Text = ;
	r.CreatedSe = ;
	r.PeerReceivedTime = ;
	r.PeerSeenTime = ;
	r.DeliviryStatusEnumId = ;
	r.ChatKey = ;
	r.RoomTypeEnumId = ;
	r.IsByMe = ;
	r.RemoteId = ;
	r.MessageFileView = ;

	//get
	
	m. = r.MessageId ;//0
	m. = r.MessageKey ;//1
	m. = r.RoomKey ;//2
	m. = r.UserId ;//3
	m. = r.MessageFileId ;//4
	m. = r.MessageTypeEnumId ;//5
	m. = r.Text ;//6
	m. = r.CreatedSe ;//7
	m. = r.PeerReceivedTime ;//8
	m. = r.PeerSeenTime ;//9
	m. = r.DeliviryStatusEnumId ;//10
	m. = r.ChatKey ;//11
	m. = r.RoomTypeEnumId ;//12
	m. = r.IsByMe ;//13
	m. = r.RemoteId ;//14
	m. = r.MessageFileView ;//15

	//get - no tag number
	
	m. = r.MessageId ;
	m. = r.MessageKey ;
	m. = r.RoomKey ;
	m. = r.UserId ;
	m. = r.MessageFileId ;
	m. = r.MessageTypeEnumId ;
	m. = r.Text ;
	m. = r.CreatedSe ;
	m. = r.PeerReceivedTime ;
	m. = r.PeerSeenTime ;
	m. = r.DeliviryStatusEnumId ;
	m. = r.ChatKey ;
	m. = r.RoomTypeEnumId ;
	m. = r.IsByMe ;
	m. = r.RemoteId ;
	m. = r.MessageFileView ;
	
*/
