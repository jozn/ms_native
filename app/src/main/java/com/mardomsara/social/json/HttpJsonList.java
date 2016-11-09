package com.mardomsara.social.json;

import java.util.List;

/**
 * Created by Hamid on 1/23/2016.
 */
public class HttpJsonList<T> { //extends HttpJson {
    public String Status;
    // public List<com.mardomsara.social.del.UserListFollow> UserListFollow = new ArrayList<com.mardomsara.social.del.UserListFollow>();
    public Integer ServerTime;
    public Integer Version;
    public Integer ResTime;
    public List<T> Payload;

	public boolean isPayloadNoneEmpty(){
		if(Payload == null || Payload.size() == 0 || !Status.equalsIgnoreCase("OK")){
			return false;
		}
		return true;
	}
}
