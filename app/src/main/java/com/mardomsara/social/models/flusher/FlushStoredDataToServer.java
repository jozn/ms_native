package com.mardomsara.social.models.flusher;

import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgSeen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 10/13/2016.
 */

public class FlushStoredDataToServer {
	public static void flushAllMessages() {
		if (false){
			List<Message> msgs = DB.getAppDB().selectFromMessage().ToPushEq(1).toList();
			flushTextMessages(msgs);
			flushMediaMsgs(msgs);
			flushVideoMessages(msgs);

			flushSeenMessages();
		}
	}

	public static void flushTextMessages(List<Message> msgs){
		AndroidUtil.runInBackgroundNoPanic(()->{
			List txtMsgs = new ArrayList();
			for(Message msg : msgs){
				if(msg.MessageTypeId == Constants.MESSAGE_TEXT){
					txtMsgs.add(msg);
				}
			}
			MsgsCallToServer.addManyMsgs(txtMsgs);
		});
	}

	public static void flushMediaMsgs(List<Message> msgs){
		AndroidUtil.runInBackgroundNoPanic(()->{
			for(Message msg : msgs){
				try {
					if(msg.MessageTypeId == Constants.MESSAGE_IMAGE){
						File file = new File(msg.MsgFile_LocalSrc);
						MsgsCallToServer.sendNewPhoto(msg,file,null,false);
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}

		});
	}

	public static void flushVideoMessages(List<Message> msgs){
		AndroidUtil.runInBackgroundNoPanic(()->{
			for(Message msg : msgs){
				try {
					if(msg.MessageTypeId == Constants.MESSAGE_VIDEO){
						File file = new File(msg.MsgFile_LocalSrc);
						MsgsCallToServer.sendNewVideo(msg,file);
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	public static void flushSeenMessages(){
		List<MsgSeen> msgsSeen = DB.getAppDB().selectFromMsgSeen().toList();
		if(msgsSeen == null || msgsSeen.size() ==0 )return;
		MsgsCallToServer.sendSeenMsgs(msgsSeen);
	}

}
