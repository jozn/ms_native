package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.API;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.cells.lists.PostsListCell;

/**
 * Created by Hamid on 7/13/2016.
 */
public class LastPostsPresenter extends BasePresenter {
    ViewGroup viewRoot;

    @Override
    public View buildView() {
        viewRoot = new Cells.NavAndEmptyView().rootView;

        PostsListCell listCell = new PostsListCell();
        listCell.setLoadingEndPoint(API.LATEST_POSTS_GET);
        viewRoot.addView(listCell.getViewRoot());
        listCell.loadFromServer(1);

        return viewRoot;
    }

}
