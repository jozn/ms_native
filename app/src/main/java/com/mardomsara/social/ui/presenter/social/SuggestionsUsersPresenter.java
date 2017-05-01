package com.mardomsara.social.ui.presenter.social;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.Cells;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SuggestionsUsersPresenter extends BasePresenter implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {
	Adapter adaptor;
	Cells.Pager_RecyclerView pager;

	@Override
    public View buildView() {
		adaptor = new Adapter();

		pager = new Cells.Pager_RecyclerView(adaptor,this);
		pager.wrapView.refresh_layout.setEnabled(true);
		pager.wrapView.refresh_layout.setOnRefreshListener(()->{
			loadNextPage(1);
		});

		Cells.Title_InfoLight title=new Cells.Title_InfoLight(pager.wrapView.recycler_view,"اشخاص پیشنهادی برای دنبال کردن:");
		adaptor.appendViewToHeader(title.rootView);

		return pager.wrapView.root;
    }

	@Override
	public void loadNextPage(int pageNum) {
		loadFromServer(pageNum);
	}
	private void loadFromServer(int page) {

		Http.getPath("/v1/recommend/users")
			.setQueryParam("username","abas")
			.setQueryParam("page",""+page)
			.setQueryParam("limit",""+20)
			.doAsyncUi((result)->{
				adaptor.nextPageIsLoaded(result);
				pager.wrapView.refresh_layout.setRefreshing(false);
				if(result.isOk()){
					HttpJsonList<UserInfoJson> data = Result.fromJsonList(result, UserInfoJson.class);
					if(data.isPayloadNoneEmpty()){
						if(page <= 1) adaptor.list.clear();
						if(data.Payload != null && data.Payload.size() >0){
							adaptor.list.addAll(data.Payload);
							adaptor.notifyDataSetChanged();
						}
					}else {
						adaptor.setHasMorePage(false);
					}
				}
				pager.wrapView.refresh_layout.setRefreshing(false);
			});
	}


	public static class Adapter extends AppHeaderFooterRecyclerViewAdapter<UserRowRecommendVH> {

		public List<UserInfoJson> list = new ArrayList<>();

		@Override
		protected int getContentItemCount() {
			return list == null ? 0 : list.size();
		}

		@Override
		protected UserRowRecommendVH onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
			return new UserRowRecommendVH(new X.Recommend_UserRow(parent));
		}

		@Override
		protected void onBindContentItemViewHolder(UserRowRecommendVH userRowRecommendVH, int position) {
			userRowRecommendVH.bind(list.get(position));
		}
	}

	public static class UserRowRecommendVH extends RecyclerView.ViewHolder {
		X.Recommend_UserRow cell;
		UserInfoJson row;
		public UserRowRecommendVH(X.Recommend_UserRow userRow) {
			super(userRow.root);
			cell = userRow;
			userRow.avatar.setOnClickListener((v)-> goToProfile());
			userRow.primary_name.setOnClickListener((v)-> goToProfile());
		}

		private void goToProfile() {
			Router.goToProfile(row.getUserId());
		}

		public void bind(UserInfoJson row){
			this.row = row;
			cell.primary_name.setText(row.FullName);
			cell.second_name.setText("@"+row.UserName);
			Helper.SetAvatar(cell.avatar, row.AvatarUrl);
			cell.following_button.setUser(row);
			cell.about.setText(row.About);
//			cell.about.setText("");
		}
	}

}
