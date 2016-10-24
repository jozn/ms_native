package com.mardomsara.social.ui.cells.chats.msgs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.Message;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_PhotoPeer extends MsgCell_AbstractViewHolder {
    @Bind(R.id.msg_time)
    TextView time_txt;
//    @Bind(R.id.msg_delivery_status) TextView msg_delivery_status;
    @Bind(R.id.msg_text) TextView msg_text;
    @Bind(R.id.msg_image)
    SimpleDraweeView msg_image;
    @Bind(R.id.msg_content_holder)
    ViewGroup msg_content_holder;
    //    LinkerText msg_text;
    Message msg;

    public MsgCell_PhotoPeer(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static MsgCell_PhotoPeer makeNew(ViewGroup parent){
        return new MsgCell_PhotoPeer(AppUtil.inflate(R.layout.msg_row_image_peer,parent));
    }

    @Override
    public void bindToView(Message msg) {
        AppUtil.log("bindToView Peer");
//        msg_text.setText(msg.getText());
        MsgCommon.setImage(msg,msg_image);
//        MsgCommon.setContentMaxwhidth(msg,msg_image);
//        ViewHelper.setViewSizesPrecentaion(msg_content_holder,0.8f);
        MsgCommon.setTextForImages(msg,msg_text);
        time_txt.setText(MsgCommon.msgRawTime2(msg));

    }

}
/*


    //        URI uri = AppUtil.(msg.getMediaLocalSrc());
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

        file.toURI();
        Uri u2 =Uri.fromFile(file);
//        msg_image.setAspectRatio(1.33f);
        msg_image.setImageURI(u2);

        grandView.setOnClickListener((v)->{
        FullScreenImage window = new FullScreenImage();
        window.text = msg.getText();
        window.imageUri = u2 ;//msg.getMediaLocalSrc();
        window.show();
        });*/
