package com.mardomsara.social.ui.presenter.social;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.CommentRowJson;
import com.mardomsara.social.json.social.CommentSingleJson;
import com.mardomsara.social.json.social.CommentsListJson;
import com.mardomsara.social.lib.PagerRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.wigets.LoadingView;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/25/2016.
 */
public class CommontsPresnter extends BasePresenter
        implements PagerRecyclerViewAdapter.LoadNextPage,
            SimpleAddText.OnAddText{
    int postId = 0;
    @Bind(R.id.simpleTopNav)
    SimpleTopNav simpleTopNav;

    @Bind(R.id.loadingView)
    LoadingView loadingView;

    @Bind(R.id.simpleAddText)
    SimpleAddText simpleAddText;

    public CommontsPresnter(int postId ) {
        this.postId = postId;
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
        CommontsPresnter that = this;
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


    boolean isNextPages = false;
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true);
    RecyclerView recyclerView = ViewHelper.newRecyclerViewWraped();
    CommentsAdaptor adaptor = new CommentsAdaptor();


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
        Helper.showMessage(text);

        AndroidUtil.runInBackgroundNoPanic(()->{
            Http.Req req = new Http.Req();
            req.absPath = API.COMMENTS_ADD.toString();
            req.form.put("post_id",""+postId);
            req.form.put("text",""+text);
            Http.Result res = Http.masterSendPost(req);
            boolean isError = false;
            if(res.ok){
                CommentSingleJson data = JsonUtil.fromJson(res.data,CommentSingleJson.class);
                if(data != null && data.Status.equalsIgnoreCase("OK")){
                    Helper.showMessage(data.Payload.toString());
                }else {
                    isError = true;
                }
            }else {
                isError = true;
            }

            if(isError){
                Helper.showMessage("خطا در ثبت نظر");
            }

        });
    }

    public static class CommentsAdaptor extends PagerRecyclerViewAdapter{

        public List<CommentRowJson> list;

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
            req.absPath = API.COMMENTS_LIST_GET.toString();
            req.urlParams.put("post_id",""+postId);
            req.urlParams.put("page",""+0);
            Http.Result res = Http.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                    loadedCommentsFromNet(res);
                });
            }
        });

    }
*/

