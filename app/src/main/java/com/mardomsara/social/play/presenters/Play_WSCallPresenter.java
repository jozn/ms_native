package com.mardomsara.social.play.presenters;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_WSCallPresenter extends BasePresenter {
    @Override
    public View buildView() {
        Cells.Scroller cell =new Cells.Scroller();
        ViewGroup rootView =cell.rootView;
        ViewGroup layout =cell.layout;

        layout.addView(newTitle("Call Echo ",()->{
            callEcho();
        }));

        return rootView;
    }

	private void callEcho() {
		/*Pipe_OLD.sendCall("echo","Hi From go",
			()->{
				Helper.showDebugMessage("Echo Call Success");
			},
			()->{
				Helper.showDebugMessage("Echo Call Error");
			}
		);*/
	}

	View newTitle(String title, Runnable runnable){
		ViewGroup view = new Cells.Title_BigClickAble(null,title).rootView;
		view.setOnClickListener((v)->{
			runnable.run();
		});
		int p = AndroidUtil.dpToPx(10);
		view.setPadding(0,p,p,p);
		return view;
	}



}
