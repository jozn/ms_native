package com.mardomsara.social.ui.presenter.social.search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.social.rows.TagRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

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
			super(commentRowCell.rootView);
			this.tagRowJson = commentRowCell;
		}
	}

	public static class TagRowCell {
		@Bind(R.id.text)
		TextView text;
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
			count.setText(" "+tagRowJson.Count + " پست ");
		}
	}
}
