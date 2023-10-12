package com.stripe.android;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripePaymentController.kt */
final class StripePaymentController$Companion$create$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $publishableKey;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripePaymentController$Companion$create$1(String str) {
        super(0);
        this.$publishableKey = str;
    }

    public final String invoke() {
        return this.$publishableKey;
    }
}
