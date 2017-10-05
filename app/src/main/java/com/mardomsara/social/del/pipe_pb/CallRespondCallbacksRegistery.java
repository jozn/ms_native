package com.mardomsara.social.del.pipe_pb;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.TimeUtil;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by Hamid on 5/12/2016.
 */
class CallRespondCallbacksRegistery {
//    public static String CMD_RES ="ResCmd" ;
    private static  Map<Long, CallRespondCallback>  _mapper = Collections.synchronizedMap(new HashMap<>());

	public static void register(CallRespondCallback handler) {
		if(handler.clientCallId != 0 ){
			if(handler.timeoutAtMs == 0){
				handler.timeoutAtMs = TimeUtil.getTimeMs() + 2001;
			}
			_mapper.put(handler.clientCallId, handler);
		}
		setNextChecker();
	}

	//FIXME
//	@SuppressWarnings("All")
	static void trySucceeded(long ReqId, byte[] bytes) {
		CallRespondCallback h = _mapper.get(ReqId);
        if(h != null){
			if(h.success != null ){
				try {
					Method m = Class.forName(h.responseClass).getMethod("parseFrom", byte[].class);
					Object res = m.invoke(bytes);
//					PB_Message res = PB_Message.parseFrom(bytes);
					h.success.onResponse(res);
				/*} catch (InvalidProtocolBufferException e) {
					e.printStackTrace();*/
				} catch (Exception e2){
					e2.printStackTrace();
				}

//				h.success.onResponse(null);
			}
			cleanCall(h.clientCallId);
        }
    }

	static void tryReachedServer(long ReqId) {
		CallRespondCallback h = _mapper.get(ReqId);
		if(h != null){
			if(h.reachedServer != null ) {
				h.reachedServer.run();
			}
		}
	}

	private static void cleanCall(long ClientCallId){
		_mapper.remove(ClientCallId);
		Pipe.cancelCall(ClientCallId);
	}

	//just in case of timeout -- or server did't respond
	public static void tryErr(long ReqId) {
		CallRespondCallback h = _mapper.get(ReqId);
		if(h != null){
			if(h.error != null ){
				h.error.run();
			}
		}
	}

	public static void remove(long ReqId) {
		_mapper.remove(ReqId);
	}

	private static void runErrorOfTimeouts() {
		AppUtil.log(" Pipes runErrorOfTimeouts() ");
		for(CallRespondCallback call : _mapper.values()){
			if(call.timeoutAtMs < TimeUtil.getTimeMs()){
				try {
					if(call.error != null){
						call.error.run();
					}
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					cleanCall(call.clientCallId);
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