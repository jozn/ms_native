package com.mardomsara.social.lib;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.ui.views.wigets.LoadingView;

/**
 * Created by Hamid on 7/26/2016.
 */
@Deprecated
public abstract class PagerRecyclerViewAdapter extends HeaderFooterRecyclerViewAdapter {
    int footerSize = 1;

    @Override
    protected int getHeaderItemCount() {
        return 0;
    }

    @Override
    protected int getFooterItemCount() {
        return footerSize;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderItemViewHolder(ViewGroup parent, int headerViewType) {
        return null;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateFooterItemViewHolder(ViewGroup parent, int footerViewType) {
        return new HeaderViewHolder(LoadingView.getNewWraped());
    }


    @Override
    protected void onBindHeaderItemViewHolder(RecyclerView.ViewHolder headerViewHolder, int position) {

    }

    @Override
    protected void onBindFooterItemViewHolder(RecyclerView.ViewHolder footerViewHolder, int position) {

    }

    //// For pages///////////
    public  void setHasMorePage(boolean hasMore){
        if(hasMore){
            footerSize = 1;
            if(listener != null){
               recyclerView.addOnScrollListener(listener);
            }
            notifyFooterItemChanged(0);
        }else {
            footerSize = 0;
            if(listener != null){
                recyclerView.removeOnScrollListener(listener);
            }
            notifyFooterItemChanged(0);
        }
    }

    EndlessRecyclerViewScrollListener listener;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    LoadNextPage pager;

    public  void setupWith(RecyclerView recyclerView, LinearLayoutManager layoutManager ,LoadNextPage pager){
        this.recyclerView = recyclerView;
        this.layoutManager = layoutManager;
        this.pager = pager;
    }

    public void listenOnScroll(){
            listener =new EndlessRecyclerViewScrollListener(layoutManager){
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
//                loadNextPage();
//                if(pager!=null){
                    pager.loadNextPage();
//                }
            }
        };
        recyclerView.addOnScrollListener(listener);
    }

    protected abstract void loadNextPage();

    class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface LoadNextPage{
        void loadNextPage();
    }
}
