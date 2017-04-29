package com.mardomsara.social.ui.presenter.pages;

import android.view.View;

import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.adaptors.PostGeneralListCell;

/**
 * Created by Hamid on 8/24/2016.
 */
public class TagsPage extends BasePresenter {
    String tagName = "";

    public TagsPage(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public View buildView() {
		X.PageTag_Parent x= new X.PageTag_Parent(null);
		PostGeneralListCell cell = new PostGeneralListCell(x.button_post_way, (page, cell2)->{
			Http.getPath("v1/tags/list")
				.setQueryParam("tag",""+tagName.replace("#",""))
				.setQueryParam("page",""+page)
				.setQueryParam("last",""+cell2.getLastPostId(page))
				.doAsyncUi((result)->{
					cell2.loadedPostsFromNetNew(result,page);
					cell2.loadedPostsFromNetNew(result,page);
				});
		});
		x.container.addView(cell.getViewRoot());
		cell.setLoadingEndPoint(API.TAGS_LIST);
		x.title_text.setText(getTagNameTitle(tagName));
//		cell.loadNextPage(1);

		return x.root;
    }


	String getTagNameTitle(String tagName){
		if(tagName!=null&&tagName.length()>0){
			if(!tagName.startsWith("#")) {
				return "#" + tagName;
			}
			else {
				return tagName;
			}
		}
		return "";
	}

}
