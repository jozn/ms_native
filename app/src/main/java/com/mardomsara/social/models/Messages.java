package com.mardomsara.social.models;

import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.tables.RoomsListTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 2/18/2016.
 */
public class Messages {
    static String LOGTAG = "Messages_Model";
    public static List<MessagesTable> loadMsgs(RoomsListTable room){
        /*Query query1 =
                Query.select()
                        .from(MessagesTable.TABLE)
                        .leftJoin(FilesTable.TABLE, MessagesTable.MESSAGE_KEY.eq(FilesTable.MESSAGE_KEY))
                        .leftJoin(ImageBinary.TABLE, MessagesTable.MESSAGE_KEY.eq(ImageBinary.MESSAGE_KEY))
                        .where(MessagesTable.ROOM_KEY.eq(room.getRoomKey()))
                        .orderBy(MessagesTable.CREATED_TIMESTAMP_MS.desc())
                        .limit(400);

        SquidCursor<MessagesTable> rooms = DBSingletons.getAppDataBase().query(MessagesTable.class, query1);
        List<MessagesTable> list = new ArrayList();

        Log.d(LOGTAG, Helper.stringArrayToString(rooms.getCursor().getColumnNames(), " "));

        try {
            for (rooms.moveToFirst(); !rooms.isAfterLast(); rooms.moveToNext()) {
                MessagesTable p = new MessagesTable();
                p.readPropertiesFromCursor(rooms);
//                Log.i("DB", p.getRoomName());
                list.add(p);
            }
        } finally {
            rooms.close();
        }

        return list;*/
        return new ArrayList<MessagesTable>(){};
    }
//    public static MessagesTable loadMsgs(RoomListsTable room, int lastId){}
}
