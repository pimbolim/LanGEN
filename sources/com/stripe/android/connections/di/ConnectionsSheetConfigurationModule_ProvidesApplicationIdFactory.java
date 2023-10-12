package com.stripe.android.connections.di;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ConnectionsSheetConfigurationModule_ProvidesApplicationIdFactory implements Factory<String> {
    private final Provider<Application> applicationProvider;

    public ConnectionsSheetConfigurationModule_ProvidesApplicationIdFactory(Provider<Application> provider) {
        this.applicationProvider = provider;
    }

    public String get() {
        return providesApplicationId(this.applicationProvider.get());
    }

    public static ConnectionsSheetConfigurationModule_ProvidesApplicationIdFactory create(Provider<Application> provider) {
        return new ConnectionsSheetConfigurationModule_ProvidesApplicationIdFactory(provider);
    }

    public static String providesApplicationId(Application application) {
        return (String) Preconditions.checkNotNullFromProvides(ConnectionsSheetConfigurationModule.INSTANCE.providesApplicationId(application));
    }
}
