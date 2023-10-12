package com.stripe.android.payments.bankaccount.domain;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession", f = "CreateLinkAccountSession.kt", i = {}, l = {44}, m = "forSetupIntent-yxL6bBk", n = {}, s = {})
/* compiled from: CreateLinkAccountSession.kt */
final class CreateLinkAccountSession$forSetupIntent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreateLinkAccountSession this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateLinkAccountSession$forSetupIntent$1(CreateLinkAccountSession createLinkAccountSession, Continuation<? super CreateLinkAccountSession$forSetupIntent$1> continuation) {
        super(continuation);
        this.this$0 = createLinkAccountSession;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r7 = this.this$0.m4374forSetupIntentyxL6bBk((String) null, (String) null, (String) null, (String) null, this);
        return r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r7 : Result.m4708boximpl(r7);
    }
}
