package com.mardomsara.x.iconify.icons;


import com.mardomsara.x.iconify.Icon;
import com.mardomsara.x.iconify.IconFontDescriptor;

public class MaterialModule implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "iconify/android-iconify-material.ttf";
    }

    @Override
    public Icon[] characters() {
        return MaterialIcons.values();
    }
}
