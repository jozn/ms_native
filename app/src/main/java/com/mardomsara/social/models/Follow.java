package com.mardomsara.social.models;

import com.mardomsara.social.app.API;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.json.SyncFollowings;
import com.mardomsara.social.json.UserRow;
import com.mardomsara.social.tables.UsersTable;
import com.mardomsara.social.tables.UsersTable_Table;
import com.orhanobut.hawk.Hawk;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * Created by Hamid on 7/3/2016.
 */
public class Follow {
    //todo improve followings syncs mechainsm
    public static void checkSyncAllFollowingsFromServer(){
        long last = Hawk.<Long>get(Config.SYNC_DIFF_FOLLOWINGS_LAST_TIMESTAMP,0L);
        if(last+8< TimeUtil.getTime()){
            syncAllFollowingsFromServer();
            Hawk.put(Config.SYNC_DIFF_FOLLOWINGS_LAST_TIMESTAMP, TimeUtil.getTime());
        }
    }

    public static void syncAllFollowingsFromServer(){
        try {
            HttpOld.Req rq = new HttpOld.Req();
            rq.absPath = API.FOLLOWINGS_SYNC_ALL.toString();
            rq.urlParams.put("last", ""+ Hawk.<Long>get(Config.SYNC_DIFF_FOLLOWINGS_LAST_TIMESTAMP,0L));
            HttpOld.Result res = HttpOld.masterSendPost(rq);
            AppUtil.log("http result of syncAllFollowingsFromServer() :" +res.data);
            if(res.ok == false) {
                AppUtil.error("http result of syncAllFollowingsFromServer() is failed");
                return;
            }
            SyncFollowings r = JsonUtil.fromJson(res.data, SyncFollowings.class);
            removeFollowings(r.Payload.Remove);
            saveFollowings(r.Payload.Add);
            Hawk.put(Config.SYNC_DIFF_FOLLOWINGS_LAST_TIMESTAMP, (long)r.ServerTime);

        }catch (Exception e){
            AppUtil.log(e.toString());
        }
    }

    public static void removeFollowings(List<Integer> ids){
//        AppDatabase appDb = DBSingletons.getAppDataBase();
//        String q = "delete from contacts where UserId in("+ DbUtil.ToSqlIn(ids) +") and IsPhoneContact = 0";
        AppUtil.log("deleteing Contacts: for refresh: ");
        Integer[] ins = new Integer[ids.size()] ;
        int[] in2 = new int[ids.size()] ;
        for (int i =0;i<ids.size();i++){
            in2[i] = (int)ids.get(i);
        }
        ins = ids.toArray(ins);

        SQLite.delete().from(UsersTable.class).where(UsersTable_Table.UserId.in( -1,in2  ))
                .and(UsersTable_Table.IsPhoneContact.eq(0)).execute();
//        appDb.rawQuery(q, new Object[]{});
    }

    public static void saveFollowings(List<UserRow> users){
        for (UserRow user: users){
            UsersTable c = new UsersTable();
            c.setIsPhoneContact(0);//
            user.setUserTableParams(c);
            AppUtil.log("persisting following" + c.toString());
            c.insert();//Bug: just insert - dont save otherwise will remove contacts rows - if we follow too
        }
    }

}
