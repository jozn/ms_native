package com.mardomsara.social.models.memory_store;

import android.database.Cursor;
import android.support.annotation.Nullable;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;

import org.greenrobot.essentials.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Hamid on 5/31/2016.
 */
public class MemoryStore_LastMsgs {
    private static Map<String,Message> map = new HashMap<>();

	public static void set(Message msgNew){
		Message msg2 =map.get(msgNew.RoomKey);
		if(msg2 == null){
			map.put(msgNew.RoomKey,msgNew);
			return;
		}

		if(msg2.NanoId < msgNew.NanoId){
			map.put(msgNew.RoomKey,msgNew);
		}
	}

    public static void removeForRoom(String roomKey){
        map.put(roomKey,null);
    }

    private static void setForRoom(String roomkey, Message msg){
		if(roomkey == null || roomkey.equals("") || msg == null) return;
        map.put(roomkey,msg);
    }

    public static void setForRoom(List<Room> rooms){
       List<String> roomKeys = new ArrayList();
       for(Room r : rooms){
           roomKeys.add(r.RoomKey);
       }
		setForRoomKeys(roomKeys);
    }

	public static void setForRoomKeys(List<String> roomKeys){
		if(roomKeys == null || roomKeys.size() ==0)return;
		String ins = StringUtils.join(roomKeys,",");
		Cursor cursor =  DB.db.getConnection().rawQuery("select * from Message where RoomKey in("+ ins + ") GROUP BY RoomKey order by NanoId Desc ");

		List<Message> msgs = new ArrayList<>();
		for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			msgs.add(DB.db.newMessageFromCursor(cursor));
		}

		for (Message msg : msgs){
			set(msg);
		}
	}

    public static @Nullable Message getForRoom(Room room){
		if(room == null)return null;
        return map.get(room.RoomKey);
    }

	public static @Nullable Message getForRoom(String roomKey){
		if(roomKey == null || roomKey.equals(""))return null;
		return map.get(roomKey);
	}

    public static boolean isThisLastMsgOfRoom(String msgKey ,Room room) {
		return msgKey.equals(map.get(room.RoomKey).MessageKey);
	}

}
