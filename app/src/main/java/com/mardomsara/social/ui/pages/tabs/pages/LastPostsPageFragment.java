package com.mardomsara.social.ui.pages.tabs.pages;

import android.os.Bundle;
import android.view.View;

import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.adaptors.PostGeneralListCell;

/**
 * Created by Hamid on 7/13/2016.
 */
@Deprecated
public class LastPostsPageFragment extends FragmentPage {

	@Override
	public View getView(Bundle savedInstanceState) {
		X.PageRecentPosts_Parent x= new X.PageRecentPosts_Parent();
		PostGeneralListCell cell = new PostGeneralListCell(x.top_nav.getButtonPostMultiWayView(), (page, cell2)->{
			Http.getPath("v1/post/latest")
				.setQueryParam("page",""+page)
				.setQueryParam("limit",""+25)
				.setQueryParam("last",""+cell2.getLastPostId(page))
				.doAsyncUi((result)->{
					cell2.loadedPostsFromNetNew(result,page);
				});
		});
		x.container.addView(cell.getViewRoot());

		return x.root;
	}


}
