package com.mardomsara.social.ui.presenter.pages.add_post;

import android.view.View;

import com.mardomsara.social.Nav_DEP;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.EmojiKeyboard;
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
			Nav_DEP.push(new PostAddGalleryChooserPresenter(new PostAddGalleryChooserPresenter.onImageClicked() {
				@Override
				public void onRecentImageAdded(String filePath) {
					Nav_DEP.pop();
					setImageFromOutside(filePath);
				}

				@Override
				public void onRecentImageRemoved(String filePath) {

				}

				@Override
				public void onRecentImageClicked(String filePath) {

				}
			}));
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
		x.top_nav.setOnLeftClick(()->sendPost());
		x.camera_btn.setOnClickListener(v-> Helper.showCommingSoonMessage());

		EmojiKeyboard emojiKeybord= new EmojiKeyboard(x.post_field ,x.emoji_opener_btn, AppUtil.global_window);

//		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		keyboard_noResize();

		setImageFromOutside(toShareFilePath);

		return x.root;
    }


	private void sendPost() {
		Helper.showDebugMessage("sendPost");
		if(isStingEmpty(toShareFilePath)){
			Http.postPath("/v1/post/add")
				.setFormParam("text", x.post_field.getText().toString())
				.doAsyncUi((result -> {
					Nav_DEP.pop();
				}));
		}else {
			File file = new File(toShareFilePath);
			Http.uploadPath("/v1/post/add",file)
				.setFormParam("text", x.post_field.getText().toString())
				.doAsyncUi((result -> {
					Nav_DEP.pop();
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

	public void setImage(String path){
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

	public void setToShareFilePath(String toShareFilePath) {
		this.toShareFilePath = toShareFilePath;
	}

	private void setImageFromOutside(String toShareFilePath) {
		recentImagesCell.tryAddToSelected(toShareFilePath);
		setImage(toShareFilePath);
	}

	void selectNoImage(){
		recentImagesCell.selectNone();
		setImage(null);
	}

	private static boolean isStingEmpty(String str){
		return str == null || str.equals("");
	}
}
