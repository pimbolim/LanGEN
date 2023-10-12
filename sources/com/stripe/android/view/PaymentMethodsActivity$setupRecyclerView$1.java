package com.stripe.android.view;

import com.stripe.android.model.PaymentMethod;
import com.stripe.android.view.PaymentMethodsAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/stripe/android/view/PaymentMethodsActivity$setupRecyclerView$1", "Lcom/stripe/android/view/PaymentMethodsAdapter$Listener;", "onDeletePaymentMethodAction", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "onGooglePayClick", "onPaymentMethodClick", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsActivity.kt */
public final class PaymentMethodsActivity$setupRecyclerView$1 implements PaymentMethodsAdapter.Listener {
    final /* synthetic */ DeletePaymentMethodDialogFactory $deletePaymentMethodDialogFactory;
    final /* synthetic */ PaymentMethodsActivity this$0;

    PaymentMethodsActivity$setupRecyclerView$1(PaymentMethodsActivity paymentMethodsActivity, DeletePaymentMethodDialogFactory deletePaymentMethodDialogFactory) {
        this.this$0 = paymentMethodsActivity;
        this.$deletePaymentMethodDialogFactory = deletePaymentMethodDialogFactory;
    }

    public void onPaymentMethodClick(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        this.this$0.getViewBinding$payments_core_release().recycler.setTappedPaymentMethod$payments_core_release(paymentMethod);
    }

    public void onGooglePayClick() {
        this.this$0.finishWithGooglePay();
    }

    public void onDeletePaymentMethodAction(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        this.$deletePaymentMethodDialogFactory.create(paymentMethod).show();
    }
}
