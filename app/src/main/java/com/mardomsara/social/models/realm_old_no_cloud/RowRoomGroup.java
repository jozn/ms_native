package com.mardomsara.social.models.realm_old_no_cloud;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Hamid on 7/9/2017.
 */

public class RowRoomGroup extends RealmObject {

	public int GroupId = 0;
	public String GroupName = "";
	public int MyRole = 0;//enum
	public int MembersCount = 0;
	public int MembersLimit = 0;
	public String InivteLink = "";
	public String UserName = "";

	RealmList<RowGroupMember> Members;

}
