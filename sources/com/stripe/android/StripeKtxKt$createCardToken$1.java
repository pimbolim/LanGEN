package com.stripe.android;

import com.stripe.android.model.CardParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.StripeKtxKt", f = "StripeKtx.kt", i = {}, l = {297}, m = "createCardToken", n = {}, s = {})
/* compiled from: StripeKtx.kt */
final class StripeKtxKt$createCardToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    StripeKtxKt$createCardToken$1(Continuation<? super StripeKtxKt$createCardToken$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StripeKtxKt.createCardToken((Stripe) null, (CardParams) null, (String) null, (String) null, this);
    }
}
