package com.stripe.android.stripe3ds2.init;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository", f = "DefaultAppInfoRepository.kt", i = {0}, l = {61}, m = "get", n = {"this"}, s = {"L$0"})
/* compiled from: DefaultAppInfoRepository.kt */
final class DefaultAppInfoRepository$get$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultAppInfoRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultAppInfoRepository$get$1(DefaultAppInfoRepository defaultAppInfoRepository, Continuation<? super DefaultAppInfoRepository$get$1> continuation) {
        super(continuation);
        this.this$0 = defaultAppInfoRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.get(this);
    }
}
