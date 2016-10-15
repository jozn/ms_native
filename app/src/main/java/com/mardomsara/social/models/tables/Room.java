package com.mardomsara.social.models.tables;

import android.support.annotation.NonNull;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.models.UserModel;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by Hamid on 9/4/2016.
 */
@Table
public class Room implements Comparable<Room> {
    
//    @PrimaryKey(autoincrement = true)
//    public int id;
//
//    @Column(indexed = true)
    @PrimaryKey(auto = false)
    @NonNull
    public String RoomKey;

    @Column(defaultExpr = "1")
    public int RoomTypeId = 1;

    @Column(defaultExpr = "''")
    public String RoomName = "";//???????

    @Column(defaultExpr = "0")
    public int UseCustomRoomSettings = 0;

    @Column(defaultExpr = "0" , helpers = Column.Helpers.ALL)
    public long LastRoomOpenedTimeMs = 0;

	@Column(defaultExpr = "0" , helpers = Column.Helpers.ALL)
	public long LastSeenTimeMs = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.ALL)
    public int UnseenMessageCount = 0;

    @Column(defaultExpr = "''", helpers = Column.Helpers.CONDITION_EQ)
    public String LastSeenMessageKey = "";

    @Column(defaultExpr = "''")
    public String MessageDraftText = "";

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.ALL)
    public long UpdatedMs = 0;

    @Column(defaultExpr = "0" , helpers = Column.Helpers.ALL)
    public long CreatedMs = 0;

    @Column(defaultExpr = "0" , indexed = true)
    public long SortTimeMs = 0;

    /////////////////////////////////////////////////////////
    ////////////////// Helpers ///////////////////
    public void save() {
        DB.db.prepareInsertIntoRoom(OnConflict.REPLACE,false).execute(this);
    }


    public User User;

    public int getUserId(){
        //todo addStart support for groups
        if(RoomTypeId == 1 && false ) return 0;
        Integer id = roomKeyToPeerId(RoomKey);//NumberUtils.createInteger(RoomKey.substring(1));
        return id;
    }

    public User loadAndGetUser(){
        if(User == null) {
            User = UserModel.getByUserId(getUserId());
        }
        return User;
    }

    public String getRoomName() {
        if(User != null){
            return User.getFullName();
        }
        return "RoomName";
    }

    public String getRoomAvatarUrl(){
//        loadAndGetUser();//todo remove me
        if(User != null){
            return User.AvatarUrl;
        }
        return "public/avatars/no.jpg";
    }


	//todo move this somewhere
	public static int roomKeyToPeerId(String RoomKey){
		int myId = Session.getUserId();
		String[] users = RoomKey.substring(1).split("_");
		if(users.length != 2) return 0;
		int user1 = LangUtil.stringToInt(users[0],0);
		int user2 = LangUtil.stringToInt(users[1],0);

		if(user1 == myId){
			return user2;
		}

		if(user2 == myId){
			return user1;
		}
		return 0;
	}

	@Override
	public int compareTo(Room room) {
		if(room == null) return 1;

		if(SortTimeMs == room.SortTimeMs) return 0;

		return (SortTimeMs > room.SortTimeMs) ? 1 : -1;
	}
}
