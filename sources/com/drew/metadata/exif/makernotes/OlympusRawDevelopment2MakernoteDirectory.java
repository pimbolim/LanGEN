package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusRawDevelopment2MakernoteDirectory extends Directory {
    public static final int TagRawDevArtFilter = 289;
    public static final int TagRawDevAutoGradation = 281;
    public static final int TagRawDevColorSpace = 265;
    public static final int TagRawDevContrastValue = 261;
    public static final int TagRawDevEngine = 267;
    public static final int TagRawDevExposureBiasValue = 256;
    public static final int TagRawDevGradation = 274;
    public static final int TagRawDevGrayPoint = 260;
    public static final int TagRawDevMemoryColorEmphasis = 264;
    public static final int TagRawDevNoiseReduction = 266;
    public static final int TagRawDevPictureMode = 268;
    public static final int TagRawDevPmBwFilter = 272;
    public static final int TagRawDevPmContrast = 270;
    public static final int TagRawDevPmNoiseFilter = 288;
    public static final int TagRawDevPmPictureTone = 273;
    public static final int TagRawDevPmSaturation = 269;
    public static final int TagRawDevPmSharpness = 271;
    public static final int TagRawDevSaturation3 = 275;
    public static final int TagRawDevSaturationEmphasis = 263;
    public static final int TagRawDevSharpnessValue = 262;
    public static final int TagRawDevVersion = 0;
    public static final int TagRawDevWbFineAdjustment = 259;
    public static final int TagRawDevWhiteBalance = 257;
    public static final int TagRawDevWhiteBalanceValue = 258;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Olympus Raw Development 2";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Raw Dev Version");
        hashMap.put(256, "Raw Dev Exposure Bias Value");
        hashMap.put(257, "Raw Dev White Balance");
        hashMap.put(258, "Raw Dev White Balance Value");
        hashMap.put(259, "Raw Dev WB Fine Adjustment");
        hashMap.put(260, "Raw Dev Gray Point");
        hashMap.put(261, "Raw Dev Contrast Value");
        hashMap.put(262, "Raw Dev Sharpness Value");
        hashMap.put(263, "Raw Dev Saturation Emphasis");
        hashMap.put(264, "Raw Dev Memory Color Emphasis");
        hashMap.put(265, "Raw Dev Color Space");
        hashMap.put(266, "Raw Dev Noise Reduction");
        hashMap.put(267, "Raw Dev Engine");
        hashMap.put(268, "Raw Dev Picture Mode");
        hashMap.put(269, "Raw Dev PM Saturation");
        hashMap.put(270, "Raw Dev PM Contrast");
        hashMap.put(271, "Raw Dev PM Sharpness");
        hashMap.put(272, "Raw Dev PM BW Filter");
        hashMap.put(273, "Raw Dev PM Picture Tone");
        hashMap.put(274, "Raw Dev Gradation");
        hashMap.put(275, "Raw Dev Saturation 3");
        hashMap.put(281, "Raw Dev Auto Gradation");
        hashMap.put(288, "Raw Dev PM Noise Filter");
        hashMap.put(289, "Raw Dev Art Filter");
    }

    public OlympusRawDevelopment2MakernoteDirectory() {
        setDescriptor(new OlympusRawDevelopment2MakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
