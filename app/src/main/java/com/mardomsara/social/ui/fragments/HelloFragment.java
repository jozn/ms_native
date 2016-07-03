package com.mardomsara.social.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.ui.BaseFragment;

/**
 * Created by Hamid on 2/4/2016.
 */
public class HelloFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
//        Nav.hideFooter();
        return inflater.inflate(R.layout.hello_world,container,false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        Nav.showFooter();
    }
}
