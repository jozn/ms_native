package com.mardomsara.social.ui.presenter.social;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.json.social.rows.CommentRowJson;
import com.mardomsara.social.json.social.http.CommentSingleJson;
import com.mardomsara.social.json.social.http.CommentsListJson;
import com.mardomsara.social.lib.PagerRecyclerViewAdapter;
import com.mardomsara.social.models.Comment;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.wigets.LoadingView;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/25/2016.
 */
@Deprecated
public class CommontsPresnter_DEP extends BasePresenter
        implements PagerRecyclerViewAdapter.LoadNextPage,
            SimpleAddText.OnAddText{
    int postId = 0;
    @Bind(R.id.simpleTopNav)
    SimpleTopNav simpleTopNav;

    @Bind(R.id.loadingView)
    LoadingView loadingView;

    @Bind(R.id.simpleAddText)
    SimpleAddText simpleAddText;

    ///////////////////////////////
    boolean isNextPages = false;
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true);
    RecyclerView recyclerView = ViewHelper.newRecyclerViewWraped();
    CommentsAdaptor adaptor;

    ///////////////////////////////

    public CommontsPresnter_DEP(int postId ) {
        this.postId = postId;
        adaptor = new CommentsAdaptor(postId);
    }

    @Override
    public View buildView() {
        View view = AppUtil.inflate(R.layout.presenter_commonts);
        ButterKnife.bind(this,view);
//        loadCommontsFromNet();
        load();
        simpleAddText.setOnAddListener(this);
        return view;
    }

    int page = 0;
    private void load() {
        CommontsPresnter_DEP that = this;
        recyclerView.setAdapter(adaptor);
//                layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adaptor.setupWith(recyclerView, layoutManager, that);
                        adaptor.listenOnScroll();

        loadCommontsFromNet();
//        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager){
//
//                    @Override
//                    public void onLoadMore(int page, int totalItemsCount) {
//                        loadCommontsFromNet();
//                    }
//                });
    }
    private void loadCommontsFromNet() {
        AndroidUtil.runInBackground(()->{
            Http.Req req = new Http.Req();
            req.absPath = API.COMMENTS_LIST_GET.toString();
            req.urlParams.put("post_id",""+postId);
            req.urlParams.put("page",""+page);
            page++;
            Http.Result res = Http.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                    loadedCommentsFromNet(res);
                });
            }
        });
    }


    private void loadedCommentsFromNet(Http.Result res) {


        CommentsListJson data = JsonUtil.fromJson(res.data, CommentsListJson.class);
        if(!isNextPages){
            isNextPages = true;
            if(data != null && data.Status.equalsIgnoreCase("OK") && data.Payload!=null){

                adaptor.list= data.Payload;
                recyclerView.setAdapter(adaptor);
                recyclerView.setLayoutManager(layoutManager);
                loadingView.replace(recyclerView);
            }else {
                adaptor.setHasMorePage(false);
                //todo error
            }
        }else {
            if(data != null && data.Status.equalsIgnoreCase("OK") && data.Payload!=null){
                adaptor.list.addAll(data.Payload);
                adaptor.notifyDataSetChanged();
            }else {
                adaptor.setHasMorePage(false);
            }
        }

    }

    @Override
    public void loadNextPage() {
        AppUtil.log("loadNextPage()");
        loadCommontsFromNet();
    }

    @Override
    public void onAddText(String text) {
        addNewComment(text);
    }

    public void addNewComment(String text) {
//        Helper.showMessage(text);
        CommentRowJson comment = new CommentRowJson();
        comment.Sender = Session.buildUserSender();
        comment.PostId = postId;
        comment.UserId = Session.getUserId();
        comment.CreatedTime = (int)TimeUtil.getTime();
        comment.Text = text;
        comment._isNew=true;

        adaptor.list.add(0,comment);
        adaptor.notifyDataSetChanged();

        AndroidUtil.runInBackgroundNoPanic(()->{
            Http.Req req = new Http.Req();
            req.absPath = API.COMMENTS_ADD.toString();
            req.form.put("post_id",""+postId);
            req.form.put("text",""+text);
            Http.Result res = Http.masterSendPost(req);
            boolean isError = false;
            if(res.ok){
                CommentSingleJson data = JsonUtil.fromJson(res.data,CommentSingleJson.class);
                if(data != null && data.Payload != null && data.Status.equalsIgnoreCase("OK")){
//                    Helper.showMessage(data.Load.toString());
                    comment.Id = data.Payload.Id;
                    comment.CreatedTime = data.Payload.CreatedTime;
                    comment._isNew=false;
                    AndroidUtil.runInUi(()->{
                        adaptor.notifyDataSetChanged();
                    });
                }else {
                    isError = true;
                }
            }else {
                isError = true;
            }

            if(isError){
                Helper.showMessage("خطا در ثبت نظر");
                comment._isNew=false;
                AndroidUtil.runInUi(()->{
                    adaptor.notifyDataSetChanged();
                });
            }

        });
    }

    public static class CommentsAdaptor extends PagerRecyclerViewAdapter{
        int _postId=0;
        public List<CommentRowJson> list;

        public CommentsAdaptor(int _postId) {
            this._postId = _postId;
        }

        @Override
        protected int getContentItemCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        protected RecyclerView.ViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            return new CommentRowViewHolder(AppUtil.inflate(R.layout.row_commont,parent));
        }

        @Override
        protected void onBindContentItemViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            ((CommentRowViewHolder)viewHolder).bind(list.get(position));
        }

        @Override
        protected void loadNextPage() {

        }

        public class CommentRowViewHolder extends RecyclerView.ViewHolder{
            @Bind(R.id.avatar) SimpleDraweeView avatar;
            @Bind(R.id.fullname) TextView fullname;
            @Bind(R.id.date) TextView date;
            @Bind(R.id.text) TextView text;
            @Bind(R.id.loadingView) View loading;

            CommentRowJson comment;

            View.OnLongClickListener onLong = (v)->{
                openMoreOptionDialog(comment);
                return true;
            };

            View.OnClickListener gotoProfile = (v)->{
                Nav.push(new ProfilePresenter(comment.UserId));
            };

            public CommentRowViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);

                itemView.setOnLongClickListener(onLong);
                fullname.setOnClickListener(gotoProfile);
                avatar.setOnClickListener(gotoProfile);
            }
            int i =0;
            void bind(CommentRowJson commont){
                this.comment = commont;

                fullname.setText(commont.Sender.FullName);
                date.setText("2 روز قبل"+ i);
                i++;
                text.setText(commont.Text);
                Helper.SetAvatar(avatar, commont.Sender.AvatarUrl);

                if(commont._isNew){
                    loading.setVisibility(View.VISIBLE);
                }else {
                    loading.setVisibility(View.GONE);
                }

//                loading.startAnimation();

            }

            void openMoreOptionDialog(CommentRowJson commont){
                List<DialogHelper.MenuItem> items = new ArrayList<>();
                items.add(new DialogHelper.MenuItem("کپی متن",(v)->{
                    AndroidUtil.copyTextToClipboard(commont.Text,true);
                }));

                if(Session.getUserId() == commont.UserId){
                    items.add(new DialogHelper.MenuItem("حذف نظر",(v)->{
                        Comment.serverRemoveComment(commont.Id,_postId);
                        list.remove(commont);
                        notifyDataSetChanged();
                    }));
                }


                /*items.add(new DialogHelper.MenuItem("پاسخ دادن",(v)->{

                }));*/

                DialogHelper.simpleMenu(items);
            }
        }
    }


}

