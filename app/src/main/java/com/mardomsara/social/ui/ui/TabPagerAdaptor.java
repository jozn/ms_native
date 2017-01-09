package com.mardomsara.social.ui.ui;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 1/9/2017.
 */

public class TabPagerAdaptor extends PagerAdapter {
	List<Tab> tabList=new ArrayList<>();

	public void addTab(@NonNull Tab tab){
		tabList.add(tab);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Tab tab = tabList.get(position);
		View tabView = tab.getView();
		container.addView(tabView);
		return tab;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(((Tab)object).view);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabList.get(position).title;
	}

	@Override
	public int getCount() {
		return tabList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	public static class Tab{
		public String title = "";
		public GetView getViewRunner ;
		View view;

		public Tab(@NonNull String title,@NonNull GetView getViewRunner) {
			this.title = title;
			this.getViewRunner = getViewRunner;
		}

		public View getView(){
			if(view==null){
				view = getViewRunner.getView();
			}
			return view;
		}
	}

	public interface GetView{
		public View getView();
	}
}
