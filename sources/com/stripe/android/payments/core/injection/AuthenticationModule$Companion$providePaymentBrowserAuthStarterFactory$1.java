package com.stripe.android.payments.core.injection;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.PaymentBrowserAuthStarter;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.core.authentication.DefaultPaymentAuthenticatorRegistry;
import com.stripe.android.view.AuthActivityStarterHost;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/stripe/android/PaymentBrowserAuthStarter;", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthenticationModule.kt */
final class AuthenticationModule$Companion$providePaymentBrowserAuthStarterFactory$1 extends Lambda implements Function1<AuthActivityStarterHost, PaymentBrowserAuthStarter> {
    final /* synthetic */ DefaultReturnUrl $defaultReturnUrl;
    final /* synthetic */ Lazy<DefaultPaymentAuthenticatorRegistry> $lazyRegistry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthenticationModule$Companion$providePaymentBrowserAuthStarterFactory$1(Lazy<DefaultPaymentAuthenticatorRegistry> lazy, DefaultReturnUrl defaultReturnUrl) {
        super(1);
        this.$lazyRegistry = lazy;
        this.$defaultReturnUrl = defaultReturnUrl;
    }

    public final PaymentBrowserAuthStarter invoke(AuthActivityStarterHost authActivityStarterHost) {
        PaymentBrowserAuthStarter.Modern modern;
        Intrinsics.checkNotNullParameter(authActivityStarterHost, "host");
        ActivityResultLauncher<PaymentBrowserAuthContract.Args> paymentBrowserAuthLauncher$payments_core_release = this.$lazyRegistry.get().getPaymentBrowserAuthLauncher$payments_core_release();
        if (paymentBrowserAuthLauncher$payments_core_release == null) {
            modern = null;
        } else {
            modern = new PaymentBrowserAuthStarter.Modern(paymentBrowserAuthLauncher$payments_core_release);
        }
        if (modern == null) {
            return new PaymentBrowserAuthStarter.Legacy(authActivityStarterHost, this.$defaultReturnUrl);
        }
        return modern;
    }
}
