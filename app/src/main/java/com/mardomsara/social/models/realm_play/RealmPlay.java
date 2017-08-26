package com.mardomsara.social.models.realm_play;

import com.mardomsara.social.app.ConfigRealm;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;

import io.realm.RealmResults;

/**
 * Created by Hamid on 7/4/2017.
 */

public class RealmPlay {

	public static void play(){

		new Thread(()->{

			for (int i =0 ; i <1 ; i++){

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				AndroidUtil.runInUiNoPanic(()->{
					ConfigRealm.getInstance().executeTransactionAsync((t)->{

						Blog blog = t.createObject(Blog.class, "id_"+LangUtil.getRandom(1000000));;
						blog.setName("as");
						blog.setAge(654);
//						blog.setId();


						t.insert(blog);

					});

					if(LangUtil.getRandom(6)%5 ==0){
						RealmResults<Blog> results = ConfigRealm.getInstance()
							.where(Blog.class)
							.findAll();
						Helper.showDebugMessage("realm res : " +results.size());
					}
				});


//				FragmentPagerAdapter
//				FragmentStatePagerAdapter

			}
		}).start();


	}
}
