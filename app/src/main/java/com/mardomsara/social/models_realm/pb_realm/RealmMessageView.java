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

	public static PB_MessageView toPB(RealmMessageView rV){//realmView
		PB_MessageView.Builder pbB = PB_MessageView.newBuilder();
		
		pbB.setMessageId(rV.MessageId);//0
		pbB.setMessageKey(rV.MessageKey);//1
		pbB.setRoomKey(rV.RoomKey);//2
		pbB.setUserId(rV.UserId);//3
		pbB.setMessageFileId(rV.MessageFileId);//4
		pbB.setMessageTypeEnumId(rV.MessageTypeEnumId);//5
		pbB.setText(rV.Text);//6
		pbB.setCreatedSe(rV.CreatedSe);//7
		pbB.setPeerReceivedTime(rV.PeerReceivedTime);//8
		pbB.setPeerSeenTime(rV.PeerSeenTime);//9
		pbB.setDeliviryStatusEnumId(rV.DeliviryStatusEnumId);//10
		pbB.setChatKey(rV.ChatKey);//11
		pbB.setRoomTypeEnumId(rV.RoomTypeEnumId);//12
		pbB.setIsByMe(rV.IsByMe);//13
		pbB.setRemoteId(rV.RemoteId);//14
		//r.MessageFileView = pb.getMessageFileView();//15

		return pbB.build();
    	}

	public static PB_MessageView.Builder toPB_Builder(RealmMessageView rV){//realmView
		PB_MessageView.Builder pbB = PB_MessageView.newBuilder();
		
		pbB.setMessageId(rV.MessageId);//0
		pbB.setMessageKey(rV.MessageKey);//1
		pbB.setRoomKey(rV.RoomKey);//2
		pbB.setUserId(rV.UserId);//3
		pbB.setMessageFileId(rV.MessageFileId);//4
		pbB.setMessageTypeEnumId(rV.MessageTypeEnumId);//5
		pbB.setText(rV.Text);//6
		pbB.setCreatedSe(rV.CreatedSe);//7
		pbB.setPeerReceivedTime(rV.PeerReceivedTime);//8
		pbB.setPeerSeenTime(rV.PeerSeenTime);//9
		pbB.setDeliviryStatusEnumId(rV.DeliviryStatusEnumId);//10
		pbB.setChatKey(rV.ChatKey);//11
		pbB.setRoomTypeEnumId(rV.RoomTypeEnumId);//12
		pbB.setIsByMe(rV.IsByMe);//13
		pbB.setRemoteId(rV.RemoteId);//14
		//r.MessageFileView = pb.getMessageFileView();//15

		return pbB;
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


	//for PB.Builder
	PB_MessageView.Builder b = PB_MessageView.newBuilder();
	
	b.setMessageId(r.MessageId);//0
	b.setMessageKey(r.MessageKey);//1
	b.setRoomKey(r.RoomKey);//2
	b.setUserId(r.UserId);//3
	b.setMessageFileId(r.MessageFileId);//4
	b.setMessageTypeEnumId(r.MessageTypeEnumId);//5
	b.setText(r.Text);//6
	b.setCreatedSe(r.CreatedSe);//7
	b.setPeerReceivedTime(r.PeerReceivedTime);//8
	b.setPeerSeenTime(r.PeerSeenTime);//9
	b.setDeliviryStatusEnumId(r.DeliviryStatusEnumId);//10
	b.setChatKey(r.ChatKey);//11
	b.setRoomTypeEnumId(r.RoomTypeEnumId);//12
	b.setIsByMe(r.IsByMe);//13
	b.setRemoteId(r.RemoteId);//14
	//r.MessageFileView = pb.getMessageFileView();//15


	//for PB.Builder - empty
	PB_MessageView.Builder b = PB_MessageView.newBuilder();
	
	b.setMessageId();//0
	b.setMessageKey();//1
	b.setRoomKey();//2
	b.setUserId();//3
	b.setMessageFileId();//4
	b.setMessageTypeEnumId();//5
	b.setText();//6
	b.setCreatedSe();//7
	b.setPeerReceivedTime();//8
	b.setPeerSeenTime();//9
	b.setDeliviryStatusEnumId();//10
	b.setChatKey();//11
	b.setRoomTypeEnumId();//12
	b.setIsByMe();//13
	b.setRemoteId();//14
	//r.MessageFileView = pb.getMessageFileView();//15



	
*/
