package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.CommentsListCell;
import com.mardomsara.social.ui.cells.lists.CommentsWithAddFieldCell;

/**
 * Created by Hamid on 7/25/2016.
 */
//TODO merge to
public class CommentsPresenter extends BasePresenter  {
	int postId = 0;

	CommentsListCell commentsListCell;

	public CommentsPresenter(int postId ) {
		this.postId = postId;
	}

	ViewGroup viewRoot;
	@Override
	public View buildView() {
		PageCells.NavAndEmptyView pageCell = new PageCells.NavAndEmptyView();
		viewRoot = pageCell.rootView;

		CommentsWithAddFieldCell commentsWithAddFieldCell = new CommentsWithAddFieldCell(postId,viewRoot);
		pageCell.rootView.addView(commentsWithAddFieldCell.getViewRoot());

		pageCell.simpleTopNav.setTitle("نظرات");

		return pageCell.rootView;
	}
	
}


