package com.stripe.android.connections.di;

import android.app.Application;
import com.stripe.android.connections.ConnectionsSheet;
import com.stripe.android.connections.ConnectionsSheetContract;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/connections/di/ConnectionsSheetConfigurationModule;", "", "()V", "providesApplicationId", "", "application", "Landroid/app/Application;", "providesConfiguration", "Lcom/stripe/android/connections/ConnectionsSheet$Configuration;", "args", "Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "providesEnableLogging", "", "providesPublishableKey", "configuration", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: ConnectionsSheetConfigurationModule.kt */
public final class ConnectionsSheetConfigurationModule {
    public static final ConnectionsSheetConfigurationModule INSTANCE = new ConnectionsSheetConfigurationModule();

    @Singleton
    @Provides
    @Named("enableLogging")
    public final boolean providesEnableLogging() {
        return false;
    }

    private ConnectionsSheetConfigurationModule() {
    }

    @Singleton
    @Provides
    public final ConnectionsSheet.Configuration providesConfiguration(ConnectionsSheetContract.Args args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return args.getConfiguration();
    }

    @Singleton
    @Provides
    @Named("publishableKey")
    public final String providesPublishableKey(ConnectionsSheet.Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return configuration.getPublishableKey();
    }

    @Singleton
    @Provides
    @Named("applicationId")
    public final String providesApplicationId(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        String packageName = application.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "application.packageName");
        return packageName;
    }
}
