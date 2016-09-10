package com.mardomsara.social.app;

import com.mardomsara.social.base.Command;
import com.mardomsara.social.models.NotifyModel;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.service.WSService;

/**
 * Created by Hamid on 7/2/2016.
 */
public class LifeCycle {

    public static void onAppActivityStarted(){
//        Sync.syncAllFollowings();
        Sync.checkSyncContacts();
        Sync.syncAllFollowings();

        NotifyModel.getSyncLasts();
    }

    static boolean _afterActivityCalled = false;
    public static void onAfterAppActivityStarted(){
        if(_afterActivityCalled) return;
        //////////////
        AppFiles.buildAllDirs();
        //////////////
        Command cmd = new Command();
        cmd.Name = "Echo";
        WSService.sendCommand(cmd);
        Session.fetchUserInfoFromServer();
        /////////////
        _afterActivityCalled = true;
    }


    public static void onAppActivityStartedNowHttpConnected(){

    }

    public static void onAppActivityStartedNowWebsocketConnected(){

    }

    public static void onAppBackgroundStarted(){


    }


}
