package com.stripe.android.view;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/view/CardDisplayTextFactory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsActivity.kt */
final class PaymentMethodsActivity$cardDisplayTextFactory$2 extends Lambda implements Function0<CardDisplayTextFactory> {
    final /* synthetic */ PaymentMethodsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsActivity$cardDisplayTextFactory$2(PaymentMethodsActivity paymentMethodsActivity) {
        super(0);
        this.this$0 = paymentMethodsActivity;
    }

    public final CardDisplayTextFactory invoke() {
        return new CardDisplayTextFactory(this.this$0);
    }
}
