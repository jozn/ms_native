package com.mardomsara.social.models.realm_old_no_cloud;

import io.realm.RealmObject;

/**
 * Created by Hamid on 7/9/2017.
 */

public class RowNotifications extends RealmObject {
	public int Vibrate;
	public String SoundPath;
	public int IdRadioButtonSound; //enum
	public int NotificationType;
	public int Seconds;
	public int Reapet;
	public int LedColor;
}
