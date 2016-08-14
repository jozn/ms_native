package com.mardomsara.social.models;

import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.BooleanRespnseJson;
import com.mardomsara.social.json.social.CommentSingleJson;

/**
 * Created by Hamid on 7/31/2016.
 */
public class Comment {
    public static void serverRemoveComment(int commentId, int postId){
        AndroidUtil.runInBackgroundNoPanic(()-> {
            Http.Req req = new Http.Req();
            req.absPath = API.COMMENTS_DELETE.toString();
            req.form.put("post_id", "" + postId);
            req.form.put("comment_id", "" + commentId);

            Http.Result res = Http.masterSendPost(req);
            boolean isError = false;
            if (res.ok) {
                BooleanRespnseJson data = JsonUtil.fromJson(res.data, BooleanRespnseJson.class);
                if (data != null && data.Status.equalsIgnoreCase("OK")) {
                    if (data.Payload == true) {
                        Helper.showMessage("پیام حذف شد");
                    } else {
                        isError = true;
                    }
                } else {
                    isError = true;
                }
            } else {
                isError = true;
            }

            if (isError) {
                Helper.showMessage("خطایی در حذف نظر پیش آمد");
            }

        });
    }
}
