package com.stripe.android.googlepaylauncher.injection;

import android.content.Context;
import com.stripe.android.GooglePayJsonFactory;
import com.stripe.android.core.Logger;
import com.stripe.android.googlepaylauncher.DefaultGooglePayRepository;
import com.stripe.android.googlepaylauncher.GooglePayEnvironment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/stripe/android/googlepaylauncher/DefaultGooglePayRepository;", "environment", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayLauncherModule.kt */
final class GooglePayLauncherModule$provideGooglePayRepositoryFactory$1 extends Lambda implements Function1<GooglePayEnvironment, DefaultGooglePayRepository> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Logger $logger;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayLauncherModule$provideGooglePayRepositoryFactory$1(Context context, Logger logger) {
        super(1);
        this.$appContext = context;
        this.$logger = logger;
    }

    public final DefaultGooglePayRepository invoke(GooglePayEnvironment googlePayEnvironment) {
        Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
        return new DefaultGooglePayRepository(this.$appContext, googlePayEnvironment, new GooglePayJsonFactory.BillingAddressParameters(false, (GooglePayJsonFactory.BillingAddressParameters.Format) null, false, 7, (DefaultConstructorMarker) null), true, this.$logger);
    }
}
