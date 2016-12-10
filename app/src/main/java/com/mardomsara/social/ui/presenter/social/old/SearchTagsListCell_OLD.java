package com.mardomsara.social.ui.presenter.social.old;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.app.API;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.http.TagsListJson;
import com.mardomsara.social.json.social.rows.TagRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/29/2016.
 */
public class SearchTagsListCell_OLD {
    public LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext(),LinearLayoutManager.VERTICAL,false);
    RecyclerView recyclerView = ViewHelper.newRecyclerViewWraped();
    public TagsAdaptor adaptor;

    String tagName;
    public SearchTagsListCell_OLD(String tagName) {
        this.tagName = tagName;
        adaptor = new TagsAdaptor();
        load();
    }

    private void load() {
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(layoutManager);

        loadTagsFromNet(0);
    }

    public void setNewTag(String tag){
        tagName = tag;
        loadTagsFromNet(0);
    }

    private void loadTagsFromNet(int page) {
        AndroidUtil.runInBackground(()->{
            HttpOld.Req req = new HttpOld.Req();
            req.absPath = API.SEARCH_TAGS;
            req.urlParams.put("q",""+tagName);
            req.urlParams.put("tag",""+tagName);
            req.urlParams.put("page",""+page);
            HttpOld.Result res = HttpOld.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                    loadedTagsFromNet(res);
                });
            }
        });
    }

    private void loadedTagsFromNet(HttpOld.Result res) {
        TagsListJson data = JsonUtil.fromJson(res.data, TagsListJson.class);
        if(data != null && data.Status.equalsIgnoreCase("OK") && data.Payload!=null){
            adaptor.list.clear();
            adaptor.list.addAll(data.Payload);
            adaptor.notifyDataSetChanged();
            adaptor.setHasMorePage(false);//just one page
        }else {
            adaptor.setHasMorePage(false);
        }
    }

    public ViewGroup getViewRoot() {
        return recyclerView;
    }

    public static class TagsAdaptor extends AppHeaderFooterRecyclerViewAdapter<TagsAdaptor.TagRowViewHolder> {
        public int postId = 0;
        public List<TagRowJson> list = new ArrayList<>();

        @Override
        protected int getContentItemCount() {
            return list.size();
        }

        @Override
        protected TagRowViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            return new TagRowViewHolder(new TagRowCell(parent));
        }

        @Override
        protected void onBindContentItemViewHolder(TagRowViewHolder tagRowViewHolder, int position) {
            tagRowViewHolder.tagRowJson.bind(list.get(position));
        }


        public class TagRowViewHolder extends RecyclerView.ViewHolder{
            TagRowCell tagRowJson;

            public TagRowViewHolder(TagRowCell commentRowCell) {
                super(commentRowCell.rootView);
                this.tagRowJson = commentRowCell;
            }
        }

    }

    public static class TagRowCell {
        @Bind(R.id.text) TextView text;
        @Bind(R.id.count) TextView count;

        TagRowJson tag;

        View rootView;

        public TagRowCell(ViewGroup parent) {
            rootView = AppUtil.inflate(R.layout.row_tag_simple, parent);
            ButterKnife.bind(this, rootView);
            rootView.setOnClickListener((v)-> Router.goToTag(tag.Name));
        }

        public void bind(TagRowJson tagRowJson){
            tag = tagRowJson;
            text.setText(tagRowJson.Name);
            count.setText(""+tagRowJson.Count + " پست ");
        }
    }


}
