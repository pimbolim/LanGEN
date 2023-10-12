package com.stripe.android.payments.core;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import com.stripe.android.payments.PaymentFlowResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, d2 = {"Lcom/stripe/android/payments/core/ActivityResultLauncherHost;", "", "onLauncherInvalidated", "", "onNewActivityResultCaller", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "activityResultCallback", "Landroidx/activity/result/ActivityResultCallback;", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityResultLauncherHost.kt */
public interface ActivityResultLauncherHost {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActivityResultLauncherHost.kt */
    public static final class DefaultImpls {
        public static void onLauncherInvalidated(ActivityResultLauncherHost activityResultLauncherHost) {
            Intrinsics.checkNotNullParameter(activityResultLauncherHost, "this");
        }

        public static void onNewActivityResultCaller(ActivityResultLauncherHost activityResultLauncherHost, ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
            Intrinsics.checkNotNullParameter(activityResultLauncherHost, "this");
            Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
            Intrinsics.checkNotNullParameter(activityResultCallback, "activityResultCallback");
        }
    }

    void onLauncherInvalidated();

    void onNewActivityResultCaller(ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback);
}
