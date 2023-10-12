package com.stripe.android.payments.core.injection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;

public final class PaymentLauncherModule_ProvideThreeDs1IntentReturnUrlMapFactory implements Factory<Map<String, String>> {
    private final PaymentLauncherModule module;

    public PaymentLauncherModule_ProvideThreeDs1IntentReturnUrlMapFactory(PaymentLauncherModule paymentLauncherModule) {
        this.module = paymentLauncherModule;
    }

    public Map<String, String> get() {
        return provideThreeDs1IntentReturnUrlMap(this.module);
    }

    public static PaymentLauncherModule_ProvideThreeDs1IntentReturnUrlMapFactory create(PaymentLauncherModule paymentLauncherModule) {
        return new PaymentLauncherModule_ProvideThreeDs1IntentReturnUrlMapFactory(paymentLauncherModule);
    }

    public static Map<String, String> provideThreeDs1IntentReturnUrlMap(PaymentLauncherModule paymentLauncherModule) {
        return (Map) Preconditions.checkNotNullFromProvides(paymentLauncherModule.provideThreeDs1IntentReturnUrlMap());
    }
}
