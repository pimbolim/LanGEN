package com.stripe.android.payments.core.authentication;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import com.stripe.android.PaymentBrowserAuthStarter;
import com.stripe.android.core.injection.UIContext;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.authentication.PaymentAuthenticator;
import com.stripe.android.view.AuthActivityStarterHost;
import java.util.Map;
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
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bm\b\u0007\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u0012\b\b\u0001\u0010\u0014\u001a\u00020\f¢\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJc\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010%\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/stripe/android/payments/core/authentication/WebIntentAuthenticator;", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Lcom/stripe/android/model/StripeIntent;", "paymentBrowserAuthStarterFactory", "Lkotlin/Function1;", "Lcom/stripe/android/view/AuthActivityStarterHost;", "Lcom/stripe/android/PaymentBrowserAuthStarter;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "enableLogging", "", "uiContext", "Lkotlin/coroutines/CoroutineContext;", "threeDs1IntentReturnUrlMap", "", "", "publishableKeyProvider", "Lkotlin/Function0;", "isInstantApp", "(Lkotlin/jvm/functions/Function1;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;ZLkotlin/coroutines/CoroutineContext;Ljava/util/Map;Lkotlin/jvm/functions/Function0;Z)V", "authenticate", "", "host", "authenticatable", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/StripeIntent;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "beginWebAuth", "stripeIntent", "requestCode", "", "clientSecret", "authUrl", "stripeAccount", "returnUrl", "shouldCancelSource", "shouldCancelIntentOnUserNavigation", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/StripeIntent;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebIntentAuthenticator.kt */
public final class WebIntentAuthenticator implements PaymentAuthenticator<StripeIntent> {
    private final AnalyticsRequestExecutor analyticsRequestExecutor;
    /* access modifiers changed from: private */
    public final boolean enableLogging;
    /* access modifiers changed from: private */
    public final boolean isInstantApp;
    private final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    /* access modifiers changed from: private */
    public final Function1<AuthActivityStarterHost, PaymentBrowserAuthStarter> paymentBrowserAuthStarterFactory;
    /* access modifiers changed from: private */
    public final Function0<String> publishableKeyProvider;
    private final Map<String, String> threeDs1IntentReturnUrlMap;
    private final CoroutineContext uiContext;

    @Inject
    public WebIntentAuthenticator(Function1<AuthActivityStarterHost, PaymentBrowserAuthStarter> function1, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, @Named("enableLogging") boolean z, @UIContext CoroutineContext coroutineContext, Map<String, String> map, @Named("publishableKey") Function0<String> function0, @Named("isInstantApp") boolean z2) {
        Intrinsics.checkNotNullParameter(function1, "paymentBrowserAuthStarterFactory");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(coroutineContext, "uiContext");
        Intrinsics.checkNotNullParameter(map, "threeDs1IntentReturnUrlMap");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        this.paymentBrowserAuthStarterFactory = function1;
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
        this.enableLogging = z;
        this.uiContext = coroutineContext;
        this.threeDs1IntentReturnUrlMap = map;
        this.publishableKeyProvider = function0;
        this.isInstantApp = z2;
    }

    public void onLauncherInvalidated() {
        PaymentAuthenticator.DefaultImpls.onLauncherInvalidated(this);
    }

