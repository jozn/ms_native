package com.mardomsara.social.ui.ui;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.social.PostRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.HeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.presenter.social.ProfilePresenter;
import com.mardomsara.social.ui.views.FullScreenImage;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.play.TextViewWithIcon;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/3/2016.
 */
public class UIPostsList {
    static {
        Glide.get(AppUtil.getContext()).setMemoryCategory(MemoryCategory.LOW);
    }
    public static RecyclerView buildNew(List<PostRowJson> posts){
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
//        if(posts == null){
//            return null;
//        }

        PostsAdaptor adaptor = new PostsAdaptor();
        if(posts != null) posts.addAll(posts);
//        adaptor.posts.addAll(posts);

        recycler_view.setLayoutManager(new LinearLayoutManager(AppUtil.getContext()));
        recycler_view.setAdapter(adaptor);

        return recycler_view;
    }

    public static RecyclerView buildNew(PostsAdaptor adaptor){
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
        recycler_view.setLayoutManager(new LinearLayoutManager(AppUtil.getContext()));
        recycler_view.setAdapter(adaptor);

        return recycler_view;
    }

    public static RecyclerView buildNew(PostsAdaptor adaptor, ViewGroup parent){
        RecyclerView recycler_view = (RecyclerView)AppUtil.inflate(R.layout.view_recycler_view,parent);
        recycler_view.setLayoutManager(new LinearLayoutManager(AppUtil.getContext()));
        recycler_view.setAdapter(adaptor);

        return recycler_view;
    }

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
            View v = AppUtil.inflate(R.layout.row_post_stream, parent);
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
        View rootView;
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
//        SimpleDraweeView image;

        //            @Bind(R.id.comment_count) TextView comment_count;
        @Bind(R.id.comment_count)
        TextViewWithIcon comment_count;
        //            @Bind(R.id.likes_count) TextView likes_count;
        @Bind(R.id.likes_count)
        TextViewWithIcon likes_count;
        //            @Bind(R.id.cnts) TextViewWithIcon cnts;
        //            @Bind(R.id.vvv) IconAnTextView vvv;

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

        static int __i = 0;
        public PostStreamHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            __i++;
            AppUtil.log("xxx: count of ui instance: " + __i);
            rootView = itemView;

            user_name.setOnClickListener(gotoProfile);
            avatar.setOnClickListener(gotoProfile);

        }

        void bind(PostRowJson post) {
            this.post = post;
            text.setText(LangUtil.limitText(post.Text, 120));
            user_name.setText(post.Sender.FullName);
            date.setText(FormaterUtil.timeToDayTime(post.CreatedTime));
            Uri imageUri = Helper.PathToUserAvatarUri(post.Sender.AvatarUrl);
            avatar.setImageURI(imageUri);
            /*if (LangUtil.getRandom(3) % 2 == 0) {
                image.setVisibility(View.VISIBLE);
                imageUri2 = Helper.PathToUserAvatarUri("/public/photo/" + LangUtil.getRandom(50) + "_960.jpg");
                image.setImageURI(imageUri2);
                image.setOnClickListener(imagePopup);
            } else {
                image.setVisibility(View.GONE);
                image.setOnClickListener(null);
            }*/

            if (post.TypeId == 2) {
                int screenSize = AndroidUtil.pxToDp( AndroidUtil.getScreenWidth() );
                ViewHelper.setImageSizesWithMaxPx(image,screenSize,screenSize,post.Width,post.Height);
                image.setVisibility(View.VISIBLE);
                String urlStr = "http://localhost:5000/"+post.MediaUrl;

                Glide.with(AppUtil.getContext())
                    .load(urlStr)
                    .centerCrop()
//                    .placeholder(R.drawable.loading_spinner)
                    .crossFade()
                    .into(image);

                /////// Fresco //////////////////
                /*imageUri2 = Uri.parse("http://localhost:5000/"+post.MediaUrl);
                image.setImageURI(imageUri2);
                image.setOnClickListener(imagePopup);*/
            } else {
                image.setVisibility(View.GONE);
                image.setOnClickListener(null);
            }

            //                comment_count.setText(MixIconAndTextHelper.MixIconAndText("نظر 256 ","\uf11e"));
            //                comment_count.setText(MixIconAndTextHelper.MixIconAndText(post.CommentsCount +8 +" نظر ","\uf11e"));
            //comment_count.setText(MixIconAndTextHelper.MixIconAndText(" ۱۲۳ پسند ","۱۲۳ \uf443"));
            //                likes_count.setText(MixIconAndTextHelper.MixIconAndText(" پسند ۱۲۳ ","\uf443"));
            //likes_count.setText(MixIconAndTextHelper.MixIconAndText4(" پسند ","45","\uf443"));
            //                vvv.setTexts(" پسند ","125","\uf443");

                /*Bitmap bitmap =BitmapFactory.decodeResource(getContext().getResources(),R.drawable.emoji_1f1e6_1f1e9);
                Bitmap bm2 = ImageUtil.getResizedBitmapRatio(bitmap,20);
                BitmapDrawable bm3 = new BitmapDrawable(getContext().getResources(),bm2);

                likes_count.setCompoundDrawables(bm3,null,null,null);

                Drawable d = getContext().getResources().getDrawable(R.drawable.img_likes_count);
                comment_count.setCompoundDrawables(d,null,null,null);
                likes_count.setCompoundDrawables(d,null,d,null);

    */
            //                likes_count.setTextAndIcon(142+"پسند","\uF443");
            if (post.LikesCount > 0) {
                likes_count.setTextAndIcon(post.LikesCount + "پسند", "\uF443");
            }
            if (post.CommentsCount > 0) {
                comment_count.setTextAndIcon(post.CommentsCount + "نظر", "\uf11e");
            }

            likes_count.setOnClickListener(gotoLikes);
            comment_count.setOnClickListener(gotoComments);

            itemView.requestLayout();

            //                cnts.setTextAndIcon("256 منه","\uF443");
        }
    }

    public static class HomeStreamAdaptor_Dep extends RecyclerView.Adapter<PostStreamHolder> {
        public List<PostRowJson> posts;

        @Override
        public PostStreamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = AppUtil.inflate(R.layout.row_post_stream, parent);
            return new PostStreamHolder(v);
        }

        @Override
        public void onBindViewHolder(PostStreamHolder holder, int position) {
            holder.bind(posts.get(position));
        }

        @Override
        public int getItemCount() {
            return posts.size();
        }

    }
}
