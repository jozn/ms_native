package com.mardomsara.social.ui.presenter.pages;

import android.view.View;

import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;

public class AddPostPage extends BasePresenter {

	X.AddPost_Container x;
	@Override
    public View buildView() {
		x = new X.AddPost_Container();
        return x.root;
    }

}
