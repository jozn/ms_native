package com.mardomsara.social.ui.cells.chats.msgs;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.extra.MsgExtraPhotoThumbnail;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_VideoMe extends MsgCell_AbstractViewHolder {
    @Bind(R.id.msg_time) TextView time_txt;
    @Bind(R.id.msg_delivery_status) TextView msg_delivery_status;
    @Bind(R.id.msg_text) TextView msg_text;
    @Bind(R.id.msg_image) SimpleDraweeView msg_image;
    @Bind(R.id.msg_content_holder) ViewGroup msg_content_holder;
//    LinkerText msg_text;
    Message msg;

    public MsgCell_VideoMe(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static MsgCell_VideoMe makeNew(ViewGroup parent){
        return new MsgCell_VideoMe(AppUtil.inflate(R.layout.msg__row_video_me,parent));
    }

    @Override
    public void bindToView(Message msg) {
        AppUtil.log("bindToView Peer");
        time_txt.setText(MsgCommon.msgRawTime2(msg));
        msg_text.setText(msg.Text);
        MsgCommon.msgDeliveryStatusText(msg,msg_delivery_status);
        MsgCommon.setVideoImage(msg,msg_image);
    }

	public void bindToView_DEp(Message msg) {
		AppUtil.log("bindToView Peer");
		time_txt.setText(MsgCommon.msgRawTime2(msg));
		msg_text.setText(msg.Text);
		MsgCommon.msgDeliveryStatusText(msg,msg_delivery_status);
		MsgCommon.setVideoImage_DEP(msg,msg_image);

//        URI uri = AppUtil.(msg.getMediaLocalSrc());
//        msg_image.
//        Uri u = Uri.parse(msg.getMediaLocalSrc());
		Uri u = Uri.parse("http://localhost:5000/public/photo/1_960.jpg");
//        int max_width = msg_content_holder.getLayoutParams().width;//px
//        int max_width = msg_content_holder.getWidth();;//px

		int max_width = (int) (AndroidUtil.getScreenWidth() * 0.88);
		AppUtil.log("width: "+max_width+AndroidUtil.getScreenResolution()+AndroidUtil.getDensity());
		max_width = AndroidUtil.pxToDp(max_width);
		MsgExtraPhotoThumbnail thumbnail = JsonUtil.fromJson(msg.ExtraJson,MsgExtraPhotoThumbnail.class);

		if(thumbnail != null){
			File file = new File(thumbnail.LocalSrc);
//        ViewGroup.LayoutParams sizes = new ViewGroup.LayoutParams(AndroidUtil.dpToPx(msg.getMediaWidth()),
//                AndroidUtil.dpToPx(msg.getMediaWidth()));
//        msg_image.setLayoutParams(sizes);

//        ViewHelper.setImageSizesWithMaxPx(msg_image, max_width, msg.getMediaWidth(),msg.getMediaHeight());
			ViewHelper.setImageSizesWithMaxPx(msg_image, max_width, thumbnail.Width , thumbnail.Height );
			file.toURI();
			Uri u2 =Uri.fromFile(file);
//        msg_image.setAspectRatio(1.33f);
			msg_image.setImageURI(u2);
			msg_content_holder.requestLayout();

		}
	}


}
