package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.lists.CommentsListCell;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/25/2016.
 */
public class CommentsPresenter extends BasePresenter implements SimpleAddText.OnAddText {
    int postId = 0;

    @Bind(R.id.simpleTopNav)
    SimpleTopNav simpleTopNav;

    /*@Bind(R.id.loadingView)
    LoadingView loadingView;*/

    @Bind(R.id.simpleAddText)
    SimpleAddText simpleAddText;

	@Bind(R.id.content)
	ViewGroup content;

	CommentsListCell commentsListCell;

    public CommentsPresenter(int postId ) {
        this.postId = postId;
    }

    @Override
    public View buildView() {
        View view = AppUtil.inflate(R.layout.presenter_commonts);
//        ViewGroup view = new PageCells.NavAndEmptyView().rootView;
        ButterKnife.bind(this,view);
		simpleTopNav.setTitle("نظرات");
        commentsListCell = new CommentsListCell(postId);

        content.addView(commentsListCell.getViewRoot());

        simpleAddText.setOnAddListener(this);
        return view;
    }


	@Override
	public void onAddText(String text) {
		commentsListCell.addNewCommentByMe(text);
	}
}


