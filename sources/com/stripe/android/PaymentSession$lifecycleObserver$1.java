package com.stripe.android;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.stripe.android.PaymentSession;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"com/stripe/android/PaymentSession$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSession.kt */
public final class PaymentSession$lifecycleObserver$1 implements LifecycleObserver {
    final /* synthetic */ PaymentSession this$0;

    PaymentSession$lifecycleObserver$1(PaymentSession paymentSession) {
        this.this$0 = paymentSession;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.this$0.setListener$payments_core_release((PaymentSession.PaymentSessionListener) null);
    }
}
