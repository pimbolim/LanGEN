package com.stripe.android.networking;

import com.stripe.android.model.SourceParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeApiRepository.kt */
final class StripeApiRepository$createSource$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SourceParams $sourceParams;
    final /* synthetic */ StripeApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeApiRepository$createSource$2(StripeApiRepository stripeApiRepository, SourceParams sourceParams) {
        super(0);
        this.this$0 = stripeApiRepository;
        this.$sourceParams = sourceParams;
    }

    public final void invoke() {
        StripeApiRepository stripeApiRepository = this.this$0;
        stripeApiRepository.fireAnalyticsRequest$payments_core_release(stripeApiRepository.paymentAnalyticsRequestFactory.createSourceCreation$payments_core_release(this.$sourceParams.getType(), this.$sourceParams.getAttribution$payments_core_release()));
    }
}
