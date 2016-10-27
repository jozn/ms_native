package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.API;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.PostsListCell;

/**
 * Created by Hamid on 7/13/2016.
 */
public class HomeStream2Presenter extends BasePresenter {
    ViewGroup viewRoot;

    @Override
    public View buildView() {
        viewRoot = new PageCells.NavAndEmptyView().rootView;

        PostsListCell listCell = new PostsListCell();
        listCell.setLoadingEndPoint(API.BASE_DOMAIN_URL_STR+"/v1/post/stream");
        viewRoot.addView(listCell.getViewRoot());
        listCell.loadFromServer(0);

        return viewRoot;
    }

}
