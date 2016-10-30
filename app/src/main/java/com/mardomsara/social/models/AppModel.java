package com.mardomsara.social.models;

import com.mardomsara.social.helpers.TimeUtil;

/**
 * Created by Hamid on 10/30/2016.
 */

public class AppModel {
	public static long timeDiffToServer = 0;
	public static void getTimeDiffrenceToServer(){

	}

	public static long getRealGlobalTimestampMs(){
		return TimeUtil.getTimeMs() + timeDiffToServer;
	}
}
