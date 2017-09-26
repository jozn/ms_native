package com.mardomsara.social.models_old.realm_old_no_cloud;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
//TODO // FIXME: 7/9/2017
public class RowOfflineMsgSeen extends RealmObject {
    @PrimaryKey
	public long id;
	public long offlineSeen;
}
