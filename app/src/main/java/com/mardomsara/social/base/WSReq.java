package com.mardomsara.social.base;

import java.util.Map;

//dep unused  --delete
public class WSReq {
   public String SessionUid;
    public String Command;
    public Map<String, Object> Params; // map[string]interface{}
    public String RequestId;
}
