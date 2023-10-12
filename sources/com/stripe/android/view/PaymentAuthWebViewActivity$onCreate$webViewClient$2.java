package com.stripe.android.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthWebViewActivity.kt */
/* synthetic */ class PaymentAuthWebViewActivity$onCreate$webViewClient$2 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    PaymentAuthWebViewActivity$onCreate$webViewClient$2(Object obj) {
        super(1, obj, PaymentAuthWebViewActivity.class, "onAuthComplete", "onAuthComplete$payments_core_release(Ljava/lang/Throwable;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        ((PaymentAuthWebViewActivity) this.receiver).onAuthComplete$payments_core_release(th);
    }
}
