package com.mardomsara.social.ui.cells;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.joanzapata.iconify.widget.IconTextView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/6/2016.
 */
public class PageCells {

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
		public NavAndPager() {
			rootView = (ViewGroup) AppUtil.inflate(R.layout.nav_header_pager_menu);
			viewPager = (ViewPager)rootView.findViewById(R.id.viewpager);
			tabLayout = (TabLayout)rootView.findViewById(R.id.sliding_tabs);
			iconsContainer = (ViewGroup) rootView.findViewById(R.id.search);
			tabLayout.setBackgroundColor(0xeeeeee);
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


	}


}
