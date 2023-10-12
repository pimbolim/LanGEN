package com.stripe.android.payments.bankaccount.di;

import dagger.internal.Factory;

public final class CollectBankAccountModule_ProvidesEnableLoggingFactory implements Factory<Boolean> {
    public Boolean get() {
        return Boolean.valueOf(providesEnableLogging());
    }

    public static CollectBankAccountModule_ProvidesEnableLoggingFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean providesEnableLogging() {
        return CollectBankAccountModule.INSTANCE.providesEnableLogging();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CollectBankAccountModule_ProvidesEnableLoggingFactory INSTANCE = new CollectBankAccountModule_ProvidesEnableLoggingFactory();

        private InstanceHolder() {
        }
    }
}
