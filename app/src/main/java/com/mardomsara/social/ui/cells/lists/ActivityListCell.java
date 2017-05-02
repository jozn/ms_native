package com.mardomsara.social.ui.cells.lists;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.social.rows.ActivityRowJson;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.lib.AppClickableSpan;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.Spanny;
import com.mardomsara.social.models.tables.Notify;
import com.mardomsara.social.ui.X;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/26/2016.
 */
public class ActivityListCell {

    public static class ActivitiesAdaptor extends AppHeaderFooterRecyclerViewAdapter<TextHolder> {

        public List<ActivityRowJson> list = new ArrayList<>();
        public ActivitiesAdaptor(List<ActivityRowJson> list){
            super();
            if(list != null){
                this.list.addAll(list);
            }
        }


        @Override
        protected int getContentItemViewType(int position) {
//            return super.getContentItemViewType(position);
            return list.get(position).ActionTypeId;
        }

        @Override
        protected int getContentItemCount() {
            return list.size();
        }

        @Override
        protected TextHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
			if (contentViewType == Constants.NOTIFICATION_TYPE_POST_LIKED ||
				contentViewType == Constants.NOTIFICATION_TYPE_POST_COMMENTED ||
				contentViewType == Constants.NOTIFICATION_TYPE_FOLLOWED_YOU) {
				return new TextHolder(new NotifyCell(parent,contentViewType));
			} else {
				return new TextHolder(new X.NotifyNotSuportedCell(parent).root);
			}

        }

        @Override
        protected void onBindContentItemViewHolder(TextHolder textHolder, int position) {
//            textHolder.view.setText(LangUtil.limitText(list.get(position).PayloadStored,120));
			ActivityRowJson nf =list.get(position);
			if(textHolder.notifyCell != null){
				textHolder.notifyCell.bind(nf);
			}
        }
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        TextView view;
        NotifyCell notifyCell;
        public TextHolder(NotifyCell notifyCell) {
            super(notifyCell.x.root);
            this.notifyCell = notifyCell;
        }

