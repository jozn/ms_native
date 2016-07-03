package com.mardomsara.social.json;

import java.util.List;

/**
 * Created by Hamid on 4/28/2016.
 */
public class SyncFollowings extends HttpBaseProtocol {

    public Sync Payload ;

    public class Sync {
        public List<UserRow> Add;
        public List<Integer> Remove;
    }

}
