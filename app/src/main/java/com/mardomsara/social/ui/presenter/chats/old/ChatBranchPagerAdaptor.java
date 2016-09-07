package com.mardomsara.social.ui.presenter.chats.old;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.ui.presenter.chats.RoomsListPresenter;
import com.mardomsara.social.ui.presenter.chats.UserAndContactsPresenter;
import com.mardomsara.social.ui.presenter.chats.old.ChatRoomsListPresenter;

@Deprecated
public class ChatBranchPagerAdaptor extends FragmentPagerAdapter  {
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
//                return BasePresenter.presenterToFragment(new ChatRoomsListPresenter() );
            case 1:
//                return new HelloFragment();
            default:
                return new ChatRoomsListPresenter().getFragment();
//                return new RoomsListPresenter().getFragment();
//                return BasePresenter.presenterToFragment(new UserAndContactsPresenter());
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