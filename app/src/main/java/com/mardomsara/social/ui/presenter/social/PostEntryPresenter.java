package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.API;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.TitleCellsGroup;
import com.mardomsara.social.ui.cells.lists.CommentsListCell;
import com.mardomsara.social.ui.cells.lists.CommentsWithAddFieldCell;
import com.mardomsara.social.ui.cells.lists.PostsListCell;
import com.mardomsara.social.ui.cells.rows.PostRowCell;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostEntryPresenter extends BasePresenter {
    ViewGroup viewRoot;
    PostRowJson postRowJson;

    public PostEntryPresenter(PostRowJson postJson) {
        postRowJson = postJson;
    }

    @Override
    public View buildView() {
        viewRoot = new PageCells.NavAndEmptyView().rootView;

        PostRowCell postCell = new PostRowCell(viewRoot);
        postCell.bind(postRowJson);
//        viewRoot.addView(listCell.getViewRoot());

		CommentsWithAddFieldCell commentsWithAddFieldCell = new CommentsWithAddFieldCell(postRowJson.Id);
        CommentsListCell commentsListCell = commentsWithAddFieldCell.commentsListCell;
        commentsListCell.adaptor.appendViewToHeader(postCell.getViewRoot());

		TitleCellsGroup.InfoTitle infoTitle = new TitleCellsGroup.InfoTitle(commentsListCell.getViewRoot(),"نظرات");
		commentsListCell.adaptor.appendViewToHeader(infoTitle.rootView);

        commentsListCell.layoutManager.setReverseLayout(false);

//		commentsListCell.adaptor.hideLoading();

        viewRoot.addView(commentsListCell.getViewRoot());
//        listCell.loadFromServer(0);

        return viewRoot;
    }
}
