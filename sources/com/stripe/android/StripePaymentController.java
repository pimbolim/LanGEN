package com.stripe.android;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import com.google.android.instantapps.InstantApps;
import com.stripe.android.PaymentController;
import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.core.Logger;
import com.stripe.android.core.exception.APIConnectionException;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.exception.AuthenticationException;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.Source;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.Token;
import com.stripe.android.networking.AlipayRepository;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.PaymentFlowFailureMessageFactory;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.PaymentIntentFlowResultProcessor;
import com.stripe.android.payments.SetupIntentFlowResultProcessor;
import com.stripe.android.payments.core.authentication.DefaultPaymentAuthenticatorRegistry;
import com.stripe.android.payments.core.authentication.PaymentAuthenticatorRegistry;
import com.stripe.android.view.AuthActivityStarterHost;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 k2\u00020\u0001:\u0001kB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f¢\u0006\u0002\u0010\u0014J)\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u00101J)\u00102\u001a\u00020*2\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u00105J!\u00106\u001a\u00020,2\u0006\u00107\u001a\u0002042\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u00108J!\u00109\u001a\u00020:2\u0006\u00107\u001a\u00020;2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010<J!\u0010=\u001a\u00020>2\u0006\u00103\u001a\u0002042\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u00108J\u0019\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0019\u0010D\u001a\u00020*2\u0006\u0010A\u001a\u00020BH@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0019\u0010E\u001a\u00020F2\u0006\u0010A\u001a\u00020BH@ø\u0001\u0000¢\u0006\u0002\u0010CJ)\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH@ø\u0001\u0000¢\u0006\u0002\u0010NJ)\u0010O\u001a\u00020H2\u0006\u0010I\u001a\u00020#2\u0006\u0010P\u001a\u00020Q2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010RJ\u0012\u0010S\u001a\u00020H2\b\u0010T\u001a\u0004\u0018\u00010\u0006H\u0002J)\u0010U\u001a\u00020H2\u0006\u0010I\u001a\u00020#2\u0006\u0010V\u001a\u00020@2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010WJ\u001e\u0010X\u001a\u00020H2\u0006\u0010Y\u001a\u00020Z2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0016J\u001a\u0010^\u001a\u00020\n2\u0006\u0010J\u001a\u00020K2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010_\u001a\u00020\n2\u0006\u0010J\u001a\u00020K2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010`\u001a\u00020\n2\u0006\u0010J\u001a\u00020K2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J1\u0010a\u001a\u00020H2\u0006\u0010I\u001a\u00020#2\u0006\u0010b\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0006\u0010c\u001a\u00020dH@ø\u0001\u0000¢\u0006\u0002\u0010eJ)\u0010f\u001a\u00020H2\u0006\u0010I\u001a\u00020#2\u0006\u0010V\u001a\u00020@2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010WJ)\u0010g\u001a\u00020H2\u0006\u0010I\u001a\u00020#2\u0006\u00107\u001a\u00020h2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010iJ\b\u0010j\u001a\u00020HH\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006l"}, d2 = {"Lcom/stripe/android/StripePaymentController;", "Lcom/stripe/android/PaymentController;", "context", "Landroid/content/Context;", "publishableKeyProvider", "Lkotlin/Function0;", "", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "enableLogging", "", "workContext", "Lkotlin/coroutines/CoroutineContext;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "alipayRepository", "Lcom/stripe/android/networking/AlipayRepository;", "uiContext", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lcom/stripe/android/networking/StripeRepository;ZLkotlin/coroutines/CoroutineContext;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lcom/stripe/android/networking/AlipayRepository;Lkotlin/coroutines/CoroutineContext;)V", "authenticatorRegistry", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticatorRegistry;", "defaultReturnUrl", "Lcom/stripe/android/payments/DefaultReturnUrl;", "failureMessageFactory", "Lcom/stripe/android/payments/PaymentFlowFailureMessageFactory;", "isInstantApp", "paymentIntentFlowResultProcessor", "Lcom/stripe/android/payments/PaymentIntentFlowResultProcessor;", "paymentRelayLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/PaymentRelayStarter$Args;", "paymentRelayStarterFactory", "Lkotlin/Function1;", "Lcom/stripe/android/view/AuthActivityStarterHost;", "Lcom/stripe/android/PaymentRelayStarter;", "setupIntentFlowResultProcessor", "Lcom/stripe/android/payments/SetupIntentFlowResultProcessor;", "threeDs1IntentReturnUrlMap", "", "authenticateAlipay", "Lcom/stripe/android/PaymentIntentResult;", "paymentIntent", "Lcom/stripe/android/model/PaymentIntent;", "authenticator", "Lcom/stripe/android/AlipayAuthenticator;", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/model/PaymentIntent;Lcom/stripe/android/AlipayAuthenticator;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmAndAuthenticateAlipay", "confirmPaymentIntentParams", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams;Lcom/stripe/android/AlipayAuthenticator;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPaymentIntent", "confirmStripeIntentParams", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmSetupIntent", "Lcom/stripe/android/model/SetupIntent;", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "(Lcom/stripe/android/model/ConfirmSetupIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmWeChatPay", "Lcom/stripe/android/model/WeChatPayNextAction;", "getAuthenticateSourceResult", "Lcom/stripe/android/model/Source;", "data", "Landroid/content/Intent;", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentIntentResult", "getSetupIntentResult", "Lcom/stripe/android/SetupIntentResult;", "handleError", "", "host", "requestCode", "", "throwable", "", "(Lcom/stripe/android/view/AuthActivityStarterHost;ILjava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleNextAction", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/StripeIntent;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logReturnUrl", "returnUrl", "onSourceRetrieved", "source", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/Source;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerLaunchersWithActivityResultCaller", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "activityResultCallback", "Landroidx/activity/result/ActivityResultCallback;", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "shouldHandlePaymentResult", "shouldHandleSetupResult", "shouldHandleSourceResult", "startAuth", "clientSecret", "type", "Lcom/stripe/android/PaymentController$StripeIntentType;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lcom/stripe/android/PaymentController$StripeIntentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAuthenticateSource", "startConfirmAndAuth", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/ConfirmStripeIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterLaunchers", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripePaymentController.kt */
public final class StripePaymentController implements PaymentController {
    /* access modifiers changed from: private */
    public static final long CHALLENGE_DELAY = TimeUnit.SECONDS.toMillis(2);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> EXPAND_PAYMENT_METHOD = CollectionsKt.listOf("payment_method");
    public static final int PAYMENT_REQUEST_CODE = 50000;
    private static final String REQUIRED_ERROR = "API request returned an invalid response.";
    public static final int SETUP_REQUEST_CODE = 50001;
    public static final int SOURCE_REQUEST_CODE = 50002;
    private final AlipayRepository alipayRepository;
    private final AnalyticsRequestExecutor analyticsRequestExecutor;
    private final PaymentAuthenticatorRegistry authenticatorRegistry;
    private final DefaultReturnUrl defaultReturnUrl;
    private final boolean enableLogging;
    private final PaymentFlowFailureMessageFactory failureMessageFactory;
    private final boolean isInstantApp;
    private final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final PaymentIntentFlowResultProcessor paymentIntentFlowResultProcessor;
    /* access modifiers changed from: private */
    public ActivityResultLauncher<PaymentRelayStarter.Args> paymentRelayLauncher;
    /* access modifiers changed from: private */
    public final Function1<AuthActivityStarterHost, PaymentRelayStarter> paymentRelayStarterFactory;
    private final Function0<String> publishableKeyProvider;
    private final SetupIntentFlowResultProcessor setupIntentFlowResultProcessor;
    private final StripeRepository stripeRepository;
    private final Map<String, String> threeDs1IntentReturnUrlMap;
    private final CoroutineContext uiContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripePaymentController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentController.StripeIntentType.values().length];
            iArr[PaymentController.StripeIntentType.PaymentIntent.ordinal()] = 1;
            iArr[PaymentController.StripeIntentType.SetupIntent.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final PaymentController create(Context context, String str, StripeRepository stripeRepository2) {
        return Companion.create(context, str, stripeRepository2);
    }

    @JvmStatic
    public static final PaymentController create(Context context, String str, StripeRepository stripeRepository2, boolean z) {
        return Companion.create(context, str, stripeRepository2, z);
    }

    public boolean shouldHandlePaymentResult(int i, Intent intent) {
        return i == 50000 && intent != null;
    }

    public boolean shouldHandleSetupResult(int i, Intent intent) {
        return i == 50001 && intent != null;
    }

    public boolean shouldHandleSourceResult(int i, Intent intent) {
        return i == 50002 && intent != null;
    }

    public StripePaymentController(Context context, Function0<String> function0, StripeRepository stripeRepository2, boolean z, CoroutineContext coroutineContext, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, AlipayRepository alipayRepository2, CoroutineContext coroutineContext2) {
        Context context2 = context;
        Function0<String> function02 = function0;
        StripeRepository stripeRepository3 = stripeRepository2;
        boolean z2 = z;
        AnalyticsRequestExecutor analyticsRequestExecutor3 = analyticsRequestExecutor2;
        PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory3 = paymentAnalyticsRequestFactory2;
        AlipayRepository alipayRepository3 = alipayRepository2;
        CoroutineContext coroutineContext3 = coroutineContext2;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function02, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(stripeRepository3, "stripeRepository");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor3, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory3, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(alipayRepository3, "alipayRepository");
        Intrinsics.checkNotNullParameter(coroutineContext3, "uiContext");
        this.publishableKeyProvider = function02;
        this.stripeRepository = stripeRepository3;
        this.enableLogging = z2;
        this.analyticsRequestExecutor = analyticsRequestExecutor3;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory3;
        this.alipayRepository = alipayRepository3;
        this.uiContext = coroutineContext3;
        this.failureMessageFactory = new PaymentFlowFailureMessageFactory(context2);
        Context context3 = context;
        Function0<String> function03 = function0;
        StripeRepository stripeRepository4 = stripeRepository2;
        CoroutineContext coroutineContext4 = coroutineContext;
        PaymentIntentFlowResultProcessor paymentIntentFlowResultProcessor2 = r1;
        PaymentIntentFlowResultProcessor paymentIntentFlowResultProcessor3 = new PaymentIntentFlowResultProcessor(context3, function03, stripeRepository4, Logger.Companion.getInstance(z2), coroutineContext4, new RetryDelaySupplier());
        this.paymentIntentFlowResultProcessor = paymentIntentFlowResultProcessor2;
        this.setupIntentFlowResultProcessor = new SetupIntentFlowResultProcessor(context3, function03, stripeRepository4, Logger.Companion.getInstance(z2), coroutineContext4);
        this.defaultReturnUrl = DefaultReturnUrl.Companion.create(context2);
        boolean isInstantApp2 = InstantApps.isInstantApp(context);
        this.isInstantApp = isInstantApp2;
        this.paymentRelayStarterFactory = new StripePaymentController$paymentRelayStarterFactory$1(this);
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        this.threeDs1IntentReturnUrlMap = linkedHashMap;
        this.authenticatorRegistry = DefaultPaymentAuthenticatorRegistry.Companion.createInstance(context3, stripeRepository2, analyticsRequestExecutor2, paymentAnalyticsRequestFactory2, z, coroutineContext, coroutineContext2, linkedHashMap, function02, paymentAnalyticsRequestFactory2.getDefaultProductUsageTokens$payments_core_release(), isInstantApp2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ StripePaymentController(android.content.Context r13, kotlin.jvm.functions.Function0 r14, com.stripe.android.networking.StripeRepository r15, boolean r16, kotlin.coroutines.CoroutineContext r17, com.stripe.android.core.networking.AnalyticsRequestExecutor r18, com.stripe.android.networking.PaymentAnalyticsRequestFactory r19, com.stripe.android.networking.AlipayRepository r20, kotlin.coroutines.CoroutineContext r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r6 = 0
            goto L_0x000b
        L_0x0009:
            r6 = r16
        L_0x000b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0017
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r7 = r1
            goto L_0x0019
        L_0x0017:
            r7 = r17
        L_0x0019:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002c
            com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor r1 = new com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor
            com.stripe.android.core.Logger$Companion r2 = com.stripe.android.core.Logger.Companion
            com.stripe.android.core.Logger r2 = r2.getInstance(r6)
            r1.<init>(r2, r7)
            com.stripe.android.core.networking.AnalyticsRequestExecutor r1 = (com.stripe.android.core.networking.AnalyticsRequestExecutor) r1
            r8 = r1
            goto L_0x002e
        L_0x002c:
            r8 = r18
        L_0x002e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0048
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r1 = new com.stripe.android.networking.PaymentAnalyticsRequestFactory
            android.content.Context r2 = r13.getApplicationContext()
            java.lang.String r3 = "constructor(\n    context…nvalid response.\"\n    }\n}"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.stripe.android.-$$Lambda$StripePaymentController$5PMbu-ciGAWkPN8Lbgm3JEUC62Q r3 = new com.stripe.android.-$$Lambda$StripePaymentController$5PMbu-ciGAWkPN8Lbgm3JEUC62Q
            r4 = r14
            r3.<init>()
            r1.<init>(r2, r3)
            r9 = r1
            goto L_0x004b
        L_0x0048:
            r4 = r14
            r9 = r19
        L_0x004b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0059
            com.stripe.android.networking.DefaultAlipayRepository r1 = new com.stripe.android.networking.DefaultAlipayRepository
            r5 = r15
            r1.<init>(r15)
            com.stripe.android.networking.AlipayRepository r1 = (com.stripe.android.networking.AlipayRepository) r1
            r10 = r1
            goto L_0x005c
        L_0x0059:
            r5 = r15
            r10 = r20
        L_0x005c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0068
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            r11 = r0
            goto L_0x006a
        L_0x0068:
            r11 = r21
        L_0x006a:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.<init>(android.content.Context, kotlin.jvm.functions.Function0, com.stripe.android.networking.StripeRepository, boolean, kotlin.coroutines.CoroutineContext, com.stripe.android.core.networking.AnalyticsRequestExecutor, com.stripe.android.networking.PaymentAnalyticsRequestFactory, com.stripe.android.networking.AlipayRepository, kotlin.coroutines.CoroutineContext, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final String m4283_init_$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        return (String) function0.invoke();
    }

    public void registerLaunchersWithActivityResultCaller(ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
        Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
        Intrinsics.checkNotNullParameter(activityResultCallback, "activityResultCallback");
        this.paymentRelayLauncher = activityResultCaller.registerForActivityResult(new PaymentRelayContract(), activityResultCallback);
        this.authenticatorRegistry.onNewActivityResultCaller(activityResultCaller, activityResultCallback);
    }

    public void unregisterLaunchers() {
        ActivityResultLauncher<PaymentRelayStarter.Args> activityResultLauncher = this.paymentRelayLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
        this.paymentRelayLauncher = null;
        this.authenticatorRegistry.onLauncherInvalidated();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: com.stripe.android.core.networking.ApiRequest$Options} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: com.stripe.android.core.networking.ApiRequest$Options} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x00d8=Splitter:B:45:0x00d8, B:55:0x00fe=Splitter:B:55:0x00fe} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object startConfirmAndAuth(com.stripe.android.view.AuthActivityStarterHost r11, com.stripe.android.model.ConfirmStripeIntentParams r12, com.stripe.android.core.networking.ApiRequest.Options r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stripe.android.StripePaymentController$startConfirmAndAuth$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.stripe.android.StripePaymentController$startConfirmAndAuth$1 r0 = (com.stripe.android.StripePaymentController$startConfirmAndAuth$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripePaymentController$startConfirmAndAuth$1 r0 = new com.stripe.android.StripePaymentController$startConfirmAndAuth$1
            r0.<init>(r10, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0080
            if (r2 == r6) goto L_0x005c
            if (r2 == r5) goto L_0x003e
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            goto L_0x0039
        L_0x0031:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0166
        L_0x003e:
            java.lang.Object r11 = r0.L$4
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r0.L$3
            r13 = r12
            com.stripe.android.core.networking.ApiRequest$Options r13 = (com.stripe.android.core.networking.ApiRequest.Options) r13
            java.lang.Object r12 = r0.L$2
            com.stripe.android.model.ConfirmStripeIntentParams r12 = (com.stripe.android.model.ConfirmStripeIntentParams) r12
            java.lang.Object r2 = r0.L$1
            com.stripe.android.view.AuthActivityStarterHost r2 = (com.stripe.android.view.AuthActivityStarterHost) r2
            java.lang.Object r5 = r0.L$0
            com.stripe.android.StripePaymentController r5 = (com.stripe.android.StripePaymentController) r5
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0079 }
            r9 = r14
            r14 = r11
            r11 = r2
            r2 = r9
            goto L_0x00fe
        L_0x005c:
            java.lang.Object r11 = r0.L$4
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r0.L$3
            r13 = r12
            com.stripe.android.core.networking.ApiRequest$Options r13 = (com.stripe.android.core.networking.ApiRequest.Options) r13
            java.lang.Object r12 = r0.L$2
            com.stripe.android.model.ConfirmStripeIntentParams r12 = (com.stripe.android.model.ConfirmStripeIntentParams) r12
            java.lang.Object r2 = r0.L$1
            com.stripe.android.view.AuthActivityStarterHost r2 = (com.stripe.android.view.AuthActivityStarterHost) r2
            java.lang.Object r5 = r0.L$0
            com.stripe.android.StripePaymentController r5 = (com.stripe.android.StripePaymentController) r5
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0079 }
            r9 = r14
            r14 = r11
            r11 = r2
            r2 = r9
            goto L_0x00d8
        L_0x0079:
            r14 = move-exception
            r9 = r14
            r14 = r11
            r11 = r2
            r2 = r9
            goto L_0x010d
        L_0x0080:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.String r14 = r12.getReturnUrl()
            r10.logReturnUrl(r14)
            boolean r14 = r10.isInstantApp
            if (r14 == 0) goto L_0x0093
            java.lang.String r14 = r12.getReturnUrl()
            goto L_0x00b2
        L_0x0093:
            java.lang.String r14 = r12.getReturnUrl()
            r2 = r14
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x00a5
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            r2 = 0
            goto L_0x00a6
        L_0x00a5:
            r2 = 1
        L_0x00a6:
            if (r2 != 0) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            r14 = r7
        L_0x00aa:
            if (r14 != 0) goto L_0x00b2
            com.stripe.android.payments.DefaultReturnUrl r14 = r10.defaultReturnUrl
            java.lang.String r14 = r14.getValue()
        L_0x00b2:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x010b }
            r2 = r10
            com.stripe.android.StripePaymentController r2 = (com.stripe.android.StripePaymentController) r2     // Catch:{ all -> 0x010b }
            boolean r8 = r12 instanceof com.stripe.android.model.ConfirmPaymentIntentParams     // Catch:{ all -> 0x010b }
            if (r8 == 0) goto L_0x00dd
            r5 = r12
            com.stripe.android.model.ConfirmPaymentIntentParams r5 = (com.stripe.android.model.ConfirmPaymentIntentParams) r5     // Catch:{ all -> 0x010b }
            r5.setReturnUrl(r14)     // Catch:{ all -> 0x010b }
            r5 = r12
            com.stripe.android.model.ConfirmPaymentIntentParams r5 = (com.stripe.android.model.ConfirmPaymentIntentParams) r5     // Catch:{ all -> 0x010b }
            r0.L$0 = r10     // Catch:{ all -> 0x010b }
            r0.L$1 = r11     // Catch:{ all -> 0x010b }
            r0.L$2 = r12     // Catch:{ all -> 0x010b }
            r0.L$3 = r13     // Catch:{ all -> 0x010b }
            r0.L$4 = r14     // Catch:{ all -> 0x010b }
            r0.label = r6     // Catch:{ all -> 0x010b }
            java.lang.Object r2 = r2.confirmPaymentIntent(r5, r13, r0)     // Catch:{ all -> 0x010b }
            if (r2 != r1) goto L_0x00d7
            return r1
        L_0x00d7:
            r5 = r10
        L_0x00d8:
            com.stripe.android.model.StripeIntent r2 = (com.stripe.android.model.StripeIntent) r2     // Catch:{ all -> 0x00db }
            goto L_0x0100
        L_0x00db:
            r2 = move-exception
            goto L_0x010d
        L_0x00dd:
            boolean r6 = r12 instanceof com.stripe.android.model.ConfirmSetupIntentParams     // Catch:{ all -> 0x010b }
            if (r6 == 0) goto L_0x0105
            r6 = r12
            com.stripe.android.model.ConfirmSetupIntentParams r6 = (com.stripe.android.model.ConfirmSetupIntentParams) r6     // Catch:{ all -> 0x010b }
            r6.setReturnUrl(r14)     // Catch:{ all -> 0x010b }
            r6 = r12
            com.stripe.android.model.ConfirmSetupIntentParams r6 = (com.stripe.android.model.ConfirmSetupIntentParams) r6     // Catch:{ all -> 0x010b }
            r0.L$0 = r10     // Catch:{ all -> 0x010b }
            r0.L$1 = r11     // Catch:{ all -> 0x010b }
            r0.L$2 = r12     // Catch:{ all -> 0x010b }
            r0.L$3 = r13     // Catch:{ all -> 0x010b }
            r0.L$4 = r14     // Catch:{ all -> 0x010b }
            r0.label = r5     // Catch:{ all -> 0x010b }
            java.lang.Object r2 = r2.confirmSetupIntent(r6, r13, r0)     // Catch:{ all -> 0x010b }
            if (r2 != r1) goto L_0x00fd
            return r1
        L_0x00fd:
            r5 = r10
        L_0x00fe:
            com.stripe.android.model.StripeIntent r2 = (com.stripe.android.model.StripeIntent) r2     // Catch:{ all -> 0x00db }
        L_0x0100:
            java.lang.Object r2 = kotlin.Result.m4709constructorimpl(r2)     // Catch:{ all -> 0x00db }
            goto L_0x0117
        L_0x0105:
            kotlin.NoWhenBranchMatchedException r2 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x010b }
            r2.<init>()     // Catch:{ all -> 0x010b }
            throw r2     // Catch:{ all -> 0x010b }
        L_0x010b:
            r2 = move-exception
            r5 = r10
        L_0x010d:
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            java.lang.Object r2 = kotlin.Result.m4709constructorimpl(r2)
        L_0x0117:
            java.lang.Throwable r6 = kotlin.Result.m4712exceptionOrNullimpl(r2)
            if (r6 != 0) goto L_0x014d
            com.stripe.android.model.StripeIntent r2 = (com.stripe.android.model.StripeIntent) r2
            com.stripe.android.model.StripeIntent$NextActionData r12 = r2.getNextActionData()
            if (r12 != 0) goto L_0x0126
            goto L_0x013a
        L_0x0126:
            boolean r12 = r12 instanceof com.stripe.android.model.StripeIntent.NextActionData.SdkData.Use3DS1
            if (r12 == 0) goto L_0x013a
            java.lang.String r12 = r2.getId()
            if (r12 != 0) goto L_0x0131
            goto L_0x013a
        L_0x0131:
            java.util.Map<java.lang.String, java.lang.String> r3 = r5.threeDs1IntentReturnUrlMap
            if (r14 != 0) goto L_0x0137
            java.lang.String r14 = ""
        L_0x0137:
            r3.put(r12, r14)
        L_0x013a:
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r7
            r0.L$4 = r7
            r0.label = r4
            java.lang.Object r11 = r5.handleNextAction(r11, r2, r13, r0)
            if (r11 != r1) goto L_0x0166
            return r1
        L_0x014d:
            com.stripe.android.StripePaymentController$Companion r13 = Companion
            int r12 = r13.getRequestCode$payments_core_release((com.stripe.android.model.ConfirmStripeIntentParams) r12)
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r7
            r0.L$4 = r7
            r0.label = r3
            java.lang.Object r11 = r5.handleError(r11, r12, r6, r0)
            if (r11 != r1) goto L_0x0166
            return r1
        L_0x0166:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.startConfirmAndAuth(com.stripe.android.view.AuthActivityStarterHost, com.stripe.android.model.ConfirmStripeIntentParams, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.stripe.android.core.networking.ApiRequest$Options} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object confirmAndAuthenticateAlipay(com.stripe.android.model.ConfirmPaymentIntentParams r6, com.stripe.android.AlipayAuthenticator r7, com.stripe.android.core.networking.ApiRequest.Options r8, kotlin.coroutines.Continuation<? super com.stripe.android.PaymentIntentResult> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stripe.android.StripePaymentController$confirmAndAuthenticateAlipay$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.stripe.android.StripePaymentController$confirmAndAuthenticateAlipay$1 r0 = (com.stripe.android.StripePaymentController$confirmAndAuthenticateAlipay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripePaymentController$confirmAndAuthenticateAlipay$1 r0 = new com.stripe.android.StripePaymentController$confirmAndAuthenticateAlipay$1
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$2
            com.stripe.android.StripePaymentController r6 = (com.stripe.android.StripePaymentController) r6
            java.lang.Object r7 = r0.L$1
            r8 = r7
            com.stripe.android.core.networking.ApiRequest$Options r8 = (com.stripe.android.core.networking.ApiRequest.Options) r8
            java.lang.Object r7 = r0.L$0
            com.stripe.android.AlipayAuthenticator r7 = (com.stripe.android.AlipayAuthenticator) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0059
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r5
            r0.label = r4
            java.lang.Object r9 = r5.confirmPaymentIntent(r6, r8, r0)
            if (r9 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r6 = r5
        L_0x0059:
            com.stripe.android.model.PaymentIntent r9 = (com.stripe.android.model.PaymentIntent) r9
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r9 = r6.authenticateAlipay(r9, r7, r8, r0)
            if (r9 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.confirmAndAuthenticateAlipay(com.stripe.android.model.ConfirmPaymentIntentParams, com.stripe.android.AlipayAuthenticator, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object confirmWeChatPay(com.stripe.android.model.ConfirmPaymentIntentParams r5, com.stripe.android.core.networking.ApiRequest.Options r6, kotlin.coroutines.Continuation<? super com.stripe.android.model.WeChatPayNextAction> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stripe.android.StripePaymentController$confirmWeChatPay$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.StripePaymentController$confirmWeChatPay$1 r0 = (com.stripe.android.StripePaymentController$confirmWeChatPay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripePaymentController$confirmWeChatPay$1 r0 = new com.stripe.android.StripePaymentController$confirmWeChatPay$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003e
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.label = r3
            java.lang.Object r7 = r4.confirmPaymentIntent(r5, r6, r0)
            if (r7 != r1) goto L_0x003e
            return r1
        L_0x003e:
            com.stripe.android.model.PaymentIntent r7 = (com.stripe.android.model.PaymentIntent) r7
            com.stripe.android.model.StripeIntent$NextActionData r5 = r7.getNextActionData()
            boolean r5 = r5 instanceof com.stripe.android.model.StripeIntent.NextActionData.WeChatPayRedirect
            if (r5 == 0) goto L_0x0058
            com.stripe.android.model.WeChatPayNextAction r5 = new com.stripe.android.model.WeChatPayNextAction
            com.stripe.android.model.StripeIntent$NextActionData r6 = r7.getNextActionData()
            com.stripe.android.model.StripeIntent$NextActionData$WeChatPayRedirect r6 = (com.stripe.android.model.StripeIntent.NextActionData.WeChatPayRedirect) r6
            com.stripe.android.model.WeChat r6 = r6.getWeChat()
            r5.<init>(r7, r6)
            return r5
        L_0x0058:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Unable to confirm Payment Intent with WeChatPay SDK"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.confirmWeChatPay(com.stripe.android.model.ConfirmPaymentIntentParams, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object confirmPaymentIntent(com.stripe.android.model.ConfirmPaymentIntentParams r5, com.stripe.android.core.networking.ApiRequest.Options r6, kotlin.coroutines.Continuation<? super com.stripe.android.model.PaymentIntent> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stripe.android.StripePaymentController$confirmPaymentIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.StripePaymentController$confirmPaymentIntent$1 r0 = (com.stripe.android.StripePaymentController$confirmPaymentIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripePaymentController$confirmPaymentIntent$1 r0 = new com.stripe.android.StripePaymentController$confirmPaymentIntent$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0046
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            com.stripe.android.networking.StripeRepository r7 = r4.stripeRepository
            com.stripe.android.model.ConfirmPaymentIntentParams r5 = r5.withShouldUseStripeSdk((boolean) r3)
            java.util.List<java.lang.String> r2 = EXPAND_PAYMENT_METHOD
            r0.label = r3
            java.lang.Object r7 = r7.confirmPaymentIntent$payments_core_release(r5, r6, r2, r0)
            if (r7 != r1) goto L_0x0046
            return r1
        L_0x0046:
            if (r7 == 0) goto L_0x0049
            return r7
        L_0x0049:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "API request returned an invalid response."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.confirmPaymentIntent(com.stripe.android.model.ConfirmPaymentIntentParams, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object confirmSetupIntent(com.stripe.android.model.ConfirmSetupIntentParams r5, com.stripe.android.core.networking.ApiRequest.Options r6, kotlin.coroutines.Continuation<? super com.stripe.android.model.SetupIntent> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stripe.android.StripePaymentController$confirmSetupIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.StripePaymentController$confirmSetupIntent$1 r0 = (com.stripe.android.StripePaymentController$confirmSetupIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripePaymentController$confirmSetupIntent$1 r0 = new com.stripe.android.StripePaymentController$confirmSetupIntent$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0046
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            com.stripe.android.networking.StripeRepository r7 = r4.stripeRepository
            com.stripe.android.model.ConfirmSetupIntentParams r5 = r5.withShouldUseStripeSdk((boolean) r3)
            java.util.List<java.lang.String> r2 = EXPAND_PAYMENT_METHOD
            r0.label = r3
            java.lang.Object r7 = r7.confirmSetupIntent$payments_core_release(r5, r6, r2, r0)
            if (r7 != r1) goto L_0x0046
            return r1
        L_0x0046:
            if (r7 == 0) goto L_0x0049
            return r7
        L_0x0049:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "API request returned an invalid response."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.confirmSetupIntent(com.stripe.android.model.ConfirmSetupIntentParams, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e0 A[Catch:{ all -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e5 A[Catch:{ all -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x00b5=Splitter:B:37:0x00b5, B:47:0x00dc=Splitter:B:47:0x00dc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object startAuth(com.stripe.android.view.AuthActivityStarterHost r18, java.lang.String r19, com.stripe.android.core.networking.ApiRequest.Options r20, com.stripe.android.PaymentController.StripeIntentType r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r10 = r20
            r11 = r21
            r0 = r22
            boolean r3 = r0 instanceof com.stripe.android.StripePaymentController$startAuth$1
            if (r3 == 0) goto L_0x001e
            r3 = r0
            com.stripe.android.StripePaymentController$startAuth$1 r3 = (com.stripe.android.StripePaymentController$startAuth$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001e
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x0023
        L_0x001e:
            com.stripe.android.StripePaymentController$startAuth$1 r3 = new com.stripe.android.StripePaymentController$startAuth$1
            r3.<init>(r1, r0)
        L_0x0023:
            r12 = r3
            java.lang.Object r0 = r12.result
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r12.label
            r14 = 4
            r15 = 3
            r9 = 2
            r8 = 1
            if (r3 == 0) goto L_0x0080
            if (r3 == r8) goto L_0x0060
            if (r3 == r9) goto L_0x0048
            if (r3 == r15) goto L_0x0043
            if (r3 != r14) goto L_0x003b
            goto L_0x0043
        L_0x003b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0148
        L_0x0048:
            java.lang.Object r2 = r12.L$3
            com.stripe.android.PaymentController$StripeIntentType r2 = (com.stripe.android.PaymentController.StripeIntentType) r2
            java.lang.Object r3 = r12.L$2
            com.stripe.android.core.networking.ApiRequest$Options r3 = (com.stripe.android.core.networking.ApiRequest.Options) r3
            java.lang.Object r4 = r12.L$1
            com.stripe.android.view.AuthActivityStarterHost r4 = (com.stripe.android.view.AuthActivityStarterHost) r4
            java.lang.Object r5 = r12.L$0
            com.stripe.android.StripePaymentController r5 = (com.stripe.android.StripePaymentController) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0079 }
            r11 = r2
            r10 = r3
            r2 = r4
            r14 = 1
            goto L_0x00b5
        L_0x0060:
            java.lang.Object r2 = r12.L$3
            com.stripe.android.PaymentController$StripeIntentType r2 = (com.stripe.android.PaymentController.StripeIntentType) r2
            java.lang.Object r3 = r12.L$2
            com.stripe.android.core.networking.ApiRequest$Options r3 = (com.stripe.android.core.networking.ApiRequest.Options) r3
            java.lang.Object r4 = r12.L$1
            com.stripe.android.view.AuthActivityStarterHost r4 = (com.stripe.android.view.AuthActivityStarterHost) r4
            java.lang.Object r5 = r12.L$0
            com.stripe.android.StripePaymentController r5 = (com.stripe.android.StripePaymentController) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0079 }
            r11 = r2
            r10 = r3
            r2 = r4
            r14 = 1
            goto L_0x00dc
        L_0x0079:
            r0 = move-exception
            r11 = r2
            r10 = r3
            r2 = r4
            r14 = 1
            goto L_0x00f8
        L_0x0080:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00f5 }
            r0 = r1
            com.stripe.android.StripePaymentController r0 = (com.stripe.android.StripePaymentController) r0     // Catch:{ all -> 0x00f5 }
            int[] r3 = com.stripe.android.StripePaymentController.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x00f5 }
            int r4 = r21.ordinal()     // Catch:{ all -> 0x00f5 }
            r3 = r3[r4]     // Catch:{ all -> 0x00f5 }
            if (r3 == r8) goto L_0x00bf
            if (r3 != r9) goto L_0x00b8
            com.stripe.android.networking.StripeRepository r3 = r0.stripeRepository     // Catch:{ all -> 0x00f5 }
            r6 = 0
            r0 = 4
            r16 = 0
            r12.L$0 = r1     // Catch:{ all -> 0x00f5 }
            r12.L$1 = r2     // Catch:{ all -> 0x00f5 }
            r12.L$2 = r10     // Catch:{ all -> 0x00f5 }
            r12.L$3 = r11     // Catch:{ all -> 0x00f5 }
            r12.label = r9     // Catch:{ all -> 0x00f5 }
            r4 = r19
            r5 = r20
            r7 = r12
            r14 = 1
            r8 = r0
            r9 = r16
            java.lang.Object r0 = com.stripe.android.networking.StripeRepository.retrieveSetupIntent$default(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00f3 }
            if (r0 != r13) goto L_0x00b4
            return r13
        L_0x00b4:
            r5 = r1
        L_0x00b5:
            com.stripe.android.model.StripeIntent r0 = (com.stripe.android.model.StripeIntent) r0     // Catch:{ all -> 0x00f1 }
            goto L_0x00de
        L_0x00b8:
            r14 = 1
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x00f3 }
            r0.<init>()     // Catch:{ all -> 0x00f3 }
            throw r0     // Catch:{ all -> 0x00f3 }
        L_0x00bf:
            r14 = 1
            com.stripe.android.networking.StripeRepository r3 = r0.stripeRepository     // Catch:{ all -> 0x00f3 }
            r6 = 0
            r8 = 4
            r9 = 0
            r12.L$0 = r1     // Catch:{ all -> 0x00f3 }
            r12.L$1 = r2     // Catch:{ all -> 0x00f3 }
            r12.L$2 = r10     // Catch:{ all -> 0x00f3 }
            r12.L$3 = r11     // Catch:{ all -> 0x00f3 }
            r12.label = r14     // Catch:{ all -> 0x00f3 }
            r4 = r19
            r5 = r20
            r7 = r12
            java.lang.Object r0 = com.stripe.android.networking.StripeRepository.retrievePaymentIntent$default(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00f3 }
            if (r0 != r13) goto L_0x00db
            return r13
        L_0x00db:
            r5 = r1
        L_0x00dc:
            com.stripe.android.model.StripeIntent r0 = (com.stripe.android.model.StripeIntent) r0     // Catch:{ all -> 0x00f1 }
        L_0x00de:
            if (r0 == 0) goto L_0x00e5
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x00f1 }
            goto L_0x0102
        L_0x00e5:
            java.lang.String r0 = "Required value was null."
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00f1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f1 }
            r3.<init>(r0)     // Catch:{ all -> 0x00f1 }
            throw r3     // Catch:{ all -> 0x00f1 }
        L_0x00f1:
            r0 = move-exception
            goto L_0x00f8
        L_0x00f3:
            r0 = move-exception
            goto L_0x00f7
        L_0x00f5:
            r0 = move-exception
            r14 = 1
        L_0x00f7:
            r5 = r1
        L_0x00f8:
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0102:
            java.lang.Throwable r3 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            r4 = 0
            if (r3 != 0) goto L_0x011c
            com.stripe.android.model.StripeIntent r0 = (com.stripe.android.model.StripeIntent) r0
            r12.L$0 = r4
            r12.L$1 = r4
            r12.L$2 = r4
            r12.L$3 = r4
            r12.label = r15
            java.lang.Object r0 = r5.handleNextAction(r2, r0, r10, r12)
            if (r0 != r13) goto L_0x0148
            return r13
        L_0x011c:
            int[] r0 = com.stripe.android.StripePaymentController.WhenMappings.$EnumSwitchMapping$0
            int r6 = r11.ordinal()
            r0 = r0[r6]
            if (r0 == r14) goto L_0x0133
            r6 = 2
            if (r0 != r6) goto L_0x012d
            r0 = 50001(0xc351, float:7.0066E-41)
            goto L_0x0136
        L_0x012d:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0133:
            r0 = 50000(0xc350, float:7.0065E-41)
        L_0x0136:
            r12.L$0 = r4
            r12.L$1 = r4
            r12.L$2 = r4
            r12.L$3 = r4
            r4 = 4
            r12.label = r4
            java.lang.Object r0 = r5.handleError(r2, r0, r3, r12)
            if (r0 != r13) goto L_0x0148
            return r13
        L_0x0148:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.startAuth(com.stripe.android.view.AuthActivityStarterHost, java.lang.String, com.stripe.android.core.networking.ApiRequest$Options, com.stripe.android.PaymentController$StripeIntentType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098 A[SYNTHETIC, Splitter:B:38:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009f A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object startAuthenticateSource(com.stripe.android.view.AuthActivityStarterHost r18, com.stripe.android.model.Source r19, com.stripe.android.core.networking.ApiRequest.Options r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r17 = this;
            r1 = r17
            r2 = r20
            r0 = r21
            boolean r3 = r0 instanceof com.stripe.android.StripePaymentController$startAuthenticateSource$1
            if (r3 == 0) goto L_0x001a
            r3 = r0
            com.stripe.android.StripePaymentController$startAuthenticateSource$1 r3 = (com.stripe.android.StripePaymentController$startAuthenticateSource$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x001f
        L_0x001a:
            com.stripe.android.StripePaymentController$startAuthenticateSource$1 r3 = new com.stripe.android.StripePaymentController$startAuthenticateSource$1
            r3.<init>(r1, r0)
        L_0x001f:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L_0x0053
            if (r5 == r8) goto L_0x0040
            if (r5 == r7) goto L_0x003b
            if (r5 != r6) goto L_0x0033
            goto L_0x003b
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00e6
        L_0x0040:
            java.lang.Object r2 = r3.L$2
            com.stripe.android.core.networking.ApiRequest$Options r2 = (com.stripe.android.core.networking.ApiRequest.Options) r2
            java.lang.Object r5 = r3.L$1
            com.stripe.android.view.AuthActivityStarterHost r5 = (com.stripe.android.view.AuthActivityStarterHost) r5
            java.lang.Object r8 = r3.L$0
            com.stripe.android.StripePaymentController r8 = (com.stripe.android.StripePaymentController) r8
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0050 }
            goto L_0x0096
        L_0x0050:
            r0 = move-exception
            r10 = r5
            goto L_0x00b1
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r0)
            com.stripe.android.core.networking.AnalyticsRequestExecutor r0 = r1.analyticsRequestExecutor
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r9 = r1.paymentAnalyticsRequestFactory
            com.stripe.android.networking.PaymentAnalyticsEvent r10 = com.stripe.android.networking.PaymentAnalyticsEvent.AuthSourceStart
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 30
            r16 = 0
            com.stripe.android.core.networking.AnalyticsRequest r5 = com.stripe.android.networking.PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.executeAsync(r5)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00ad }
            r0 = r1
            com.stripe.android.StripePaymentController r0 = (com.stripe.android.StripePaymentController) r0     // Catch:{ all -> 0x00ad }
            com.stripe.android.networking.StripeRepository r0 = r0.stripeRepository     // Catch:{ all -> 0x00ad }
            java.lang.String r5 = r19.getId()     // Catch:{ all -> 0x00ad }
            java.lang.String r9 = ""
            if (r5 != 0) goto L_0x007b
            r5 = r9
        L_0x007b:
            java.lang.String r10 = r19.getClientSecret()     // Catch:{ all -> 0x00ad }
            if (r10 != 0) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            r9 = r10
        L_0x0083:
            r3.L$0 = r1     // Catch:{ all -> 0x00ad }
            r10 = r18
            r3.L$1 = r10     // Catch:{ all -> 0x00ab }
            r3.L$2 = r2     // Catch:{ all -> 0x00ab }
            r3.label = r8     // Catch:{ all -> 0x00ab }
            java.lang.Object r0 = r0.retrieveSource$payments_core_release(r5, r9, r2, r3)     // Catch:{ all -> 0x00ab }
            if (r0 != r4) goto L_0x0094
            return r4
        L_0x0094:
            r8 = r1
            r5 = r10
        L_0x0096:
            if (r0 == 0) goto L_0x009f
            com.stripe.android.model.Source r0 = (com.stripe.android.model.Source) r0     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0050 }
            goto L_0x00bc
        L_0x009f:
            java.lang.String r0 = "Required value was null."
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0050 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0050 }
            r9.<init>(r0)     // Catch:{ all -> 0x0050 }
            throw r9     // Catch:{ all -> 0x0050 }
        L_0x00ab:
            r0 = move-exception
            goto L_0x00b0
        L_0x00ad:
            r0 = move-exception
            r10 = r18
        L_0x00b0:
            r8 = r1
        L_0x00b1:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
            r5 = r10
        L_0x00bc:
            java.lang.Throwable r9 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            r10 = 0
            if (r9 != 0) goto L_0x00d4
            com.stripe.android.model.Source r0 = (com.stripe.android.model.Source) r0
            r3.L$0 = r10
            r3.L$1 = r10
            r3.L$2 = r10
            r3.label = r7
            java.lang.Object r0 = r8.onSourceRetrieved(r5, r0, r2, r3)
            if (r0 != r4) goto L_0x00e6
            return r4
        L_0x00d4:
            r0 = 50002(0xc352, float:7.0068E-41)
            r3.L$0 = r10
            r3.L$1 = r10
            r3.L$2 = r10
            r3.label = r6
            java.lang.Object r0 = r8.handleError(r5, r0, r9, r3)
            if (r0 != r4) goto L_0x00e6
            return r4
        L_0x00e6:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.startAuthenticateSource(com.stripe.android.view.AuthActivityStarterHost, com.stripe.android.model.Source, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object onSourceRetrieved(AuthActivityStarterHost authActivityStarterHost, Source source, ApiRequest.Options options, Continuation<? super Unit> continuation) {
        Object authenticate = this.authenticatorRegistry.getAuthenticator(source).authenticate(authActivityStarterHost, source, options, continuation);
        return authenticate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? authenticate : Unit.INSTANCE;
    }

    public Object getPaymentIntentResult(Intent intent, Continuation<? super PaymentIntentResult> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, IllegalArgumentException {
        return this.paymentIntentFlowResultProcessor.processResult(PaymentFlowResult.Unvalidated.Companion.fromIntent(intent), continuation);
    }

    public Object getSetupIntentResult(Intent intent, Continuation<? super SetupIntentResult> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, IllegalArgumentException {
        return this.setupIntentFlowResultProcessor.processResult(PaymentFlowResult.Unvalidated.Companion.fromIntent(intent), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAuthenticateSourceResult(android.content.Intent r23, kotlin.coroutines.Continuation<? super com.stripe.android.model.Source> r24) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException, java.lang.IllegalArgumentException {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            boolean r2 = r1 instanceof com.stripe.android.StripePaymentController$getAuthenticateSourceResult$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.stripe.android.StripePaymentController$getAuthenticateSourceResult$1 r2 = (com.stripe.android.StripePaymentController$getAuthenticateSourceResult$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.stripe.android.StripePaymentController$getAuthenticateSourceResult$1 r2 = new com.stripe.android.StripePaymentController$getAuthenticateSourceResult$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0036
            if (r4 != r5) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x008c
        L_0x002e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r1)
            com.stripe.android.payments.PaymentFlowResult$Unvalidated$Companion r1 = com.stripe.android.payments.PaymentFlowResult.Unvalidated.Companion
            r4 = r23
            com.stripe.android.payments.PaymentFlowResult$Unvalidated r1 = r1.fromIntent(r4)
            java.lang.String r4 = r1.getSourceId$payments_core_release()
            java.lang.String r6 = ""
            if (r4 != 0) goto L_0x004a
            r4 = r6
        L_0x004a:
            java.lang.String r7 = r1.getClientSecret()
            if (r7 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r6 = r7
        L_0x0052:
            com.stripe.android.core.networking.ApiRequest$Options r13 = new com.stripe.android.core.networking.ApiRequest$Options
            kotlin.jvm.functions.Function0<java.lang.String> r7 = r0.publishableKeyProvider
            java.lang.Object r7 = r7.invoke()
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = r1.getStripeAccountId$payments_core_release()
            r10 = 0
            r11 = 4
            r12 = 0
            r7 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            com.stripe.android.core.networking.AnalyticsRequestExecutor r1 = r0.analyticsRequestExecutor
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r14 = r0.paymentAnalyticsRequestFactory
            com.stripe.android.networking.PaymentAnalyticsEvent r15 = com.stripe.android.networking.PaymentAnalyticsEvent.AuthSourceResult
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 30
            r21 = 0
            com.stripe.android.core.networking.AnalyticsRequest r7 = com.stripe.android.networking.PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(r14, r15, r16, r17, r18, r19, r20, r21)
            r1.executeAsync(r7)
            com.stripe.android.networking.StripeRepository r1 = r0.stripeRepository
            r2.label = r5
            java.lang.Object r1 = r1.retrieveSource$payments_core_release(r4, r6, r13, r2)
            if (r1 != r3) goto L_0x008c
            return r3
        L_0x008c:
            if (r1 == 0) goto L_0x008f
            return r1
        L_0x008f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Required value was null."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.getAuthenticateSourceResult(android.content.Intent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: com.stripe.android.core.networking.ApiRequest$Options} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object authenticateAlipay(com.stripe.android.model.PaymentIntent r8, com.stripe.android.AlipayAuthenticator r9, com.stripe.android.core.networking.ApiRequest.Options r10, kotlin.coroutines.Continuation<? super com.stripe.android.PaymentIntentResult> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stripe.android.StripePaymentController$authenticateAlipay$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.stripe.android.StripePaymentController$authenticateAlipay$1 r0 = (com.stripe.android.StripePaymentController$authenticateAlipay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripePaymentController$authenticateAlipay$1 r0 = new com.stripe.android.StripePaymentController$authenticateAlipay$1
            r0.<init>(r7, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$0
            com.stripe.android.StripePaymentController r9 = (com.stripe.android.StripePaymentController) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0088
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            java.lang.Object r8 = r0.L$2
            r10 = r8
            com.stripe.android.core.networking.ApiRequest$Options r10 = (com.stripe.android.core.networking.ApiRequest.Options) r10
            java.lang.Object r8 = r0.L$1
            com.stripe.android.model.PaymentIntent r8 = (com.stripe.android.model.PaymentIntent) r8
            java.lang.Object r9 = r0.L$0
            com.stripe.android.StripePaymentController r9 = (com.stripe.android.StripePaymentController) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0061
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r11)
            com.stripe.android.networking.AlipayRepository r11 = r7.alipayRepository
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r11 = r11.authenticate(r8, r9, r10, r0)
            if (r11 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r9 = r7
        L_0x0061:
            com.stripe.android.model.AlipayAuthResult r11 = (com.stripe.android.model.AlipayAuthResult) r11
            int r11 = r11.getOutcome()
            com.stripe.android.networking.StripeRepository r2 = r9.stripeRepository
            java.lang.String r8 = r8.getClientSecret()
            if (r8 != 0) goto L_0x0071
            java.lang.String r8 = ""
        L_0x0071:
            java.util.List<java.lang.String> r4 = EXPAND_PAYMENT_METHOD
            r0.L$0 = r9
            r5 = 0
            r0.L$1 = r5
            r0.L$2 = r5
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r8 = r2.retrievePaymentIntent(r8, r10, r4, r0)
            if (r8 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r6 = r11
            r11 = r8
            r8 = r6
        L_0x0088:
            if (r11 == 0) goto L_0x009b
            com.stripe.android.model.PaymentIntent r11 = (com.stripe.android.model.PaymentIntent) r11
            com.stripe.android.PaymentIntentResult r10 = new com.stripe.android.PaymentIntentResult
            com.stripe.android.payments.PaymentFlowFailureMessageFactory r9 = r9.failureMessageFactory
            r0 = r11
            com.stripe.android.model.StripeIntent r0 = (com.stripe.android.model.StripeIntent) r0
            java.lang.String r9 = r9.create(r0, r8)
            r10.<init>(r11, r8, r9)
            return r10
        L_0x009b:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Required value was null."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripePaymentController.authenticateAlipay(com.stripe.android.model.PaymentIntent, com.stripe.android.AlipayAuthenticator, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object handleError(AuthActivityStarterHost authActivityStarterHost, int i, Throwable th, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.uiContext, new StripePaymentController$handleError$2(this, authActivityStarterHost, th, i, (Continuation<? super StripePaymentController$handleError$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public Object handleNextAction(AuthActivityStarterHost authActivityStarterHost, StripeIntent stripeIntent, ApiRequest.Options options, Continuation<? super Unit> continuation) {
        Object authenticate = this.authenticatorRegistry.getAuthenticator(stripeIntent).authenticate(authActivityStarterHost, stripeIntent, options, continuation);
        return authenticate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? authenticate : Unit.INSTANCE;
    }

    private final void logReturnUrl(String str) {
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

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b\u001dR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/stripe/android/StripePaymentController$Companion;", "", "()V", "CHALLENGE_DELAY", "", "getCHALLENGE_DELAY$payments_core_release", "()J", "EXPAND_PAYMENT_METHOD", "", "", "getEXPAND_PAYMENT_METHOD$payments_core_release", "()Ljava/util/List;", "PAYMENT_REQUEST_CODE", "", "REQUIRED_ERROR", "SETUP_REQUEST_CODE", "SOURCE_REQUEST_CODE", "create", "Lcom/stripe/android/PaymentController;", "context", "Landroid/content/Context;", "publishableKey", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "enableLogging", "", "getRequestCode", "params", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "getRequestCode$payments_core_release", "intent", "Lcom/stripe/android/model/StripeIntent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripePaymentController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PaymentController create(Context context, String str, StripeRepository stripeRepository) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(stripeRepository, "stripeRepository");
            return create$default(this, context, str, stripeRepository, false, 8, (Object) null);
        }

        private Companion() {
        }

        public final /* synthetic */ int getRequestCode$payments_core_release(StripeIntent stripeIntent) {
            Intrinsics.checkNotNullParameter(stripeIntent, "intent");
            return stripeIntent instanceof PaymentIntent ? StripePaymentController.PAYMENT_REQUEST_CODE : StripePaymentController.SETUP_REQUEST_CODE;
        }

        public final /* synthetic */ int getRequestCode$payments_core_release(ConfirmStripeIntentParams confirmStripeIntentParams) {
            Intrinsics.checkNotNullParameter(confirmStripeIntentParams, "params");
            if (confirmStripeIntentParams instanceof ConfirmPaymentIntentParams) {
                return StripePaymentController.PAYMENT_REQUEST_CODE;
            }
            if (confirmStripeIntentParams instanceof ConfirmSetupIntentParams) {
                return StripePaymentController.SETUP_REQUEST_CODE;
            }
            throw new NoWhenBranchMatchedException();
        }

        public static /* synthetic */ PaymentController create$default(Companion companion, Context context, String str, StripeRepository stripeRepository, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.create(context, str, stripeRepository, z);
        }

        @JvmStatic
        public final PaymentController create(Context context, String str, StripeRepository stripeRepository, boolean z) {
            String str2 = str;
            Context context2 = context;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str2, "publishableKey");
            StripeRepository stripeRepository2 = stripeRepository;
            Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            return new StripePaymentController(applicationContext, new StripePaymentController$Companion$create$1(str2), stripeRepository2, z, (CoroutineContext) null, (AnalyticsRequestExecutor) null, (PaymentAnalyticsRequestFactory) null, (AlipayRepository) null, (CoroutineContext) null, 496, (DefaultConstructorMarker) null);
        }

        public final List<String> getEXPAND_PAYMENT_METHOD$payments_core_release() {
            return StripePaymentController.EXPAND_PAYMENT_METHOD;
        }

        public final long getCHALLENGE_DELAY$payments_core_release() {
            return StripePaymentController.CHALLENGE_DELAY;
        }
    }
}
