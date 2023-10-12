package com.stripe.android.link.confirmation;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.payments.paymentlauncher.PaymentLauncher;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\bJ/\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\nj\u0002`\u000eø\u0001\u0000J\u0006\u0010\u0015\u001a\u00020\rJ\u0017\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bR+\u0010\t\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000eX\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/link/confirmation/ConfirmationManager;", "", "paymentLauncherFactory", "Lcom/stripe/android/payments/paymentlauncher/StripePaymentLauncherAssistedFactory;", "publishableKeyProvider", "Lkotlin/Function0;", "", "stripeAccountIdProvider", "(Lcom/stripe/android/payments/paymentlauncher/StripePaymentLauncherAssistedFactory;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "completionCallback", "Lkotlin/Function1;", "Lkotlin/Result;", "Lcom/stripe/android/payments/paymentlauncher/PaymentResult;", "", "Lcom/stripe/android/link/confirmation/PaymentConfirmationCallback;", "paymentLauncher", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "confirmStripeIntent", "confirmStripeIntentParams", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "onResult", "invalidatePaymentLauncher", "onPaymentResult", "paymentResult", "(Lcom/stripe/android/payments/paymentlauncher/PaymentResult;)Lkotlin/Unit;", "setupPaymentLauncher", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfirmationManager.kt */
public final class ConfirmationManager {
    private Function1<? super Result<? extends PaymentResult>, Unit> completionCallback;
    private PaymentLauncher paymentLauncher;
    private final StripePaymentLauncherAssistedFactory paymentLauncherFactory;
    private final Function0<String> publishableKeyProvider;
    private final Function0<String> stripeAccountIdProvider;

    @Inject
    public ConfirmationManager(StripePaymentLauncherAssistedFactory stripePaymentLauncherAssistedFactory, @Named("publishableKey") Function0<String> function0, @Named("stripeAccountId") Function0<String> function02) {
        Intrinsics.checkNotNullParameter(stripePaymentLauncherAssistedFactory, "paymentLauncherFactory");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(function02, "stripeAccountIdProvider");
        this.paymentLauncherFactory = stripePaymentLauncherAssistedFactory;
        this.publishableKeyProvider = function0;
        this.stripeAccountIdProvider = function02;
    }

    public final void setupPaymentLauncher(ActivityResultCaller activityResultCaller) {
        Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
        StripePaymentLauncherAssistedFactory stripePaymentLauncherAssistedFactory = this.paymentLauncherFactory;
        Function0<String> function0 = this.publishableKeyProvider;
        Function0<String> function02 = this.stripeAccountIdProvider;
        ActivityResultLauncher registerForActivityResult = activityResultCaller.registerForActivityResult(new PaymentLauncherContract(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                ConfirmationManager.this.onPaymentResult((PaymentResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activityResultCaller.reg…ymentResult\n            )");
        this.paymentLauncher = stripePaymentLauncherAssistedFactory.create(function0, function02, registerForActivityResult);
    }

    public final void invalidatePaymentLauncher() {
        this.paymentLauncher = null;
    }

    public final void confirmStripeIntent(ConfirmStripeIntentParams confirmStripeIntentParams, Function1<? super Result<? extends PaymentResult>, Unit> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(confirmStripeIntentParams, "confirmStripeIntentParams");
        Intrinsics.checkNotNullParameter(function1, "onResult");
        this.completionCallback = function1;
        try {
            Result.Companion companion = Result.Companion;
            PaymentLauncher paymentLauncher2 = this.paymentLauncher;
            if (paymentLauncher2 != null) {
                obj = Result.m4709constructorimpl(paymentLauncher2);
                Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
                if (r1 == null) {
                    PaymentLauncher paymentLauncher3 = (PaymentLauncher) obj;
                    if (confirmStripeIntentParams instanceof ConfirmPaymentIntentParams) {
                        paymentLauncher3.confirm((ConfirmPaymentIntentParams) confirmStripeIntentParams);
                    } else if (confirmStripeIntentParams instanceof ConfirmSetupIntentParams) {
                        paymentLauncher3.confirm((ConfirmSetupIntentParams) confirmStripeIntentParams);
                    }
                } else {
                    Result.Companion companion2 = Result.Companion;
                    function1.invoke(Result.m4708boximpl(Result.m4709constructorimpl(ResultKt.createFailure(r1))));
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } catch (Throwable th) {
            Result.Companion companion3 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* access modifiers changed from: private */
    public final Unit onPaymentResult(PaymentResult paymentResult) {
        Function1<? super Result<? extends PaymentResult>, Unit> function1 = this.completionCallback;
        if (function1 == null) {
            return null;
        }
        Result.Companion companion = Result.Companion;
        function1.invoke(Result.m4708boximpl(Result.m4709constructorimpl(paymentResult)));
        return Unit.INSTANCE;
    }
}
