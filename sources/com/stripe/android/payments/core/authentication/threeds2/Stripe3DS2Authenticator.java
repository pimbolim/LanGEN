package com.stripe.android.payments.core.authentication.threeds2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.PaymentAuthConfig;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.authentication.PaymentAuthenticator;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.stripe3ds2.transaction.SdkTransactionId;
import com.stripe.android.view.AuthActivityStarterHost;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0002\u0010\rJ)\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u001cH\u0016J\u001e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3DS2Authenticator;", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Lcom/stripe/android/model/StripeIntent;", "config", "Lcom/stripe/android/PaymentAuthConfig;", "enableLogging", "", "injectorKey", "", "publishableKeyProvider", "Lkotlin/Function0;", "productUsage", "", "(Lcom/stripe/android/PaymentAuthConfig;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/util/Set;)V", "stripe3ds2CompletionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "getStripe3ds2CompletionLauncher$payments_core_release$annotations", "()V", "getStripe3ds2CompletionLauncher$payments_core_release", "()Landroidx/activity/result/ActivityResultLauncher;", "setStripe3ds2CompletionLauncher$payments_core_release", "(Landroidx/activity/result/ActivityResultLauncher;)V", "stripe3ds2CompletionStarterFactory", "Lkotlin/Function1;", "Lcom/stripe/android/view/AuthActivityStarterHost;", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionStarter;", "authenticate", "", "host", "authenticatable", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/StripeIntent;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLauncherInvalidated", "onNewActivityResultCaller", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "activityResultCallback", "Landroidx/activity/result/ActivityResultCallback;", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3DS2Authenticator.kt */
public final class Stripe3DS2Authenticator implements PaymentAuthenticator<StripeIntent> {
    private final PaymentAuthConfig config;
    private final boolean enableLogging;
    private final String injectorKey;
    private final Set<String> productUsage;
    private final Function0<String> publishableKeyProvider;
    private ActivityResultLauncher<Stripe3ds2TransactionContract.Args> stripe3ds2CompletionLauncher;
    private final Function1<AuthActivityStarterHost, Stripe3ds2TransactionStarter> stripe3ds2CompletionStarterFactory = new Stripe3DS2Authenticator$stripe3ds2CompletionStarterFactory$1(this);

    public static /* synthetic */ void getStripe3ds2CompletionLauncher$payments_core_release$annotations() {
    }

    @Inject
    public Stripe3DS2Authenticator(PaymentAuthConfig paymentAuthConfig, @Named("enableLogging") boolean z, @InjectorKey String str, @Named("publishableKey") Function0<String> function0, @Named("productUsage") Set<String> set) {
        Intrinsics.checkNotNullParameter(paymentAuthConfig, "config");
        Intrinsics.checkNotNullParameter(str, "injectorKey");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        this.config = paymentAuthConfig;
        this.enableLogging = z;
        this.injectorKey = str;
        this.publishableKeyProvider = function0;
        this.productUsage = set;
    }

    public final ActivityResultLauncher<Stripe3ds2TransactionContract.Args> getStripe3ds2CompletionLauncher$payments_core_release() {
        return this.stripe3ds2CompletionLauncher;
    }

    public final void setStripe3ds2CompletionLauncher$payments_core_release(ActivityResultLauncher<Stripe3ds2TransactionContract.Args> activityResultLauncher) {
        this.stripe3ds2CompletionLauncher = activityResultLauncher;
    }

    public void onNewActivityResultCaller(ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
        Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
        Intrinsics.checkNotNullParameter(activityResultCallback, "activityResultCallback");
        this.stripe3ds2CompletionLauncher = activityResultCaller.registerForActivityResult(new Stripe3ds2TransactionContract(), activityResultCallback);
    }

    public void onLauncherInvalidated() {
        ActivityResultLauncher<Stripe3ds2TransactionContract.Args> activityResultLauncher = this.stripe3ds2CompletionLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
        this.stripe3ds2CompletionLauncher = null;
    }

    public Object authenticate(AuthActivityStarterHost authActivityStarterHost, StripeIntent stripeIntent, ApiRequest.Options options, Continuation<? super Unit> continuation) {
        AuthActivityStarterHost authActivityStarterHost2 = authActivityStarterHost;
        SdkTransactionId create = SdkTransactionId.Companion.create();
        PaymentAuthConfig.Stripe3ds2Config stripe3ds2Config$payments_core_release = this.config.getStripe3ds2Config$payments_core_release();
        StripeIntent.NextActionData nextActionData = stripeIntent.getNextActionData();
        Objects.requireNonNull(nextActionData, "null cannot be cast to non-null type com.stripe.android.model.StripeIntent.NextActionData.SdkData.Use3DS2");
        this.stripe3ds2CompletionStarterFactory.invoke(authActivityStarterHost).start(new Stripe3ds2TransactionContract.Args(create, stripe3ds2Config$payments_core_release, stripeIntent, (StripeIntent.NextActionData.SdkData.Use3DS2) nextActionData, options, this.enableLogging, authActivityStarterHost.getStatusBarColor$payments_core_release(), this.injectorKey, this.publishableKeyProvider.invoke(), this.productUsage));
        return Unit.INSTANCE;
    }
}
