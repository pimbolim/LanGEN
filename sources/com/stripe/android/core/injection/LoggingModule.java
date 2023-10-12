package com.stripe.android.core.injection;

import com.stripe.android.core.Logger;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/core/injection/LoggingModule;", "", "()V", "provideLogger", "Lcom/stripe/android/core/Logger;", "enableLogging", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: LoggingModule.kt */
public final class LoggingModule {
    public static final int $stable = 0;

    @Singleton
    @Provides
    public final Logger provideLogger(@Named("enableLogging") boolean z) {
        return Logger.Companion.getInstance(z);
    }
}
