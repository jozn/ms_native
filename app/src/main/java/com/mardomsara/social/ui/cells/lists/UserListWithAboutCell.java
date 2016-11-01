package com.mardomsara.social.ui.cells.lists;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.json.social.rows.UserRowAndMeJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.social.ui.views.wigets.FollowingButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
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
            return new UserRowViewHolder(AppUtil.inflate(R.layout.cell_list_user_type_follow_about_row,parent));
        }

        @Override
        protected void onBindContentItemViewHolder(UserRowViewHolder userRowViewHolder, int position) {
            userRowViewHolder.bind(list.get(position));
        }
}

    public static class UserRowViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.following_button)
        public FollowingButton following_button;

        @Bind(R.id.second_name)
        public TextView second_name;

        @Bind(R.id.primary_name)
        public TextView primary_name;

		@Bind(R.id.about)
		public TextView about;

        @Bind(R.id.avatar)
        public SimpleDraweeView avatar;

        View view;

		UserInfoJson row;

        public UserRowViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            view.setOnClickListener((v)->{
                Router.goToProfile(row.UserId);
            });
            ButterKnife.bind(this,itemView);

//			about.setTypeface(FontCache.getIranLight());
//			primary_name.setTypeface(FontCache.getIranMedium());
//			second_name.setTypeface(FontCache.getIranLight());
        }

        public void bind(UserInfoJson row){
            this.row = row;
            primary_name.setText(row.FullName);
            second_name.setText("@"+row.UserName);
            Helper.SetAvatar(avatar, row.AvatarUrl);
            following_button.setUser(row);
			about.setText("\uD83D\uDC78 برگ \uD83D \uD83D\uDE29 \uD83D\uDC66 \uD83D\uDC66\uD83C\uDFFD #عمودی آن و \uD83D\uDE14 کوچک خود \uD83E\uDD17 \uD83D\uDD75️\uD83C\uDFFB @pkht #به \uD83D\uDC71\uD83C\uDFFE الهام \uD83E\uDD11 \uD83D\uDCAA\uD83C\uDFFE کاربرد وزن شده جابه\u200Cجا باقیمانده برای \uD83D\uDC68 سنگینی" +
				" \uD83D\uDC82\uD83C\uDFFE \uD83C\uDFFF @kjjk" +
				" ");
			about.setText(row.About);
        }
    }

}
