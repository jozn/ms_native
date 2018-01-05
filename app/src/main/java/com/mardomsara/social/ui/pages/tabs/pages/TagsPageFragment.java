package com.mardomsara.social.ui.pages.tabs.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.adaptors.PostGeneralListCell;

/**
 * Created by Hamid on 8/24/2016.
 */
public class TagsPageFragment extends FragmentPage {
	static final String TAG_NAME = "TAG_NAME";
	String tagName = "";

	public static TagsPageFragment newInstance(String tagName) {
		Bundle bundle = new Bundle();
		bundle.putString(TAG_NAME, tagName);
		TagsPageFragment fragment = new TagsPageFragment();
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			this.tagName = getArguments().getString(TAG_NAME);
		}
	}

	@Override
	public View getView(Bundle savedInstanceState) {
		X.PageTag_Parent x = new X.PageTag_Parent();
		PostGeneralListCell cell = new PostGeneralListCell(x.top_nav.getButtonPostMultiWayView(), (page, cell2) -> {
			Http.getPath("v1/tags/list")
				.setQueryParam("tag", "" + tagName.replace("#", ""))
				.setQueryParam("page", "" + page)
				.setQueryParam("last", "" + cell2.getLastPostId(page))
				.doAsyncUi((result) -> {
					cell2.loadedPostsFromNetNew(result, page);
					cell2.loadedPostsFromNetNew(result, page);
				});
		});
		x.container.addView(cell.getViewRoot());
		cell.setLoadingEndPoint(API.TAGS_LIST);
		x.top_nav.setTitle(getTagNameTitle(tagName));
//		cell.loadNextPage(1);

		return x.root;
	}


	String getTagNameTitle(String tagName) {
		if (tagName != null && tagName.length() > 0) {
			if (!tagName.startsWith("#")) {
				return "#" + tagName;
			} else {
				return tagName;
			}
		}
		return "";
	}

}
