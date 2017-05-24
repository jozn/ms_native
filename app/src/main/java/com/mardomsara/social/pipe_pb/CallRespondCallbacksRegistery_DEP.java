package com.mardomsara.social.pipe_pb;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by Hamid on 5/12/2016.
 */
class CallRespondCallbacksRegistery_DEP {
//    public static String CMD_RES ="ResCmd" ;
    private static  Map<Long, CallRespondCallback_DEP>  _mapper = Collections.synchronizedMap(new HashMap<>());

	public static void register(CallRespondCallback_DEP handler) {
		if(handler.clientCallId != 0 ){
			if(handler.timeoutAtMs == 0){
				handler.timeoutAtMs = TimeUtil.getTimeMs() + 2001;
			}
			_mapper.put(handler.clientCallId, handler);
		}
		setNextChecker();
	}

    static void trySucceeded(long ReqId) {
		CallRespondCallback_DEP h = _mapper.get(ReqId);
        if(h != null){
			if(h.success != null ){
				h.success.run();
			}
			cleanCall(h.call);
        }
    }

	private static void cleanCall(Call_DEP call){
		_mapper.remove(call.ClientCallId);
		Pipe_DEP.cancelCall(call);
	}

	//just in case of timeout -- or server did't respond
	public static void tryErr(long ReqId) {
		CallRespondCallback_DEP h = _mapper.get(ReqId);
		if(h != null){
			if(h.error != null ){
				h.success.run();
			}
		}
	}

	public static void remove(long ReqId) {
		_mapper.remove(ReqId);
	}

	private static void runErrorOfTimeouts() {
		AppUtil.log(" Pipes runErrorOfTimeouts() ");
		for(CallRespondCallback_DEP call : _mapper.values()){
			if(call.timeoutAtMs < TimeUtil.getTimeMs()){
				try {
					if(call.error != null){
						call.error.run();
					}
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					cleanCall(call.call);
//					_mapper.remove(call.clientCallId);
				}
			}
		}
	}
	private static boolean hasSetInterval = false;
	private static synchronized void setHasSetInterval(boolean val){
		hasSetInterval = val;
	}
	private static synchronized boolean getHasSetInterval(){
		return hasSetInterval;
	}
	private static void setNextChecker(){
		if(getHasSetInterval()){
			return;
		}
		setHasSetInterval(true);
		Runnable runner  = ()->{
			int n = 0;
			while (n < 5){ // 5 times * 1 second  = 5sec
				try {
					Thread.sleep(1000);
					runErrorOfTimeouts();
				}catch (Exception e){
					e.printStackTrace();
				}
				n++;
			}
			setHasSetInterval(false);
			if(_mapper.size() >0){
				setNextChecker();
			}
		};
		Executors.newSingleThreadExecutor().execute(runner);
	}
}