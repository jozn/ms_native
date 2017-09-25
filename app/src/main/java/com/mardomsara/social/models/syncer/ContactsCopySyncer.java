package com.mardomsara.social.models.syncer;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.models_realm.android.DevicePhoneContacts;
import com.mardomsara.social.models_realm.android.PhoneContact;
import com.mardomsara.social.models.tables.ContactsCopy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 10/2/2016.
 */
public class ContactsCopySyncer {
	public static void checkChangesAndSyncToServer_BG(){
		AndroidUtil.runInBackgroundNoPanic(()->{
			syncToServerImple(null,false);
		});
	}

	public static void forceSyncToServer(Runnable runnable){
		syncToServerImple(runnable,true);
	}

	//Private
	public static void syncToServerImple(Runnable runnable, boolean force){
		DevicePhoneContacts.fetchAllWithAskPermisions((rows)->{//rows: contcs fetche from device
			AppUtil.log("checkChangesAndSyncToServer_BG");
			List<String> listOfHashes = new ArrayList<String>();
			for(PhoneContact row : rows){
				row.calculateHash();
				listOfHashes.add(row.Hash);
			}

			List<ContactsCopy> list = DB.getAppDB().selectFromContactsCopy().HashIn(listOfHashes).toList();
			if(list.size() != rows.size() || (force && rows.size()>0) ){
				insertFetchedContactsToTable(rows);
			}
			syncCopyTableRowsToServer();
			if(runnable!= null) runnable.run();
		});

	}



	//performs a full delete and reinsert
	private static void insertFetchedContactsToTable(List<PhoneContact> rows){
		List<ContactsCopy> list = new ArrayList<>();
		for(PhoneContact row : rows){
			row.calculateHash();
			list.add(row.toNewContactsCopy());
		}

		DB.getAppDB().deleteFromContactsCopy().execute();//delete all
		DB.getAppDB().transactionSync(()->{
			for(ContactsCopy r : list){
				r.insert();
			}
		});

	}

	//must be called during change contact AND on startup of app (maybe we haven has internet connection)
	private static void syncCopyTableRowsToServer() {
		List<ContactsCopy> list = DB.getAppDB().selectFromContactsCopy().IsSyncedEq(0).toList();
		if(list.size() ==0 )return;

		//work around: PhoneNormalizedNumber is alot empty: for noe mobile phone for example
		DB.getAppDB().updateContactsCopy().IsSynced(1).PhoneNormalizedNumberEq("").execute();

		Http.postPath("/v1/grab_contacts")
			.setFormParam("contacts", JsonUtil.toJson(list))
			.doAsync((result)->{
				if(result.isOk()){
					HttpJsonList<String> res =Result.fromJsonList(result, String.class);
					if(res != null && res.Payload != null){
						DB.getAppDB().updateContactsCopy().IsSynced(1).PhoneNormalizedNumberIn(res.Payload).execute();
					}
				}
				Helper.showDebugMessage("sync contacts: " +result.isOk());
			});
	}

}
