package com.stripe.android.payments.bankaccount.domain;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession", f = "AttachLinkAccountSession.kt", i = {}, l = {43}, m = "forSetupIntent-BWLJW6A", n = {}, s = {})
/* compiled from: AttachLinkAccountSession.kt */
final class AttachLinkAccountSession$forSetupIntent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AttachLinkAccountSession this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AttachLinkAccountSession$forSetupIntent$1(AttachLinkAccountSession attachLinkAccountSession, Continuation<? super AttachLinkAccountSession$forSetupIntent$1> continuation) {
        super(continuation);
        this.this$0 = attachLinkAccountSession;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.m4372forSetupIntentBWLJW6A((String) null, (String) null, (String) null, this);
        return r3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r3 : Result.m4708boximpl(r3);
    }
}