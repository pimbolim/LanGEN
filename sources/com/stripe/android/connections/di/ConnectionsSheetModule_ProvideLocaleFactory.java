package com.stripe.android.connections.di;

import dagger.internal.Factory;
import java.util.Locale;

public final class ConnectionsSheetModule_ProvideLocaleFactory implements Factory<Locale> {
    public Locale get() {
        return provideLocale();
    }

    public static ConnectionsSheetModule_ProvideLocaleFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Locale provideLocale() {
        return ConnectionsSheetModule.INSTANCE.provideLocale();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ConnectionsSheetModule_ProvideLocaleFactory INSTANCE = new ConnectionsSheetModule_ProvideLocaleFactory();

        private InstanceHolder() {
        }
    }
}
