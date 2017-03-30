package com.mardomsara.social.ui.presenter.pages.add_post;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.mardomsara.MediaFacade.media.image.ImageCursor;
import com.mardomsara.MediaFacade.media.image.ImageProviderHelper;
import com.mardomsara.social.App;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.CursorRecyclerViewAdapter;
import com.mardomsara.social.ui.X;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

//import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;

//image size is 80dp
//// TODO: 3/13/2017 merge this class with RecentImages - just one flixibel calss with good api - this class to be the futuer one
public class RecentImagesAddPostBoxCell {
    int maxSelection = 10;

    onRecentImageClicked listener;

    List<String> selected = new ArrayList<>();

	RecentImagesGallery galley;

	X.RecentImagesPostBox_RecyclerView x = new X.RecentImagesPostBox_RecyclerView();
	Context context = AppUtil.getContext();

    public RecentImagesAddPostBoxCell(ViewGroup parent) {
        x.recycler_view = (RecyclerView) AppUtil.inflate(R.layout.recent_images_post_box__recycler_view,parent);
        askPermissions();
    }

    void afterPermissionsGranted(){
        ImageCursor imageCursor = ImageProviderHelper.getLastImages();

        galley = new RecentImagesGallery(AppUtil.getContext(),imageCursor);

		//// TODO: 11/15/2016 add animatio with suport library comtaible
		/*AlphaInAnimationAdapter anim = new AlphaInAnimationAdapter(galley,0.3f);
        anim.setStartPosition(6);*///disable animating for fisrt six images
        x.recycler_view.setAdapter(galley);
//        recycler_view.setAdapter(anim);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true);
        x.recycler_view.setLayoutManager(layoutManager);
//        recycler_view.setItemAnimator(new FadeInRightAnimator());
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

	public String getSelectedOne() {
		if(selected.size()>0){
			return selected.get(0);
		};
		return null;
	}

	public void tryAddToSelected(String imagePath) {
		if(imagePath != null){
			File file = new File(imagePath);
			if(file.exists()){
				selected.add(imagePath);
				galley.notifyDataSetChanged();
			}

		};
	}

    public void setMaxSelection(int maxSelection) {
        this.maxSelection = maxSelection;
    }

    public void setListener(onRecentImageClicked listener) {
        this.listener = listener;
    }

    public void selectNone(){
		selected.clear();
		galley.notifyDataSetChanged();
	}

	public void select(String path){
		if(!selected.contains(path)){
			selected.add(path);
		}
		galley.notifyDataSetChanged();
	}


    ////////////////////////////////////////

    public static interface onRecentImageClicked{
        void onRecentImageAdded(String filePath);
        void onRecentImageRemoved(String filePath);
        void onRecentImageClicked(String filePath);
    }


    ///////////////////////////////////////////////////////////////////

    class RecentImagesGallery extends CursorRecyclerViewAdapter<RecentImagesGallery.VH> implements View.OnClickListener {
        ImageCursor _cursor;
        RecentImagesGallery that;
        //fresco
        GenericDraweeHierarchyBuilder builder ;
        GenericDraweeHierarchy hierarchy;
        public RecentImagesGallery(Context context, ImageCursor cursor) {
            super(context, cursor);
            _cursor = cursor;
            that = this;
            builder = new GenericDraweeHierarchyBuilder(context.getResources());
            hierarchy= builder
                    .setFadeDuration(300)
//                    .setRoundingParams(RoundingParams.asCircle())
                    .setPlaceholderImage(AndroidUtil.getDrawable(R.drawable.holder_recent_image))
                    .build();
        }

        @Override
        public void onBindViewHolder(VH viewHolder, Cursor cursor, int position) {
            viewHolder.bind(_cursor,position);
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            return new VH(new X.RecentImagesAddPost_ImageItem());
        }

        @Override
        public void onViewRecycled(VH holder) {
            super.onViewRecycled(holder);
            holder.x.image_drawee.setImageBitmap(null);
        }

        //on select item
        @Override
        public void onClick(View v) {

        }

		public class VH extends RecyclerView.ViewHolder {
			String filePath;

			X.RecentImagesAddPost_ImageItem x;
			int imagePosition=0;

			View.OnClickListener onSelect = (v)->{
				if(selected.contains(filePath)){
					selected.remove(filePath);
					if(listener != null) listener.onRecentImageRemoved(filePath);
				}else {
					if(selected.size() < maxSelection){
						selected.add(filePath);
						if(listener != null) listener.onRecentImageAdded(filePath);
					}else {
						//TODO: Toast user that max is 10 for example
					}

				}
				notifyItemChanged(imagePosition);
				if(listener != null) listener.onRecentImageClicked(filePath);
			};

			public VH(X.RecentImagesAddPost_ImageItem x) {
				super(x.root);
				this.x = x;
				x.root.setOnClickListener(onSelect);
			}
			Long thisViewcurrentId;
			//todo extract syncy to a common plac
			//// TODO: 3/13/2017 better image quality and canceling of decoding of hidede images
			void bind(ImageCursor imageCursor,int position){
				//in main thread
				String path;
				final Long thisRunid;
				synchronized (imageCursor){
					imagePosition = position;
					File file = new File(imageCursor.data());
					thisViewcurrentId = imageCursor.id();
					thisRunid = imageCursor.id();
					path = imageCursor.data();
					filePath = imageCursor.data();
					if(selected.contains(filePath)){
						x.text_icon.setVisibility(View.VISIBLE);
						x.text_holder.setBackgroundColor(AndroidUtil.getColor(R.color.transparent_selection));
					}else{//for recyled this is neccessory
						x.text_icon.setVisibility(View.INVISIBLE);
						x.text_holder.setBackgroundColor(AndroidUtil.getColor(R.color.transparent_0));
					}
					x.image_drawee.setHierarchy(hierarchy);
				}

				AndroidUtil.runInSingleBackground(()->{
					Bitmap bm = ImageProviderHelper.getMicroThumnail(thisRunid);
					AndroidUtil.runInUi(()->{
						if(bm==null){
							if(thisRunid.equals(thisViewcurrentId)){
								x.image_drawee.setImageURI(Uri.parse(path));
							}
						}else {
							if(thisRunid.equals(thisViewcurrentId)) {
								x.image_drawee.setImageBitmap(bm);
							}
						}
					});

				});
			}
		}

    }

}