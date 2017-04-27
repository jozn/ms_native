package com.mardomsara.social.ui.cells.post;

import android.net.Uri;
import android.widget.ImageView;

import com.mardomsara.social.app.API;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.ui.views.FullScreenImage;

/**
 * Created by Hamid on 3/29/2017.
 */

public class PostRowUtils {

	public static void setImage(ImageView image, PostRowJson post){
		String urlStr = API.BASE_CDN_DOMAIN_URL_STR+"/"+post.MediaUrl;
		image.setOnClickListener((v)->{
			FullScreenImage window = new FullScreenImage();
			window.text = post.Text;
			window.imageUri = Uri.parse(urlStr) ;//msg.getMediaLocalSrc();
			window.show();
		});
	}

	public static void setImage(ImageView image, JV.PostView post){
//		String urlStr = API.BASE_CDN_DOMAIN_URL_STR+"/"+post.MediaUrl;
		String urlStr = Helper.postsGetBestPhotoResUrl(post.PhotoView,1080);
		image.setOnClickListener((v)->{
			FullScreenImage window = new FullScreenImage();
			window.text = post.Text;
			window.imageUri = Uri.parse(urlStr) ;//msg.getMediaLocalSrc();
			window.show();
		});
	}
}
