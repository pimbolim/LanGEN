package com.stripe.android;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.view.AuthActivityStarterHost;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/stripe/android/PaymentRelayStarter;", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripePaymentController.kt */
final class StripePaymentController$paymentRelayStarterFactory$1 extends Lambda implements Function1<AuthActivityStarterHost, PaymentRelayStarter> {
    final /* synthetic */ StripePaymentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripePaymentController$paymentRelayStarterFactory$1(StripePaymentController stripePaymentController) {
        super(1);
        this.this$0 = stripePaymentController;
    }

    public final PaymentRelayStarter invoke(AuthActivityStarterHost authActivityStarterHost) {
        PaymentRelayStarter.Modern modern;
        Intrinsics.checkNotNullParameter(authActivityStarterHost, "host");
        ActivityResultLauncher access$getPaymentRelayLauncher$p = this.this$0.paymentRelayLauncher;
        if (access$getPaymentRelayLauncher$p == null) {
            modern = null;
        } else {
            modern = new PaymentRelayStarter.Modern(access$getPaymentRelayLauncher$p);
        }
        if (modern == null) {
            return new PaymentRelayStarter.Legacy(authActivityStarterHost);
        }
        return modern;
    }
}
