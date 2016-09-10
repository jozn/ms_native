package com.mardomsara.social.base;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.google.gson.annotations.Expose;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 3/28/2016.
 */
@Table
public class Command {
    @Column(helpers = Column.Helpers.CONDITION_EQ)
    public String Name;

    @Column(helpers = Column.Helpers.CONDITION_EQ)
    public String Data;

    @Column(helpers = Column.Helpers.CONDITION_EQ)
    public long ResId;//

    @PrimaryKey(auto = false)
    public long CmdId;//eq to nano

    @Column(indexed = true)
    public long CreatedTimeMs;

//    @Expose(serialize = false, deserialize = false)
    private transient List<Object> _dataArray = new ArrayList<>();

    public Command() {
        CmdId = TimeUtil.getTimeNano()+ (long)(1000_000+LangUtil.getRandom(9_000_000));
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
        _dataArray.add(arrayRow);
    }

    public void makeDataReady(){
        if(Data == null && _dataArray !=null){
            Data = JsonUtil.toJson(_dataArray);
        }
    }


}
