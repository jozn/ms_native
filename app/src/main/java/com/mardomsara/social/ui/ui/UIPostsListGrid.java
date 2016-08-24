package com.mardomsara.social.ui.ui;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.social.PostRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.presenter.social.ProfilePresenter;
import com.mardomsara.social.ui.views.FullScreenImage;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/3/2016.
 */
public class UIPostsListGrid {

    public static class PostsAdaptor extends AppHeaderFooterRecyclerViewAdapter<PostStreamHolder> {

        public static PostsAdaptor newFromPosts(List<PostRowJson> posts){
            PostsAdaptor adaptor = new PostsAdaptor();
            if(posts != null) adaptor.posts.addAll(posts);
            return adaptor;
        }

        public List<PostRowJson> posts = new ArrayList<>();

        @Override
        protected int getContentItemCount() {
            return posts.size();
        }

        @Override
        protected PostStreamHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
//            View v = AppUtil.inflate(R.layout.row_post_stream, parent);
            int screenSize = AndroidUtil.getScreenWidth()/3;
//            ImageView v = ViewHelper.newImageView(ViewHelper.MATCH_PARENT,ViewHelper.MATCH_PARENT);
            ImageView v = ViewHelper.newImageView(screenSize,screenSize);
            return new PostStreamHolder(v);
        }

        @Override
        protected void onBindContentItemViewHolder(PostStreamHolder postStreamHolder, int position) {
            postStreamHolder.bind(posts.get(position));
        }
    }

    /**
     * Created by Hamid on 8/3/2016.
     */


    public static class PostStreamHolder extends RecyclerView.ViewHolder {
        ImageView rootView;
        PostRowJson post;

        Uri imageUri2;


        View.OnClickListener gotoLikes = (v) -> {
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

        public PostStreamHolder(ImageView itemView) {
            super(itemView);
            rootView = itemView;

            itemView.setOnClickListener(gotoProfile);

        }

        void bind(PostRowJson post) {
            this.post = post;
            Uri imageUri = Helper.PathToUserAvatarUri(post.Sender.AvatarUrl);
            if (post.TypeId == 2) {
                int screenSize = AndroidUtil.getScreenWidth()/ 3;
//                ViewHelper.setImageSizesWithMaxPx(rootView,screenSize,screenSize,post.Width,post.Height);
                rootView.setVisibility(View.VISIBLE);
                String urlStr = "http://localhost:5000/"+post.MediaUrl;

                Picasso.with(AppUtil.getContext())
                        .load(urlStr)
                        .resize(screenSize,screenSize)
                        .placeholder(R.drawable.image_background)
//                        .fit()
                        .centerCrop()
                        .into(rootView);


            } else {
                rootView.setVisibility(View.GONE);
                rootView.setOnClickListener(null);
            }

            itemView.requestLayout();

        }
    }

}
