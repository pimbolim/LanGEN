package com.stripe.android.view;

import com.stripe.android.model.PaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/model/PaymentMethod$Type;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodActivity.kt */
final class AddPaymentMethodActivity$paymentMethodType$2 extends Lambda implements Function0<PaymentMethod.Type> {
    final /* synthetic */ AddPaymentMethodActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddPaymentMethodActivity$paymentMethodType$2(AddPaymentMethodActivity addPaymentMethodActivity) {
        super(0);
        this.this$0 = addPaymentMethodActivity;
    }

    public final PaymentMethod.Type invoke() {
        return this.this$0.getArgs().getPaymentMethodType$payments_core_release();
    }
}
