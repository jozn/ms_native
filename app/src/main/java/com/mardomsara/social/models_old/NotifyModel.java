package com.mardomsara.social.models_old;

import com.mardomsara.social.App;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.NotifysAddRemoveJson;
import com.mardomsara.social.models_old.events.NotifyChanged;
import com.mardomsara.social.models_old.tables.Notify;

import java.util.List;

/**
 * Created by Hamid on 9/2/2016.
 */
public class NotifyModel {

	@Deprecated
    private static List<Notify> getAll(){
        return DB.getAppDB().selectFromNotify().toList();
    }

    public static List<Notify> getAllReverse(){
//        DB.db.updateNotify().ForUserId(55).execute();
        return DB.getAppDB().selectFromNotify().orderByIdDesc().toList();
    }

    public static void fetchSyncLasts(){
        loadFromServer(true);
    }

	public static void loadFromServer(boolean force) {
		App.getBus().post(new NotifyChanged());
		long l = getLast();
		if(force) l=0;
		Http.getPath("/v1/notify_add_remove")
			.setQueryParam("last",""+l)
			.doAsync(result -> {
				HttpJson<NotifysAddRemoveJson> data = Result.fromJson(result,NotifysAddRemoveJson.class);
				if(data.isPayloadNoneEmpty()){
					if(data.Payload.Add != null && data.Payload.Add.size()>0){
						DB.getAppDB().transactionSync(()->{
							for(Notify n : data.Payload.Add){
								n.PayloadStored = AppUtil.toJson(n.Load);
								DB.getAppDB().insertIntoNotify(n);
							}
						});
					}

					if(data.Payload.Remove != null && data.Payload.Remove.size()>0){
						DB.getAppDB().deleteFromNotify().IdIn(data.Payload.Remove).execute();
					}

					App.getBus().post(new NotifyChanged());
				}
			});
	}

	private static void loadFromServer_2(boolean force) {
		App.getBus().post(new NotifyChanged());
		long l = getLast();
		if(force) l=0;
		Http.getPath("/v1/notify_add_remove")
			.setQueryParam("last",""+l)
			.doAsync(result -> {
				HttpJson<NotifysAddRemoveJson> data = Result.fromJson(result,NotifysAddRemoveJson.class);
				if(data.isPayloadNoneEmpty()){
					if(data.Payload.Add != null && data.Payload.Add.size()>0){
						DB.getAppDB().transactionSync(()->{
							for(Notify n : data.Payload.Add){
								n.PayloadStored = AppUtil.toJson(n.Load);
								DB.getAppDB().insertIntoNotify(n);
							}
						});
					}

					if(data.Payload.Remove != null && data.Payload.Remove.size()>0){
						DB.getAppDB().deleteFromNotify().IdIn(data.Payload.Remove).execute();
					}

					App.getBus().post(new NotifyChanged());
				}
			});
	}

	@Deprecated
	private static void loadFromServer_simple() {
		App.getBus().post(new NotifyChanged());
		Http.getPath("/v1/notify")
			.setQueryParam("last",""+getLast())
			.doAsync(result -> {
				HttpJsonList<Notify> data = Result.fromJsonList(result,Notify.class);
				if(data.isPayloadNoneEmpty()){
					DB.getAppDB().transactionSync(()->{
						for(Notify n : data.Payload){
							n.PayloadStored = AppUtil.toJson(n.Load);
							DB.getAppDB().insertIntoNotify(n);
						}
					});
				}
			});
	}

	public static long getLast() {
		Notify not = DB.getAppDB().selectFromNotify().orderByIdDesc().limit(1).getOrNull(0);
		if(not != null){
			return not.Id;
		}
		return 0;
	}

}
