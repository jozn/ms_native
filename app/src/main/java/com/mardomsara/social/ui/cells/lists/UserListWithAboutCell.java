package com.mardomsara.social.ui.cells.lists;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mardomsara.social.app.Router_DEP;
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
public class UserListWithAboutCell {

    public static class Adapter extends AppHeaderFooterRecyclerViewAdapter<UserRowViewHolder> {

        public List<UserInfoJson> list = new ArrayList<>();

        @Override
        protected int getContentItemCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        protected UserRowViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
//            return new UserRowViewHolder(AppUtil.inflate(R.layout.cell_list_user_type_follow_about_row_bk,parent));
            return new UserRowViewHolder(new X.UserList_RowFollowAbout(parent));
        }

        @Override
        protected void onBindContentItemViewHolder(UserRowViewHolder userRowViewHolder, int position) {
            userRowViewHolder.bind(list.get(position));
        }
}

    public static class UserRowViewHolder extends RecyclerView.ViewHolder {

        X.UserList_RowFollowAbout x;

		UserInfoJson row;

        public UserRowViewHolder(X.UserList_RowFollowAbout x) {
            super(x.root);
           	this.x = x;
            x.root.setOnClickListener((v)->{
                Router_DEP.goToProfile(row.UserId);
            });
            ButterKnife.bind(this,itemView);
        }

        public void bind(UserInfoJson row){
            this.row = row;
            x.primary_name.setText(row.FullName);
            x.second_name.setText("@"+row.UserName);
            Helper.SetAvatar(x.avatar, row.AvatarUrl);
            x.following_button.setUser(row);
			x.about.setText("\uD83D\uDC78 برگ \uD83D \uD83D\uDE29 \uD83D\uDC66 \uD83D\uDC66\uD83C\uDFFD #عمودی آن و \uD83D\uDE14 کوچک خود \uD83E\uDD17 \uD83D\uDD75️\uD83C\uDFFB @pkht #به \uD83D\uDC71\uD83C\uDFFE الهام \uD83E\uDD11 \uD83D\uDCAA\uD83C\uDFFE کاربرد وزن شده جابه\u200Cجا باقیمانده برای \uD83D\uDC68 سنگینی" +
				" \uD83D\uDC82\uD83C\uDFFE \uD83C\uDFFF @kjjk" +
				" ");
			x.about.setText(row.About);
        }
    }

}
