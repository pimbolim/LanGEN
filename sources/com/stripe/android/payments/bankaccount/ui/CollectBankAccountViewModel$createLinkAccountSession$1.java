package com.stripe.android.payments.bankaccount.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel", f = "CollectBankAccountViewModel.kt", i = {0, 1, 2}, l = {51, 57, 67, 74}, m = "createLinkAccountSession", n = {"this", "this", "this"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: CollectBankAccountViewModel.kt */
final class CollectBankAccountViewModel$createLinkAccountSession$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectBankAccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectBankAccountViewModel$createLinkAccountSession$1(CollectBankAccountViewModel collectBankAccountViewModel, Continuation<? super CollectBankAccountViewModel$createLinkAccountSession$1> continuation) {
        super(continuation);
        this.this$0 = collectBankAccountViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createLinkAccountSession(this);
    }
}
