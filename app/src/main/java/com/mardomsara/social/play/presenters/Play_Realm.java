package com.mardomsara.social.play.presenters;

import android.view.View;

import com.mardomsara.social.app.MSRealm;
import com.mardomsara.social.models.realm_play.Blog;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_Realm extends BasePresenter {
    @Override
	public View buildView() {
		X.PlayRealm x = new X.PlayRealm();

		RealmResults<Blog> realmResults = MSRealm.getChatRealm()
			.where(Blog.class)
			.findAll();

		x.txt.setText("ss " +realmResults.size());

		realmResults.addChangeListener(new RealmChangeListener<RealmResults<Blog>>() {
			@Override
			public void onChange(RealmResults<Blog> blogs) {
				x.txt.setText("ss " +blogs.size() + " " + blogs.last().getId());
			}
		});


		MSRealm.getChatRealm().addChangeListener(new RealmChangeListener<Realm>() {
			@Override
			public void onChange(Realm realm) {

			}
		});

		return x.root;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
