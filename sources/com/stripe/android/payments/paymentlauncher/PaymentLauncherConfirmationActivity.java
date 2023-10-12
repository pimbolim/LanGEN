package com.stripe.android.payments.paymentlauncher;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.view.AuthActivityStarterHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0015J\b\u0010\u001f\u001a\u00020\u0017H\u0014R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R!\u0010\t\u001a\u00020\n8@X\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherConfirmationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "starterArgs", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "getStarterArgs", "()Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "starterArgs$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel;", "getViewModel$payments_core_release$annotations", "getViewModel$payments_core_release", "()Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel;", "viewModel$delegate", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$payments_core_release$annotations", "getViewModelFactory$payments_core_release", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$payments_core_release", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "disableAnimations", "", "finish", "finishWithResult", "result", "Lcom/stripe/android/payments/paymentlauncher/PaymentResult;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncherConfirmationActivity.kt */
public final class PaymentLauncherConfirmationActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EMPTY_ARG_ERROR = "PaymentLauncherConfirmationActivity was started without arguments";
    private final Lazy starterArgs$delegate = LazyKt.lazy(new PaymentLauncherConfirmationActivity$starterArgs$2(this));
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PaymentLauncherViewModel.class), new PaymentLauncherConfirmationActivity$special$$inlined$viewModels$2(this), new PaymentLauncherConfirmationActivity$viewModel$2(this));
    private ViewModelProvider.Factory viewModelFactory = new PaymentLauncherViewModel.Factory(new PaymentLauncherConfirmationActivity$viewModelFactory$1(this), new PaymentLauncherConfirmationActivity$viewModelFactory$2(this), this);

    public static /* synthetic */ void getViewModel$payments_core_release$annotations() {
    }

    public static /* synthetic */ void getViewModelFactory$payments_core_release$annotations() {
    }

    /* access modifiers changed from: private */
    public final PaymentLauncherContract.Args getStarterArgs() {
        return (PaymentLauncherContract.Args) this.starterArgs$delegate.getValue();
    }

    public final ViewModelProvider.Factory getViewModelFactory$payments_core_release() {
        return this.viewModelFactory;
    }

    public final void setViewModelFactory$payments_core_release(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    public final PaymentLauncherViewModel getViewModel$payments_core_release() {
        return (PaymentLauncherViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        disableAnimations();
        try {
            Result.Companion companion = Result.Companion;
            PaymentLauncherContract.Args starterArgs = getStarterArgs();
            if (starterArgs != null) {
                obj = Result.m4709constructorimpl(starterArgs);
                Throwable r0 = Result.m4712exceptionOrNullimpl(obj);
                if (r0 == null) {
                    PaymentLauncherContract.Args args = (PaymentLauncherContract.Args) obj;
                    Integer statusBarColor = args.getStatusBarColor();
                    if (statusBarColor != null) {
                        getWindow().setStatusBarColor(statusBarColor.intValue());
                    }
                    getViewModel$payments_core_release().getPaymentLauncherResult$payments_core_release().observe(this, new Observer() {
                        public final void onChanged(Object obj) {
                            PaymentLauncherConfirmationActivity.this.finishWithResult((PaymentResult) obj);
                        }
                    });
                    getViewModel$payments_core_release().register$payments_core_release(this);
                    AuthActivityStarterHost create$payments_core_release = AuthActivityStarterHost.Companion.create$payments_core_release((ComponentActivity) this);
                    if (args instanceof PaymentLauncherContract.Args.IntentConfirmationArgs) {
                        getViewModel$payments_core_release().confirmStripeIntent$payments_core_release(((PaymentLauncherContract.Args.IntentConfirmationArgs) args).getConfirmStripeIntentParams(), create$payments_core_release);
                    } else if (args instanceof PaymentLauncherContract.Args.PaymentIntentNextActionArgs) {
                        getViewModel$payments_core_release().handleNextActionForStripeIntent$payments_core_release(((PaymentLauncherContract.Args.PaymentIntentNextActionArgs) args).getPaymentIntentClientSecret(), create$payments_core_release);
                    } else if (args instanceof PaymentLauncherContract.Args.SetupIntentNextActionArgs) {
                        getViewModel$payments_core_release().handleNextActionForStripeIntent$payments_core_release(((PaymentLauncherContract.Args.SetupIntentNextActionArgs) args).getSetupIntentClientSecret(), create$payments_core_release);
                    }
                } else {
                    finishWithResult(new PaymentResult.Failed(r0));
                }
            } else {
                throw new IllegalArgumentException(EMPTY_ARG_ERROR.toString());
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getViewModel$payments_core_release().cleanUp$payments_core_release();
    }

    public void finish() {
        super.finish();
        disableAnimations();
    }

    private final void disableAnimations() {
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: private */
    public final void finishWithResult(PaymentResult paymentResult) {
        setResult(-1, new Intent().putExtras(paymentResult.toBundle()));
        finish();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherConfirmationActivity$Companion;", "", "()V", "EMPTY_ARG_ERROR", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentLauncherConfirmationActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
