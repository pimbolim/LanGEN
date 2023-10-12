package com.imagepicker.media;

import android.webkit.MimeTypeMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import java.io.File;

public class ImageConfig {
    public final int maxHeight;
    public final int maxWidth;
    public final File original;
    public final int quality;
    public final File resized;
    public final int rotation;
    public final boolean saveToCameraRoll;

    public ImageConfig(File file, File file2, int i, int i2, int i3, int i4, boolean z) {
        this.original = file;
        this.resized = file2;
        this.maxWidth = i;
        this.maxHeight = i2;
        this.quality = i3;
        this.rotation = i4;
        this.saveToCameraRoll = z;
    }

    public ImageConfig withMaxWidth(int i) {
        return new ImageConfig(this.original, this.resized, i, this.maxHeight, this.quality, this.rotation, this.saveToCameraRoll);
    }

    public ImageConfig withMaxHeight(int i) {
        return new ImageConfig(this.original, this.resized, this.maxWidth, i, this.quality, this.rotation, this.saveToCameraRoll);
    }

    public ImageConfig withQuality(int i) {
        return new ImageConfig(this.original, this.resized, this.maxWidth, this.maxHeight, i, this.rotation, this.saveToCameraRoll);
    }

    public ImageConfig withRotation(int i) {
        return new ImageConfig(this.original, this.resized, this.maxWidth, this.maxHeight, this.quality, i, this.saveToCameraRoll);
    }

    public ImageConfig withOriginalFile(File file) {
        if (file != null) {
            boolean contains = MimeTypeMap.getFileExtensionFromUrl(file.getAbsolutePath()).contains("gif");
        }
        return new ImageConfig(file, this.resized, this.maxWidth, this.maxHeight, this.quality, this.rotation, this.saveToCameraRoll);
    }

    public ImageConfig withResizedFile(File file) {
        return new ImageConfig(this.original, file, this.maxWidth, this.maxHeight, this.quality, this.rotation, this.saveToCameraRoll);
    }

    public ImageConfig withSaveToCameraRoll(boolean z) {
        return new ImageConfig(this.original, this.resized, this.maxWidth, this.maxHeight, this.quality, this.rotation, z);
    }

    public ImageConfig updateFromOptions(ReadableMap readableMap) {
        boolean z;
        int i = readableMap.hasKey(ViewProps.MAX_WIDTH) ? (int) readableMap.getDouble(ViewProps.MAX_WIDTH) : 0;
        int i2 = readableMap.hasKey(ViewProps.MAX_HEIGHT) ? (int) readableMap.getDouble(ViewProps.MAX_HEIGHT) : 0;
        int i3 = readableMap.hasKey("quality") ? (int) (readableMap.getDouble("quality") * 100.0d) : 100;
        int i4 = readableMap.hasKey("rotation") ? (int) readableMap.getDouble("rotation") : 0;
        if (readableMap.hasKey("storageOptions")) {
            ReadableMap map = readableMap.getMap("storageOptions");
            if (map.hasKey("cameraRoll")) {
                z = map.getBoolean("cameraRoll");
                return new ImageConfig(this.original, this.resized, i, i2, i3, i4, z);
            }
        }
        z = false;
        return new ImageConfig(this.original, this.resized, i, i2, i3, i4, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = r1.rotation;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r2 = r1.maxHeight;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean useOriginal(int r2, int r3, int r4) {
        /*
            r1 = this;
            int r0 = r1.maxWidth
            if (r2 >= r0) goto L_0x0006
            if (r0 > 0) goto L_0x0008
        L_0x0006:
            if (r0 != 0) goto L_0x001e
        L_0x0008:
            int r2 = r1.maxHeight
            if (r3 >= r2) goto L_0x000e
            if (r2 > 0) goto L_0x0010
        L_0x000e:
            if (r2 != 0) goto L_0x001e
        L_0x0010:
            int r2 = r1.quality
            r3 = 100
            if (r2 != r3) goto L_0x001e
            int r2 = r1.rotation
            if (r2 == 0) goto L_0x001c
            if (r4 != r2) goto L_0x001e
        L_0x001c:
            r2 = 1
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.media.ImageConfig.useOriginal(int, int, int):boolean");
    }

    public File getActualFile() {
        File file = this.resized;
        return file != null ? file : this.original;
    }
}
