package com.stripe.android.googlepaylauncher;

import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.Injector;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$injector$1", "Lcom/stripe/android/core/injection/Injector;", "inject", "", "injectable", "Lcom/stripe/android/core/injection/Injectable;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncher.kt */
public final class GooglePayPaymentMethodLauncher$injector$1 implements Injector {
    final /* synthetic */ GooglePayPaymentMethodLauncher this$0;

    GooglePayPaymentMethodLauncher$injector$1(GooglePayPaymentMethodLauncher googlePayPaymentMethodLauncher) {
        this.this$0 = googlePayPaymentMethodLauncher;
    }

    public void inject(Injectable<?> injectable) {
        Intrinsics.checkNotNullParameter(injectable, "injectable");
        if (injectable instanceof GooglePayPaymentMethodLauncherViewModel.Factory) {
            this.this$0.launcherComponent.inject((GooglePayPaymentMethodLauncherViewModel.Factory) injectable);
            return;
        }
        throw new IllegalArgumentException("invalid Injectable " + injectable + " requested in " + this);
    }
}
