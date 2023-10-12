package com.stripe.android.link.repositories;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.link.repositories.LinkApiRepository", f = "LinkApiRepository.kt", i = {}, l = {63}, m = "consumerSignUp-yxL6bBk", n = {}, s = {})
/* compiled from: LinkApiRepository.kt */
final class LinkApiRepository$consumerSignUp$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LinkApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkApiRepository$consumerSignUp$1(LinkApiRepository linkApiRepository, Continuation<? super LinkApiRepository$consumerSignUp$1> continuation) {
        super(continuation);
        this.this$0 = linkApiRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r7 = this.this$0.m4313consumerSignUpyxL6bBk((String) null, (String) null, (String) null, (String) null, this);
        return r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r7 : Result.m4708boximpl(r7);
    }
}
