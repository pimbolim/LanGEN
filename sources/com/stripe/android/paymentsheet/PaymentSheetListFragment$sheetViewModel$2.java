package com.stripe.android.paymentsheet;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetListFragment.kt */
final class PaymentSheetListFragment$sheetViewModel$2 extends Lambda implements Function0<PaymentSheetViewModel> {
    final /* synthetic */ PaymentSheetListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSheetListFragment$sheetViewModel$2(PaymentSheetListFragment paymentSheetListFragment) {
        super(0);
        this.this$0 = paymentSheetListFragment;
    }

    public final PaymentSheetViewModel invoke() {
        return this.this$0.getActivityViewModel();
    }
}
