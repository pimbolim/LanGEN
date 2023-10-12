package com.stripe.android.view;

import com.stripe.android.PaymentSessionConfig;
import com.stripe.android.model.ShippingMethod;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/view/PaymentFlowPagerAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowActivity.kt */
final class PaymentFlowActivity$paymentFlowPagerAdapter$2 extends Lambda implements Function0<PaymentFlowPagerAdapter> {
    final /* synthetic */ PaymentFlowActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentFlowActivity$paymentFlowPagerAdapter$2(PaymentFlowActivity paymentFlowActivity) {
        super(0);
        this.this$0 = paymentFlowActivity;
    }

    public final PaymentFlowPagerAdapter invoke() {
        PaymentFlowActivity paymentFlowActivity = this.this$0;
        PaymentSessionConfig access$getPaymentSessionConfig = paymentFlowActivity.getPaymentSessionConfig();
        Set<String> allowedShippingCountryCodes = this.this$0.getPaymentSessionConfig().getAllowedShippingCountryCodes();
        final PaymentFlowActivity paymentFlowActivity2 = this.this$0;
        return new PaymentFlowPagerAdapter(paymentFlowActivity, access$getPaymentSessionConfig, allowedShippingCountryCodes, new Function1<ShippingMethod, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ShippingMethod) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ShippingMethod shippingMethod) {
                Intrinsics.checkNotNullParameter(shippingMethod, "it");
                paymentFlowActivity2.getViewModel().setSelectedShippingMethod$payments_core_release(shippingMethod);
            }
        });
    }
}
