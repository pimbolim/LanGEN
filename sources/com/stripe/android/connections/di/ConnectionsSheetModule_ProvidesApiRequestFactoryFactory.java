package com.stripe.android.connections.di;

import com.stripe.android.core.networking.ApiRequest;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ConnectionsSheetModule_ProvidesApiRequestFactoryFactory implements Factory<ApiRequest.Factory> {
    public ApiRequest.Factory get() {
        return providesApiRequestFactory();
    }

    public static ConnectionsSheetModule_ProvidesApiRequestFactoryFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ApiRequest.Factory providesApiRequestFactory() {
        return (ApiRequest.Factory) Preconditions.checkNotNullFromProvides(ConnectionsSheetModule.INSTANCE.providesApiRequestFactory());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ConnectionsSheetModule_ProvidesApiRequestFactoryFactory INSTANCE = new ConnectionsSheetModule_ProvidesApiRequestFactoryFactory();

        private InstanceHolder() {
        }
    }
}
