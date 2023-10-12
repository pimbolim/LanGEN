package com.stripe.android.payments.core.authentication;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.authentication.PaymentAuthenticator;
import com.stripe.android.view.AuthActivityStarterHost;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J)\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/payments/core/authentication/OxxoAuthenticator;", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Lcom/stripe/android/model/StripeIntent;", "webIntentAuthenticator", "Lcom/stripe/android/payments/core/authentication/WebIntentAuthenticator;", "noOpIntentAuthenticator", "Lcom/stripe/android/payments/core/authentication/NoOpIntentAuthenticator;", "(Lcom/stripe/android/payments/core/authentication/WebIntentAuthenticator;Lcom/stripe/android/payments/core/authentication/NoOpIntentAuthenticator;)V", "authenticate", "", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "authenticatable", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/StripeIntent;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OxxoAuthenticator.kt */
public final class OxxoAuthenticator implements PaymentAuthenticator<StripeIntent> {
    private final NoOpIntentAuthenticator noOpIntentAuthenticator;
    private final WebIntentAuthenticator webIntentAuthenticator;

    @Inject
    public OxxoAuthenticator(WebIntentAuthenticator webIntentAuthenticator2, NoOpIntentAuthenticator noOpIntentAuthenticator2) {
        Intrinsics.checkNotNullParameter(webIntentAuthenticator2, "webIntentAuthenticator");
        Intrinsics.checkNotNullParameter(noOpIntentAuthenticator2, "noOpIntentAuthenticator");
        this.webIntentAuthenticator = webIntentAuthenticator2;
        this.noOpIntentAuthenticator = noOpIntentAuthenticator2;
    }

    public void onLauncherInvalidated() {
        PaymentAuthenticator.DefaultImpls.onLauncherInvalidated(this);
    }

    public void onNewActivityResultCaller(ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
        PaymentAuthenticator.DefaultImpls.onNewActivityResultCaller(this, activityResultCaller, activityResultCallback);
    }

    public Object authenticate(AuthActivityStarterHost authActivityStarterHost, StripeIntent stripeIntent, ApiRequest.Options options, Continuation<? super Unit> continuation) {
        StripeIntent.NextActionData nextActionData = stripeIntent.getNextActionData();
        Objects.requireNonNull(nextActionData, "null cannot be cast to non-null type com.stripe.android.model.StripeIntent.NextActionData.DisplayOxxoDetails");
        if (((StripeIntent.NextActionData.DisplayOxxoDetails) nextActionData).getHostedVoucherUrl() == null) {
            Object authenticate = this.noOpIntentAuthenticator.authenticate(authActivityStarterHost, stripeIntent, options, (Continuation<Unit>) continuation);
            if (authenticate == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return authenticate;
            }
        } else {
            Object authenticate2 = this.webIntentAuthenticator.authenticate(authActivityStarterHost, stripeIntent, options, (Continuation<Unit>) continuation);
            if (authenticate2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return authenticate2;
            }
        }
        return Unit.INSTANCE;
    }
}
