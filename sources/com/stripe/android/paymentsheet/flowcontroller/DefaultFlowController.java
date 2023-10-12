package com.stripe.android.paymentsheet.flowcontroller;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelStoreOwner;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.Injector;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.injection.UIContext;
import com.stripe.android.core.injection.WeakMapInjectorRegistry;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherFactory;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.payments.paymentlauncher.PaymentLauncher;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory;
import com.stripe.android.paymentsheet.PaymentOptionCallback;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import com.stripe.android.paymentsheet.PaymentOptionResult;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetConfigurationKtxKt;
import com.stripe.android.paymentsheet.PaymentSheetResult;
import com.stripe.android.paymentsheet.PaymentSheetResultCallback;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.paymentsheet.injection.DaggerFlowControllerComponent;
import com.stripe.android.paymentsheet.injection.FlowControllerComponent;
import com.stripe.android.paymentsheet.model.ClientSecret;
import com.stripe.android.paymentsheet.model.ConfirmStripeIntentParamsFactory;
import com.stripe.android.paymentsheet.model.PaymentIntentClientSecret;
import com.stripe.android.paymentsheet.model.PaymentOption;
import com.stripe.android.paymentsheet.model.PaymentOptionFactory;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.model.SavedSelection;
import com.stripe.android.paymentsheet.model.SetupIntentClientSecret;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.Lazy;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Singleton
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0003cdeB³\u0001\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\b\b\u0001\u0010!\u001a\u00020\"\u0012\b\b\u0001\u0010#\u001a\u00020$\u0012\u000e\b\u0001\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130&\u0012\u0006\u0010'\u001a\u00020(¢\u0006\u0002\u0010)J\"\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>H\u0002J\"\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\u00132\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>H\u0016J\"\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020\u00132\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010C\u001a\u000208H\u0016J\u001a\u0010D\u001a\u0002082\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020HH\u0007J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J!\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020O2\u0006\u0010=\u001a\u00020>H@ø\u0001\u0000¢\u0006\u0002\u0010PJ\n\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u0014\u0010S\u001a\u0002082\n\u0010T\u001a\u0006\u0012\u0002\b\u00030UH\u0016J\u0010\u0010V\u001a\u0002082\u0006\u0010G\u001a\u00020HH\u0002J\u0015\u0010W\u001a\u0002082\u0006\u0010X\u001a\u00020YH\u0000¢\u0006\u0002\bZJ\u0018\u0010[\u001a\u0002082\u0006\u0010G\u001a\u00020H2\u0006\u0010=\u001a\u00020>H\u0002J\u0017\u0010\\\u001a\u0002082\b\u0010]\u001a\u0004\u0018\u00010^H\u0000¢\u0006\u0002\b_J\u0015\u0010`\u001a\u0002082\u0006\u0010K\u001a\u00020LH\u0000¢\u0006\u0002\baJ\b\u0010b\u001a\u000208H\u0016R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020601X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006f"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/DefaultFlowController;", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "Lcom/stripe/android/core/injection/Injector;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "statusBarColor", "Lkotlin/Function0;", "", "paymentOptionFactory", "Lcom/stripe/android/paymentsheet/model/PaymentOptionFactory;", "paymentOptionCallback", "Lcom/stripe/android/paymentsheet/PaymentOptionCallback;", "paymentResultCallback", "Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "injectorKey", "", "flowControllerInitializer", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer;", "eventReporter", "Lcom/stripe/android/paymentsheet/analytics/EventReporter;", "viewModel", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerViewModel;", "paymentLauncherFactory", "Lcom/stripe/android/payments/paymentlauncher/StripePaymentLauncherAssistedFactory;", "resourceRepository", "Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "lazyPaymentConfiguration", "Ldagger/Lazy;", "Lcom/stripe/android/PaymentConfiguration;", "uiContext", "Lkotlin/coroutines/CoroutineContext;", "enableLogging", "", "productUsage", "", "googlePayPaymentMethodLauncherFactory", "Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherFactory;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lcom/stripe/android/paymentsheet/model/PaymentOptionFactory;Lcom/stripe/android/paymentsheet/PaymentOptionCallback;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;Landroidx/activity/result/ActivityResultCaller;Ljava/lang/String;Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer;Lcom/stripe/android/paymentsheet/analytics/EventReporter;Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerViewModel;Lcom/stripe/android/payments/paymentlauncher/StripePaymentLauncherAssistedFactory;Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;Ldagger/Lazy;Lkotlin/coroutines/CoroutineContext;ZLjava/util/Set;Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherFactory;)V", "flowControllerComponent", "Lcom/stripe/android/paymentsheet/injection/FlowControllerComponent;", "getFlowControllerComponent", "()Lcom/stripe/android/paymentsheet/injection/FlowControllerComponent;", "setFlowControllerComponent", "(Lcom/stripe/android/paymentsheet/injection/FlowControllerComponent;)V", "googlePayActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "paymentLauncher", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "paymentOptionActivityLauncher", "Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "configureInternal", "", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "configuration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "callback", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$ConfigCallback;", "configureWithPaymentIntent", "paymentIntentClientSecret", "configureWithSetupIntent", "setupIntentClientSecret", "confirm", "confirmPaymentSelection", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "initData", "Lcom/stripe/android/paymentsheet/flowcontroller/InitData;", "createPaymentSheetResult", "Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "paymentResult", "Lcom/stripe/android/payments/paymentlauncher/PaymentResult;", "dispatchResult", "result", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult;", "(Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult;Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$ConfigCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentOption", "Lcom/stripe/android/paymentsheet/model/PaymentOption;", "inject", "injectable", "Lcom/stripe/android/core/injection/Injectable;", "launchGooglePay", "onGooglePayResult", "googlePayResult", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "onGooglePayResult$paymentsheet_release", "onInitSuccess", "onPaymentOptionResult", "paymentOptionResult", "Lcom/stripe/android/paymentsheet/PaymentOptionResult;", "onPaymentOptionResult$paymentsheet_release", "onPaymentResult", "onPaymentResult$paymentsheet_release", "presentPaymentOptions", "Args", "Companion", "GooglePayException", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultFlowController.kt */
public final class DefaultFlowController implements PaymentSheet.FlowController, Injector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean enableLogging;
    private final EventReporter eventReporter;
    public FlowControllerComponent flowControllerComponent;
    /* access modifiers changed from: private */
    public final FlowControllerInitializer flowControllerInitializer;
    private ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> googlePayActivityLauncher;
    private final GooglePayPaymentMethodLauncherFactory googlePayPaymentMethodLauncherFactory;
    private final String injectorKey;
    /* access modifiers changed from: private */
    public final Lazy<PaymentConfiguration> lazyPaymentConfiguration;
    private final CoroutineScope lifecycleScope;
    /* access modifiers changed from: private */
    public PaymentLauncher paymentLauncher;
    /* access modifiers changed from: private */
    public final StripePaymentLauncherAssistedFactory paymentLauncherFactory;
    private final ActivityResultLauncher<PaymentOptionContract.Args> paymentOptionActivityLauncher;
    private final PaymentOptionCallback paymentOptionCallback;
    private final PaymentOptionFactory paymentOptionFactory;
    /* access modifiers changed from: private */
    public final PaymentSheetResultCallback paymentResultCallback;
    private final Set<String> productUsage;
    /* access modifiers changed from: private */
    public final ResourceRepository resourceRepository;
    private final Function0<Integer> statusBarColor;
    /* access modifiers changed from: private */
    public final CoroutineContext uiContext;
    private final FlowControllerViewModel viewModel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultFlowController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentSheet.GooglePayConfiguration.Environment.values().length];
            iArr[PaymentSheet.GooglePayConfiguration.Environment.Production.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DefaultFlowController(CoroutineScope coroutineScope, LifecycleOwner lifecycleOwner, Function0<Integer> function0, PaymentOptionFactory paymentOptionFactory2, PaymentOptionCallback paymentOptionCallback2, PaymentSheetResultCallback paymentSheetResultCallback, ActivityResultCaller activityResultCaller, @InjectorKey String str, FlowControllerInitializer flowControllerInitializer2, EventReporter eventReporter2, FlowControllerViewModel flowControllerViewModel, StripePaymentLauncherAssistedFactory stripePaymentLauncherAssistedFactory, ResourceRepository resourceRepository2, Lazy<PaymentConfiguration> lazy, @UIContext CoroutineContext coroutineContext, @Named("enableLogging") boolean z, @Named("productUsage") Set<String> set, GooglePayPaymentMethodLauncherFactory googlePayPaymentMethodLauncherFactory2) {
        Function0<Integer> function02 = function0;
        PaymentOptionFactory paymentOptionFactory3 = paymentOptionFactory2;
        PaymentOptionCallback paymentOptionCallback3 = paymentOptionCallback2;
        PaymentSheetResultCallback paymentSheetResultCallback2 = paymentSheetResultCallback;
        String str2 = str;
        FlowControllerInitializer flowControllerInitializer3 = flowControllerInitializer2;
        EventReporter eventReporter3 = eventReporter2;
        FlowControllerViewModel flowControllerViewModel2 = flowControllerViewModel;
        StripePaymentLauncherAssistedFactory stripePaymentLauncherAssistedFactory2 = stripePaymentLauncherAssistedFactory;
        ResourceRepository resourceRepository3 = resourceRepository2;
        Lazy<PaymentConfiguration> lazy2 = lazy;
        CoroutineContext coroutineContext2 = coroutineContext;
        Set<String> set2 = set;
        Intrinsics.checkNotNullParameter(coroutineScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(function02, "statusBarColor");
        Intrinsics.checkNotNullParameter(paymentOptionFactory3, "paymentOptionFactory");
        Intrinsics.checkNotNullParameter(paymentOptionCallback3, "paymentOptionCallback");
        Intrinsics.checkNotNullParameter(paymentSheetResultCallback2, "paymentResultCallback");
        Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
        Intrinsics.checkNotNullParameter(str2, "injectorKey");
        Intrinsics.checkNotNullParameter(flowControllerInitializer3, "flowControllerInitializer");
        Intrinsics.checkNotNullParameter(eventReporter3, "eventReporter");
        Intrinsics.checkNotNullParameter(flowControllerViewModel2, "viewModel");
        Intrinsics.checkNotNullParameter(stripePaymentLauncherAssistedFactory2, "paymentLauncherFactory");
        Intrinsics.checkNotNullParameter(resourceRepository3, "resourceRepository");
        Intrinsics.checkNotNullParameter(lazy2, "lazyPaymentConfiguration");
        Intrinsics.checkNotNullParameter(coroutineContext2, "uiContext");
        Intrinsics.checkNotNullParameter(set2, NamedConstantsKt.PRODUCT_USAGE);
        GooglePayPaymentMethodLauncherFactory googlePayPaymentMethodLauncherFactory3 = googlePayPaymentMethodLauncherFactory2;
        Intrinsics.checkNotNullParameter(googlePayPaymentMethodLauncherFactory3, "googlePayPaymentMethodLauncherFactory");
        this.lifecycleScope = coroutineScope;
        this.statusBarColor = function02;
        this.paymentOptionFactory = paymentOptionFactory3;
        this.paymentOptionCallback = paymentOptionCallback3;
        this.paymentResultCallback = paymentSheetResultCallback2;
        this.injectorKey = str2;
        this.flowControllerInitializer = flowControllerInitializer3;
        this.eventReporter = eventReporter3;
        this.viewModel = flowControllerViewModel2;
        this.paymentLauncherFactory = stripePaymentLauncherAssistedFactory2;
        this.resourceRepository = resourceRepository3;
        this.lazyPaymentConfiguration = lazy2;
        this.uiContext = coroutineContext2;
        this.enableLogging = z;
        this.productUsage = set2;
        this.googlePayPaymentMethodLauncherFactory = googlePayPaymentMethodLauncherFactory3;
        final ActivityResultCaller activityResultCaller2 = activityResultCaller;
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver(this) {
            final /* synthetic */ DefaultFlowController this$0;

            {
                this.this$0 = r1;
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public final void onCreate() {
                DefaultFlowController defaultFlowController = this.this$0;
                ActivityResultLauncher registerForActivityResult = activityResultCaller2.registerForActivityResult(new PaymentLauncherContract(), new ActivityResultCallback() {
                    public final void onActivityResult(Object obj) {
                        DefaultFlowController.this.onPaymentResult$paymentsheet_release((PaymentResult) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activityResultCaller.reg…                        )");
                defaultFlowController.paymentLauncher = defaultFlowController.paymentLauncherFactory.create(new DefaultFlowController$1$onCreate$1(this.this$0), new DefaultFlowController$1$onCreate$2(this.this$0), registerForActivityResult);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                this.this$0.paymentLauncher = null;
            }
        });
        ActivityResultLauncher<PaymentOptionContract.Args> registerForActivityResult = activityResultCaller2.registerForActivityResult(new PaymentOptionContract(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                DefaultFlowController.this.onPaymentOptionResult$paymentsheet_release((PaymentOptionResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activityResultCaller.reg…ptionResult\n            )");
        this.paymentOptionActivityLauncher = registerForActivityResult;
        ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> registerForActivityResult2 = activityResultCaller2.registerForActivityResult(new GooglePayPaymentMethodLauncherContract(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                DefaultFlowController.this.onGooglePayResult$paymentsheet_release((GooglePayPaymentMethodLauncher.Result) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "activityResultCaller.reg…lePayResult\n            )");
        this.googlePayActivityLauncher = registerForActivityResult2;
    }

    public final FlowControllerComponent getFlowControllerComponent() {
        FlowControllerComponent flowControllerComponent2 = this.flowControllerComponent;
        if (flowControllerComponent2 != null) {
            return flowControllerComponent2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flowControllerComponent");
        return null;
    }

    public final void setFlowControllerComponent(FlowControllerComponent flowControllerComponent2) {
        Intrinsics.checkNotNullParameter(flowControllerComponent2, "<set-?>");
        this.flowControllerComponent = flowControllerComponent2;
    }

    public void inject(Injectable<?> injectable) {
        Intrinsics.checkNotNullParameter(injectable, "injectable");
        if (injectable instanceof PaymentOptionsViewModel.Factory) {
            getFlowControllerComponent().inject((PaymentOptionsViewModel.Factory) injectable);
        } else if (injectable instanceof FormViewModel.Factory) {
            getFlowControllerComponent().inject((FormViewModel.Factory) injectable);
        } else {
            throw new IllegalArgumentException("invalid Injectable " + injectable + " requested in " + this);
        }
    }

    public void configureWithPaymentIntent(String str, PaymentSheet.Configuration configuration, PaymentSheet.FlowController.ConfigCallback configCallback) {
        Intrinsics.checkNotNullParameter(str, "paymentIntentClientSecret");
        Intrinsics.checkNotNullParameter(configCallback, "callback");
        configureInternal(new PaymentIntentClientSecret(str), configuration, configCallback);
    }

    public void configureWithSetupIntent(String str, PaymentSheet.Configuration configuration, PaymentSheet.FlowController.ConfigCallback configCallback) {
        Intrinsics.checkNotNullParameter(str, "setupIntentClientSecret");
        Intrinsics.checkNotNullParameter(configCallback, "callback");
        configureInternal(new SetupIntentClientSecret(str), configuration, configCallback);
    }

    private final void configureInternal(ClientSecret clientSecret, PaymentSheet.Configuration configuration, PaymentSheet.FlowController.ConfigCallback configCallback) {
        if (configuration != null) {
            try {
                PaymentSheetConfigurationKtxKt.validate(configuration);
            } catch (InvalidParameterException e) {
                configCallback.onConfigured(false, e);
                return;
            }
        }
        clientSecret.validate();
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultFlowController$configureInternal$1(this, clientSecret, configuration, configCallback, (Continuation<? super DefaultFlowController$configureInternal$1>) null), 3, (Object) null);
    }

    public PaymentOption getPaymentOption() {
        PaymentSelection paymentSelection = this.viewModel.getPaymentSelection();
        if (paymentSelection == null) {
            return null;
        }
        return this.paymentOptionFactory.create(paymentSelection);
    }

    public void presentPaymentOptions() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4709constructorimpl(this.viewModel.getInitData());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4712exceptionOrNullimpl(obj) == null) {
            InitData initData = (InitData) obj;
            ActivityResultLauncher<PaymentOptionContract.Args> activityResultLauncher = this.paymentOptionActivityLauncher;
            StripeIntent stripeIntent = initData.getStripeIntent();
            List<PaymentMethod> paymentMethods = initData.getPaymentMethods();
            PaymentSheet.Configuration config = initData.getConfig();
            boolean isGooglePayReady = initData.isGooglePayReady();
            PaymentSelection paymentSelection = this.viewModel.getPaymentSelection();
            activityResultLauncher.launch(new PaymentOptionContract.Args(stripeIntent, paymentMethods, config, isGooglePayReady, paymentSelection instanceof PaymentSelection.New.Card ? (PaymentSelection.New.Card) paymentSelection : null, this.statusBarColor.invoke(), this.injectorKey, this.enableLogging, this.productUsage));
            return;
        }
        throw new IllegalStateException("FlowController must be successfully initialized using configureWithPaymentIntent() or configureWithSetupIntent() before calling presentPaymentOptions()".toString());
    }

    public void confirm() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4709constructorimpl(this.viewModel.getInitData());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4712exceptionOrNullimpl(obj) == null) {
            InitData initData = (InitData) obj;
            PaymentSelection paymentSelection = this.viewModel.getPaymentSelection();
            if (Intrinsics.areEqual((Object) paymentSelection, (Object) PaymentSelection.GooglePay.INSTANCE)) {
                launchGooglePay(initData);
            } else {
                confirmPaymentSelection(paymentSelection, initData);
            }
        } else {
            throw new IllegalStateException("FlowController must be successfully initialized using configureWithPaymentIntent() or configureWithSetupIntent() before calling confirm()".toString());
        }
    }

    public final void confirmPaymentSelection(PaymentSelection paymentSelection, InitData initData) {
        ConfirmStripeIntentParams confirmStripeIntentParams;
        Intrinsics.checkNotNullParameter(initData, "initData");
        ConfirmStripeIntentParamsFactory<ConfirmStripeIntentParams> createFactory = ConfirmStripeIntentParamsFactory.Companion.createFactory(initData.getClientSecret());
        if (paymentSelection instanceof PaymentSelection.Saved) {
            confirmStripeIntentParams = createFactory.create((PaymentSelection.Saved) paymentSelection);
        } else {
            confirmStripeIntentParams = paymentSelection instanceof PaymentSelection.New ? createFactory.create((PaymentSelection.New) paymentSelection) : null;
        }
        if (confirmStripeIntentParams != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultFlowController$confirmPaymentSelection$1$1(confirmStripeIntentParams, this, (Continuation<? super DefaultFlowController$confirmPaymentSelection$1$1>) null), 3, (Object) null);
        }
    }

    public final void onGooglePayResult$paymentsheet_release(GooglePayPaymentMethodLauncher.Result result) {
        Object obj;
        Intrinsics.checkNotNullParameter(result, "googlePayResult");
        if (result instanceof GooglePayPaymentMethodLauncher.Result.Completed) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m4709constructorimpl(this.viewModel.getInitData());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
            if (r1 == null) {
                PaymentSelection saved = new PaymentSelection.Saved(((GooglePayPaymentMethodLauncher.Result.Completed) result).getPaymentMethod());
                this.viewModel.setPaymentSelection(saved);
                confirmPaymentSelection(saved, (InitData) obj);
                return;
            }
            this.eventReporter.onPaymentFailure(PaymentSelection.GooglePay.INSTANCE);
            this.paymentResultCallback.onPaymentSheetResult(new PaymentSheetResult.Failed(r1));
        } else if (result instanceof GooglePayPaymentMethodLauncher.Result.Failed) {
            this.eventReporter.onPaymentFailure(PaymentSelection.GooglePay.INSTANCE);
            this.paymentResultCallback.onPaymentSheetResult(new PaymentSheetResult.Failed(new GooglePayException(((GooglePayPaymentMethodLauncher.Result.Failed) result).getError())));
        } else if (result instanceof GooglePayPaymentMethodLauncher.Result.Canceled) {
            this.paymentResultCallback.onPaymentSheetResult(PaymentSheetResult.Canceled.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final Object dispatchResult(FlowControllerInitializer.InitResult initResult, PaymentSheet.FlowController.ConfigCallback configCallback, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.uiContext, new DefaultFlowController$dispatchResult$2(initResult, this, configCallback, (Continuation<? super DefaultFlowController$dispatchResult$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void onInitSuccess(InitData initData, PaymentSheet.FlowController.ConfigCallback configCallback) {
        PaymentSelection paymentSelection;
        Object obj;
        PaymentSelection.Saved saved;
        this.eventReporter.onInit(initData.getConfig());
        SavedSelection savedSelection = initData.getSavedSelection();
        if (Intrinsics.areEqual((Object) savedSelection, (Object) SavedSelection.GooglePay.INSTANCE)) {
            paymentSelection = PaymentSelection.GooglePay.INSTANCE;
        } else if (savedSelection instanceof SavedSelection.PaymentMethod) {
            Iterator it = initData.getPaymentMethods().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((PaymentMethod) obj).id, (Object) ((SavedSelection.PaymentMethod) savedSelection).getId())) {
                    break;
                }
            }
            PaymentMethod paymentMethod = (PaymentMethod) obj;
            if (paymentMethod == null) {
                saved = null;
            } else {
                saved = new PaymentSelection.Saved(paymentMethod);
            }
            paymentSelection = saved;
        } else {
            paymentSelection = null;
        }
        this.viewModel.setPaymentSelection(paymentSelection);
        this.viewModel.setInitData(initData);
        configCallback.onConfigured(true, (Throwable) null);
    }

    public final /* synthetic */ void onPaymentOptionResult$paymentsheet_release(PaymentOptionResult paymentOptionResult) {
        if (paymentOptionResult instanceof PaymentOptionResult.Succeeded) {
            PaymentSelection paymentSelection = ((PaymentOptionResult.Succeeded) paymentOptionResult).getPaymentSelection();
            this.viewModel.setPaymentSelection(paymentSelection);
            this.paymentOptionCallback.onPaymentOption(this.paymentOptionFactory.create(paymentSelection));
            return;
        }
        PaymentOption paymentOption = null;
        if (paymentOptionResult instanceof PaymentOptionResult.Failed ? true : paymentOptionResult instanceof PaymentOptionResult.Canceled) {
            PaymentOptionCallback paymentOptionCallback2 = this.paymentOptionCallback;
            PaymentSelection paymentSelection2 = this.viewModel.getPaymentSelection();
            if (paymentSelection2 != null) {
                paymentOption = this.paymentOptionFactory.create(paymentSelection2);
            }
            paymentOptionCallback2.onPaymentOption(paymentOption);
            return;
        }
        this.viewModel.setPaymentSelection((PaymentSelection) null);
        this.paymentOptionCallback.onPaymentOption((PaymentOption) null);
    }

    public final void onPaymentResult$paymentsheet_release(PaymentResult paymentResult) {
        Intrinsics.checkNotNullParameter(paymentResult, "paymentResult");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultFlowController$onPaymentResult$1(this, paymentResult, (Continuation<? super DefaultFlowController$onPaymentResult$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [com.stripe.android.model.StripeIntent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void launchGooglePay(com.stripe.android.paymentsheet.flowcontroller.InitData r13) {
        /*
            r12 = this;
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r0 = r13.getConfig()
            java.lang.String r1 = "Required value was null."
            if (r0 == 0) goto L_0x0098
            com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration r2 = r0.getGooglePay()
            if (r2 == 0) goto L_0x008e
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config r1 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config
            com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration$Environment r3 = r2.getEnvironment()
            int[] r4 = com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 1
            if (r3 != r4) goto L_0x0022
            com.stripe.android.googlepaylauncher.GooglePayEnvironment r3 = com.stripe.android.googlepaylauncher.GooglePayEnvironment.Production
            goto L_0x0024
        L_0x0022:
            com.stripe.android.googlepaylauncher.GooglePayEnvironment r3 = com.stripe.android.googlepaylauncher.GooglePayEnvironment.Test
        L_0x0024:
            r4 = r3
            java.lang.String r5 = r2.getCountryCode()
            java.lang.String r6 = r0.getMerchantDisplayName()
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 56
            r11 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherFactory r3 = r12.googlePayPaymentMethodLauncherFactory
            kotlinx.coroutines.CoroutineScope r4 = r12.lifecycleScope
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController$launchGooglePay$1 r0 = com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController$launchGooglePay$1.INSTANCE
            r6 = r0
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$ReadyCallback r6 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.ReadyCallback) r6
            androidx.activity.result.ActivityResultLauncher<com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract$Args> r7 = r12.googlePayActivityLauncher
            r8 = 1
            r5 = r1
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher r0 = r3.create(r4, r5, r6, r7, r8)
            com.stripe.android.model.StripeIntent r1 = r13.getStripeIntent()
            boolean r3 = r1 instanceof com.stripe.android.model.PaymentIntent
            r4 = 0
            if (r3 == 0) goto L_0x0054
            com.stripe.android.model.PaymentIntent r1 = (com.stripe.android.model.PaymentIntent) r1
            goto L_0x0055
        L_0x0054:
            r1 = r4
        L_0x0055:
            if (r1 != 0) goto L_0x0059
            r1 = r4
            goto L_0x005d
        L_0x0059:
            java.lang.String r1 = r1.getCurrency()
        L_0x005d:
            if (r1 != 0) goto L_0x0067
            java.lang.String r1 = r2.getCurrencyCode()
            if (r1 != 0) goto L_0x0067
            java.lang.String r1 = ""
        L_0x0067:
            com.stripe.android.model.StripeIntent r2 = r13.getStripeIntent()
            boolean r3 = r2 instanceof com.stripe.android.model.PaymentIntent
            if (r3 == 0) goto L_0x0072
            r4 = r2
            com.stripe.android.model.PaymentIntent r4 = (com.stripe.android.model.PaymentIntent) r4
        L_0x0072:
            r2 = 0
            if (r4 != 0) goto L_0x0076
            goto L_0x0082
        L_0x0076:
            java.lang.Long r3 = r4.getAmount()
            if (r3 != 0) goto L_0x007d
            goto L_0x0082
        L_0x007d:
            long r2 = r3.longValue()
            int r2 = (int) r2
        L_0x0082:
            com.stripe.android.model.StripeIntent r13 = r13.getStripeIntent()
            java.lang.String r13 = r13.getId()
            r0.present(r1, r2, r13)
            return
        L_0x008e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r1.toString()
            r13.<init>(r0)
            throw r13
        L_0x0098:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r1.toString()
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController.launchGooglePay(com.stripe.android.paymentsheet.flowcontroller.InitData):void");
    }

    /* access modifiers changed from: private */
    public final PaymentSheetResult createPaymentSheetResult(PaymentResult paymentResult) {
        if (paymentResult instanceof PaymentResult.Completed) {
            return PaymentSheetResult.Completed.INSTANCE;
        }
        if (paymentResult instanceof PaymentResult.Canceled) {
            return PaymentSheetResult.Canceled.INSTANCE;
        }
        if (paymentResult instanceof PaymentResult.Failed) {
            return new PaymentSheetResult.Failed(((PaymentResult.Failed) paymentResult).getThrowable());
        }
        return new PaymentSheetResult.Failed(new RuntimeException("Failed to complete payment."));
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/DefaultFlowController$GooglePayException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultFlowController.kt */
    public static final class GooglePayException extends Exception {
        public static final int $stable = 8;
        private final Throwable throwable;

        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GooglePayException(Throwable th) {
            super(th);
            Intrinsics.checkNotNullParameter(th, "throwable");
            this.throwable = th;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/DefaultFlowController$Args;", "Landroid/os/Parcelable;", "clientSecret", "", "config", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "(Ljava/lang/String;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;)V", "getClientSecret", "()Ljava/lang/String;", "getConfig", "()Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultFlowController.kt */
    public static final class Args implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        private final String clientSecret;
        private final PaymentSheet.Configuration config;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DefaultFlowController.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Args(parcel.readString(), parcel.readInt() == 0 ? null : PaymentSheet.Configuration.CREATOR.createFromParcel(parcel));
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        public static /* synthetic */ Args copy$default(Args args, String str, PaymentSheet.Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                str = args.clientSecret;
            }
            if ((i & 2) != 0) {
                configuration = args.config;
            }
            return args.copy(str, configuration);
        }

        public final String component1() {
            return this.clientSecret;
        }

        public final PaymentSheet.Configuration component2() {
            return this.config;
        }

        public final Args copy(String str, PaymentSheet.Configuration configuration) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return new Args(str, configuration);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Args)) {
                return false;
            }
            Args args = (Args) obj;
            return Intrinsics.areEqual((Object) this.clientSecret, (Object) args.clientSecret) && Intrinsics.areEqual((Object) this.config, (Object) args.config);
        }

        public int hashCode() {
            int hashCode = this.clientSecret.hashCode() * 31;
            PaymentSheet.Configuration configuration = this.config;
            return hashCode + (configuration == null ? 0 : configuration.hashCode());
        }

        public String toString() {
            return "Args(clientSecret=" + this.clientSecret + ", config=" + this.config + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.clientSecret);
            PaymentSheet.Configuration configuration = this.config;
            if (configuration == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            configuration.writeToParcel(parcel, i);
        }

        public Args(String str, PaymentSheet.Configuration configuration) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            this.clientSecret = str;
            this.config = configuration;
        }

        public final String getClientSecret() {
            return this.clientSecret;
        }

        public final PaymentSheet.Configuration getConfig() {
            return this.config;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/DefaultFlowController$Companion;", "", "()V", "getInstance", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "appContext", "Landroid/content/Context;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "statusBarColor", "Lkotlin/Function0;", "", "paymentOptionFactory", "Lcom/stripe/android/paymentsheet/model/PaymentOptionFactory;", "paymentOptionCallback", "Lcom/stripe/android/paymentsheet/PaymentOptionCallback;", "paymentResultCallback", "Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultFlowController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaymentSheet.FlowController getInstance(Context context, ViewModelStoreOwner viewModelStoreOwner, CoroutineScope coroutineScope, LifecycleOwner lifecycleOwner, ActivityResultCaller activityResultCaller, Function0<Integer> function0, PaymentOptionFactory paymentOptionFactory, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback) {
            Intrinsics.checkNotNullParameter(context, "appContext");
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
            Intrinsics.checkNotNullParameter(coroutineScope, "lifecycleScope");
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
            Intrinsics.checkNotNullParameter(function0, "statusBarColor");
            Intrinsics.checkNotNullParameter(paymentOptionFactory, "paymentOptionFactory");
            Intrinsics.checkNotNullParameter(paymentOptionCallback, "paymentOptionCallback");
            Intrinsics.checkNotNullParameter(paymentSheetResultCallback, "paymentResultCallback");
            WeakMapInjectorRegistry weakMapInjectorRegistry = WeakMapInjectorRegistry.INSTANCE;
            String simpleName = Reflection.getOrCreateKotlinClass(PaymentSheet.FlowController.class).getSimpleName();
            if (simpleName != null) {
                String nextKey = weakMapInjectorRegistry.nextKey(simpleName);
                FlowControllerComponent build = DaggerFlowControllerComponent.builder().appContext(context).viewModelStoreOwner(viewModelStoreOwner).lifecycleScope(coroutineScope).lifeCycleOwner(lifecycleOwner).activityResultCaller(activityResultCaller).statusBarColor(function0).paymentOptionFactory(paymentOptionFactory).paymentOptionCallback(paymentOptionCallback).paymentResultCallback(paymentSheetResultCallback).injectorKey(nextKey).build();
                DefaultFlowController flowController = build.getFlowController();
                flowController.setFlowControllerComponent(build);
                WeakMapInjectorRegistry.INSTANCE.register(flowController, nextKey);
                return flowController;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }
}
