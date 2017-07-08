package com.mardomsara.social.ui.cells.post;

import android.net.Uri;
import android.widget.ImageView;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.ui.views.FullScreenImage;
import com.mardomsara.social.ui.views.x.VPostImageView;

/**
 * Created by Hamid on 3/29/2017.
 */

public class PostRowUtils {

	public static void setImage(ImageView image, JV.PostView post){
		image.setOnClickListener((v)->{

			String urlStr = Helper.postsGetBestPhotoResUrl(post.PhotoView, AndroidUtil.getScreenWidth());

			FullScreenImage window = new FullScreenImage();
			window.text = post.Text;
			window.imageUri = Uri.parse(urlStr) ;//msg.getMediaLocalSrc();
			window.show();
		});
	}

	//FIXME add FullScreenImage for Fresco
	public static void setImage(VPostImageView image, JV.PostView post){
		image.setOnClickListener((v)->{

			String urlStr = Helper.postsGetBestPhotoResUrl(post.PhotoView, AndroidUtil.getScreenWidth());

			FullScreenImage window = new FullScreenImage();
			window.text = post.Text;
			window.imageUri = Uri.parse(urlStr) ;//msg.getMediaLocalSrc();
			window.show();
		});
	}
}
