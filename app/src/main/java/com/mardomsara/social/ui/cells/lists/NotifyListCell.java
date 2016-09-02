package com.mardomsara.social.ui.cells.lists;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mardomsara.social.App;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.models.tables.Notify;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/26/2016.
 */
public class NotifyListCell
        implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

    View loading;
    PostsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;

    List<Notify> list;

    public NotifyListCell(List<Notify> list) {
        this.list = list;
        init();
    }

    private void init() {
        refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT, ViewHelper.MATCH_PARENT);
        adaptor = new PostsAdaptor(list);
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(recycler_view, layoutManager, this);
        adaptor.showLoading();

        refreshLayout.addView(recycler_view);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showMessage("re");
            }
        });
    }

    public ViewGroup getViewRoot() {
        return refreshLayout;
    }

    @Override
    public void loadNextPage(int pageNum) {
        Helper.showMessage("pageNum: "+pageNum);
    }

    public static class PostsAdaptor extends AppHeaderFooterRecyclerViewAdapter<TextHolder> {

        List<Notify> list = new ArrayList<>();
        public PostsAdaptor(List<Notify> list){
            super();
            if(list != null){
                this.list.addAll(list);
            }
        }

        @Override
        protected int getContentItemCount() {
            return list.size();
        }

        @Override
        protected TextHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            return new TextHolder(new NotifyCell(parent));
        }

        @Override
        protected void onBindContentItemViewHolder(TextHolder textHolder, int position) {
//            textHolder.view.setText(LangUtil.limitText(list.get(position).PayloadStored,120));
            Notify nf =list.get(position);
            textHolder.notifyCell.bind(nf);
//            nf.setloadFromStored();
//            String s = nf.Load.Actor.getFullName();
//            textHolder.view.setText(LangUtil.limitText(s,120));
        }
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        TextView view;
        NotifyCell notifyCell;
        public TextHolder(NotifyCell notifyCell) {
            super(notifyCell.viewRoot);
            this.notifyCell = notifyCell;
        }
    }

    public static class NotifyCell {
        View viewRoot;

        @Bind(R.id.image) ImageView image;
        @Bind(R.id.text) TextView text;

        public NotifyCell(ViewGroup parent) {
            viewRoot = AppUtil.inflate(R.layout.notify_cell ,parent);
            ButterKnife.bind(this,viewRoot);
        }
        void bind(Notify nf){
            nf.setloadFromStored();
            String s = nf.Load.Actor.getFullName();
            text.setText(s);
            Helper.SetAvatar(image, nf.Load.Actor.AvatarUrl);
        }
    }
}
