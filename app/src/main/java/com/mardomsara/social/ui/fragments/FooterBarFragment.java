package com.mardomsara.social.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.ui.BaseFragment;

import java.util.HashMap;
import java.util.Map;
@Deprecated
public class FooterBarFragment extends BaseFragment {
    TextView profile;
    TextView activity;
    TextView search;
    TextView home;
    TextView chat;
    TextView[] cells;
    String activeBranch;
    Map<String,TextView> cellsMap = new HashMap<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View footer = inflater.inflate(R.layout.fragment_footer_bar, container, false);
        return  footer;
    }

    @Override
    public void onViewCreated(View footer, Bundle savedInstanceState) {
        super.onViewCreated(footer, savedInstanceState);
        profile = (TextView) footer.findViewById(R.id.profile);
        activity = (TextView) footer.findViewById(R.id.activity);
        search = (TextView) footer.findViewById(R.id.search);
        home = (TextView) footer.findViewById(R.id.home);
        chat = (TextView) footer.findViewById(R.id.chat);

        setUpMaper();
        setUpEvents();
    }

    public void setUpMaper(){
        cellsMap.put("profile",profile);
        cellsMap.put("activity",activity);
        cellsMap.put("search",search);
        cellsMap.put("home",home);
        cellsMap.put("chat",chat);
    }

    public void setUpEvents(){

        for (final String k: cellsMap.keySet()){
            cellsMap.get(k).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Nav.goToBranch(k);
                }});
            cellsMap.get(k).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
//                    Nav.goToBranch(k);
//                    Nav.resetBranch(k);
                    return true;
                }
            });
//            cellsMap.get(k).setOnClickListener((v)-> Nav.goToBranch(k));
//            cellsMap.get(k).setOnClickListener((v)-> Nav.goToBranch(k));
        }
    }

    public void activateBranch(String bra){
        for (String k: cellsMap.keySet()){
            cellsMap.get(k).setBackgroundColor(getResources().getColor(R.color.navbar_background));
            cellsMap.get(k).setTextColor(getResources().getColor(R.color.navbar_icon_font));
        }
        TextView activeCell = cellsMap.get(bra);
        activeCell.setBackgroundColor(getResources().getColor(R.color.navbar_background_active));
        activeCell.setTextColor(getResources().getColor(R.color.navbar_icon_font_active));

    }
}

//
//profile.setOnClickListener((v)-> Nav.goToBranch("profile"));
//        activity.setOnClickListener((v)-> Nav.goToBranch("activity"));
//        search.setOnClickListener((v)-> Nav.goToBranch("search"));
//        home.setOnClickListener((v)-> Nav.goToBranch("home"));
//        chat.setOnClickListener((v) -> Nav.goToBranch("chat"));
//cells = new TextView[][]{profile,activity,search,home,chat};
