package com.mardomsara.social.ui.cells.post;

import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.API;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.presenter.pages.ProfilePage;
import com.mardomsara.social.ui.views.FullScreenImage;
import com.mardomsara.social.ui.views.FullScreenImage_Fresco;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostRowCompactWrapper {

    PostRowJson post;

    Uri imageUri2;


    View.OnClickListener gotoLikes = (v) -> {
//        Nav.push(Router.getLikesPage(post.Id));
        Nav.push(Router.getLikesPage(post.Id));
    };

    View.OnClickListener gotoComments = (v) -> {
        Nav.push(Router.getCommontsPage(post.Id));
    };

    View.OnClickListener gotoProfile = (v) -> {
        Nav.push(new ProfilePage(post.UserId));
    };

    View.OnClickListener imagePopup = (v) -> {
        FullScreenImage_Fresco window = new FullScreenImage_Fresco();
        window.text = post.Text;
        window.imageUri = imageUri2;
        window.show();
    };

	View.OnClickListener likeListner = (v) -> {
		if(post.AmIlike){//do unlike
			Http.postPath("/v1/unlike")
				.setFormParam("post_id",""+post.Id)
				.doAsyncUi((result)->{

				});
			post.AmIlike = false;
			post.LikesCount -= 1;
			likeBtnShowUnlike();

		}else {//do like
			Http.postPath("/v1/like")
				.setFormParam("post_id",""+post.Id)
				.doAsyncUi((result)->{

				});
			post.AmIlike = true;
			post.LikesCount += 1;
			likeBtnShowLike();
		}
		//onDownloadProgress view
		bind(post);
	};


    Runnable getGotoCommentsAdd = () -> {

    };

	public X.PostRow_Compact x = new X.PostRow_Compact();

	public PostRowCompactWrapper(ViewGroup parent) {
        x.fullname.setOnClickListener(gotoProfile);
        x.avatar.setOnClickListener(gotoProfile);
        x.like_btn.setOnClickListener(likeListner);

    }

    public void bind(@NonNull PostRowJson post) {
        this.post = post;
//        text.setText(LangUtil.limitText(post.Text, 120));
        x.text.setTextWithLimits(LangUtil.limitText(post.Text, 1600),160);
        x.fullname.setText(post.Sender.getFullName());
        x.date.setText(FormaterUtil.timeAgo(post.CreatedTime));
        Uri imageUri = Helper.PathToUserAvatarUri(post.Sender.AvatarUrl);

		int p50 = AndroidUtil.dpToPx(55);
//        x.avatar.setImageURI(imageUri);
		Picasso.with(AppUtil.getContext())
			.load(imageUri)
			.resize(p50, p50)
			.centerCrop()
			.transform(new RoundedCornersTransformation(AndroidUtil.dpToPx(6),0))
			.placeholder(R.drawable.image_background)
			.into(x.avatar);

        if (post.TypeId == 2) {
            /*int screenSize =AndroidUtil.getScreenWidth() +1;
			int w = (int) (screenSize*.75);
			int h = (int) (w*.66);
            x.image.getLayoutParams().height = h;
            x.image.getLayoutParams().width = w;*/

			int iw = x.image.getLayoutParams().width;
			int ih = x.image.getLayoutParams().height;
            x.image.setVisibility(View.VISIBLE);
            String urlStr = API.BASE_CDN_DOMAIN_URL_STR+"/"+post.MediaUrl;
            Picasso.with(AppUtil.getContext())
                    .load(urlStr)
//					.resize(w,h)
//					.centerCrop()
					.transform(new CropTransformation(0,ih))
					.transform(new RoundedCornersTransformation(AndroidUtil.dpToPx(12),0))
                    .placeholder(R.drawable.image_background)
                    .into(x.image);

			PostRowUtils.setImage(x.image,post);

        } else {
            x.image.setVisibility(View.GONE);
            x.image.setOnClickListener(null);
        }

        if (post.LikesCount > 0) {
			x.likes_count.setVisibility(View.VISIBLE);
			x.likes_count.setTextAndIcon(post.LikesCount + "پسند", "\uF443");
        }else {
			x.likes_count.setVisibility(View.GONE);
		}
        if (post.CommentsCount > 0) {
			x.comment_count.setVisibility(View.VISIBLE);
			x.comment_count.setTextAndIcon(post.CommentsCount + "نظر", "\uf11e");
        }else {
			x.comment_count.setTextAndIcon("نظر دهید", "\uf11e");
//			comment_count.setVisibility(View.GONE);
		}

        x.likes_count.setOnClickListener(gotoLikes);
        x.comment_count.setOnClickListener(gotoComments);

        if(post.AmIlike){
            likeBtnShowLike();
        }else {
            likeBtnShowUnlike();
        }

    }

	private void likeBtnShowLike(){
		x.like_btn.setTextColor(Color.RED);
		x.like_btn.setText("\uf443");
	}

	private void likeBtnShowUnlike(){
		x.like_btn.setTextColor(Color.BLACK);
		x.like_btn.setText("\uf442");
	}

}
