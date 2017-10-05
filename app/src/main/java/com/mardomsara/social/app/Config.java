package com.mardomsara.social.app;

import com.mardomsara.social.BuildConfig;

/**
 * Created by Hamid on 5/9/2016.
 */
public class Config {
    public static boolean IS_DEBUG =true;
    public static boolean IS_DEBUG2 = BuildConfig.DEBUG;

	public static int OFFLINE_RPC_FLUSH_TIMEOUT_MS = 7 * 24 * 36000 * 100;

    public static int KEYBOARD_HEIGHT_DEFAULT = 700;
    public static String KEYBOARD_HEIGHT = "KEYBOARD_HEIGHT";


    public static String SYNC_DIFF_FOLLOWINGS_LAST_TIMESTAMP = "SYNC_DIFF_FOLLOWINGS_LAST_TIMESTAMP";


    public static String SYNC_CONTACTS_REFETCHED_FROM_DEVICE_LAST_TIME = "SYNC_CONTACTS_REFETCHED_FROM_DEVICE_LAST_TIME";
    public static String SYNC_CONTACTS_TO_PUSH_SERVER= "SYNC_CONTACTS_TO_PUSH_SERVER";


	public static String WEBSOCKET_SERVER_ADDRESS = "";
	public static Integer WEBSOCKET_SERVER_PORT = 10000;


}
