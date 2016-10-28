package com.mardomsara.social.json;

/**
 * Created by Hamid on 1/23/2016.
 */
public class HttpJson<T> {
    public String Status;
   // public List<com.mardomsara.social.json.UserListFollow> UserListFollow = new ArrayList<com.mardomsara.social.json.UserListFollow>();
    public Integer ServerTime;
    public Integer Version;
    public Integer ResTime;
    public T Payload;

	public boolean isPayloadNoneEmpty(){
		if(Payload == null ){
			return false;
		}
		return true;
	}

}
