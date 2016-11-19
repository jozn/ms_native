package com.mardomsara.social.del;

import com.mardomsara.social.json.HttpBaseProtocol;
import com.mardomsara.social.json.social.rows.TopTagsWithPostsRowJson;

import java.util.List;

/**
 * Created by Hamid on 8/23/2016.
 */
@Deprecated
public class TopTagsWithPostsJson extends HttpBaseProtocol {
    public List<TopTagsWithPostsRowJson> Payload;
}
