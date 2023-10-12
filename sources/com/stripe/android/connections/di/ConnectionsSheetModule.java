package com.stripe.android.connections.di;

import android.app.Application;
import android.content.pm.PackageManager;
import androidx.core.os.LocaleListCompat;
import com.stripe.android.connections.analytics.ConnectionsEventReporter;
import com.stripe.android.connections.analytics.DefaultConnectionsEventReporter;
import com.stripe.android.connections.repository.ConnectionsApiRepository;
import com.stripe.android.connections.repository.ConnectionsRepository;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.AnalyticsRequestFactory;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.ConnectionFactory;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultStripeNetworkClient;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.core.networking.StripeNetworkClient;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u001a\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020 H\u0007¨\u0006!"}, d2 = {"Lcom/stripe/android/connections/di/ConnectionsSheetModule;", "", "()V", "provideAnalyticsRequestFactory", "Lcom/stripe/android/core/networking/AnalyticsRequestFactory;", "application", "Landroid/app/Application;", "publishableKey", "", "provideAnalyticsRequestFactory$connections_release", "provideConnectionsRepository", "Lcom/stripe/android/connections/repository/ConnectionsRepository;", "repository", "Lcom/stripe/android/connections/repository/ConnectionsApiRepository;", "provideEventReporter", "Lcom/stripe/android/connections/analytics/ConnectionsEventReporter;", "defaultConnectionsEventReporter", "Lcom/stripe/android/connections/analytics/DefaultConnectionsEventReporter;", "provideLocale", "Ljava/util/Locale;", "provideStripeNetworkClient", "Lcom/stripe/android/core/networking/StripeNetworkClient;", "context", "Lkotlin/coroutines/CoroutineContext;", "logger", "Lcom/stripe/android/core/Logger;", "providesAnalyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "executor", "Lcom/stripe/android/core/networking/DefaultAnalyticsRequestExecutor;", "providesAnalyticsRequestExecutor$connections_release", "providesApiRequestFactory", "Lcom/stripe/android/core/networking/ApiRequest$Factory;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {ConnectionsSheetConfigurationModule.class})
/* compiled from: ConnectionsSheetModule.kt */
public final class ConnectionsSheetModule {
    public static final ConnectionsSheetModule INSTANCE = new ConnectionsSheetModule();

    /* access modifiers changed from: private */
    /* renamed from: provideAnalyticsRequestFactory$lambda-1  reason: not valid java name */
    public static final String m4288provideAnalyticsRequestFactory$lambda1(String str) {
        Intrinsics.checkNotNullParameter(str, "$publishableKey");
        return str;
    }

    private ConnectionsSheetModule() {
    }

    @Singleton
    @Provides
    public final StripeNetworkClient provideStripeNetworkClient(@IOContext CoroutineContext coroutineContext, Logger logger) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return new DefaultStripeNetworkClient(coroutineContext, (ConnectionFactory) null, (RetryDelaySupplier) null, 0, logger, 14, (DefaultConstructorMarker) null);
    }

    @Singleton
    @Provides
    public final ApiRequest.Factory providesApiRequestFactory() {
        return new ApiRequest.Factory((AppInfo) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    @Singleton
    @Provides
    public final ConnectionsRepository provideConnectionsRepository(ConnectionsApiRepository connectionsApiRepository) {
        Intrinsics.checkNotNullParameter(connectionsApiRepository, "repository");
        return connectionsApiRepository;
    }

    @Singleton
    @Provides
    public final Locale provideLocale() {
        LocaleListCompat adjustedDefault = LocaleListCompat.getAdjustedDefault();
        if (adjustedDefault.isEmpty()) {
            adjustedDefault = null;
        }
        if (adjustedDefault == null) {
            return null;
        }
        return adjustedDefault.get(0);
    }

    @Singleton
    @Provides
    public final ConnectionsEventReporter provideEventReporter(DefaultConnectionsEventReporter defaultConnectionsEventReporter) {
        Intrinsics.checkNotNullParameter(defaultConnectionsEventReporter, "defaultConnectionsEventReporter");
        return defaultConnectionsEventReporter;
    }

    @Singleton
    @Provides
    public final AnalyticsRequestExecutor providesAnalyticsRequestExecutor$connections_release(DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor) {
        Intrinsics.checkNotNullParameter(defaultAnalyticsRequestExecutor, "executor");
        return defaultAnalyticsRequestExecutor;
    }

    @Singleton
    @Provides
    public final AnalyticsRequestFactory provideAnalyticsRequestFactory$connections_release(Application application, @Named("publishableKey") String str) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        PackageManager packageManager = application.getPackageManager();
        String packageName = application.getPackageName();
        if (packageName == null) {
            packageName = "";
        }
        return new AnalyticsRequestFactory(packageManager, application.getPackageManager().getPackageInfo(application.getPackageName(), 0), packageName, new Provider(str) {
            public final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Object get() {
                return ConnectionsSheetModule.m4288provideAnalyticsRequestFactory$lambda1(this.f$0);
            }
        }, (Set) null, 16, (DefaultConstructorMarker) null);
    }
}
