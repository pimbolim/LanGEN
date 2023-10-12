package com.stripe.android.core.injection;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/core/injection/CoroutineContextModule;", "", "()V", "provideUIContext", "Lkotlin/coroutines/CoroutineContext;", "provideWorkContext", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: CoroutineContextModule.kt */
public final class CoroutineContextModule {
    public static final int $stable = 0;

    @Singleton
    @IOContext
    @Provides
    public final CoroutineContext provideWorkContext() {
        return Dispatchers.getIO();
    }

    @Singleton
    @UIContext
    @Provides
    public final CoroutineContext provideUIContext() {
        return Dispatchers.getMain();
    }
}
