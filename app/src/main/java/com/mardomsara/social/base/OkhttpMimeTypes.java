package com.mardomsara.social.base;

import okhttp3.MediaType;

/**
 * Created by Hamid on 3/19/2016.
 */
public class OkhttpMimeTypes {
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json");
    public static final MediaType MEDIA_TYPE_TEXT_PLAIN = MediaType.parse("text/plain");
    public static final MediaType MEDIA_TYPE_HTML = MediaType.parse("text/html");
    public static final MediaType MEDIA_TYPE_FILE_GENERAL = MediaType.parse("application/octet-stream");
    public static final MediaType MEDIA_TYPE_MP4 = MediaType.parse("video/mp4");
    public static final MediaType MEDIA_TYPE_MULTIPART = MediaType.parse("multipart/form-data");
}
