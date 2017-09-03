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
		public RoomTypeEnum RoomTypeEnum;//11 				 PB 31
		public boolean IsByMe;//12 				 PB 33
		public PB_MessageFileView File;//13 				 PB 100
	

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
	    r.RoomTypeEnum = pb.getRoomTypeEnum();//11
	    r.IsByMe = pb.getIsByMe();//12
	    r.File = pb.getFile();//13

	    return r;
	}

}
	/*
	folding

	PBFlatTypes.PB_MessageView t = new PBFlatTypes.PB_MessageView();
    t.MessageId = pb.getMessageId();
    t.RoomKey = pb.getRoomKey();
    t.UserId = pb.getUserId();
    t.MessageFileId = pb.getMessageFileId();
    t.MessageTypeEnumId = pb.getMessageTypeEnumId();
    t.Text = pb.getText();
    t.Time = pb.getTime();
    t.PeerReceivedTime = pb.getPeerReceivedTime();
    t.PeerSeenTime = pb.getPeerSeenTime();
    t.DeliviryStatusEnumId = pb.getDeliviryStatusEnumId();
    t.ChatId = pb.getChatId();
    t.RoomTypeEnum = pb.getRoomTypeEnum();
    t.IsByMe = pb.getIsByMe();
    t.File = pb.getFile();
	*/

	/*
	PBFlatTypes.PB_MessageView t = new PBFlatTypes.PB_MessageView();
	t.MessageId = ;
	t.RoomKey = ;
	t.UserId = ;
	t.MessageFileId = ;
	t.MessageTypeEnumId = ;
	t.Text = ;
	t.Time = ;
	t.PeerReceivedTime = ;
	t.PeerSeenTime = ;
	t.DeliviryStatusEnumId = ;
	t.ChatId = ;
	t.RoomTypeEnum = ;
	t.IsByMe = ;
	t.File = ;
	*/

	/*
	PB_MessageView t = new PB_MessageView();
	t.MessageId = m.getMessageId() ;
	t.RoomKey = m.getRoomKey() ;
	t.UserId = m.getUserId() ;
	t.MessageFileId = m.getMessageFileId() ;
	t.MessageTypeEnumId = m.getMessageTypeEnumId() ;
	t.Text = m.getText() ;
	t.Time = m.getTime() ;
	t.PeerReceivedTime = m.getPeerReceivedTime() ;
	t.PeerSeenTime = m.getPeerSeenTime() ;
	t.DeliviryStatusEnumId = m.getDeliviryStatusEnumId() ;
	t.ChatId = m.getChatId() ;
	t.RoomTypeEnum = m.getRoomTypeEnum() ;
	t.IsByMe = m.getIsByMe() ;
	t.File = m.getFile() ;
	
*/
