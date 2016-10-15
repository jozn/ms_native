package com.mardomsara.social.ui.cells.chats.msgs;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mardomsara.social.models.tables.Message;

//import com.mardomsara.social.models.tables.Message;

/**
 * Created by Hamid on 6/13/2016.
 */

//Every sub class must create "public static  MsgAbstractViewHolder new()"
// we do it this way beause of java limitations for abstract static methods and
// the way RecyclerView.UserRowViewHolder works it must setOrReplace inflated viw in constructor so
// this approche gives us flexblites;
public abstract class MsgAbstractViewHolder extends RecyclerView.ViewHolder {
    View grandView;
    public MsgAbstractViewHolder(View itemView) {
        super(itemView);
        grandView = itemView;
    }
    public abstract void bindToView(Message msg);
//    public static  MsgAbstractViewHolder makeNew();

}

//    public static abstract void init(Message msg);//java shortcoming
