package com.mardomsara.social.ui.cells.lists;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mardomsara.social.app.API;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.json.social.http.CommentSingleJson;
import com.mardomsara.social.json.social.http.CommentsListJson;
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

        loadCommentsFromNet(0);
    }

    public void setLayoutManagerOrintation(int orintation){
        layoutManager.setOrientation(orintation);
    }

    private void loadCommentsFromNet(int page) {
        AndroidUtil.runInBackground(()->{
            HttpOld.Req req = new HttpOld.Req();
            req.absPath = API.COMMENTS_LIST_GET.toString();
            req.urlParams.put("post_id",""+postId);
            req.urlParams.put("page",""+page);
            HttpOld.Result res = HttpOld.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                    loadedCommentsFromNet(res);
                });
            }
        });
    }

    private void loadedCommentsFromNet(HttpOld.Result res) {
        CommentsListJson data = JsonUtil.fromJson(res.data, CommentsListJson.class);
        if(data != null && data.Status.equalsIgnoreCase("OK") && data.Payload!=null){
            adaptor.list.addAll(data.Payload);
            adaptor.notifyDataSetChanged();
        }else {
            adaptor.setHasMorePage(false);
        }
    }

    @Override
    public void loadNextPage(int pageNum) {
        loadCommentsFromNet(pageNum);
    }

    public ViewGroup getViewRoot() {
        return recyclerView;
    }

	public void addNewCommentByme(String text){
		Helper.showDebugMessage(text);
		CommentRowJson comment = new CommentRowJson();
		comment.Sender = Session.buildUserSender();
		comment.PostId = postId;
		comment.UserId = Session.getUserId();
		comment.CreatedTime = (int) TimeUtil.getTime();
		comment.Text = text;
		comment._isNew=true;

		adaptor.list.add(0,comment);
		adaptor.notifyDataSetChanged();

		AndroidUtil.runInBackgroundNoPanic(()->{
			HttpOld.Req req = new HttpOld.Req();
			req.absPath = API.COMMENTS_ADD.toString();
			req.form.put("post_id",""+postId);
			req.form.put("text",""+text);
			HttpOld.Result res = HttpOld.masterSendPost(req);
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

/*
if(!isNextPages){
        isNextPages = true;
        if(data != null && data.Status.equalsIgnoreCase("OK") && data.Load!=null){

        adaptor.list.addAllStart(data.Load);
        adaptor.notifyDataSetChanged();
//                recyclerView.setAdapter(adaptor);
//                recyclerView.setLayoutManager(layoutManager);
//                loadingView.replace(recyclerView);
        }else {
//                adaptor.setHasMorePage(false);
        //todo error
        }
        }else {
        if(data != null && data.Status.equalsIgnoreCase("OK") && data.Load!=null){
        adaptor.list.addAllStart(data.Load);
        adaptor.notifyDataSetChanged();
        }else {
        adaptor.setHasMorePage(false);
        }
        }
*/
