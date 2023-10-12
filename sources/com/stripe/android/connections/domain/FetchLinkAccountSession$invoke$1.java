package com.stripe.android.connections.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.connections.domain.FetchLinkAccountSession", f = "FetchLinkAccountSession.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {23, 28, 34}, m = "invoke", n = {"this", "clientSecret", "this", "clientSecret", "linkAccountSession", "accounts", "this", "clientSecret", "linkAccountSession", "accounts"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: FetchLinkAccountSession.kt */
final class FetchLinkAccountSession$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FetchLinkAccountSession this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchLinkAccountSession$invoke$1(FetchLinkAccountSession fetchLinkAccountSession, Continuation<? super FetchLinkAccountSession$invoke$1> continuation) {
        super(continuation);
        this.this$0 = fetchLinkAccountSession;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((String) null, this);
    }
}
