package com.stripe.android.view;

import android.view.View;
import android.view.ViewGroup;
import com.stripe.android.R;
import com.stripe.android.databinding.PaymentFlowActivityBinding;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/databinding/PaymentFlowActivityBinding;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowActivity.kt */
final class PaymentFlowActivity$viewBinding$2 extends Lambda implements Function0<PaymentFlowActivityBinding> {
    final /* synthetic */ PaymentFlowActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentFlowActivity$viewBinding$2(PaymentFlowActivity paymentFlowActivity) {
        super(0);
        this.this$0 = paymentFlowActivity;
    }

    public final PaymentFlowActivityBinding invoke() {
        this.this$0.getViewStub$payments_core_release().setLayoutResource(R.layout.payment_flow_activity);
        View inflate = this.this$0.getViewStub$payments_core_release().inflate();
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        PaymentFlowActivityBinding bind = PaymentFlowActivityBinding.bind((ViewGroup) inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(root)");
        return bind;
    }
}
