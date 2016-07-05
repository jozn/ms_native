package com.mardomsara.social.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;

/**
 * Created by Hamid on 5/2/2016.
 */
public class PresenterFragment extends BaseFragment {


    FrameLayout presenterViewHolder;
    BasePresenter presenter;
    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
        //presenter.fragment = this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        presenterViewHolder = (FrameLayout) inflater.inflate(R.layout.fragment_single_presenter,container,false);
        return presenterViewHolder;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
        try {
//            presenter.fragment = this;
            View v= presenter.buildView();
            presenterViewHolder.addView(v);
        }catch (Exception e){
            e.printStackTrace();
            Log.e("Presenter:"," render err:");

        }
    }

    @Override
    public void onStart() {
        super.onStart();
//        AppUtil.log("after?? FragmentPresnter onStart()");
        if(presenter!=null) {
            presenter.onStart();
        }else {
            logIt(" presenter in "+getClass().getSimpleName() +" is null ");
        }
    }

    @Override
    public void onResume() {
        super.onStart();
//        AppUtil.log("after?? FragmentPresnter onResume()");
        if(presenter!=null) {
            presenter.onResume();
        }
    }

    @Override
    public void onDestroy() {
        if(presenter!=null){
            presenter.onDestroy();
        }
        super.onDestroy();

    }

}
