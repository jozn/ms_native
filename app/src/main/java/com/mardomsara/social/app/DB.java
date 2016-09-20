package com.mardomsara.social.app;

import android.content.ContentValues;

import com.github.gfx.android.orma.AccessThreadConstraint;
import com.github.gfx.android.orma.Schema;
import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.AppDB;

import java.lang.reflect.Field;

/**
 * Created by Hamid on 9/1/2016.
 */
public class DB {

    public static AppDB db = null;

    public static void init(){
        if(db != null) return;

        db = AppDB.builder(AppUtil.getContext())
                .readOnMainThread(AccessThreadConstraint.WARNING)
                .writeOnMainThread(AccessThreadConstraint.WARNING)
                .name("ms6")
                .trace(true)
                .build();

        /*AndroidUtil.runInBackground(()-> {
            db.transactionSync(() -> {
                for (int i = 0; i < 90; i++) {
                    Notify not = new Notify();
                    not.Id = (long) i;
                    not.CreatedTime = (int) AppUtil.getTime();
//                    not.Load = JsonUtil.toJson(new UserInfoJson());
//                    db.insertIntoNotify(not);
                    Message msg = new Message();
                    msg.MessageKey = LangUtil.getRandomString(20);
                    msg.RoomKey = "u12";
                    db.insertIntoMessage(msg);
                    AppUtil.log("==============================");
//                    toString(msg);
                }
            });

            List<Message> msg = db.selectFromMessage().idLe(20).toList();
            String k = LangUtil.getRandomString(2);
            db.transactionSync(() -> {
                for(Message m : msg){
                    m.RoomKey = k;
                    m.CreatedMs = TimeUtil.getTimeMs();
                    m.MessageKey = LangUtil.getRandomString(20)+ " ,ddd";
                    updateAuto(m, Message_Schema.INSTANCE);
                    db.prepareInsertIntoMessage(OnConflict.REPLACE,false).execute(m);

                }
            });


        });*/
    }

    public static void updateAuto(Object row, Schema tableSchema) {
        try {
            String primaryKey ="";
            String primaryVal ="";

            ContentValues content= new ContentValues();

            Field[] fields = row.getClass().getDeclaredFields();
            for(Field f : fields){
                String col = f.getName();//columname
                f.setAccessible(true);
                Object val =f.get(row);//col val

                if(f.isAnnotationPresent(PrimaryKey.class)){
                    primaryKey = col;
                    primaryVal = ""+val;
                    continue;
                }

                if(f.isAnnotationPresent(Column.class) == false){
                    continue;
                }

                if(val instanceof String){
//                    content.put(col, "'"+(String)val +"'");
                    content.put(col, (String)val);
                }else if(val instanceof Integer){
                    content.put(col,(Integer)val);
                }else if(val instanceof Float){
                    content.put(col,(Float) val);
                }else if(val instanceof Long){
                    content.put(col,(Long) val);
                }else if(val instanceof Short){
                    content.put(col,(Short) val);
                }else if(val instanceof Double){
                    content.put(col,(Double) val);
                }else if(val instanceof Byte) {
                    content.put(col, (Byte) val);
                }
            }

            String whereClause = primaryKey + "=?";
            String[] whereArgs = new String[]{primaryVal};

            db.getConnection().update(tableSchema,content,whereClause,whereArgs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
