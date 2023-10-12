package com.stripe.android.paymentsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
/* synthetic */ class PaymentOptionsAdapter$onCreateViewHolder$2 extends FunctionReferenceImpl implements Function2<Integer, Boolean, Unit> {
    PaymentOptionsAdapter$onCreateViewHolder$2(Object obj) {
        super(2, obj, PaymentOptionsAdapter.class, "onItemSelected", "onItemSelected$paymentsheet_release(IZ)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, boolean z) {
        ((PaymentOptionsAdapter) this.receiver).onItemSelected$paymentsheet_release(i, z);
    }
}
