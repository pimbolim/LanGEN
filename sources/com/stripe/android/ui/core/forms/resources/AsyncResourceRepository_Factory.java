package com.stripe.android.ui.core.forms.resources;

import android.content.res.Resources;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class AsyncResourceRepository_Factory implements Factory<AsyncResourceRepository> {
    private final Provider<Locale> localeProvider;
    private final Provider<Resources> resourcesProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public AsyncResourceRepository_Factory(Provider<Resources> provider, Provider<CoroutineContext> provider2, Provider<Locale> provider3) {
        this.resourcesProvider = provider;
        this.workContextProvider = provider2;
        this.localeProvider = provider3;
    }

    public AsyncResourceRepository get() {
        return newInstance(this.resourcesProvider.get(), this.workContextProvider.get(), this.localeProvider.get());
    }

    public static AsyncResourceRepository_Factory create(Provider<Resources> provider, Provider<CoroutineContext> provider2, Provider<Locale> provider3) {
        return new AsyncResourceRepository_Factory(provider, provider2, provider3);
    }

    public static AsyncResourceRepository newInstance(Resources resources, CoroutineContext coroutineContext, Locale locale) {
        return new AsyncResourceRepository(resources, coroutineContext, locale);
    }
}
