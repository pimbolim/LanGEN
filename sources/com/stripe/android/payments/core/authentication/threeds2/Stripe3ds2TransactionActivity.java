package com.stripe.android.payments.core.authentication.threeds2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.databinding.Stripe3ds2TransactionLayoutBinding;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "args", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "getArgs", "()Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "setArgs", "(Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;)V", "viewBinding", "Lcom/stripe/android/databinding/Stripe3ds2TransactionLayoutBinding;", "getViewBinding", "()Lcom/stripe/android/databinding/Stripe3ds2TransactionLayoutBinding;", "viewBinding$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$payments_core_release$annotations", "getViewModelFactory$payments_core_release", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$payments_core_release", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "finishWithResult", "", "paymentFlowResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2TransactionActivity.kt */
public final class Stripe3ds2TransactionActivity extends AppCompatActivity {
    public Stripe3ds2TransactionContract.Args args;
    private final Lazy viewBinding$delegate = LazyKt.lazy(new Stripe3ds2TransactionActivity$viewBinding$2(this));
    private ViewModelProvider.Factory viewModelFactory = new Stripe3ds2TransactionViewModelFactory(new Stripe3ds2TransactionActivity$viewModelFactory$1(this), this, new Stripe3ds2TransactionActivity$viewModelFactory$2(this));

    public static /* synthetic */ void getViewModelFactory$payments_core_release$annotations() {
    }

    private final Stripe3ds2TransactionLayoutBinding getViewBinding() {
        return (Stripe3ds2TransactionLayoutBinding) this.viewBinding$delegate.getValue();
    }

