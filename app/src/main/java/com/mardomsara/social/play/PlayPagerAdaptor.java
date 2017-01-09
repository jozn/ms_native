package com.mardomsara.social.play;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hamid on 1/9/2017.
 */

public class PlayPagerAdaptor extends PagerAdapter {
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		return super.instantiateItem(container, position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return super.getPageTitle(position);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return false;
	}

	/*@Override
	public int getCount() {
		return 0;
	}

	*/
}
