package com.mardomsara.social.play.presenters;

import android.os.Bundle;
import android.view.View;

import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_XTextColorsViews extends FragmentPage {
    @Override
	public View getView(Bundle savedInstanceState) {
		X.PlayXtextview x = new X.PlayXtextview();
		return new X.PlayXtextcoloersview().root;
	}


}
