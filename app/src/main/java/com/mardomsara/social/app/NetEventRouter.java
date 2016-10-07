package com.mardomsara.social.app;

import com.mardomsara.social.base.old.Command;
import com.mardomsara.social.pipe.NetEventHandler;
import com.mardomsara.social.events.from_server.HelloCommand;
//import com.mardomsara.social.events.from_server.MsgCommand;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.net_events.MsgCommand_DEP;
import com.mardomsara.social.service.WS_DEP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 3/31/2016.
 */
@Deprecated
public class NetEventRouter {

    static {
        mapper = new HashMap<>();//must be here - otherwise it will not inintilaze befor buildMapper()
        buildMapper();
    }

    public static Map<String,NetEventHandler> mapper;

    public static void register(String command, NetEventHandler handler){
        mapper.put(command,handler);
    }

    public static void handle(String command, String data){
        AppUtil.log("WS handle: "+ command + " data : "+ data);
        try {
            NetEventHandler handler =  mapper.get(command);
            if(handler != null){
                handler.handle(data);
            }else {
                AppUtil.error("NetEventRouter for "+ command +" has not been registered. ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void handleResponse(Command command) {

    }

    public static void buildMapper() {
        register("time", HelloCommand.addMesage);
        register("hello", HelloCommand.addMesage);

        //dep
        register("addMsg", MsgCommand_DEP.addSingleMsg);
        //Messages
        register(Constants.MsgsAddNew, MsgCommand_DEP.MsgsAddNew);
        register(Constants.MsgsReceivedToServer, MsgCommand_DEP.MsgsReceivedToServer);
        register(Constants.MsgsReceivedToPeer, MsgCommand_DEP.MsgsReceivedToPeer);
        register(Constants.MsgsSeenByPeer, MsgCommand_DEP.MsgsSeenByPeer);
        register(Constants.MsgsDeletedFromServer, MsgCommand_DEP.MsgsDeletedFromServer);

        //internal
        register(Constants.CommandsReceivedToServer, WS_DEP.CommandsReceivedToServer_Handler);

        //////////////////
        register("SetUserForTable", MsgCommand_DEP.SetUserForTable);
        register("SetUserForTable", MsgCommand_DEP.SetUserForTable);

//        register("ResCmd", MsgCommand.SetUserForTable);

    }

}
