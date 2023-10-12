package com.stripe.android.paymentsheet.injection;

import dagger.internal.Factory;
import java.util.Locale;

public final class PaymentSheetCommonModule_Companion_ProvideLocaleFactory implements Factory<Locale> {
    public Locale get() {
        return provideLocale();
    }

    public static PaymentSheetCommonModule_Companion_ProvideLocaleFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Locale provideLocale() {
        return PaymentSheetCommonModule.Companion.provideLocale();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PaymentSheetCommonModule_Companion_ProvideLocaleFactory INSTANCE = new PaymentSheetCommonModule_Companion_ProvideLocaleFactory();

        private InstanceHolder() {
        }
    }
}
