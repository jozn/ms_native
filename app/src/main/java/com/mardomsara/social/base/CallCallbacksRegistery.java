package com.mardomsara.social.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 5/12/2016.
 */
public class CallCallbacksRegistery {
//    public static String CMD_RES ="ResCmd" ;
    private static Map<Long, NetEventHandler> _mapper = new HashMap<>();

    public static void register(long ReqId, NetEventHandler handler) {
        _mapper.put(ReqId, handler);
    }

    public static void tryRun(long ReqId, String data) {
        NetEventHandler h = _mapper.get(ReqId);
        if(h !=  null){
            h.handle(data);
        }
    }

    public static void tryRunCmd(Call call) {
       if(call != null && call.ClientCallId > 0 ){
           tryRun(call.ClientCallId, call.Data);
       }
    }

}