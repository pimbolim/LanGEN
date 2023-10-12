package com.stripe.android.googlepaylauncher;

import com.stripe.android.PaymentConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeGooglePayActivity.kt */
final class StripeGooglePayActivity$publishableKey$2 extends Lambda implements Function0<String> {
    final /* synthetic */ StripeGooglePayActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeGooglePayActivity$publishableKey$2(StripeGooglePayActivity stripeGooglePayActivity) {
        super(0);
        this.this$0 = stripeGooglePayActivity;
    }

    public final String invoke() {
        return PaymentConfiguration.Companion.getInstance(this.this$0).getPublishableKey();
    }
}
