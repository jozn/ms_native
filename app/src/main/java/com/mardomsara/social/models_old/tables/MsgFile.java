package com.mardomsara.social.models_old.tables;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.models_old.CacheBank;

/**
 * Created by Hamid on 9/4/2016.
 */
@Table
public class MsgFile {

	@NonNull
	@PrimaryKey(auto = false)
	public String LocalSrc = "";

    @NonNull
	@Column(defaultExpr = "''" , indexed = true)
    public String Hash = "";

	@Column(defaultExpr = "''" , indexed = true)
	public String ServerSrc = "";

	@Column(defaultExpr = "0")
	public int FileType = 0;

	@Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITION_EQ)
	public int Status=0;

	@Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITION_EQ)
	public int Origin =0; // 1:here 2:downloaded from net

	@Column(defaultExpr = "''")
	public String Name = "";

	@Column(defaultExpr = "0")
	public long Size = 0;

	@Column(defaultExpr = "0")
	public int Duration = 0;

	@Column(defaultExpr = "0")
	public int Height = 0;

	@Column(defaultExpr = "0")
	public int Width = 0;

	@Column(defaultExpr = "''")
	public String Extension = "";//with dot

	//Thumb

	@Column(defaultExpr = "0")
	public int ThumbSize = 0;

	@Column(defaultExpr = "0")
	public int ThumbHeight = 0;

	@Column(defaultExpr = "0")
	public int ThumbWidth = 0;

	@Column(defaultExpr = "''")
	public String Thumb64 = "";

	@Column
	@Nullable
	public byte[] ThumbData = null;

	@Column(defaultExpr = "''" )
	public String ThumbLocalSrc = "";

    @Column(defaultExpr = "0" , helpers = Column.Helpers.ALL)
    public long CreatedMs = 0;

    /////////////////////////////////////////////////////////
    ////////////////// Helpers ///////////////////

	@Deprecated //use Message methods
	public boolean isNetWorkTransferring = false;

	public boolean isNetWorkTransferring() {
		return isNetWorkTransferring;
	}

	public void setNetWorkTransferring(boolean netWorkTransferring) {
		isNetWorkTransferring = netWorkTransferring;
	}


    public void saveAndEmit() {
//		MemoryStore_Rooms.setAndEmit(this);
//        DB.db.prepareInsertIntoRoom(OnConflict.REPLACE,false).execute(this);
    }

	public void save() {
		if(LocalSrc.equals("")) return;//avoid bugs
		//todo calculate hash
		CacheBank.getMsgFile().put(LocalSrc,this);
		DB.getAppDB().prepareInsertIntoMsgFile(OnConflict.REPLACE,false).execute(this);
	}

}
