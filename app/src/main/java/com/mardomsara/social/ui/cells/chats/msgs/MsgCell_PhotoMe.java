package com.mardomsara.social.ui.cells.chats.msgs;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_PhotoMe extends MsgCell_AbstractViewHolder {

	@NonNull
	X.Msg_RowImageMe x;

    public MsgCell_PhotoMe(X.Msg_RowImageMe xv) {
        super(xv.root);
		x = xv;
//        ButterKnife.bind(this, itemView);
    }

    public static MsgCell_PhotoMe makeNew(ViewGroup parent){
        return new MsgCell_PhotoMe(new X.Msg_RowImageMe(parent));
    }

    @Override
    public void bindToView(Message msg) {
        AppUtil.log("bindToView Peer");
        x.msg_time.setText(MsgCommon.msgRawTime2(msg));
//        msg_text.setText(msg.getText());
        MsgCommon.setImage(msg,x.msg_image);
//        MsgCommon.setContentMaxwhidth(msg,msg_image);
        MsgCommon.setTextForImages(msg,x.msg_text);
        ViewHelper.setViewSizesPrecentaion(x.msg_content_holder,0.8f);

        MsgCommon.msgDelviryStatusText(msg,x.msg_delivery_status);


    }


}
/*//        URI uri = AppUtil.(msg.getMediaLocalSrc());
//        msg_image.
//        Uri u = Uri.parse(msg.getMediaLocalSrc());
        Uri u = Uri.parse("http://localhost:5000/public/photo/1_960.jpg");
        File file = new File(msg.getMediaLocalSrc());
//        int max_width = msg_content_holder.getLayoutParams().width;//px
//        int max_width = msg_content_holder.getWidth();;//px

        int max_width = (int) (AndroidUtil.getScreenWidth() * 0.8);
        AppUtil.log("width: "+max_width+AndroidUtil.getScreenResolution()+AndroidUtil.getDensity());
        max_width = AndroidUtil.pxToDp(max_width);
//        ViewGroup.LayoutParams sizes = new ViewGroup.LayoutParams(AndroidUtil.dpToPx(msg.getMediaWidth()),
//                AndroidUtil.dpToPx(msg.getMediaWidth()));
//        msg_image.setLayoutParams(sizes);

        ViewHelper.setImageSizesWithMaxPx(msg_image, max_width, msg.getMediaWidth(),msg.getMediaHeight());
//        ViewHelper.setViewSizeDp(msg_image,msg.getMediaWidth(),msg.getMediaHeight());
//        msg_image.setLayoutParams();
        file.toURI();
        Uri u2 =Uri.fromFile(file);
//        msg_image.setAspectRatio(1.33f);
        msg_image.setImageURI(u2);

        msg_image.setOnClickListener((v)->{
            new FullScreenImage();
        });*/
