package com.mardomsara.social.ui;

import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Hamid on 1/30/2016.
 */
public class FooterBar {
    public class Cell extends TextView{

        public Cell(Context context) {
            super(context);
        }

        public Cell(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public Cell(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }
    }


}
