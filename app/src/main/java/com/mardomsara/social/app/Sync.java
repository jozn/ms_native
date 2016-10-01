package com.mardomsara.social.app;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.old.DevicePhoneContact__OLD;
import com.mardomsara.social.models.Follow;
import com.mardomsara.social.models.old.PhoneContactsModel;

/**
 * Created by Hamid on 7/2/2016.
 */
public class Sync {

    public static void checkSyncContacts() {
        Runnable r = () -> {
//            PhoneContactsModel.syncContactsFromServer();
            try {
                DevicePhoneContact__OLD.checkForSync();
            }catch (Exception e){
                e.printStackTrace();
            }
        };
        AppUtil.runInBackgeound(r);
    }

    public static void syncDiffFollowings() {
        Runnable r = () -> {
            PhoneContactsModel.syncAllFollowingsFromServer();
        };
        AppUtil.runInBackgeound(r);
    }

    public static void syncAllFollowings() {
        Runnable r = () -> {
//            PhoneContactsModel.syncAllFollowingsFromServer();
//            Follow.syncAllFollowingsFromServer();
            Follow.checkSyncAllFollowingsFromServer();
        };
        AppUtil.runInBackgeound(r);
    }

}

//    public static void checkForSyncContacts() {
//
//    }