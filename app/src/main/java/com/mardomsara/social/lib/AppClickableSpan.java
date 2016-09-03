package com.mardomsara.social.lib;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import com.mardomsara.social.helpers.AppUtil;

public class AppClickableSpan extends ClickableSpan {// extend ClickableSpan

    String clicked;
    public AppClickableSpan() {
        super();
    }
    public AppClickableSpan(String string) {
        super();
        clicked = string;
    }

    public void onClick(View tv) {
       Toast.makeText(AppUtil.getContext(),clicked , Toast.LENGTH_SHORT).show();
    }

    public void updateDrawState(TextPaint ds) {// override updateDrawState
        ds.setUnderlineText(false); // set to false to remove underline
    }
}