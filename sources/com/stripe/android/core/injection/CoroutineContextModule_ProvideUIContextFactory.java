package com.stripe.android.core.injection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.coroutines.CoroutineContext;

public final class CoroutineContextModule_ProvideUIContextFactory implements Factory<CoroutineContext> {
    private final CoroutineContextModule module;

    public CoroutineContextModule_ProvideUIContextFactory(CoroutineContextModule coroutineContextModule) {
        this.module = coroutineContextModule;
    }

    public CoroutineContext get() {
        return provideUIContext(this.module);
    }

    public static CoroutineContextModule_ProvideUIContextFactory create(CoroutineContextModule coroutineContextModule) {
        return new CoroutineContextModule_ProvideUIContextFactory(coroutineContextModule);
    }

    public static CoroutineContext provideUIContext(CoroutineContextModule coroutineContextModule) {
        return (CoroutineContext) Preconditions.checkNotNullFromProvides(coroutineContextModule.provideUIContext());
    }
}
