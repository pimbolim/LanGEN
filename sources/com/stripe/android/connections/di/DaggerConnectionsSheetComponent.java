package com.stripe.android.connections.di;

import android.app.Application;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.connections.ConnectionsSheet;
import com.stripe.android.connections.ConnectionsSheetContract;
import com.stripe.android.connections.ConnectionsSheetViewModel;
import com.stripe.android.connections.analytics.ConnectionsEventReporter;
import com.stripe.android.connections.analytics.DefaultConnectionsEventReporter;
import com.stripe.android.connections.analytics.DefaultConnectionsEventReporter_Factory;
import com.stripe.android.connections.di.ConnectionsSheetComponent;
import com.stripe.android.connections.domain.FetchLinkAccountSession;
import com.stripe.android.connections.domain.GenerateLinkAccountSessionManifest;
import com.stripe.android.connections.repository.ConnectionsApiRepository;
import com.stripe.android.connections.repository.ConnectionsApiRepository_Factory;
import com.stripe.android.connections.repository.ConnectionsRepository;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideWorkContextFactory;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.AnalyticsRequestFactory;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor_Factory;
import com.stripe.android.core.networking.StripeNetworkClient;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class DaggerConnectionsSheetComponent implements ConnectionsSheetComponent {
    private Provider<Application> applicationProvider;
    private final ConnectionsSheetContract.Args configuration;
    private Provider<ConnectionsSheetContract.Args> configurationProvider;
    private Provider<ConnectionsApiRepository> connectionsApiRepositoryProvider;
    private final DaggerConnectionsSheetComponent connectionsSheetComponent;
    private Provider<DefaultAnalyticsRequestExecutor> defaultAnalyticsRequestExecutorProvider;
    private Provider<DefaultConnectionsEventReporter> defaultConnectionsEventReporterProvider;
    private Provider<AnalyticsRequestFactory> provideAnalyticsRequestFactory$connections_releaseProvider;
    private Provider<ConnectionsRepository> provideConnectionsRepositoryProvider;
    private Provider<ConnectionsEventReporter> provideEventReporterProvider;
    private Provider<Logger> provideLoggerProvider;
    private Provider<StripeNetworkClient> provideStripeNetworkClientProvider;
    private Provider<CoroutineContext> provideWorkContextProvider;
    private Provider<AnalyticsRequestExecutor> providesAnalyticsRequestExecutor$connections_releaseProvider;
    private Provider<ApiRequest.Factory> providesApiRequestFactoryProvider;
    private Provider<String> providesApplicationIdProvider;
    private Provider<ConnectionsSheet.Configuration> providesConfigurationProvider;
    private Provider<Boolean> providesEnableLoggingProvider;
    private Provider<String> providesPublishableKeyProvider;
    private final SavedStateHandle savedStateHandle;

    public void inject(ConnectionsSheetViewModel.Factory factory) {
    }

    private DaggerConnectionsSheetComponent(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Application application, SavedStateHandle savedStateHandle2, ConnectionsSheetContract.Args args) {
        this.connectionsSheetComponent = this;
        this.configuration = args;
        this.savedStateHandle = savedStateHandle2;
        initialize(coroutineContextModule, loggingModule, application, savedStateHandle2, args);
    }

    public static ConnectionsSheetComponent.Builder builder() {
        return new Builder();
    }

    private GenerateLinkAccountSessionManifest generateLinkAccountSessionManifest() {
        return new GenerateLinkAccountSessionManifest(this.provideConnectionsRepositoryProvider.get());
    }

    private FetchLinkAccountSession fetchLinkAccountSession() {
        return new FetchLinkAccountSession(this.provideConnectionsRepositoryProvider.get());
    }

    private void initialize(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Application application, SavedStateHandle savedStateHandle2, ConnectionsSheetContract.Args args) {
        Factory create = InstanceFactory.create(application);
        this.applicationProvider = create;
        this.providesApplicationIdProvider = DoubleCheck.provider(ConnectionsSheetConfigurationModule_ProvidesApplicationIdFactory.create(create));
        Factory create2 = InstanceFactory.create(args);
        this.configurationProvider = create2;
        Provider<ConnectionsSheet.Configuration> provider = DoubleCheck.provider(ConnectionsSheetConfigurationModule_ProvidesConfigurationFactory.create(create2));
        this.providesConfigurationProvider = provider;
        this.providesPublishableKeyProvider = DoubleCheck.provider(ConnectionsSheetConfigurationModule_ProvidesPublishableKeyFactory.create(provider));
        this.provideWorkContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        Provider<Boolean> provider2 = DoubleCheck.provider(ConnectionsSheetConfigurationModule_ProvidesEnableLoggingFactory.create());
        this.providesEnableLoggingProvider = provider2;
        Provider<Logger> provider3 = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, provider2));
        this.provideLoggerProvider = provider3;
        this.provideStripeNetworkClientProvider = DoubleCheck.provider(ConnectionsSheetModule_ProvideStripeNetworkClientFactory.create(this.provideWorkContextProvider, provider3));
        Provider<ApiRequest.Factory> provider4 = DoubleCheck.provider(ConnectionsSheetModule_ProvidesApiRequestFactoryFactory.create());
        this.providesApiRequestFactoryProvider = provider4;
        ConnectionsApiRepository_Factory create3 = ConnectionsApiRepository_Factory.create(this.providesPublishableKeyProvider, this.provideStripeNetworkClientProvider, provider4);
        this.connectionsApiRepositoryProvider = create3;
        this.provideConnectionsRepositoryProvider = DoubleCheck.provider(ConnectionsSheetModule_ProvideConnectionsRepositoryFactory.create(create3));
        DefaultAnalyticsRequestExecutor_Factory create4 = DefaultAnalyticsRequestExecutor_Factory.create(this.provideLoggerProvider, this.provideWorkContextProvider);
        this.defaultAnalyticsRequestExecutorProvider = create4;
        this.providesAnalyticsRequestExecutor$connections_releaseProvider = DoubleCheck.provider(ConnectionsSheetModule_ProvidesAnalyticsRequestExecutor$connections_releaseFactory.create(create4));
        Provider<AnalyticsRequestFactory> provider5 = DoubleCheck.provider(ConnectionsSheetModule_ProvideAnalyticsRequestFactory$connections_releaseFactory.create(this.applicationProvider, this.providesPublishableKeyProvider));
        this.provideAnalyticsRequestFactory$connections_releaseProvider = provider5;
        DefaultConnectionsEventReporter_Factory create5 = DefaultConnectionsEventReporter_Factory.create(this.providesAnalyticsRequestExecutor$connections_releaseProvider, provider5, this.provideWorkContextProvider);
        this.defaultConnectionsEventReporterProvider = create5;
        this.provideEventReporterProvider = DoubleCheck.provider(ConnectionsSheetModule_ProvideEventReporterFactory.create(create5));
    }

    public ConnectionsSheetViewModel getViewModel() {
        return new ConnectionsSheetViewModel(this.providesApplicationIdProvider.get(), this.configuration, generateLinkAccountSessionManifest(), fetchLinkAccountSession(), this.savedStateHandle, this.provideEventReporterProvider.get());
    }

    private static final class Builder implements ConnectionsSheetComponent.Builder {
        private Application application;
        private ConnectionsSheetContract.Args configuration;
        private SavedStateHandle savedStateHandle;

        private Builder() {
        }

        public Builder application(Application application2) {
            this.application = (Application) Preconditions.checkNotNull(application2);
            return this;
        }

        public Builder savedStateHandle(SavedStateHandle savedStateHandle2) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(savedStateHandle2);
            return this;
        }

        public Builder configuration(ConnectionsSheetContract.Args args) {
            this.configuration = (ConnectionsSheetContract.Args) Preconditions.checkNotNull(args);
            return this;
        }

        public ConnectionsSheetComponent build() {
            Preconditions.checkBuilderRequirement(this.application, Application.class);
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            Preconditions.checkBuilderRequirement(this.configuration, ConnectionsSheetContract.Args.class);
            return new DaggerConnectionsSheetComponent(new CoroutineContextModule(), new LoggingModule(), this.application, this.savedStateHandle, this.configuration);
        }
    }
}
