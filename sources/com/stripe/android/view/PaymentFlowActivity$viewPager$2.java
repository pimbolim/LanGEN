package com.stripe.android.view;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/view/PaymentFlowViewPager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowActivity.kt */
final class PaymentFlowActivity$viewPager$2 extends Lambda implements Function0<PaymentFlowViewPager> {
    final /* synthetic */ PaymentFlowActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentFlowActivity$viewPager$2(PaymentFlowActivity paymentFlowActivity) {
        super(0);
        this.this$0 = paymentFlowActivity;
    }

    public final PaymentFlowViewPager invoke() {
        PaymentFlowViewPager paymentFlowViewPager = this.this$0.getViewBinding().shippingFlowViewpager;
        Intrinsics.checkNotNullExpressionValue(paymentFlowViewPager, "viewBinding.shippingFlowViewpager");
        return paymentFlowViewPager;
    }
}
