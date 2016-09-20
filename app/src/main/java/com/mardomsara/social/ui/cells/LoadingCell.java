package com.mardomsara.social.ui.cells;

import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;

import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/6/2016.
 */
public class LoadingCell {
    public ViewGroup rootView;
//    @Bind(R.id.progress_wheel)
//    ProgressWheel progressWheel;

    public LoadingCell() {
        rootView = (ViewGroup) AppUtil.inflate(R.layout.loading_row);
//        ButterKnife.bind(this, rootView);
//        progressWheel.
    }
    public LoadingCell(ViewGroup parent) {
        rootView = (ViewGroup) AppUtil.inflate(R.layout.cell_loading,parent);
        ButterKnife.bind(this, rootView);
//        progressWheel.spin();
//        progressWheel.setBarColor(Color.GREEN);
//        progressWheel.setProgress(0.8f);
//        progressWheel.
    }

}
