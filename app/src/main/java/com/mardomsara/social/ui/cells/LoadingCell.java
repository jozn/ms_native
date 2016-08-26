package com.mardomsara.social.ui.cells;

import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;

/**
 * Created by Hamid on 8/6/2016.
 */
public class LoadingCell {
    public ViewGroup rootView;

    public LoadingCell() {
        rootView = (ViewGroup) AppUtil.inflate(R.layout.cell_loading);
//        ButterKnife.bind(this, rootView);
//        progressWheel.
    }
    public LoadingCell(ViewGroup parent) {
        rootView = (ViewGroup) AppUtil.inflate(R.layout.cell_loading,parent);
//        ButterKnife.bind(this, rootView);
//        progressWheel.
    }

}
