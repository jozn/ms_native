package com.mardomsara.social.lib;

import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.Cells;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/4/2016.
 */

///NOTICE: notify**Changed() shoulld not be called in here (we should not manuplate views in
// here) it must be called from apps code -- it will be bugy
public abstract class AppHeaderFooterRecyclerViewAdapter<T extends RecyclerView.ViewHolder> extends
        HeaderFooterRecyclerViewAdapter<
                T,
                AppHeaderFooterRecyclerViewAdapter.HeaderViewHolder,
                AppHeaderFooterRecyclerViewAdapter.FooterViewHolder> {

    List<ViewTag> headerViews = new ArrayList<>();
    List<ViewTag> footerViews = new ArrayList<>();

    int footerTypeId = 0;
    int headerTypeId = 0;

	Sectioned sectioned;

	public AppHeaderFooterRecyclerViewAdapter() {
		registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(){
			@Override
			public void onChanged() {
				super.onChanged();
				check();
			}

			@Override
			public void onItemRangeChanged(int positionStart, int itemCount) {
				super.onItemRangeChanged(positionStart, itemCount);
				check();
			}

			@Override
			public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
				super.onItemRangeChanged(positionStart, itemCount, payload);
				check();
			}

			@Override
			public void onItemRangeInserted(int positionStart, int itemCount) {
				super.onItemRangeInserted(positionStart, itemCount);
				check();
			}

			@Override
			public void onItemRangeRemoved(int positionStart, int itemCount) {
				super.onItemRangeRemoved(positionStart, itemCount);
				check();
			}

			@Override
			public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
				super.onItemRangeMoved(fromPosition, toPosition, itemCount);
				check();
			}

			void check(){
				if(sectioned!=null){
					sectioned.notifyDataChanged();
				}
			}
		});
	}

	//    RecyclerView recyclerView;
    @Override
    protected int getHeaderItemCount() {
        return headerViews.size();
    }

    @Override
    protected int getFooterItemCount() {
        return footerViews.size();
    }

	@Override
	protected int getContentItemCount_0() {
		int s = getContentItemCount();
		if(s == 0 ){
			if(enableAutoShowEmptyView) {
				showEmptyView();
			}
		}else {
			hideEmptyView();
		}
		return s;
	}

	public void notifyDataChanged(){
		if(sectioned!=null){
			sectioned.notifyDataChanged();
		}
		super.notifyDataSetChanged();
	}

	protected abstract int getContentItemCount();

    @Override
    protected int getFooterItemViewType(int position) {
        if(footerViews.size() > position && footerViews.get(position) != null){
            return footerViews.get(position).typeId;
        }
        return 0;
    }

    @Override
    protected int getHeaderItemViewType(int position) {
        if(headerViews.size() > position && headerViews.get(position) != null){
            return headerViews.get(position).typeId;
        }
        return 0;
    }

    @Override
    protected void onBindHeaderItemViewHolder(HeaderViewHolder headerViewHolder, int position) {

    }

    @Override
    protected void onBindFooterItemViewHolder(FooterViewHolder footerViewHolder, int position) {

    }

    @Override
    protected FooterViewHolder onCreateFooterItemViewHolder(ViewGroup parent, int footerViewType) {
        for(ViewTag tag : footerViews){
            if(tag.typeId == footerViewType){
                return new FooterViewHolder(tag.view);
            }
        }
        return null;
    }

    @Override
    protected HeaderViewHolder onCreateHeaderItemViewHolder(ViewGroup parent, int headerViewType) {
        for(ViewTag tag : headerViews){
            if(tag.typeId == headerViewType){
                return new HeaderViewHolder(tag.view);
            }
        }
        return null;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }


    public static class FooterViewHolder extends RecyclerView.ViewHolder{
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void appendViewToFooter(View view){
        footerTypeId++;
        ViewTag tag = new ViewTag();
        tag.typeId=footerTypeId;
        tag.view = view;
        footerViews.add(tag);
    }

    public int removeViewFromFooter(View view){
		int num = -1;
        for(ViewTag tag : footerViews) {
			num++;
            if (tag.view == view) {
                footerViews.remove(tag);
				return num;
            }
        }
		return -1;
    }

    public void appendViewToHeader(View view){
        headerTypeId++;
        ViewTag tag = new ViewTag();
        tag.typeId=headerTypeId;
        tag.view = view;
        headerViews.add(tag);
    }

    public void removeViewFromHeader(View view){
        for(ViewTag tag : headerViews) {
            if (tag.view == view) {
                headerViews.remove(tag);
            }
        }
    }

    //needed for centering LoadingView
    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    //////////////// For LoadingView ///////////////////////////////
    View loading;
    boolean isShowingLoading = false;
    public void showLoading(){
        if( ! isShowingLoading){
            loading = new Cells.LoadingCell(recyclerView).rootView;
            appendViewToFooter(loading);
            isShowingLoading =true;
        }
    }

    public void hideLoading(){
		getItemCount();
		if(loading!= null){
			loading.setVisibility(View.GONE);
			int num = removeViewFromFooter(loading);
			if(num >= 0){
				notifyFooterItemRemoved(num);
			}
		}
    }

    //// For multi pages ///////////

    AppEndlessRecyclerViewScrollListener scrollListener;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    LoadNextPage pager;
    int pageNum = 0;

    public  void setHasMorePage(boolean hasMore){
        if(hasMore){
//            footerSize = 1;
            if(scrollListener != null && getContentItemCount() >0){
                recyclerView.addOnScrollListener(scrollListener);
//                notifyFooterItemChanged(0);
            }
        }else {
//            footerSize = 0;
            if(scrollListener != null && getContentItemCount() >0){
				scrollListener.setDisable(true);
//                recyclerView.removeOnScrollListener(scrollListener);
                //ME:dont do this it will crash: reason: child not attached???
//                notifyFooterItemChanged(0);
            }
			hideLoading();
		}
    }

    //
    public  void setUpForPaginationWith(RecyclerView recyclerView, LinearLayoutManager layoutManager , LoadNextPage pager){
        this.recyclerView = recyclerView;
        this.layoutManager = layoutManager;
        this.pager = pager;
        if(this.layoutManager != null && this.pager != null){
            showLoading();
            listenOnScroll();
			new Handler().post(()->{
				scrollListener.callNextPage();//call page 1
			});
        }
    }

	boolean isReload = false;
	public void reload(){
		if(scrollListener!=null){
			scrollListener.setDisable(false);
			scrollListener.setCurrentPage(1);
			scrollListener.callNextPage();
			scrollListener.setLoading(true);
		}
//		if(pager!=null){
//			pager.loadNextPage(1);
//		}
	}

	public void nextPageIsLoaded(){
		if(scrollListener!=null){
			scrollListener.setLoading(false);
		}
	}

    public void listenOnScroll(){

        scrollListener =new AppEndlessRecyclerViewScrollListener(layoutManager,this){
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
//                loadNextPage();
				Runnable r  = ()->{
					if(pager!=null){
						pager.loadNextPage(page);
					}
				};
                new Handler().post(r);;
            }
        };
        //ME: somehow if we attach scrollListener in here befor View attached to window it will
        //crashe. so addStart it after attached in onAttached
//        recyclerView.addOnScrollListener(scrollListener);
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if(scrollListener != null){
            recyclerView.addOnScrollListener(scrollListener);
        }
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(scrollListener != null){
            recyclerView.removeOnScrollListener(scrollListener);
        }
    }

    public GridLayoutManager.SpanSizeLookup getSpanSizeForSimpleContentGridLayout(int contentSpanSize){
        return new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int sizeHeader = getHeaderItemCount();
                int sizeFooter = getFooterItemCount();
                int sizeContent = getContentItemCount();

                if (sizeHeader > 0 && position < sizeHeader) {
                    return contentSpanSize;
                } else if (sizeContent > 0 && position - sizeHeader < sizeContent) {
                    return 1;
                } else {//footer
                    return contentSpanSize;
                }
            }
        };
    }

	////////////////// Empty message  funcs ////////////////
	String emptyMsg = "آیتمی برای نمایش وجود ندارد";
	boolean enableAutoShowEmptyView = false;
	boolean isShowingEmptyView = false;
	View emptyMsgView;

	public void setEmptyMessage(String emptyMsg){
		this.emptyMsg = emptyMsg;
	}

	public void setEmptyMsgView(View emptyView){
		this.emptyMsgView = emptyView;
	}

	public void showEmptyView(String emptyMsg){
		if(isShowingEmptyView)return;
		isShowingEmptyView = true;
		Runnable r = ()->{
			setHasMorePage(false);
			if(emptyMsgView == null){
				X.Rv_EmptyNote emptyNote = new X.Rv_EmptyNote(recyclerView);
				emptyNote.empty_note.setText(emptyMsg);
				emptyMsgView = emptyNote.root;
				//emptyMsgView= AppUtil.inflate(R.layout.wiget_app__headr_footer_recycler_empty_msg,recyclerView);
			}
			appendViewToHeader(emptyMsgView);
			notifyDataChanged();
		};
		new Handler().post(r);
	}

	public void showEmptyView(){
		showEmptyView(emptyMsg);
	}

	public void hideEmptyView(){
		if(!isShowingEmptyView)return;
		isShowingEmptyView = false;
		Runnable r = ()->{
			removeViewFromHeader(emptyMsgView);
			notifyDataChanged();
		};
		new Handler().post(r);
	}
	public void setEnableAutoShowEmptyView(boolean autoMsgView){
		enableAutoShowEmptyView = autoMsgView;
	}



    ///////////////////////////////////////////////
    ///// Class ///////////////
    class ViewTag {
        View view;
        int typeId;
    }

    public interface LoadNextPage{
        void loadNextPage(int pageNum);
    }


	public static class Sectioned<T extends RecyclerView.Adapter<RecyclerView.ViewHolder>> extends
		RecyclerView.Adapter<RecyclerView.ViewHolder>{
		private List<SectionRow> sections = new ArrayList<SectionRow>();
		int offset =0;
		final int SECTION_OFFSET = 10_000;

		public Sectioned() {
			/*registerAdapterDataObserver( new RecyclerView.AdapterDataObserver(){

				@Override
				public void onChanged() {
					notifyDataChanged();
				}

				@Override
				public void onItemRangeChanged(int positionStart, int itemCount) {
					super.onItemRangeChanged(positionStart, itemCount);
					notifyDataChanged();
				}

				@Override
				public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
					super.onItemRangeChanged(positionStart, itemCount, payload);
					notifyDataChanged();
				}

				@Override
				public void onItemRangeInserted(int positionStart, int itemCount) {
					super.onItemRangeInserted(positionStart, itemCount);
					notifyDataChanged();
				}

				@Override
				public void onItemRangeRemoved(int positionStart, int itemCount) {
					super.onItemRangeRemoved(positionStart, itemCount);
					notifyDataChanged();
				}

				@Override
				public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
					super.onItemRangeMoved(fromPosition, toPosition, itemCount);
					notifyDataChanged();
				}
			});*/
		}

		public void add(AppHeaderFooterRecyclerViewAdapter adpator){
			SectionRow sectionRow = new SectionRow();
			sectionRow.adapter = adpator;
			sectionRow.offsetType =offset;
			sectionRow.offsetPosition =resetPositions();
			offset += SECTION_OFFSET;
			AppUtil.log("Section: onBindViewHolder: add "+sectionRow);
			sections.add(sectionRow);
			adpator.sectioned = this;
		}

		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			AppUtil.log("Section: onCreateViewHolder: viewType "+viewType);
			SectionRow sectionRow = getSectionRowOrThrow_ByViewTypeId(viewType);
			RecyclerView.ViewHolder res;
			if(sectionRow!= null){
				int vt = viewType - sectionRow.offsetType;
				AppUtil.log("Section: XXxx vt"+vt);

				res = sectionRow.adapter.onCreateViewHolder(parent,vt);
//				return sectionRow.adapter.onCreateViewHolder(parent,vt);
				if(res==null){
					AppUtil.log("Section: XXX RecyclerView.ViewHolder is null");
				}else {
					return res;
				}
			}
//			res = new SectionHolder(AppUtil.inflate(R.layout.hello_world_row));
			return new SectionHolder(new View(AppUtil.getContext()));
//			return null;
		}

		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
			AppUtil.log("Section: onBindViewHolder: pos "+position);
			SectionRow sectionRow = getSectionRowOrThrow_ByPosition(position);
			if(sectionRow!= null){
				int pos = position - sectionRow.offsetPosition;
				sectionRow.adapter.onBindViewHolder(holder,pos);
			}
		}

		@Override
		public int getItemViewType(int position) {
			AppUtil.log("Section: getItemViewType: position "+position);
			SectionRow sectionRow = getSectionRowOrThrow_ByPosition(position);
			if(sectionRow!= null){
				int pos = position - sectionRow.offsetPosition;
				return sectionRow.adapter.getItemViewType(pos)+sectionRow.offsetType;
			}
			return super.getItemViewType(position);
		}

		@Override
		public void setHasStableIds(boolean hasStableIds) {
			super.setHasStableIds(hasStableIds);
		}

		@Override
		public long getItemId(int position) {
			/*SectionRow sectionRow = getSectionRowOrThrow_ByPosition(position);
			if(sectionRow!= null){
				int pos = position - sectionRow.offsetPosition;
				return sectionRow.adapter.getItemId(pos);
			}*/
			return super.getItemId(position);
		}

		@Override
		public int getItemCount() {
			resetPositions();
			int sum = 0;
			for(SectionRow sectionRow: sections ){
				sum += sectionRow.adapter.getItemCount();
			}
			return sum;
		}

		private SectionRow getSectionRowOrThrow_ByPosition(int position){
			resetPositions();
			int sum = 0;
			for(SectionRow sectionRow: sections ){
				if(position >= sum  && (position-sum) < sectionRow.adapter.getItemCount()){
					return sectionRow;
				}
				sum += sectionRow.adapter.getItemCount();
			}

			if(Config.IS_DEBUG){
				AppUtil.log("section is null getSectionRowOrThrow_ByPosition viewId: "+position + " " +getItemCount());

//				throw new IllegalArgumentException("In AppHeader... Section getSectionRowOrThrow_ByPosition(int) for position: "+position);
			}
			return null;
		}

		private SectionRow getSectionRowOrThrow_ByViewTypeId(int viewId){
			resetPositions();
			for(SectionRow sectionRow: sections ){
				if(viewId >= sectionRow.offsetType && viewId < sectionRow.offsetType +SECTION_OFFSET){
					return sectionRow;
				}
			}

			if(Config.IS_DEBUG){
//				throw new IllegalArgumentException("In AppHeader... Section getSectionRowOrThrow_ByViewTypeId(int) for viewId: "+viewId);
				AppUtil.log("Section is null getSectionRowOrThrow_ByViewTypeId viewId: "+viewId);
			}
			return null;
		}

		public final void Changed() {
			resetPositions();
			super.notifyDataSetChanged();
		}

		private int resetPositions(){
			int sum = 0;
			for(SectionRow sectionRow: sections ){
				sectionRow.offsetPosition = sum;
				sum += sectionRow.adapter.getItemCount();
			}
			return sum;
		}

		public void notifyDataChanged(){
			resetPositions();
			super.notifyDataSetChanged();
		}

		public static class SectionRow {
			AppHeaderFooterRecyclerViewAdapter adapter;
			int offsetType;
			int offsetPosition;
		}

		public static class SectionHolder extends RecyclerView.ViewHolder{

			public SectionHolder(View itemView) {
				super(itemView);
			}
		}
	}

    /*public interface Binder{
        public void bind(int relativePosition);
    }*/

}


		/*protected int getContentItemCount() {
			int sum = 0;
			for(SectionRow sectionRow: sections ){
				sum += sectionRow.adapter.getItemCount();
			}
			return sum;
		}

		@Override
		protected int getHeaderItemCount() {
			return 0;
		}

		@Override
		protected int getFooterItemCount() {
			return super.getFooterItemCount();
		}

		@Override
		protected int getContentItemCount_0() {
			return super.getContentItemCount_0();
		}

		@Override
		protected int getFooterItemViewType(int position) {
			return super.getFooterItemViewType(position);
		}

		@Override
		protected int getHeaderItemViewType(int position) {
			return super.getHeaderItemViewType(position);
		}

		@Override
		protected void onBindHeaderItemViewHolder(HeaderViewHolder headerViewHolder, int position) {
			super.onBindHeaderItemViewHolder(headerViewHolder, position);
		}

		@Override
		protected void onBindFooterItemViewHolder(FooterViewHolder footerViewHolder, int position) {
			super.onBindFooterItemViewHolder(footerViewHolder, position);
		}

		@Override
		protected FooterViewHolder onCreateFooterItemViewHolder(ViewGroup parent, int footerViewType) {
			return super.onCreateFooterItemViewHolder(parent, footerViewType);
		}

		@Override
		protected HeaderViewHolder onCreateHeaderItemViewHolder(ViewGroup parent, int headerViewType) {
			return super.onCreateHeaderItemViewHolder(parent, headerViewType);
		}

		@Override
		protected int getContentItemViewType(int position) {
			return super.getContentItemViewType(position);
		}

		@Override
		protected SectionHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
			return null;
		}

		@Override
		protected void onBindContentItemViewHolder(SectionHolder sectionHolder, int position) {

		}

		@Override
		public long getItemId(int position) {
			return super.getItemId(position);
		}*/

	/*public void onLoadMore(int page, int totalItemsCount) {
//                loadNextPage();
		Runnable r  = ()->{
			if(pager!=null){
				//workaround: onScroll in Endless... is called page 1 when reloaded
				// : means we end up calling page 1 twice one ourself like loadfromserver(1)
				// and another by Endless... scroll checker, so page 1 twice loads
				// and then they the counts of items has bot changed so page 2 never will
				// be called, and Endless... scroll remains in not wainting for page 1 complete.
				if(isReload){
					pager.loadNextPage(page+1);
					scrollListener.decrCurrentPage();
					isReload =false;
				}else {
					pager.loadNextPage(page);
				}
//						pageNum++;
			}
		};
		new Handler().post(r);;
	}*/

