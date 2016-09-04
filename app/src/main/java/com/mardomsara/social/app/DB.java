package com.mardomsara.social.app;

import com.github.gfx.android.orma.AccessThreadConstraint;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.models.tables.AppDB;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Notify;

/**
 * Created by Hamid on 9/1/2016.
 */
public class DB {

    public static AppDB db = null;

    public static void init(){
        if(db != null) return;

        db = AppDB.builder(AppUtil.getContext())
                .readOnMainThread(AccessThreadConstraint.NONE)
                .name("ms4")
                .trace(true)
                .build();

        AndroidUtil.runInBackground(()-> {
            db.transactionSync(() -> {
                for (int i = 0; i < 100; i++) {
                    Notify not = new Notify();
                    not.Id = (long) i;
                    not.CreatedTime = (int) AppUtil.getTime();
//                    not.Load = JsonUtil.toJson(new UserInfoJson());
//                    db.insertIntoNotify(not);
                    Message msg = new Message();
                    msg.MessageKey = LangUtil.getRandomString(20);
                    msg.RoomKey = "u12";
                    db.insertIntoMessage(msg);
                }
            });
        });
    }

}
