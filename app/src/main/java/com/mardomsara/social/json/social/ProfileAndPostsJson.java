package com.mardomsara.social.json.social;

import com.mardomsara.social.json.HttpBaseProtocol;
import com.mardomsara.social.json.social.server.ServerUserTable;

import java.util.List;

/**
 * Created by Hamid on 7/31/2016.
 */
public class ProfileAndPostsJson extends HttpBaseProtocol {
    public ProfileResponse Payload;

    public static class ProfileResponse{
        public ServerUserTable User;
        public List<PostRowJson> Posts;
    }
}

