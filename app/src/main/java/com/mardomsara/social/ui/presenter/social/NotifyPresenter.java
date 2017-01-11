package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.models.NotifyModel;
import com.mardomsara.social.models.tables.Notify;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.NotifyListCell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 7/13/2016.
 */
public class NotifyPresenter extends BasePresenter {
    ViewGroup viewRoot;

    @Override
    public View buildView() {

        List<Notify> list0 = NotifyModel.getAllReverse();
        List<String> list = new ArrayList<>();
        for (Notify n: list0){
            list.add(n.PayloadStored);
        }

        NotifyListCell listCell = new NotifyListCell(list0);
        viewRoot = listCell.getViewRoot();

        PageCells.InfoTitleLight topTitle = new PageCells.InfoTitleLight(listCell.recycler_view);
        topTitle.setText("فعالیت های دیگران مرتبط به شما:");
        listCell.getAdaptor().appendViewToHeader(topTitle.rootView);

        return viewRoot;
    }

}
