package com.stripe.android.core.networking;

import dagger.internal.Factory;

public final class RetryDelaySupplier_Factory implements Factory<RetryDelaySupplier> {
    public RetryDelaySupplier get() {
        return newInstance();
    }

    public static RetryDelaySupplier_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RetryDelaySupplier newInstance() {
        return new RetryDelaySupplier();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RetryDelaySupplier_Factory INSTANCE = new RetryDelaySupplier_Factory();

        private InstanceHolder() {
        }
    }
}
