package com.mardomsara.social.models;

import com.mardomsara.social.App;
import com.mardomsara.social.app.API;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.http.NotifysListJson;
import com.mardomsara.social.json.social.rows.NotifysAddRemoveJson;
import com.mardomsara.social.models.events.NotifyChanged;
import com.mardomsara.social.models.tables.Notify;

import java.util.List;

/**
 * Created by Hamid on 9/2/2016.
 */
public class NotifyModel {

	@Deprecated
    private static List<Notify> getAll(){
        return DB.db.selectFromNotify().toList();
    }

    public static List<Notify> getAllReverse(){
//        DB.db.updateNotify().ForUserId(55).execute();
        return DB.db.selectFromNotify().orderByIdDesc().toList();
    }

    public static void getSyncLasts(){
        loadFromServer();
    }

	private static void loadFromServer() {
		App.getBus().post(new NotifyChanged());
		Http.getPath("/v1/notify_add_remove")
			.setQueryParam("last",""+getLast())
			.doAsync(result -> {
				HttpJson<NotifysAddRemoveJson> data = Result.fromJson(result,NotifysAddRemoveJson.class);
				if(data.isPayloadNoneEmpty()){
					if(data.Payload.Add != null && data.Payload.Add.size()>0){
						DB.db.transactionSync(()->{
							for(Notify n : data.Payload.Add){
								n.PayloadStored = AppUtil.toJson(n.Load);
								DB.db.insertIntoNotify(n);
							}
						});
					}

					if(data.Payload.Remove != null && data.Payload.Remove.size()>0){
						DB.db.deleteFromNotify().IdIn(data.Payload.Remove).execute();
					}

					App.getBus().post(new NotifyChanged());
				}
			});
	}

	private static void loadFromServer_simple() {
		App.getBus().post(new NotifyChanged());
		Http.getPath("/v1/notify")
			.setQueryParam("last",""+getLast())
			.doAsync(result -> {
				HttpJsonList<Notify> data = Result.fromJsonList(result,Notify.class);
				if(data.isPayloadNoneEmpty()){
					DB.db.transactionSync(()->{
						for(Notify n : data.Payload){
							n.PayloadStored = AppUtil.toJson(n.Load);
							DB.db.insertIntoNotify(n);
						}
					});
				}
			});
	}

	public static long getLast() {
		Notify not = DB.db.selectFromNotify().orderByIdDesc().limit(1).getOrNull(0);
		if(not != null){
			return not.Id;
		}
		return 0;
	}

	@Deprecated
	private static void loadFromServer_dep() {
        AndroidUtil.runInBackgroundNoPanic(()->{
            HttpOld.Req req = new HttpOld.Req();

            req.absPath = API.NOTIFICATIONS;
            req.urlParams.put("page",""+0);
            req.urlParams.put("last","");
            HttpOld.Result res = HttpOld.get(req);
            if(res.ok){
                    loadedPostsFromNet_dep(res);
            }
        });
    }

    //in background thread
    private static void loadedPostsFromNet_dep(HttpOld.Result res) {
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
