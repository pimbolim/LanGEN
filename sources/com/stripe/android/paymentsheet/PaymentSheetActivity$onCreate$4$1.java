package com.stripe.android.paymentsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetActivity.kt */
/* synthetic */ class PaymentSheetActivity$onCreate$4$1 extends FunctionReferenceImpl implements Function0<Unit> {
    PaymentSheetActivity$onCreate$4$1(Object obj) {
        super(0, obj, PaymentSheetViewModel.class, "launchLink", "launchLink()V", 0);
    }

    public final void invoke() {
        ((PaymentSheetViewModel) this.receiver).launchLink();
    }
}
