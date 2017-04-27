package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.json.social.rows.TopTagsWithPostsRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.presenter.pages.PostEntryPage_OLD;
import com.mardomsara.social.ui.presenter.pages.TagsPage;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

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
			.setFormParam("page",""+pageNum)
			.doAsyncUi(result -> {

				adaptor.nextPageIsLoaded(result);
				refreshLayout.setRefreshing(false);

				if(result.isOk()){
					HttpJsonList<TopTagsWithPostsRowJson> data = Result.fromJsonList(result,TopTagsWithPostsRowJson.class);
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

		//for now just one page
		if(pageNum > 1){
			adaptor.setHasMorePage(false);
			return;
		}
		loadFromServer(pageNum);
    }

    public static class TopTagsAdaptor extends AppHeaderFooterRecyclerViewAdapter<TagHolder> {

        List<TopTagsWithPostsRowJson> list = new ArrayList<>();

        @Override
        protected int getContentItemCount() {
            return list.size();
        }

        @Override
        protected TagHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            View v = AppUtil.inflate(R.layout.presenter_top_tags,parent);
            return new TagHolder(v);
        }

        @Override
        protected void onBindContentItemViewHolder(TagHolder tagHolder, int position) {
            tagHolder.bind(list.get(position));
        }
    }

    public static class TagHolder extends RecyclerView.ViewHolder {
        View rootView;

        @Bind(R.id.image1) ImageView image1;
        @Bind(R.id.image2) ImageView image2;
        @Bind(R.id.image3) ImageView image3;
        @Bind(R.id.text) TextView text;
        @Bind(R.id.see_more)
		IconTextView see_more;

        int size =0;

        public TagHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ButterKnife.bind(this,itemView);

            size = AndroidUtil.getScreenWidth()/3;

//            image1.setLayoutParams(new LinearLayout.LayoutParams(size,size));
        }

        void bind(TopTagsWithPostsRowJson tagJson){
            text.setText("#"+tagJson.Tag.Name);

			see_more.setOnClickListener((v)->{
				Nav.push(new TagsPage(tagJson.Tag.Name));
			});
			see_more.setTypeface(FontCache.getIranLight());
			see_more.setText("همه {ion-ios-arrow-left 12dp}");

            if(tagJson.Posts == null) return;

			image1.setVisibility(View.GONE);
			image2.setVisibility(View.GONE);
			image3.setVisibility(View.GONE);

			PostRowJson post;
//            if(tagJson.Posts)
            if(tagJson.Posts.size()>0){
				post = tagJson.Posts.get(0);
                setImage(image1, post.MediaUrl, tagJson.Tag.Name,post);
            }

            if(tagJson.Posts.size()>1){
				post = tagJson.Posts.get(1);
                setImage(image2, post.MediaUrl, tagJson.Tag.Name,post);
            }

            if(tagJson.Posts.size()>2){
				post = tagJson.Posts.get(2);
                setImage(image3, post.MediaUrl, tagJson.Tag.Name,post);
            }
        }

        void setImage(ImageView image, String src, String tag, PostRowJson post) {
			image.setVisibility(View.VISIBLE);
			//todo extract this url
            src = "http://localhost:5000/"+src;
            AppUtil.log("SCC2" +src);
            if(src.equals("")) return;
            Picasso.with(AppUtil.getContext())
                    .load(src)
                    .resize(size,size)
                    .centerCrop()
                    .into(image);

            View.OnClickListener onClick = (v)->{
                Nav.push(new PostEntryPage_OLD(post));
            };

            image.setOnClickListener(onClick);
        }
    }

}
