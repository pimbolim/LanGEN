package com.stripe.android.payments.core.authentication;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.ActivityResultLauncherHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0004H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/payments/core/authentication/PaymentAuthenticatorRegistry;", "Lcom/stripe/android/payments/core/ActivityResultLauncherHost;", "getAuthenticator", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Authenticatable", "authenticatable", "(Ljava/lang/Object;)Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthenticatorRegistry.kt */
public interface PaymentAuthenticatorRegistry extends ActivityResultLauncherHost {
    <Authenticatable> PaymentAuthenticator<Authenticatable> getAuthenticator(Authenticatable authenticatable);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthenticatorRegistry.kt */
    public static final class DefaultImpls {
        public static void onLauncherInvalidated(PaymentAuthenticatorRegistry paymentAuthenticatorRegistry) {
            Intrinsics.checkNotNullParameter(paymentAuthenticatorRegistry, "this");
            ActivityResultLauncherHost.DefaultImpls.onLauncherInvalidated(paymentAuthenticatorRegistry);
        }

        public static void onNewActivityResultCaller(PaymentAuthenticatorRegistry paymentAuthenticatorRegistry, ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
            Intrinsics.checkNotNullParameter(paymentAuthenticatorRegistry, "this");
            Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
            Intrinsics.checkNotNullParameter(activityResultCallback, "activityResultCallback");
            ActivityResultLauncherHost.DefaultImpls.onNewActivityResultCaller(paymentAuthenticatorRegistry, activityResultCaller, activityResultCallback);
        }
    }
}
