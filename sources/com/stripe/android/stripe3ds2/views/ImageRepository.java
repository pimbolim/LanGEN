package com.stripe.android.stripe3ds2.views;

import android.graphics.Bitmap;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.utils.ImageCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ImageRepository;", "", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lkotlin/coroutines/CoroutineContext;)V", "imageCache", "Lcom/stripe/android/stripe3ds2/utils/ImageCache;", "imageSupplier", "Lcom/stripe/android/stripe3ds2/views/ImageRepository$ImageSupplier;", "(Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/stripe3ds2/utils/ImageCache;Lcom/stripe/android/stripe3ds2/views/ImageRepository$ImageSupplier;)V", "cacheImage", "", "imageUrl", "", "image", "Landroid/graphics/Bitmap;", "getImage", "getImage$3ds2sdk_release", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalImage", "getRemoteImage", "ImageSupplier", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageRepository.kt */
public final class ImageRepository {
    private final ImageCache imageCache;
    private final ImageSupplier imageSupplier;
    private final CoroutineContext workContext;

    public ImageRepository(CoroutineContext coroutineContext, ImageCache imageCache2, ImageSupplier imageSupplier2) {
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(imageCache2, "imageCache");
        Intrinsics.checkNotNullParameter(imageSupplier2, "imageSupplier");
        this.workContext = coroutineContext;
        this.imageCache = imageCache2;
        this.imageSupplier = imageSupplier2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageRepository(ErrorReporter errorReporter, CoroutineContext coroutineContext) {
        this(coroutineContext, ImageCache.Default.INSTANCE, new ImageSupplier.Default(errorReporter, coroutineContext));
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    public final Object getImage$3ds2sdk_release(String str, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(this.workContext, new ImageRepository$getImage$2(str, this, (Continuation<? super ImageRepository$getImage$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Bitmap getLocalImage(String str) {
        return this.imageCache.get(str);
    }

    /* access modifiers changed from: private */
    public final Object getRemoteImage(String str, Continuation<? super Bitmap> continuation) {
        return this.imageSupplier.getBitmap(str, continuation);
    }

    /* access modifiers changed from: private */
    public final void cacheImage(String str, Bitmap bitmap) {
        if (bitmap != null) {
            this.imageCache.set(str, bitmap);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ImageRepository$ImageSupplier;", "", "getBitmap", "Landroid/graphics/Bitmap;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Default", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageRepository.kt */
    public interface ImageSupplier {
        Object getBitmap(String str, Continuation<? super Bitmap> continuation);

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ImageRepository$ImageSupplier$Default;", "Lcom/stripe/android/stripe3ds2/views/ImageRepository$ImageSupplier;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lkotlin/coroutines/CoroutineContext;)V", "getBitmap", "Landroid/graphics/Bitmap;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ImageRepository.kt */
        public static final class Default implements ImageSupplier {
            private final ErrorReporter errorReporter;
            private final CoroutineContext workContext;

            public Default(ErrorReporter errorReporter2, CoroutineContext coroutineContext) {
                Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
                Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
                this.errorReporter = errorReporter2;
                this.workContext = coroutineContext;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:35:0x007a, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                kotlin.io.CloseableKt.closeFinally(r14, r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
                throw r2;
             */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0065 A[Catch:{ all -> 0x0033 }] */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0067 A[Catch:{ all -> 0x0033 }] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0092  */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x00bb  */
            /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object getBitmap(java.lang.String r13, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r14) {
                /*
                    r12 = this;
                    boolean r0 = r14 instanceof com.stripe.android.stripe3ds2.views.ImageRepository$ImageSupplier$Default$getBitmap$1
                    if (r0 == 0) goto L_0x0014
                    r0 = r14
                    com.stripe.android.stripe3ds2.views.ImageRepository$ImageSupplier$Default$getBitmap$1 r0 = (com.stripe.android.stripe3ds2.views.ImageRepository$ImageSupplier$Default$getBitmap$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r14 = r0.label
                    int r14 = r14 - r2
                    r0.label = r14
                    goto L_0x0019
                L_0x0014:
                    com.stripe.android.stripe3ds2.views.ImageRepository$ImageSupplier$Default$getBitmap$1 r0 = new com.stripe.android.stripe3ds2.views.ImageRepository$ImageSupplier$Default$getBitmap$1
                    r0.<init>(r12, r14)
                L_0x0019:
                    java.lang.Object r14 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    r4 = 0
                    if (r2 == 0) goto L_0x003d
                    if (r2 != r3) goto L_0x0035
                    java.lang.Object r13 = r0.L$1
                    java.lang.String r13 = (java.lang.String) r13
                    java.lang.Object r0 = r0.L$0
                    com.stripe.android.stripe3ds2.views.ImageRepository$ImageSupplier$Default r0 = (com.stripe.android.stripe3ds2.views.ImageRepository.ImageSupplier.Default) r0
                    kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0033 }
                    goto L_0x0061
                L_0x0033:
                    r14 = move-exception
                    goto L_0x0081
                L_0x0035:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r14)
                    throw r13
                L_0x003d:
                    kotlin.ResultKt.throwOnFailure(r14)
                    kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x007f }
                    r14 = r12
                    com.stripe.android.stripe3ds2.views.ImageRepository$ImageSupplier$Default r14 = (com.stripe.android.stripe3ds2.views.ImageRepository.ImageSupplier.Default) r14     // Catch:{ all -> 0x007f }
                    com.stripe.android.stripe3ds2.transaction.StripeHttpClient r2 = new com.stripe.android.stripe3ds2.transaction.StripeHttpClient     // Catch:{ all -> 0x007f }
                    r7 = 0
                    com.stripe.android.stripe3ds2.observability.ErrorReporter r8 = r14.errorReporter     // Catch:{ all -> 0x007f }
                    kotlin.coroutines.CoroutineContext r9 = r14.workContext     // Catch:{ all -> 0x007f }
                    r10 = 2
                    r11 = 0
                    r5 = r2
                    r6 = r13
                    r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x007f }
                    r0.L$0 = r12     // Catch:{ all -> 0x007f }
                    r0.L$1 = r13     // Catch:{ all -> 0x007f }
                    r0.label = r3     // Catch:{ all -> 0x007f }
                    java.lang.Object r14 = r2.doGetRequest(r0)     // Catch:{ all -> 0x007f }
                    if (r14 != r1) goto L_0x0060
                    return r1
                L_0x0060:
                    r0 = r12
                L_0x0061:
                    java.io.InputStream r14 = (java.io.InputStream) r14     // Catch:{ all -> 0x0033 }
                    if (r14 != 0) goto L_0x0067
                    r1 = r4
                    goto L_0x0073
                L_0x0067:
                    java.io.Closeable r14 = (java.io.Closeable) r14     // Catch:{ all -> 0x0033 }
                    r1 = r14
                    java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x0078 }
                    android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ all -> 0x0078 }
                    kotlin.io.CloseableKt.closeFinally(r14, r4)     // Catch:{ all -> 0x0033 }
                L_0x0073:
                    java.lang.Object r14 = kotlin.Result.m4709constructorimpl(r1)     // Catch:{ all -> 0x0033 }
                    goto L_0x008b
                L_0x0078:
                    r1 = move-exception
                    throw r1     // Catch:{ all -> 0x007a }
                L_0x007a:
                    r2 = move-exception
                    kotlin.io.CloseableKt.closeFinally(r14, r1)     // Catch:{ all -> 0x0033 }
                    throw r2     // Catch:{ all -> 0x0033 }
                L_0x007f:
                    r14 = move-exception
                    r0 = r12
                L_0x0081:
                    kotlin.Result$Companion r1 = kotlin.Result.Companion
                    java.lang.Object r14 = kotlin.ResultKt.createFailure(r14)
                    java.lang.Object r14 = kotlin.Result.m4709constructorimpl(r14)
                L_0x008b:
                    java.lang.Throwable r1 = kotlin.Result.m4712exceptionOrNullimpl(r14)
                    if (r1 != 0) goto L_0x0092
                    goto L_0x00b4
                L_0x0092:
                    com.stripe.android.stripe3ds2.observability.ErrorReporter r0 = r0.errorReporter
                    java.lang.RuntimeException r2 = new java.lang.RuntimeException
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r5 = "Could not get bitmap from url: "
                    r3.append(r5)
                    r3.append(r13)
                    r13 = 46
                    r3.append(r13)
                    java.lang.String r13 = r3.toString()
                    r2.<init>(r13, r1)
                    java.lang.Throwable r2 = (java.lang.Throwable) r2
                    r0.reportError(r2)
                L_0x00b4:
                    boolean r13 = kotlin.Result.m4715isFailureimpl(r14)
                    if (r13 == 0) goto L_0x00bb
                    goto L_0x00bc
                L_0x00bb:
                    r4 = r14
                L_0x00bc:
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.views.ImageRepository.ImageSupplier.Default.getBitmap(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }
}
