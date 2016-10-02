package com.mardomsara.social.json;

import com.mardomsara.social.json.social.rows.UserSyncJson;

import java.util.List;

/**
 * Created by Hamid on 4/28/2016.
 */
public class SyncFollowings extends HttpBaseProtocol {

    public Sync Payload ;

    public class Sync {
        public List<UserSyncJson> Add;
        public List<Integer> Remove;
    }

}
