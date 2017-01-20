package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.social.rows.NotifyPayloadJson;

/**
 * Created by Hamid on 9/1/2016.
 */

@Table
public class Notify {

    @PrimaryKey(auto = false,onConflict = OnConflict.IGNORE )
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
    public int TargetId;

    @Column(indexed = false)
    public int SeenStatus;

    @Column(indexed = true)
    public int CreatedTime;

    @Column(defaultExpr = "''")
    public String PayloadStored = "";

    /// No Sqlite ///
    public NotifyPayloadJson Load;

    public void setPayloadStored(){
        PayloadStored = AppUtil.toJson(Load);
    }

    public void setloadFromStored(){
        Load = AppUtil.fromJson(PayloadStored,NotifyPayloadJson.class);
    }

	////////// Instance methods ///////

	public void save(){
		if(PayloadStored == null || PayloadStored.length() ==0){
			setPayloadStored();
		}
		DB.db.insertIntoNotify(this);
	}

}
