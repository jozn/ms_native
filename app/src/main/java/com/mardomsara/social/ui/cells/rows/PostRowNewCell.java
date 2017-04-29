package com.mardomsara.social.ui.cells.rows;

import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.post.PostRowUtils;
import com.mardomsara.social.ui.presenter.pages.ProfilePage;
import com.mardomsara.social.ui.views.FullScreenImage_Fresco;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.squareup.picasso.Picasso;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostRowNewCell {
//    private View rootView;
    JV.PostView post;
	X.PostRow_Stream x;

    /*@Bind(R.id.text)
	XEmojiLinkerTextView text;
    @Bind(R.id.fullname)
    TextView user_name;
    @Bind(R.id.date)
    TextView date;
    @Bind(R.id.avatar)
    SimpleDraweeView avatar;

    @Bind(R.id.image)
    ImageView image;

    @Bind(R.id.like_btn) TextView like_btn;*/

    /*@Bind(R.id.comment_count)
	TextViewWithIcon_DEP comment_count;
    @Bind(R.id.likes_count)
	TextViewWithIcon_DEP likes_count;*/

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

    public PostRowNewCell(ViewGroup parent) {
//		rootView = AppUtil.inflate(R.layout.post_row__stream, parent);
		x = new X.PostRow_Stream(parent);
//        ButterKnife.bind(this, rootView);
//        rootView = itemView;
		x.fullname.setOnClickListener(gotoProfile);
		x.avatar.setOnClickListener(gotoProfile);
		x.like_btn.setOnClickListener(likeListner);
//        user_name.setOnClickListener(gotoProfile);
//        avatar.setOnClickListener(gotoProfile);
//        like_btn.setOnClickListener(likeListner);

    }

    public void bind(@NonNull JV.PostView post) {
		x.image.setVisibility(View.GONE);
        this.post = post;
//        text.setText(LangUtil.limitText(post.Text, 120));
        x.text.setTextWithLimits(LangUtil.limitText(post.Text, 1600),160);
        x.fullname.setText(post.Sender.FullName);
        x.date.setText(FormaterUtil.timeAgo(post.CreatedTime));
        Uri imageUri = Helper.PathToUserAvatarUri(post.Sender.AvatarUrl);
        x.avatar.setImageURI(imageUri);

        if (post.TypeId == 2 && post.PhotoView != null) {
			int screenSizePx =AndroidUtil.getScreenWidth() +1;
			int screenSize = AndroidUtil.pxToDp( AndroidUtil.getScreenWidth() )+1;
			ViewHelper.setImageSizesWithMaxPx(x.image,screenSize,screenSize,post.PhotoView.Width,post.PhotoView.Height);
			x.image.setVisibility(View.VISIBLE);
//			String urlStr = API.BASE_CDN_DOMAIN_URL_STR+"/"+post.MediaUrl;
			String urlStr = Helper.postsGetBestPhotoResUrl(post.PhotoView,screenSizePx);
			Picasso.with(AppUtil.getContext())
				.load(urlStr)
				.placeholder(R.drawable.image_background)
				.into(x.image);

			PostRowUtils.setImage(x.image,post);

        } else {
            x.image.setVisibility(View.GONE);
//            image.setOnClickListener(null);
        }

        if (post.LikesCount > 0) {
			x.likes_count.setVisibility(View.VISIBLE);
//			x.likes_count.setTextStr(post.LikesCount + "پسند");
			x.likes_count.setTextAndIcon(post.LikesCount + "پسند", "\uF443");
        }else {
			x.likes_count.setVisibility(View.GONE);
		}
        if (post.CommentsCount > 0) {
			x.comment_count.setVisibility(View.VISIBLE);
//			x.comment_count.setTextStr(post.CommentsCount + "نظر");
			x.comment_count.setTextAndIcon(post.CommentsCount + "نظر", "\uf11e");
        }else {
			x.comment_count.setTextAndIcon("نظر دهید" , "\uf11e");
//			comment_count.setVisibility(View.GONE);
		}

        x.likes_count.setOnClickListener(gotoLikes);
        x.comment_count.setOnClickListener(gotoComments);

        if(post.MyLike > 0){
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

    public View getViewRoot() {
        return getRootView();
    }

	public View getRootView() {
		return x.root;
	}
}
