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

		AppDB.Builder builder = AppDB.builder(AppUtil.getContext());

		if(Config.IS_DEBUG){
			builder.readOnMainThread(AccessThreadConstraint.WARNING)
				.writeOnMainThread(AccessThreadConstraint.WARNING);
		} else {

		}

		db = builder.name("ms32")
			.trace(true)
			.build();
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
