package com.paginate.recycler;

/** SpanSizeLookup that will be used to determine the span of loading_progress list item. */
public interface LoadingListItemSpanLookup {

    /** @return the span of loading_progress list item. */
    int getSpanSize();
}