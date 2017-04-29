package com.mardomsara.social.ui.presenter.pages;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.mardomsara.social.app.API;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.adaptors.PostGeneralListCell;
import com.mardomsara.social.ui.ui.UIPostsList;

/**
 * Created by Hamid on 8/24/2016.
 */
public class TagsPage extends BasePresenter
        {
    String tagName = "";


    UIPostsList.PostsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;

    public TagsPage(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public View buildView() {
		X.PageTag_Parent x= new X.PageTag_Parent(null);
		PostGeneralListCell cell = new PostGeneralListCell(x.button_post_way);
		cell.setLoadingEndPoint(API.TAGS_LIST);

		cell.loadNextPage(1);

//		viewRoot.addView(x.root);
		return x.root;

        /*Cells.NavAndEmptyView page = new Cells.NavAndEmptyView();
        page.simpleTopNav.setTitle(getTagNameTitle(this.tagName));
        viewRoot = page.rootView;
        load();*/
//        return viewRoot;
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
