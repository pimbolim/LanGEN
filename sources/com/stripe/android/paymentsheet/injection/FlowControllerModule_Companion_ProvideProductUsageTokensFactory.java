package com.stripe.android.paymentsheet.injection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;

public final class FlowControllerModule_Companion_ProvideProductUsageTokensFactory implements Factory<Set<String>> {
    public Set<String> get() {
        return provideProductUsageTokens();
    }

    public static FlowControllerModule_Companion_ProvideProductUsageTokensFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Set<String> provideProductUsageTokens() {
        return (Set) Preconditions.checkNotNullFromProvides(FlowControllerModule.Companion.provideProductUsageTokens());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FlowControllerModule_Companion_ProvideProductUsageTokensFactory INSTANCE = new FlowControllerModule_Companion_ProvideProductUsageTokensFactory();

        private InstanceHolder() {
        }
    }
}
