package com.stripe.android.cards;

import com.stripe.android.cards.CardNumber;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.cards.RemoteCardAccountRangeSource", f = "RemoteCardAccountRangeSource.kt", i = {0, 0, 0}, l = {32}, m = "getAccountRange", n = {"this", "cardNumber", "bin"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: RemoteCardAccountRangeSource.kt */
final class RemoteCardAccountRangeSource$getAccountRange$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteCardAccountRangeSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteCardAccountRangeSource$getAccountRange$1(RemoteCardAccountRangeSource remoteCardAccountRangeSource, Continuation<? super RemoteCardAccountRangeSource$getAccountRange$1> continuation) {
        super(continuation);
        this.this$0 = remoteCardAccountRangeSource;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAccountRange((CardNumber.Unvalidated) null, this);
    }
}
