package com.mardomsara.social.models.tables;

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

	@Column(indexed = true, defaultExpr = "1")
	public int ReachedType = 1;

	@Column(defaultExpr = "0")
	public int Count = 0;

	@Column(indexed = true, defaultExpr = "0")
	public long CreatedAt = 0;

	////////// Methods (No sqlite) //////

	final static int LIMIT = 50;

	public void save(){
		DB.db.insertIntoSearchTagHistory(this);
		if(LangUtil.getRandom(10) == 5){
			AndroidUtil.runInBackgroundNoPanic(()->{runGc();});
		}
	}

	private static void runGc(){
		List<SearchTagHistory> rows = DB.db.selectFromSearchTagHistory().orderByCreatedAtDesc().toList();
		if(rows.size()>LIMIT){
			int delCnt = rows.size() - LIMIT;
			DB.db.transactionSync(()->{
				for (int i=1 ;i <= delCnt; i++){
					DB.db.deleteFromSearchTagHistory().NameEq(rows.get(rows.size()-i).Name).execute();
				}
			});
		}
	}

}
