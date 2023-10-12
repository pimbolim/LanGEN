package com.stripe.android.payments.bankaccount.domain;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit", f = "VerifyWithMicrodeposit.kt", i = {}, l = {81}, m = "forSetupIntent-BWLJW6A", n = {}, s = {})
/* compiled from: VerifyWithMicrodeposit.kt */
final class VerifyWithMicrodeposit$forSetupIntent$4 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VerifyWithMicrodeposit this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerifyWithMicrodeposit$forSetupIntent$4(VerifyWithMicrodeposit verifyWithMicrodeposit, Continuation<? super VerifyWithMicrodeposit$forSetupIntent$4> continuation) {
        super(continuation);
        this.this$0 = verifyWithMicrodeposit;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.m4377forSetupIntentBWLJW6A((String) null, (String) null, (String) null, this);
        return r3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r3 : Result.m4708boximpl(r3);
    }
}
