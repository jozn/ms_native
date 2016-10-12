package com.mardomsara.social.pipe.from_net_calls;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.pipe.Call;
import com.mardomsara.social.pipe.Pipe;

/**
 * Created by Hamid on 10/12/2016.
 */

public class MsgsCallToServer {
	public static void addNewMsg(Message msg){
		Call call = new Call("MsgsAddOne",msg);

		Runnable succ =  ()->{
			msg.ToPush = 0;
			msg.ServerReceivedTime = TimeUtil.getTime();
			msg.save();
		};

		Pipe.sendCall(call,succ,null);
	}
}
