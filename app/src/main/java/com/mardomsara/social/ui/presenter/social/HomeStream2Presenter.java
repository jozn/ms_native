package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.http.HomeStreamJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.PostsListCell;
import com.mardomsara.social.ui.ui.UIPostsList;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import butterknife.Bind;

/**
 * Created by Hamid on 7/13/2016.
 */
public class HomeStream2Presenter extends BasePresenter {
    ViewGroup viewRoot;

    @Override
    public View buildView() {
        viewRoot = new PageCells.NavAndEmptyView().rootView;

        PostsListCell listCell = new PostsListCell();
        listCell.setLoadingEndPoint("http://localhost:5000/v1/post/stream");
        viewRoot.addView(listCell.getViewRoot());
        listCell.loadFromServer(0);

        return viewRoot;
    }

}
