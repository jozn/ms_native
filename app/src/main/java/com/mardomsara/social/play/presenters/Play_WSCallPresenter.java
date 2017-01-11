package com.mardomsara.social.play.presenters;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.pipe.Pipe;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_WSCallPresenter extends BasePresenter {
    @Override
    public View buildView() {
        PageCells.Scroller cell =new PageCells.Scroller();
        ViewGroup rootView =cell.rootView;
        ViewGroup layout =cell.layout;

        layout.addView(newTitle("Call Echo ",()->{
            callEcho();
        }));

        return rootView;
    }

	private void callEcho() {
		Pipe.sendCall("echo","Hi From go",
			()->{
				Helper.showDebugMessage("Echo Call Success");
			},
			()->{
				Helper.showDebugMessage("Echo Call Error");
			}
		);
	}

	View newTitle(String title, Runnable runnable){
		ViewGroup view = new PageCells.BigClickAbleTitle(null,title).rootView;
		view.setOnClickListener((v)->{
			runnable.run();
		});
		int p = AndroidUtil.dpToPx(10);
		view.setPadding(0,p,p,p);
		return view;
	}



}
