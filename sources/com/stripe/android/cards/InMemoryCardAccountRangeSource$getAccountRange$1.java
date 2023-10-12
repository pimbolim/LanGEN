package com.stripe.android.cards;

import com.stripe.android.cards.CardNumber;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.cards.InMemoryCardAccountRangeSource", f = "InMemoryCardAccountRangeSource.kt", i = {0}, l = {16}, m = "getAccountRange", n = {"cardNumber"}, s = {"L$0"})
/* compiled from: InMemoryCardAccountRangeSource.kt */
final class InMemoryCardAccountRangeSource$getAccountRange$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InMemoryCardAccountRangeSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InMemoryCardAccountRangeSource$getAccountRange$1(InMemoryCardAccountRangeSource inMemoryCardAccountRangeSource, Continuation<? super InMemoryCardAccountRangeSource$getAccountRange$1> continuation) {
        super(continuation);
        this.this$0 = inMemoryCardAccountRangeSource;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAccountRange((CardNumber.Unvalidated) null, this);
    }
}