    public final Stripe3ds2TransactionContract.Args getArgs() {
        Stripe3ds2TransactionContract.Args args2 = this.args;
        if (args2 != null) {
            return args2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("args");
        return null;
    }

    public final void setArgs(Stripe3ds2TransactionContract.Args args2) {
        Intrinsics.checkNotNullParameter(args2, "<set-?>");
        this.args = args2;
    }

    public final ViewModelProvider.Factory getViewModelFactory$payments_core_release() {
        return this.viewModelFactory;
    }

    public final void setViewModelFactory$payments_core_release(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0079 }
            r0 = r11
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity r0 = (com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity) r0     // Catch:{ all -> 0x0079 }
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args$Companion r1 = com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract.Args.Companion     // Catch:{ all -> 0x0079 }
            android.content.Intent r2 = r0.getIntent()     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0079 }
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args r1 = r1.fromIntent(r2)     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x006d
            com.stripe.android.PaymentAuthConfig$Stripe3ds2Config r2 = r1.getConfig()     // Catch:{ all -> 0x0079 }
            com.stripe.android.PaymentAuthConfig$Stripe3ds2UiCustomization r2 = r2.getUiCustomization$payments_core_release()     // Catch:{ all -> 0x0079 }
            com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization r2 = r2.getUiCustomization()     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = r2.getAccentColor()     // Catch:{ all -> 0x0079 }
            r3 = 0
            if (r2 != 0) goto L_0x002a
            goto L_0x004e
        L_0x002a:
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0039 }
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ all -> 0x0039 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0039 }
            java.lang.Object r2 = kotlin.Result.m4709constructorimpl(r2)     // Catch:{ all -> 0x0039 }
            goto L_0x0044
        L_0x0039:
            r2 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0079 }
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)     // Catch:{ all -> 0x0079 }
            java.lang.Object r2 = kotlin.Result.m4709constructorimpl(r2)     // Catch:{ all -> 0x0079 }
        L_0x0044:
            boolean r4 = kotlin.Result.m4715isFailureimpl(r2)     // Catch:{ all -> 0x0079 }
            if (r4 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r3 = r2
        L_0x004c:
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0079 }
        L_0x004e:
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()     // Catch:{ all -> 0x0079 }
            com.stripe.android.stripe3ds2.views.ChallengeProgressFragmentFactory r2 = new com.stripe.android.stripe3ds2.views.ChallengeProgressFragmentFactory     // Catch:{ all -> 0x0079 }
            com.stripe.android.model.Stripe3ds2Fingerprint r4 = r1.getFingerprint()     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = r4.getDirectoryServerName()     // Catch:{ all -> 0x0079 }
            com.stripe.android.stripe3ds2.transaction.SdkTransactionId r5 = r1.getSdkTransactionId()     // Catch:{ all -> 0x0079 }
            r2.<init>(r4, r5, r3)     // Catch:{ all -> 0x0079 }
            androidx.fragment.app.FragmentFactory r2 = (androidx.fragment.app.FragmentFactory) r2     // Catch:{ all -> 0x0079 }
            r0.setFragmentFactory(r2)     // Catch:{ all -> 0x0079 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r1)     // Catch:{ all -> 0x0079 }
            goto L_0x0084
        L_0x006d:
            java.lang.String r0 = "Error while attempting to initiate 3DS2 transaction."
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0079 }
            r1.<init>(r0)     // Catch:{ all -> 0x0079 }
            throw r1     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0084:
            super.onCreate(r12)
            java.lang.Throwable r12 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            if (r12 != 0) goto L_0x0127
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args r0 = (com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract.Args) r0
            r11.setArgs(r0)
            com.stripe.android.databinding.Stripe3ds2TransactionLayoutBinding r12 = r11.getViewBinding()
            androidx.fragment.app.FragmentContainerView r12 = r12.getRoot()
            android.view.View r12 = (android.view.View) r12
            r11.setContentView((android.view.View) r12)
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args r12 = r11.getArgs()
            java.lang.Integer r12 = r12.getStatusBarColor()
            if (r12 != 0) goto L_0x00aa
            goto L_0x00b7
        L_0x00aa:
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            android.view.Window r0 = r11.getWindow()
            r0.setStatusBarColor(r12)
        L_0x00b7:
            r12 = r11
            androidx.activity.ComponentActivity r12 = (androidx.activity.ComponentActivity) r12
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$viewModel$2 r0 = new com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$viewModel$2
            r0.<init>(r11)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.lifecycle.ViewModelLazy r1 = new androidx.lifecycle.ViewModelLazy
            java.lang.Class<com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel> r2 = com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$$inlined$viewModels$2 r3 = new com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$$inlined$viewModels$2
            r3.<init>(r12)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r1.<init>(r2, r3, r0)
            r9 = r1
            kotlin.Lazy r9 = (kotlin.Lazy) r9
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$onChallengeResult$1 r12 = new com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$onChallengeResult$1
            r12.<init>(r11, r9)
            r7 = r12
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            com.stripe.android.stripe3ds2.transaction.ChallengeContract r12 = new com.stripe.android.stripe3ds2.transaction.ChallengeContract
            r12.<init>()
            androidx.activity.result.contract.ActivityResultContract r12 = (androidx.activity.result.contract.ActivityResultContract) r12
            com.stripe.android.payments.core.authentication.threeds2.-$$Lambda$Stripe3ds2TransactionActivity$tH8u6ZUzrqJ3Epfy1kyXBD2UJGM r0 = new com.stripe.android.payments.core.authentication.threeds2.-$$Lambda$Stripe3ds2TransactionActivity$tH8u6ZUzrqJ3Epfy1kyXBD2UJGM
            r0.<init>()
            androidx.activity.result.ActivityResultLauncher r6 = r11.registerForActivityResult(r12, r0)
            java.lang.String r12 = "registerForActivityResul…lengeResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r12)
            com.stripe.android.auth.PaymentBrowserAuthContract r12 = new com.stripe.android.auth.PaymentBrowserAuthContract
            r12.<init>()
            androidx.activity.result.contract.ActivityResultContract r12 = (androidx.activity.result.contract.ActivityResultContract) r12
            com.stripe.android.payments.core.authentication.threeds2.-$$Lambda$Stripe3ds2TransactionActivity$QJzIdiRr1PNVQK6f8RnSVvBnTLg r0 = new com.stripe.android.payments.core.authentication.threeds2.-$$Lambda$Stripe3ds2TransactionActivity$QJzIdiRr1PNVQK6f8RnSVvBnTLg
            r0.<init>()
            androidx.activity.result.ActivityResultLauncher r8 = r11.registerForActivityResult(r12, r0)
            java.lang.String r12 = "registerForActivityResul…hWithResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r12)
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel r12 = m4380onCreate$lambda6(r9)
            boolean r12 = r12.getHasCompleted()
            if (r12 != 0) goto L_0x0126
            r12 = r11
            androidx.lifecycle.LifecycleOwner r12 = (androidx.lifecycle.LifecycleOwner) r12
            androidx.lifecycle.LifecycleCoroutineScope r12 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r12)
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$3 r0 = new com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$3
            r10 = 0
            r4 = r0
            r5 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.launchWhenResumed(r0)
        L_0x0126:
            return
        L_0x0127:
            com.stripe.android.payments.PaymentFlowResult$Unvalidated r0 = new com.stripe.android.payments.PaymentFlowResult$Unvalidated
            r2 = 0
            r3 = 2
            com.stripe.android.core.exception.StripeException$Companion r1 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r1.create(r12)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 121(0x79, float:1.7E-43)
            r10 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.finishWithResult(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-6  reason: not valid java name */
    public static final Stripe3ds2TransactionViewModel m4380onCreate$lambda6(Lazy<Stripe3ds2TransactionViewModel> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-7  reason: not valid java name */
    public static final void m4381onCreate$lambda7(Function1 function1, ChallengeResult challengeResult) {
        Intrinsics.checkNotNullParameter(function1, "$onChallengeResult");
        Intrinsics.checkNotNullExpressionValue(challengeResult, "it");
        function1.invoke(challengeResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-8  reason: not valid java name */
    public static final void m4382onCreate$lambda8(Stripe3ds2TransactionActivity stripe3ds2TransactionActivity, PaymentFlowResult.Unvalidated unvalidated) {
        Intrinsics.checkNotNullParameter(stripe3ds2TransactionActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(unvalidated, "it");
        stripe3ds2TransactionActivity.finishWithResult(unvalidated);
    }

    /* access modifiers changed from: private */
    public final void finishWithResult(PaymentFlowResult.Unvalidated unvalidated) {
        setResult(-1, new Intent().putExtras(unvalidated.toBundle()));
        finish();
    }
}
