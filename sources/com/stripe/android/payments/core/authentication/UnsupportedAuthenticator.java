package com.stripe.android.payments.core.authentication;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.StripeIntentKtxKt;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.authentication.PaymentAuthenticator;
import com.stripe.android.view.AuthActivityStarterHost;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u001b\b\u0007\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J)\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/payments/core/authentication/UnsupportedAuthenticator;", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Lcom/stripe/android/model/StripeIntent;", "paymentRelayStarterFactory", "Lkotlin/Function1;", "Lcom/stripe/android/view/AuthActivityStarterHost;", "Lcom/stripe/android/PaymentRelayStarter;", "(Lkotlin/jvm/functions/Function1;)V", "authenticate", "", "host", "authenticatable", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/StripeIntent;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnsupportedAuthenticator.kt */
public final class UnsupportedAuthenticator implements PaymentAuthenticator<StripeIntent> {
    /* access modifiers changed from: private */
    public static final Map<Class<? extends StripeIntent.NextActionData>, String> ACTION_DEPENDENCY_MAP = MapsKt.mapOf(TuplesKt.to(StripeIntent.NextActionData.WeChatPayRedirect.class, "com.stripe:stripe-wechatpay:20.1.0"));
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function1<AuthActivityStarterHost, PaymentRelayStarter> paymentRelayStarterFactory;

    @Inject
    public UnsupportedAuthenticator(Function1<AuthActivityStarterHost, PaymentRelayStarter> function1) {
        Intrinsics.checkNotNullParameter(function1, "paymentRelayStarterFactory");
        this.paymentRelayStarterFactory = function1;
    }

    public void onLauncherInvalidated() {
        PaymentAuthenticator.DefaultImpls.onLauncherInvalidated(this);
    }

    public void onNewActivityResultCaller(ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
        PaymentAuthenticator.DefaultImpls.onNewActivityResultCaller(this, activityResultCaller, activityResultCallback);
    }

    public Object authenticate(AuthActivityStarterHost authActivityStarterHost, StripeIntent stripeIntent, ApiRequest.Options options, Continuation<Unit> continuation) {
        StripeException stripeException;
        StripeIntent.NextActionData nextActionData = stripeIntent.getNextActionData();
        if (nextActionData == null) {
            stripeException = null;
        } else {
            Class<?> cls = nextActionData.getClass();
            StripeException.Companion companion = StripeException.Companion;
            stripeException = companion.create(new IllegalArgumentException(cls.getSimpleName() + " type is not supported, add " + ACTION_DEPENDENCY_MAP.get(cls) + " in build.gradle to support it"));
        }
        if (stripeException == null) {
            UnsupportedAuthenticator unsupportedAuthenticator = this;
            stripeException = StripeException.Companion.create(new IllegalArgumentException("stripeIntent.nextActionData is null"));
        }
        this.paymentRelayStarterFactory.invoke(authActivityStarterHost).start(new PaymentRelayStarter.Args.ErrorArgs(stripeException, StripeIntentKtxKt.getRequestCode(stripeIntent)));
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R%\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/payments/core/authentication/UnsupportedAuthenticator$Companion;", "", "()V", "ACTION_DEPENDENCY_MAP", "", "Ljava/lang/Class;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "", "getACTION_DEPENDENCY_MAP", "()Ljava/util/Map;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnsupportedAuthenticator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<Class<? extends StripeIntent.NextActionData>, String> getACTION_DEPENDENCY_MAP() {
            return UnsupportedAuthenticator.ACTION_DEPENDENCY_MAP;
        }
    }
}
