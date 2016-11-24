package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.rows.UserSyncJson;

/**
 * Created by Hamid on 11/24/2016.
 */

@Table
public class SearchTagHistory {

	@PrimaryKey(auto = false, onConflict = OnConflict.REPLACE)
	public String Name = "";

	@Column(indexed = true, defaultExpr = "1")
	public int ReachedType = 1;

	@Column(defaultExpr = "0")
	public int Count = 0;

	@Column(indexed = true, defaultExpr = "0")
	public long CreatedAt = 0;

	////////////////

	public void save(){
		DB.db.insertIntoSearchTagHistory(this);
	}

}
