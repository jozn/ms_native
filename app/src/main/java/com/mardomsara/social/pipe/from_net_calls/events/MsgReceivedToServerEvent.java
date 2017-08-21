package com.mardomsara.social.pipe.from_net_calls.events;

import com.mardomsara.social.App;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.tables.Message;

/**
 * Created by Hamid on 10/14/2016.
 */
@Deprecated
public class MsgReceivedToServerEvent {
	public int ToUserId = 0;
	public int PeerUserId = 0;
	public String MsgKey="";
	public String RoomKey="";
	public long AtTime = 0;

	public static void publishNew(Message msg){
		MsgReceivedToServerEvent meta = new MsgReceivedToServerEvent();
		meta.RoomKey = msg.RoomKey;
		meta.MsgKey = msg.MessageKey;
		meta.AtTime = TimeUtil.getTimeSec();

		App.getBus().post(meta);
	}

}
