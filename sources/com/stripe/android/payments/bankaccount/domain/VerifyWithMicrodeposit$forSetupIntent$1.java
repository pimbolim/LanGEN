package com.stripe.android.payments.bankaccount.domain;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit", f = "VerifyWithMicrodeposit.kt", i = {}, l = {62}, m = "forSetupIntent-yxL6bBk", n = {}, s = {})
/* compiled from: VerifyWithMicrodeposit.kt */
final class VerifyWithMicrodeposit$forSetupIntent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VerifyWithMicrodeposit this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerifyWithMicrodeposit$forSetupIntent$1(VerifyWithMicrodeposit verifyWithMicrodeposit, Continuation<? super VerifyWithMicrodeposit$forSetupIntent$1> continuation) {
        super(continuation);
        this.this$0 = verifyWithMicrodeposit;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r7 = this.this$0.m4378forSetupIntentyxL6bBk((String) null, (String) null, 0, 0, this);
        return r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r7 : Result.m4708boximpl(r7);
    }
}
