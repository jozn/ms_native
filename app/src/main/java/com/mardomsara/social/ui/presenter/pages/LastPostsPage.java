package com.mardomsara.social.ui.presenter.pages;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.adaptors.PostGeneralListCell;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.cells.lists.PostsListCell;

/**
 * Created by Hamid on 7/13/2016.
 */
public class LastPostsPage extends BasePresenter {

	@Override
	public View buildView() {
		X.PageRecentPosts_Parent x= new X.PageRecentPosts_Parent(null);
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
