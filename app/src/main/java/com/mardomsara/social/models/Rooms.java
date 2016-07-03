package com.mardomsara.social.models;

import com.mardomsara.social.tables.RoomsListTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 2/18/2016.
 */
public class Rooms {
    public static List<RoomsListTable> getAllRooms(){
       /* Query query1 = Query.select().from(RoomListsTable.TABLE);
        SquidCursor<RoomListsTable> rooms = DBSingletons.getAppDataBase().query(RoomListsTable.class, query1);
        List<RoomListsTable> list = new ArrayList();

        try {
            for (rooms.moveToFirst(); !rooms.isAfterLast(); rooms.moveToNext()) {
                RoomListsTable p = new RoomListsTable();
                p.readPropertiesFromCursor(rooms);
                Log.i("DB", p.getRoomName());
                list.add(p);
            }
        } finally {
            rooms.close();
        }
        Log.d("DB: Rooms::getAllRooms ",query1.toRawSql(VersionCode.V3_7_11));
        return list;*/
        return new ArrayList<>();
    }
}
