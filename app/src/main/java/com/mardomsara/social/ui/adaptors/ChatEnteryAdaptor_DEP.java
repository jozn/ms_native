package com.mardomsara.social.ui.adaptors;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mardomsara.social.App;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

//import butterknife.Bind;

/**
 * Created by Hamid on 2/13/2016.
 */
public class ChatEnteryAdaptor_DEP extends RecyclerView.Adapter<ChatEnteryAdaptor_DEP.ViewHolder> {
//    @Bind()
    public List<MessagesTable> msgs;
    public void setMsgs(List<MessagesTable> msgs) {
        this.msgs = msgs;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.msg_time) TextView time_txt;
        @Bind(R.id.msg_delivery_status) TextView msg_delivery_status;
        @Bind(R.id.msg_text) TextView msg_text;
//        @Bind(R.id.msg_image)
        ImageView msg_image;

        TextView txt ;
        View v ;
        ViewGroup vg ;
//        View orginal;
        int typeId =0;
        MessagesTable msg;
        @DebugLog
        public ViewHolder(View v , int type) {
            super(v);
            typeId = type;
//            orginal = v;
            txt = (TextView)v.findViewById(R.id.msg_text);
            vg = (ViewGroup) v.findViewById(R.id.msg_content_holder);
            if (type == 11 ){
                ButterKnife.bind(this,v);

            }
            if(type == 40 || type == 41){
//                ButterKnife.bind(this,v);
                msg_image = (ImageView) v.findViewById(R.id.msg_image);

                msg_image.setImageResource(R.drawable.keyboard_background_holo);
            }

        }
    }

    public ChatEnteryAdaptor_DEP() {
        super();

       // DBSingletons.getAppDataBase();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view.
        LayoutInflater _infl = LayoutInflater.from(parent.getContext());
        View rowView =  _infl.inflate(R.layout.empty, parent, false);

        if(viewType % 2 == 0){//even: peer
            switch (viewType) {
                case 10:
                    rowView = _infl.inflate(R.layout.msg_row_text_peer, parent, false);
                    break;
                case 12:
                    rowView = _infl.inflate(R.layout.msg_row_contact_peer, parent, false);
                    break;
                case 14:
                    rowView = _infl.inflate(R.layout.msg_row_location_peer, parent, false);
                    break;
                case 16:
                    rowView = _infl.inflate(R.layout.msg_row_sticker_peer, parent, false);
                    break;
                case 30:
                    rowView = _infl.inflate(R.layout.msg_row_post_peer, parent, false);
                    break;
                case 40://// TODO: 6/11/2016  :change to msg_row_image_peer
                    rowView = _infl.inflate(R.layout.msg_row_image_me, parent, false);
                    break;
                case 42:
                    rowView = _infl.inflate(R.layout.msg_row_audio_peer, parent, false);
                    break;
                case 44:
                    rowView = _infl.inflate(R.layout.msg_row_file_peer, parent, false);
                    break;
            }
        }else {//odd views: is ME
            switch (viewType-1) {//1 comes from .isByMe()
                case 10:
                    rowView = _infl.inflate(R.layout.msg_row_text_me, parent, false);
                    break;
                case 12:
                    rowView = _infl.inflate(R.layout.msg_row_contact_me, parent, false);
                    break;
                case 14:
                    rowView = _infl.inflate(R.layout.msg_row_location_me, parent, false);
                    break;
                case 16:
                    rowView = _infl.inflate(R.layout.msg_row_sticker_me, parent, false);
                    break;
                case 30:
                    rowView = _infl.inflate(R.layout.msg_row_post_me, parent, false);
                    break;
                case 40:
                    rowView = _infl.inflate(R.layout.msg_row_image_me, parent, false);
                    break;
                case 42:
                    rowView = _infl.inflate(R.layout.msg_row_audio_me, parent, false);
                    break;
                case 44:
                    rowView = _infl.inflate(R.layout.msg_row_file_me, parent, false);
                    break;
            }
        }

        if(viewType == 1 || viewType == 2){
            rowView = _infl.inflate(R.layout.msg_row_system, parent, false);
        }
        return new ViewHolder(rowView,viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, int position) {

//        vh.txt.setText("YES "+ position);

        switch (vh.typeId){
            case 10:
            case 11:
                bindTextTypeView(vh, position);
                break;
            case 40:
            case 41:
                bindImagTypeView(vh, position);
        }
    }

    private void bindImagTypeView(ViewHolder vh, int position) {
        MessagesTable msg = msgs.get(position);
        Uri uri = Uri.parse(msg.getMediaLocalSrc());
        File file = new File(msg.getMediaLocalSrc());
        if(file.exists()){
            vh.msg_image.setImageURI(uri);
        }else {
            Bitmap bm =ImageUtil.base64ToBitmap(msg.getMediaThumb64());
            vh.msg_image.setImageBitmap(bm);
        }

    }

    @DebugLog
    private void bindTextTypeView(ViewHolder vh, int position) {
        MessagesTable msg = msgs.get(position);
//        AppUtil.log("Msg: "+position);
//        TextView time = (TextView) vh.orginal.findViewById(R.id.msg_time);
        vh.txt.setText(msg.getText());
        TextView tx = new TextView(App.getContext());
        Date d = new Date(msg.getCreatedMs());
        SimpleDateFormat format = new SimpleDateFormat("hH:mm");

        tx.setText(format.format(d));
//        vh.vg.addView(tx);
//        vh.vg.addView(MsgDeliveryStatus.getNew());
        if(msg.MessageTypeId == 10 && msg.getIsByMe() == 1 ){
            vh.time_txt.setText(format.format(d));
//            vh.msg_delivery_status.setText("www");
            ViewHelper.msgDelviryStatusText(msg,vh.msg_delivery_status);
        }
       // time.setText(""+msg.getCreatedTimestampMs() +msg.getDeliveryStatus() );
    }

    @Override
    public int getItemViewType(int position) {
        int type = 10;
        MessagesTable m =msgs.get(position);
        if (m == null) return type;
        type = m.getMessageTypeId()+m.getIsByMe();
        return type;
//        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);


    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }


    @Subscribe
    public void onEvent(MessageSyncMeta meta){
        logIt("event meta: XXXXX " + meta.toString());
    }



    protected void logIt(String str) {
        Log.d(" "+ this.getClass().getSimpleName() ," "+ str);
    }

}


//    @Override
//    public int getItemViewType(int position) {
//        int type = 0;
//        if(position%2 ==0){
//            type = 1;//peer
//        }else {
//            type = 2;
//        }
//        return type;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        int type = 0;
//        if(msgs.get(position).getIsByMe() == 1){
//            type = 1;
//        }else {
//            type = 2;//peer
//        }
//        return type;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // Create a new view.
//        if(viewType == 2){
//            View v = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.msg_row_all_peer, parent, false);
//
//            return new ViewHolder(v, viewType);
//        }else {
//            View v = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.msg_row_all_me, parent, false);
//
//            return new ViewHolder(v,viewType);
//        }
//
//    }

