package com.mardomsara.social.app;

/**
 * Created by Hamid on 7/2/2016.
 */
public class LifeCycle {

    public static void onAppActivityStarted(){
//        Sync.syncAllFollowings();
        Sync.checkSyncContacts();
        Sync.syncAllFollowings();
    }

    public static void onAppActivityStartedNowHttpConnected(){

    }

    public static void onAppActivityStartedNowWebsocketConnected(){

    }

    public static void onAppBackgroundStarted(){


    }


}
