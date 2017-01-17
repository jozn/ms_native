package com.mardomsara.social.ui.cells;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.Spanny;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/6/2016.
 */

//Use this class for wrapping general more advanced view wrapView functionality,
// most old class in this class are not necessary now thanks to new X.java class
public class Cells {

    public static class NavAndRecylerView {
        public ViewGroup rootView;
        @Bind(R.id.simpleTopNav)
        public SimpleTopNav simpleTopNav;
        @Bind(R.id.recycler_view)
        public RecyclerView recyclerView;


        public NavAndRecylerView() {
            rootView = (ViewGroup)AppUtil.inflate(R.layout.cell_page_cell_nav_recylcer_view);
            ButterKnife.bind(this, rootView);
        }
    }

    public static class NavAndEmptyView {
        public ViewGroup rootView;
        @Bind(R.id.simpleTopNav)
        public SimpleTopNav simpleTopNav;

        public NavAndEmptyView() {
            rootView = (ViewGroup)AppUtil.inflate(R.layout.cell_page_cell_nav_linear_view);
            ButterKnife.bind(this, rootView);
        }
    }

	public static class NavAndScrollContainer {
		public ViewGroup rootView;
		@Bind(R.id.simpleTopNav)
		public SimpleTopNav simpleTopNav;

		@Bind(R.id.container)
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

	public static class NavAndPager {
		public ViewGroup rootView;
		public ViewPager viewPager;
		public TabLayout tabLayout;
		public ViewGroup iconsContainer;

		public NavAndPager(PagerAdapter pagerAdaptor) {
			rootView = (ViewGroup) AppUtil.inflate(R.layout.nav_header_pager_menu);
			viewPager = (ViewPager)rootView.findViewById(R.id.viewpager);
			tabLayout = (TabLayout)rootView.findViewById(R.id.sliding_tabs);
			iconsContainer = (ViewGroup) rootView.findViewById(R.id.search);
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
			IconTextView iconTextView = new IconTextView(rootView.getContext());
			iconTextView.setText(iconIfyIcon);
			iconTextView.setTextColor(Color.BLACK);
			iconTextView.setPadding(dp10,0,dp10,0);
			iconTextView.setOnClickListener((v)->{
				if(runnable!= null) runnable.run();
			});
			iconsContainer.addView(iconTextView);
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
		@Bind(R.id.text_view)
		TextView text_view;

		@Bind(R.id.icon)
		TextView icon;

		public Title_BigClickAble(ViewGroup parent){
			rootView = (ViewGroup)AppUtil.inflate(R.layout.title_string_clickable,parent);
			ButterKnife.bind(this,rootView);
		}

		public Title_BigClickAble(ViewGroup parent, String title){
			this(parent);
			text_view.setText(title);
		}

		public void setIcon(String icon){
			this.icon.setText(icon);
		}

		public void setText(String title){
			text_view.setText(title);
		}
	}

	public static class Title_Info {
		public ViewGroup rootView;
		@Bind(R.id.text_view)
		TextView text_view;

		public Title_Info(ViewGroup parent){
			rootView =(ViewGroup) AppUtil.inflate(R.layout.title_info,parent);
			ButterKnife.bind(this,rootView);
		}
		public Title_Info(ViewGroup parent, String title){
			this(parent);
			text_view.setText(title);
		}

		public void setText(String title){
			text_view.setText(title);
		}
	}

	public static class Title_InfoLight {
		public ViewGroup rootView;
		@Bind(R.id.text_view)
		TextView text_view;

		public Title_InfoLight(ViewGroup parent){
			rootView =(ViewGroup) AppUtil.inflate(R.layout.title_info_light,parent);
			ButterKnife.bind(this,rootView);
		}

		public Title_InfoLight(ViewGroup parent, String title){
			this(parent);
			text_view.setText(title);
		}

		public void setText(String title){
			Spanny spanny = new Spanny();
			spanny.append(title, Typeface.BOLD);
			text_view.setText(spanny);
		}
	}

	/**
	 * Created by Hamid on 8/6/2016.
	 */
	public static class LoadingCell {
		public ViewGroup rootView;
	//    @Bind(R.id.progress_wheel)
	//    ProgressWheel progressWheel;

		public LoadingCell() {
			rootView = (ViewGroup) AppUtil.inflate(R.layout.loading_row);
	//        ButterKnife.bind(this, rootView);
	//        progressWheel.
		}
		public LoadingCell(ViewGroup parent) {
			rootView = (ViewGroup) AppUtil.inflate(R.layout.cell_loading,parent);
			ButterKnife.bind(this, rootView);
	//        progressWheel.spin();
	//        progressWheel.setBarColor(Color.GREEN);
	//        progressWheel.setProgress(0.8f);
	//        progressWheel.
		}

	}

	public static class Pager_RecyclerViewWithRefresher {

	}

	public static class Pager_RecyclerView {
		public X.Pager_RecyclerviewWithRefresher wrapView;
		LinearLayoutManager layoutManager;

		public Pager_RecyclerView(AppHeaderFooterRecyclerViewAdapter adaptor, AppHeaderFooterRecyclerViewAdapter.LoadNextPage pager) {
			wrapView = new X.Pager_RecyclerviewWithRefresher();
			layoutManager = new LinearLayoutManager(AppUtil.getContext());
			wrapView.recycler_view.setLayoutManager(layoutManager);
			wrapView.recycler_view.setAdapter(adaptor);
			adaptor.setUpForPaginationWith(wrapView.recycler_view,layoutManager,pager);
			adaptor.setEnableAutoShowEmptyView(true);
		}
	}
}
