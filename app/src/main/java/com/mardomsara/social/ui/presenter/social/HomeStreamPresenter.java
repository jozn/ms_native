package com.mardomsara.social.ui.presenter.social;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.social.HomeStreamJson;
import com.mardomsara.social.json.social.HomeStreamRowJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.views.FullScreenImage;
import com.mardomsara.social.ui.views.play.IconAnTextView;
import com.mardomsara.social.ui.views.play.MixIconAndTextHelper;
import com.mardomsara.social.ui.views.play.TextViewWithIcon;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/13/2016.
 */
public class HomeStreamPresenter extends BasePresenter {
    View view;
    @Bind(R.id.content) View content;
    @Bind(R.id.loading) View loading;
    @Bind(R.id.recycler_view) RecyclerView recycler_view;



    @Override
    public View buildView() {
        view = AppUtil.inflate(R.layout.preseter_home_stream);
        ButterKnife.bind(this,view);
        loadFromServer();
        return view;
    }

    private void loadFromServer() {
        AndroidUtil.runInBackground(()->{
            Http.Req req = new Http.Req();
//            req.absPath = API.POSTS_STREAM_GET.toString();
            req.absPath = "http://localhost:5000/v1/post/stream";
            Http.Result res = Http.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                   /*TextView tv= (TextView)view.findViewById(R.id.loading);
                    tv.setText(res.data);*/
                    loadedPostsFromNet(res);

                });
            }
        });
    }

    private void loadedPostsFromNet(Http.Result res) {
        loading.setVisibility(View.GONE);
        content.setVisibility(View.VISIBLE);
        HomeStreamJson data= JsonUtil.fromJson(res.data, HomeStreamJson.class);
        if(data != null && data.Status.equalsIgnoreCase("OK")){
            HomeStreamAdaptor adaptor = new HomeStreamAdaptor();
            adaptor.posts = data.Payload;
            recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
            recycler_view.setAdapter(adaptor);
        }
    }

    public class HomeStreamAdaptor extends RecyclerView.Adapter<HomeStreamAdaptor.PostStreamHolder>{
        public List<HomeStreamRowJson> posts;

        @Override
        public PostStreamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = AppUtil.inflate(R.layout.row_post_stream,parent);
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

        public class PostStreamHolder extends RecyclerView.ViewHolder{
            HomeStreamRowJson post;
            @Bind(R.id.text) TextView text;
            @Bind(R.id.fullname) TextView user_name;
            @Bind(R.id.date) TextView date;
            @Bind(R.id.avatar) SimpleDraweeView avatar;
            @Bind(R.id.image) SimpleDraweeView image;
//            @Bind(R.id.comment_count) TextView comment_count;
            @Bind(R.id.comment_count) TextViewWithIcon comment_count;
//            @Bind(R.id.likes_count) TextView likes_count;
            @Bind(R.id.likes_count) TextViewWithIcon likes_count;
//            @Bind(R.id.cnts) TextViewWithIcon cnts;
//            @Bind(R.id.vvv) IconAnTextView vvv;

            Uri imageUri2;


            View.OnClickListener gotoLikes = (v)->{
                Nav.push(Router.getLikesPage(post.Id));
            };

            View.OnClickListener gotoComments = (v)->{
                Nav.push(Router.getCommontsPage(post.Id));
            };

            View.OnClickListener imagePopup = (v)->{
                FullScreenImage window = new FullScreenImage();
                window.text = post.Text;
                window.imageUri = imageUri2;
                window.show();
            };

            Runnable gotoProfile = ()->{

            };

            Runnable getGotoCommentsAdd = ()->{

            };

            public PostStreamHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }

            void bind(HomeStreamRowJson post){
                this.post = post;
                text.setText(LangUtil.limitText(post.Text,120));
                user_name.setText(post.Sender.FullName);
                date.setText(FormaterUtil.timeToDayTime(post.CreatedTime));
                Uri imageUri = Helper.PathToUserAvatarUri(post.Sender.AvatarUrl);
                avatar.setImageURI(imageUri);
                if(LangUtil.getRandom(3)% 2 ==0 ){
                    image.setVisibility(View.VISIBLE);
                    imageUri2 = Helper.PathToUserAvatarUri("/public/photo/"+LangUtil.getRandom(50) +"_960.jpg");
                    image.setImageURI(imageUri2);
                    image.setOnClickListener(imagePopup);
                }else {
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
                if(post.LikesCount>0){
                    likes_count.setTextAndIcon(post.LikesCount+"پسند","\uF443");
                }
                if(post.CommentsCount>0){
                    comment_count.setTextAndIcon(post.CommentsCount+"نظر","\uf11e");
                }

                likes_count.setOnClickListener(gotoLikes);
                comment_count.setOnClickListener(gotoComments);

//                cnts.setTextAndIcon("256 منه","\uF443");
            }
        }

    }
}
