package com.stripe.android.paymentsheet;

import android.os.Parcelable;
import com.stripe.android.paymentsheet.PaymentSheetContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetAddPaymentMethodFragment.kt */
final class PaymentSheetAddPaymentMethodFragment$viewModelFactory$2 extends Lambda implements Function0<PaymentSheetContract.Args> {
    final /* synthetic */ PaymentSheetAddPaymentMethodFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSheetAddPaymentMethodFragment$viewModelFactory$2(PaymentSheetAddPaymentMethodFragment paymentSheetAddPaymentMethodFragment) {
        super(0);
        this.this$0 = paymentSheetAddPaymentMethodFragment;
    }

    public final PaymentSheetContract.Args invoke() {
        Parcelable parcelable = this.this$0.requireArguments().getParcelable("com.stripe.android.paymentsheet.extra_starter_args");
        if (parcelable != null) {
            return (PaymentSheetContract.Args) parcelable;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
