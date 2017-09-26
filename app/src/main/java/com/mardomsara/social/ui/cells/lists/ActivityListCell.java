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

import com.mardomsara.social.R;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.lib.AppClickableSpan;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.Spanny;
import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.ui.X;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/26/2016.
 */
public class ActivityListCell {

    public static class ActivitiesAdaptor extends AppHeaderFooterRecyclerViewAdapter<TextHolder> {

        public List<JV.ActivityView> list = new ArrayList<>();
        public ActivitiesAdaptor(List<JV.ActivityView> list){
            super();
            if(list != null){
                this.list.addAll(list);
            }
        }


        @Override
        protected int getContentItemViewType(int position) {
//            return super.getContentItemViewType(position);
//            return list.get(position).ActionTypeId;
			return type_gen(list.get(position).ActionTypeId);
        }

        @Override
        protected int getContentItemCount() {
            return list.size();
        }

        @Override
        protected TextHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
			if (type_gen(contentViewType) == 1) {
				return new TextHolder(new NotifyCell(parent,contentViewType));
			} else {
				return new TextHolder(new X.NotifyNotSuportedCell(parent).root);
			}

        }

        @Override
        protected void onBindContentItemViewHolder(TextHolder textHolder, int position) {
//            textHolder.view.setText(LangUtil.limitText(list.get(position).PayloadStored,120));
			JV.ActivityView nf =list.get(position);
			if(textHolder.notifyCell != null){
				textHolder.notifyCell.bind(nf);
			}
        }

