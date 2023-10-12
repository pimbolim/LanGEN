package com.stripe.android.view;

import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/core/Logger;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthWebViewActivity.kt */
final class PaymentAuthWebViewActivity$logger$2 extends Lambda implements Function0<Logger> {
    final /* synthetic */ PaymentAuthWebViewActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentAuthWebViewActivity$logger$2(PaymentAuthWebViewActivity paymentAuthWebViewActivity) {
        super(0);
        this.this$0 = paymentAuthWebViewActivity;
    }

    public final Logger invoke() {
        Logger.Companion companion = Logger.Companion;
        PaymentBrowserAuthContract.Args access$get_args = this.this$0.get_args();
        boolean z = false;
        if (access$get_args != null && access$get_args.getEnableLogging()) {
            z = true;
        }
        return companion.getInstance(z);
    }
}
