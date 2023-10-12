package com.stripe.android.paymentsheet.injection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class PaymentOptionsViewModelModule_ProvideDummyInjectorKeyFactory implements Factory<String> {
    private final PaymentOptionsViewModelModule module;

    public PaymentOptionsViewModelModule_ProvideDummyInjectorKeyFactory(PaymentOptionsViewModelModule paymentOptionsViewModelModule) {
        this.module = paymentOptionsViewModelModule;
    }

    public String get() {
        return provideDummyInjectorKey(this.module);
    }

    public static PaymentOptionsViewModelModule_ProvideDummyInjectorKeyFactory create(PaymentOptionsViewModelModule paymentOptionsViewModelModule) {
        return new PaymentOptionsViewModelModule_ProvideDummyInjectorKeyFactory(paymentOptionsViewModelModule);
    }

    public static String provideDummyInjectorKey(PaymentOptionsViewModelModule paymentOptionsViewModelModule) {
        return (String) Preconditions.checkNotNullFromProvides(paymentOptionsViewModelModule.provideDummyInjectorKey());
    }
}
