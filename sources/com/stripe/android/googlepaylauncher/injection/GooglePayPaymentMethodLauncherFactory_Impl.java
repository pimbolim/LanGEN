package com.stripe.android.googlepaylauncher.injection;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher_Factory;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

public final class GooglePayPaymentMethodLauncherFactory_Impl implements GooglePayPaymentMethodLauncherFactory {
    private final GooglePayPaymentMethodLauncher_Factory delegateFactory;

    GooglePayPaymentMethodLauncherFactory_Impl(GooglePayPaymentMethodLauncher_Factory googlePayPaymentMethodLauncher_Factory) {
        this.delegateFactory = googlePayPaymentMethodLauncher_Factory;
    }

    public GooglePayPaymentMethodLauncher create(CoroutineScope coroutineScope, GooglePayPaymentMethodLauncher.Config config, GooglePayPaymentMethodLauncher.ReadyCallback readyCallback, ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> activityResultLauncher, boolean z) {
        return this.delegateFactory.get(coroutineScope, config, readyCallback, activityResultLauncher, z);
    }

    public static Provider<GooglePayPaymentMethodLauncherFactory> create(GooglePayPaymentMethodLauncher_Factory googlePayPaymentMethodLauncher_Factory) {
        return InstanceFactory.create(new GooglePayPaymentMethodLauncherFactory_Impl(googlePayPaymentMethodLauncher_Factory));
    }
}
