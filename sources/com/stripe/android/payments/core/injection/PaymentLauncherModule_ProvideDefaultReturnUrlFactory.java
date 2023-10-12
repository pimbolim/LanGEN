package com.stripe.android.payments.core.injection;

import android.content.Context;
import com.stripe.android.payments.DefaultReturnUrl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PaymentLauncherModule_ProvideDefaultReturnUrlFactory implements Factory<DefaultReturnUrl> {
    private final Provider<Context> contextProvider;
    private final PaymentLauncherModule module;

    public PaymentLauncherModule_ProvideDefaultReturnUrlFactory(PaymentLauncherModule paymentLauncherModule, Provider<Context> provider) {
        this.module = paymentLauncherModule;
        this.contextProvider = provider;
    }

    public DefaultReturnUrl get() {
        return provideDefaultReturnUrl(this.module, this.contextProvider.get());
    }

    public static PaymentLauncherModule_ProvideDefaultReturnUrlFactory create(PaymentLauncherModule paymentLauncherModule, Provider<Context> provider) {
        return new PaymentLauncherModule_ProvideDefaultReturnUrlFactory(paymentLauncherModule, provider);
    }

    public static DefaultReturnUrl provideDefaultReturnUrl(PaymentLauncherModule paymentLauncherModule, Context context) {
        return (DefaultReturnUrl) Preconditions.checkNotNullFromProvides(paymentLauncherModule.provideDefaultReturnUrl(context));
    }
}
