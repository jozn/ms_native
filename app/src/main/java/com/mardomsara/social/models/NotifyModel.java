package com.mardomsara.social.models;

import com.mardomsara.social.app.API;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.http.NotifysListJson;
import com.mardomsara.social.models.tables.Notify;

import java.util.List;

/**
 * Created by Hamid on 9/2/2016.
 */
public class NotifyModel {

    public static List<Notify> getAll(){
        return DB.db.selectFromNotify().toList();
    }

    public static void getSyncLasts(){
        loadFromServer();
    }

    public static void loadFromServer() {
        AndroidUtil.runInBackgroundNoPanic(()->{
            Http.Req req = new Http.Req();

            req.absPath = API.NOTIFICATIONS;
            req.urlParams.put("page",""+0);
            req.urlParams.put("last","");
            Http.Result res = Http.get(req);
            if(res.ok){
                    loadedPostsFromNet(res);
            }
        });
    }

    //in background thread
    private static void loadedPostsFromNet(Http.Result res) {
        NotifysListJson data= JsonUtil.fromJson(res.data, NotifysListJson.class);
        if(data != null && data.Payload != null && data.Status.equalsIgnoreCase("OK")){
            if(data.Payload != null){
                DB.db.transactionSync(()->{
                    for(Notify n : data.Payload){
                        n.PayloadStored = AppUtil.toJson(n.Load);
//                        AppUtil.log("PayloadStored " + n.PayloadStored);
//                        AppUtil.log("Load " + n.Load);
                        DB.db.insertIntoNotify(n);
//                        DB.db.prepareInsertIntoNotify().executeAll();

                    }
                });
            }
        }
    }

}
