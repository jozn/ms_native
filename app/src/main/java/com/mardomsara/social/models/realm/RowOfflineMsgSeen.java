package com.mardomsara.social.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
//TODO // FIXME: 7/9/2017
public class RowOfflineMsgSeen extends RealmObject {
    @PrimaryKey
	public long id;
	public long offlineSeen;
}
