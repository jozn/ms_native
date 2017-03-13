package com.mardomsara.social.play.presenters;

import android.view.View;

import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_XTextViews extends BasePresenter {
    @Override
	public View buildView() {
		X.PlayXtextview x = new X.PlayXtextview();
		return x.root;
	}


}
