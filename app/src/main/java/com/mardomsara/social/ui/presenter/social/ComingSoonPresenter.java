package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.models.NotifyModel;
import com.mardomsara.social.models.tables.Notify;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.NotifyListCell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 7/13/2016.
 */
public class ComingSoonPresenter extends BasePresenter {
    ViewGroup viewRoot;

    @Override
    public View buildView() {
        PageCells.ComingSoon listCell = new PageCells.ComingSoon();

        return listCell.rootView;
    }

}
