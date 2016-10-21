package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.memory_store.MemoryStore_Users;

/**
 * Created by Hamid on 9/4/2016.
 */
@Table()
public class User {
    @PrimaryKey(auto = false)
    public int UserId;

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITIONS)
    public int IsFollowing = 0;

    @Column(defaultExpr = "''" ,helpers = Column.Helpers.CONDITIONS)
    public String AvatarUrl = "";

    @Column(defaultExpr = "''")
    public String StatusText = "";

    @Column(defaultExpr = "0",helpers = Column.Helpers.CONDITIONS)
    public int StatusId = 0;

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITIONS)
    public int UnseenMessageCount = 0;//??

    //for followings
    @Column(defaultExpr = "''" ,helpers = Column.Helpers.CONDITIONS)
    public String UserName = "";

    @Column(defaultExpr = "''")
    public String FirstName = "";

    @Column(defaultExpr = "''")
    public String LastName = "";

    @Column(defaultExpr = "''")
    public String FullName = "";

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITIONS)
    public int PrivacyProfile = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITIONS)
    public int FollowingType = 0;

	@Column(defaultExpr = "''")
	public String About = "";


    /////////// FOr contacts
    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITIONS)
    public int IsPhoneContact = 0;

    @Column(defaultExpr = "0")
    public int PhoneContactRowId = 0;

    @Column(defaultExpr = "''" ,helpers = Column.Helpers.CONDITIONS)
    public String PhoneNumber = "";//0935... +98910711..

    @Column(defaultExpr = "''",helpers = Column.Helpers.CONDITIONS )
    public String PhoneNormalizedNumber = "";

    @Column(defaultExpr = "''" ,helpers = Column.Helpers.CONDITIONS)
    public String PhoneDisplayName = "";

    @Column(defaultExpr = "''" ,helpers = Column.Helpers.CONDITIONS)
    public String PhoneFamilyName = "";


    //////////////// Others /////////////
    @Column(defaultExpr = "1" ,helpers = Column.Helpers.CONDITIONS)
    public int AppVersion = 1;


    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITIONS)
    public int UpdatedTime = 0;

	//todo what to do whit this ? //server sends Phone
	public String Phone = "";



    ///////////////////////////////////////

    public void save(){
		if(PhoneNormalizedNumber  == null)PhoneNormalizedNumber = "";
		if(!PhoneNormalizedNumber.equals("")){
			IsPhoneContact =1;
		}else {
			IsPhoneContact=0;
		}

		MemoryStore_Users.set(this);
		AppUtil.log("user: " + JsonUtil.toJson(this));
        DB.db.relationOfUser().upserter().execute(this);
    }


    public String getFullName() {
        return FirstName + " " + LastName;
    }

}
//
//    @Deprecated
//    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITION_EQ)
//    public int IsProfilePrivate = 0;

