package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.FNV;

/**
 * Created by Hamid on 9/4/2016.
 */
@Table
public class ContactsCopy {

    @PrimaryKey(auto = false)
    public int PhoneContactRowId;

    @Column(defaultExpr = "''")
    public String PhoneNumber = "";//0935... +98910711..

    @Column(defaultExpr = "''" )
    public String PhoneNormalizedNumber = "";

    @Column(defaultExpr = "''")
    public String PhoneDisplayName = "";

    @Column(defaultExpr = "''")
    public String PhoneFamilyName = "";

    @Column(defaultExpr = "''")
    public String Hash = "";

    /*public void calculateHash(){
        Hash = FNV.fnv1a_32(toStringForHash().getBytes()).toString();
    }*/

    public void insert(){
        DB.db.relationOfContactsCopy().upserter().execute(this);
    }

}
