package com.mardomsara.social.ui.adaptors;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.presenter.pages.PostEntryPage;
import com.mardomsara.social.ui.views.FullScreenImage_Fresco;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/3/2016.
 */
public class PostsListAdaptor extends AppHeaderFooterRecyclerViewAdapter<PostsListAdaptor.VH> {

	public List<JV.PostView> posts = new ArrayList<>();

	@Override
	protected int getContentItemCount() {
		return posts.size();
	}

	@Override
	protected int getContentItemViewType(int position) {
		return 0;
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
        ImageView imageView;
		ViewGroup root;
		JV.PostView post;

        Uri imageUri2;

        View.OnClickListener gotoPost = (v) -> {
            Nav.push(new PostEntryPage(post));
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
            imageView = itemView.img;
			root = itemView.root;

            root.setOnClickListener(gotoPost);

        }

        void bind(JV.PostView post) {
            this.post = post;
            if (post.TypeId == 2) {
                int screenSize = AndroidUtil.getScreenWidth()/ 3;
//                ViewHelper.setImageSizesWithMaxPx(imageView,screenSize,screenSize,post.Width,post.Height);
                imageView.setVisibility(View.VISIBLE);
//                String urlStr = "http://localhost:5000/"+post.MediaUrl;
                String urlStr = Helper.postsGetBestPhotoResUrl(post.PhotoView, screenSize);

                Picasso.with(AppUtil.getContext())
                        .load(urlStr)
                        .resize(screenSize,screenSize)
                        .placeholder(R.drawable.image_background)
//                        .fit()
                        .centerCrop()
                        .into(imageView);


            } else {
                imageView.setVisibility(View.GONE);
                imageView.setOnClickListener(null);
            }

//            itemView.invalidate();

        }
    }

}
