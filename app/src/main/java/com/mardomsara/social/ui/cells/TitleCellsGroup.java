package com.mardomsara.social.ui.cells;

import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.lib.Spanny;

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

        public BigClickAbleTitle(ViewGroup parent,String title){
            this(parent);
            text_view.setText(title);
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
        public InfoTitle(ViewGroup parent,String title){
            this(parent);
            text_view.setText(title);
        }

        public void setText(String title){
            text_view.setText(title);
        }
    }

    public static class InfoTitleLight {
        public ViewGroup rootView;
        @Bind(R.id.text_view)
        TextView text_view;

        public InfoTitleLight(ViewGroup parent){
            rootView =(ViewGroup) AppUtil.inflate(R.layout.title_info_light,parent);
            ButterKnife.bind(this,rootView);
        }

        public InfoTitleLight(ViewGroup parent,String title){
            this(parent);
            text_view.setText(title);
        }

        public void setText(String title){
            Spanny spanny = new Spanny();
            spanny.append(title, Typeface.BOLD);
            text_view.setText(spanny);
        }
    }






}
