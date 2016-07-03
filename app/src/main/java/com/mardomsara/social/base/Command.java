package com.mardomsara.social.base;

import com.google.gson.annotations.Expose;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 3/28/2016.
 */
public class Command {
    public String Name;
    public String Data;
    public long ResId;
    public long CmdId;//u seconds

//    @Expose(serialize = false, deserialize = false)
    private transient List<Object> _dataArray = new ArrayList<>();

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
        Data = JsonUtil.toJson(objToJson);
    }

    public void addToDataArray(Object arrayRow){
        _dataArray.add(arrayRow);
    }

    public void makeDataReady(){
        if(Data == null && _dataArray !=null){
            Data = JsonUtil.toJson(_dataArray);
        }
    }


}
