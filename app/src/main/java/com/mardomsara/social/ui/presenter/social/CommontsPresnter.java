package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.CommentsListCell;
import com.mardomsara.social.ui.views.wigets.LoadingView;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/25/2016.
 */
public class CommontsPresnter extends BasePresenter {
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
//        View view = AppUtil.inflate(R.layout.presenter_commonts);
        ViewGroup view = new PageCells.NavAndEmptyView().rootView;
//        ButterKnife.bind(this,view);
        CommentsListCell commentsListCell = new CommentsListCell(postId);
        view.addView(commentsListCell.getViewRoot());

//        simpleAddText.setOnAddListener(commentsListCell);
        return view;
    }



}


