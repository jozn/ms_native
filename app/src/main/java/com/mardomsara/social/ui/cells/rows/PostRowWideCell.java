package com.mardomsara.social.ui.cells.rows;

import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.Nav_DEP;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router_DEP;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.post.PostRowUtils;
import com.mardomsara.social.ui.presenter.pages.ProfilePage;
import com.mardomsara.social.ui.views.FullScreenImage_Fresco;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostRowWideCell {
    JV.PostView post;
	X.PostRow_Stream x;

    Uri imageUri2;

    View.OnClickListener gotoLikes = (v) -> {
//        Nav.push(Router.getLikesPage(post.Id));
		Helper.showDebugMessage("gotoLikes");
        Nav_DEP.push(Router_DEP.getLikesPage(post.Id));
    };

    View.OnClickListener gotoComments = (v) -> {
		Helper.showDebugMessage("gotoComments");
		Nav_DEP.push(Router_DEP.getCommontsPage(post.Id));
    };

    View.OnClickListener gotoProfile = (v) -> {
		Helper.showDebugMessage("gotoProfile");
        Nav_DEP.push(new ProfilePage(post.UserId));
    };

    View.OnClickListener imagePopup = (v) -> {
        FullScreenImage_Fresco window = new FullScreenImage_Fresco();
        window.text = post.Text;
        window.imageUri = imageUri2;
        window.show();
    };

	View.OnClickListener likeListner = (v) -> {
		if(post.MyLike >0){//do unlike
			Http.postPath("/v1/unlike")
				.setFormParam("post_id",""+post.Id)
				.doAsyncUi((result)->{

				});
			post.MyLike = 0;
			post.LikesCount -= 1;
			likeBtnShowUnlike();

		}else {//do like
			Http.postPath("/v1/like")
				.setFormParam("post_id",""+post.Id)
				.doAsyncUi((result)->{

				});
			post.MyLike = 1;
			post.LikesCount += 1;
			likeBtnShowLike();
		}
		//onDownloadProgress view
		bind(post);
	};


    Runnable getGotoCommentsAdd = () -> {

    };

    public PostRowWideCell(ViewGroup parent) {
		x = new X.PostRow_Stream(parent);

		x.fullname.setOnClickListener(gotoProfile);
		x.avatar.setOnClickListener(gotoProfile);
		x.like_btn.setOnClickListener(likeListner);
    }

    public void bind(@NonNull JV.PostView post) {
		x.image.setVisibility(View.GONE);
        this.post = post;
		x.likes_count.setOnClickListener(gotoLikes);
		x.comment_count.setOnClickListener(gotoComments);

        x.text.setTextWithLimits(LangUtil.limitText(post.Text, 1600),160);
        x.fullname.setText(post.Sender.FullName);
        x.date.setText(FormaterUtil.timeAgo(post.CreatedTime));
        Uri imageUri = Helper.PathToUserAvatarUri(post.Sender.AvatarUrl);

//		x.avatar.setImageDrawable(TextDrawable.builder().buildRound(post.Sender.UserName.substring(0,1), ColorGenerator.MATERIAL.getColor(imageUri)));
		x.avatar.setImageURIAndId(imageUri, post.Sender.UserId);
//        x.avatar.setImageURI(imageUri);

        if (post.TypeId == 2 && post.PhotoView != null) {
			int screenSizePx =AndroidUtil.getScreenWidth() +1;
			int screenSize = AndroidUtil.pxToDp( AndroidUtil.getScreenWidth() )+1;
			ViewHelper.setImageSizesWithMaxPx(x.image,screenSize,screenSize,post.PhotoView.Width,post.PhotoView.Height);
			x.image.setVisibility(View.VISIBLE);
			String urlStr = Helper.postsGetBestPhotoResUrl(post.PhotoView,screenSizePx);
			/*Picasso.with(AppUtil.getContext())
				.load(urlStr)
				.placeholder(R.drawable.image_background)
				.into(x.image);*/

			x.image.setImageURIAndColorRGB(Uri.parse(urlStr),post.PhotoView.Color);


			PostRowUtils.setImage(x.image,post);

        } else {
            x.image.setVisibility(View.GONE);
        }

        if (post.LikesCount > 0) {
			x.likes_count.setVisibility(View.VISIBLE);
			x.likes_count.setTextStr(post.LikesCount + "پسند");
        }else {
			x.likes_count.setVisibility(View.GONE);
		}
        if (post.CommentsCount > 0) {
			x.comment_count.setVisibility(View.VISIBLE);
			x.comment_count.setTextStr(post.CommentsCount + "نظر");
        }else {
			x.comment_count.setTextStr("نظر دهید");
		}

        if(post.MyLike > 0){
            likeBtnShowLike();
        }else {
            likeBtnShowUnlike();
        }
    }

	private void likeBtnShowLike(){
		x.like_btn.setRightIconStr("ion-ios-heart");
		x.like_btn.setFullColor(AndroidUtil.getColor(R.color.light_blue_3));
	}

	private void likeBtnShowUnlike(){
		x.like_btn.setRightIconStr("ion-ios-heart-outline");
		x.like_btn.setFullColor(Color.BLACK);
//		x.like_btn.setText("\uf442");
	}

    public View getViewRoot() {
        return getRootView();
    }

	public View getRootView() {
		return x.root;
	}
}
