package com.mardomsara.social.tables;


//@TableModelSpec(className = "GroupMembersTable",tableName = "group_members")
public class GroupMembersTable {
    public String RoomKey;

//    @ColumnSpec(defaultValue = "0")
    public int UserId;

//    @ColumnSpec(defaultValue = "0")
    public int ByUserId;

//    @ColumnSpec(defaultValue = "0")
    public int RoleId;//1 blocked??, 2: invited  , 5: normall-member 6:admin

//    @ColumnSpec(defaultValue = "0")
    public int IsAdmin;//1 blocked??, 2: invited  , 5: normall-member 6:admin

//    @ColumnSpec(defaultValue = "0")
    public int CreatedTimestamp;
}
