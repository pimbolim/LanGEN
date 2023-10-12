package com.stripe.android.view;

import android.content.Intent;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthWebViewActivity.kt */
final class PaymentAuthWebViewActivity$_args$2 extends Lambda implements Function0<PaymentBrowserAuthContract.Args> {
    final /* synthetic */ PaymentAuthWebViewActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentAuthWebViewActivity$_args$2(PaymentAuthWebViewActivity paymentAuthWebViewActivity) {
        super(0);
        this.this$0 = paymentAuthWebViewActivity;
    }

    public final PaymentBrowserAuthContract.Args invoke() {
        PaymentBrowserAuthContract.Companion companion = PaymentBrowserAuthContract.Companion;
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return companion.parseArgs$payments_core_release(intent);
    }
}
