package com.stripe.android.payments.core.injection;

import android.content.Context;
import com.stripe.android.payments.DefaultReturnUrl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AuthenticationModule_Companion_ProvideDefaultReturnUrlFactory implements Factory<DefaultReturnUrl> {
    private final Provider<Context> contextProvider;

    public AuthenticationModule_Companion_ProvideDefaultReturnUrlFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public DefaultReturnUrl get() {
        return provideDefaultReturnUrl(this.contextProvider.get());
    }

    public static AuthenticationModule_Companion_ProvideDefaultReturnUrlFactory create(Provider<Context> provider) {
        return new AuthenticationModule_Companion_ProvideDefaultReturnUrlFactory(provider);
    }

    public static DefaultReturnUrl provideDefaultReturnUrl(Context context) {
        return (DefaultReturnUrl) Preconditions.checkNotNullFromProvides(AuthenticationModule.Companion.provideDefaultReturnUrl(context));
    }
}
