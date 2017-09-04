package com.mardomsara.social.models_realm;

import com.mardomsara.social.app.MSRealm;
import com.mardomsara.social.models_realm.pb_realm.RealmUserView;
//import com.mardomsara.social.models_realm.realm_local.RealmUserViewFields;

import io.realm.Realm;

/**
 * Created by Hamid on 8/21/2017.
 */

public class RealmUserViewHelper {

	public static RealmUserView getUserByUserId(int UserId){
		Realm realm = MSRealm.getChatRealm();
		RealmUserView r = realm.where(RealmUserView.class).equalTo("UserId", UserId).findFirst();
		realm.close();


		return r;
	}
}
