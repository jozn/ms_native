package com.mardomsara.social.ui.pages;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.ui.adaptors.ChatEnteryAdaptor;
import com.mardomsara.social.ui.BaseFragment;
import com.mardomsara.social.models.Messages;
import com.mardomsara.social.tables.RoomsListTable;

import java.util.List;

import com.mardomsara.social.tables.MessagesTable;

/**
 * Created by Hamid on 2/4/2016.
 */
public class ChatEnteryPage extends BaseFragment {

    private static final String LOGTAG = "db";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_chat_entery_page,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Nav.hideFooter();
        RoomsListTable room = (RoomsListTable) params.get("room");
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view);

        List<MessagesTable> msgs = Messages.loadMsgs(room);
         ChatEnteryAdaptor ad =new ChatEnteryAdaptor();
        ad.setMsgs(msgs);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

//        mLayoutManager.setSmoothScrollbarEnabled(true);
        mLayoutManager.setReverseLayout(true);
//        mLayoutManager.
        rv.setAdapter(ad);
        rv.setLayoutManager(mLayoutManager);
//        rv


//        view.findViewById(R.id.back).setOnClickListener(v -> Nav.pop());
        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nav.pop();
            }
        });
        TextView roomTitle = (TextView) view.findViewById(R.id.room_name);
        roomTitle.setText(room.getRoomName());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Nav.showFooter();

    }


    public void showNextPage(int lastMsg ){}
    public void deleteMsgs(int[] msgs ){}
    public void forwardMsgs(int[] msgs ){}
    public void replayMsg(int[] msgs ){}
    public void favoriteMsgs(int[] msgs ){}
    public void addMsg(String msg ){}
    public void addMsg(Image msg ){}//....
}
