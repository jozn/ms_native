package com.mardomsara.social.lib;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
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

//How to use:
//in  Http result handler call nextPageLoaded(result) to check if http is wrong and it set "try reload view",
//after trying unjsonized result call autoCheckAndSetEmptyView() to set empty view if view is empty
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

	View loadingView;
	boolean isShowingLoading = false;

	//// For multi pages ///////////
	AppEndlessRecyclerViewScrollListener scrollListener;
	RecyclerView recyclerView;
	LinearLayoutManager layoutManager;
	LoadNextPage pager;

	////////////////// Empty message  funcs ////////////////
	String emptyNoteMsg = "آیتمی برای نمایش وجود ندارد";
	boolean enableAutoShowEmptyView = false;
	boolean isShowingEmptyNoteView = false;
	View emptyNoteView;

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
		int cnt = getContentItemCount();
		return cnt;
	}

	public void notifyDataChanged(){
		if(recyclerView != null){
			if(recyclerView.isComputingLayout()){
				AndroidUtil.runInUi(()->{
					__notifyDataChanged();
				});
			} else {
				__notifyDataChanged();
			}
		}else {
			__notifyDataChanged();
		}
	}

	private void __notifyDataChanged(){
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

	public void appendViewToFooterIfNotExist(View view){
		for(ViewTag tag : footerViews) {
			if (tag.view == view) {
				return;
			}
		}
		appendViewToFooter(view);
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

	public void appendViewToHeaderIfNotExist(View view){
		for(ViewTag tag : headerViews) {
			if (tag.view == view) {
				return;
			}
		}
		appendViewToHeader(view);
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
    public void showLoading(){
		if(loadingView==null){
			loadingView = new Cells.LoadingCell(recyclerView).rootView;
		}
		loadingView.setVisibility(View.VISIBLE);
		appendViewToFooterIfNotExist(loadingView);
		isShowingLoading =true;
    }

    public void hideLoading(){
		isShowingLoading =false;
		getItemCount();//workaround?
		if(loadingView != null){
			loadingView.setVisibility(View.GONE);
			int num = removeViewFromFooter(loadingView);
			if(num >= 0){
				notifyFooterItemRemoved(num);
			}
		}
    }

    public  void setHasMorePage(boolean hasMore){
        if(hasMore){
			//FIxme is getContentItemCount() >0 neccesory
            if(scrollListener != null && getContentItemCount() >0){
                recyclerView.addOnScrollListener(scrollListener);
            }
        }else {
            if(scrollListener != null && getContentItemCount() >0){
				scrollListener.setDisable(true);
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

	public void reload(){
		if(scrollListener!=null){
			scrollListener.setDisable(false);
			scrollListener.setCurrentPage(1);
			scrollListener.callNextPage();
			scrollListener.setLoading(true);
		}
		hideFullReloader();
		hideEmptyView();
		showLoading();

		setHasMorePage(true);
	}

	public void nextPageIsLoaded(){
		if(scrollListener!=null){
			scrollListener.setLoading(false);
		}
	}

	public void nextPageIsLoaded(Result result){
		if(scrollListener!=null){
			scrollListener.setLoading(false);
		}
		if(result !=null && !result.isOk()){
			if(getContentItemCount()==0){
				showFullTryReload(result);
			}
			showFullTryReload(result);
		}
	}

	public void autoCheckAndSetEmptyView(){
		int cnt = getContentItemCount();
		if( !isLoadingContent()
			&& enableAutoShowEmptyView == true
			&& isShowingFullReloaderNote ==false
			&& cnt == 0
			) {
			showEmptyView();
		}else if ( !isLoadingContent() ) {

		}

		if(cnt!=0){
			hideEmptyView();
		}
	}

	protected boolean isLoadingContent(){
		if(scrollListener != null){
			return scrollListener.isLoading();
		}
		return false;
	}

    protected void listenOnScroll(){

        scrollListener =new AppEndlessRecyclerViewScrollListener(layoutManager,this){
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
				Runnable r  = ()->{
					if(pager!=null){
						pager.loadNextPage(page);
					}
				};
                new Handler().post(r);
            }
        };

		if(recyclerView!=null){
			recyclerView.addOnScrollListener(scrollListener);
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

	public void setEmptyMessage(String emptyMsg){
		this.emptyNoteMsg = emptyMsg;
	}

	public void setEmptyNoteView(View emptyView){
		this.emptyNoteView = emptyView;
	}

	public void showEmptyView(String emptyMsg){
//		if(isShowingEmptyNoteView)return;
		isShowingEmptyNoteView = true;
		setHasMorePage(false);
		if(emptyNoteView == null){
			X.Rv_EmptyNote emptyNote = new X.Rv_EmptyNote(recyclerView);
			emptyNote.empty_note.setText(emptyMsg);
			emptyNoteView = emptyNote.root;
		}
		appendViewToHeaderIfNotExist(emptyNoteView);
		notifyDataChanged();
	}

	public void showEmptyView(){
		showEmptyView(emptyNoteMsg);
	}

	public void hideEmptyView(){
//		if(!isShowingEmptyNoteView)return;
		isShowingEmptyNoteView = false;
		removeViewFromHeader(emptyNoteView);
		notifyDataChanged();
	}

	public void setEnableAutoShowEmptyView(boolean autoMsgView){
		enableAutoShowEmptyView = autoMsgView;
	}

	X.Rv_FailedReload emptyReloader;
	boolean isShowingFullReloaderNote;
	public void showFullTryReload(Result result){
		//if we have content dont set a full page
		if(getContentItemCount() > 0){
			return;
		}
		isShowingFullReloaderNote = true;
		setHasMorePage(false);
		hideEmptyView();
		if(emptyReloader == null){
			emptyReloader = new X.Rv_FailedReload(recyclerView);
		}

		if(AndroidUtil.isNetworkAvailable()){
			emptyReloader.not_internet.setVisibility(View.GONE);
		}else {
			emptyReloader.not_internet.setVisibility(View.VISIBLE);
			emptyReloader.not_internet.setText(R.string.rv_no_internet);
		}

		emptyReloader.reload.setOnClickListener((v)->{
			reload();
		});
		appendViewToFooterIfNotExist(emptyReloader.root);
		notifyDataChanged();
	}

	void hideFullReloader(){
		isShowingFullReloaderNote = false;
		if(emptyReloader != null){
			removeViewFromFooter(emptyReloader.root);
			notifyDataChanged();
		}
	}


    ///////////////////////////////////////////////
    /////////////////// Class ////////////////////

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

}
