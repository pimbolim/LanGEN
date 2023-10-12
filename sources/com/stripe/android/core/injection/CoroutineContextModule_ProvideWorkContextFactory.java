package com.stripe.android.core.injection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.coroutines.CoroutineContext;

public final class CoroutineContextModule_ProvideWorkContextFactory implements Factory<CoroutineContext> {
    private final CoroutineContextModule module;

    public CoroutineContextModule_ProvideWorkContextFactory(CoroutineContextModule coroutineContextModule) {
        this.module = coroutineContextModule;
    }

    public CoroutineContext get() {
        return provideWorkContext(this.module);
    }

    public static CoroutineContextModule_ProvideWorkContextFactory create(CoroutineContextModule coroutineContextModule) {
        return new CoroutineContextModule_ProvideWorkContextFactory(coroutineContextModule);
    }

    public static CoroutineContext provideWorkContext(CoroutineContextModule coroutineContextModule) {
        return (CoroutineContext) Preconditions.checkNotNullFromProvides(coroutineContextModule.provideWorkContext());
    }
}
