package com.stripe.android.core.injection;

import com.stripe.android.core.Logger;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class LoggingModule_ProvideLoggerFactory implements Factory<Logger> {
    private final Provider<Boolean> enableLoggingProvider;
    private final LoggingModule module;

    public LoggingModule_ProvideLoggerFactory(LoggingModule loggingModule, Provider<Boolean> provider) {
        this.module = loggingModule;
        this.enableLoggingProvider = provider;
    }

    public Logger get() {
        return provideLogger(this.module, this.enableLoggingProvider.get().booleanValue());
    }

    public static LoggingModule_ProvideLoggerFactory create(LoggingModule loggingModule, Provider<Boolean> provider) {
        return new LoggingModule_ProvideLoggerFactory(loggingModule, provider);
    }

    public static Logger provideLogger(LoggingModule loggingModule, boolean z) {
        return (Logger) Preconditions.checkNotNullFromProvides(loggingModule.provideLogger(z));
    }
}
