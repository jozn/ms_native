package com.mardomsara.social.models.realm;

import android.support.annotation.Nullable;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.JV;

import io.realm.annotations.Ignore;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class RowNotify {

	@PrimaryKey
    public long Id;

    @Index
    public int ForUserId;

    public int ActorUserId;

    public int ActionTypeId;

    public int ObjectTypeId;

    public int RowId;

	public int RootId;

    public int SeenStatus;

    public int CreatedTime;

	@Nullable
    public String PayloadStored = "";

    /// No Sqlite ///
	@Ignore
    public JV.NotifPayload Load;

    public void setPayloadStored(){
        PayloadStored = AppUtil.toJson(Load);
    }

    public void setloadFromStored(){
        Load = AppUtil.fromJson(PayloadStored,JV.NotifPayload.class);
    }

	////////// Instance methods ///////

	public void save(){
		if(PayloadStored == null || PayloadStored.length() ==0){
			setPayloadStored();
		}
//		DB.db.insertIntoNotify(this);
	}

}
