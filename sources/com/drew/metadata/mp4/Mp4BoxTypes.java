package com.drew.metadata.mp4;

import java.util.ArrayList;

public class Mp4BoxTypes {
    public static final String BOX_FILE_TYPE = "ftyp";
    public static final String BOX_HANDLER = "hdlr";
    public static final String BOX_HINT_MEDIA_INFO = "hmhd";
    public static final String BOX_MEDIA_HEADER = "mdhd";
    public static final String BOX_MOVIE_HEADER = "mvhd";
    public static final String BOX_NULL_MEDIA_INFO = "nmhd";
    public static final String BOX_SAMPLE_DESCRIPTION = "stsd";
    public static final String BOX_SOUND_MEDIA_INFO = "smhd";
    public static final String BOX_TIME_TO_SAMPLE = "stts";
    public static final String BOX_VIDEO_MEDIA_INFO = "vmhd";
    public static ArrayList<String> _boxList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        _boxList = arrayList;
        arrayList.add("ftyp");
        _boxList.add("mvhd");
        _boxList.add("vmhd");
        _boxList.add("smhd");
        _boxList.add(BOX_HINT_MEDIA_INFO);
        _boxList.add("nmhd");
        _boxList.add("hdlr");
        _boxList.add("stsd");
        _boxList.add("stts");
        _boxList.add("mdhd");
    }
}
