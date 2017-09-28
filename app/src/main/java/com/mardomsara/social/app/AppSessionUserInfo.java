package com.mardomsara.social.app;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.lib.TinyDB;

/**
 * Created by Hamid on 9/26/2017.
 */

public class AppSessionUserInfo {

	private TinyDB getDefStore(){
		return new TinyDB(AppUtil.getContext(),"store_0");
	}



}
