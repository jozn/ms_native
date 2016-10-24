package com.mardomsara.social.ui.cells.chats.msgs;

import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.Message;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgEmptyView extends MsgAbstractViewHolder {

    public MsgEmptyView(View itemView) {
        super(itemView);
//        ButterKnife.bind(this, itemView);
    }

    public static MsgAbstractViewHolder makeNew(){
        return new MsgEmptyView(AppUtil.inflate(R.layout.msg_empty));
    }


    @Override
    public void bindToView(Message msg) {
//        ImageSpan
    }



}
