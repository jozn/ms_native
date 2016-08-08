package com.mardomsara.social.ui.presenter.social;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.HomeStreamJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.ui.UIPostsList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/13/2016.
 */
public class HomeStreamPresenter extends BasePresenter {
    View view;
    @Bind(R.id.content)
    ViewGroup content;
    @Bind(R.id.loading) View loading;
//    @Bind(R.id.recycler_view) RecyclerView recycler_view;



    @Override
    public View buildView() {
        view = AppUtil.inflate(R.layout.preseter_home_stream);
        ButterKnife.bind(this,view);
        loadFromServer();
        return view;
    }

    private void loadFromServer() {
        AndroidUtil.runInBackground(()->{
            Http.Req req = new Http.Req();
//            req.absPath = API.POSTS_STREAM_GET.toString();
            req.absPath = "http://localhost:5000/v1/post/stream";
            Http.Result res = Http.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                   /*TextView tv= (TextView)viewRoot.findViewById(R.id.loading);
                    tv.setText(res.data);*/
                    loadedPostsFromNet(res);

                });
            }
        });
    }

    private void loadedPostsFromNet(Http.Result res) {
        loading.setVisibility(View.GONE);
        content.setVisibility(View.VISIBLE);
        HomeStreamJson data= JsonUtil.fromJson(res.data, HomeStreamJson.class);
        if(data != null && data.Status.equalsIgnoreCase("OK")){

            content.addView(UIPostsList.buildNew(data.Payload));
//            UIPostsList_DEP.HomeStreamAdaptor_Dep adaptor = new UIPostsList_DEP.HomeStreamAdaptor_Dep();
//            adaptor.posts = data.Payload;
//            recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
//            recycler_view.setAdapter(adaptor);
        }
    }

}
