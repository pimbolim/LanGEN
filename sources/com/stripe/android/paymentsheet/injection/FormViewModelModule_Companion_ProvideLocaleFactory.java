package com.stripe.android.paymentsheet.injection;

import dagger.internal.Factory;
import java.util.Locale;

public final class FormViewModelModule_Companion_ProvideLocaleFactory implements Factory<Locale> {
    public Locale get() {
        return provideLocale();
    }

    public static FormViewModelModule_Companion_ProvideLocaleFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Locale provideLocale() {
        return FormViewModelModule.Companion.provideLocale();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FormViewModelModule_Companion_ProvideLocaleFactory INSTANCE = new FormViewModelModule_Companion_ProvideLocaleFactory();

        private InstanceHolder() {
        }
    }
}
