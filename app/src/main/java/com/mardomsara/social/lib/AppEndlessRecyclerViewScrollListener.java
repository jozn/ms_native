package com.mardomsara.social.lib;

import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.mardomsara.social.helpers.AppUtil;

public abstract class AppEndlessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
    // The minimum amount of items to have below your current scroll position
    // before loadingView more.
    private int visibleThreshold = 5;
    // The current offsetType index of data you have loaded
    private int currentPage = 1;
    // The total number of items in the dataset after the last load
    private int previousTotalItemCount = 0;

	// True if we are still waiting for the last setOrReplace of data to load.
    private boolean loading = true;
    // Sets the starting page index
    private int startingPageIndex = 1;

	boolean disable =false;

    public void setStopMore(boolean stopMore) {
        this.stopMore = stopMore;
    }

    boolean stopMore = false;

    RecyclerView.LayoutManager mLayoutManager;
	HeaderFooterRecyclerViewAdapter adapter;

    public AppEndlessRecyclerViewScrollListener(LinearLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

	public AppEndlessRecyclerViewScrollListener(LinearLayoutManager layoutManager, HeaderFooterRecyclerViewAdapter adapter) {
		this.mLayoutManager = layoutManager;
		this.adapter = adapter;
	}

    public AppEndlessRecyclerViewScrollListener(GridLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * layoutManager.getSpanCount();
    }

    public AppEndlessRecyclerViewScrollListener(StaggeredGridLayoutManager layoutManager) {
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

	///////////// For Ticker
	boolean hastNextTickCheckInQueue = false;

	Runnable tickRunner = ()->{
		check();
		hastNextTickCheckInQueue = false;
	};

	Handler handler = new Handler();

    // This happens many times a second during a scroll, so be wary of the code you place here.
    // We are given a few useful parameters to help us work out if we need to load some more data,
    // but first we check if we are waiting for the previous load to finish.
    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {
		if(hastNextTickCheckInQueue == false){
			hastNextTickCheckInQueue = true;

			handler.postDelayed(tickRunner,100);
		}
    }

	void check(){
		if(disable) return;
		int lastVisibleItemPosition = 0;
		int totalItemCount;
		if(adapter != null){
			totalItemCount = adapter.getContentItemCount_0();
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

		if(false){
			calledCnt++;
			AppUtil.log("loadingView: "+ loading + " lastVisibleItemPosition: "+lastVisibleItemPosition
				+ " previousTotalItemCount: "+previousTotalItemCount
				+ " totalItemCount: "+totalItemCount
				+ "  currentPage: "+ currentPage
				+ " calledCnt: "+ calledCnt);
		}

		// If it isn’t currently loadingView, we check to see if we have breached
		// the visibleThreshold and need to reloadForAll more data.
		// If we do need to reloadForAll some more data, we execute onLoadMore to fetch the data.
		// threshold should reflect how many total columns there are too
		if (!loading && (lastVisibleItemPosition + visibleThreshold) > totalItemCount) {
			callNextPage();
		}
	}

	void callNextPage(){
		onLoadMore(currentPage, -1);
		currentPage++;
		loading = true;
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

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public boolean isLoading() {
		return loading;
	}
	// Defines the process for actually loadingView more data based on page
    public abstract void onLoadMore(int page, int totalItemsCount);

}

/* old way
	void check(){
		int lastVisibleItemPosition = 0;
		int totalItemCount;
		if(adapter != null){
			totalItemCount = adapter.getContentItemCount_0();
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
			AppUtil.log("loadingView: "+ loadingView + " lastVisibleItemPosition: "+lastVisibleItemPosition
				+ " previousTotalItemCount: "+previousTotalItemCount
				+ " totalItemCount: "+totalItemCount
				+ "  currentPage: "+ currentPage
				+ " calledCnt: "+ calledCnt);
		}

		// If the total item count is zero and the previous isn't, assume the
		// list is invalidated and should be reset back to initial state
		if (totalItemCount < previousTotalItemCount) {
			this.currentPage = this.startingPageIndex;
			this.previousTotalItemCount = totalItemCount;
			this.loadingView = false;
			if (totalItemCount == 0) {
//                this.loadingView = true;
			}
		}
		// If it’s still loadingView, we check to see if the dataset count has
		// changed, if so we conclude it has finished loadingView and onDownloadProgress the current page
		// number and total item count.
		if (loadingView && (totalItemCount > previousTotalItemCount)) {
			//Me: i have changed this line many times, if there is wired thinhs in pagination its po
			// posiible that this is causing problem
//            */
/*if(stopMore){//BY ME
			loadingView = false;
//            }*//*

//			if(stopMore){//BY ME
//				loadingView = false;
//            }
			previousTotalItemCount = totalItemCount;
		}

		// If it isn’t currently loadingView, we check to see if we have breached
		// the visibleThreshold and need to reloadForAll more data.
		// If we do need to reloadForAll some more data, we execute onLoadMore to fetch the data.
		// threshold should reflect how many total columns there are too
		if (!loadingView && (lastVisibleItemPosition + visibleThreshold) > totalItemCount) {
			onLoadMore(currentPage, totalItemCount);
			currentPage++;
			loadingView = true;
		}
	}
*/
