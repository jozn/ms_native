package com.mardomsara.social.ui.presenter.pages;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.cells.lists.CommentsListCell;
import com.mardomsara.social.ui.cells.lists.CommentsWithAddFieldCell;
import com.mardomsara.social.ui.cells.rows.PostRowCell;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostEntryPage_BK extends BasePresenter {
    ViewGroup viewRoot;
    PostRowJson postRowJson;

    public PostEntryPage_BK(PostRowJson postJson) {
        postRowJson = postJson;
    }

    @Override
    public View buildView() {
        viewRoot = new Cells.NavAndEmptyView().rootView;

        PostRowCell postCell = new PostRowCell(viewRoot);
        postCell.bind(postRowJson);
//        viewRoot.addView(listCell.getViewRoot());

		CommentsWithAddFieldCell commentsWithAddFieldCell = new CommentsWithAddFieldCell(postRowJson.Id,viewRoot);
        CommentsListCell commentsListCell = commentsWithAddFieldCell.commentsListCell;
        commentsListCell.adaptor.appendViewToHeader(postCell.getViewRoot());

		Cells.Title_Info infoTitle = new Cells.Title_Info(commentsListCell.getViewRoot(),"نظرات");
		commentsListCell.adaptor.appendViewToHeader(infoTitle.rootView);

        commentsListCell.layoutManager.setReverseLayout(false);

//		commentsListCell.adaptor.hideLoading();

        viewRoot.addView(commentsWithAddFieldCell.getViewRoot());
//        listCell.loadFromServer(0);

        return viewRoot;
    }
}
