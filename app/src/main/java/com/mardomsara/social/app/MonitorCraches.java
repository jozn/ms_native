package com.mardomsara.social.app;

/**
 * Created by Hamid on 6/16/2017.
 */

public class MonitorCraches {
	public static void log(Exception e){
		if(e != null){
			e.printStackTrace();
		}
	}
}
