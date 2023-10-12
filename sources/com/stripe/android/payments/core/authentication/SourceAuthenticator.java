package com.stripe.android.payments.core.authentication;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import com.stripe.android.PaymentBrowserAuthStarter;
import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.core.injection.UIContext;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.Source;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.authentication.PaymentAuthenticator;
import com.stripe.android.view.AuthActivityStarterHost;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Singleton
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bm\b\u0007\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ+\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010 J)\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010#R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/stripe/android/payments/core/authentication/SourceAuthenticator;", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Lcom/stripe/android/model/Source;", "paymentBrowserAuthStarterFactory", "Lkotlin/Function1;", "Lcom/stripe/android/view/AuthActivityStarterHost;", "Lcom/stripe/android/PaymentBrowserAuthStarter;", "paymentRelayStarterFactory", "Lcom/stripe/android/PaymentRelayStarter;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "enableLogging", "", "uiContext", "Lkotlin/coroutines/CoroutineContext;", "publishableKeyProvider", "Lkotlin/Function0;", "", "isInstantApp", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;ZLkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;Z)V", "authenticate", "", "host", "authenticatable", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/Source;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bypassAuth", "source", "stripeAccountId", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/Source;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startSourceAuth", "paymentBrowserAuthStarter", "(Lcom/stripe/android/PaymentBrowserAuthStarter;Lcom/stripe/android/model/Source;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SourceAuthenticator.kt */
public final class SourceAuthenticator implements PaymentAuthenticator<Source> {
    /* access modifiers changed from: private */
    public final AnalyticsRequestExecutor analyticsRequestExecutor;
    /* access modifiers changed from: private */
    public final boolean enableLogging;
    /* access modifiers changed from: private */
    public final boolean isInstantApp;
    /* access modifiers changed from: private */
    public final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final Function1<AuthActivityStarterHost, PaymentBrowserAuthStarter> paymentBrowserAuthStarterFactory;
    /* access modifiers changed from: private */
    public final Function1<AuthActivityStarterHost, PaymentRelayStarter> paymentRelayStarterFactory;
    /* access modifiers changed from: private */
    public final Function0<String> publishableKeyProvider;
    private final CoroutineContext uiContext;

    @Inject
    public SourceAuthenticator(Function1<AuthActivityStarterHost, PaymentBrowserAuthStarter> function1, Function1<AuthActivityStarterHost, PaymentRelayStarter> function12, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, @Named("enableLogging") boolean z, @UIContext CoroutineContext coroutineContext, @Named("publishableKey") Function0<String> function0, @Named("isInstantApp") boolean z2) {
        Intrinsics.checkNotNullParameter(function1, "paymentBrowserAuthStarterFactory");
        Intrinsics.checkNotNullParameter(function12, "paymentRelayStarterFactory");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(coroutineContext, "uiContext");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        this.paymentBrowserAuthStarterFactory = function1;
        this.paymentRelayStarterFactory = function12;
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
        this.enableLogging = z;
        this.uiContext = coroutineContext;
        this.publishableKeyProvider = function0;
        this.isInstantApp = z2;
    }

    public void onLauncherInvalidated() {
        PaymentAuthenticator.DefaultImpls.onLauncherInvalidated(this);
    }

    public void onNewActivityResultCaller(ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
        PaymentAuthenticator.DefaultImpls.onNewActivityResultCaller(this, activityResultCaller, activityResultCallback);
    }

    public Object authenticate(AuthActivityStarterHost authActivityStarterHost, Source source, ApiRequest.Options options, Continuation<Unit> continuation) {
        if (source.getFlow() == Source.Flow.Redirect) {
            Object startSourceAuth = startSourceAuth(this.paymentBrowserAuthStarterFactory.invoke(authActivityStarterHost), source, options, continuation);
            return startSourceAuth == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? startSourceAuth : Unit.INSTANCE;
        }
        Object bypassAuth = bypassAuth(authActivityStarterHost, source, options.getStripeAccount(), continuation);
        return bypassAuth == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bypassAuth : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object startSourceAuth(PaymentBrowserAuthStarter paymentBrowserAuthStarter, Source source, ApiRequest.Options options, Continuation<Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.uiContext, new SourceAuthenticator$startSourceAuth$2(this, paymentBrowserAuthStarter, source, options, (Continuation<SourceAuthenticator$startSourceAuth$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object bypassAuth(AuthActivityStarterHost authActivityStarterHost, Source source, String str, Continuation<Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.uiContext, new SourceAuthenticator$bypassAuth$2(this, authActivityStarterHost, source, str, (Continuation<SourceAuthenticator$bypassAuth$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
