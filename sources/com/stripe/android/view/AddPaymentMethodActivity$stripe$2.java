package com.stripe.android.view;

import android.content.Context;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.Stripe;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/Stripe;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodActivity.kt */
final class AddPaymentMethodActivity$stripe$2 extends Lambda implements Function0<Stripe> {
    final /* synthetic */ AddPaymentMethodActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddPaymentMethodActivity$stripe$2(AddPaymentMethodActivity addPaymentMethodActivity) {
        super(0);
        this.this$0 = addPaymentMethodActivity;
    }

    public final Stripe invoke() {
        PaymentConfiguration paymentConfiguration$payments_core_release = this.this$0.getArgs().getPaymentConfiguration$payments_core_release();
        if (paymentConfiguration$payments_core_release == null) {
            paymentConfiguration$payments_core_release = PaymentConfiguration.Companion.getInstance(this.this$0);
        }
        Context applicationContext = this.this$0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        return new Stripe(applicationContext, paymentConfiguration$payments_core_release.getPublishableKey(), paymentConfiguration$payments_core_release.getStripeAccountId(), false, (Set) null, 24, (DefaultConstructorMarker) null);
    }
}
