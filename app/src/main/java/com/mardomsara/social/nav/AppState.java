package com.mardomsara.social.nav;

import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

/**
 * Created by Hamid on 1/1/2018.
 */

public class AppState {
	private static AppState appState = null;

	public AppCompatActivity mainActivity;
	public ViewGroup rootView;

	public static AppState getInstance() {
		if (appState == null) {
			appState = (new AppState());
		}
		return appState;
	}
}
