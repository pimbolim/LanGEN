package com.stripe.android.view;

import com.stripe.android.model.PaymentMethod;
import com.stripe.android.view.PaymentMethodSwipeCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/SwipeToDeleteCallbackListener;", "Lcom/stripe/android/view/PaymentMethodSwipeCallback$Listener;", "deletePaymentMethodDialogFactory", "Lcom/stripe/android/view/DeletePaymentMethodDialogFactory;", "(Lcom/stripe/android/view/DeletePaymentMethodDialogFactory;)V", "onSwiped", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwipeToDeleteCallbackListener.kt */
public final class SwipeToDeleteCallbackListener implements PaymentMethodSwipeCallback.Listener {
    private final DeletePaymentMethodDialogFactory deletePaymentMethodDialogFactory;

    public SwipeToDeleteCallbackListener(DeletePaymentMethodDialogFactory deletePaymentMethodDialogFactory2) {
        Intrinsics.checkNotNullParameter(deletePaymentMethodDialogFactory2, "deletePaymentMethodDialogFactory");
        this.deletePaymentMethodDialogFactory = deletePaymentMethodDialogFactory2;
    }

    public void onSwiped(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        this.deletePaymentMethodDialogFactory.create(paymentMethod).show();
    }
}
