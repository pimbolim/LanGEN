package com.facebook.drawee.backends.pipeline.info;

import com.brentvatne.react.ReactVideoView;

public class ImagePerfUtils {
    public static String toString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : ReactVideoView.EVENT_PROP_ERROR : "canceled" : "success" : "intermediate_available" : "origin_available" : "requested";
    }

    private ImagePerfUtils() {
    }
}
