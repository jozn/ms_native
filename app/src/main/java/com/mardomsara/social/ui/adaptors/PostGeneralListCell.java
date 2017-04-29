package com.mardomsara.social.ui.adaptors;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.post.PostRowCompactWrapper;
import com.mardomsara.social.ui.cells.rows.PostRowNewCell;
import com.mardomsara.social.ui.views.buttons.ButtonPostMultiWayView;
import com.mardomsara.social.ui.views.buttons.PostWayToShow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostGeneralListCell
        implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

	X.PostList_Parent x;
	public PostsAdaptor adaptor;
	NextPage nextPage;

    public PostGeneralListCell(ButtonPostMultiWayView multiWayView, NextPage nextPage1) {
        init( multiWayView);
		this.nextPage = nextPage1;
    }

    private void init(ButtonPostMultiWayView multiWayView) {
		x = new X.PostList_Parent();

        adaptor = new PostsAdaptor(multiWayView.getPostWayToShow());
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
        x.recycler_view.setLayoutManager(layoutManager);
        x.recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(x.recycler_view,layoutManager,this);
        adaptor.showLoading();
		adaptor.setEnableAutoShowEmptyView(true);

		x.refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showDebugMessage("reload");
                loadFromServer(1);
            }
        });

		multiWayView.setOnChangeListener((type)->{
			switch (type) {
				case COMPACT:
					break;
				case WIDE:
					break;
				case MINI:
					break;
			}
			adaptor.postWayToShow = type; //why we must this?? - dont adaptoer refers to same object
//			Helper.showDebugMessage("t: "+type.id);
			adaptor.notifyDataChanged();
		});
    }

    String endPointAbsPath;
    public void setLoadingEndPoint(String absPath){
        this.endPointAbsPath = absPath;
    }

    public void loadFromServer(int page) {
		nextPage.nextPage(page,this);
       /* if(endPointAbsPath == null){
            throw new IllegalArgumentException("In PostsListCell endPointAbsPath url must be setOrReplace for loading_progress posts");
        }

		Http.get(endPointAbsPath)
			.setQueryParam("page",""+page)
			.setQueryParam("last",""+getLastPostId(page))
			.doAsyncUi((result)->{
				loadedPostsFromNetNew(result,page);
				adaptor.nextPageIsLoaded();
			});*/
    }

    public int getLastPostId(int page) {
		if(page == 1)return 0;//fix for refreshing
        if(adaptor.posts.size() > 0 ){
            return adaptor.posts.get(adaptor.posts.size()-1).Id;
        }
        return 0;
    }

	public void loadedPostsFromNetNew(Result res, int page) {
		hideRefreshLoading();
		Helper.showDebugMessage("Http isOk?: " + res.isOk());
		adaptor.nextPageIsLoaded(res);
		boolean end = false;
		if(res.isOk()) {
			HttpJsonList<JV.PostView> data= Result.fromJsonList(res, JV.PostView.class);
			if(data != null){
				AndroidUtil.runInUiNoPanic(()->{
					if (data.Payload == null){
						return;
					}

					if(data.Payload.size() == 0){
						adaptor.setHasMorePage(false);
					}
					if( data.isPayloadNoneEmpty() ){
						if(page == 1){
							adaptor.posts.clear();
						}
						adaptor.posts.addAll(data.Payload);
						adaptor.notifyDataSetChanged();
					}
					adaptor.autoCheckAndSetEmptyView();
				});
			}
			else {
				end = true;
			}
		}else {
			end = true;
//			adaptor.showFullTryReload(res);
		}
		if(end){
			adaptor.setHasMorePage(false);
		}
	}

	private void hideRefreshLoading(){
		x.refresh_layout.setRefreshing(false);
	}

    public ViewGroup getViewRoot() {
        return x.root;
    }

	//pageNum is >= 1
    @Override
    public void loadNextPage(int pageNum) {
        Helper.showDebugMessage("pageNum: "+pageNum);
        loadFromServer(pageNum);
    }

	public static class PostsAdaptor extends AppHeaderFooterRecyclerViewAdapter<CommonPostBinder> {
		public List<JV.PostView> posts = new ArrayList<>();
		PostWayToShow postWayToShow;

		public PostsAdaptor(PostWayToShow postWayToShow) {
//			setHasStableIds(false);
			this.postWayToShow = postWayToShow;
		}

		@Override
		protected int getContentItemCount() {
			return posts.size();
		}

		@Override
		protected CommonPostBinder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
//            View v = AppUtil.inflate(R.layout.row_post_stream, parent);

			if(PostWayToShow.WIDE.id == contentViewType){
				return new PostWideVH(new PostRowNewCell(null));
			}else if (PostWayToShow.COMPACT.id == contentViewType){
				return new PostCompactVH(new PostRowCompactWrapper(null));
			}
			return null;
			/*PostRowNewCell postRowCell = new PostRowNewCell(null);
			return new PostStreamHolder(new PostRowCompactWrapper(null));*/
		}

		@Override
		protected void onBindContentItemViewHolder(CommonPostBinder postStreamHolder, int position) {
//            postStreamHolder.bind(posts.get(position));
			postStreamHolder.bind(posts.get(position));
		}

		@Override
		protected int getContentItemViewType(int position) {
			return postWayToShow.id;
		}

		@Override
		public void setHasStableIds(boolean hasStableIds) {
			super.setHasStableIds(hasStableIds);
		}
	}

	/**
	 * Created by Hamid on 8/3/2016.
	 */
	public static class PostCompactVH extends CommonPostBinder{
		PostRowCompactWrapper postRowCell;
		public PostCompactVH(PostRowCompactWrapper postCell) {
			super(postCell.x.root);
			this.postRowCell = postCell;
		}

		@Override
		public void bind(JV.PostView postRowJson) {
			postRowCell.bind(postRowJson);
		}
	}

	public static class PostWideVH extends CommonPostBinder {
		PostRowNewCell postRowCell;
		public PostWideVH(PostRowNewCell postCell) {
			super(postCell.rootView);
			this.postRowCell = postCell;
		}

		@Override
		public void bind(JV.PostView postRowJson) {
			postRowCell.bind(postRowJson);
		}
	}

	static abstract class CommonPostBinder extends RecyclerView.ViewHolder{
		abstract void bind(JV.PostView postRowJson);

		public CommonPostBinder(View itemView) {
			super(itemView);
		}
	}

	private class HomeAddPostBox {

		public HomeAddPostBox(ViewGroup parent) {

		}
	}

	//////////////////////////////
	//we must after requesting the page do cell.loadedPostsFromNetNew(http.Res)
	public interface NextPage {
		void nextPage(int pgae, PostGeneralListCell cell);
	}
}
