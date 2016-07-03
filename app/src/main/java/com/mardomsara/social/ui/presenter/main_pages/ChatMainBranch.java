package com.mardomsara.social.ui.presenter.main_pages;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.adaptors.pager.ChatBranchPagerAdaptor;

/**
 * Created by Hamid on 5/2/2016.
 */
public class ChatMainBranch extends BasePresenter {
    @Override
    public View buildView() {
        View l = AppUtil.inflate(R.layout.main_branch_chat);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tab = (TabLayout)l.findViewById(R.id.sliding_tabs);
        tab.setBackgroundColor(0xeeeeee);
        ChatBranchPagerAdaptor pad = new ChatBranchPagerAdaptor(fragment.getChildFragmentManager(),fragment.getActivity());

        tab.setTabMode(TabLayout.MODE_FIXED);
//

        vp.setAdapter(pad);
        tab.setupWithViewPager(vp);

        //must called here
        for (int i = 0; i < tab.getTabCount(); i++) {
            TabLayout.Tab t = tab.getTabAt(i);
            t.setCustomView( pad.getTabView(i) );
        }
//        tab.setBackgroundResource(R.drawable.chat_content_bubble_me);
//        tab.setSelectedTabIndicatorColor(AndroidUtil.getColor(R.color.light_blue_1));
//        tab.setSelectedTabIndicatorHeight(AndroidUtil.dpToPx(4));

        vp.setCurrentItem(1);
        return l;
    }
}
