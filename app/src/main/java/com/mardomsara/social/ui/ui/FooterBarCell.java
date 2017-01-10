package com.mardomsara.social.ui.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.Branch;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

import java.util.HashMap;
import java.util.Map;

public class FooterBarCell {
	View root;
    TextView profile;
    TextView activity;
    TextView search;
    TextView home;
    TextView chat;
    TextView[] cells;
    Branch activeBranch;
    Map<Branch,TextView> cellsMap = new HashMap<>();

	public FooterBarCell(ViewGroup container) {
		root = AppUtil.inflate(R.layout.fragment_footer_bar, container);
		profile = (TextView) root.findViewById(R.id.profile);
		activity = (TextView) root.findViewById(R.id.activity);
		search = (TextView) root.findViewById(R.id.search);
		home = (TextView) root.findViewById(R.id.home);
		chat = (TextView) root.findViewById(R.id.chat);

		setUpMaper();
		setUpEvents();
	}

	public View getRoot() {
		return root;
	}

	public void setUpMaper(){
        cellsMap.put(Branch.Profile,profile);
        cellsMap.put(Branch.Activity,activity);
        cellsMap.put(Branch.Search,search);
        cellsMap.put(Branch.Home,home);
        cellsMap.put(Branch.Chat,chat);
    }

    public void setUpEvents(){

        for (final Branch k: cellsMap.keySet()){
            cellsMap.get(k).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Nav.goToBranch(k);
                }});
            cellsMap.get(k).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
//                    Nav.goToBranch(k);
                    Nav.resetBranch(k);
					Nav.goToBranch(k);
                    return true;
                }
            });
//            cellsMap.get(k).setOnClickListener((v)-> Nav.goToBranch(k));
//            cellsMap.get(k).setOnClickListener((v)-> Nav.goToBranch(k));
        }
    }

    public void activateBranch(Branch bra){
        for (Branch k: cellsMap.keySet()){
            cellsMap.get(k).setBackgroundColor(getResources().getColor(R.color.navbar_background));
            cellsMap.get(k).setTextColor(getResources().getColor(R.color.navbar_icon_font));
        }
        TextView activeCell = cellsMap.get(bra);
        activeCell.setBackgroundColor(getResources().getColor(R.color.navbar_background_active));
        activeCell.setTextColor(getResources().getColor(R.color.navbar_icon_font_active));

    }

	Resources getResources(){
		return AndroidUtil.getResources();
	}
}

//
//profile.setOnClickListener((v)-> Nav.goToBranch("profile"));
//        activity.setOnClickListener((v)-> Nav.goToBranch("activity"));
//        search.setOnClickListener((v)-> Nav.goToBranch("search"));
//        home.setOnClickListener((v)-> Nav.goToBranch("home"));
//        chat.setOnClickListener((v) -> Nav.goToBranch("chat"));
//cells = new TextView[][]{profile,activity,search,home,chat};
