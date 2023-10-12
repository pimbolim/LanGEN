package com.stripe.android.paymentsheet;

import android.os.Parcelable;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAddPaymentMethodFragment.kt */
final class PaymentOptionsAddPaymentMethodFragment$viewModelFactory$2 extends Lambda implements Function0<PaymentOptionContract.Args> {
    final /* synthetic */ PaymentOptionsAddPaymentMethodFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsAddPaymentMethodFragment$viewModelFactory$2(PaymentOptionsAddPaymentMethodFragment paymentOptionsAddPaymentMethodFragment) {
        super(0);
        this.this$0 = paymentOptionsAddPaymentMethodFragment;
    }

    public final PaymentOptionContract.Args invoke() {
        Parcelable parcelable = this.this$0.requireArguments().getParcelable("com.stripe.android.paymentsheet.extra_starter_args");
        if (parcelable != null) {
            return (PaymentOptionContract.Args) parcelable;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
