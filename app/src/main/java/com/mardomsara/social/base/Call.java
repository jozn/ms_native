package com.mardomsara.social.base;

import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 10/5/2016.
 */
public class Call {
	public String Name;
	public int UserId;
	public long ClientCallId;
	public long ServerCallId;
	public String Data;
	public String Meta;

	private transient List<Object> _dataArray = null;

	public Call() {
		ClientCallId = TimeUtil.getTimeNano();
	}

	public Call(String name) {
		Name = name;
		ClientCallId = TimeUtil.getTimeNano();
	}

	public Call(String name, String data) {
		Name = name;
		Data = data;
		ClientCallId = TimeUtil.getTimeNano();
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


}
/*
	type Call struct {
	Name            string
	UserId          int
	ClientCallId    int64
	ServerCallId    int64
	Data            string        //marshilized json - don't set dirctly set via toJsonData
	toJsonSliceData []interface{} //`json:"-"`
	Meta            string        //marshilized json - don't set dirctly set via toJsonData
	}
*/
