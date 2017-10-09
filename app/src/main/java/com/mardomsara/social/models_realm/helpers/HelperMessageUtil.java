package com.mardomsara.social.models_realm.helpers;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.models_old.tables.Session;

/**
 * Created by Hamid on 10/9/2017.
 */

public class HelperMessageUtil {
	public static String getNewMessageKey() {
		return "" + Session.getUserId() + "_" + AppUtil.getTimeMs() + "_" + LangUtil.getRandomString(4);
	}
}
