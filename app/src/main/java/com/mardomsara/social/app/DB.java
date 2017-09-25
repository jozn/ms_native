package com.mardomsara.social.app;

import android.content.ContentValues;

import com.github.gfx.android.orma.AccessThreadConstraint;
import com.github.gfx.android.orma.Schema;
import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.AppDB;
import com.mardomsara.social.pipe.table.RpcDB;
//import com.mardomsara.social.models._migrate.tables.AppDB;
//import com.mardomsara.social.models.tables.AppDB;

import java.lang.reflect.Field;

/**
 * Created by Hamid on 9/1/2016.
 */
public class DB {

    private static RpcDB rpcDB = null;
    private static AppDB db = null;

	static {
		init();
	}


	public static AppDB getAppDB() {
		if(db != null) return db;

		AppDB.Builder builder = AppDB.builder(AppUtil.getContext());

		if(Config.IS_DEBUG){
			builder.readOnMainThread(AccessThreadConstraint.WARNING)
				.writeOnMainThread(AccessThreadConstraint.WARNING);
		} else {

		}

		db = (builder.name("ms40")
			.trace(true)
			.build());
		return db;
	}

	public static RpcDB getRpcDB() {
		if(rpcDB == null){
			RpcDB.Builder builder = RpcDB.builder(AppUtil.getContext());

			if(Config.IS_DEBUG){
				builder.readOnMainThread(AccessThreadConstraint.WARNING)
					.writeOnMainThread(AccessThreadConstraint.WARNING);
			} else {

			}

			rpcDB = builder.name("rpc")
				.trace(true)
				.build();
		}
		return rpcDB;
	}

	public static void init(){
        if(getAppDB() != null) return;
//        if(true) return;

		AppDB.Builder builder = AppDB.builder(AppUtil.getContext());

		if(Config.IS_DEBUG){
			builder.readOnMainThread(AccessThreadConstraint.WARNING)
				.writeOnMainThread(AccessThreadConstraint.WARNING);
		} else {

		}

		setDb(builder.name("ms40")
			.trace(true)
			.build());
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

            getAppDB().getConnection().update(tableSchema,content,whereClause,whereArgs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
