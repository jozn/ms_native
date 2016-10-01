package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.API;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.http.TopTagsWithPostsJson;
import com.mardomsara.social.json.social.http.TopTagsWithPostsRowJson;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
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
//        adaptor = new UIPostsListGrid.TopTagsAdaptor();
        adaptor = new TopTagsAdaptor();
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
//        GridLayoutManager layoutManager = new GridLayoutManager(AppUtil.getContext(),3);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(recycler_view, layoutManager, this);
//        adaptor.setRecyclerView(recycler_view);
        adaptor.showLoading();

        refreshLayout.addView(recycler_view);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showMessage("re");
                loadFromServer();
            }
        });
        loadFromServer();
    }

    private void loadFromServer() {
        AndroidUtil.runInBackground(() -> {
            HttpOld.Req req = new HttpOld.Req();
            req.absPath = API.RECOMMEND_TOP_TAGS_DISCOVER;
            HttpOld.Result res = HttpOld.get(req);
            if (res.ok) {
                AndroidUtil.runInUi(() -> {
                    loadedPostsFromNet(res);
                });
            }
        });
    }

    private void loadedPostsFromNet(HttpOld.Result res) {
        TopTagsWithPostsJson data = JsonUtil.fromJson(res.data, TopTagsWithPostsJson.class);
        if (data != null && data.Payload != null && data.Status.equalsIgnoreCase("OK")) {

            if (data.Payload != null) {
                adaptor.list.addAll(data.Payload);
                adaptor.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void loadNextPage(int pageNum) {

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


        int size =0;

        public TagHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ButterKnife.bind(this,itemView);

            size = AndroidUtil.getScreenWidth()/3;

            image1.setLayoutParams(new LinearLayout.LayoutParams(size,size));
        }

        void bind(TopTagsWithPostsRowJson tagJson){
            text.setText("#"+tagJson.Tag.Name);

            if(tagJson.Posts == null) return;
//            if(tagJson.Posts)
            if(tagJson.Posts.size()>0){
                setImage(image1,tagJson.Posts.get(0).MediaUrl,tagJson.Tag.Name,tagJson.Posts.get(0));
            }

            if(tagJson.Posts.size()>1){
                setImage(image2,tagJson.Posts.get(1).MediaUrl,tagJson.Tag.Name,tagJson.Posts.get(0));
            }

            if(tagJson.Posts.size()>2){
                setImage(image3,tagJson.Posts.get(2).MediaUrl,tagJson.Tag.Name,tagJson.Posts.get(0));
            }
        }

        void setImage(ImageView image, String src, String tag, PostRowJson post) {
            src = "http://localhost:5000/"+src;
            AppUtil.log("SCC2" +src);
            if(src.equals("")) return;
            Picasso.with(AppUtil.getContext())
                    .load(src)
                    .resize(size,size)
                    .centerCrop()
                    .into(image);

            View.OnClickListener onClick = (v)->{
                Nav.push(new PostEnteryPresenter(post));
            };

            image.setOnClickListener(onClick);
        }


    }

}
