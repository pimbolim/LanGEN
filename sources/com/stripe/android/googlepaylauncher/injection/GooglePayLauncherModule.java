package com.stripe.android.googlepaylauncher.injection;

import android.content.Context;
import com.stripe.android.core.Logger;
import com.stripe.android.googlepaylauncher.GooglePayEnvironment;
import com.stripe.android.googlepaylauncher.GooglePayRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/googlepaylauncher/injection/GooglePayLauncherModule;", "", "()V", "provideGooglePayRepositoryFactory", "Lkotlin/Function1;", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "appContext", "Landroid/content/Context;", "logger", "Lcom/stripe/android/core/Logger;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: GooglePayLauncherModule.kt */
public final class GooglePayLauncherModule {
    public static final int $stable = 0;

    @Singleton
    @Provides
    public final Function1<GooglePayEnvironment, GooglePayRepository> provideGooglePayRepositoryFactory(Context context, Logger logger) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return new GooglePayLauncherModule$provideGooglePayRepositoryFactory$1(context, logger);
    }
}
