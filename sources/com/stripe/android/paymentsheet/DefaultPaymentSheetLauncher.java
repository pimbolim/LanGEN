package com.stripe.android.paymentsheet;

import android.app.Application;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.Injector;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.injection.WeakMapInjectorRegistry;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetContract;
import com.stripe.android.paymentsheet.PaymentSheetViewModel;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.paymentsheet.injection.DaggerPaymentSheetLauncherComponent;
import com.stripe.android.paymentsheet.injection.PaymentSheetLauncherComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nB\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\rB\u001b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0014\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u001a\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u00158\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/stripe/android/paymentsheet/DefaultPaymentSheetLauncher;", "Lcom/stripe/android/paymentsheet/PaymentSheetLauncher;", "Lcom/stripe/android/core/injection/Injector;", "activity", "Landroidx/activity/ComponentActivity;", "callback", "Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "(Landroidx/fragment/app/Fragment;Landroidx/activity/result/ActivityResultRegistry;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "application", "Landroid/app/Application;", "(Landroidx/activity/result/ActivityResultLauncher;Landroid/app/Application;)V", "injectorKey", "", "getInjectorKey$annotations", "()V", "paymentSheetLauncherComponent", "Lcom/stripe/android/paymentsheet/injection/PaymentSheetLauncherComponent;", "inject", "", "injectable", "Lcom/stripe/android/core/injection/Injectable;", "present", "args", "presentWithPaymentIntent", "paymentIntentClientSecret", "configuration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "presentWithSetupIntent", "setupIntentClientSecret", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultPaymentSheetLauncher.kt */
public final class DefaultPaymentSheetLauncher implements PaymentSheetLauncher, Injector {
    private final ActivityResultLauncher<PaymentSheetContract.Args> activityResultLauncher;
    private final String injectorKey;
    private final PaymentSheetLauncherComponent paymentSheetLauncherComponent;

    @InjectorKey
    private static /* synthetic */ void getInjectorKey$annotations() {
    }

