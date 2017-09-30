package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.presenter.pages.PostEntryPage;
import com.mardomsara.social.ui.presenter.pages.TagsPage;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SuggestionsTagsPresenter extends BasePresenter implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {
    @Override
    public View buildView() {
        refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT, ViewHelper.MATCH_PARENT);
        load();
        return refreshLayout;
    }

    TopTagsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;

    private void load() {
        adaptor = new TopTagsAdaptor();
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());

        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(recycler_view, layoutManager, this);

		Cells.Title_Info topTitle = new Cells.Title_Info(recycler_view);
		topTitle.setText("تگ های داغ");
		adaptor.appendViewToHeaderIfNotExist(topTitle.rootView);

        adaptor.showLoading();

        refreshLayout.addView(recycler_view);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showDebugMessage("re");
				adaptor.reload();
            }
        });
    }

    private void loadFromServer(int pageNum) {
		Http.getPath("/v1/recommend/top_tags_discover")
			.setQueryParam("page",""+pageNum)
			.setQueryParam("limit",""+8)
			.doAsyncUi(result -> {

				adaptor.nextPageIsLoaded(result);
				refreshLayout.setRefreshing(false);

				if(result.isOk()){
					HttpJsonList<JV.TopTagsWithPostsView> data = Result.fromJsonList(result,JV.TopTagsWithPostsView.class);
					if(data.isPayloadNoneEmpty()){
						if(pageNum==1){

						}
						adaptor.list.addAll(data.Payload);
						adaptor.notifyDataSetChanged();

					}else{
						adaptor.setHasMorePage(false);
					}

				}else {
					adaptor.setHasMorePage(false);
				}
			});
    }

    @Override
    public void loadNextPage(int pageNum) {
		Helper.showDebugMessage("page tags: "+ pageNum);

		loadFromServer(pageNum);
    }

    public static class TopTagsAdaptor extends AppHeaderFooterRecyclerViewAdapter<TagHolder> {

        List<JV.TopTagsWithPostsView> list = new ArrayList<>();

        @Override
        protected int getContentItemCount() {
            return list.size();
        }

        @Override
        protected TagHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            return new TagHolder(new X.Recommend_TopTags(parent));
        }

        @Override
        protected void onBindContentItemViewHolder(TagHolder tagHolder, int position) {
            tagHolder.bind(list.get(position));
        }
    }

    public static class TagHolder extends RecyclerView.ViewHolder {
		X.Recommend_TopTags x;

        int size =0;

        public TagHolder( X.Recommend_TopTags x) {
            super(x.root);
			this.x = x;

            size = AndroidUtil.getScreenWidth()/3;
        }

        void bind(JV.TopTagsWithPostsView tagJson){
            x.text.setText("#"+tagJson.Tag.Name);

			x.see_more.setOnClickListener((v)->{
				Nav.push(new TagsPage(tagJson.Tag.Name));
			});
			x.see_more.setTypeface(FontCache.getIranLight());
			x.see_more.setText("همه {ion-ios-arrow-left 12dp}");

            if(tagJson.Posts == null) return;

			x.image1.setVisibility(View.GONE);
			x.image2.setVisibility(View.GONE);
			x.image3.setVisibility(View.GONE);

			JV.PostView post;
//            if(tagJson.Posts)
            if(tagJson.Posts.size()>0){
				post = tagJson.Posts.get(0);
                setImage(x.image1, post, tagJson.Tag.Name,post);
            }

            if(tagJson.Posts.size()>1){
				post = tagJson.Posts.get(1);
                setImage(x.image2, post, tagJson.Tag.Name,post);
            }

            if(tagJson.Posts.size()>2){
				post = tagJson.Posts.get(2);
                setImage(x.image3, post, tagJson.Tag.Name,post);
            }
        }
		static int s = AndroidUtil.getScreenWidth() / 3;
        void setImage(ImageView image, JV.PostView postView, String tag, JV.PostView post) {
			image.setVisibility(View.VISIBLE);
			//todo extract this url
            String src = Helper.postsGetBestPhotoResUrl(postView.PhotoView,s) ;//"http://192.168.1.250:5000/"+src;
            AppUtil.log("SCC2" +src);
            if(src.equals("")) return;
            Picasso.with(AppUtil.getContext())
                    .load(src)
                    .resize(size,size)
                    .centerCrop()
                    .into(image);

            View.OnClickListener onClick = (v)->{
                Nav.push(new PostEntryPage(post));
            };

            image.setOnClickListener(onClick);
        }
    }

}
