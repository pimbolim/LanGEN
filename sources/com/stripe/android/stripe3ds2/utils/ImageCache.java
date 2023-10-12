package com.stripe.android.stripe3ds2.utils;

import android.graphics.Bitmap;
import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦\u0002J\u0019\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H¦\u0002¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/utils/ImageCache;", "", "clear", "", "get", "Landroid/graphics/Bitmap;", "key", "", "set", "bitmap", "Default", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCache.kt */
public interface ImageCache {
    void clear();

    Bitmap get(String str);

    void set(String str, Bitmap bitmap);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0019\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/stripe3ds2/utils/ImageCache$Default;", "Lcom/stripe/android/stripe3ds2/utils/ImageCache;", "()V", "KB", "", "MAX_SIZE", "cache", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "getCache$3ds2sdk_release$annotations", "getCache$3ds2sdk_release", "()Landroid/util/LruCache;", "cacheSize", "clear", "", "get", "key", "set", "bitmap", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageCache.kt */
    public static final class Default implements ImageCache {
        public static final Default INSTANCE = new Default();
        private static final int KB = 1024;
        private static final int MAX_SIZE = 10240;
        private static final LruCache<String, Bitmap> cache;
        private static final int cacheSize;

        public static /* synthetic */ void getCache$3ds2sdk_release$annotations() {
        }

        private Default() {
        }

        static {
            int min = Math.min((int) ((Runtime.getRuntime().maxMemory() / ((long) 1024)) / ((long) 8)), MAX_SIZE);
            cacheSize = min;
            cache = new ImageCache$Default$cache$1(min);
        }

        public final LruCache<String, Bitmap> getCache$3ds2sdk_release() {
            return cache;
        }

        public Bitmap get(String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            return cache.get(str);
        }

        public void set(String str, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            cache.put(str, bitmap);
        }

        public void clear() {
            cache.evictAll();
        }
    }
}
