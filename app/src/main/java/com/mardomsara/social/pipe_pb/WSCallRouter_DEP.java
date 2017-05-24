package com.mardomsara.social.pipe_pb;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.AppModel;
import com.mardomsara.social.pipe_pb.from_net_calls.MsgCallsFromServer;
import com.mardomsara.social.pipe_pb.from_net_calls.NotifyCallsFromServer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 3/31/2016.
 */
@Deprecated
public class WSCallRouter_DEP {

    static {
        mapper = new HashMap<>();//must be here - otherwise it will not inintilaze befor buildMapper()
        buildMapper();
    }

    static Map<String,NetEventHandler_DEP> mapper;

    static void register(String command, NetEventHandler_DEP handler){
        mapper.put(command,handler);
    }

    public static void handle(String command, Call_DEP call){
		if(call == null || command == null) return;

		String data = call.Data;
        AppUtil.log("WS handle: "+ command + " data : "+ data);
        try {
            NetEventHandler_DEP handler =  mapper.get(command);
            if(handler != null){
                handler.handle(data);
            }else if(command.equals("TimeMs")) {
				TimeMs(call);
			}else {
                AppUtil.error("NetEventRouter for "+ command +" has not been registered. ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void buildMapper() {

        //Messages
		register("MsgAddOne", MsgCallsFromServer.MsgAddOne);
		register("MsgAddMany", MsgCallsFromServer.MsgAddMany);
        register("MsgsReceivedToPeerMany", MsgCallsFromServer.MsgsReceivedToPeerMany);
        register("MsgsDeletedFromServerMany", MsgCallsFromServer.MsgsDeletedFromServerMany);
        register("MsgsSeenByPeerMany", MsgCallsFromServer.MsgsSeenByPeerMany);

		//Notify
        register("NotifyAddOne", NotifyCallsFromServer.NotifyAddOne);
        register("NotifyRemoveMany", NotifyCallsFromServer.NotifyRemoveMany);

//		register("NotifyRemoveMany", MsgCallsFromServer.MsgAddOne);
//		register("NotifyAddOne", MsgCallsFromServer.MsgAddMany);
    }

	static void TimeMs(Call_DEP call) {
		AppModel.timeDiffToServer = call.TimeMs - TimeUtil.getTimeMs();

	}

}
