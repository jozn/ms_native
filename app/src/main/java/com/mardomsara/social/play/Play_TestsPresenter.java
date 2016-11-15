package com.mardomsara.social.play;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.play.presenters.Play_DiaolgPresenter;
import com.mardomsara.social.play.presenters.Play_FormsPresenter;
import com.mardomsara.social.play.presenters.Play_Http2TestPresenter;
import com.mardomsara.social.play.presenters.Play_WSCallPresenter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.TitleCellsGroup;
import com.mardomsara.social.ui.presenter.HelloPresenter;
import com.mardomsara.social.ui.react.MSReactActivity2;
import com.mardomsara.social.ui.react.MyReactActivity;
import com.mardomsara.social.ui.react.ReactPresenter;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_TestsPresenter extends BasePresenter {
    @Override
    public View buildView() {
        PageCells.Scroller cell =new PageCells.Scroller();
        ViewGroup rootView =cell.rootView;
        ViewGroup layout =cell.layout;

        layout.addView(newTitle("همه حذف",()->{
            Nav.push(new HelloPresenter());
        }));

        layout.addView(newTitle("Http2 play test",()->{
            Nav.push(new Play_Http2TestPresenter());
        }));

		layout.addView(newTitle("Ws Call tsest",()->{
			Nav.push(new Play_WSCallPresenter());
		}));

		layout.addView(newTitle("Dialogs ",()->{
			Nav.push(new Play_DiaolgPresenter());
		}));

		layout.addView(newTitle("Edits ",()->{
			Nav.push(new Play_FormsPresenter());
		}));

		layout.addView(newTitle("React ",()->{
			Nav.push(new ReactPresenter());
		}));

		layout.addView(newTitle("React Activity",()->{
			Intent intent = new Intent(getContext(), MyReactActivity.class);
			getActivity().startActivity(intent);
		}));

		layout.addView(newTitle("React Activity2",()->{
			Intent intent = new Intent(getContext(), MSReactActivity2.class);
			getActivity().startActivity(intent);
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
