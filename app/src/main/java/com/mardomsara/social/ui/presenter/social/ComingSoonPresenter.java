package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;

/**
 * Created by Hamid on 7/13/2016.
 */
@Deprecated
public class ComingSoonPresenter extends BasePresenter {
    ViewGroup viewRoot;

    @Override
    public View buildView() {
        Cells.ComingSoon listCell = new Cells.ComingSoon();

        return listCell.rootView;
    }

}
