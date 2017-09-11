package com.mardomsara.base_rv;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import io.realm.RealmModel;

/**
 * Created by Hamid on 9/11/2017.
 */

public abstract class BaseRealmAdapter_2<T extends RealmModel, S extends BaseViewHolder>
	extends BaseQuickAdapter<T,S> {

	public BaseRealmAdapter_2(@Nullable List<T> data, boolean autoUpdate) {
		super(data);
	}
}
