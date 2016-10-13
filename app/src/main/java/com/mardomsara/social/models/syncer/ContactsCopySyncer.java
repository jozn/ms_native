package com.mardomsara.social.models.syncer;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.models.android.DevicePhoneContacts;
import com.mardomsara.social.models.android.PhoneContact;
import com.mardomsara.social.models.tables.ContactsCopy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 10/2/2016.
 */
public class ContactsCopySyncer {
	public static void checkChangesAndSyncToServer(){
		AndroidUtil.runInBackgroundNoPanic(()->{
			DevicePhoneContacts.fetchAllWithAskPermisions((rows)->{//rows: contcs fetche from device
				List<String> listOfHashes = new ArrayList<String>();
				for(PhoneContact row : rows){
					row.calculateHash();
					listOfHashes.add(row.Hash);
				}

				List<ContactsCopy> list = DB.db.selectFromContactsCopy().HashIn(listOfHashes).toList();
				if(list.size() != rows.size()){
					insertFetchedContactsToTable(rows);
				}
				syncCopyTableRowsToServer();
			});
		});
	}

	//performs a full delete and reinsert
	static void insertFetchedContactsToTable(List<PhoneContact> rows){
		List<ContactsCopy> list = new ArrayList<>();
		for(PhoneContact row : rows){
			row.calculateHash();
			list.add(row.toNewContactsCopy());
		}

		DB.db.deleteFromContactsCopy().execute();//delete all
		DB.db.transactionSync(()->{
			for(ContactsCopy r : list){
				r.insert();
			}
		});

	}

	//must be called during change contact AND on startup of app (maybe we haven has internet connection)
	static void syncCopyTableRowsToServer() {
		List<ContactsCopy> list = DB.db.selectFromContactsCopy().IsSyncedEq(0).toList();
		if(list.size() ==0 )return;

		//work around: PhoneNormalizedNumber is alot empty: for noe mobile phone for example
		DB.db.updateContactsCopy().IsSynced(1).PhoneNormalizedNumberEq("").execute();

		Http.postPath("/v1/grab_contacts")
			.setFormParam("contacts", JsonUtil.toJson(list))
			.doAsync((result)->{
				if(result.isOk()){
					HttpJsonList<String> res =Result.fromJsonList(result, String.class);
					if(res != null && res.Payload != null){
						DB.db.updateContactsCopy().IsSynced(1).PhoneNormalizedNumberIn(res.Payload).execute();
					}
				}
				Helper.showDebugMessage("sync contacts: " +result.isOk());
			});
	}

}
