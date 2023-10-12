package com.stripe.android.googlepaylauncher.injection;

import android.content.Context;
import com.stripe.android.core.Logger;
import com.stripe.android.googlepaylauncher.GooglePayEnvironment;
import com.stripe.android.googlepaylauncher.GooglePayRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.functions.Function1;

public final class GooglePayLauncherModule_ProvideGooglePayRepositoryFactoryFactory implements Factory<Function1<GooglePayEnvironment, GooglePayRepository>> {
    private final Provider<Context> appContextProvider;
    private final Provider<Logger> loggerProvider;
    private final GooglePayLauncherModule module;

    public GooglePayLauncherModule_ProvideGooglePayRepositoryFactoryFactory(GooglePayLauncherModule googlePayLauncherModule, Provider<Context> provider, Provider<Logger> provider2) {
        this.module = googlePayLauncherModule;
        this.appContextProvider = provider;
        this.loggerProvider = provider2;
    }

    public Function1<GooglePayEnvironment, GooglePayRepository> get() {
        return provideGooglePayRepositoryFactory(this.module, this.appContextProvider.get(), this.loggerProvider.get());
    }

    public static GooglePayLauncherModule_ProvideGooglePayRepositoryFactoryFactory create(GooglePayLauncherModule googlePayLauncherModule, Provider<Context> provider, Provider<Logger> provider2) {
        return new GooglePayLauncherModule_ProvideGooglePayRepositoryFactoryFactory(googlePayLauncherModule, provider, provider2);
    }

    public static Function1<GooglePayEnvironment, GooglePayRepository> provideGooglePayRepositoryFactory(GooglePayLauncherModule googlePayLauncherModule, Context context, Logger logger) {
        return (Function1) Preconditions.checkNotNullFromProvides(googlePayLauncherModule.provideGooglePayRepositoryFactory(context, logger));
    }
}
