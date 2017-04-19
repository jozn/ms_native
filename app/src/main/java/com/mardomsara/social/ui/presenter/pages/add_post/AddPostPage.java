package com.mardomsara.social.ui.presenter.pages.add_post;

import android.view.View;

import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.squareup.picasso.Picasso;

import java.io.File;

public class AddPostPage extends BasePresenter {

	String toShareFilePath = null;
	X.AddPost_Container x;
	RecentImagesAddPostBoxCell recentImagesCell;

	@Override
    public View buildView() {
		x = new X.AddPost_Container();

		x.gallery_btn.setOnClickListener((v) -> {
			Nav.push(new PostAddGalleryChooserPresenter());
		});

		recentImagesCell = new RecentImagesAddPostBoxCell(x.recent_images_holder);
		recentImagesCell.setListener(new RecentImagesAddPostBoxCell.onRecentImageClicked() {
			@Override
			public void onRecentImageAdded(String filePath) {

			}

			@Override
			public void onRecentImageRemoved(String filePath) {

			}

			@Override
			public void onRecentImageClicked(String filePath) {
				if(toShareFilePath != null && toShareFilePath.equals(filePath)){//add
					selectNoImage();
				}else {//remove
					recentImagesCell.selectNone();
					recentImagesCell.select(filePath);
					setImage(filePath);
				}
			}
		});
		recentImagesCell.insertInto(x.recent_images_holder);
		x.cancel_image.setOnClickListener((v)-> selectNoImage());
		x.send_btn2.setOnClickListener((v)->sendPost());


		return x.root;
    }

	private void sendPost() {
		Helper.showDebugMessage("sendPost");
		if(isStingEmpty(toShareFilePath)){
			Http.postPath("/v1/post/add")
				.setFormParam("text", x.post_field.getText().toString())
				.doAsyncUi((result -> {
					Nav.pop();
				}));
		}else {
			File file = new File(toShareFilePath);
			Http.uploadPath("/v1/post/add",file)
				.setFormParam("text", x.post_field.getText().toString())
				.doAsyncUi((result -> {
					Nav.pop();
				}));
		}
	}

	@Override
	public void onFocus() {
		super.onFocus();
		
	}

	@Override
	public void onBlur() {
		super.onBlur();
	}

	void setImage(String path){
		toShareFilePath = path;
		if(path != null && !path.equals("")){
			File file = new File(path);
			Picasso.with(AppUtil.getContext())
				.load(file)

				.into(x.image);
		}else {
			x.image.setImageBitmap(null);
		}
	}

	void selectNoImage(){
		recentImagesCell.selectNone();
		setImage(null);
	}

	private static boolean isStingEmpty(String str){
		return str == null || str.equals("");
	}
}
