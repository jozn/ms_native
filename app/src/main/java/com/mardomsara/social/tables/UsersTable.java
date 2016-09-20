package com.mardomsara.social.tables;

import com.mardomsara.social.helpers.AppUtil;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

//@TableModelSpec(className = "UsersTable",tableName = "contacts")
@Table(allFields = true ,name = "user",database = AppDB.class)
@Deprecated
public class UsersTable extends BaseModel {
//    @ColumnSpec(constraints = "NOT NULL UNIQUE")
//    @PrimaryKey(autoincrement = false)
    @Column
    @PrimaryKey
    public int UserId;

    @Column(defaultValue = "0")
    public int PhoneContactRowId;

    @Column(defaultValue = "0")
    public int IsPhoneContact;

    @Column(defaultValue = "\"\"")
    public String PhoneNumber;//0935... +98910711..

    @Column(defaultValue = "\"\"" )
    public String PhoneNormalizedNumber;

    @Column(defaultValue = "\"\"")
    public String PhoneDisplayName;

    @Column(defaultValue = "\"\"")
    public String PhoneFamilyName;

    @Column(defaultValue = "0")
    public int IsFollowing;

    @Column(defaultValue = "\"\"")
    public String AvatarUrl;

    @Column(defaultValue = "\"\"")
    public String StatusText;

    @Column(defaultValue = "0")
    public int StatusId;

    @Column(defaultValue = "0")
    public int UpdateTimestamp;

    @Column(defaultValue = "0")
    public int UnseenMessageCount;//??

    //for followings
    @Column(defaultValue = "\"\"")
    public String UserName;

    @Column(defaultValue = "\"\"")
    public String FirstName;

    @Column(defaultValue = "\"\"")
    public String LastName;

    @Column(defaultValue = "\"\"")
    public String FullName;

    @Column(defaultValue = "0")
    public int IsProfilePrivate;

    @Column(defaultValue = "0")
    public int FollowingType;

    @Column(defaultValue = "0")

    public int UpdatedTimestamp;

    ////////////////// No Sqlite /////////////////

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }


    ///////////////////// Static//////////////////

    public static UsersTable getByUserId(int id){
        return SQLite.select().from(UsersTable.class)
                .where(UsersTable_Table.UserId.eq(id)).querySingle();
    }

    /*public static void onRecivedNewMsg(MessagesTable msg) {
        UsersTable user = getByUserId( msg.getUserId() );
        if(user == null){
            Command cmd = new Command();
            cmd.Name = "GetUserForTable";
            cmd.Data = ""+ msg.getUserId();
            WS.sendCommand(cmd);
        }
    }*/

    public static List<UsersTable> getAllFollowings() {
        return SQLite.select().from(UsersTable.class).where(UsersTable_Table.FollowingType.eq(1)).queryList();
    }

    public static List<UsersTable> getAllRegisteredContacts() {
        String q = SQLite.select().from(UsersTable.class).
                where(UsersTable_Table.IsPhoneContact.eq(1)).toString();
        AppUtil.log("Queru getAllFollowings" + q);

        return SQLite.select().from(UsersTable.class).
                where(UsersTable_Table.IsPhoneContact.eq(1)).queryList();
    }

        ////////////////////////////////////////////

/////////////////////////////////////////////
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getPhoneContactRowId() {
        return PhoneContactRowId;
    }

    public void setPhoneContactRowId(int phoneContactRowId) {
        PhoneContactRowId = phoneContactRowId;
    }

    public int getIsPhoneContact() {
        return IsPhoneContact;
    }

    public void setIsPhoneContact(int isPhoneContact) {
        IsPhoneContact = isPhoneContact;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNormalizedNumber() {
        return PhoneNormalizedNumber;
    }

    public void setPhoneNormalizedNumber(String phoneNormalizedNumber) {
        PhoneNormalizedNumber = phoneNormalizedNumber;
    }

    public String getPhoneDisplayName() {
        return PhoneDisplayName;
    }

    public void setPhoneDisplayName(String phoneDisplayName) {
        PhoneDisplayName = phoneDisplayName;
    }

    public String getPhoneFamilyName() {
        return PhoneFamilyName;
    }

    public void setPhoneFamilyName(String phoneFamilyName) {
        PhoneFamilyName = phoneFamilyName;
    }

    public int getIsFollowing() {
        return IsFollowing;
    }

    public void setIsFollowing(int isFollowing) {
        IsFollowing = isFollowing;
    }

    public String getAvatarUrl() {
        return AvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        AvatarUrl = avatarUrl;
    }

    public String getStatusText() {
        return StatusText;
    }

    public void setStatusText(String statusText) {
        StatusText = statusText;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
    }

    public int getUpdateTimestamp() {
        return UpdateTimestamp;
    }

    public void setUpdateTimestamp(int updateTimestamp) {
        UpdateTimestamp = updateTimestamp;
    }

    public int getUnseenMessageCount() {
        return UnseenMessageCount;
    }

    public void setUnseenMessageCount(int unseenMessageCount) {
        UnseenMessageCount = unseenMessageCount;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }


    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getIsProfilePrivate() {
        return IsProfilePrivate;
    }

    public void setIsProfilePrivate(int isProfilePrivate) {
        IsProfilePrivate = isProfilePrivate;
    }


    public int getUpdatedTimestamp() {
        return UpdatedTimestamp;
    }

    public void setUpdatedTimestamp(int updatedTimestamp) {
        UpdatedTimestamp = updatedTimestamp;
    }

    public int getFollowingType() {
        return FollowingType;
    }

    public void setFollowingType(int followingType) {
        FollowingType = followingType;
    }




//    @ColumnSpec(defaultValue = "0")
//    public int ____________DDDDDDDe;

}
