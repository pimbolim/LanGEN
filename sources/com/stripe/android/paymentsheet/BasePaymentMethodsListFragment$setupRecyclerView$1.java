package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.model.PaymentSelection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasePaymentMethodsListFragment.kt */
/* synthetic */ class BasePaymentMethodsListFragment$setupRecyclerView$1 extends FunctionReferenceImpl implements Function2<PaymentSelection, Boolean, Unit> {
    BasePaymentMethodsListFragment$setupRecyclerView$1(Object obj) {
        super(2, obj, BasePaymentMethodsListFragment.class, "onPaymentOptionSelected", "onPaymentOptionSelected(Lcom/stripe/android/paymentsheet/model/PaymentSelection;Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PaymentSelection) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PaymentSelection paymentSelection, boolean z) {
        Intrinsics.checkNotNullParameter(paymentSelection, "p0");
        ((BasePaymentMethodsListFragment) this.receiver).onPaymentOptionSelected(paymentSelection, z);
    }
}
