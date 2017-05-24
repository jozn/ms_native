package com.mardomsara.social.pipe_pb;

import com.mardomsara.social.helpers.AndroidUtil;

/**
 * Created by Hamid on 10/5/2016.
 */
public class Pipe_DEP {

	public static void sendCall(Call_DEP call, Runnable success , Runnable error){
		AndroidUtil.runInBackgroundNoPanic(()->{
			if(WS_DEP.getInstance().isOpen()){
				CallRespondCallback_DEP respondCallback = new CallRespondCallback_DEP(call, success,error);
				CallRespondCallbacksRegistery_DEP.register(respondCallback);
				WS_DEP.getInstance().sendCall(call);
			}else {
				if(error != null){
					error.run();
				}
			}
		});
	}
	public static void cancelCall(Call_DEP call){
		AndroidUtil.runInBackgroundNoPanic(()->{
			WS_DEP.getInstance().cancelCall(call);
		});
	}

	public static void sendCall(String callName, String data, Runnable success , Runnable error){
		Call_DEP call = new Call_DEP(callName,data);

		sendCall(call,success,error);
	}

}
