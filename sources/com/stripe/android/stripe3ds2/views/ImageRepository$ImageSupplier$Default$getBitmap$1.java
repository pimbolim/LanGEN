package com.stripe.android.stripe3ds2.views;

import com.stripe.android.stripe3ds2.views.ImageRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.views.ImageRepository$ImageSupplier$Default", f = "ImageRepository.kt", i = {0, 0}, l = {60}, m = "getBitmap", n = {"this", "url"}, s = {"L$0", "L$1"})
/* compiled from: ImageRepository.kt */
final class ImageRepository$ImageSupplier$Default$getBitmap$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageRepository.ImageSupplier.Default this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageRepository$ImageSupplier$Default$getBitmap$1(ImageRepository.ImageSupplier.Default defaultR, Continuation<? super ImageRepository$ImageSupplier$Default$getBitmap$1> continuation) {
        super(continuation);
        this.this$0 = defaultR;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getBitmap((String) null, this);
    }
}
