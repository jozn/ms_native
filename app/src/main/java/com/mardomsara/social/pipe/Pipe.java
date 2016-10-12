package com.mardomsara.social.pipe;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.JsonUtil;

/**
 * Created by Hamid on 10/5/2016.
 */
public class Pipe {

	public static void sendCall(Call call, Runnable success , Runnable error){
		AndroidUtil.runInBackgroundNoPanic(()->{
			CallRespondCallback respondCallback = new CallRespondCallback(call, success,error);
			CallRespondCallbacksRegistery.register(respondCallback);

			WS.getInstance().sendCall(call);
		});
	}
	public static void cancelCall(Call call){
		AndroidUtil.runInBackgroundNoPanic(()->{
			WS.getInstance().cancelCall(call);
		});
	}

	public static void sendCall(String callName, String data, Runnable success , Runnable error){
		Call call = new Call(callName,data);

		sendCall(call,success,error);
	}

}
