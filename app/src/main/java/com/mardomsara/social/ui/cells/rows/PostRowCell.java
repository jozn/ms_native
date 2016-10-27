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
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.ui.presenter.social.ProfilePresenter;
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
    TextView text;
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


    Runnable getGotoCommentsAdd = () -> {

    };

    public PostRowCell(ViewGroup parent) {
        View itemView = AppUtil.inflate(R.layout.row_post_stream, parent);
        ButterKnife.bind(this, itemView);
        rootView = itemView;

        user_name.setOnClickListener(gotoProfile);
        avatar.setOnClickListener(gotoProfile);

    }

    public void bind(@NonNull PostRowJson post) {
        this.post = post;
        text.setText(LangUtil.limitText(post.Text, 120));
        user_name.setText(post.Sender.getFullName());
        date.setText(FormaterUtil.timeToDayTime(post.CreatedTime));
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
            likes_count.setTextAndIcon(post.LikesCount + "پسند", "\uF443");
        }
        if (post.CommentsCount > 0) {
            comment_count.setTextAndIcon(post.CommentsCount + "نظر", "\uf11e");
        }

        likes_count.setOnClickListener(gotoLikes);
        comment_count.setOnClickListener(gotoComments);

        if(post.AmIlike){
            like_btn.setTextColor(Color.RED);
            like_btn.setText("\uf443");

        }else {
            like_btn.setTextColor(Color.BLACK);
            like_btn.setText("\uf442");
        }

    }

    public View getViewRoot() {
        return rootView;
    }
}
