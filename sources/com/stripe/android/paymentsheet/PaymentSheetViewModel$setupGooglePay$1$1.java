package com.stripe.android.paymentsheet;

import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isReady", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetViewModel.kt */
final class PaymentSheetViewModel$setupGooglePay$1$1 implements GooglePayPaymentMethodLauncher.ReadyCallback {
    final /* synthetic */ PaymentSheetViewModel this$0;

    PaymentSheetViewModel$setupGooglePay$1$1(PaymentSheetViewModel paymentSheetViewModel) {
        this.this$0 = paymentSheetViewModel;
    }

    public final void onReady(boolean z) {
        this.this$0.getSavedStateHandle().set(BaseSheetViewModel.SAVE_GOOGLE_PAY_READY, Boolean.valueOf(z));
    }
}
