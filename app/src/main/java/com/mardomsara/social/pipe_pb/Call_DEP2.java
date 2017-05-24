package com.mardomsara.social.pipe_pb;

import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 10/5/2016.
 */
public class Call_DEP2 {
	public String Name;
	public long ClientCallId;
	public String Data;
	public long TimeMs;

	private transient List<Object> _dataArray = null;

	public Call_DEP2() {
		ClientCallId = TimeUtil.getTimeNano();
	}

	public Call_DEP2(String name) {
		Name = name;
		ClientCallId = TimeUtil.getTimeNano();
	}

	private Call_DEP2(String name, String data) {
		Name = name;
		Data = data;
		ClientCallId = TimeUtil.getTimeNano();
	}

	public Call_DEP2(String name, Object objectToJson) {
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
