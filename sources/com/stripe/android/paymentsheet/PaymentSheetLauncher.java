package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.PaymentSheet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetLauncher;", "", "presentWithPaymentIntent", "", "paymentIntentClientSecret", "", "configuration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "presentWithSetupIntent", "setupIntentClientSecret", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetLauncher.kt */
public interface PaymentSheetLauncher {
    void presentWithPaymentIntent(String str, PaymentSheet.Configuration configuration);

    void presentWithSetupIntent(String str, PaymentSheet.Configuration configuration);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetLauncher.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void presentWithPaymentIntent$default(PaymentSheetLauncher paymentSheetLauncher, String str, PaymentSheet.Configuration configuration, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    configuration = null;
                }
                paymentSheetLauncher.presentWithPaymentIntent(str, configuration);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: presentWithPaymentIntent");
        }

        public static /* synthetic */ void presentWithSetupIntent$default(PaymentSheetLauncher paymentSheetLauncher, String str, PaymentSheet.Configuration configuration, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    configuration = null;
                }
                paymentSheetLauncher.presentWithSetupIntent(str, configuration);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: presentWithSetupIntent");
        }
    }
}
