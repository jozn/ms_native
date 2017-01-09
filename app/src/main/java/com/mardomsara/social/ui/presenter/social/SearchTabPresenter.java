package com.mardomsara.social.ui.presenter.social;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.presenter.social.search.SearchPresenter;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SearchTabPresenter extends BasePresenter {
    @Override
    public View buildView() {
//		SearchTabPagerAdaptor pad = new SearchTabPagerAdaptor(getFragment().getChildFragmentManager(),fragment.getActivity());
		SearchTabPagerAdaptor pad = new SearchTabPagerAdaptor();

		PageCells.NavAndPager navAndPager = new PageCells.NavAndPager(pad);

		navAndPager.addIcon("{ion-ios-search-strong 26dp}",()->{ Nav.push(new SearchPresenter());});

        return navAndPager.rootView;
    }

	public static class SearchTabPagerAdaptor extends PagerAdapter {
		final int PAGE_COUNT = 3;
		private String tabTitles[] = new String[] { "تگ","کاربر","پست"};//, "Tab3","Tab222","Tab222","Tab222" };
		private Context context;


		@Override
		public Object instantiateItem(ViewGroup container, int position) {
//			return super.instantiateItem(container, position);
			View v = o();
			switch (position){
				case 0:
					v = new SuggestionsTagsPresenter().buildView();
					break;
				case 1:
					v = new SuggestionsUsersPresenter().buildView();
//					v = o();
					break;
				default:
					v=  new SuggestionsPostsPresenter().buildView();
			}
			if (v!=null){
				container.addView(v);

			}
			return v;
			/*switch (position){
				case 0:
					return new SuggestionsTagsPresenter().buildView();
				case 1:
					return new SuggestionsUsersPresenter().buildView();
				default:
					return new SuggestionsPostsPresenter().buildView();
			}*/
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
//			super.destroyItem(container, position, object);
			container.removeView((View) object);
		}

		@Override
		public int getCount() {
			return PAGE_COUNT;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return tabTitles[position];
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == (View) object;
		}


		View o(){
			return new X.HelloWorldRow().root;
		}
	}

	@Deprecated
	public static class SearchTabPagerAdaptor2 extends FragmentPagerAdapter {
        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[] { "تگ","کاربر","پست"};//, "Tab3","Tab222","Tab222","Tab222" };
        private Context context;

        public SearchTabPagerAdaptor2(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new SuggestionsTagsPresenter().getFragment();
                case 1:
                    return new SuggestionsUsersPresenter().getFragment();
                default:
                    return new SuggestionsPostsPresenter().getFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
