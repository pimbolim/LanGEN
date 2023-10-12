package com.stripe.android.googlepaylauncher.injection;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import dagger.assisted.AssistedFactory;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@AssistedFactory
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherFactory;", "", "create", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "config", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "readyCallback", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ReadyCallback;", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "skipReadyCheck", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncherFactory.kt */
public interface GooglePayPaymentMethodLauncherFactory {
    GooglePayPaymentMethodLauncher create(CoroutineScope coroutineScope, GooglePayPaymentMethodLauncher.Config config, GooglePayPaymentMethodLauncher.ReadyCallback readyCallback, ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> activityResultLauncher, boolean z);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncherFactory.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ GooglePayPaymentMethodLauncher create$default(GooglePayPaymentMethodLauncherFactory googlePayPaymentMethodLauncherFactory, CoroutineScope coroutineScope, GooglePayPaymentMethodLauncher.Config config, GooglePayPaymentMethodLauncher.ReadyCallback readyCallback, ActivityResultLauncher activityResultLauncher, boolean z, int i, Object obj) {
            if (obj == null) {
                return googlePayPaymentMethodLauncherFactory.create(coroutineScope, config, readyCallback, activityResultLauncher, (i & 16) != 0 ? false : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }
    }
}
