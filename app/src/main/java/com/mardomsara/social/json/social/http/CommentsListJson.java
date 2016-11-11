package com.mardomsara.social.json.social.http;

import com.mardomsara.social.json.HttpBaseProtocol;
import com.mardomsara.social.json.social.rows.CommentRowJson;

import java.util.List;

/**
 * Created by Hamid on 7/25/2016.
 */
@Deprecated
public class CommentsListJson extends HttpBaseProtocol {
    public List<CommentRowJson> Payload ;
}
