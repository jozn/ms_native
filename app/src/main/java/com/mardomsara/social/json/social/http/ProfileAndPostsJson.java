package com.mardomsara.social.json.social.http;

import com.mardomsara.social.json.HttpBaseProtocol;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.json.social.rows.UserTableJson;

import java.util.List;

/**
 * Created by Hamid on 7/31/2016.
 */
public class ProfileAndPostsJson extends HttpBaseProtocol {
    public ProfileResponse Payload;

    public static class ProfileResponse{
        public UserTableJson User;
        public List<PostRowJson> Posts;
    }
}

