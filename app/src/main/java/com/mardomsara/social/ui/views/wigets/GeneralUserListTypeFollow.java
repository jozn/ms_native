package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.social.rows.UserInfoJson;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/18/2016.
 */
public class GeneralUserListTypeFollow extends FrameLayout {

//    public List<UserRowAndMeJson> list = new ArrayList<>();
    public Adapter adapter = new Adapter();
    RecyclerView recycler_view;

    public static GeneralUserListTypeFollow getNew(){
        GeneralUserListTypeFollow generalUserListTypeFollow = new GeneralUserListTypeFollow(AppUtil.getContext());
        generalUserListTypeFollow.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        return generalUserListTypeFollow;
    }

    public GeneralUserListTypeFollow(Context context) {
        super(context);
        init();
    }

    public GeneralUserListTypeFollow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GeneralUserListTypeFollow(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    void init() {
//        setLayoutParams(new LayoutParams(getContext(),));
        View view = LayoutInflater.from(getContext()).inflate(R.layout.widget_general_user_list_ytype_follow, this, true);
        recycler_view = (RecyclerView)view.findViewById(R.id.recycler_view);
    }

    public void show(){

        recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        requestLayout();

    }

    public void show(List<UserInfoJson> list){
        Adapter adapter = new Adapter();
        adapter.setList(list);
        recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        requestLayout();

    }

    public static class Adapter extends RecyclerView.Adapter<UserRowViewHolder> {

        public void setList(List<UserInfoJson> list) {
            this.list = list;
        }

        public List<UserInfoJson> getList() {
            return list;
        }

        public List<UserInfoJson> list ;//= new ArrayList<>();

        @Override
        public UserRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new UserRowViewHolder(AppUtil.inflate(R.layout.wiget_user_list_type_follow_row,parent));
        }

        @Override
        public void onBindViewHolder(UserRowViewHolder holder, int position) {
            holder.bind(getList().get(position));
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }
    }

    public static class UserRowViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.following_button)
        public FollowingButtonView following_button;

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

        public void bind(UserInfoJson row){
            primary_name.setText(row.FullName);
            second_name.setText("@"+row.UserName);
            Helper.SetAvatar(avatar, row.AvatarUrl);
            following_button.setUser(row);
        }
    }

}
