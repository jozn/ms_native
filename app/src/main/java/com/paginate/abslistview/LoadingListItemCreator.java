package com.paginate.abslistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;

//import com.paginate.R;

/** AbsListView creator that will be called to create and bind loading_progress list item */
public interface LoadingListItemCreator {

    /**
     * Create/inflate new loading_progress list item view.
     *
     * @param position loading_progress list item position.
     * @param parent   parent ViewGroup.
     * @return view that will be displayed as loading_progress list item (loading_progress indicator).
     */
    View newView(int position, ViewGroup parent);

    /**
     * Bind the loading_progress list item.
     *
     * @param position loading_progress list item position.
     * @param view     loading_progress list item view.
     */
    void bindView(int position, View view);

    LoadingListItemCreator DEFAULT = new LoadingListItemCreator() {
        @Override
        public View newView(int position, ViewGroup parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.common__loading_row, parent, false);
        }

        @Override
        public void bindView(int position, View view) {
            // No binding for default loading_progress root_view
        }
    };

}