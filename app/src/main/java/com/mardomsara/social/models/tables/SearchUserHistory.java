package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.json.social.rows.UserSyncJson;

/**
 * Created by Hamid on 11/24/2016.
 */

@Table
public class SearchUserHistory {

	@PrimaryKey(auto = false, onConflict = OnConflict.REPLACE)
	public int UserId = 0;

	@Column(indexed = true, defaultExpr = "1")
	public int ReachedType = 1;

	@Column(defaultExpr = "")
	public String Data = "";

	@Column(indexed = true, defaultExpr = "0")
	public long CreatedAt = 0;

	////////////////

	public void save(){
		DB.db.insertIntoSearchUserHistory(this);
	}

	UserSyncJson userSyncJson;

	public UserSyncJson getUserSyncJson(){
		if(userSyncJson != null){
			return userSyncJson;
		}

		if(Data != null && !Data.equals("")){
			userSyncJson = JsonUtil.fromJson(Data,UserSyncJson.class);
		}

		return userSyncJson;
	}

}
