package com.stripe.android.networking;

import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.PaymentMethodCreateParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeApiRepository.kt */
final class StripeApiRepository$confirmSetupIntent$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConfirmSetupIntentParams $confirmSetupIntentParams;
    final /* synthetic */ StripeApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeApiRepository$confirmSetupIntent$2(StripeApiRepository stripeApiRepository, ConfirmSetupIntentParams confirmSetupIntentParams) {
        super(0);
        this.this$0 = stripeApiRepository;
        this.$confirmSetupIntentParams = confirmSetupIntentParams;
    }

    public final void invoke() {
        StripeApiRepository stripeApiRepository = this.this$0;
        PaymentAnalyticsRequestFactory access$getPaymentAnalyticsRequestFactory$p = stripeApiRepository.paymentAnalyticsRequestFactory;
        PaymentMethodCreateParams paymentMethodCreateParams$payments_core_release = this.$confirmSetupIntentParams.getPaymentMethodCreateParams$payments_core_release();
        stripeApiRepository.fireAnalyticsRequest$payments_core_release(access$getPaymentAnalyticsRequestFactory$p.createSetupIntentConfirmation$payments_core_release(paymentMethodCreateParams$payments_core_release == null ? null : paymentMethodCreateParams$payments_core_release.getTypeCode()));
    }
}
