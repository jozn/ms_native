package com.mardomsara.social.ui.presenter.pages.add_post;

import android.view.View;

import com.mardomsara.social.Nav;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;

public class AddPostPage extends BasePresenter {

	X.AddPost_Container x;
	@Override
    public View buildView() {
		x = new X.AddPost_Container();

		x.gallery_btn.setOnClickListener((v) -> {
			Nav.push(new PostAddGalleryChooserPresenter());
		});

		RecentImagesAddPostBoxCell recentImagesCell = new RecentImagesAddPostBoxCell(x.recent_images_holder);
		recentImagesCell.insertInto(x.recent_images_holder);


		return x.root;
    }

	@Override
	public void onFocus() {
		super.onFocus();
		
	}

	@Override
	public void onBlur() {
		super.onBlur();
	}
}
