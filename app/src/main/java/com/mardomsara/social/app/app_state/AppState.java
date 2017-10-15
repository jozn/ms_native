package com.mardomsara.social.app.app_state;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mardomsara.social.app.AppLogger;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.helpers.AppUtil;

import ir.ms.pb.PB_Session;
import ir.ms.pb.PB_SettingClient;
import ir.ms.pb.PB_SettingNotification;

/**
 * Created by Hamid on 10/14/2017.
 */

public class AppState {

	public static UserStates getDefault() {

		return new UserStates(0);
	}

	public static class UserStates {
		private final static String KEY_CLIENT_SETTINGS = "KEY_CLIENT_SETTINGS";
		private final static String KEY_NOTIFICATIONS = "KEY_NOTIFICATIONS";
		private final static String KEY_SESSION = "KEY_SESSION";

		private final static String FILE_SESSION = "session";
		private final static String FILE_SETTINGS = "settings";

		int userId = 0;

		private PB_SettingClient pb_settingClient;
		private PB_SettingClient.Builder pb_settingClientBuilder;

		private PB_SettingNotification pb_settingNotification;
		private PB_SettingNotification.Builder pb_settingNotificationBuilder;

		private PB_Session pb_session;

		UserStates(int userId) {
			this.userId = userId;
		}

		////////////////////////////////////////// SettingClient ////////////////////////////////////
		public PB_SettingClient getSetting() {
			if (pb_settingClient == null) {
				String base64 = getSharedPrefrence(FILE_SETTINGS).getString(KEY_CLIENT_SETTINGS, "");
				if (base64.equals("")) {//in first time - or when user deletes all data
					pb_settingClient = PB_SettingClient.newBuilder().build();
					saveSettingClient();
				} else {
					try {
						pb_settingClient = PB_SettingClient.parseFrom(Base64.decode(base64, Base64.DEFAULT));
					} catch (InvalidProtocolBufferException e) {
						e.printStackTrace();
						AppLogger.getExecptionsLogger().e(e);
					}
				}
			}
			return pb_settingClient;
		}

		public PB_SettingClient.Builder getSettingClientEditor() {
			if (pb_settingClientBuilder == null) {
				pb_settingClientBuilder = PB_SettingClient.newBuilder();
			}
			return pb_settingClientBuilder;
		}

		public synchronized void saveSettingClient() {
			if (pb_settingClientBuilder != null) {
				pb_settingClient = pb_settingClientBuilder.build();
			}
			getSharedPrefrence(FILE_SETTINGS).edit().putString(KEY_CLIENT_SETTINGS, Base64.encodeToString(pb_settingClient.toByteArray(), Base64.DEFAULT)).apply();
		}

		/////////////////////////////////////////// Push Notifications /////////////////////////////////
		public PB_SettingNotification getNotificationSetting() {
			if (pb_settingNotification == null) {
				String base64 = getSharedPrefrence(FILE_SETTINGS).getString(KEY_NOTIFICATIONS, "");
				if (base64.equals("")) {//in first time - or when user deletes all data
					pb_settingNotification = PB_SettingNotification.newBuilder().build();
					saveNotificationsSetting();
				} else {
					try {
						pb_settingNotification = PB_SettingNotification.parseFrom(Base64.decode(base64, Base64.DEFAULT));
					} catch (InvalidProtocolBufferException e) {
						e.printStackTrace();
						AppLogger.getExecptionsLogger().e(e);
					}
				}
			}
			return pb_settingNotification;
		}

		public PB_SettingNotification.Builder getSettingNotificationsEditor() {
			if (pb_settingNotificationBuilder == null) {
				pb_settingNotificationBuilder = PB_SettingNotification.newBuilder();
			}
			return pb_settingNotificationBuilder;
		}

		public synchronized void saveNotificationsSetting() {
			if (pb_settingNotificationBuilder != null) {
				pb_settingNotification = pb_settingNotificationBuilder.build();
			}
			getSharedPrefrence(FILE_SETTINGS).edit().putString(KEY_NOTIFICATIONS, Base64.encodeToString(pb_settingNotification.toByteArray(), Base64.DEFAULT)).apply();
		}

		/////////////////////////////////////////// Session /////////////////////////////////
		public PB_Session getSession() {
			if (pb_session == null) {
				String base64 = getSharedPrefrence(FILE_SESSION).getString(KEY_SESSION, "");
				if (base64.equals("")) {//in first time - or when user deletes all data
					//todo if we dont have the session open login activity to force use loggin
					if (Config.IS_DEBUG) {
						pb_session = PB_Session.newBuilder().setSessionUuid("14dsad").setUserId(6).build();
						saveSession(pb_session);
					}
				} else {
					try {
						pb_session = PB_Session.parseFrom(Base64.decode(base64, Base64.DEFAULT));
					} catch (InvalidProtocolBufferException e) {
						e.printStackTrace();
						AppLogger.getExecptionsLogger().e(e);
					}
				}
			}
			return pb_session;
		}


		public synchronized void saveSession(PB_Session pb_session1) {
			pb_session = pb_session1;
			getSharedPrefrence(FILE_SESSION).edit().putString(KEY_SESSION, Base64.encodeToString(pb_session1.toByteArray(), Base64.DEFAULT)).apply();
		}

		public synchronized void saveState() {

		}

		///////////////////////////////// privates ///////////////////////

		private SharedPreferences getSharedPrefrence(String fileName) {
			return AppUtil.getContext().getSharedPreferences(getPerifxOFile() + fileName, Context.MODE_PRIVATE);
		}

		private String getPerifxOFile() {
			if (userId == 0) {
				return "def_";
			}
			return "u" + userId + "_";
		}
	}

}
