package com.mardomsara.social.ui.cells.lists;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.ui.UIPostsList;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/26/2016.
 */
public class StringListCell
        implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

    View loading;
    PostsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;

    public StringListCell(List<String> list) {
        init(list);
    }

    private void init(List<String> list) {
        refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT, ViewHelper.MATCH_PARENT);
        adaptor = new PostsAdaptor(list);
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(recycler_view, layoutManager, this);
        adaptor.showLoading();

        refreshLayout.addView(recycler_view);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showMessage("re");
            }
        });
    }

    public ViewGroup getViewRoot() {
        return refreshLayout;
    }

    @Override
    public void loadNextPage(int pageNum) {
        Helper.showMessage("pageNum: "+pageNum);
    }

    public static class PostsAdaptor extends AppHeaderFooterRecyclerViewAdapter<TextHolder> {

        List<String> list = new ArrayList<>();
        public PostsAdaptor(List<String> list){
            super();
            if(list != null){
                this.list.addAll(list);
            }
        }

        @Override
        protected int getContentItemCount() {
            return list.size();
        }

        @Override
        protected TextHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            return new TextHolder(new TextView(AppUtil.getContext()));
        }

        @Override
        protected void onBindContentItemViewHolder(TextHolder textHolder, int position) {
            textHolder.view.setText(list.get(position));
        }
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        TextView view;
        public TextHolder(TextView itemView) {
            super(itemView);
            view = itemView;
        }
    }
}
