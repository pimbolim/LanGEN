package com.stripe.android.googlepaylauncher;

import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncherViewModel.kt */
final class GooglePayPaymentMethodLauncherViewModel$Factory$fallbackInitialize$1 extends Lambda implements Function0<String> {
    final /* synthetic */ GooglePayPaymentMethodLauncherViewModel.Factory.FallbackInjectionParams $arg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayPaymentMethodLauncherViewModel$Factory$fallbackInitialize$1(GooglePayPaymentMethodLauncherViewModel.Factory.FallbackInjectionParams fallbackInjectionParams) {
        super(0);
        this.$arg = fallbackInjectionParams;
    }

    public final String invoke() {
        return this.$arg.getPublishableKey();
    }
}
