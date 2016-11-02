package com.mardomsara.social.lib;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.mardomsara.social.helpers.AppUtil;

public abstract class EndlessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
    // The minimum amount of items to have below your current scroll position
    // before loading more.
    private int visibleThreshold = 5;
    // The current offset index of data you have loaded
    private int currentPage = 0;
    // The total number of items in the dataset after the last load
    private int previousTotalItemCount = 0;
    // True if we are still waiting for the last setOrReplace of data to load.
    private boolean loading = true;
    // Sets the starting page index
    private int startingPageIndex = 1;

    public void setStopMore(boolean stopMore) {
        this.stopMore = stopMore;
    }

    boolean stopMore = false;

    RecyclerView.LayoutManager mLayoutManager;
	HeaderFooterRecyclerViewAdapter adapter;

    public EndlessRecyclerViewScrollListener(LinearLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

	public EndlessRecyclerViewScrollListener(LinearLayoutManager layoutManager,HeaderFooterRecyclerViewAdapter adapter) {
		this.mLayoutManager = layoutManager;
		this.adapter = adapter;
	}

    public EndlessRecyclerViewScrollListener(GridLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * layoutManager.getSpanCount();
    }

    public EndlessRecyclerViewScrollListener(StaggeredGridLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * layoutManager.getSpanCount();
    }

    public int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            }
            else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }

	int calledCnt = 0;

    // This happens many times a second during a scroll, so be wary of the code you place here.
    // We are given a few useful parameters to help us work out if we need to load some more data,
    // but first we check if we are waiting for the previous load to finish.
    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {
        check();
    }

	void check(){
		int lastVisibleItemPosition = 0;
		int totalItemCount;
		if(adapter != null){
			totalItemCount = adapter.getContentItemCount();
		}else {
			totalItemCount = mLayoutManager.getItemCount();
		}

		if (mLayoutManager instanceof StaggeredGridLayoutManager) {
			int[] lastVisibleItemPositions = ((StaggeredGridLayoutManager) mLayoutManager).findLastVisibleItemPositions(null);
			// get maximum element within the list
			lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions);
		} else if (mLayoutManager instanceof LinearLayoutManager) {
			lastVisibleItemPosition = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
		} else if (mLayoutManager instanceof GridLayoutManager) {
			lastVisibleItemPosition = ((GridLayoutManager) mLayoutManager).findLastVisibleItemPosition();
		}

		if(true){
			calledCnt++;
			AppUtil.log("loading: "+ loading + " lastVisibleItemPosition: "+lastVisibleItemPosition
				+ " previousTotalItemCount: "+previousTotalItemCount
				+ " totalItemCount: "+totalItemCount
				+ "  currentPage: "+ currentPage
				+ " calledCnt: "+ calledCnt);
		}

		// If the total item count is zero and the previous isn't, assume the
		// list is invalidated and should be reset back to initial state
		if (totalItemCount < previousTotalItemCount) {
//			this.currentPage = this.startingPageIndex;
			this.previousTotalItemCount = totalItemCount;
			this.loading = false;
			if (totalItemCount == 0) {
//                this.loading = true;
			}
		}
		// If it’s still loading, we check to see if the dataset count has
		// changed, if so we conclude it has finished loading and update the current page
		// number and total item count.
		if (loading && (totalItemCount > previousTotalItemCount)) {
			//Me: i have changed this line many times, if there is wired thinhs in pagination its po
			// posiible that this is causing problem
//            /*if(stopMore){//BY ME
			loading = false;
//            }*/
//			if(stopMore){//BY ME
//				loading = false;
//            }
			previousTotalItemCount = totalItemCount;
		}

		// If it isn’t currently loading, we check to see if we have breached
		// the visibleThreshold and need to reloadForAll more data.
		// If we do need to reloadForAll some more data, we execute onLoadMore to fetch the data.
		// threshold should reflect how many total columns there are too
		if (!loading && (lastVisibleItemPosition + visibleThreshold) > totalItemCount) {
			onLoadMore(currentPage, totalItemCount);
			currentPage++;
			loading = true;
		}
	}

	//call this when there is error in adding more data to items, like network error
	public void setLoading(boolean val){
		loading = val;
	}

	public void decrCurrentPage(){
		currentPage--;
	}

	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

    // Defines the process for actually loading more data based on page
    public abstract void onLoadMore(int page, int totalItemsCount);

}