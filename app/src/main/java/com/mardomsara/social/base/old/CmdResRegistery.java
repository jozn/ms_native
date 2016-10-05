package com.mardomsara.social.base.old;

import com.mardomsara.social.pipe.NetEventHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 5/12/2016.
 */
@Deprecated
public class CmdResRegistery {
    public static String CMD_RES ="ResCmd" ;
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

    public static void tryRunCmd(Command cmd) {
       if(cmd != null && cmd.ResId > 0 ){
           tryRun(cmd.ResId, cmd.Data);
       }
    }
}