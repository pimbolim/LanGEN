package com.stripe.android.payments.paymentlauncher;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncherFactory.kt */
final class PaymentLauncherFactory$create$2 extends Lambda implements Function0<String> {
    final /* synthetic */ String $stripeAccountId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentLauncherFactory$create$2(String str) {
        super(0);
        this.$stripeAccountId = str;
    }

    public final String invoke() {
        return this.$stripeAccountId;
    }
}
