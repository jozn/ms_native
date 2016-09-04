package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

/**
 * Created by Hamid on 9/4/2016.
 */
@Table
public class User {
    @PrimaryKey(auto = false)
    public int UserId;

    @Column(defaultExpr = "0")
    public int PhoneContactRowId = 0;

    @Column(defaultExpr = "0")
    public int IsPhoneContact = 0;

    @Column(defaultExpr = "''")
    public String PhoneNumber = "";//0935... +98910711..

    @Column(defaultExpr = "''" )
    public String PhoneNormalizedNumber = "";

    @Column(defaultExpr = "''")
    public String PhoneDisplayName = "";

    @Column(defaultExpr = "''")
    public String PhoneFamilyName = "";

    @Column(defaultExpr = "0")
    public int IsFollowing = 0;

    @Column(defaultExpr = "''")
    public String AvatarUrl = "";

    @Column(defaultExpr = "''")
    public String StatusText = "";

    @Column(defaultExpr = "0")
    public int StatusId = 0;

    @Column(defaultExpr = "0")
    public int UpdateTimestamp = 0;

    @Column(defaultExpr = "0")
    public int UnseenMessageCount = 0;//??

    //for followings
    @Column(defaultExpr = "''")
    public String UserName = "";

    @Column(defaultExpr = "''")
    public String FirstName = "";

    @Column(defaultExpr = "''")
    public String LastName = "";

    @Column(defaultExpr = "''")
    public String FullName = "";

    @Column(defaultExpr = "0")
    public int IsProfilePrivate = 0;

    @Column(defaultExpr = "0")
    public int FollowingType = 0;

    @Column(defaultExpr = "0")
    public int UpdatedTimestamp = 0;
}
