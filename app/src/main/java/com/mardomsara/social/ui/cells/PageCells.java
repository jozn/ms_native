package com.mardomsara.social.ui.cells;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mardomsara.social.R;
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


}