    public DefaultPaymentSheetLauncher(ActivityResultLauncher<PaymentSheetContract.Args> activityResultLauncher2, Application application) {
        Intrinsics.checkNotNullParameter(activityResultLauncher2, "activityResultLauncher");
        Intrinsics.checkNotNullParameter(application, "application");
        this.activityResultLauncher = activityResultLauncher2;
        WeakMapInjectorRegistry weakMapInjectorRegistry = WeakMapInjectorRegistry.INSTANCE;
        String simpleName = Reflection.getOrCreateKotlinClass(PaymentSheetLauncher.class).getSimpleName();
        if (simpleName != null) {
            String nextKey = weakMapInjectorRegistry.nextKey(simpleName);
            this.injectorKey = nextKey;
            this.paymentSheetLauncherComponent = DaggerPaymentSheetLauncherComponent.builder().application(application).injectorKey(nextKey).build();
            WeakMapInjectorRegistry.INSTANCE.register(this, nextKey);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultPaymentSheetLauncher(androidx.activity.ComponentActivity r3, com.stripe.android.paymentsheet.PaymentSheetResultCallback r4) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.stripe.android.paymentsheet.PaymentSheetContract r0 = new com.stripe.android.paymentsheet.PaymentSheetContract
            r0.<init>()
            androidx.activity.result.contract.ActivityResultContract r0 = (androidx.activity.result.contract.ActivityResultContract) r0
            com.stripe.android.paymentsheet.-$$Lambda$DefaultPaymentSheetLauncher$BSl2RDO2Mxsy6Iv1Ie371eI8myQ r1 = new com.stripe.android.paymentsheet.-$$Lambda$DefaultPaymentSheetLauncher$BSl2RDO2Mxsy6Iv1Ie371eI8myQ
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r4 = r3.registerForActivityResult(r0, r1)
            java.lang.String r0 = "activity.registerForActi…SheetResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.app.Application r3 = r3.getApplication()
            java.lang.String r0 = "activity.application"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.<init>((androidx.activity.result.ActivityResultLauncher<com.stripe.android.paymentsheet.PaymentSheetContract.Args>) r4, (android.app.Application) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.DefaultPaymentSheetLauncher.<init>(androidx.activity.ComponentActivity, com.stripe.android.paymentsheet.PaymentSheetResultCallback):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4391_init_$lambda0(PaymentSheetResultCallback paymentSheetResultCallback, PaymentSheetResult paymentSheetResult) {
        Intrinsics.checkNotNullParameter(paymentSheetResultCallback, "$callback");
        Intrinsics.checkNotNullExpressionValue(paymentSheetResult, "it");
        paymentSheetResultCallback.onPaymentSheetResult(paymentSheetResult);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultPaymentSheetLauncher(androidx.fragment.app.Fragment r3, com.stripe.android.paymentsheet.PaymentSheetResultCallback r4) {
        /*
            r2 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.stripe.android.paymentsheet.PaymentSheetContract r0 = new com.stripe.android.paymentsheet.PaymentSheetContract
            r0.<init>()
            androidx.activity.result.contract.ActivityResultContract r0 = (androidx.activity.result.contract.ActivityResultContract) r0
            com.stripe.android.paymentsheet.-$$Lambda$DefaultPaymentSheetLauncher$UXJhxv8roxQCA-0Cph-kTvfBmhM r1 = new com.stripe.android.paymentsheet.-$$Lambda$DefaultPaymentSheetLauncher$UXJhxv8roxQCA-0Cph-kTvfBmhM
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r4 = r3.registerForActivityResult(r0, r1)
            java.lang.String r0 = "fragment.registerForActi…SheetResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            androidx.fragment.app.FragmentActivity r3 = r3.requireActivity()
            android.app.Application r3 = r3.getApplication()
            java.lang.String r0 = "fragment.requireActivity().application"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.<init>((androidx.activity.result.ActivityResultLauncher<com.stripe.android.paymentsheet.PaymentSheetContract.Args>) r4, (android.app.Application) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.DefaultPaymentSheetLauncher.<init>(androidx.fragment.app.Fragment, com.stripe.android.paymentsheet.PaymentSheetResultCallback):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4392_init_$lambda1(PaymentSheetResultCallback paymentSheetResultCallback, PaymentSheetResult paymentSheetResult) {
        Intrinsics.checkNotNullParameter(paymentSheetResultCallback, "$callback");
        Intrinsics.checkNotNullExpressionValue(paymentSheetResult, "it");
        paymentSheetResultCallback.onPaymentSheetResult(paymentSheetResult);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultPaymentSheetLauncher(androidx.fragment.app.Fragment r3, androidx.activity.result.ActivityResultRegistry r4, com.stripe.android.paymentsheet.PaymentSheetResultCallback r5) {
        /*
            r2 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "registry"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.stripe.android.paymentsheet.PaymentSheetContract r0 = new com.stripe.android.paymentsheet.PaymentSheetContract
            r0.<init>()
            androidx.activity.result.contract.ActivityResultContract r0 = (androidx.activity.result.contract.ActivityResultContract) r0
            com.stripe.android.paymentsheet.-$$Lambda$DefaultPaymentSheetLauncher$PAXnQj543jnIkta92nLPu_DY758 r1 = new com.stripe.android.paymentsheet.-$$Lambda$DefaultPaymentSheetLauncher$PAXnQj543jnIkta92nLPu_DY758
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r4 = r3.registerForActivityResult(r0, r4, r1)
            java.lang.String r5 = "fragment.registerForActi…SheetResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            androidx.fragment.app.FragmentActivity r3 = r3.requireActivity()
            android.app.Application r3 = r3.getApplication()
            java.lang.String r5 = "fragment.requireActivity().application"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            r2.<init>((androidx.activity.result.ActivityResultLauncher<com.stripe.android.paymentsheet.PaymentSheetContract.Args>) r4, (android.app.Application) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.DefaultPaymentSheetLauncher.<init>(androidx.fragment.app.Fragment, androidx.activity.result.ActivityResultRegistry, com.stripe.android.paymentsheet.PaymentSheetResultCallback):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m4393_init_$lambda2(PaymentSheetResultCallback paymentSheetResultCallback, PaymentSheetResult paymentSheetResult) {
        Intrinsics.checkNotNullParameter(paymentSheetResultCallback, "$callback");
        Intrinsics.checkNotNullExpressionValue(paymentSheetResult, "it");
        paymentSheetResultCallback.onPaymentSheetResult(paymentSheetResult);
    }

    public void presentWithPaymentIntent(String str, PaymentSheet.Configuration configuration) {
        Intrinsics.checkNotNullParameter(str, "paymentIntentClientSecret");
        present(PaymentSheetContract.Args.Companion.createPaymentIntentArgsWithInjectorKey$paymentsheet_release(str, configuration, this.injectorKey));
    }

    public void presentWithSetupIntent(String str, PaymentSheet.Configuration configuration) {
        Intrinsics.checkNotNullParameter(str, "setupIntentClientSecret");
        present(PaymentSheetContract.Args.Companion.createSetupIntentArgsWithInjectorKey$paymentsheet_release(str, configuration, this.injectorKey));
    }

    private final void present(PaymentSheetContract.Args args) {
        this.activityResultLauncher.launch(args);
    }

    public void inject(Injectable<?> injectable) {
        Intrinsics.checkNotNullParameter(injectable, "injectable");
        if (injectable instanceof PaymentSheetViewModel.Factory) {
            this.paymentSheetLauncherComponent.inject((PaymentSheetViewModel.Factory) injectable);
        } else if (injectable instanceof FormViewModel.Factory) {
            this.paymentSheetLauncherComponent.inject((FormViewModel.Factory) injectable);
        } else {
            throw new IllegalArgumentException("invalid Injectable " + injectable + " requested in " + this);
        }
    }
}
