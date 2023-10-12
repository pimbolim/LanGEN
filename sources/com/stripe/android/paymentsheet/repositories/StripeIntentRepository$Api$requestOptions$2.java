package com.stripe.android.paymentsheet.repositories;

import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeIntentRepository.kt */
final class StripeIntentRepository$Api$requestOptions$2 extends Lambda implements Function0<ApiRequest.Options> {
    final /* synthetic */ StripeIntentRepository.Api this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeIntentRepository$Api$requestOptions$2(StripeIntentRepository.Api api) {
        super(0);
        this.this$0 = api;
    }

    public final ApiRequest.Options invoke() {
        return new ApiRequest.Options(((PaymentConfiguration) this.this$0.lazyPaymentConfig.get()).getPublishableKey(), ((PaymentConfiguration) this.this$0.lazyPaymentConfig.get()).getStripeAccountId(), (String) null, 4, (DefaultConstructorMarker) null);
    }
}
