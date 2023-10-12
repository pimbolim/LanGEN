package com.stripe.android.view;

import com.stripe.android.CustomerSession;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/CustomerSession;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowActivity.kt */
final class PaymentFlowActivity$customerSession$2 extends Lambda implements Function0<CustomerSession> {
    public static final PaymentFlowActivity$customerSession$2 INSTANCE = new PaymentFlowActivity$customerSession$2();

    PaymentFlowActivity$customerSession$2() {
        super(0);
    }

    public final CustomerSession invoke() {
        return CustomerSession.Companion.getInstance();
    }
}
