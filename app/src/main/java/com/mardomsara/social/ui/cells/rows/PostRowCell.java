package com.mardomsara.social.ui.cells.rows;

import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
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
import com.mardomsara.social.ui.presenter.social.ProfilePresenter;
import com.mardomsara.social.ui.views.EmojiLinkerTextView;
import com.mardomsara.social.ui.views.FullScreenImage;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.play.TextViewWithIcon;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostRowCell {
    public View rootView;
    PostRowJson post;

    @Bind(R.id.text)
	EmojiLinkerTextView text;
    @Bind(R.id.fullname)
    TextView user_name;
    @Bind(R.id.date)
    TextView date;
    @Bind(R.id.avatar)
    SimpleDraweeView avatar;

    @Bind(R.id.image)
    ImageView image;

    @Bind(R.id.like_btn) TextView like_btn;

    @Bind(R.id.comment_count)
    TextViewWithIcon comment_count;
    @Bind(R.id.likes_count)
    TextViewWithIcon likes_count;

    Uri imageUri2;


    View.OnClickListener gotoLikes = (v) -> {
//        Nav.push(Router.getLikesPage(post.Id));
        Nav.push(Router.getLikesPage(post.Id));
    };

    View.OnClickListener gotoComments = (v) -> {
        Nav.push(Router.getCommontsPage(post.Id));
    };

    View.OnClickListener gotoProfile = (v) -> {
        Nav.push(new ProfilePresenter(post.UserId));
    };

    View.OnClickListener imagePopup = (v) -> {
        FullScreenImage window = new FullScreenImage();
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
		//update view
		bind(post);
	};


    Runnable getGotoCommentsAdd = () -> {

    };

    public PostRowCell(ViewGroup parent) {
        View itemView = AppUtil.inflate(R.layout.row_post_stream, parent);
        ButterKnife.bind(this, itemView);
        rootView = itemView;

        user_name.setOnClickListener(gotoProfile);
        avatar.setOnClickListener(gotoProfile);
        like_btn.setOnClickListener(likeListner);

    }

    public void bind(@NonNull PostRowJson post) {
        this.post = post;
//        text.setText(LangUtil.limitText(post.Text, 120));
        text.setTextWithLimits(LangUtil.limitText(post.Text, 12000),120);
        user_name.setText(post.Sender.getFullName());
        date.setText(FormaterUtil.timeAgo(post.CreatedTime));
        Uri imageUri = Helper.PathToUserAvatarUri(post.Sender.AvatarUrl);
        avatar.setImageURI(imageUri);

        if (post.TypeId == 2) {
            int screenSize = AndroidUtil.pxToDp( AndroidUtil.getScreenWidth() )+1;
            ViewHelper.setImageSizesWithMaxPx(image,screenSize,screenSize,post.Width,post.Height);
            image.setVisibility(View.VISIBLE);
            String urlStr = API.BASE_CDN_DOMAIN_URL_STR+"/"+post.MediaUrl;
            Picasso.with(AppUtil.getContext())
                    .load(urlStr)
                    .placeholder(R.drawable.image_background)
                    .into(image);

        } else {
            image.setVisibility(View.GONE);
            image.setOnClickListener(null);
        }

        if (post.LikesCount > 0) {
			likes_count.setVisibility(View.VISIBLE);
			likes_count.setTextAndIcon(post.LikesCount + "پسند", "\uF443");
        }else {
			likes_count.setVisibility(View.GONE);
		}
        if (post.CommentsCount > 0) {
			comment_count.setVisibility(View.VISIBLE);
			comment_count.setTextAndIcon(post.CommentsCount + "نظر", "\uf11e");
        }else {
			comment_count.setTextAndIcon("نظر دهید", "\uf11e");
//			comment_count.setVisibility(View.GONE);
		}

        likes_count.setOnClickListener(gotoLikes);
        comment_count.setOnClickListener(gotoComments);

        if(post.AmIlike){
            likeBtnShowLike();
        }else {
            likeBtnShowUnlike();
        }

    }

	private void likeBtnShowLike(){
		like_btn.setTextColor(Color.RED);
		like_btn.setText("\uf443");
	}

	private void likeBtnShowUnlike(){
		like_btn.setTextColor(Color.BLACK);
		like_btn.setText("\uf442");
	}

    public View getViewRoot() {
        return rootView;
    }
}
