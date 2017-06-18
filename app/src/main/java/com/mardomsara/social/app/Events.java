package com.mardomsara.social.app;

import java.util.List;

/**
 * Created by Hamid on 6/16/2017.
 */
//All event with their classes must be implemented in here
public class Events {


	public static void publish(Object object){
		org.greenrobot.eventbus.EventBus.getDefault().post(object);
	}

	public static class NewMessages {
		public List<String> msgKeys;

		public NewMessages(List<String> msgKeys) {
			this.msgKeys = msgKeys;
		}
	}
	public static class MsgsMetaInfoChanged {
		public List<String> msgKeys;

		public MsgsMetaInfoChanged(List<String> msgKeys) {
			this.msgKeys = msgKeys;
		}
	}


}
