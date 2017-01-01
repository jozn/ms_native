package com.mardomsara.social.play.presenters;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.pipe.Pipe;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.TitleCellsGroup;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_RecipiesPresenter extends BasePresenter {
    @Override
    public View buildView() {
		X.PlayRecipies rootView =  new X.PlayRecipies();
		rootView._status_bar.setOnClickListener((v)->{
			int currentVis = v.getSystemUiVisibility();
			int newVis;
			if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE)
				== View.SYSTEM_UI_FLAG_LOW_PROFILE) {
				newVis = View.SYSTEM_UI_FLAG_VISIBLE;
			} else {
				newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE;
			}
			v.setSystemUiVisibility(newVis);

			Notification not =new Notification.Builder(v.getContext())
//				.setColor(Color.GREEN)
				.setContentText("content text")
				.setContentTitle("titlw")
				.setAutoCancel(true)
				.setSubText("sub text")
				.setTicker("ticker!!!!! !!!!")
				.setWhen(System.currentTimeMillis())
				.setSmallIcon(R.drawable.e_1f18e)
//				.setShowWhen(true)
				.build();

			((NotificationManager)v.getContext().getSystemService(Context.NOTIFICATION_SERVICE)).notify(1,not);

		});

		int i = 0;
		rootView.p_navigation.setOnClickListener((v)->{
			new AlertDialog.Builder(v.getContext())
				.setIcon(R.drawable.e_1f1e6_1f1ee)
				.setMessage("message")
				.setPositiveButton("postive",(o,w)->{Helper.showMessage(""+w);})
				.create().show();

			v.setSystemUiVisibility(
/* This flag tells Android not to shift
* our layout when resizing the window to
* hide/show the system elements
*/
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
/* This flag hides the system status bar. If
* ACTION_BAR_OVERLAY is requested, it will hide
* the ActionBar as well.
*/
					| View.SYSTEM_UI_FLAG_FULLSCREEN
/* This flag hides the onscreen controls
*/
					| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		/*
			if(i%2==1) {
				v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
			}else {
//				v.setSystemUiVisibility(View.);
			}*/
		});

		WebView w= rootView.webview;
		w.getSettings().setJavaScriptEnabled(false);
		w.loadUrl("http://mardomsara.com/");
        return rootView.root;
    }


}
