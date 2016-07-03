package com.mardomsara.social.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 4/29/2016.
 */
public class SqlBase {

    public static List<?> loadAll(Class cls){
        /*try {
            cls.getClass();
            SqlTable table = (SqlTable) cls.getField("TABLE").get(new Object());
            Query query1 = Query.select().from(table);
            SquidCursor<UsersTable> rooms = DBSingletons.getAppDataBase().query(UsersTable.class, query1);
            List<UsersTable> list = new ArrayList();

            try {
                for (rooms.moveToFirst(); !rooms.isAfterLast(); rooms.moveToNext()) {
                    UsersTable p = new UsersTable();
                    p.readPropertiesFromCursor(rooms);
//                Log.i("DB", p.getRoomName());
                    list.add(p);
                }
            } finally {
                rooms.close();
            }
            Log.d("DB: Rooms::getAllRooms ",query1.toRawSql(VersionCode.V3_7_11));
            return list;
        }catch (Exception e){

        }*/
        return new ArrayList<>();
    }


}
