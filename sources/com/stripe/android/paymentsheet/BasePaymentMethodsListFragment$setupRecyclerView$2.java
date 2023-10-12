package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.PaymentOptionsAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasePaymentMethodsListFragment.kt */
/* synthetic */ class BasePaymentMethodsListFragment$setupRecyclerView$2 extends FunctionReferenceImpl implements Function1<PaymentOptionsAdapter.Item.SavedPaymentMethod, Unit> {
    BasePaymentMethodsListFragment$setupRecyclerView$2(Object obj) {
        super(1, obj, BasePaymentMethodsListFragment.class, "deletePaymentMethod", "deletePaymentMethod(Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item$SavedPaymentMethod;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PaymentOptionsAdapter.Item.SavedPaymentMethod) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PaymentOptionsAdapter.Item.SavedPaymentMethod savedPaymentMethod) {
        Intrinsics.checkNotNullParameter(savedPaymentMethod, "p0");
        ((BasePaymentMethodsListFragment) this.receiver).deletePaymentMethod(savedPaymentMethod);
    }
}
