package com.mardomsara.social.ui.views.msgs;

import android.text.style.ImageSpan;
import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.tables.MessagesTable;

import butterknife.ButterKnife;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgEmptyView extends MsgAbstractViewHolder {

    public MsgEmptyView(View itemView) {
        super(itemView);
//        ButterKnife.bind(this, itemView);
    }

    public static MsgAbstractViewHolder makeNew(){
        return new MsgEmptyView(AppUtil.inflate(R.layout.empty));
    }


    @Override
    public void bindToView(MessagesTable msg) {
//        ImageSpan
    }



}
