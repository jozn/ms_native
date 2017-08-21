package com.mardomsara.social.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Hamid on 8/21/2017.
 */

public class RealmUserView extends RealmObject {
	@PrimaryKey
	public int UserId;
	public String UserName;
	public String FirstName;
	public String LastName;
	public String About;
	public String FullName;
	public String AvatarUrl;
	public int PrivacyProfile;
	public String Phone;
	public int UpdatedTime;
	public int AppVersion;
	public int FollowingType;
}
