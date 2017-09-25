package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;

/**
 * Created by Hamid on 9/4/2016.
 */
@Deprecated
@Table
public class ContactsCopy {

    @PrimaryKey(auto = false)
//	@Column(defaultExpr = "0")
	public int PhoneContactRowId;

    @Column(defaultExpr = "''")
    public String PhoneNumber = "";//0935... +98910711..

    @Column(defaultExpr = "''", indexed = true)
//	@PrimaryKey
    public String PhoneNormalizedNumber = "";

    @Column(defaultExpr = "''")
    public String PhoneDisplayName = "";

    @Column(defaultExpr = "''")
    public String PhoneFamilyName = "";

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public int IsSynced = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public int IsRemoved = 0;

    @Column(defaultExpr = "''" ,indexed = true)
    public String Hash = "";

    /*public void calculateHash(){
        Hash = FNV.fnv1a_32(toStringForHash().getBytes()).toString();
    }*/

    public void insert(){
        DB.getAppDB().relationOfContactsCopy().upserter().execute(this);
    }

}
