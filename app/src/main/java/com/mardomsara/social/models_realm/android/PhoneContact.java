package com.mardomsara.social.models_realm.android;

import com.mardomsara.social.base.FNV;
import com.mardomsara.social.models.tables.ContactsCopy;
import com.mardomsara.social.models_realm.realm_local.RealmContactsCopy;

public class PhoneContact {
	//fields
	public String PhoneNumber = "";//0935... +98910711..
	public String PhoneNormalizedNumber = "";
	public String PhoneDisplayName = "";
	public String PhoneFamilyName = "";
	public int PhoneContactRowId = 0;

	public String Hash = "";

	public String toStringForHash() {
		return "" + PhoneNumber + PhoneNormalizedNumber + PhoneDisplayName + PhoneFamilyName + PhoneContactRowId;
	}

	public void calculateHash() {
		Hash = FNV.fnv1a_32(toStringForHash().getBytes()).toString();
	}

	private void toContactsCopy(ContactsCopy copy) {
//            ContactsCopy copy = new ContactsCopy();
		copy.PhoneNumber = this.PhoneNumber;
		copy.PhoneContactRowId = this.PhoneContactRowId;
		copy.PhoneFamilyName = this.PhoneFamilyName;
		copy.PhoneNormalizedNumber = this.PhoneNormalizedNumber != null ? this.PhoneNormalizedNumber : "";
		copy.PhoneDisplayName = this.PhoneDisplayName;
		copy.Hash = this.Hash;
	}

	@Deprecated
	public ContactsCopy toNewContactsCopy() {
		ContactsCopy copy= new ContactsCopy();
		toContactsCopy(copy);
		return copy;
	}

	private void toRealmContactsCopy(RealmContactsCopy copy) {
//            ContactsCopy copy = new ContactsCopy();
		copy.PhoneNumber = this.PhoneNumber;
		copy.PhoneContactRowId = this.PhoneContactRowId;
		copy.PhoneFamilyName = this.PhoneFamilyName;
		copy.PhoneNormalizedNumber = this.PhoneNormalizedNumber != null ? this.PhoneNormalizedNumber : "";
		copy.PhoneDisplayName = this.PhoneDisplayName;
		copy.Hash = this.Hash;
	}
	public RealmContactsCopy toNewRealmContactsCopy() {
		RealmContactsCopy copy= new RealmContactsCopy();
		toRealmContactsCopy(copy);
		return copy;
	}
}