		//or empty
		public TextHolder(View itemView) {
			super(itemView);
		}
	}

    public static class NotifyCell {
		X.Actions_Row x;

        public NotifyCell(ViewGroup parent,int contentViewType) {
			x = new X.Actions_Row(parent);

        }

        void bind(ActivityRowJson nf){
            try {
//                nf.setloadFromStored();//json
                x.root.setVisibility(View.VISIBLE);
                _hideExtra();
                _setDate(nf.CreatedAt);
                x.text_main.setMovementMethod(LinkMovementMethod.getInstance());

                UserInfoJson actor = nf.Load.Actor;
                _setAvatar(actor);
                ////////////////////////////////////////////////
                // Posts: text_main,Photo,
                String tp ="";
                if(nf.ActionTypeId == Constants.NOTIFICATION_TYPE_POST_LIKED){
                    _bindLiked(nf);
                }

                if(nf.ActionTypeId == Constants.NOTIFICATION_TYPE_POST_COMMENTED){
                    _bindComment(nf);
                }

                if(nf.ActionTypeId == Constants.NOTIFICATION_TYPE_FOLLOWED_YOU){
                    _bindFollowing(nf);
                }
				//// TODO: 1/8/2017 set not supporetd upgrade message
			}catch (Exception e){
                e.printStackTrace();
                x.root.setVisibility(View.GONE);//if we break hide view
            }
        }

        //////////////// Notifications Types binders ///////////////

        void _bindPost(Notify nf){}
        void _bindPostText(Notify nf){}
        void _bindPostPhoto(Notify nf){}

        void _bindComment(ActivityRowJson nf){
            PostRowJson post = nf.Load.Post;
            Spanny spanny = _getProfileSpany(nf.Load.Actor); //new Spanny(s, new StyleSpan(Typeface.BOLD), goToProfileSpan(uid));
            String tp ="";
            if(post != null){//must never happen
                tp = " بر روی پست شما: \"%\" نظر داد: \"@$\".";
                tp = tp.replace("%",LangUtil.limitText(nf.Load.Post.Text,40));
                if(post.TypeId == Constants.POST_TYPE_PHOTO){
                    tp = " بر روی عکس شما: \"%\" نظر داد: \"@$\".";
                    tp = tp.replace("%",LangUtil.limitText(nf.Load.Post.Text,40));
                    _setPostImage(post.MediaUrl);
                    _showExtraImage();
                }else {
                    x.image_extra.setVisibility(View.GONE);
                }
                if(nf.Load.Comment!= null){
                    tp = tp.replace("@$",nf.Load.Comment.Text);
                }
                spanny.append(tp);
                x.root.setOnClickListener((v)->Router.goToPost(nf.Load.Post));
                x.text_main.setText(spanny);
                x.root.setOnClickListener((v)->Router.goToPost(nf.Load.Post));
            }
        }

        void _bindLiked(ActivityRowJson nf){
            PostRowJson post = nf.Load.Post;
            UserInfoJson actor = nf.Load.Actor;
//            _setAvatar(actor);
            Spanny spanny = _getProfileSpany(actor); //new Spanny(s, new StyleSpan(Typeface.BOLD), goToProfileSpan(uid));
            String tp ="";
            if(post != null){//must never happen
                tp = " پست شما: \"%\" را پسندید.";
                tp = tp.replace("%",LangUtil.limitText(nf.Load.Post.Text,40));
                if(post.TypeId == Constants.POST_TYPE_PHOTO){
                    tp = " عکس شما: \"%\" را پسندید.";
                    tp = tp.replace("%",LangUtil.limitText(nf.Load.Post.Text,40));
                    _setPostImage(post.MediaUrl);
                    _showExtraImage();
//                    image_extra.setVisibility(View.VISIBLE);
                }else {
                    x.image_extra.setVisibility(View.GONE);
                }
                spanny.append(tp);
                x.text_main.setText(spanny);
                x.root.setOnClickListener((v)->Router.goToPost(nf.Load.Post));
            }
        }
        void _bindFollowing(ActivityRowJson nf){
            String tp ="";
            UserInfoJson actor = nf.Load.Actor;
            Spanny spanny = _getProfileSpany(actor);
            tp = " شما را دنبال می کند.";
            spanny.append(tp);
            _showExtraFollowing();
            x.root.setOnClickListener((v)->Router.goToProfile(actor.UserId));
			x.text_main.setText(spanny);
        }

        //////////////// Helpers /////////////////////

        int dp50px = AndroidUtil.dpToPx(50);
        void _setPostImage(String url){
            x.image_extra.setVisibility(View.VISIBLE);
            Picasso.with(AppUtil.getContext())
                    .load("http://localhost:5000/"+url)
                    .resize(dp50px,dp50px)
                    .centerCrop()
                    .into(x.image_extra);
        }

        void _setDate(int time){
//            date.setText(FormaterUtil.timeToDayTime(time));
			x.date.setText(FormaterUtil.timeAgo(time));
        }

        void _setAvatar(UserInfoJson Actor){
			x.avatar_image.setOnClickListener((v)-> Router.goToProfile(Actor.UserId));
            Helper.SetAvatar(x.avatar_image, Actor.AvatarUrl);
			x.avatar_image.setOnClickListener((v)-> Router.goToProfile(Actor.UserId));
        }

        void _hideExtra(){
			x.frame_layout.setVisibility(View.GONE);
        }

        void _showExtraImage(){
			x.frame_layout.setVisibility(View.VISIBLE);
			x.image_extra.setVisibility(View.VISIBLE);
			x.following_button.setVisibility(View.GONE);
        }

        void _showExtraFollowing(){
			x.frame_layout.setVisibility(View.VISIBLE);
			x.image_extra.setVisibility(View.GONE);
			x.following_button.setVisibility(View.VISIBLE);
        }

        Spanny _getProfileSpany(UserInfoJson Actor){
            /////////////////////////
            String s = Actor.getFullName();
            int uid = Actor.UserId;
            Spanny spanny = new Spanny(s, new StyleSpan(Typeface.BOLD), goToProfileSpan(uid));
            return spanny;
        }

        static ClickableSpan buildclick(final CharSequence s){

            ClickableSpan clickableSpan = new AppClickableSpan() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(AppUtil.getContext(), s, Toast.LENGTH_LONG).show();
                }
            };
            return clickableSpan;
        }

        static ClickableSpan goToProfileSpan(final int s){

            AppClickableSpan clickableSpan = new AppClickableSpan() {
                @Override
                public void onClick(View view) {
                    Router.goToProfile(s);
                }
            };
            return clickableSpan;
        }
    }
}
