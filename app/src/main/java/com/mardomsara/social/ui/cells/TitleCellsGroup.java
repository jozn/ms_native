package com.mardomsara.social.ui.cells;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/26/2016.
 */
public class TitleCellsGroup {

    public static class BigClickAbleTitle {
        public ViewGroup rootView;
        @Bind(R.id.text_view)
        TextView text_view;

        @Bind(R.id.icon)
        TextView icon;

        public BigClickAbleTitle(ViewGroup parent){
            rootView = (ViewGroup)AppUtil.inflate(R.layout.title_string_clickable,parent);
            ButterKnife.bind(this,rootView);
        }

        public void setIcon(String icon){
            this.icon.setText(icon);
        }

        public void setText(String title){
            text_view.setText(title);
        }
    }

    public static class InfoTitle {
        public ViewGroup rootView;
        @Bind(R.id.text_view)
        TextView text_view;

        public InfoTitle(ViewGroup parent){
            rootView =(ViewGroup) AppUtil.inflate(R.layout.title_info,parent);
            ButterKnife.bind(this,rootView);
        }

        public void setText(String title){
            text_view.setText(title);
        }
    }






}
