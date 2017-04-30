package com.mardomsara.social.ui.presenter.pages;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.cells.lists.CommentsListCell;
import com.mardomsara.social.ui.cells.lists.CommentsWithAddFieldCell;
import com.mardomsara.social.ui.cells.rows.PostRowWideCell;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostEntryPage extends BasePresenter {
    ViewGroup viewRoot;
    JV.PostView postRowJson;

	boolean havePostJson = true;
	X.Post_SingleEntryHolder postHolder;

	public PostEntryPage(JV.PostView postJson) {
        postRowJson = postJson;
    }

	public PostEntryPage(JV.PostView postJson, boolean has) {
		postRowJson = postJson;
		havePostJson = has;
	}

    @Override
    public View buildView() {
		Cells.NavAndEmptyView page = new Cells.NavAndEmptyView();
        viewRoot = page.rootView;
		page.simpleTopNav.setTitle("پست");
		postHolder = new X.Post_SingleEntryHolder(viewRoot);

		CommentsWithAddFieldCell commentsWithAddFieldCell = new CommentsWithAddFieldCell(postRowJson.Id,viewRoot);
        CommentsListCell commentsListCell = commentsWithAddFieldCell.commentsListCell;

		commentsListCell.adaptor.appendViewToHeader(postHolder.root);

		Cells.Title_Info infoTitle = new Cells.Title_Info(commentsListCell.getViewRoot(),"نظرات");
		commentsListCell.adaptor.appendViewToHeader(infoTitle.rootView);

		if(havePostJson){
			showPostCell(postRowJson);
		}else {
			Http.getPath("/v1/post/get")
				.setQueryParam("post_id",getPostId())
				.doAsyncUi(result -> {
					HttpJson<JV.PostView> data =Result.fromJson(result, JV.PostView.class);
					if(data!=null){
						showPostCell(data.Payload);
					}
				});

		}

		commentsListCell.layoutManager.setReverseLayout(false);

//		commentsListCell.adaptor.hideLoading();

        viewRoot.addView(commentsWithAddFieldCell.getViewRoot());
//        listCell.loadFromServer(0);

        return viewRoot;
    }

	int getPostId(){
		return postRowJson.Id;
	}

	void showPostCell(JV.PostView postJson){
		PostRowWideCell postCell = new PostRowWideCell(viewRoot);
		postCell.bind(postJson);
//        viewRoot.addView(listCell.getViewRoot());
		postHolder.loading.setVisibility(View.GONE);
		postHolder.root.addView(postCell.getViewRoot());
	}
}
