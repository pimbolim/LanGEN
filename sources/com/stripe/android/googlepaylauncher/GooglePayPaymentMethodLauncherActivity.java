package com.stripe.android.googlepaylauncher;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BundleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.PaymentData;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0015\u0010\u0011\u001a\u00070\u0012¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0016\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\"\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010!\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006$"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "args", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "viewModel", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherViewModel;", "getViewModel", "()Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "disableAnimations", "", "finish", "finishWithResult", "result", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "googlePayStatusCodeToErrorCode", "", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ErrorCode;", "googlePayStatusCode", "launchGooglePay", "task", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/wallet/PaymentData;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGooglePayResult", "updateResult", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncherActivity.kt */
public final class GooglePayPaymentMethodLauncherActivity extends AppCompatActivity {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int LOAD_PAYMENT_DATA_REQUEST_CODE = 4444;
    /* access modifiers changed from: private */
    public GooglePayPaymentMethodLauncherContract.Args args;
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GooglePayPaymentMethodLauncherViewModel.class), new GooglePayPaymentMethodLauncherActivity$special$$inlined$viewModels$2(this), new GooglePayPaymentMethodLauncherActivity$viewModel$2(this));

    private final int googlePayStatusCodeToErrorCode(int i) {
        if (i != 7) {
            return i != 10 ? 1 : 2;
        }
        return 3;
    }

    /* access modifiers changed from: private */
    public final GooglePayPaymentMethodLauncherViewModel getViewModel() {
        return (GooglePayPaymentMethodLauncherViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("extra_status_bar_color", -1);
        if (intExtra != -1) {
            getWindow().setStatusBarColor(intExtra);
        }
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        disableAnimations();
        GooglePayPaymentMethodLauncherContract.Args.Companion companion = GooglePayPaymentMethodLauncherContract.Args.Companion;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        GooglePayPaymentMethodLauncherContract.Args fromIntent = companion.fromIntent(intent);
        if (fromIntent == null) {
            finishWithResult(new GooglePayPaymentMethodLauncher.Result.Failed(new RuntimeException("GooglePayPaymentMethodLauncherActivity was started without arguments."), 2));
            return;
        }
        this.args = fromIntent;
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getGooglePayResult$payments_core_release().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                GooglePayPaymentMethodLauncherActivity.m4297onCreate$lambda0(GooglePayPaymentMethodLauncherActivity.this, (GooglePayPaymentMethodLauncher.Result) obj);
            }
        });
        if (!getViewModel().getHasLaunched$payments_core_release()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new GooglePayPaymentMethodLauncherActivity$onCreate$2(this, (Continuation<? super GooglePayPaymentMethodLauncherActivity$onCreate$2>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m4297onCreate$lambda0(GooglePayPaymentMethodLauncherActivity googlePayPaymentMethodLauncherActivity, GooglePayPaymentMethodLauncher.Result result) {
        Intrinsics.checkNotNullParameter(googlePayPaymentMethodLauncherActivity, "this$0");
        if (result != null) {
            googlePayPaymentMethodLauncherActivity.finishWithResult(result);
        }
    }

    public void finish() {
        super.finish();
        disableAnimations();
    }

    /* access modifiers changed from: private */
    public final void launchGooglePay(Task<PaymentData> task) {
        AutoResolveHelper.resolveTask(task, this, LOAD_PAYMENT_DATA_REQUEST_CODE);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        super.onActivityResult(i, i2, intent);
        if (i != LOAD_PAYMENT_DATA_REQUEST_CODE) {
            return;
        }
        if (i2 == -1) {
            onGooglePayResult(intent);
        } else if (i2 != 0) {
            int i3 = 1;
            if (i2 != 1) {
                updateResult(new GooglePayPaymentMethodLauncher.Result.Failed(new RuntimeException("Google Pay returned an expected result code."), 1));
                return;
            }
            Status statusFromIntent = AutoResolveHelper.getStatusFromIntent(intent);
            Integer num = null;
            if (statusFromIntent == null) {
                str = null;
            } else {
                str = statusFromIntent.getStatusMessage();
            }
            if (str == null) {
                str = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Google Pay failed with error ");
            if (statusFromIntent != null) {
                num = Integer.valueOf(statusFromIntent.getStatusCode());
            }
            sb.append(num);
            sb.append(": ");
            sb.append(str);
            Throwable runtimeException = new RuntimeException(sb.toString());
            if (statusFromIntent != null) {
                i3 = googlePayStatusCodeToErrorCode(statusFromIntent.getStatusCode());
            }
            updateResult(new GooglePayPaymentMethodLauncher.Result.Failed(runtimeException, i3));
        } else {
            updateResult(GooglePayPaymentMethodLauncher.Result.Canceled.INSTANCE);
        }
    }

    private final void onGooglePayResult(Intent intent) {
        PaymentData fromIntent;
        Job job = null;
        if (!(intent == null || (fromIntent = PaymentData.getFromIntent(intent)) == null)) {
            job = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new GooglePayPaymentMethodLauncherActivity$onGooglePayResult$2$1(this, fromIntent, (Continuation<? super GooglePayPaymentMethodLauncherActivity$onGooglePayResult$2$1>) null), 3, (Object) null);
        }
        if (job == null) {
            updateResult(new GooglePayPaymentMethodLauncher.Result.Failed(new IllegalArgumentException("Google Pay data was not available"), 1));
        }
    }

    /* access modifiers changed from: private */
    public final void updateResult(GooglePayPaymentMethodLauncher.Result result) {
        getViewModel().updateResult(result);
    }

    /* access modifiers changed from: private */
    public final void finishWithResult(GooglePayPaymentMethodLauncher.Result result) {
        setResult(-1, new Intent().putExtras(BundleKt.bundleOf(TuplesKt.to("extra_result", result))));
        finish();
    }

    private final void disableAnimations() {
        overridePendingTransition(0, 0);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherActivity$Companion;", "", "()V", "LOAD_PAYMENT_DATA_REQUEST_CODE", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncherActivity.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
