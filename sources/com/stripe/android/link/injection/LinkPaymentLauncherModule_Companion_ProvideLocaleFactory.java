package com.stripe.android.link.injection;

import dagger.internal.Factory;
import java.util.Locale;

public final class LinkPaymentLauncherModule_Companion_ProvideLocaleFactory implements Factory<Locale> {
    public Locale get() {
        return provideLocale();
    }

    public static LinkPaymentLauncherModule_Companion_ProvideLocaleFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Locale provideLocale() {
        return LinkPaymentLauncherModule.Companion.provideLocale();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LinkPaymentLauncherModule_Companion_ProvideLocaleFactory INSTANCE = new LinkPaymentLauncherModule_Companion_ProvideLocaleFactory();

        private InstanceHolder() {
        }
    }
}
