package com.mardomsara.social.ui.cells.lists;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mardomsara.social.App;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.lib.AppClickableSpan;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.Spanny;
import com.mardomsara.social.models.NotifyModel;
import com.mardomsara.social.models.events.NotifyAddedEvent;
import com.mardomsara.social.models.events.NotifyChanged;
import com.mardomsara.social.models.tables.Notify;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/26/2016.
 */
public class NotifyListCell
        implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

    public NotifyRVAdaptor adaptor;
    public SwipeRefreshLayout refreshLayout;
	public RecyclerView recycler_view;

    public List<Notify> list = new ArrayList<>();

    public NotifyListCell() {
        init();
    }

    private void init() {
        refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT, ViewHelper.MATCH_PARENT);
        adaptor = new NotifyRVAdaptor(list);
        recycler_view = ViewHelper.newRecyclerViewMatch();
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setRecyclerView(recycler_view);
        adaptor.setUpForPaginationWith(recycler_view, layoutManager, this);
        adaptor.showLoading();

		App.getBus().register(this);

		refreshLayout.addView(recycler_view);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
				NotifyModel.fetchSyncLasts();
                Helper.showDebugMessage("re");
            }
        });
		AndroidUtil.runInUi(()->{
			load();
		});

    }

	public void destroy(){
		App.getBus().unregister(this);
	}

    public ViewGroup getViewRoot() {
        return refreshLayout;
    }


    public NotifyRVAdaptor getAdaptor() {
        return adaptor;
    }


    @Override
    public void loadNextPage(int pageNum) {
        Helper.showDebugMessage("pageNum: "+pageNum);
    }

	@Subscribe(threadMode = ThreadMode.MAIN)
	void event(NotifyChanged notifyChanged){
		load();
		Helper.showDebugMessage("event: NotifyChanged");
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	void event(NotifyAddedEvent notifyChanged){
		Helper.showDebugMessage("event: NotifyAddedEvent");
		if(notifyChanged.notify == null){
			Helper.showDebugMessage("event: NotifyAddedEvent is null");
			return;
		}
		list.add(0,notifyChanged.notify);
		adaptor.notifyDataChanged();
	}

	void load(){
		List<Notify> list0 = NotifyModel.getAllReverse();

		list.clear();
		list.addAll(list0);


		refreshLayout.setRefreshing(false);
		adaptor.hideLoading();
		adaptor.notifyDataChanged();
	}


	//////////////////////////////////////////////////////////
	///////////////////// Other Classes //////////////////////

    public static class NotifyRVAdaptor extends AppHeaderFooterRecyclerViewAdapter<RecyclerView.ViewHolder> {

        List<Notify> list = new ArrayList<>();
        public NotifyRVAdaptor(@NonNull List<Notify> list){
            super();
			this.list = list;
        }


        @Override
        protected int getContentItemViewType(int position) {
//            return super.getContentItemViewType(position);
            return list.get(position).ActionTypeId;
        }

        @Override
        protected int getContentItemCount() {
//			Helper.showDebugMessage("size: "+list.size());
            return list.size();
        }

        @Override
        protected RecyclerView.ViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
			if (contentViewType == Constants.NOTIFICATION_TYPE_POST_LIKED ||
				contentViewType == Constants.NOTIFICATION_TYPE_POST_COMMENTED ||
				contentViewType == Constants.NOTIFICATION_TYPE_FOLLOWED_YOU){

				return new TextHolder(new NotifyCell(parent));
			}else {
				return  new NotSupported(new X.NotifyNotSuportedCell(parent).root);
			}
        }

        @Override
        protected void onBindContentItemViewHolder(RecyclerView.ViewHolder textHolder, int position) {
			if(textHolder instanceof TextHolder){
				Notify nf =list.get(position);
				((TextHolder) textHolder).notifyCell.bind(nf);
			}
        }
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        TextView view;
        NotifyCell notifyCell;
        public TextHolder(NotifyCell notifyCell) {
            super(notifyCell.viewRoot);
            this.notifyCell = notifyCell;
        }
    }

	public static class NotSupported extends RecyclerView.ViewHolder{
		public NotSupported(View notifyCell) {
			super(notifyCell);
		}
	}

    public static class NotifyCell {
        View viewRoot;

        @Bind(R.id.avatar) ImageView avatar_image;
        @Bind(R.id.frame_layout) FrameLayout frame_layout;
        @Bind(R.id.image_extra) ImageView image_extra;
        @Bind(R.id.following_button) View following_button;
        @Bind(R.id.text) TextView text_main;
        @Bind(R.id.date) TextView date;

        public NotifyCell(ViewGroup parent) {
            viewRoot = AppUtil.inflate(R.layout.notify_cell ,parent);
            ButterKnife.bind(this,viewRoot);
        }


        void bind(Notify nf){
            try {
                nf.setloadFromStored();//json
                viewRoot.setVisibility(View.VISIBLE);
                _hideExtra();
                _setDate(nf.CreatedTime);

				//// FIXME: 1/20/2017 dont set to not macke problem for to go or post entry
				/// must set .setMovementMethod to something custom to pass tap to higher views if
				//not handeled
//				text_main.setMovementMethod(LinkMovementMethod.getInstance());

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
            }catch (Exception e){
                e.printStackTrace();
                viewRoot.setVisibility(View.GONE);//if we break hide view
            }
        }

        //////////////// Notifications Types binders ///////////////

        void _bindPost(Notify nf){}
        void _bindPostText(Notify nf){}
        void _bindPostPhoto(Notify nf){}

        void _bindComment(Notify nf){
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
                    image_extra.setVisibility(View.GONE);
                }
                if(nf.Load.Comment!= null){
                    tp = tp.replace("@$",nf.Load.Comment.Text);
                }
                spanny.append(tp);
//                viewRoot.setOnClickListener((v)->Router.goToPost_PartialData(nf.Load.Post));
                text_main.setText(spanny);
                viewRoot.setOnClickListener((v)->Router.goToPost_PartialData(nf.Load.Post));
            }
        }

        void _bindLiked(Notify nf){
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
                    image_extra.setVisibility(View.GONE);
                }
                spanny.append(tp);
                text_main.setText(spanny);
                viewRoot.setOnClickListener((v)->Router.goToPost_PartialData(nf.Load.Post));
            }
        }
        void _bindFollowing(Notify nf){
            String tp ="";
            UserInfoJson actor = nf.Load.Actor;
            Spanny spanny = _getProfileSpany(actor);
            tp = " شما را دنبال می کند.";
            spanny.append(tp);
            _showExtraFollowing();
            viewRoot.setOnClickListener((v)->Router.goToProfile(actor.getUserId()));
            text_main.setText(spanny);
        }

        //////////////// Helpers /////////////////////

        int dp50px = AndroidUtil.dpToPx(50);
        void _setPostImage(String url){
            image_extra.setVisibility(View.VISIBLE);
            Picasso.with(AppUtil.getContext())
                    .load("http://localhost:5000/"+url)
                    .resize(dp50px,dp50px)
                    .centerCrop()
                    .into(image_extra);
        }

        void _setDate(int time){
//            date.setText(FormaterUtil.timeToDayTime(time));
            date.setText(FormaterUtil.timeAgoWithDateForTooFar(time));
        }

        void _setAvatar(UserInfoJson Actor){
            avatar_image.setOnClickListener((v)-> Router.goToProfile(Actor.UserId));
            Helper.SetAvatar(avatar_image, Actor.AvatarUrl);
            avatar_image.setOnClickListener((v)-> Router.goToProfile(Actor.UserId));
        }

        void _hideExtra(){
            frame_layout.setVisibility(View.GONE);
        }

        void _showExtraImage(){
            frame_layout.setVisibility(View.VISIBLE);
            image_extra.setVisibility(View.VISIBLE);
            following_button.setVisibility(View.GONE);
        }

        void _showExtraFollowing(){
            frame_layout.setVisibility(View.VISIBLE);
            image_extra.setVisibility(View.GONE);
            following_button.setVisibility(View.VISIBLE);
        }

        Spanny _getProfileSpany(UserInfoJson Actor){
            /////////////////////////
            String s = Actor.getFullName();
            int uid = Actor.getUserId();
			//// FIXME: 1/20/2017 if we set profile instan
//            Spanny spanny = new Spanny(s, new StyleSpan(Typeface.BOLD), goToProfileSpan(uid));
            Spanny spanny = new Spanny(s, new StyleSpan(Typeface.BOLD));
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


