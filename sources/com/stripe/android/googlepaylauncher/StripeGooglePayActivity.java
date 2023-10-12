package com.stripe.android.googlepaylauncher;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentDataRequest;
import com.google.android.gms.wallet.PaymentsClient;
import com.stripe.android.googlepaylauncher.GooglePayLauncherResult;
import com.stripe.android.googlepaylauncher.StripeGooglePayContract;
import com.stripe.android.model.GooglePayResult;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.ShippingInformation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\"\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\u0012\u0010)\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u001a\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016¨\u00061"}, d2 = {"Lcom/stripe/android/googlepaylauncher/StripeGooglePayActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "args", "Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args;", "paymentsClient", "Lcom/google/android/gms/wallet/PaymentsClient;", "getPaymentsClient", "()Lcom/google/android/gms/wallet/PaymentsClient;", "paymentsClient$delegate", "Lkotlin/Lazy;", "publishableKey", "", "getPublishableKey", "()Ljava/lang/String;", "publishableKey$delegate", "stripeAccountId", "getStripeAccountId", "stripeAccountId$delegate", "viewModel", "Lcom/stripe/android/googlepaylauncher/StripeGooglePayViewModel;", "getViewModel", "()Lcom/stripe/android/googlepaylauncher/StripeGooglePayViewModel;", "viewModel$delegate", "finish", "", "finishWithResult", "result", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult;", "isReadyToPay", "paymentDataRequest", "Lorg/json/JSONObject;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGooglePayResult", "onPaymentMethodCreated", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "payWithGoogle", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeGooglePayActivity.kt */
public final class StripeGooglePayActivity extends AppCompatActivity {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int LOAD_PAYMENT_DATA_REQUEST_CODE = 4444;
    /* access modifiers changed from: private */
    public StripeGooglePayContract.Args args;
    private final Lazy paymentsClient$delegate = LazyKt.lazy(new StripeGooglePayActivity$paymentsClient$2(this));
    private final Lazy publishableKey$delegate = LazyKt.lazy(new StripeGooglePayActivity$publishableKey$2(this));
    private final Lazy stripeAccountId$delegate = LazyKt.lazy(new StripeGooglePayActivity$stripeAccountId$2(this));
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(StripeGooglePayViewModel.class), new StripeGooglePayActivity$special$$inlined$viewModels$2(this), new StripeGooglePayActivity$viewModel$2(this));

    private final PaymentsClient getPaymentsClient() {
        return (PaymentsClient) this.paymentsClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getPublishableKey() {
        return (String) this.publishableKey$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getStripeAccountId() {
        return (String) this.stripeAccountId$delegate.getValue();
    }

    private final StripeGooglePayViewModel getViewModel() {
        return (StripeGooglePayViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        overridePendingTransition(0, 0);
        setResult(-1, new Intent().putExtras(GooglePayLauncherResult.Canceled.INSTANCE.toBundle()));
        StripeGooglePayContract.Args.Companion companion = StripeGooglePayContract.Args.Companion;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        StripeGooglePayContract.Args create$payments_core_release = companion.create$payments_core_release(intent);
        if (create$payments_core_release == null) {
            finishWithResult(new GooglePayLauncherResult.Error(new RuntimeException("StripeGooglePayActivity was started without arguments."), (Status) null, (PaymentMethod) null, (ShippingInformation) null, 14, (DefaultConstructorMarker) null));
            return;
        }
        this.args = create$payments_core_release;
        if (create$payments_core_release == null) {
            Intrinsics.throwUninitializedPropertyAccessException("args");
            create$payments_core_release = null;
        }
        Integer statusBarColor = create$payments_core_release.getStatusBarColor();
        if (statusBarColor != null) {
            getWindow().setStatusBarColor(statusBarColor.intValue());
        }
        getViewModel().getGooglePayResult$payments_core_release().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                StripeGooglePayActivity.m4301onCreate$lambda1(StripeGooglePayActivity.this, (GooglePayLauncherResult) obj);
            }
        });
        if (!getViewModel().getHasLaunched()) {
            getViewModel().setHasLaunched(true);
            isReadyToPay(getViewModel().createPaymentDataRequestForPaymentIntentArgs());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m4301onCreate$lambda1(StripeGooglePayActivity stripeGooglePayActivity, GooglePayLauncherResult googlePayLauncherResult) {
        Intrinsics.checkNotNullParameter(stripeGooglePayActivity, "this$0");
        if (googlePayLauncherResult != null) {
            stripeGooglePayActivity.finishWithResult(googlePayLauncherResult);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    private final void isReadyToPay(JSONObject jSONObject) {
        getPaymentsClient().isReadyToPay(getViewModel().createIsReadyToPayRequest()).addOnCompleteListener(new OnCompleteListener(jSONObject) {
            public final /* synthetic */ JSONObject f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                StripeGooglePayActivity.m4298isReadyToPay$lambda4(StripeGooglePayActivity.this, this.f$1, task);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: isReadyToPay$lambda-4  reason: not valid java name */
    public static final void m4298isReadyToPay$lambda4(StripeGooglePayActivity stripeGooglePayActivity, JSONObject jSONObject, Task task) {
        Object obj;
        Intrinsics.checkNotNullParameter(stripeGooglePayActivity, "this$0");
        Intrinsics.checkNotNullParameter(jSONObject, "$paymentDataRequest");
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            Result.Companion companion = Result.Companion;
            if (task.isSuccessful()) {
                stripeGooglePayActivity.payWithGoogle(jSONObject);
            } else {
                stripeGooglePayActivity.getViewModel().updateGooglePayResult(GooglePayLauncherResult.Unavailable.INSTANCE);
            }
            obj = Result.m4709constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
        if (r1 != null) {
            stripeGooglePayActivity.getViewModel().updateGooglePayResult(new GooglePayLauncherResult.Error(r1, (Status) null, (PaymentMethod) null, (ShippingInformation) null, 14, (DefaultConstructorMarker) null));
        }
    }

    private final void payWithGoogle(JSONObject jSONObject) {
        AutoResolveHelper.resolveTask(getPaymentsClient().loadPaymentData(PaymentDataRequest.fromJson(jSONObject.toString())), this, LOAD_PAYMENT_DATA_REQUEST_CODE);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != LOAD_PAYMENT_DATA_REQUEST_CODE) {
            return;
        }
        if (i2 == -1) {
            onGooglePayResult(intent);
        } else if (i2 == 0) {
            getViewModel().updateGooglePayResult(GooglePayLauncherResult.Canceled.INSTANCE);
        } else if (i2 != 1) {
            getViewModel().updateGooglePayResult(new GooglePayLauncherResult.Error(new RuntimeException("Google Pay returned an expected result code."), (Status) null, (PaymentMethod) null, (ShippingInformation) null, 14, (DefaultConstructorMarker) null));
        } else {
            getViewModel().updateGooglePayResult(new GooglePayLauncherResult.Error(new RuntimeException("Google Pay returned an error. See googlePayStatus property for more information."), AutoResolveHelper.getStatusFromIntent(intent), (PaymentMethod) null, (ShippingInformation) null, 12, (DefaultConstructorMarker) null));
        }
    }

    private final void onGooglePayResult(Intent intent) {
        PaymentData fromIntent = intent == null ? null : PaymentData.getFromIntent(intent);
        if (fromIntent == null) {
            getViewModel().updateGooglePayResult(new GooglePayLauncherResult.Error(new IllegalArgumentException("Google Pay data was not available"), (Status) null, (PaymentMethod) null, (ShippingInformation) null, 14, (DefaultConstructorMarker) null));
            return;
        }
        JSONObject jSONObject = new JSONObject(fromIntent.toJson());
        getViewModel().createPaymentMethod(PaymentMethodCreateParams.Companion.createFromGooglePay(jSONObject)).observe(this, new Observer(GooglePayResult.Companion.fromJson(jSONObject).getShippingInformation()) {
            public final /* synthetic */ ShippingInformation f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                StripeGooglePayActivity.m4302onGooglePayResult$lambda8(StripeGooglePayActivity.this, this.f$1, (Result) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onGooglePayResult$lambda-8  reason: not valid java name */
    public static final void m4302onGooglePayResult$lambda8(StripeGooglePayActivity stripeGooglePayActivity, ShippingInformation shippingInformation, Result result) {
        Intrinsics.checkNotNullParameter(stripeGooglePayActivity, "this$0");
        if (result != null) {
            Object r9 = result.m4718unboximpl();
            Throwable r1 = Result.m4712exceptionOrNullimpl(r9);
            if (r1 == null) {
                stripeGooglePayActivity.onPaymentMethodCreated((PaymentMethod) r9, shippingInformation);
                return;
            }
            stripeGooglePayActivity.getViewModel().setPaymentMethod((PaymentMethod) null);
            stripeGooglePayActivity.getViewModel().updateGooglePayResult(new GooglePayLauncherResult.Error(r1, (Status) null, (PaymentMethod) null, (ShippingInformation) null, 14, (DefaultConstructorMarker) null));
        }
    }

    private final void onPaymentMethodCreated(PaymentMethod paymentMethod, ShippingInformation shippingInformation) {
        getViewModel().setPaymentMethod(paymentMethod);
        getViewModel().updateGooglePayResult(new GooglePayLauncherResult.PaymentData(paymentMethod, shippingInformation));
    }

    private final void finishWithResult(GooglePayLauncherResult googlePayLauncherResult) {
        setResult(-1, new Intent().putExtras(googlePayLauncherResult.toBundle()));
        finish();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/googlepaylauncher/StripeGooglePayActivity$Companion;", "", "()V", "LOAD_PAYMENT_DATA_REQUEST_CODE", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeGooglePayActivity.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
