package com.mardomsara.social.ui.cells.lists;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.CommentRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.ui.cells.rows.CommentRowCell;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/26/2016.
 */
public class CommentsListCell implements  AppHeaderFooterRecyclerViewAdapter.LoadNextPage {
    SimpleAddText simpleAddText;
    boolean isNextPages = false;
    public LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext(),LinearLayoutManager.VERTICAL,true);
    RecyclerView recyclerView = ViewHelper.newRecyclerViewMatch();
    public CommentsAdaptor adaptor;

    int postId;
    public CommentsListCell(int postId) {
        this.postId = postId;
        adaptor = new CommentsAdaptor(postId);
        load();
    }

    private void load() {
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(layoutManager);
        adaptor.setUpForPaginationWith(recyclerView,layoutManager,this);
//        adaptor.listenOnScroll();

//        loadCommentsFromNet(0);
    }

    public void setLayoutManagerOrintation(int orintation){
        layoutManager.setOrientation(orintation);
    }

    private void loadCommentsFromNet(int page) {
        AndroidUtil.runInBackground(()->{
            Http.getPath("/v1/comments/list")
				.setQueryParam("post_id",""+postId)
				.setQueryParam("page",""+page)
				.doAsyncUi((result -> {
					adaptor.nextPageIsLoaded();

					if(result.isOk()){
						HttpJsonList<CommentRowJson> data = Result.fromJsonList(result,CommentRowJson.class);
						if(data.isPayloadNoneEmpty()){
							if(page== 1){
								adaptor.list.clear();
							}
							adaptor.list.addAll(data.Payload);
//							scrollToEnd();
						}else {
							adaptor.setHasMorePage(false);
						}
						adaptor.notifyDataSetChanged();
					}

				}));
        });
    }

	void scrollToEnd(){
		layoutManager.scrollToPositionWithOffset(0,10000);
	}

    @Override
    public void loadNextPage(int pageNum) {
		Helper.showDebugMessage("page comment: "+pageNum);
        loadCommentsFromNet(pageNum);
    }

    public ViewGroup getViewRoot() {
        return recyclerView;
    }

	public void addNewCommentByMe(String text){
		Helper.showDebugMessage(text);
		CommentRowJson comment = new CommentRowJson();
		comment.Sender = Session.buildUserSender();
		comment.PostId = postId;
		comment.UserId = Session.getUserId();
		comment.CreatedTime = (int) TimeUtil.getTimeSec();
		comment.Text = text;
		comment._isNew=true;

		adaptor.list.add(0,comment);
		adaptor.notifyDataSetChanged();

		AndroidUtil.runInBackgroundNoPanic(()->{
			Http.postPath("/v1/comments/add")
				.setFormParam("post_id",""+postId)
				.setFormParam("text",""+text)
				.doAsyncUi((res -> {
					boolean isError = false;
					if(res.isOk()){

						HttpJson<CommentRowJson> data = Result.fromJson(res,CommentRowJson.class);
						if(data != null && data.isPayloadNoneEmpty() && data.Status.equalsIgnoreCase("OK")){
//                    Helper.showMessage(data.Load.toString());
							comment.Id = data.Payload.Id;
							comment.CreatedTime = data.Payload.CreatedTime;
							comment._isNew=false;
							scrollToEnd();
							adaptor.notifyDataSetChanged();
						}else {
							isError = true;
						}
					}else {
						isError = true;
					}

					if(isError){
						Helper.showMessage("خطا در ثبت نظر");
						comment._isNew=false;
						adaptor.notifyDataSetChanged();
					}
				}));
		});
	}

    public static class CommentsAdaptor extends AppHeaderFooterRecyclerViewAdapter<CommentsAdaptor.CommentRowViewHolder> {
        public int postId = 0;
        public List<CommentRowJson> list = new ArrayList<>();

        public CommentsAdaptor(int _postId) {
            this.postId = _postId;
        }

        @Override
        protected int getContentItemCount() {
            return list.size();
        }

        @Override
        protected CommentRowViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            return new CommentRowViewHolder(new CommentRowCell(parent,this));
        }

        @Override
        protected void onBindContentItemViewHolder(CommentRowViewHolder commentRowViewHolder, int position) {
                commentRowViewHolder.commentRowCell.bind(list.get(position));
        }

        public class CommentRowViewHolder extends RecyclerView.ViewHolder{
            CommentRowCell commentRowCell;

            public CommentRowViewHolder(CommentRowCell commentRowCell) {
                super(commentRowCell.rootView);
                this.commentRowCell= commentRowCell;
            }

        }

    }
}
