package com.mardomsara.social.ui.presenter.social.search;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.json.social.rows.TagRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.X;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 11/26/2016.
 */

public class SearchResultTagsListCell {

	public static class TagsAdaptor extends AppHeaderFooterRecyclerViewAdapter<TagRowViewHolder> {
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

	}

	public static class TagRowViewHolder extends RecyclerView.ViewHolder{
		TagRowCell tagRowJson;

		public TagRowViewHolder(TagRowCell commentRowCell) {
			super(commentRowCell.x.root);
			this.tagRowJson = commentRowCell;
		}
	}

	public static class TagRowCell {

		TagRowJson tag;
		X.RowTagSimple x;

		public TagRowCell(ViewGroup parent) {
			x = new X.RowTagSimple(parent);
			x.root.setOnClickListener((v)-> Router.goToTag(tag.Name));
		}

		public void bind(TagRowJson tagRowJson){
			tag = tagRowJson;
			x.text.setText(tagRowJson.Name);
			x.count.setText(" "+tagRowJson.Count + " پست ");
		}
	}
}
