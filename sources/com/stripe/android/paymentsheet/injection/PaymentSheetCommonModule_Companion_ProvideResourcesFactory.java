package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PaymentSheetCommonModule_Companion_ProvideResourcesFactory implements Factory<Resources> {
    private final Provider<Context> contextProvider;

    public PaymentSheetCommonModule_Companion_ProvideResourcesFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public Resources get() {
        return provideResources(this.contextProvider.get());
    }

    public static PaymentSheetCommonModule_Companion_ProvideResourcesFactory create(Provider<Context> provider) {
        return new PaymentSheetCommonModule_Companion_ProvideResourcesFactory(provider);
    }

    public static Resources provideResources(Context context) {
        return (Resources) Preconditions.checkNotNullFromProvides(PaymentSheetCommonModule.Companion.provideResources(context));
    }
}
