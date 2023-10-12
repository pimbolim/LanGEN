package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseAddPaymentMethodFragment.kt */
final class BaseAddPaymentMethodFragment$setupRecyclerView$1$1$1$1 extends Lambda implements Function1<SupportedPaymentMethod, Unit> {
    final /* synthetic */ BaseAddPaymentMethodFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseAddPaymentMethodFragment$setupRecyclerView$1$1$1$1(BaseAddPaymentMethodFragment baseAddPaymentMethodFragment) {
        super(1);
        this.this$0 = baseAddPaymentMethodFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SupportedPaymentMethod) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SupportedPaymentMethod supportedPaymentMethod) {
        Intrinsics.checkNotNullParameter(supportedPaymentMethod, "selectedLpm");
        this.this$0.onPaymentMethodSelected$paymentsheet_release(supportedPaymentMethod);
    }
}
