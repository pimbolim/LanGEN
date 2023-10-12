package com.stripe.android.link.model;

import dagger.internal.Factory;

public final class Navigator_Factory implements Factory<Navigator> {
    public Navigator get() {
        return newInstance();
    }

    public static Navigator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Navigator newInstance() {
        return new Navigator();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final Navigator_Factory INSTANCE = new Navigator_Factory();

        private InstanceHolder() {
        }
    }
}
