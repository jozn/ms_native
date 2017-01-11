package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.ActivityRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.ActivityListCell;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import java.util.List;

/**
 * Created by Hamid on 7/13/2016.
 */
public class ActivityPresenter extends BasePresenter implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {
    ViewGroup viewRoot;
	ActivityListCell.ActivitiesAdaptor adaptor;
	SwipeRefreshLayout refreshLayout;

	List<ActivityRowJson> list;

    @Override
    public View buildView() {
		init();

        return refreshLayout;
    }

	private void init() {
		refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT, ViewHelper.MATCH_PARENT);
		adaptor = new ActivityListCell.ActivitiesAdaptor(list);
		RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
		LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
		recycler_view.setLayoutManager(layoutManager);
		recycler_view.setAdapter(adaptor);
		adaptor.setUpForPaginationWith(recycler_view, layoutManager, this);
		adaptor.showLoading();

		PageCells.InfoTitleLight title = new PageCells.InfoTitleLight(recycler_view);
		title.setText("آخرین فعالیت های دنبال شدگان شما:");
		adaptor.appendViewToHeader(title.rootView);

		refreshLayout.addView(recycler_view);
		refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				loadNextPage(1);
			}
		});
	}

	@Override
	public void loadNextPage(int pageNum) {
		if(pageNum>100){
			adaptor.setHasMorePage(false);
		}
		Http.getPath("/v1/activity")
			.setQueryParam("page",""+pageNum)
			.setQueryParam("limit",""+100)
			.setQueryParam("last",""+getLast(pageNum))
			.doAsyncUi((result -> {
				adaptor.nextPageIsLoaded();
				refreshLayout.setRefreshing(false);
				if(result.isOk()){
					HttpJsonList<ActivityRowJson> data = Result.fromJsonList(result,ActivityRowJson.class);

					if(data.isPayloadNoneEmpty()){
						if(pageNum == 1){
							adaptor.list.clear();
						}
						adaptor.list.addAll(data.Payload);
					}
				}

				adaptor.notifyDataChanged();

			}));

	}

	long getLast(int pageNum){
		if(pageNum==1){
			return 0;
		}
		if(adaptor.list.size()>0){
			return adaptor.list.get(adaptor.list.size()-1).Id;
		}
		return 0;
	}
}
