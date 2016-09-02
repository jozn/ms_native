package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.API;
import com.mardomsara.social.models.NotifyModel;
import com.mardomsara.social.models.tables.Notify;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.NotifyListCell;
import com.mardomsara.social.ui.cells.lists.PostsListCell;
import com.mardomsara.social.ui.cells.lists.StringListCell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 7/13/2016.
 */
public class NotifyPresenter extends BasePresenter {
    ViewGroup viewRoot;

    @Override
    public View buildView() {

        List<Notify> list0 = NotifyModel.getAll();
        List<String> list = new ArrayList<>();
        for (Notify n: list0){
            list.add(n.PayloadStored);
        }

        NotifyListCell listCell = new NotifyListCell(list0);

        return listCell.getViewRoot();
    }

}