    public void onNewActivityResultCaller(ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
        PaymentAuthenticator.DefaultImpls.onNewActivityResultCaller(this, activityResultCaller, activityResultCallback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object authenticate(com.stripe.android.view.AuthActivityStarterHost r21, com.stripe.android.model.StripeIntent r22, com.stripe.android.core.networking.ApiRequest.Options r23, kotlin.coroutines.Continuation<kotlin.Unit> r24) {
        /*
            r20 = this;
            r11 = r20
            com.stripe.android.model.StripeIntent$NextActionData r0 = r22.getNextActionData()
            boolean r1 = r0 instanceof com.stripe.android.model.StripeIntent.NextActionData.SdkData.Use3DS1
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x003e
            com.stripe.android.model.StripeIntent$NextActionData$SdkData$Use3DS1 r0 = (com.stripe.android.model.StripeIntent.NextActionData.SdkData.Use3DS1) r0
            java.lang.String r0 = r0.getUrl()
            java.lang.String r1 = r22.getId()
            if (r1 != 0) goto L_0x001a
            goto L_0x0023
        L_0x001a:
            java.util.Map<java.lang.String, java.lang.String> r2 = r11.threeDs1IntentReturnUrlMap
            java.lang.Object r1 = r2.remove(r1)
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
        L_0x0023:
            com.stripe.android.core.networking.AnalyticsRequestExecutor r1 = r11.analyticsRequestExecutor
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r12 = r11.paymentAnalyticsRequestFactory
            com.stripe.android.networking.PaymentAnalyticsEvent r13 = com.stripe.android.networking.PaymentAnalyticsEvent.Auth3ds1Sdk
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 30
            r19 = 0
            com.stripe.android.core.networking.AnalyticsRequest r4 = com.stripe.android.networking.PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(r12, r13, r14, r15, r16, r17, r18, r19)
            r1.executeAsync(r4)
            r5 = r0
            r7 = r2
            r8 = 1
            goto L_0x006f
        L_0x003e:
            boolean r1 = r0 instanceof com.stripe.android.model.StripeIntent.NextActionData.RedirectToUrl
            if (r1 == 0) goto L_0x0071
            com.stripe.android.core.networking.AnalyticsRequestExecutor r1 = r11.analyticsRequestExecutor
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r12 = r11.paymentAnalyticsRequestFactory
            com.stripe.android.networking.PaymentAnalyticsEvent r13 = com.stripe.android.networking.PaymentAnalyticsEvent.AuthRedirect
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 30
            r19 = 0
            com.stripe.android.core.networking.AnalyticsRequest r2 = com.stripe.android.networking.PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(r12, r13, r14, r15, r16, r17, r18, r19)
            r1.executeAsync(r2)
            com.stripe.android.model.StripeIntent$NextActionData$RedirectToUrl r0 = (com.stripe.android.model.StripeIntent.NextActionData.RedirectToUrl) r0
            android.net.Uri r1 = r0.getUrl()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "nextActionData.url.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r0 = r0.getReturnUrl()
        L_0x006c:
            r7 = r0
            r5 = r1
            r8 = 0
        L_0x006f:
            r9 = 1
            goto L_0x00c2
        L_0x0071:
            boolean r1 = r0 instanceof com.stripe.android.model.StripeIntent.NextActionData.AlipayRedirect
            if (r1 == 0) goto L_0x00a0
            com.stripe.android.core.networking.AnalyticsRequestExecutor r1 = r11.analyticsRequestExecutor
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r12 = r11.paymentAnalyticsRequestFactory
            com.stripe.android.networking.PaymentAnalyticsEvent r13 = com.stripe.android.networking.PaymentAnalyticsEvent.AuthRedirect
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 30
            r19 = 0
            com.stripe.android.core.networking.AnalyticsRequest r2 = com.stripe.android.networking.PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(r12, r13, r14, r15, r16, r17, r18, r19)
            r1.executeAsync(r2)
            com.stripe.android.model.StripeIntent$NextActionData$AlipayRedirect r0 = (com.stripe.android.model.StripeIntent.NextActionData.AlipayRedirect) r0
            android.net.Uri r1 = r0.getWebViewUrl()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "nextActionData.webViewUrl.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r0 = r0.getReturnUrl()
            goto L_0x006c
        L_0x00a0:
            boolean r1 = r0 instanceof com.stripe.android.model.StripeIntent.NextActionData.DisplayOxxoDetails
            if (r1 == 0) goto L_0x00f5
            com.stripe.android.model.StripeIntent$NextActionData$DisplayOxxoDetails r0 = (com.stripe.android.model.StripeIntent.NextActionData.DisplayOxxoDetails) r0
            java.lang.String r0 = r0.getHostedVoucherUrl()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r3 = 0
        L_0x00b8:
            if (r3 == 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r0 = r2
        L_0x00bc:
            if (r0 == 0) goto L_0x00ed
            r5 = r0
            r7 = r2
            r8 = 0
            r9 = 0
        L_0x00c2:
            com.stripe.android.StripePaymentController$Companion r0 = com.stripe.android.StripePaymentController.Companion
            r2 = r22
            int r3 = r0.getRequestCode$payments_core_release((com.stripe.android.model.StripeIntent) r2)
            java.lang.String r0 = r22.getClientSecret()
            if (r0 != 0) goto L_0x00d2
            java.lang.String r0 = ""
        L_0x00d2:
            r4 = r0
            java.lang.String r6 = r23.getStripeAccount()
            r0 = r20
            r1 = r21
            r2 = r22
            r10 = r24
            java.lang.Object r0 = r0.beginWebAuth(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x00ea
            return r0
        L_0x00ea:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00ed:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "null hostedVoucherUrl for DisplayOxxoDetails"
            r0.<init>(r1)
            throw r0
        L_0x00f5:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "WebAuthenticator can't process nextActionData: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.authentication.WebIntentAuthenticator.authenticate(com.stripe.android.view.AuthActivityStarterHost, com.stripe.android.model.StripeIntent, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object beginWebAuth$default(WebIntentAuthenticator webIntentAuthenticator, AuthActivityStarterHost authActivityStarterHost, StripeIntent stripeIntent, int i, String str, String str2, String str3, String str4, boolean z, boolean z2, Continuation continuation, int i2, Object obj) {
        int i3 = i2;
        return webIntentAuthenticator.beginWebAuth(authActivityStarterHost, stripeIntent, i, str, str2, str3, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? false : z, (i3 & 256) != 0 ? true : z2, continuation);
    }

    /* access modifiers changed from: private */
    public final Object beginWebAuth(AuthActivityStarterHost authActivityStarterHost, StripeIntent stripeIntent, int i, String str, String str2, String str3, String str4, boolean z, boolean z2, Continuation<Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.uiContext, new WebIntentAuthenticator$beginWebAuth$2(this, authActivityStarterHost, stripeIntent, i, str, str2, str4, str3, z, z2, (Continuation<WebIntentAuthenticator$beginWebAuth$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
