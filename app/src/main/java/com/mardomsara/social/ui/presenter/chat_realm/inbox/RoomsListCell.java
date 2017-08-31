package com.mardomsara.social.ui.presenter.chat_realm.inbox;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.Events;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.memory_store.MemoryStore_LastMsgs;
import com.mardomsara.social.models.memory_store.MemoryStore_Rooms;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.models_realm.realm.RealmChatView;
import com.mardomsara.social.models_realm.realm.RealmChatViewFields;
import com.mardomsara.social.play.DividerItemDecoration;
import com.mardomsara.social.ui.X;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.Sort;

/**
 * Created by Hamid on 9/7/2016.
 */
public class RoomsListCell {
    public View root_view;
    ArrayListHashSetKey<Room,String> listRooms = MemoryStore_Rooms.getListRooms();//new ArrayListHashSetKey<>((room)->room.RoomKey);
    RecyclerView rv;
    RoomsListAdaptor adp;

    public RoomsListCell() {
        init();
    }

    private void init() {
        root_view = AppUtil.inflate(R.layout.list_rooms_presenter);
		MemoryStore_Rooms.reloadForAll();
		listRooms = MemoryStore_Rooms.getListRooms();

        rv = (RecyclerView) root_view.findViewById(R.id.contacts_list_rv);
        adp = new InboxRoomsListAdaptor(listRooms);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(AppUtil.getContext());
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(AppUtil.getContext(), DividerItemDecoration.VERTICAL_LIST);
//        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(adp);
        rv.setHasFixedSize(true);

//		App.getBus().register(this);

		rv.setLayoutManager(mLayoutManager);
    }


}
