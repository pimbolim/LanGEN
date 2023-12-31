package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class NikonType1MakernoteDirectory extends Directory {
    public static final int TAG_CCD_SENSITIVITY = 6;
    public static final int TAG_COLOR_MODE = 4;
    public static final int TAG_CONVERTER = 11;
    public static final int TAG_DIGITAL_ZOOM = 10;
    public static final int TAG_FOCUS = 8;
    public static final int TAG_IMAGE_ADJUSTMENT = 5;
    public static final int TAG_QUALITY = 3;
    public static final int TAG_UNKNOWN_1 = 2;
    public static final int TAG_UNKNOWN_2 = 9;
    public static final int TAG_UNKNOWN_3 = 3840;
    public static final int TAG_WHITE_BALANCE = 7;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Nikon Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(6, "CCD Sensitivity");
        hashMap.put(4, "Color Mode");
        hashMap.put(10, "Digital Zoom");
        hashMap.put(11, "Fisheye Converter");
        hashMap.put(8, "Focus");
        hashMap.put(5, "Image Adjustment");
        hashMap.put(3, "Quality");
        hashMap.put(2, "Makernote Unknown 1");
        hashMap.put(9, "Makernote Unknown 2");
        hashMap.put(3840, "Makernote Unknown 3");
        hashMap.put(7, "White Balance");
    }

    public NikonType1MakernoteDirectory() {
        setDescriptor(new NikonType1MakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
