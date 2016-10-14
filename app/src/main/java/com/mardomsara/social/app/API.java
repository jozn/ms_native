package com.mardomsara.social.app;

import com.mardomsara.social.helpers.AppUtil;

import java.net.URL;

/**
 * Created by Hamid on 3/19/2016.
 */
public class API {
    public static String BASE_DOMAIN_URL_STR = "http://localhost:5000";// NOTICE NO: "/"
    public static String BASE_URL_STR = "http://localhost:5000/v1/";
    public static URL BASE_URL = AppUtil.toUrl(BASE_URL_STR);

    public static URL POSTS_GET = AppUtil.toUrl(BASE_URL_STR+"posts");
    public static URL POST_ADD = AppUtil.toUrl(BASE_URL_STR+"addStart-post");
    public static URL POST_DELETE = AppUtil.toUrl(BASE_URL_STR+"posts");

//    public static URL COMMENTS_LIST_GET = AppUtil.toUrl(BASE_URL_STR+"comments");
//    public static URL COMMENT_ADD = AppUtil.toUrl(BASE_URL_STR+"addStart-comment");

    public static URL LIKE_POST_ADD = AppUtil.toUrl(BASE_URL_STR + "addStart-post-like");

    public static URL UPLOAD_AVATAR = AppUtil.toUrl(BASE_URL_STR+"upload-avatar");
    public static URL AVATAR_REMOVE = AppUtil.toUrl(BASE_URL_STR+"remove-avatar");

    public static URL PROFILE_GET = AppUtil.toUrl(BASE_URL_STR+"profile");

    public static URL SEARCH_GET = AppUtil.toUrl(BASE_URL_STR+"search");
    public static URL TAGS_LIST_GET = AppUtil.toUrl(BASE_URL_STR+"tag");

    public static URL CONTACTS_SYNC_ALL = AppUtil.toUrl(BASE_URL_STR+"sync-all-contacts");
    public static URL FOLLOWINGS_SYNC_ALL = AppUtil.toUrl(BASE_URL_STR+"sync-followings");

    /////////////////// New from  version 0.4 //////
    public static URL POSTS_STREAM_GET = AppUtil.toUrl(BASE_URL_STR+"post/stream");
    public static URL POSTS_LATEST_GET = AppUtil.toUrl(BASE_URL_STR+"post/latest");
    public static URL POSTS_LIKES_GET = AppUtil.toUrl(BASE_URL_STR+"likes");//dep
    public static URL LIKES_GET = AppUtil.toUrl(BASE_URL_STR+"likes");

    public static URL COMMENTS_LIST_GET = AppUtil.toUrl(BASE_URL_STR+"comments/list");
    public static URL COMMENTS_ADD = AppUtil.toUrl(BASE_URL_STR+"comments/addStart");
    public static URL COMMENTS_DELETE = AppUtil.toUrl(BASE_URL_STR+"comments/delete");

    public static URL SESSION_INFO = AppUtil.toUrl(BASE_URL_STR+"session/info");

    public static URL PROFILE_ALL = AppUtil.toUrl(BASE_URL_STR+"profile/all");
    public static URL PROFILE_POSTS = AppUtil.toUrl(BASE_URL_STR+"profile/posts");

    public static URL FOLLOW_ADD = AppUtil.toUrl(BASE_URL_STR+"follow");
    public static URL UNFOLLOW = AppUtil.toUrl(BASE_URL_STR+"unfollow");
    public static URL FOLLOWERS_GET = AppUtil.toUrl(BASE_URL_STR+"followers");
    public static URL FOLLOWINGS_GET = AppUtil.toUrl(BASE_URL_STR+"following");

    ////////////////////// String types ///////////////////

    public static String RECOMMEND_TOP_POST = BASE_URL_STR+"recommend/top_posts";
    public static String RECOMMEND_TOP_TAGS =  BASE_URL_STR+"recommend/top_tags";
    public static String RECOMMEND_TOP_TAGS_DISCOVER =  BASE_URL_STR+"recommend/top_tags_discover";
    public static String RECOMMEND_USERS =  BASE_URL_STR+"recommend/users";

    public static String TAGS_LIST =  BASE_URL_STR+"tags/list";
    public static String LATEST_POSTS_GET =  BASE_URL_STR+"post/latest";

    public static String SEARCH_TAGS =  BASE_URL_STR+"search/tags";
    public static String SEARCH_USERS =  BASE_URL_STR+"search/users";

    public static String NOTIFICATIONS =  BASE_URL_STR+"notifications";

    public static String CONTACTS_GRAB_ALL =  BASE_URL_STR+"grab_contacts2";


    static {
        setUp();
    }

    private static void setUp() {

    }
}