/*
public static class CommentsAdaptor extends RecyclerView.Adapter<CommentsAdaptor.CommentRowViewHolder>{

    public List<CommentRowJson> list;
    @Override
    public CommentRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentRowViewHolder(AppUtil.inflate(R.layout.row_commont,parent));
    }

    @Override
    public void onBindViewHolder(CommentRowViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class CommentRowViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.avatar) SimpleDraweeView avatar;
        @Bind(R.id.fullname) TextView fullname;
        @Bind(R.id.date) TextView date;
        @Bind(R.id.text) TextView text;


        CommentRowJson comment;
        public CommentRowViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        void bind(CommentRowJson commont){
            this.comment = commont;

            fullname.setText(commont.Sender.FullName);
            date.setText("2 روز قبل");
            text.setText(commont.Text);
            Helper.SetAvatar(avatar, commont.Sender.AvatarUrl);

        }
    }
}
*/


/*
    private void loadCommontsFromNet_bk() {
        AndroidUtil.runInBackground(()->{
            Http.Req req = new Http.Req();
            req.absUrl = API.COMMENTS_LIST_GET.toString();
            req.urlQueryParams.put("post_id",""+postId);
            req.urlQueryParams.put("page",""+0);
            Http.Result res = Http.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                    loadedCommentsFromNet(res);
                });
            }
        });

    }
*/

