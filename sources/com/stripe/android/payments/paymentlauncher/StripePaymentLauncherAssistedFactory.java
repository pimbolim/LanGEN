package com.stripe.android.payments.paymentlauncher;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@AssistedFactory
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/StripePaymentLauncherAssistedFactory;", "", "create", "Lcom/stripe/android/payments/paymentlauncher/StripePaymentLauncher;", "publishableKey", "Lkotlin/Function0;", "", "stripeAccountId", "hostActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripePaymentLauncherAssistedFactory.kt */
public interface StripePaymentLauncherAssistedFactory {
    StripePaymentLauncher create(@Assisted("publishableKey") Function0<String> function0, @Assisted("stripeAccountId") Function0<String> function02, ActivityResultLauncher<PaymentLauncherContract.Args> activityResultLauncher);
}
