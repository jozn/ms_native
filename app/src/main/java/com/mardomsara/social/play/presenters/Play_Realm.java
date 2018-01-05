package com.mardomsara.social.play.presenters;

import android.os.Bundle;
import android.view.View;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.app.app_state.AppState;
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_Realm extends FragmentPage {
    @Override
	public View getView(Bundle savedInstanceState) {
		X.PlayRealm x = new X.PlayRealm();
		AppRealm.getChatRealm().close();

		AppState.getDefault().getSettingClientEditor();
		/*RealmResults<Blog> realmResults = AppRealm.getChatRealm()
			.where(Blog.class)
			.findAll();

		x.txt.setText("ss " +realmResults.size());

		realmResults.addChangeListener(new RealmChangeListener<RealmResults<Blog>>() {
			@Override
			public void onChange(RealmResults<Blog> blogs) {
				x.txt.setText("ss " +blogs.size() + " " + blogs.last().getId());
			}
		});


		AppRealm.getChatRealm().addChangeListener(new RealmChangeListener<Realm>() {
			@Override
			public void onChange(Realm realm) {

			}
		});
*/
		return x.root;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
