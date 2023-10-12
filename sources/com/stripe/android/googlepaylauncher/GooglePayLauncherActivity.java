package com.stripe.android.googlepaylauncher;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
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
import com.stripe.android.googlepaylauncher.GooglePayLauncher;
import com.stripe.android.googlepaylauncher.GooglePayLauncherContract;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.AuthActivityStarterHost;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0015J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0016\u0010\u001b\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "args", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;", "viewModel", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherViewModel;", "getViewModel", "()Lcom/stripe/android/googlepaylauncher/GooglePayLauncherViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "disableAnimations", "", "finish", "finishWithResult", "result", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGooglePayResult", "payWithGoogle", "task", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/wallet/PaymentData;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayLauncherActivity.kt */
public final class GooglePayLauncherActivity extends AppCompatActivity {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int LOAD_PAYMENT_DATA_REQUEST_CODE = 4444;
    /* access modifiers changed from: private */
    public GooglePayLauncherContract.Args args;
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GooglePayLauncherViewModel.class), new GooglePayLauncherActivity$special$$inlined$viewModels$2(this), new GooglePayLauncherActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final GooglePayLauncherViewModel getViewModel() {
        return (GooglePayLauncherViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        disableAnimations();
        try {
            Result.Companion companion = Result.Companion;
            GooglePayLauncherContract.Args.Companion companion2 = GooglePayLauncherContract.Args.Companion;
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            GooglePayLauncherContract.Args fromIntent$payments_core_release = companion2.fromIntent$payments_core_release(intent);
            if (fromIntent$payments_core_release != null) {
                obj = Result.m4709constructorimpl(fromIntent$payments_core_release);
                Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
                if (r1 == null) {
                    this.args = (GooglePayLauncherContract.Args) obj;
                    int intExtra = getIntent().getIntExtra("extra_status_bar_color", -1);
                    if (intExtra != -1) {
                        getWindow().setStatusBarColor(intExtra);
                    }
                    LifecycleOwner lifecycleOwner = this;
                    getViewModel().getGooglePayResult$payments_core_release().observe(lifecycleOwner, new Observer() {
                        public final void onChanged(Object obj) {
                            GooglePayLauncherActivity.m4294onCreate$lambda3(GooglePayLauncherActivity.this, (GooglePayLauncher.Result) obj);
                        }
                    });
                    if (!getViewModel().getHasLaunched()) {
                        getViewModel().setHasLaunched(true);
                        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new GooglePayLauncherActivity$onCreate$4(this, (Continuation<? super GooglePayLauncherActivity$onCreate$4>) null), 3, (Object) null);
                        return;
                    }
                    return;
                }
                finishWithResult(new GooglePayLauncher.Result.Failed(r1));
                return;
            }
            throw new IllegalArgumentException("GooglePayLauncherActivity was started without arguments.".toString());
        } catch (Throwable th) {
            Result.Companion companion3 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m4294onCreate$lambda3(GooglePayLauncherActivity googlePayLauncherActivity, GooglePayLauncher.Result result) {
        Intrinsics.checkNotNullParameter(googlePayLauncherActivity, "this$0");
        if (result != null) {
            googlePayLauncherActivity.finishWithResult(result);
        }
    }

    public void finish() {
        super.finish();
        disableAnimations();
    }

    /* access modifiers changed from: private */
    public final void payWithGoogle(Task<PaymentData> task) {
        AutoResolveHelper.resolveTask(task, this, LOAD_PAYMENT_DATA_REQUEST_CODE);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = null;
        if (i != LOAD_PAYMENT_DATA_REQUEST_CODE) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new GooglePayLauncherActivity$onActivityResult$1(this, i, intent, (Continuation<? super GooglePayLauncherActivity$onActivityResult$1>) null), 3, (Object) null);
        } else if (i2 == -1) {
            onGooglePayResult(intent);
        } else if (i2 == 0) {
            getViewModel().updateResult(GooglePayLauncher.Result.Canceled.INSTANCE);
        } else if (i2 != 1) {
            getViewModel().updateResult(new GooglePayLauncher.Result.Failed(new RuntimeException("Google Pay returned an expected result code.")));
        } else {
            Status statusFromIntent = AutoResolveHelper.getStatusFromIntent(intent);
            if (statusFromIntent != null) {
                str = statusFromIntent.getStatusMessage();
            }
            if (str == null) {
                str = "";
            }
            getViewModel().updateResult(new GooglePayLauncher.Result.Failed(new RuntimeException(Intrinsics.stringPlus("Google Pay failed with error: ", str))));
        }
    }

    private final void onGooglePayResult(Intent intent) {
        PaymentData fromIntent = intent == null ? null : PaymentData.getFromIntent(intent);
        if (fromIntent == null) {
            getViewModel().updateResult(new GooglePayLauncher.Result.Failed(new IllegalArgumentException("Google Pay data was not available")));
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new GooglePayLauncherActivity$onGooglePayResult$1(this, AuthActivityStarterHost.Companion.create$payments_core_release((ComponentActivity) this), PaymentMethodCreateParams.Companion.createFromGooglePay(new JSONObject(fromIntent.toJson())), (Continuation<? super GooglePayLauncherActivity$onGooglePayResult$1>) null), 3, (Object) null);
    }

    private final void finishWithResult(GooglePayLauncher.Result result) {
        setResult(-1, new Intent().putExtras(BundleKt.bundleOf(TuplesKt.to("extra_result", result))));
        finish();
    }

    private final void disableAnimations() {
        overridePendingTransition(0, 0);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherActivity$Companion;", "", "()V", "LOAD_PAYMENT_DATA_REQUEST_CODE", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherActivity.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
