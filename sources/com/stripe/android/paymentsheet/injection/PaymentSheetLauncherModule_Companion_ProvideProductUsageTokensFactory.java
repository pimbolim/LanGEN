package com.stripe.android.paymentsheet.injection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;

public final class PaymentSheetLauncherModule_Companion_ProvideProductUsageTokensFactory implements Factory<Set<String>> {
    public Set<String> get() {
        return provideProductUsageTokens();
    }

    public static PaymentSheetLauncherModule_Companion_ProvideProductUsageTokensFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Set<String> provideProductUsageTokens() {
        return (Set) Preconditions.checkNotNullFromProvides(PaymentSheetLauncherModule.Companion.provideProductUsageTokens());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PaymentSheetLauncherModule_Companion_ProvideProductUsageTokensFactory INSTANCE = new PaymentSheetLauncherModule_Companion_ProvideProductUsageTokensFactory();

        private InstanceHolder() {
        }
    }
}
