package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.model.PaymentOption;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionCallback;", "", "onPaymentOption", "", "paymentOption", "Lcom/stripe/android/paymentsheet/model/PaymentOption;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionCallback.kt */
public interface PaymentOptionCallback {
    void onPaymentOption(PaymentOption paymentOption);
}
