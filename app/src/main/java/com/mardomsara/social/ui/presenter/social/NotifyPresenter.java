package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.App;
import com.mardomsara.social.models.NotifyModel;
import com.mardomsara.social.models.events.NotifyChanged;
import com.mardomsara.social.models.tables.Notify;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.cells.lists.NotifyListCell;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 7/13/2016.
 */
public class NotifyPresenter extends BasePresenter {
    ViewGroup viewRoot;

	NotifyListCell listCell;

	@Override
    public View buildView() {

        List<Notify> list0 = NotifyModel.getAllReverse();
        /*List<String> list = new ArrayList<>();
        for (Notify n: list0){
            list.add(n.PayloadStored);
        }*/


        listCell = new NotifyListCell(list0);
        viewRoot = listCell.getViewRoot();

        Cells.Title_InfoLight topTitle = new Cells.Title_InfoLight(listCell.recycler_view);
        topTitle.setText("فعالیت های دیگران مرتبط به شما:");
        listCell.getAdaptor().appendViewToHeader(topTitle.rootView);

		App.getBus().register(this);

		return viewRoot;
    }

	@Override
	public void onDestroy() {
		super.onDestroy();
		App.getBus().unregister(this);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	void event(NotifyChanged notifyChanged){
		load();
	}

	void load(){
		List<Notify> list0 = NotifyModel.getAllReverse();
		List<String> list = new ArrayList<>();

		listCell.list.clear();

		for (Notify n: list0){
			list.add(n.PayloadStored);
		}

		listCell.refreshLayout.setRefreshing(false);
		listCell.adaptor.notifyDataChanged();

	}

}
