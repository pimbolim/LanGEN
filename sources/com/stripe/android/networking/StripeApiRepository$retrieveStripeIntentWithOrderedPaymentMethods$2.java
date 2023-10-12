package com.stripe.android.networking;

import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lcom/stripe/android/model/StripeIntent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeApiRepository.kt */
final class StripeApiRepository$retrieveStripeIntentWithOrderedPaymentMethods$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PaymentAnalyticsEvent $analyticsEvent;
    final /* synthetic */ StripeApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeApiRepository$retrieveStripeIntentWithOrderedPaymentMethods$2(StripeApiRepository stripeApiRepository, PaymentAnalyticsEvent paymentAnalyticsEvent) {
        super(0);
        this.this$0 = stripeApiRepository;
        this.$analyticsEvent = paymentAnalyticsEvent;
    }

    public final void invoke() {
        StripeApiRepository stripeApiRepository = this.this$0;
        stripeApiRepository.fireAnalyticsRequest$payments_core_release(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(stripeApiRepository.paymentAnalyticsRequestFactory, this.$analyticsEvent, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }
}
