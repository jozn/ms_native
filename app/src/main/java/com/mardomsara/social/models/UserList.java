package com.mardomsara.social.models;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.social.UserRowAndMeJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.views.wigets.FollowingButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/7/2016.
 */
public class UserList {

    public static class Adapter extends AppHeaderFooterRecyclerViewAdapter<UserRowViewHolder> {

        public List<UserRowAndMeJson> list = new ArrayList<>();

        @Override
        protected int getContentItemCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        protected UserRowViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            return new UserRowViewHolder(AppUtil.inflate(R.layout.wiget_user_list_type_follow_row,parent));
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

        @Bind(R.id.avatar)
        public SimpleDraweeView avatar;

        View view;

        public UserRowViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this,itemView);

        }

        public void bind(UserRowAndMeJson row){
            primary_name.setText(row.FullName);
            second_name.setText("@"+row.UserName);
            Helper.SetAvatar(avatar, row.AvatarUrl);
            following_button.setUser(row);
        }
    }

}
