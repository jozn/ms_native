package com.mardomsara.social.ui.presenter.social;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.http.LikesListJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.views.wigets.GeneralUserListTypeFollow;
import com.mardomsara.social.ui.views.wigets.LoadingView;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/14/2016.
 */
public class LikesPresenter extends BasePresenter {
    int postId = 0;

//    @Bind(R.id.generalUserListTypeFollow)
    GeneralUserListTypeFollow generalUserListTypeFollow;

    @Bind(R.id.simpleTopNav)
    SimpleTopNav simpleTopNav;

    @Bind(R.id.loadingView)
    LoadingView loadingView;

    public LikesPresenter(int postId) {
        this.postId = postId;
    }

    @Override
    public View buildView() {
        View view = AppUtil.inflate(R.layout.presenter_general_user_list_type_follow);
        ButterKnife.bind(this,view);

        generalUserListTypeFollow = GeneralUserListTypeFollow.getNew();

        simpleTopNav.setTitle("پسندیدند");

        AndroidUtil.runInBackground(()->{
            Http.Req req = new Http.Req();
            req.urlParams.put("post_id",""+postId);
            req.absPath = API.POSTS_LIKES_GET.toString();
            Http.Result res = Http.get(req);
            if(res.ok) {
                LikesListJson data = JsonUtil.fromJson(res.data, LikesListJson.class);
                if (data.Status.equalsIgnoreCase("OK")) {
                    AndroidUtil.runInUi(() -> {
//                        AppUtil.log(data.Payload.get(0).FullName);
//                        AppUtil.log("sssssssssssssss" + data.Payload.size());
//                        generalUserListTypeFollow.adapter.setList(data.Payload);
                        loadingView.replace(generalUserListTypeFollow);
                        generalUserListTypeFollow.show(data.Payload);
                    });
                }
            }
        });
        return view;
        /*GeneralUserListTypeFollow v = new GeneralUserListTypeFollow(getContext());
        v.show();
        return v;*/
    }

    public static class UserListToFollowAdaptor extends RecyclerView.Adapter<UserListToFollowAdaptor.UserHolder>{
        @Override
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(UserHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public static class UserHolder extends RecyclerView.ViewHolder{

            public UserHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
