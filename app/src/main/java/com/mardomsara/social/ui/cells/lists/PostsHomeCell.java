package com.mardomsara.social.ui.cells.lists;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.rows.PostRowCell;
import com.mardomsara.social.ui.cells.rows.PostRowNewCell;
import com.mardomsara.social.ui.presenter.pages.add_post.AddPostPage;
import com.mardomsara.social.ui.presenter.pages.add_post.PostAddGalleryChooserPresenter;
import com.mardomsara.social.ui.presenter.pages.add_post.RecentImagesAddPostBoxCell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostsHomeCell
        implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

	X.Home_Parent x;
	public PostsAdaptor adaptor;

    public PostsHomeCell() {
        init();
    }

    private void init() {
		x = new X.Home_Parent();


        adaptor = new PostsAdaptor();
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
        x.recycler_view.setLayoutManager(layoutManager);
        x.recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(x.recycler_view,layoutManager,this);
        adaptor.showLoading();
		adaptor.setEnableAutoShowEmptyView(true);

		setUpAddPostBox();

		x.refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showDebugMessage("reload");
                loadFromServer(1);
            }
        });
    }

    String endPointAbsPath;
    public void setLoadingEndPoint(String absPath){
        this.endPointAbsPath = absPath;
    }

    public void loadFromServer(int page) {
        if(endPointAbsPath == null){
            throw new IllegalArgumentException("In PostsListCell endPointAbsPath url must be setOrReplace for loading_progress posts");
        }

		Http.get(endPointAbsPath)
			.setQueryParam("page",""+page)
			.setQueryParam("last",""+getLastPostId(page))
			.doAsyncUi((result)->{
				loadedPostsFromNetNew(result,page);
				adaptor.nextPageIsLoaded();
			});
    }

    private int getLastPostId(int page) {
		if(page == 1)return 0;//fix for refreshing
        if(adaptor.posts.size() > 0 ){
            return adaptor.posts.get(adaptor.posts.size()-1).Id;
        }
        return 0;
    }

	private void loadedPostsFromNetNew(Result res, int page) {
		hideRefreshLoading();
		Helper.showDebugMessage("Http isOk?: " + res.isOk());
		adaptor.nextPageIsLoaded(res);
		if(res.isOk()) {
			HttpJsonList<PostRowJson> data= Result.fromJsonList(res, PostRowJson.class);
			if(data != null){
				AndroidUtil.runInUiNoPanic(()->{
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
		}else {
//			adaptor.showFullTryReload(res);
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

	private void setUpAddPostBox(){
		//must be called after setting layoutManager for x.recycler_view
		X.Home_AddPostBox addPostBox = new X.Home_AddPostBox(x.recycler_view);
		adaptor.appendViewToHeader(addPostBox.root);

		addPostBox.top_holder.setOnClickListener((v)-> Nav.push(new AddPostPage()));
		addPostBox.gallery_btn.setOnClickListener((v) -> {
			Nav.push(new PostAddGalleryChooserPresenter());
		});

		RecentImagesAddPostBoxCell recentImagesCell = new RecentImagesAddPostBoxCell(addPostBox.recent_images_holder);
		recentImagesCell.insertInto(addPostBox.recent_images_holder);


	}

	public static class PostsAdaptor extends AppHeaderFooterRecyclerViewAdapter<PostStreamHolder> {
		public List<PostRowJson> posts = new ArrayList<>();

		@Override
		protected int getContentItemCount() {
			return posts.size();
		}

		@Override
		protected PostStreamHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
//            View v = AppUtil.inflate(R.layout.row_post_stream, parent);
			PostRowNewCell postRowCell = new PostRowNewCell(null);
			return new PostStreamHolder(postRowCell);
		}

		@Override
		protected void onBindContentItemViewHolder(PostStreamHolder postStreamHolder, int position) {
//            postStreamHolder.bind(posts.get(position));
			postStreamHolder.postRowCell.bind(posts.get(position));
		}
	}

	/**
	 * Created by Hamid on 8/3/2016.
	 */
	public static class PostStreamHolder extends RecyclerView.ViewHolder {
		PostRowNewCell postRowCell;
		public PostStreamHolder(PostRowNewCell postCell) {
			super(postCell.rootView);
			this.postRowCell = postCell;
		}
	}

	private class HomeAddPostBox {

		public HomeAddPostBox(ViewGroup parent) {

		}
	}
}
