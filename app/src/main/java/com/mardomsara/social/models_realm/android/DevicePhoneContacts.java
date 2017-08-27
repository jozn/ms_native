package com.mardomsara.social.models_realm.android;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.mardomsara.social.App;
import com.mardomsara.social.helpers.AppUtil;

import java.util.ArrayList;
import java.util.List;

import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

/**
 * Created by Hamid on 10/2/2016.
 */
public class DevicePhoneContacts {
	public static void fetchAllWithAskPermisions(ContactsFetcherCallback callback) {
		PermissionCallback callbackPer = new PermissionCallback(){
			@Override
			public void permissionGranted() {
				AppUtil.log("permissionGranted() callback");
				callback.onFetched(doActualFetch());
			}

			@Override
			public void permissionRefused() {
				AppUtil.log("permissionRefused() callback");
			}
		};

		if(App.getActivity() == null) return;
		Nammu.askForPermission(App.getActivity(), Manifest.permission.READ_CONTACTS,callbackPer);

	}

	private static List<PhoneContact> doActualFetch(){
		//        StringBuffer sb = new StringBuffer();
		Context ctx = App.context;
		List<PhoneContact> al = new ArrayList<>();
		Cursor managedCursor = ctx.getContentResolver()
			.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
				new String[]{ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID,
					ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY,
					ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
					ContactsContract.CommonDataKinds.Phone.NUMBER,
					ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER
				},
				null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY + " ASC");

		while (managedCursor.moveToNext()){
			String id =  managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID));
			PhoneContact pc = new PhoneContact();
			pc.PhoneDisplayName = managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY));
			pc.PhoneFamilyName = managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
			pc.PhoneNumber =managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
			pc.PhoneNormalizedNumber= managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER));
			pc.PhoneContactRowId = Integer.decode(id);
			al.add(pc);
		}
		managedCursor.close();
		return al;
	}

	/**
	 * Created by Hamid on 7/2/2016.
	 */

	public interface ContactsFetcherCallback{
		public void onFetched(List<PhoneContact> contacts);
	}

}

