package com.mardomsara.social.ui.adaptors;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.FullScreenImage_Fresco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/3/2016.
 */
public class PostsGridAdaptor extends AppHeaderFooterRecyclerViewAdapter<PostsGridAdaptor.VH> {

	public List<JV.PostView> posts = new ArrayList<>();

	@Override
	protected int getContentItemCount() {
		return posts.size();
	}

	@Override
	protected int getContentItemViewType(int position) {
		return 0;
		/*switch (position%3){
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 2;
		}
		return position%3;*/
	}

	@Override
	protected VH onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
		int screenSize = AndroidUtil.getScreenWidth()/3;
		X.Common_OneThirdImage v = new X.Common_OneThirdImage(parent);//ViewHelper.newImageView(screenSize,screenSize);
		v.img.getLayoutParams().width = screenSize;
		v.img.getLayoutParams().height = screenSize;
		v.img.setLayoutParams(v.img.getLayoutParams());

		return new VH(v);
	}

	@Override
	protected void onBindContentItemViewHolder(VH postStreamHolder, int position) {
		postStreamHolder.bind(posts.get(position));
	}


    public static class VH extends RecyclerView.ViewHolder {
//        ImageView imageView;
		ViewGroup root;
		JV.PostView post;
		X.Common_OneThirdImage v;

        Uri imageUri2;

        View.OnClickListener gotoPost = (v) -> {
            Router.goToPostEntryPage(post);
        };

        View.OnClickListener imagePopup = (v) -> {
            FullScreenImage_Fresco window = new FullScreenImage_Fresco();
            window.text = post.Text;
            window.imageUri = imageUri2;
            window.show();
        };


        Runnable getGotoCommentsAdd = () -> {

        };

        public VH(X.Common_OneThirdImage itemView) {
            super(itemView.root);
//            imageView = itemView.img;
			root = itemView.root;

			this.v = itemView;
            root.setOnClickListener(gotoPost);

        }

        void bind(JV.PostView post) {
            this.post = post;
            if (post.TypeId == 2) {
                int screenSize = AndroidUtil.getScreenWidth()/ 3;
//                ViewHelper.setImageSizesWithMaxPx(imageView,screenSize,screenSize,post.Width,post.Height);
                v.img.setVisibility(View.VISIBLE);
//                String urlStr = "http://192.168.1.250:5000/"+post.MediaUrl;
                String urlStr = Helper.postsGetBestPhotoResUrl(post.PhotoView, screenSize);

                /*Picasso.with(AppUtil.getContext())
                        .load(urlStr)
                        .resize(screenSize,screenSize)
                        .placeholder(R.drawable.image_background)
//                        .fit()
                        .centerCrop()
                        .into(imageView);*/

				v.img.setImageURIAndColorRGB(Uri.parse(urlStr),post.PhotoView.Color);

            } else {
                v.img.setVisibility(View.GONE);
                v.img.setOnClickListener(null);
            }

//            itemView.invalidate();

        }
    }

}
