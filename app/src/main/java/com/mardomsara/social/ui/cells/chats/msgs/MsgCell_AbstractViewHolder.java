package com.mardomsara.social.ui.cells.chats.msgs;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mardomsara.social.models_old.tables.Message;

//import Message;

/**
 * Created by Hamid on 6/13/2016.
 */

//Every sub class must create "public static  MsgAbstractViewHolder new()"
// we do it this way beause of java limitations for abstract static methods and
// the way RecyclerView.UserRowViewHolder works it must setOrReplace inflated viw in constructor so
// this approche gives us flexblites;
public abstract class MsgCell_AbstractViewHolder extends RecyclerView.ViewHolder {
    View grandView;
    public MsgCell_AbstractViewHolder(View itemView) {
        super(itemView);
        grandView = itemView;
    }
    public abstract void bindToView(Message msg);

	public void onRecycled(){
	};

//    public static  MsgAbstractViewHolder makeNew();

}

//    public static abstract void init(Message msg);//java shortcoming
