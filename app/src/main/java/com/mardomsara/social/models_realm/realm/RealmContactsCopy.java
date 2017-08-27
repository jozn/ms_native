package com.mardomsara.social.models_realm.realm;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class RealmContactsCopy extends RealmObject {

    @PrimaryKey
	public int PhoneContactRowId;

    public String PhoneNumber = "";//0935... +98910711..

	@Index
    public String PhoneNormalizedNumber = "";

    public String PhoneDisplayName = "";

    public String PhoneFamilyName = "";

    public int IsSynced = 0;

    public int IsRemoved = 0;

	@Index
    public String Hash = "";

    /*public void calculateHash(){
        Hash = FNV.fnv1a_32(toStringForHash().getBytes()).toString();
    }*/

    /*public void insert(){
        DB.db.relationOfContactsCopy().upserter().execute(this);
    }*/

}
