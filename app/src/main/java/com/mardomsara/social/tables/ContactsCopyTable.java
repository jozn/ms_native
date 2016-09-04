package com.mardomsara.social.tables;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;
@Deprecated
@Table(allFields = true ,name = "contacts_copy",database = AppDB.class)
public class ContactsCopyTable extends BaseModel {

    @Column(defaultValue = "0")
    @PrimaryKey
    public int PhoneContactRowId;

    @Column(defaultValue = "\"\"")
    public String PhoneNumber;//0935... +98910711..

    @Column(defaultValue = "\"\"" )
    public String PhoneNormalizedNumber;

    @Column(defaultValue = "\"\"")
    public String PhoneDisplayName;

    @Column(defaultValue = "\"\"")
    public String PhoneFamilyName;

    @Column(defaultValue = "\"\"")
    public String Hash;



    public static List<ContactsCopyTable> loadAll(){
        return SQLite.select().from(ContactsCopyTable.class).queryList();
    }

    public static void empty(){
        SQLite.delete().from(ContactsCopyTable.class).execute();
    }


}
