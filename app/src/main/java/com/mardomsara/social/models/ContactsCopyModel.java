package com.mardomsara.social.models;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.models.tables.ContactsCopy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 10/3/2016.
 */
public class ContactsCopyModel {

	static Map<String,ContactsCopy> cacheMap = null;
	public static Map<String,ContactsCopy> getCacheOfContactsCopy(){
		if(cacheMap == null){
			cacheMap = new HashMap<>();
			List<ContactsCopy> list = DB.db.selectFromContactsCopy().toList();
			for (ContactsCopy row: list){
				if(row.PhoneNormalizedNumber != ""){
					cacheMap.put(row.PhoneNormalizedNumber, row);
				}
			}
		}
		return cacheMap;
	}
}
