package com.mardomsara.social.ui.presenter.chat_realm.chat_room.del;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mardomsara.social.lib.realm.RealmRecyclerViewAdapter;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.ui.X;

import io.realm.OrderedRealmCollection;

/**
 * Created by Hamid on 9/5/2017.
 */

public class RealmChatAdaptor_DEP extends RealmRecyclerViewAdapter<RealmMessageView,RealmChatAdaptor_DEP.VH> {
	OrderedRealmCollection<RealmMessageView> data;
	public RealmChatAdaptor_DEP(@Nullable OrderedRealmCollection<RealmMessageView> data, boolean autoUpdate) {
		super(data, autoUpdate);
		this.data = data;
	}

	@Override
	public VH onCreateViewHolder(ViewGroup parent, int viewType) {
		return new VH(new X.Msg_RowTextMe());
	}

	@Override
	public void onBindViewHolder(VH holder, int position) {
		RealmMessageView realmMessageView = data.get(position);
		holder.x.msg_text.setText(""+realmMessageView.Text);
		holder.x.msg_time.setText(""+realmMessageView.Time);
	}

	public static class VH extends RecyclerView.ViewHolder{
		X.Msg_RowTextMe x;// = new X.Msg_RowTextMe();

		public VH(X.Msg_RowTextMe x) {
			super(x.root);
			this.x = x;
		}
	}
}
