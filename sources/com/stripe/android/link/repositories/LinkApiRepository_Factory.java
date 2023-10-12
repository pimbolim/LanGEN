package com.stripe.android.link.repositories;

import com.stripe.android.core.Logger;
import com.stripe.android.networking.StripeRepository;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class LinkApiRepository_Factory implements Factory<LinkApiRepository> {
    private final Provider<Locale> localeProvider;
    private final Provider<Logger> loggerProvider;
    private final Provider<Function0<String>> publishableKeyProvider;
    private final Provider<Function0<String>> stripeAccountIdProvider;
    private final Provider<StripeRepository> stripeRepositoryProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public LinkApiRepository_Factory(Provider<Function0<String>> provider, Provider<Function0<String>> provider2, Provider<StripeRepository> provider3, Provider<Logger> provider4, Provider<CoroutineContext> provider5, Provider<Locale> provider6) {
        this.publishableKeyProvider = provider;
        this.stripeAccountIdProvider = provider2;
        this.stripeRepositoryProvider = provider3;
        this.loggerProvider = provider4;
        this.workContextProvider = provider5;
        this.localeProvider = provider6;
    }

    public LinkApiRepository get() {
        return newInstance(this.publishableKeyProvider.get(), this.stripeAccountIdProvider.get(), this.stripeRepositoryProvider.get(), this.loggerProvider.get(), this.workContextProvider.get(), this.localeProvider.get());
    }

    public static LinkApiRepository_Factory create(Provider<Function0<String>> provider, Provider<Function0<String>> provider2, Provider<StripeRepository> provider3, Provider<Logger> provider4, Provider<CoroutineContext> provider5, Provider<Locale> provider6) {
        return new LinkApiRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static LinkApiRepository newInstance(Function0<String> function0, Function0<String> function02, StripeRepository stripeRepository, Logger logger, CoroutineContext coroutineContext, Locale locale) {
        return new LinkApiRepository(function0, function02, stripeRepository, logger, coroutineContext, locale);
    }
}
