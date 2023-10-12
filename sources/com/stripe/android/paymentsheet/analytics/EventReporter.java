package com.stripe.android.paymentsheet.analytics;

import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001:\u0001\u000eJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/EventReporter;", "", "onDismiss", "", "onInit", "configuration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "onPaymentFailure", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "onPaymentSuccess", "onSelectPaymentOption", "onShowExistingPaymentOptions", "onShowNewPaymentOptionForm", "Mode", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EventReporter.kt */
public interface EventReporter {
    void onDismiss();

    void onInit(PaymentSheet.Configuration configuration);

    void onPaymentFailure(PaymentSelection paymentSelection);

    void onPaymentSuccess(PaymentSelection paymentSelection);

    void onSelectPaymentOption(PaymentSelection paymentSelection);

    void onShowExistingPaymentOptions();

    void onShowNewPaymentOptionForm();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "toString", "Complete", "Custom", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventReporter.kt */
    public enum Mode {
        Complete("complete"),
        Custom("custom");
        
        private final String code;

        private Mode(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }

        public String toString() {
            return this.code;
        }
    }
}
