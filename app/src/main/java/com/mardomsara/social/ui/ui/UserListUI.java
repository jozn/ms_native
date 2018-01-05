package com.mardomsara.social.ui.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

//import com.mardomsara.social.app.Router_DEP;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.X;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/7/2016.
 * This is old one without user about
 * Todo :move this class to cells
 */
public class UserListUI {

    public static class Adapter extends AppHeaderFooterRecyclerViewAdapter<UserRowViewHolder> {

        public List<UserInfoJson> list = new ArrayList<>();

        @Override
        protected int getContentItemCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        protected UserRowViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            return new UserRowViewHolder(new X.UserList_TypeFollowRow(parent));
        }

        @Override
        protected void onBindContentItemViewHolder(UserRowViewHolder userRowViewHolder, int position) {
            userRowViewHolder.bind(list.get(position));
        }
}

    public static class UserRowViewHolder extends RecyclerView.ViewHolder {

		X.UserList_TypeFollowRow x ;

		UserInfoJson row;

        public UserRowViewHolder(X.UserList_TypeFollowRow x) {
            super(x.root);
            x.root.setOnClickListener((v)->{
                Router.goToProfile(row.UserId);
            });
            ButterKnife.bind(this,itemView);
        }

        public void bind(UserInfoJson row){
            this.row = row;
            x.primary_name.setText(row.FullName);
            x.second_name.setText("@"+row.UserName);
            Helper.SetAvatar(x.avatar, row.AvatarUrl);
            x.following_button.setUser(row);
        }
    }

}
