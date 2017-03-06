package com.mardomsara.x.iconify.icons;


import com.mardomsara.x.iconify.Icon;
import com.mardomsara.x.iconify.IconFontDescriptor;

public class SimpleLineIconsModule implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "iconify/android-iconify-simplelineicons.ttf";
    }

    @Override
    public Icon[] characters() {
        return SimpleLineIconsIcons.values();
    }
}