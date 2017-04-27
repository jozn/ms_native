package com.mardomsara.social.ui.presenter.tabs;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.API;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.lists.PostsHomeCell;

/**
 * Created by Hamid on 7/13/2016.
 */
public class HomeTab extends BasePresenter {
    ViewGroup viewRoot;

    @Override
    public View buildView() {
//        viewRoot = new Cells.NavAndEmptyView().rootView;

		PostsHomeCell listCell = new PostsHomeCell();
        listCell.setLoadingEndPoint(API.BASE_DOMAIN_URL_STR+"/v1/post/stream");
//        viewRoot.addView(listCell.getViewRoot());
        listCell.loadFromServer(1);

        return listCell.getViewRoot();
    }

}
