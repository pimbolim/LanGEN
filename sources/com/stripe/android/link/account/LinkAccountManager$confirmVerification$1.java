package com.stripe.android.link.account;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.link.account.LinkAccountManager", f = "LinkAccountManager.kt", i = {0}, l = {92}, m = "confirmVerification-gIAlu-s", n = {"this"}, s = {"L$0"})
/* compiled from: LinkAccountManager.kt */
final class LinkAccountManager$confirmVerification$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LinkAccountManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkAccountManager$confirmVerification$1(LinkAccountManager linkAccountManager, Continuation<? super LinkAccountManager$confirmVerification$1> continuation) {
        super(continuation);
        this.this$0 = linkAccountManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.m4307confirmVerificationgIAlus((String) null, this);
        return r3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r3 : Result.m4708boximpl(r3);
    }
}
