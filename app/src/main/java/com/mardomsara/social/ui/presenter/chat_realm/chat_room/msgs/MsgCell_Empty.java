package com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs;

import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.RealmMessageViewWrapper;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_Empty extends MsgCell_AbstractViewHolder {

    public MsgCell_Empty(View itemView) {
        super(itemView);
//        ButterKnife.bind(this, itemView);
    }

    public static MsgCell_AbstractViewHolder makeNew(){
        return new MsgCell_Empty(AppUtil.inflate(R.layout.msg__empty));
    }


    @Override
    public void bindToView(RealmMessageViewWrapper msg) {
//        ImageSpan
    }



}
