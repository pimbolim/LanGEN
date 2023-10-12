package com.stripe.android.connections.di;

import dagger.internal.Factory;

public final class ConnectionsSheetConfigurationModule_ProvidesEnableLoggingFactory implements Factory<Boolean> {
    public Boolean get() {
        return Boolean.valueOf(providesEnableLogging());
    }

    public static ConnectionsSheetConfigurationModule_ProvidesEnableLoggingFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean providesEnableLogging() {
        return ConnectionsSheetConfigurationModule.INSTANCE.providesEnableLogging();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ConnectionsSheetConfigurationModule_ProvidesEnableLoggingFactory INSTANCE = new ConnectionsSheetConfigurationModule_ProvidesEnableLoggingFactory();

        private InstanceHolder() {
        }
    }
}
