package com.stripe.android.payments.paymentlauncher;

import android.app.Application;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.StripeIntentResult;
import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.InjectableKtxKt;
import com.stripe.android.core.injection.UIContext;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.PaymentIntentFlowResultProcessor;
import com.stripe.android.payments.SetupIntentFlowResultProcessor;
import com.stripe.android.payments.core.authentication.PaymentAuthenticatorRegistry;
import com.stripe.android.payments.core.injection.DaggerPaymentLauncherViewModelFactoryComponent;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.payments.core.injection.PaymentLauncherViewModelSubcomponent;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.view.AuthActivityStarterHost;
import dagger.Lazy;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0001\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u0003¢\u0006\u0002\u0010\u001eJ\r\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J#\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010/J\u001d\u00100\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0000¢\u0006\u0002\b3J\u001d\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u000f2\u0006\u00101\u001a\u000202H\u0000¢\u0006\u0002\b6J\u0012\u00107\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010\u000fH\u0002J\u0015\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\b;J\u0016\u0010<\u001a\u00020(2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020+0>H\u0002J\u0015\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020AH\u0000¢\u0006\u0002\bBR\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\u001d\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel;", "Landroidx/lifecycle/ViewModel;", "isPaymentIntent", "", "stripeApiRepository", "Lcom/stripe/android/networking/StripeRepository;", "authenticatorRegistry", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticatorRegistry;", "defaultReturnUrl", "Lcom/stripe/android/payments/DefaultReturnUrl;", "apiRequestOptionsProvider", "Ljavax/inject/Provider;", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "threeDs1IntentReturnUrlMap", "", "", "lazyPaymentIntentFlowResultProcessor", "Ldagger/Lazy;", "Lcom/stripe/android/payments/PaymentIntentFlowResultProcessor;", "lazySetupIntentFlowResultProcessor", "Lcom/stripe/android/payments/SetupIntentFlowResultProcessor;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/DefaultAnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "uiContext", "Lkotlin/coroutines/CoroutineContext;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "isInstantApp", "(ZLcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/payments/core/authentication/PaymentAuthenticatorRegistry;Lcom/stripe/android/payments/DefaultReturnUrl;Ljavax/inject/Provider;Ljava/util/Map;Ldagger/Lazy;Ldagger/Lazy;Lcom/stripe/android/core/networking/DefaultAnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lkotlin/coroutines/CoroutineContext;Landroidx/lifecycle/SavedStateHandle;Z)V", "hasStarted", "getHasStarted", "()Z", "paymentLauncherResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/stripe/android/payments/paymentlauncher/PaymentResult;", "getPaymentLauncherResult$payments_core_release", "()Landroidx/lifecycle/MutableLiveData;", "cleanUp", "", "cleanUp$payments_core_release", "confirmIntent", "Lcom/stripe/android/model/StripeIntent;", "confirmStripeIntentParams", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "returnUrl", "(Lcom/stripe/android/model/ConfirmStripeIntentParams;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmStripeIntent", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "confirmStripeIntent$payments_core_release", "handleNextActionForStripeIntent", "clientSecret", "handleNextActionForStripeIntent$payments_core_release", "logReturnUrl", "onPaymentFlowResult", "paymentFlowResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "onPaymentFlowResult$payments_core_release", "postResult", "stripeIntentResult", "Lcom/stripe/android/StripeIntentResult;", "register", "caller", "Landroidx/activity/result/ActivityResultCaller;", "register$payments_core_release", "Companion", "Factory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncherViewModel.kt */
public final class PaymentLauncherViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> EXPAND_PAYMENT_METHOD = CollectionsKt.listOf("payment_method");
    public static final String KEY_HAS_STARTED = "key_has_started";
    public static final String REQUIRED_ERROR = "API request returned an invalid response.";
    public static final String TIMEOUT_ERROR = "Payment fails due to time out. \n";
    public static final String UNKNOWN_ERROR = "Payment fails due to unknown error. \n";
    private final DefaultAnalyticsRequestExecutor analyticsRequestExecutor;
    /* access modifiers changed from: private */
    public final Provider<ApiRequest.Options> apiRequestOptionsProvider;
    /* access modifiers changed from: private */
    public final PaymentAuthenticatorRegistry authenticatorRegistry;
    /* access modifiers changed from: private */
    public final DefaultReturnUrl defaultReturnUrl;
    /* access modifiers changed from: private */
    public final boolean isInstantApp;
    /* access modifiers changed from: private */
    public final boolean isPaymentIntent;
    /* access modifiers changed from: private */
    public final Lazy<PaymentIntentFlowResultProcessor> lazyPaymentIntentFlowResultProcessor;
    /* access modifiers changed from: private */
    public final Lazy<SetupIntentFlowResultProcessor> lazySetupIntentFlowResultProcessor;
    private final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final MutableLiveData<PaymentResult> paymentLauncherResult = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final SavedStateHandle savedStateHandle;
    /* access modifiers changed from: private */
    public final StripeRepository stripeApiRepository;
    /* access modifiers changed from: private */
    public final Map<String, String> threeDs1IntentReturnUrlMap;
    /* access modifiers changed from: private */
    public final CoroutineContext uiContext;

    @Inject
    public PaymentLauncherViewModel(@Named("isPaymentIntent") boolean z, StripeRepository stripeRepository, PaymentAuthenticatorRegistry paymentAuthenticatorRegistry, DefaultReturnUrl defaultReturnUrl2, Provider<ApiRequest.Options> provider, Map<String, String> map, Lazy<PaymentIntentFlowResultProcessor> lazy, Lazy<SetupIntentFlowResultProcessor> lazy2, DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, @UIContext CoroutineContext coroutineContext, SavedStateHandle savedStateHandle2, @Named("isInstantApp") boolean z2) {
        Intrinsics.checkNotNullParameter(stripeRepository, "stripeApiRepository");
        Intrinsics.checkNotNullParameter(paymentAuthenticatorRegistry, "authenticatorRegistry");
        Intrinsics.checkNotNullParameter(defaultReturnUrl2, "defaultReturnUrl");
        Intrinsics.checkNotNullParameter(provider, "apiRequestOptionsProvider");
        Intrinsics.checkNotNullParameter(map, "threeDs1IntentReturnUrlMap");
        Intrinsics.checkNotNullParameter(lazy, "lazyPaymentIntentFlowResultProcessor");
        Intrinsics.checkNotNullParameter(lazy2, "lazySetupIntentFlowResultProcessor");
        Intrinsics.checkNotNullParameter(defaultAnalyticsRequestExecutor, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(coroutineContext, "uiContext");
        Intrinsics.checkNotNullParameter(savedStateHandle2, "savedStateHandle");
        this.isPaymentIntent = z;
        this.stripeApiRepository = stripeRepository;
        this.authenticatorRegistry = paymentAuthenticatorRegistry;
        this.defaultReturnUrl = defaultReturnUrl2;
        this.apiRequestOptionsProvider = provider;
        this.threeDs1IntentReturnUrlMap = map;
        this.lazyPaymentIntentFlowResultProcessor = lazy;
        this.lazySetupIntentFlowResultProcessor = lazy2;
        this.analyticsRequestExecutor = defaultAnalyticsRequestExecutor;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
        this.uiContext = coroutineContext;
        this.savedStateHandle = savedStateHandle2;
        this.isInstantApp = z2;
    }

    private final boolean getHasStarted() {
        Boolean bool = (Boolean) this.savedStateHandle.get(KEY_HAS_STARTED);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final MutableLiveData<PaymentResult> getPaymentLauncherResult$payments_core_release() {
        return this.paymentLauncherResult;
    }

    public final void register$payments_core_release(ActivityResultCaller activityResultCaller) {
        Intrinsics.checkNotNullParameter(activityResultCaller, "caller");
        this.authenticatorRegistry.onNewActivityResultCaller(activityResultCaller, new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                PaymentLauncherViewModel.this.onPaymentFlowResult$payments_core_release((PaymentFlowResult.Unvalidated) obj);
            }
        });
    }

    public final void confirmStripeIntent$payments_core_release(ConfirmStripeIntentParams confirmStripeIntentParams, AuthActivityStarterHost authActivityStarterHost) {
        Intrinsics.checkNotNullParameter(confirmStripeIntentParams, "confirmStripeIntentParams");
        Intrinsics.checkNotNullParameter(authActivityStarterHost, "host");
        if (!getHasStarted()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PaymentLauncherViewModel$confirmStripeIntent$1(this, confirmStripeIntentParams, authActivityStarterHost, (Continuation<? super PaymentLauncherViewModel$confirmStripeIntent$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object confirmIntent(com.stripe.android.model.ConfirmStripeIntentParams r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.StripeIntent> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel$confirmIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel$confirmIntent$1 r0 = (com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel$confirmIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel$confirmIntent$1 r0 = new com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel$confirmIntent$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0084
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0063
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r8)
            r6.setReturnUrl(r7)
            com.stripe.android.model.ConfirmStripeIntentParams r6 = r6.withShouldUseStripeSdk(r4)
            boolean r7 = r6 instanceof com.stripe.android.model.ConfirmPaymentIntentParams
            java.lang.String r8 = "apiRequestOptionsProvider.get()"
            if (r7 == 0) goto L_0x0066
            com.stripe.android.networking.StripeRepository r7 = r5.stripeApiRepository
            com.stripe.android.model.ConfirmPaymentIntentParams r6 = (com.stripe.android.model.ConfirmPaymentIntentParams) r6
            javax.inject.Provider<com.stripe.android.core.networking.ApiRequest$Options> r2 = r5.apiRequestOptionsProvider
            java.lang.Object r2 = r2.get()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            com.stripe.android.core.networking.ApiRequest$Options r2 = (com.stripe.android.core.networking.ApiRequest.Options) r2
            java.util.List<java.lang.String> r8 = EXPAND_PAYMENT_METHOD
            r0.label = r4
            java.lang.Object r8 = r7.confirmPaymentIntent$payments_core_release(r6, r2, r8, r0)
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x0063:
            com.stripe.android.model.StripeIntent r8 = (com.stripe.android.model.StripeIntent) r8
            goto L_0x0086
        L_0x0066:
            boolean r7 = r6 instanceof com.stripe.android.model.ConfirmSetupIntentParams
            if (r7 == 0) goto L_0x0095
            com.stripe.android.networking.StripeRepository r7 = r5.stripeApiRepository
            com.stripe.android.model.ConfirmSetupIntentParams r6 = (com.stripe.android.model.ConfirmSetupIntentParams) r6
            javax.inject.Provider<com.stripe.android.core.networking.ApiRequest$Options> r2 = r5.apiRequestOptionsProvider
            java.lang.Object r2 = r2.get()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            com.stripe.android.core.networking.ApiRequest$Options r2 = (com.stripe.android.core.networking.ApiRequest.Options) r2
            java.util.List<java.lang.String> r8 = EXPAND_PAYMENT_METHOD
            r0.label = r3
            java.lang.Object r8 = r7.confirmSetupIntent$payments_core_release(r6, r2, r8, r0)
            if (r8 != r1) goto L_0x0084
            return r1
        L_0x0084:
            com.stripe.android.model.StripeIntent r8 = (com.stripe.android.model.StripeIntent) r8
        L_0x0086:
            if (r8 == 0) goto L_0x0089
            return r8
        L_0x0089:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "API request returned an invalid response."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x0095:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel.confirmIntent(com.stripe.android.model.ConfirmStripeIntentParams, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void handleNextActionForStripeIntent$payments_core_release(String str, AuthActivityStarterHost authActivityStarterHost) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(authActivityStarterHost, "host");
        if (!getHasStarted()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PaymentLauncherViewModel$handleNextActionForStripeIntent$1(this, str, authActivityStarterHost, (Continuation<? super PaymentLauncherViewModel$handleNextActionForStripeIntent$1>) null), 3, (Object) null);
        }
    }

    public final void onPaymentFlowResult$payments_core_release(PaymentFlowResult.Unvalidated unvalidated) {
        Intrinsics.checkNotNullParameter(unvalidated, "paymentFlowResult");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PaymentLauncherViewModel$onPaymentFlowResult$1(this, unvalidated, (Continuation<? super PaymentLauncherViewModel$onPaymentFlowResult$1>) null), 3, (Object) null);
    }

    public final void cleanUp$payments_core_release() {
        this.authenticatorRegistry.onLauncherInvalidated();
    }

    /* access modifiers changed from: private */
    public final void postResult(StripeIntentResult<? extends StripeIntent> stripeIntentResult) {
        PaymentResult paymentResult;
        MutableLiveData<PaymentResult> mutableLiveData = this.paymentLauncherResult;
        int outcome = stripeIntentResult.getOutcome();
        if (outcome == 1) {
            paymentResult = PaymentResult.Completed.INSTANCE;
        } else if (outcome == 2) {
            paymentResult = new PaymentResult.Failed(new APIException((StripeError) null, (String) null, 0, stripeIntentResult.getFailureMessage(), (Throwable) null, 23, (DefaultConstructorMarker) null));
        } else if (outcome == 3) {
            paymentResult = PaymentResult.Canceled.INSTANCE;
        } else if (outcome != 4) {
            paymentResult = new PaymentResult.Failed(new APIException((StripeError) null, (String) null, 0, Intrinsics.stringPlus(UNKNOWN_ERROR, stripeIntentResult.getFailureMessage()), (Throwable) null, 23, (DefaultConstructorMarker) null));
        } else {
            paymentResult = new PaymentResult.Failed(new APIException((StripeError) null, (String) null, 0, Intrinsics.stringPlus(TIMEOUT_ERROR, stripeIntentResult.getFailureMessage()), (Throwable) null, 23, (DefaultConstructorMarker) null));
        }
        mutableLiveData.postValue(paymentResult);
    }

    /* access modifiers changed from: private */
    public final void logReturnUrl(String str) {
        PaymentAnalyticsEvent paymentAnalyticsEvent;
        if (Intrinsics.areEqual((Object) str, (Object) this.defaultReturnUrl.getValue())) {
            paymentAnalyticsEvent = PaymentAnalyticsEvent.ConfirmReturnUrlDefault;
        } else if (str == null) {
            paymentAnalyticsEvent = PaymentAnalyticsEvent.ConfirmReturnUrlNull;
        } else {
            paymentAnalyticsEvent = PaymentAnalyticsEvent.ConfirmReturnUrlCustom;
        }
        this.analyticsRequestExecutor.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, paymentAnalyticsEvent, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001 B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ7\u0010\u0013\u001a\u0002H\u0014\"\n\b\u0000\u0010\u0014*\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel$Factory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Lcom/stripe/android/core/injection/Injectable;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel$Factory$FallbackInitializeParam;", "argsSupplier", "Lkotlin/Function0;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "applicationSupplier", "Landroid/app/Application;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/savedstate/SavedStateRegistryOwner;)V", "subComponentBuilderProvider", "Ljavax/inject/Provider;", "Lcom/stripe/android/payments/core/injection/PaymentLauncherViewModelSubcomponent$Builder;", "getSubComponentBuilderProvider", "()Ljavax/inject/Provider;", "setSubComponentBuilderProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "fallbackInitialize", "", "arg", "FallbackInitializeParam", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentLauncherViewModel.kt */
    public static final class Factory extends AbstractSavedStateViewModelFactory implements Injectable<FallbackInitializeParam> {
        private final Function0<Application> applicationSupplier;
        private final Function0<PaymentLauncherContract.Args> argsSupplier;
        @Inject
        public Provider<PaymentLauncherViewModelSubcomponent.Builder> subComponentBuilderProvider;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Factory(Function0<? extends PaymentLauncherContract.Args> function0, Function0<? extends Application> function02, SavedStateRegistryOwner savedStateRegistryOwner) {
            super(savedStateRegistryOwner, (Bundle) null);
            Intrinsics.checkNotNullParameter(function0, "argsSupplier");
            Intrinsics.checkNotNullParameter(function02, "applicationSupplier");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
            this.argsSupplier = function0;
            this.applicationSupplier = function02;
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\nHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006 "}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel$Factory$FallbackInitializeParam;", "", "application", "Landroid/app/Application;", "enableLogging", "", "publishableKey", "", "stripeAccountId", "productUsage", "", "(Landroid/app/Application;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getApplication", "()Landroid/app/Application;", "getEnableLogging", "()Z", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "()Ljava/lang/String;", "getStripeAccountId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentLauncherViewModel.kt */
        public static final class FallbackInitializeParam {
            private final Application application;
            private final boolean enableLogging;
            private final Set<String> productUsage;
            private final String publishableKey;
            private final String stripeAccountId;

            public static /* synthetic */ FallbackInitializeParam copy$default(FallbackInitializeParam fallbackInitializeParam, Application application2, boolean z, String str, String str2, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    application2 = fallbackInitializeParam.application;
                }
                if ((i & 2) != 0) {
                    z = fallbackInitializeParam.enableLogging;
                }
                boolean z2 = z;
                if ((i & 4) != 0) {
                    str = fallbackInitializeParam.publishableKey;
                }
                String str3 = str;
                if ((i & 8) != 0) {
                    str2 = fallbackInitializeParam.stripeAccountId;
                }
                String str4 = str2;
                if ((i & 16) != 0) {
                    set = fallbackInitializeParam.productUsage;
                }
                return fallbackInitializeParam.copy(application2, z2, str3, str4, set);
            }

            public final Application component1() {
                return this.application;
            }

            public final boolean component2() {
                return this.enableLogging;
            }

            public final String component3() {
                return this.publishableKey;
            }

            public final String component4() {
                return this.stripeAccountId;
            }

            public final Set<String> component5() {
                return this.productUsage;
            }

            public final FallbackInitializeParam copy(Application application2, boolean z, String str, String str2, Set<String> set) {
                Intrinsics.checkNotNullParameter(application2, "application");
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new FallbackInitializeParam(application2, z, str, str2, set);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FallbackInitializeParam)) {
                    return false;
                }
                FallbackInitializeParam fallbackInitializeParam = (FallbackInitializeParam) obj;
                return Intrinsics.areEqual((Object) this.application, (Object) fallbackInitializeParam.application) && this.enableLogging == fallbackInitializeParam.enableLogging && Intrinsics.areEqual((Object) this.publishableKey, (Object) fallbackInitializeParam.publishableKey) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) fallbackInitializeParam.stripeAccountId) && Intrinsics.areEqual((Object) this.productUsage, (Object) fallbackInitializeParam.productUsage);
            }

            public int hashCode() {
                int hashCode = this.application.hashCode() * 31;
                boolean z = this.enableLogging;
                if (z) {
                    z = true;
                }
                int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.publishableKey.hashCode()) * 31;
                String str = this.stripeAccountId;
                return ((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.productUsage.hashCode();
            }

            public String toString() {
                return "FallbackInitializeParam(application=" + this.application + ", enableLogging=" + this.enableLogging + ", publishableKey=" + this.publishableKey + ", stripeAccountId=" + this.stripeAccountId + ", productUsage=" + this.productUsage + ')';
            }

            public FallbackInitializeParam(Application application2, boolean z, String str, String str2, Set<String> set) {
                Intrinsics.checkNotNullParameter(application2, "application");
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.application = application2;
                this.enableLogging = z;
                this.publishableKey = str;
                this.stripeAccountId = str2;
                this.productUsage = set;
            }

            public final Application getApplication() {
                return this.application;
            }

            public final boolean getEnableLogging() {
                return this.enableLogging;
            }

            public final String getPublishableKey() {
                return this.publishableKey;
            }

            public final String getStripeAccountId() {
                return this.stripeAccountId;
            }

            public final Set<String> getProductUsage() {
                return this.productUsage;
            }
        }

        public final Provider<PaymentLauncherViewModelSubcomponent.Builder> getSubComponentBuilderProvider() {
            Provider<PaymentLauncherViewModelSubcomponent.Builder> provider = this.subComponentBuilderProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentBuilderProvider");
            return null;
        }

        public final void setSubComponentBuilderProvider(Provider<PaymentLauncherViewModelSubcomponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentBuilderProvider = provider;
        }

        /* access modifiers changed from: protected */
        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
            PaymentLauncherContract.Args invoke = this.argsSupplier.invoke();
            InjectableKtxKt.injectWithFallback(this, invoke.getInjectorKey(), new FallbackInitializeParam(this.applicationSupplier.invoke(), invoke.getEnableLogging(), invoke.getPublishableKey(), invoke.getStripeAccountId(), invoke.getProductUsage()));
            PaymentLauncherViewModelSubcomponent.Builder builder = getSubComponentBuilderProvider().get();
            boolean z = false;
            if (invoke instanceof PaymentLauncherContract.Args.IntentConfirmationArgs) {
                ConfirmStripeIntentParams confirmStripeIntentParams = ((PaymentLauncherContract.Args.IntentConfirmationArgs) invoke).getConfirmStripeIntentParams();
                if (!(confirmStripeIntentParams instanceof ConfirmPaymentIntentParams)) {
                    if (!(confirmStripeIntentParams instanceof ConfirmSetupIntentParams)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return builder.isPaymentIntent(z).savedStateHandle(savedStateHandle).build().getViewModel();
                }
            } else if (!(invoke instanceof PaymentLauncherContract.Args.PaymentIntentNextActionArgs)) {
                if (!(invoke instanceof PaymentLauncherContract.Args.SetupIntentNextActionArgs)) {
                    throw new NoWhenBranchMatchedException();
                }
                return builder.isPaymentIntent(z).savedStateHandle(savedStateHandle).build().getViewModel();
            }
            z = true;
            return builder.isPaymentIntent(z).savedStateHandle(savedStateHandle).build().getViewModel();
        }

        public void fallbackInitialize(FallbackInitializeParam fallbackInitializeParam) {
            Intrinsics.checkNotNullParameter(fallbackInitializeParam, "arg");
            DaggerPaymentLauncherViewModelFactoryComponent.builder().context(fallbackInitializeParam.getApplication()).enableLogging(fallbackInitializeParam.getEnableLogging()).publishableKeyProvider(new PaymentLauncherViewModel$Factory$fallbackInitialize$1(fallbackInitializeParam)).stripeAccountIdProvider(new PaymentLauncherViewModel$Factory$fallbackInitialize$2(fallbackInitializeParam)).productUsage(fallbackInitializeParam.getProductUsage()).build().inject(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel$Companion;", "", "()V", "EXPAND_PAYMENT_METHOD", "", "", "getEXPAND_PAYMENT_METHOD", "()Ljava/util/List;", "KEY_HAS_STARTED", "getKEY_HAS_STARTED$payments_core_release$annotations", "REQUIRED_ERROR", "TIMEOUT_ERROR", "UNKNOWN_ERROR", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentLauncherViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getKEY_HAS_STARTED$payments_core_release$annotations() {
        }

        private Companion() {
        }

        public final List<String> getEXPAND_PAYMENT_METHOD() {
            return PaymentLauncherViewModel.EXPAND_PAYMENT_METHOD;
        }
    }
}
