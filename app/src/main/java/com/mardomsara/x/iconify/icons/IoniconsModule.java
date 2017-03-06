package com.mardomsara.x.iconify.icons;


import com.mardomsara.x.iconify.Icon;
import com.mardomsara.x.iconify.IconFontDescriptor;

public class IoniconsModule implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "iconify/android-iconify-ionicons.ttf";
    }

    @Override
    public Icon[] characters() {
        return IoniconsIcons.values();
    }
}