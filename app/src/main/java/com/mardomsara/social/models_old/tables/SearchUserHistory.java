package com.mardomsara.social.models_old.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.social.rows.UserSyncJson;

import java.util.List;

/**
 * Created by Hamid on 11/24/2016.
 */

@Table
public class SearchUserHistory {

	@PrimaryKey(auto = false, onConflict = OnConflict.REPLACE)
	public int UserId = 0;

	@Column(indexed = true, defaultExpr = "2")
	public int ReachedType = 2;

	@Column(defaultExpr = "")
	public String Data = "";

	@Column(indexed = true, defaultExpr = "0")
	public long CreatedAt = 0;

	////////// Methods (No sqlite) //////
	public final static int REACHED_SEARCH = 1;
	public final static int REACHED_CLICK = 2;
	final static int LIMIT = 50;

	public void save(){
		DB.getAppDB().insertIntoSearchUserHistory(this);
		if(LangUtil.getRandom(10) == 5){
			AndroidUtil.runInBackgroundNoPanic(()->{runGc();});
		}
	}

	private static void runGc(){
		List<SearchUserHistory> rows = DB.getAppDB().selectFromSearchUserHistory().orderByCreatedAtDesc().toList();
		if(rows.size()>LIMIT){
			int delCnt = rows.size() - LIMIT;
			DB.getAppDB().transactionSync(()->{
				for (int i=1 ;i <= delCnt; i++){
					DB.getAppDB().deleteFromSearchUserHistory().UserIdEq(rows.get(rows.size()-i).UserId).execute();
				}
			});
		}
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
