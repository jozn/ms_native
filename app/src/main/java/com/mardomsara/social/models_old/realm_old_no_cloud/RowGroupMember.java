package com.mardomsara.social.models_old.realm_old_no_cloud;

import io.realm.RealmObject;

/**
 * Created by Hamid on 7/9/2017.
 */

public class RowGroupMember extends RealmObject {
	public int UserId = 0;
	public int RoleId = 0; //enum
	public int AddedByUserId = 0;
	public int CreatedTime = 0;
}
