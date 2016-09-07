package com.mardomsara.social.ui.presenter.chats;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.presenter.chats.old.ChatRoomsListPresenter;

/**
 * Created by Hamid on 5/2/2016.
 */
public class ChatTabPresenter extends BasePresenter {
    @Override
    public View buildView() {
        View l = AppUtil.inflate(R.layout.main_branch_chat);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tab = (TabLayout)l.findViewById(R.id.sliding_tabs);
        tab.setBackgroundColor(0xeeeeee);
        ChatBranchPagerAdaptor pad = new ChatBranchPagerAdaptor(fragment.getChildFragmentManager(),fragment.getActivity());

        tab.setTabMode(TabLayout.MODE_FIXED);
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

    public static class ChatBranchPagerAdaptor extends FragmentPagerAdapter {
        final int PAGE_COUNT = 2;
        private String tabTitles[] = new String[] {  "کاربران" ,"گفتگو ها"};//, "Tab3","Tab222","Tab222","Tab222" };
        private Context context;
        //    private String tabTitles[] = new String[] { "Tab1", "Tab2" };
        private int[] imageResId = { R.drawable.ic_menu_send, R.drawable.ic_menu_camera};//, R.drawable.ic_menu_manage, R.drawable.ic_menu_manage, R.drawable.ic_menu_manage, R.drawable.ic_menu_manage };

        public ChatBranchPagerAdaptor(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new UserAndContactsPresenter().getFragment();
                case 1:
                default:
                return new RoomsListPresenter().getFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        public View getTabView(int position) {
            // Given you have a custom layout in `response/layout/custom_tab.xml` with a TextView and ImageView
            View v = LayoutInflater.from(context).inflate(R.layout.tab_cell_general, null);
            TextView tv = (TextView) v.findViewById(R.id.textView);
            tv.setText(tabTitles[position]);
//        ImageView img = (ImageView) v.findViewById(R.id.imgView);
            //img.setImageResource(imageResId[position]);
            return v;
        }
    }
}


