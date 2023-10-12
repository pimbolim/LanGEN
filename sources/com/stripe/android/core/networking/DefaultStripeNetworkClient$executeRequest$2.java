package com.stripe.android.core.networking;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/stripe/android/core/networking/StripeResponse;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultStripeNetworkClient.kt */
final class DefaultStripeNetworkClient$executeRequest$2 extends Lambda implements Function0<StripeResponse<String>> {
    final /* synthetic */ StripeRequest $request;
    final /* synthetic */ DefaultStripeNetworkClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultStripeNetworkClient$executeRequest$2(DefaultStripeNetworkClient defaultStripeNetworkClient, StripeRequest stripeRequest) {
        super(0);
        this.this$0 = defaultStripeNetworkClient;
        this.$request = stripeRequest;
    }

    public final StripeResponse<String> invoke() {
        return this.this$0.makeRequest(this.$request);
    }
}
