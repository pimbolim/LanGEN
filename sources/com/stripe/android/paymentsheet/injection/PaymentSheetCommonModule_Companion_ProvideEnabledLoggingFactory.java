package com.stripe.android.paymentsheet.injection;

import dagger.internal.Factory;

public final class PaymentSheetCommonModule_Companion_ProvideEnabledLoggingFactory implements Factory<Boolean> {
    public Boolean get() {
        return Boolean.valueOf(provideEnabledLogging());
    }

    public static PaymentSheetCommonModule_Companion_ProvideEnabledLoggingFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provideEnabledLogging() {
        return PaymentSheetCommonModule.Companion.provideEnabledLogging();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PaymentSheetCommonModule_Companion_ProvideEnabledLoggingFactory INSTANCE = new PaymentSheetCommonModule_Companion_ProvideEnabledLoggingFactory();

        private InstanceHolder() {
        }
    }
}
