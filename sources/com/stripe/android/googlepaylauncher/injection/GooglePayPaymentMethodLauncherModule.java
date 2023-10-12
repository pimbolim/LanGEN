package com.stripe.android.googlepaylauncher.injection;

import android.content.Context;
import com.google.android.gms.wallet.PaymentsClient;
import com.stripe.android.googlepaylauncher.DefaultGooglePayRepository;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayRepository;
import com.stripe.android.googlepaylauncher.PaymentsClientFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherModule;", "", "()V", "bindsGooglePayRepository", "Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "defaultGooglePayRepository", "Lcom/stripe/android/googlepaylauncher/DefaultGooglePayRepository;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(subcomponents = {GooglePayPaymentMethodLauncherViewModelSubcomponent.class})
/* compiled from: GooglePayPaymentMethodLauncherModule.kt */
public abstract class GooglePayPaymentMethodLauncherModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Singleton
    @Binds
    public abstract GooglePayRepository bindsGooglePayRepository(DefaultGooglePayRepository defaultGooglePayRepository);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherModule$Companion;", "", "()V", "providePaymentsClient", "Lcom/google/android/gms/wallet/PaymentsClient;", "context", "Landroid/content/Context;", "googlePayConfig", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "paymentsClientFactory", "Lcom/stripe/android/googlepaylauncher/PaymentsClientFactory;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncherModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Singleton
        @Provides
        public final PaymentsClient providePaymentsClient(Context context, GooglePayPaymentMethodLauncher.Config config, PaymentsClientFactory paymentsClientFactory) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "googlePayConfig");
            Intrinsics.checkNotNullParameter(paymentsClientFactory, "paymentsClientFactory");
            return paymentsClientFactory.create(config.getEnvironment());
        }
    }
}
