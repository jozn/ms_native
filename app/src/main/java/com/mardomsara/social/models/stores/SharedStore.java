package com.mardomsara.social.models.stores;

import android.support.annotation.NonNull;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.lib.TinyDB;

/**
 * Created by Hamid on 2/24/2017.
 */

public class SharedStore {

	static TinyDB tinyDBSettings;
	public static TinyDB getCacheStore(){
		if(tinyDBSettings == null){
			tinyDBSettings = new TinyDB(AppUtil.getContext(), "settings");
		}
		return tinyDBSettings;
	}

	private static SettingsStore settingsStore;
	public static SettingsStore getSetingStore(){
		if(settingsStore == null){
			settingsStore = new SettingsStore();
		}
		return settingsStore;
	}

	///////////////////////////////////////////
	///////////////////////////////////////////
	public static class SettingsStore{
		@NonNull static TinyDB tinyDB;
		private final String WIFI_IMAGE = "Auto_Dl_Wifi_Image";
		private final String WIFI_Video = "Auto_Dl_Wifi_Video";
		private final String WIFI_File = "Auto_Dl_Wifi_File";

		private final String CELLULAR_IMAGE = "Auto_Dl_Cellular_Image";
		private final String CELLUlAR_Video = "Auto_Dl_Cellular_Video";
		private final String CELLUAlR_File = "Auto_Dl_Cellular_File";

		public SettingsStore() {
			if(tinyDB==null){
				tinyDB = new TinyDB(AppUtil.getContext(), "settings");
			}
		}

		///WIFI
		public boolean getAutoDlWifiImage(){
			return tinyDB.getBoolean(WIFI_IMAGE,false);
		}

		public boolean getAutoDlWifiVideo(){
			return tinyDB.getBoolean(WIFI_Video,false);
		}

		public boolean getAutoDlWifiFile(){
			return tinyDB.getBoolean(WIFI_File,false);
		}

		public void setAutoDlWifiImage (boolean val ){
			tinyDB.putBoolean(WIFI_IMAGE,val);
		}

		public void setAutoDlWifiVideo (boolean val ){
			tinyDB.putBoolean(WIFI_Video,val);
		}

		public void setAutoDlWifiFile(boolean val ) {
			tinyDB.putBoolean(WIFI_File,val);
		}

		///// Cellular
		public boolean getAutoDlCellularImage(){
			return tinyDB.getBoolean(CELLULAR_IMAGE,false);
		}

		public boolean getAutoDlCellularVideo(){
			return tinyDB.getBoolean(CELLUlAR_Video,false);
		}

		public boolean getAutoDlCellularFile(){
			return tinyDB.getBoolean(CELLUAlR_File,false);
		}

		public void setAutoDlCellularImage (boolean val ){
			tinyDB.putBoolean(CELLULAR_IMAGE,val);
		}

		public void setAutoDlCellularVideo (boolean val ){
			tinyDB.putBoolean(CELLUlAR_Video,val);
		}

		public void setAutoDlCellularFile(boolean val ) {
			tinyDB.putBoolean(CELLUAlR_File,val);
		}


	}

	private static class Notifications{

	}

	///////////// keep Bit mask ////////////
/*
	static final int WIFI_IMAGE  = 1 ; //2^0
	static final int WIFI_VIDEO  = 2 ; //2^1
	static final int WIFI_MUSIC  = 4 ; //2^2
	static final int WIFI_FILE  = 8 ; //2^3

	public int getWifiMask(){
		return tinyDB.getInt("wifi_mask",0);
	}

	public void setWifiMask(int val){
		tinyDB.putInt("wifi_mask",val);
	}

	public boolean getAutoWifiImage(){
		return (getWifiMask() & WIFI_IMAGE ) != 0;
	}

	public void setAutoWifiImage(boolean val){
		if(val){
			setWifiMask( (getWifiMask() | WIFI_IMAGE ) );
		}else {

		}
		return (getWifiMask() & WIFI_IMAGE ) != 0;
	}
*/

}
