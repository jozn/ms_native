package com.mardomsara.social.app;

import com.mardomsara.social.helpers.AppUtil;

import java.net.URL;

/**
 * Created by Hamid on 3/19/2016.
 */
public class API {
    public static String BASE_URL_STR = "http://localhost:5000/v1/";
    public static URL BASE_URL = AppUtil.toUrl(BASE_URL_STR);

    public static URL POSTS_GET = AppUtil.toUrl(BASE_URL_STR+"posts");
    public static URL POST_ADD = AppUtil.toUrl(BASE_URL_STR+"add-post");
    public static URL POST_DELETE = AppUtil.toUrl(BASE_URL_STR+"posts");

    public static URL COMMENTS_GET = AppUtil.toUrl(BASE_URL_STR+"comments");
    public static URL COMMENT_ADD = AppUtil.toUrl(BASE_URL_STR+"add-comment");

    public static URL LIKES_GET = AppUtil.toUrl(BASE_URL_STR+"likes");
    public static URL LIKE_POST_ADD = AppUtil.toUrl(BASE_URL_STR + "add-post-like");

    public static URL UPLOAD_AVATAR = AppUtil.toUrl(BASE_URL_STR+"upload-avatar");
    public static URL AVATAR_REMOVE = AppUtil.toUrl(BASE_URL_STR+"remove-avatar");

    public static URL PROFILE_GET = AppUtil.toUrl(BASE_URL_STR+"profile");

    public static URL FOLLOW_ADD = AppUtil.toUrl(BASE_URL_STR+"follow");
    public static URL UNFOLLOW = AppUtil.toUrl(BASE_URL_STR+"unfollow");
    public static URL FOLLOWERS_GET = AppUtil.toUrl(BASE_URL_STR+"followers");
    public static URL FOLLOWINGS_GET = AppUtil.toUrl(BASE_URL_STR+"followings");

    public static URL SEARCH_GET = AppUtil.toUrl(BASE_URL_STR+"search");
    public static URL TAGS_LIST_GET = AppUtil.toUrl(BASE_URL_STR+"tag");

    public static URL CONTACTS_SYNC_ALL = AppUtil.toUrl(BASE_URL_STR+"sync-all-contacts");
    public static URL FOLLOWINGS_SYNC_ALL = AppUtil.toUrl(BASE_URL_STR+"sync-followings");

    /////////////////// New from  version 0.4 //////
    public static URL POSTS_STREAM_GET = AppUtil.toUrl(BASE_URL_STR+"post/stream");
    public static URL POSTS_LIKES_GET = AppUtil.toUrl(BASE_URL_STR+"likes");

    static {
        setUp();
    }

    private static void setUp() {

    }
}
