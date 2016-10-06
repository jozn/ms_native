package com.mardomsara.social.play.presenters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.TitleCellsGroup;
import com.mardomsara.social.ui.presenter.HelloPresenter;

/**
 * Created by Hamid on 10/1/2016.
 */
public class TestsPresenter extends BasePresenter {
    @Override
    public View buildView() {
        PageCells.Scroller cell =new PageCells.Scroller();
        ViewGroup rootView =cell.rootView;
        ViewGroup layout =cell.layout;

        layout.addView(newTitle("همه حذف",()->{
            Nav.push(new HelloPresenter());
        }));

        layout.addView(newTitle("Http2 play test",()->{
            Nav.push(new Http2TestPresenter());
        }));

		layout.addView(newTitle("Ws Call tsest",()->{
			Nav.push(new WSCallPresenter());
		}));

        return rootView;
    }

    View newTitle(String title, Runnable runnable){
        ViewGroup view = new TitleCellsGroup.InfoTitle(null,title).rootView;
        view.setOnClickListener((v)->{
            runnable.run();
        });
        return view;
    }

}
