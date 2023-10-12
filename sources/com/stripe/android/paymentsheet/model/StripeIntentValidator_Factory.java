package com.stripe.android.paymentsheet.model;

import dagger.internal.Factory;

public final class StripeIntentValidator_Factory implements Factory<StripeIntentValidator> {
    public StripeIntentValidator get() {
        return newInstance();
    }

    public static StripeIntentValidator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static StripeIntentValidator newInstance() {
        return new StripeIntentValidator();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final StripeIntentValidator_Factory INSTANCE = new StripeIntentValidator_Factory();

        private InstanceHolder() {
        }
    }
}
