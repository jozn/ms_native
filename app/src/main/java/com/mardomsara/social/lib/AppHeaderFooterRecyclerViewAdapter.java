package com.mardomsara.social.lib;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.ui.cells.LoadingCell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/4/2016.
 */

///NOTICE: notify**Changed() shoulld not be called in here (we should not manuplate views in
// here) it must be called from apps code -- it will be bugy
public abstract class AppHeaderFooterRecyclerViewAdapter<T extends RecyclerView.ViewHolder> extends
        HeaderFooterRecyclerViewAdapter<
                T,
                AppHeaderFooterRecyclerViewAdapter.HeaderViewHolder,
                AppHeaderFooterRecyclerViewAdapter.FooterViewHolder> {

    List<ViewTag> headerViews = new ArrayList<>();
    List<ViewTag> footerViews = new ArrayList<>();

    int footerTypeId = 0;
    int headerTypeId = 0;

//    RecyclerView recyclerView;
    @Override
    protected int getHeaderItemCount() {
        return headerViews.size();
    }

    @Override
    protected int getFooterItemCount() {
        return footerViews.size();
    }

    @Override
    protected int getFooterItemViewType(int position) {
        if(footerViews.get(position) != null){
            return footerViews.get(position).typeId;
        }
        return 0;
    }

    @Override
    protected int getHeaderItemViewType(int position) {
        if(headerViews.get(position) != null){
            return headerViews.get(position).typeId;
        }
        return 0;
    }

    @Override
    protected void onBindHeaderItemViewHolder(HeaderViewHolder headerViewHolder, int position) {

    }

    @Override
    protected void onBindFooterItemViewHolder(FooterViewHolder footerViewHolder, int position) {

    }

    @Override
    protected FooterViewHolder onCreateFooterItemViewHolder(ViewGroup parent, int footerViewType) {
        for(ViewTag tag : footerViews){
            if(tag.typeId == footerViewType){
                return new FooterViewHolder(tag.view);
            }
        }
        return null;
    }

    @Override
    protected HeaderViewHolder onCreateHeaderItemViewHolder(ViewGroup parent, int headerViewType) {
        for(ViewTag tag : headerViews){
            if(tag.typeId == headerViewType){
                return new HeaderViewHolder(tag.view);
            }
        }
        return null;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }


    public static class FooterViewHolder extends RecyclerView.ViewHolder{
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void appendViewToFooter(View view){
        footerTypeId++;
        ViewTag tag = new ViewTag();
        tag.typeId=footerTypeId;
        tag.view = view;
        footerViews.add(tag);
    }

    public void removeViewFromFooter(View view){
        for(ViewTag tag : footerViews) {
            if (tag.view == view) {
                footerViews.remove(tag);
            }
        }
    }

    public void appendViewToHeader(View view){
        headerTypeId++;
        ViewTag tag = new ViewTag();
        tag.typeId=headerTypeId;
        tag.view = view;
        headerViews.add(tag);
    }

    public void removeViewFromHeader(View view){
        for(ViewTag tag : headerViews) {
            if (tag.view == view) {
                headerViews.remove(tag);
            }
        }
    }

    //needed for centering LoadingView
    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    //////////////// For LoadingView ///////////////////////////////
    View loading;
    boolean isShowingLoading = false;
    public void showLoading(){
        if( ! isShowingLoading){
            loading = new LoadingCell(recyclerView).rootView;
            appendViewToFooter(loading);
            isShowingLoading =true;
        }
    }

    public void hideLoading(){
        if(loading!= null){
            loading.setVisibility(View.GONE);
        }
//        removeViewFromFooter(loading);
    }

    //// For multi pages ///////////

    EndlessRecyclerViewScrollListener scrollListener;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    LoadNextPage pager;
    int pageNum = 0;

    public  void setHasMorePage(boolean hasMore){
        if(hasMore){
//            footerSize = 1;
            if(scrollListener != null && getContentItemCount() >0){
                recyclerView.addOnScrollListener(scrollListener);
//                notifyFooterItemChanged(0);
            }
        }else {
//            footerSize = 0;
            hideLoading();
            if(scrollListener != null && getContentItemCount() >0){
                recyclerView.removeOnScrollListener(scrollListener);
                //ME:dont do this it will crash: reason: child not attached???
//                notifyFooterItemChanged(0);
            }
        }
    }

    //
    public  void setUpForPaginationWith(RecyclerView recyclerView, LinearLayoutManager layoutManager , LoadNextPage pager){
        this.recyclerView = recyclerView;
        this.layoutManager = layoutManager;
        this.pager = pager;
        if(this.layoutManager != null && this.pager != null){
            showLoading();
            listenOnScroll();
        }
    }

    public void listenOnScroll(){

        scrollListener =new EndlessRecyclerViewScrollListener(layoutManager){
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
//                loadNextPage();
                if(pager!=null){
                    pager.loadNextPage(page);
                    pageNum++;
                }
            }
        };
        //ME: somehow if we attach scrollListener in here befor View attached to window it will
        //crashe. so add it after attached in onAttached
//        recyclerView.addOnScrollListener(scrollListener);
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if(scrollListener != null){
            recyclerView.addOnScrollListener(scrollListener);
        }
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(scrollListener != null){
            recyclerView.removeOnScrollListener(scrollListener);
        }
    }

    public GridLayoutManager.SpanSizeLookup getSpanSizeForSimpleContentGridLayput(int contentSpanSize){
        return new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int sizeHeader = getHeaderItemCount();
                int sizeFooter = getFooterItemCount();
                int sizeContent = getContentItemCount();

                if (sizeHeader > 0 && position < sizeHeader) {
                    return contentSpanSize;
                } else if (sizeContent > 0 && position - sizeHeader < sizeContent) {
                    return 1;
                } else {//footer
                    return contentSpanSize;
                }
            }
        };
    }

    ///////////////////////////////////////////////
    ///// Class ///////////////
    class ViewTag {
        View view;
        int typeId;
    }

    public interface LoadNextPage{
        void loadNextPage(int pageNum);
    }
    /*public interface Binder{
        public void bind(int relativePosition);
    }*/

}
