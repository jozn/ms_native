package com.mardomsara.social.pipe_pb;

import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 10/5/2016.
 */
public class Call_DEP {
	public String Name;
	public int UserId;
	public long ClientCallId;
	public long ServerCallId;
	public String Data;
	public String Meta;
	public long TimeMs;

	private transient List<Object> _dataArray = null;

	public Call_DEP() {
		ClientCallId = TimeUtil.getTimeNano();
	}

	public Call_DEP(String name) {
		Name = name;
		ClientCallId = TimeUtil.getTimeNano();
	}

	private Call_DEP(String name, String data) {
		Name = name;
		Data = data;
		ClientCallId = TimeUtil.getTimeNano();
	}

	public Call_DEP(String name, Object objectToJson) {
		Name = name;
		setData(objectToJson);
		ClientCallId = TimeUtil.getTimeNano();
	}

	public void setData(Object objToJson){
		if(_dataArray != null){
			throw new RuntimeException("In network command you should not call both: .setData(...) and .addToDataArray(...) ");
		}
		Data = JsonUtil.toJson(objToJson);
	}

	public void setMeta(Object objToJson){
		Meta = JsonUtil.toJson(objToJson);
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


}
/*
	type Call struct {
	Name            string
	UserId          int
	ClientCallId    int64
	ServerCallId    int64
	Data            string        //marshilized json - don't setOrReplace dirctly setOrReplace via toJsonData
	toJsonSliceData []interface{} //`json:"-"`
	Meta            string        //marshilized json - don't setOrReplace dirctly setOrReplace via toJsonData
	}
*/
