package com.mardomsara.social.app;

import com.mardomsara.social.enums.MessageEvent;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.tables.Message;

import java.util.List;

/**
 * Created by Hamid on 6/16/2017.
 */
//All event with their classes must be implemented in here
public class Events {

	private Events() {
	}

	public static void publish(Object object) {
		org.greenrobot.eventbus.EventBus.getDefault().post(object);
	}

	////////////////////// Classes /////////////////////////

	public static class NewMessages {
		public List<String> msgKeys;

		public NewMessages(List<String> msgKeys) {
			this.msgKeys = msgKeys;
		}
	}

	public static class RoomChanged {
		public List<String> roomsKeys;

		public RoomChanged(List<String> msgKeys) {
			this.roomsKeys = msgKeys;
		}
	}


	public static class MsgsMetaInfoChanged {
		public List<String> msgKeys;

		public MsgsMetaInfoChanged(List<String> msgKeys) {
			this.msgKeys = msgKeys;
		}
	}

	public static class RoomInfoChangedEvent {
		public String RoomKey;

		public RoomInfoChangedEvent(String roomKey) {
			RoomKey = roomKey;
		}
	}

	public static class RoomOrderChanged {
	}

	public static class OnMessageMetaEvent {
		public MessageEvent messageEvent;

		public int ToUserId = 0;
		public int PeerUserId = 0;
		public String MsgKey = "";
		public String RoomKey = "";
		public long AtTime = 0;

		public OnMessageMetaEvent(Message msg, MessageEvent messageEvent) {
			this.messageEvent = messageEvent;
			RoomKey = msg.RoomKey;
			MsgKey = msg.MessageKey;
			AtTime = TimeUtil.getTimeSec();
		}
	}

}
