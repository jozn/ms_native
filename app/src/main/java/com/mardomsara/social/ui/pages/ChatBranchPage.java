package com.mardomsara.social.ui.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.ui.adaptors.pager.ChatBranchPagerAdaptor;
import com.mardomsara.social.ui.BaseFragment;

import hugo.weaving.DebugLog;

/**
 * Created by Hamid on 2/3/2016.
 */
public class ChatBranchPage extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    @DebugLog
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View l = inflater.inflate(R.layout.main_branch_chat,container,false);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tab = (TabLayout)l.findViewById(R.id.sliding_tabs);
        tab.setBackgroundColor(0xeeeeee);
//        tab.addTab(tab.newTab().setText("Tab 11111"));
//        tab.addTab(tab.newTab().setText("Tab 12222"));
//        tab.addTab(tab.newTab().setText("Tab 15555"));
        ChatBranchPagerAdaptor pad = new ChatBranchPagerAdaptor(getFragmentManager(),getActivity());

        for (int i = 0; i < tab.getTabCount(); i++) {
            TabLayout.Tab t = tab.getTabAt(i);
            t.setCustomView( pad.getTabView(i) );
        }
        tab.setTabMode(TabLayout.MODE_FIXED);

        vp.setAdapter(pad);
        tab.setupWithViewPager(vp);
        return l;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

    }
}



