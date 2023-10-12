package com.stripe.android.payments.core.injection;

import com.stripe.android.PaymentAuthConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class Stripe3DSAuthenticatorModule_Companion_ProvidePaymentAuthConfigFactory implements Factory<PaymentAuthConfig> {
    public PaymentAuthConfig get() {
        return providePaymentAuthConfig();
    }

    public static Stripe3DSAuthenticatorModule_Companion_ProvidePaymentAuthConfigFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PaymentAuthConfig providePaymentAuthConfig() {
        return (PaymentAuthConfig) Preconditions.checkNotNullFromProvides(Stripe3DSAuthenticatorModule.Companion.providePaymentAuthConfig());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final Stripe3DSAuthenticatorModule_Companion_ProvidePaymentAuthConfigFactory INSTANCE = new Stripe3DSAuthenticatorModule_Companion_ProvidePaymentAuthConfigFactory();

        private InstanceHolder() {
        }
    }
}