        static int type_gen(int contentViewType){
			if (contentViewType == Constants.NOTIFICATION_TYPE_POST_LIKED ||
				contentViewType == Constants.NOTIFICATION_TYPE_POST_COMMENTED ||
				contentViewType == Constants.NOTIFICATION_TYPE_FOLLOWED_YOU) {
				return 1;
			}
			return 0;
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

        void bind(JV.ActivityView nf){
            try {
//                nf.setloadFromStored();//json
                x.root.setVisibility(View.VISIBLE);
                _hideExtra();
                _setDate(nf.CreatedAt);
                x.text_main.setMovementMethod(LinkMovementMethod.getInstance());

                JV.UserInlineWithMeView actor = nf.Load.Actor;
                _setAvatar(actor);
                ////////////////////////////////////////////////
                // Posts: text_main,Photo,
                String tp ="";
                if(nf.ActionTypeId == Constants.NOTIFICATION_TYPE_POST_LIKED){
                    _bindLiked_11(nf);
                }

                if(nf.ActionTypeId == Constants.NOTIFICATION_TYPE_POST_COMMENTED){
                    _bindComment_21(nf);
                }

                if(nf.ActionTypeId == Constants.NOTIFICATION_TYPE_FOLLOWED_YOU){
                    _bindFollowing_1(nf);
                }
				//// TODO: 1/8/2017 set not supporetd upgrade message
			}catch (Exception e){
                e.printStackTrace();
                x.root.setVisibility(View.GONE);//if we break hide view
            }
        }

        //////////////// Notifications Types binders ///////////////

        void _bindComment_21(JV.ActivityView nf){
            JV.PostView post = nf.Load.Post;
            Spanny spanny = _getProfileSpany(nf.Load.Actor); //new Spanny(s, new StyleSpan(Typeface.BOLD), goToProfileSpan(uid));
            String tp ="";

			if(post.TypeId == Constants.POST_TYPE_PHOTO){//post
				spanny.append(" بر روی عکس ");
				spanny.append(StrHelper.getMeYouOrOthers_OfPostComment(nf));

				tp = "نظر داد: \"@$\".";
				tp = tp.replace("@$",nf.Load.Comment.Text);

				_setPostImage(post.PhotoView);
				_showExtraImage();

				spanny.append(tp);

				x.text_main.setText(spanny);
				x.root.setOnClickListener((v)->Router.goToPost(nf.Load.Post));

			}else {//others
				spanny.append(" بر روی پست ");
				spanny.append(StrHelper.getMeYouOrOthers_OfPostComment(nf));

				tp = "\"%\" نظر داد: \"@$\".";
				tp = tp.replace("%",LangUtil.limitText(nf.Load.Post.Text,30));
				tp = tp.replace("@$",LangUtil.limitText(nf.Load.Comment.Text,40));

				_hideExtra();

				spanny.append(tp);

				x.text_main.setText(spanny);
				x.root.setOnClickListener((v)->Router.goToPost(nf.Load.Post));
			}

        }

        void _bindLiked_11(JV.ActivityView nf){
            JV.PostView post = nf.Load.Post;
            JV.UserInlineWithMeView actor = nf.Load.Actor;
//            _setAvatar(actor);
            Spanny spanny = _getProfileSpany(actor); //new Spanny(s, new StyleSpan(Typeface.BOLD), goToProfileSpan(uid));
            String tp ="";


			if(post.TypeId == Constants.POST_TYPE_PHOTO){//post
				spanny.append(" عکس ");
				spanny.append(StrHelper.getMeYouOrOthers_OfPostLike(nf));

				tp = " را پسندید.";
				_setPostImage(post.PhotoView);
				_showExtraImage();

				spanny.append(tp);

				x.text_main.setText(spanny);
				x.root.setOnClickListener((v)->Router.goToPost(nf.Load.Post));
				return;

			}else {//others
				spanny.append(" پست ");
				spanny.append(StrHelper.getMeYouOrOthers_OfPostLike(nf));

				tp = ": \"$\" را پسندید.";
				tp = tp.replace("$",LangUtil.limitText(nf.Load.Post.Text,30));

				_hideExtra();

				spanny.append(tp);

				x.text_main.setText(spanny);
				x.root.setOnClickListener((v)->Router.goToPost(nf.Load.Post));
			}

        }

        void _bindFollowing_1(JV.ActivityView nf){
            String tp ="";
            JV.UserInlineWithMeView actor = nf.Load.Actor;
            Spanny spanny = StrHelper._getProfileSpanyWithSpace(actor);

			CharSequence o;
			if(Session.getUserId() == nf.RootId){
				o =   " " +"شما";
			}else {
				o = StrHelper._getSpanyProfile(nf.Load.Followed.FullName +" ",nf.Load.Followed.UserId );
			}
			spanny.append(o);

            tp = " را دنبال می کند.";
            spanny.append(tp);

			_showExtraFollowing(nf.Load.Followed);

            x.root.setOnClickListener((v)->Router.goToProfile(nf.Load.Followed.UserId));
			x.text_main.setText(spanny);
        }

        //////////////// Helpers /////////////////////

        static int dp50px = AndroidUtil.dpToPx(75);
        void _setPostImage(JV.PhotoView photo){
            x.image_extra.setVisibility(View.VISIBLE);
			String url = Helper.postsGetBestPhotoResUrl(photo,dp50px);
			if( !LangUtil.stringEmpty(url)){
				Picasso.with(AppUtil.getContext())
					.load(url)
					.resize(dp50px,dp50px)
					.centerCrop()
					.into(x.image_extra);
			}else {//empty image
				Picasso.with(AppUtil.getContext())
					.load(R.drawable.holder_recent_image)
					.resize(dp50px,dp50px)
					.centerCrop()
					.into(x.image_extra);
			}
        }

        void _setDate(int time){
//            date.setText(FormaterUtil.timeToDayTime(time));
			x.date.setText(FormaterUtil.timeAgo(time));
        }

        void _setAvatar(JV.UserInlineWithMeView Actor){
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

        void _showExtraFollowing(JV.UserInlineWithMeView userInlineWithMeView){
			x.frame_layout.setVisibility(View.VISIBLE);
			x.image_extra.setVisibility(View.GONE);
			x.following_button.setVisibility(View.VISIBLE);
			x.following_button.setUser(userInlineWithMeView);
        }

        Spanny _getProfileSpany(JV.UserInlineWithMeView Actor){
            /////////////////////////
            String s = Actor.FullName;
            int uid = Actor.UserId;
            Spanny spanny = new Spanny(s, new StyleSpan(Typeface.BOLD), goToProfileSpan(uid));
            return spanny;
        }

		Spanny _getSpanyProfile(String name, int UserId){
			/////////////////////////
			Spanny spanny = new Spanny(name, new StyleSpan(Typeface.BOLD), goToProfileSpan(UserId));
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

    private static class StrHelper {
		static CharSequence getMeYouOrOthers_OfPostComment(JV.ActivityView nf){
			CharSequence o ;
			if(Session.getUserId() == nf.Load.Post.UserId){
				o = "شما ";
			}else if(nf.Load.Post.UserId == nf.Load.Comment.Id){
				o = "خودش ";
			}else {
				o = _getSpanyProfile(nf.Load.Post.Sender.FullName +" ",nf.Load.Post.Sender.UserId );
			}
			return o;
		}

		static CharSequence getMeYouOrOthers_OfPostLike(JV.ActivityView nf){
			CharSequence o ;
			if(Session.getUserId() == nf.Load.Post.UserId){
				o = "شما";
			}else if(nf.Load.Post.UserId == nf.Load.Actor.UserId){
				o = "خودش";
			}else {
				o = _getSpanyProfile(nf.Load.Post.Sender.FullName +"",nf.Load.Post.Sender.UserId );
			}
			return o;
		}

		static Spanny _getSpanyProfile(String name, int UserId){
			/////////////////////////
			Spanny spanny = new Spanny(name, new StyleSpan(Typeface.BOLD), goToProfileSpan(UserId));
			return spanny;
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

		static Spanny _getProfileSpanyWithSpace(JV.UserInlineWithMeView Actor){
			/////////////////////////
			String s = Actor.FullName;
			int uid = Actor.UserId;
			Spanny spanny = new Spanny(s+ " ", new StyleSpan(Typeface.BOLD), goToProfileSpan(uid));
			return spanny;
		}
	}
}
