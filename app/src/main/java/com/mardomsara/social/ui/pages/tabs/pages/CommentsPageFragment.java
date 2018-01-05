package com.mardomsara.social.ui.pages.tabs.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.cells.lists.CommentsWithAddFieldCell;

/**
 * Created by Hamid on 7/25/2016.
 */

public class CommentsPageFragment extends FragmentPage {
	final static String POST_ID = "POST_ID";

	int postId = 0;

	public static CommentsPageFragment getInstance(int postId ){
		Bundle bundle = new Bundle();
		bundle.putInt(POST_ID,postId);
		CommentsPageFragment fragment = new CommentsPageFragment();
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(getArguments() != null){
			postId =getArguments().getInt(POST_ID);
		}
	}

	ViewGroup viewRoot;

	@Override
	public View getView(Bundle savedInstanceState){
		Cells.NavAndEmptyView pageCell = new Cells.NavAndEmptyView();
		viewRoot = pageCell.rootView;

		CommentsWithAddFieldCell commentsWithAddFieldCell = new CommentsWithAddFieldCell(postId,viewRoot);
		pageCell.rootView.addView(commentsWithAddFieldCell.getViewRoot());

		pageCell.simpleTopNav.setTitle("نظرات");

		return pageCell.rootView;
	}

}


