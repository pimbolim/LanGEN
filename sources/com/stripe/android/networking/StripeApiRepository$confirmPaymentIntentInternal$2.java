package com.stripe.android.networking;

import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.SourceParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeApiRepository.kt */
final class StripeApiRepository$confirmPaymentIntentInternal$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConfirmPaymentIntentParams $confirmPaymentIntentParams;
    final /* synthetic */ StripeApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeApiRepository$confirmPaymentIntentInternal$2(ConfirmPaymentIntentParams confirmPaymentIntentParams, StripeApiRepository stripeApiRepository) {
        super(0);
        this.$confirmPaymentIntentParams = confirmPaymentIntentParams;
        this.this$0 = stripeApiRepository;
    }

    public final void invoke() {
        PaymentMethodCreateParams paymentMethodCreateParams = this.$confirmPaymentIntentParams.getPaymentMethodCreateParams();
        String str = null;
        String typeCode = paymentMethodCreateParams == null ? null : paymentMethodCreateParams.getTypeCode();
        if (typeCode == null) {
            SourceParams sourceParams = this.$confirmPaymentIntentParams.getSourceParams();
            if (sourceParams != null) {
                str = sourceParams.getType();
            }
        } else {
            str = typeCode;
        }
        StripeApiRepository stripeApiRepository = this.this$0;
        stripeApiRepository.fireAnalyticsRequest$payments_core_release(stripeApiRepository.paymentAnalyticsRequestFactory.createPaymentIntentConfirmation$payments_core_release(str));
    }
}
