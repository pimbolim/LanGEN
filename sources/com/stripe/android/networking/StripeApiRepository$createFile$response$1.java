package com.stripe.android.networking;

import com.stripe.android.core.networking.RequestId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/stripe/android/core/networking/RequestId;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeApiRepository.kt */
final class StripeApiRepository$createFile$response$1 extends Lambda implements Function1<RequestId, Unit> {
    final /* synthetic */ StripeApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeApiRepository$createFile$response$1(StripeApiRepository stripeApiRepository) {
        super(1);
        this.this$0 = stripeApiRepository;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RequestId) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RequestId requestId) {
        this.this$0.fireAnalyticsRequest(PaymentAnalyticsEvent.FileCreate);
    }
}
