package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.model.Stripe3ds2AuthResult;
import com.stripe.android.stripe3ds2.transaction.Transaction;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel", f = "Stripe3ds2TransactionViewModel.kt", i = {}, l = {175}, m = "on3ds2AuthSuccess$payments_core_release", n = {}, s = {})
/* compiled from: Stripe3ds2TransactionViewModel.kt */
final class Stripe3ds2TransactionViewModel$on3ds2AuthSuccess$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Stripe3ds2TransactionViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe3ds2TransactionViewModel$on3ds2AuthSuccess$1(Stripe3ds2TransactionViewModel stripe3ds2TransactionViewModel, Continuation<? super Stripe3ds2TransactionViewModel$on3ds2AuthSuccess$1> continuation) {
        super(continuation);
        this.this$0 = stripe3ds2TransactionViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.on3ds2AuthSuccess$payments_core_release((Stripe3ds2AuthResult) null, (Transaction) null, (String) null, 0, this);
    }
}
