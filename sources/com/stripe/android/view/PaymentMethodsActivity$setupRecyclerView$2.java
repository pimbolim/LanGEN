package com.stripe.android.view;

import com.stripe.android.model.PaymentMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/stripe/android/model/PaymentMethod;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsActivity.kt */
final class PaymentMethodsActivity$setupRecyclerView$2 extends Lambda implements Function1<PaymentMethod, Unit> {
    final /* synthetic */ PaymentMethodsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsActivity$setupRecyclerView$2(PaymentMethodsActivity paymentMethodsActivity) {
        super(1);
        this.this$0 = paymentMethodsActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PaymentMethod) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "it");
        PaymentMethodsActivity.finishWithResult$default(this.this$0, paymentMethod, 0, 2, (Object) null);
    }
}
