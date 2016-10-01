package com.mardomsara.social.models;

import com.mardomsara.social.app.API;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.http.BooleanRespnseJson;

/**
 * Created by Hamid on 7/31/2016.
 */
public class Comment {
    public static void serverRemoveComment(int commentId, int postId){
        AndroidUtil.runInBackgroundNoPanic(()-> {
            HttpOld.Req req = new HttpOld.Req();
            req.absPath = API.COMMENTS_DELETE.toString();
            req.form.put("post_id", "" + postId);
            req.form.put("comment_id", "" + commentId);

            HttpOld.Result res = HttpOld.masterSendPost(req);
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
