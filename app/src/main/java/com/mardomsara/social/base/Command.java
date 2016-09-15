package com.mardomsara.social.base;

import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.Getter;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hamid on 3/28/2016.
 */
@Table
public class Command {
    static final String BytesCol = "Bytes";
    static final String DataCol = "Data";


    @Column(helpers = Column.Helpers.CONDITION_EQ, defaultExpr = "''")
    public String Name;

    @Nullable
    @Column(helpers = Column.Helpers.CONDITION_EQ,value = DataCol)
    public String Data = null;

    @Column(helpers = Column.Helpers.CONDITION_EQ ,defaultExpr = "0")
    public long ResId = 0;//

    @PrimaryKey(auto = false,onConflict = OnConflict.REPLACE)
    public long ClientNanoId;//eq to nano

    public long ServerNanoId = -1 ;//eq to nano

    @Column(indexed = true)
    public long CreatedTimeMs;

    @Nullable
    @Column(value = BytesCol)
    transient byte[] Bytes = null;

//    @Setter()
    void setBytes(){

    }

//    @Expose(serialize = false, deserialize = false)
    private transient List<Object> _dataArray = null;

    public Command() {
//        ClientNanoId = (1_000_000_000_000L+LangUtil.getRandomLong(9_000_000_000_000L));
        ClientNanoId = TimeUtil.getTimeNano();;
        CreatedTimeMs = TimeUtil.getTimeMs();
    }

    public static Command getNewForResult(String name){
        Command cmd = new Command();
        cmd.Name = name;
        cmd.ResId = TimeUtil.getTimeNano();
        return cmd;
    }

    public static Command getNew(String name){
        Command cmd = new Command();
        cmd.Name = name;
        return cmd;
    }

    public void setData(Object objToJson){
        if(_dataArray != null){
            throw new RuntimeException("In network command you should not call both: .setData(...) and .addToDataArray(...) ");
        }
        Data = JsonUtil.toJson(objToJson);
    }

    public void addToDataArray(Object arrayRow){
        if(Data != null){
            throw new RuntimeException("In network command you should not call both: .setData(...) and .addToDataArray(...) ");
        }
        if(_dataArray == null){
            _dataArray = new ArrayList<>();
        }
        _dataArray.add(arrayRow);
    }

    @Getter()
    public void makeDataReady(){
        if(Data == null && _dataArray !=null){
            Data = JsonUtil.toJson(_dataArray);
        }else {
//            Data =
        }

    }

    //This is must be called for each object
    //thhis is set Data to its unesapted form "\\"
    public void prepareAfterLoadFromDB(){
        if(Bytes != null ){
            Data = new String(Bytes) ;
        }
    }

    public void insert(){
        if(Bytes == null && Data != null){
            Bytes =  Data.getBytes();
        }
        String q = "";
//        AppUtil.log(toString());
        DB.db.insertIntoCommand(this);
    }


    @Override
    public String toString() {
        return "Command{" +
                "Name='" + Name + '\'' +
                ", Data='" + Data + '\'' +
                ", ResId=" + ResId +
                ", ClientNanoId=" + ClientNanoId +
                ", CreatedTimeMs=" + CreatedTimeMs +
                ", Bytes=" + Arrays.toString(Bytes) +
                ", _dataArray=" + _dataArray +
                '}';
    }
}
