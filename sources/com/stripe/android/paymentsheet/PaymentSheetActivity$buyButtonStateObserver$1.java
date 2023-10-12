package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.model.PaymentSheetViewState;
import com.stripe.android.paymentsheet.ui.PrimaryButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "viewState", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetActivity.kt */
final class PaymentSheetActivity$buyButtonStateObserver$1 extends Lambda implements Function1<PaymentSheetViewState, Unit> {
    final /* synthetic */ PaymentSheetActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSheetActivity$buyButtonStateObserver$1(PaymentSheetActivity paymentSheetActivity) {
        super(1);
        this.this$0 = paymentSheetActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PaymentSheetViewState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PaymentSheetViewState paymentSheetViewState) {
        PaymentSheetActivity paymentSheetActivity = this.this$0;
        PrimaryButton.State state = null;
        paymentSheetActivity.updateErrorMessage(paymentSheetActivity.getMessageView(), paymentSheetViewState == null ? null : paymentSheetViewState.getErrorMessage());
        PrimaryButton primaryButton = this.this$0.getViewBinding$paymentsheet_release().buyButton;
        if (paymentSheetViewState != null) {
            state = PaymentSheetViewModelKt.convert(paymentSheetViewState);
        }
        primaryButton.updateState(state);
    }
}
