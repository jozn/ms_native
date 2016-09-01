package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.API;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.PostsListCell;
import com.mardomsara.social.ui.cells.lists.SearchTagsListCell;

/**
 * Created by Hamid on 7/13/2016.
 */
@Deprecated
public class SearchTagPagerPresenter extends BasePresenter {
    ViewGroup viewRoot;

    @Override
    public View buildView() {
        SearchTagsListCell listCell = new SearchTagsListCell("");
        viewRoot = listCell.getViewRoot();
        return viewRoot;
    }

}
