package com.stripe.android.payments.core.authentication;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.ActivityResultLauncherHost;
import com.stripe.android.view.AuthActivityStarterHost;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Authenticatable", "Lcom/stripe/android/payments/core/ActivityResultLauncherHost;", "authenticate", "", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "authenticatable", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Ljava/lang/Object;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthenticator.kt */
public interface PaymentAuthenticator<Authenticatable> extends ActivityResultLauncherHost {
    Object authenticate(AuthActivityStarterHost authActivityStarterHost, Authenticatable authenticatable, ApiRequest.Options options, Continuation<? super Unit> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthenticator.kt */
    public static final class DefaultImpls {
        public static <Authenticatable> void onLauncherInvalidated(PaymentAuthenticator<Authenticatable> paymentAuthenticator) {
            Intrinsics.checkNotNullParameter(paymentAuthenticator, "this");
            ActivityResultLauncherHost.DefaultImpls.onLauncherInvalidated(paymentAuthenticator);
        }

        public static <Authenticatable> void onNewActivityResultCaller(PaymentAuthenticator<Authenticatable> paymentAuthenticator, ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
            Intrinsics.checkNotNullParameter(paymentAuthenticator, "this");
            Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
            Intrinsics.checkNotNullParameter(activityResultCallback, "activityResultCallback");
            ActivityResultLauncherHost.DefaultImpls.onNewActivityResultCaller(paymentAuthenticator, activityResultCaller, activityResultCallback);
        }
    }
}
