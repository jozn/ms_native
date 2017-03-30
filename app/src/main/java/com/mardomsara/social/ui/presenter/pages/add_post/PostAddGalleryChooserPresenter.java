package com.mardomsara.social.ui.presenter.pages.add_post;

import android.Manifest;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.MediaFacade.media.image.ImageCursor;
import com.mardomsara.MediaFacade.media.image.ImageProviderHelper;
import com.mardomsara.social.App;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

public class PostAddGalleryChooserPresenter extends BasePresenter {
	int maxSelection = 10;
	onImageClicked listener;
	List<String> selected = new ArrayList<>();
	Context context = AppUtil.getContext();

	X.AddPostGallery_Container x;

	public AddPostPage addPostPage;

    @Override
    public View buildView() {
		x = new X.AddPostGallery_Container();
		x.top_nav.setTitle("انتخاب عکس");
		askPermissions();

        return x.root;
    }

	public PostAddGalleryChooserPresenter(onImageClicked listener) {
		this.listener = listener;
	}

	void afterPermissionsGranted(){
		ImageCursor imageCursor = ImageProviderHelper.getLastImages();

		Here_RecentImagesGallery galley = new Here_RecentImagesGallery(AppUtil.getContext(),imageCursor,listener);
		GridLayoutManager layoutManager = new GridLayoutManager(context,3);
//		LinearLayoutManager layoutManager = new LinearLayoutManager(context);
		x.recycler_view.setLayoutManager(layoutManager);
		x.recycler_view.setAdapter(galley);

	}

	private void askPermissions() {
		PermissionCallback callback = new PermissionCallback(){
			@Override
			public void permissionGranted() {
				AppUtil.log("permissionGranted() callback");
				afterPermissionsGranted();
			}

			@Override
			public void permissionRefused() {
				AppUtil.log("permissionRefused() callback");
			}
		};

		Nammu.askForPermission(App.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE,callback);
	}
	public void insertInto(ViewGroup viewGroup){
		viewGroup.addView(x.recycler_view);
	}

	public RecyclerView getView(){
		return(x.recycler_view);
	}
	public List<String> getSelected() {
		return selected;
	}

	public void setMaxSelection(int maxSelection) {
		this.maxSelection = maxSelection;
	}

	////////////////////////////////////////////////////////////////////

	public static interface onImageClicked {
		void onRecentImageAdded(String filePath);
		void onRecentImageRemoved(String filePath);
		void onRecentImageClicked(String filePath);
	}

	///////////////////////////////////////////////////////////////////

	class Here_RecentImagesGallery extends RecyclerView.Adapter<VH> implements View.OnClickListener {
		ImageCursor _cursor;
		Here_RecentImagesGallery that;
		WeakHashMap<String, File> map = new WeakHashMap<>();
		onImageClicked onImageClicked;

		public Here_RecentImagesGallery(Context context, ImageCursor cursor,onImageClicked onImageClicked) {
//			super(context, cursor);
			_cursor = cursor;
			that = this;
			this.onImageClicked = onImageClicked;
		}

		@Override
		public void onBindViewHolder(VH holder, int position) {
			holder.bind(_cursor,position,map);
		}

		@Override
		public VH onCreateViewHolder(ViewGroup parent, int viewType) {
			return new VH(new X.AddPostGallery_Image(parent),onImageClicked);
		}

		@Override
		public void onViewRecycled(VH holder) {
			super.onViewRecycled(holder);
			AppUtil.log("ImageCursor onViewRecycled ");
			holder.x.image.setImageBitmap(null);
		}

		@Override
		public int getItemCount() {
			return _cursor.getCount();
		}

		@Override
		public long getItemId(int position) {
			return super.getItemId(position);
		}

		@Override
		public int getItemViewType(int position) {
			return 0;
		}

		//on select item
		@Override
		public void onClick(View v) {

		}
	}

	public static class VH extends RecyclerView.ViewHolder {
		String filePath;

		X.AddPostGallery_Image x;
		int imagePosition=0;
		static int i=0;
		onImageClicked onImageClicked;

		View.OnClickListener onSelect = (v)->{
			Helper.showDebugMessage(" ooo ");
			if(onImageClicked != null) onImageClicked.onRecentImageAdded(filePath);
		};

		public VH(X.AddPostGallery_Image x,onImageClicked onImageClicked) {
			super(x.root);
			this.x = x;
			x.root.setOnClickListener(onSelect);
			AppUtil.log("ImageCursor +++++ "+ i );
			int sc = AndroidUtil.getScreenWidth()/3;
			x.image.getLayoutParams().height = sc;
			x.image.getLayoutParams().width = sc;
			i++;
			this.onImageClicked = onImageClicked;
		}
		Long thisViewcurrentId;

		File file;
		void bind(ImageCursor _cursor,int position,WeakHashMap<String, File> map ){
//			holder.bind(_cursor, position);
			_cursor.moveToPosition(position);
			filePath = _cursor.data();
			File file = map.get(filePath);
			if(file == null){
				file = new File(filePath);
				map.put(filePath,file);
			}
			AppUtil.log("ImageCursor "+ position + " " +_cursor.getCount() + " " + filePath + " " +file.getAbsolutePath());

//			file = new File("/storage/emulated/0/Soroush/SoroushImages0/1471735527854.jpg");
//			Bitmap bm = BitmapFactory.decodeFile(path);
//			holder.x.image.setImageBitmap(bm);
			Picasso.with(AppUtil.getContext())
				.load(file)
				.resize(300,300)
				.centerCrop()
//					.load("http://mardomsara.com/1.png")
				.into(x.image);

		}
	}

}
