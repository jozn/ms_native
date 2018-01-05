package com.mardomsara.social.ui.pages.tabs.pages;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.cells.lists.NotifyListCell;

/**
 * Created by Hamid on 7/13/2016.
 */
public class NotifyCell {
    ViewGroup viewRoot;

	NotifyListCell listCell;


    public View buildView() {
        listCell = new NotifyListCell();
        viewRoot = listCell.getViewRoot();

        Cells.Title_InfoLight topTitle = new Cells.Title_InfoLight(listCell.recycler_view);
        topTitle.setText("فعالیت های دیگران مرتبط به شما:");
        listCell.getAdaptor().appendViewToHeader(topTitle.rootView);

		return viewRoot;
    }

	//@Override
	public void onDestroy() {
		//super.onDestroy();
		listCell.destroy();
	}
}
