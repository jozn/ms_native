package com.mardomsara.social.ui.cells;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.Spanny;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/6/2016.
 */

//Use this class for wrapping general more advanced view wrapView functionality,
// most old class in this class are not necessary now thanks to new X.java class
public class Cells {

    public static class NavAndRecylerView {
        public ViewGroup rootView;
        @BindView(R.id.simpleTopNav)
        public SimpleTopNav simpleTopNav;
        @BindView(R.id.recycler_view)
        public RecyclerView recyclerView;


        public NavAndRecylerView() {
            rootView = (ViewGroup)AppUtil.inflate(R.layout.cell_page_cell_nav_recylcer_view_bk);
            ButterKnife.bind(this, rootView);
        }
    }

    public static class NavAndEmptyView {
        public ViewGroup rootView;
        @BindView(R.id.simpleTopNav)
        public SimpleTopNav simpleTopNav;

        public NavAndEmptyView() {
            rootView = (ViewGroup)AppUtil.inflate(R.layout.pager__cell_nav_linear_view);
            ButterKnife.bind(this, rootView);
        }
    }

	public static class NavAndScrollContainer {
		public ViewGroup rootView;
		@BindView(R.id.simpleTopNav)
		public SimpleTopNav simpleTopNav;

		@BindView(R.id.container)
		public ViewGroup container;

		public NavAndScrollContainer() {
			rootView = (ViewGroup)AppUtil.inflate(R.layout.cell_page_cell_nav_scroll_container_view);
			ButterKnife.bind(this, rootView);
		}
	}

    public static class ComingSoon {
        public ViewGroup rootView;
        public ComingSoon() {
            rootView = (ViewGroup)AppUtil.inflate(R.layout.cell_page_comming_soon);
        }
    }

    public static class Scroller {
        public ViewGroup rootView;
        public ViewGroup layout;//addStart views to this
        public Scroller() {
            rootView = (ViewGroup)AppUtil.inflate(R.layout.cell_page_scroller);
            layout = (ViewGroup)rootView.findViewById(R.id.layout);
        }
    }

	public static class NavAndPagerSwipe {
		public ViewGroup rootView;
		public ViewPager viewPager;
		public TabLayout tabLayout;
		public ViewGroup iconsContainer;

		public NavAndPagerSwipe(PagerAdapter pagerAdaptor) {
			rootView = (ViewGroup) AppUtil.inflate(R.layout.nav_header_pager_menu);
			viewPager = (ViewPager)rootView.findViewById(R.id.viewpager);
			tabLayout = (TabLayout)rootView.findViewById(R.id.sliding_tabs);
			iconsContainer = (ViewGroup) rootView.findViewById(R.id.search);
			iconsContainer.setVisibility(View.GONE);
			tabLayout.setBackgroundColor(0xeeeeee);

			tabLayout.setTabMode(TabLayout.MODE_FIXED);
			viewPager.setAdapter(pagerAdaptor);
			tabLayout.setupWithViewPager(viewPager);
//
			//must called here
			for (int i = 0; i < tabLayout.getTabCount(); i++) {
				TabLayout.Tab t = tabLayout.getTabAt(i);
				t.setCustomView( getTabView(i,pagerAdaptor) );
			}

			viewPager.setCurrentItem(pagerAdaptor.getCount()-1);
		}

		public void addIcon(String iconIfyIcon, Runnable runnable){
			int dp10 = AndroidUtil.dpToPx(10);
			iconsContainer.setVisibility(View.VISIBLE);
			X.Nav_IconHolder iconHolder =new X.Nav_IconHolder(iconsContainer);
			iconHolder.icon_text.setText(iconIfyIcon);
			iconHolder.root.setOnClickListener((v)->{
				if(runnable!= null) runnable.run();
			});
			iconsContainer.addView(iconHolder.root);
			/*
			IconTextView iconTextView = new IconTextView(rootView.getContext());
			iconTextView.setTextColor(Color.BLACK);
			iconTextView.setPadding(dp10,0,dp10,0);
			iconTextView.setOnClickListener((v)->{
				if(runnable!= null) runnable.run();
			});*/

		}

		private View getTabView(int position,PagerAdapter pagerAdaptor) {
			View v = AppUtil.inflate(R.layout.tab_cell_general, null);
			TextView tv = (TextView) v.findViewById(R.id.textView);
			tv.setText(pagerAdaptor.getPageTitle(position));
			return v;
		}
	}


	//////////////////////////////////////////////////////
	///////////////////// Title //////////////////////////

	public static class Title_BigClickAble {
		public ViewGroup rootView;
		X.Title_ClickableNewPage x;

		public Title_BigClickAble(ViewGroup parent){
			x = new X.Title_ClickableNewPage(parent);
			rootView = x.root;
		}

		public Title_BigClickAble(ViewGroup parent, String title){
			this(parent);
			x.text_view.setText(title);
		}

		public void setIcon(String icon){
			x.icon.setText(icon);
		}

		public void setText(String title){
			x.text_view.setText(title);
		}
	}

	public static class Title_Info {
		public ViewGroup rootView;
		public X.Title_Info x;

		public Title_Info(ViewGroup parent){
			x = new X.Title_Info(parent);
			rootView = x.root;
		}
		public Title_Info(ViewGroup parent, String title){
			this(parent);
			x.text_view.setText(title);
		}

		public void setText(String title){
			x.text_view.setText(title);
		}
	}

	public static class Title_InfoLight {
		public ViewGroup rootView;
		X.Title_InfoLight x;

		public Title_InfoLight(ViewGroup parent){
			x = new X.Title_InfoLight(parent);
			rootView = x.root;
		}

		public Title_InfoLight(ViewGroup parent, String title){
			this(parent);
			x.text_view.setText(title);
		}

		public void setText(String title){
			Spanny spanny = new Spanny();
			spanny.append(title, Typeface.BOLD);
			x.text_view.setText(spanny);
		}
	}

	/**
	 * Created by Hamid on 8/6/2016.
	 */
	public static class LoadingCell {
		public ViewGroup rootView;

		public LoadingCell(ViewGroup parent) {
			rootView = (ViewGroup) AppUtil.inflate(R.layout.common__cell_loading,parent);
			ButterKnife.bind(this, rootView);
		}

	}

	public static class Pager_RecyclerView {
		public X.Pager_RecyclerviewWithRefresher wrapView;
		LinearLayoutManager layoutManager;

		public Pager_RecyclerView(AppHeaderFooterRecyclerViewAdapter adaptor,
		 AppHeaderFooterRecyclerViewAdapter.LoadNextPage pager) {
			wrapView = new X.Pager_RecyclerviewWithRefresher();
			layoutManager = new LinearLayoutManager(AppUtil.getContext());
			wrapView.recycler_view.setLayoutManager(layoutManager);
			wrapView.recycler_view.setAdapter(adaptor);
			adaptor.setUpForPaginationWith(wrapView.recycler_view,layoutManager,pager);
			adaptor.setEnableAutoShowEmptyView(true);
		}
	}
}
