package com.mardomsara.social.pipe;

import com.mardomsara.social.helpers.TimeUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 5/12/2016.
 */
public class CallRespondCallbacksRegistery {
//    public static String CMD_RES ="ResCmd" ;
    private static  Map<Long, CallRespondCallback>  _mapper = Collections.synchronizedMap(new HashMap<>());

	public static void register(CallRespondCallback handler) {
		if(handler.clientCallId != 0 ){
			if(handler.timeoutAtMs == 0){
				handler.timeoutAtMs = TimeUtil.getTimeMs() + 2000;
			}
			_mapper.put(handler.clientCallId, handler);
		}
	}

    public static void trySucc(long ReqId) {
		CallRespondCallback h = _mapper.get(ReqId);
        if(h != null){
			if(h.success != null ){
				h.success.run();
			}
        }
    }

	//just in case of timeout -- or server did't respond
	public static void tryErr(long ReqId) {
		CallRespondCallback h = _mapper.get(ReqId);
		if(h != null){
			if(h.error != null ){
				h.success.run();
			}
		}
	}

	public static void remove(long ReqId) {
		_mapper.remove(ReqId);
	}

	public static void runErrorOfTimeouts() {
		for(CallRespondCallback call : _mapper.values()){
			if(call.timeoutAtMs < TimeUtil.getTimeMs()){
				try {
					if(call.error != null){
						call.error.run();
					}
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					_mapper.remove(call.clientCallId);
				}
			}
		}
	}

	static void intervalRun(){
		Runnable runer  = ()->{
			while (true){
				try {
					Thread.sleep(1000);
					runErrorOfTimeouts();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		};

		new Thread(runer,"WS Call timeout checker").run();
	}
}