package com.stripe.android.googlepaylauncher;

import android.content.Context;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentsClient;
import com.stripe.android.GooglePayJsonFactory;
import com.stripe.android.core.Logger;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/googlepaylauncher/DefaultGooglePayRepository;", "Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "context", "Landroid/content/Context;", "googlePayConfig", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "logger", "Lcom/stripe/android/core/Logger;", "(Landroid/content/Context;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;Lcom/stripe/android/core/Logger;)V", "environment", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "billingAddressParameters", "Lcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters;", "existingPaymentMethodRequired", "", "(Landroid/content/Context;Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;Lcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters;ZLcom/stripe/android/core/Logger;)V", "googlePayJsonFactory", "Lcom/stripe/android/GooglePayJsonFactory;", "paymentsClient", "Lcom/google/android/gms/wallet/PaymentsClient;", "getPaymentsClient", "()Lcom/google/android/gms/wallet/PaymentsClient;", "paymentsClient$delegate", "Lkotlin/Lazy;", "isReady", "Lkotlinx/coroutines/flow/Flow;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayRepository.kt */
public final class DefaultGooglePayRepository implements GooglePayRepository {
    private final GooglePayJsonFactory.BillingAddressParameters billingAddressParameters;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final GooglePayEnvironment environment;
    private final boolean existingPaymentMethodRequired;
    private final GooglePayJsonFactory googlePayJsonFactory;
    private final Logger logger;
    private final Lazy paymentsClient$delegate;

    public DefaultGooglePayRepository(Context context2, GooglePayEnvironment googlePayEnvironment, GooglePayJsonFactory.BillingAddressParameters billingAddressParameters2, boolean z, Logger logger2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
        Intrinsics.checkNotNullParameter(billingAddressParameters2, "billingAddressParameters");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.context = context2;
        this.environment = googlePayEnvironment;
        this.billingAddressParameters = billingAddressParameters2;
        this.existingPaymentMethodRequired = z;
        this.logger = logger2;
        this.googlePayJsonFactory = new GooglePayJsonFactory(context2, false, 2, (DefaultConstructorMarker) null);
        this.paymentsClient$delegate = LazyKt.lazy(new DefaultGooglePayRepository$paymentsClient$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultGooglePayRepository(Context context2, GooglePayEnvironment googlePayEnvironment, GooglePayJsonFactory.BillingAddressParameters billingAddressParameters2, boolean z, Logger logger2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, googlePayEnvironment, billingAddressParameters2, z, (i & 16) != 0 ? Logger.Companion.noop() : logger2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultGooglePayRepository(android.content.Context r8, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Config r9, com.stripe.android.core.Logger r10) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "googlePayConfig"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "logger"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.content.Context r2 = r8.getApplicationContext()
            java.lang.String r8 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            com.stripe.android.googlepaylauncher.GooglePayEnvironment r3 = r9.getEnvironment()
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$BillingAddressConfig r8 = r9.getBillingAddressConfig()
            com.stripe.android.GooglePayJsonFactory$BillingAddressParameters r4 = com.stripe.android.googlepaylauncher.GooglePayConfigConversionKtxKt.convert((com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.BillingAddressConfig) r8)
            boolean r5 = r9.getExistingPaymentMethodRequired()
            r1 = r7
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.DefaultGooglePayRepository.<init>(android.content.Context, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config, com.stripe.android.core.Logger):void");
    }

    private final PaymentsClient getPaymentsClient() {
        return (PaymentsClient) this.paymentsClient$delegate.getValue();
    }

    public Flow<Boolean> isReady() {
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        IsReadyToPayRequest fromJson = IsReadyToPayRequest.fromJson(this.googlePayJsonFactory.createIsReadyToPayRequest(this.billingAddressParameters, Boolean.valueOf(this.existingPaymentMethodRequired)).toString());
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(\n            go…   ).toString()\n        )");
        getPaymentsClient().isReadyToPay(fromJson).addOnCompleteListener(new OnCompleteListener(MutableStateFlow) {
            public final /* synthetic */ MutableStateFlow f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                DefaultGooglePayRepository.m4289isReady$lambda2(DefaultGooglePayRepository.this, this.f$1, task);
            }
        });
        return FlowKt.filterNotNull(MutableStateFlow);
    }

    /* access modifiers changed from: private */
    /* renamed from: isReady$lambda-2  reason: not valid java name */
    public static final void m4289isReady$lambda2(DefaultGooglePayRepository defaultGooglePayRepository, MutableStateFlow mutableStateFlow, Task task) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(defaultGooglePayRepository, "this$0");
        Intrinsics.checkNotNullParameter(mutableStateFlow, "$isReadyState");
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            Result.Companion companion = Result.Companion;
            bool = Result.m4709constructorimpl(Boolean.valueOf(Intrinsics.areEqual(task.getResult(ApiException.class), (Object) true)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            bool = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r0 = Result.m4712exceptionOrNullimpl(bool);
        if (r0 != null) {
            defaultGooglePayRepository.logger.error("Google Pay check failed.", r0);
        }
        if (Result.m4715isFailureimpl(bool)) {
            bool = false;
        }
        boolean booleanValue = ((Boolean) bool).booleanValue();
        defaultGooglePayRepository.logger.info(Intrinsics.stringPlus("Google Pay ready? ", Boolean.valueOf(booleanValue)));
        mutableStateFlow.setValue(Boolean.valueOf(booleanValue));
    }
}
