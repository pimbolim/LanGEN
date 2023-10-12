package com.stripe.android.payments.paymentlauncher;

import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.FraudDetectionDataRepository;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.Logger;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.StripeNetworkClient;
import com.stripe.android.networking.FraudDetectionDataParamsUtils;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u001b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherFactory;", "", "activity", "Landroidx/activity/ComponentActivity;", "callback", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher$PaymentResultCallback;", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher$PaymentResultCallback;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher$PaymentResultCallback;)V", "context", "Landroid/content/Context;", "hostActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;)V", "create", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "publishableKey", "", "stripeAccountId", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncherFactory.kt */
public final class PaymentLauncherFactory {
    public static final int $stable = 8;
    private final Context context;
    private final ActivityResultLauncher<PaymentLauncherContract.Args> hostActivityLauncher;

    public PaymentLauncherFactory(Context context2, ActivityResultLauncher<PaymentLauncherContract.Args> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(activityResultLauncher, "hostActivityLauncher");
        this.context = context2;
        this.hostActivityLauncher = activityResultLauncher;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentLauncherFactory(androidx.activity.ComponentActivity r4, com.stripe.android.payments.paymentlauncher.PaymentLauncher.PaymentResultCallback r5) {
        /*
            r3 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r0 = r4.getApplicationContext()
            java.lang.String r1 = "activity.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.stripe.android.payments.paymentlauncher.PaymentLauncherContract r1 = new com.stripe.android.payments.paymentlauncher.PaymentLauncherContract
            r1.<init>()
            androidx.activity.result.contract.ActivityResultContract r1 = (androidx.activity.result.contract.ActivityResultContract) r1
            com.stripe.android.payments.paymentlauncher.-$$Lambda$qtlbHABW5zjG71A9eAj2zkk8lv8 r2 = new com.stripe.android.payments.paymentlauncher.-$$Lambda$qtlbHABW5zjG71A9eAj2zkk8lv8
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r4 = r4.registerForActivityResult(r1, r2)
            java.lang.String r5 = "activity.registerForActi…nPaymentResult,\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r3.<init>((android.content.Context) r0, (androidx.activity.result.ActivityResultLauncher<com.stripe.android.payments.paymentlauncher.PaymentLauncherContract.Args>) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.paymentlauncher.PaymentLauncherFactory.<init>(androidx.activity.ComponentActivity, com.stripe.android.payments.paymentlauncher.PaymentLauncher$PaymentResultCallback):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentLauncherFactory(androidx.fragment.app.Fragment r4, com.stripe.android.payments.paymentlauncher.PaymentLauncher.PaymentResultCallback r5) {
        /*
            r3 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.fragment.app.FragmentActivity r0 = r4.requireActivity()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "fragment.requireActivity().applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.stripe.android.payments.paymentlauncher.PaymentLauncherContract r1 = new com.stripe.android.payments.paymentlauncher.PaymentLauncherContract
            r1.<init>()
            androidx.activity.result.contract.ActivityResultContract r1 = (androidx.activity.result.contract.ActivityResultContract) r1
            com.stripe.android.payments.paymentlauncher.-$$Lambda$qtlbHABW5zjG71A9eAj2zkk8lv8 r2 = new com.stripe.android.payments.paymentlauncher.-$$Lambda$qtlbHABW5zjG71A9eAj2zkk8lv8
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r4 = r4.registerForActivityResult(r1, r2)
            java.lang.String r5 = "fragment.registerForActi…onPaymentResult\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r3.<init>((android.content.Context) r0, (androidx.activity.result.ActivityResultLauncher<com.stripe.android.payments.paymentlauncher.PaymentLauncherContract.Args>) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.paymentlauncher.PaymentLauncherFactory.<init>(androidx.fragment.app.Fragment, com.stripe.android.payments.paymentlauncher.PaymentLauncher$PaymentResultCallback):void");
    }

    public static /* synthetic */ PaymentLauncher create$default(PaymentLauncherFactory paymentLauncherFactory, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return paymentLauncherFactory.create(str, str2);
    }

    public final PaymentLauncher create(String str, String str2) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "publishableKey");
        Set of = SetsKt.setOf("PaymentLauncher");
        PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory = r12;
        PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2 = new PaymentAnalyticsRequestFactory(this.context, (Function0<String>) new PaymentLauncherFactory$create$analyticsRequestFactory$1(str3), (Set<String>) of);
        return new StripePaymentLauncher(new PaymentLauncherFactory$create$1(str3), new PaymentLauncherFactory$create$2(str2), this.hostActivityLauncher, this.context, false, Dispatchers.getIO(), Dispatchers.getMain(), new StripeApiRepository(this.context, new PaymentLauncherFactory$create$3(str3), (AppInfo) null, (Logger) null, (CoroutineContext) null, (Set) null, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, paymentAnalyticsRequestFactory, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 15868, (DefaultConstructorMarker) null), paymentAnalyticsRequestFactory2, of);
    }
}
