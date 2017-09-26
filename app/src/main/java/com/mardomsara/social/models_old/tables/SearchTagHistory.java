package com.mardomsara.social.models_old.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.LangUtil;

import java.util.List;

/**
 * Created by Hamid on 11/24/2016.
 */

@Table
public class SearchTagHistory {

	@PrimaryKey(auto = false, onConflict = OnConflict.REPLACE)
	public String Name = "";

	@Column(indexed = true, defaultExpr = "2")
	public int ReachedType = 2;

	@Column(defaultExpr = "0")
	public int Count = 0;

	@Column(indexed = true, defaultExpr = "0")
	public long CreatedAt = 0;

	////////// Methods (No sqlite) //////
	public final static int REACHED_SEARCH = 1;
	public final static int REACHED_CLICK = 2;
	final static int LIMIT = 50;

	public void save(){
		DB.getAppDB().insertIntoSearchTagHistory(this);
		if(LangUtil.getRandom(10) == 5){
			AndroidUtil.runInBackgroundNoPanic(()->{runGc();});
		}
	}

	private static void runGc(){
		List<SearchTagHistory> rows = DB.getAppDB().selectFromSearchTagHistory().orderByCreatedAtDesc().toList();
		if(rows.size()>LIMIT){
			int delCnt = rows.size() - LIMIT;
			DB.getAppDB().transactionSync(()->{
				for (int i=1 ;i <= delCnt; i++){
					DB.getAppDB().deleteFromSearchTagHistory().NameEq(rows.get(rows.size()-i).Name).execute();
				}
			});
		}
	}

}
