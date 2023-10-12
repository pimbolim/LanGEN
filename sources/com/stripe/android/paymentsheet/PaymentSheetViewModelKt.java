package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.model.PaymentSheetViewState;
import com.stripe.android.paymentsheet.ui.PrimaryButton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"convert", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State;", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState;", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetViewModel.kt */
public final class PaymentSheetViewModelKt {
    public static final PrimaryButton.State convert(PaymentSheetViewState paymentSheetViewState) {
        Intrinsics.checkNotNullParameter(paymentSheetViewState, "<this>");
        if (paymentSheetViewState instanceof PaymentSheetViewState.Reset) {
            return PrimaryButton.State.Ready.INSTANCE;
        }
        if (paymentSheetViewState instanceof PaymentSheetViewState.StartProcessing) {
            return PrimaryButton.State.StartProcessing.INSTANCE;
        }
        if (paymentSheetViewState instanceof PaymentSheetViewState.FinishProcessing) {
            return new PrimaryButton.State.FinishProcessing(((PaymentSheetViewState.FinishProcessing) paymentSheetViewState).getOnComplete());
        }
        throw new NoWhenBranchMatchedException();
    }
}
