package com.mardomsara.social.models_old.tables;

import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.JV;

/**
 * Created by Hamid on 9/1/2016.
 */

@Table
public class Notify {

    @PrimaryKey(auto = false,onConflict = OnConflict.REPLACE )
    public long Id;

    @Column(indexed = true)
    public int ForUserId;

    @Column(indexed = true)
    public int ActorUserId;

    @Column(indexed = true)
    public int ActionTypeId;

    @Column(indexed = true)
    public int ObjectTypeId;

    @Column(indexed = true)
    public int RowId;

	@Column(indexed = true)
	public int RootId;

    @Column(indexed = false)
    public int SeenStatus;

    @Column(indexed = true)
    public int CreatedTime;

	@Nullable
    @Column(defaultExpr = "''")
    public String PayloadStored = "";

    /// No Sqlite ///
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
		DB.getAppDB().insertIntoNotify(this);
	}

}
