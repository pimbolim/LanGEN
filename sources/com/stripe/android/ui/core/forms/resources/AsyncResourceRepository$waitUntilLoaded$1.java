package com.stripe.android.ui.core.forms.resources;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.ui.core.forms.resources.AsyncResourceRepository", f = "AsyncResourceRepository.kt", i = {0}, l = {54}, m = "waitUntilLoaded", n = {"this"}, s = {"L$0"})
/* compiled from: AsyncResourceRepository.kt */
final class AsyncResourceRepository$waitUntilLoaded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncResourceRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AsyncResourceRepository$waitUntilLoaded$1(AsyncResourceRepository asyncResourceRepository, Continuation<? super AsyncResourceRepository$waitUntilLoaded$1> continuation) {
        super(continuation);
        this.this$0 = asyncResourceRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.waitUntilLoaded(this);
    }
}
