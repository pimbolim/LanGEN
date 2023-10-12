package com.reactnativestripesdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stripe.android.PaymentAuthConfig;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.Stripe;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.injection.NamedConstantsKt;
import com.stripe.android.model.Address;
import com.stripe.android.model.BankAccountTokenParams;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.MandateDataParams;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.payments.bankaccount.CollectBankAccountConfiguration;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.view.AddPaymentMethodActivityStarter;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001d\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J\u0010\u00103\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J(\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\u0006\u00106\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J\u0010\u00107\u001a\u00020,2\u0006\u00102\u001a\u00020\u0014H\u0007J(\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\u0006\u00106\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J\u0018\u0010:\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J \u0010;\u001a\u00020,2\u0006\u0010<\u001a\u0002012\u0006\u00106\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J\u0018\u0010=\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J\u0018\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0014H\u0007J\u0018\u0010@\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0002J\u0018\u0010A\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0002J\u0014\u0010B\u001a\u0004\u0018\u00010C2\b\u00102\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010D\u001a\u00020\u0012H\u0016J\u0018\u0010E\u001a\u00020,2\u0006\u00105\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0014H\u0007J\u0018\u0010F\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J\u0018\u0010G\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J\u0018\u0010H\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J\u001a\u0010I\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u0014H\u0007J\u0010\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020,H\u0002J\u0018\u0010N\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007J\u0010\u0010O\u001a\u00020,2\u0006\u00102\u001a\u00020\u0014H\u0007J\u0018\u0010P\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0014H\u0007J\u0018\u0010Q\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0014H\u0007J(\u0010R\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0007R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/reactnativestripesdk/StripeSdkModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "cardFieldView", "Lcom/reactnativestripesdk/CardFieldView;", "getCardFieldView", "()Lcom/reactnativestripesdk/CardFieldView;", "setCardFieldView", "(Lcom/reactnativestripesdk/CardFieldView;)V", "cardFormView", "Lcom/reactnativestripesdk/CardFormView;", "getCardFormView", "()Lcom/reactnativestripesdk/CardFormView;", "setCardFormView", "(Lcom/reactnativestripesdk/CardFormView;)V", "confirmPaymentClientSecret", "", "confirmPaymentSheetPaymentPromise", "Lcom/facebook/react/bridge/Promise;", "confirmPromise", "googlePayFragment", "Lcom/reactnativestripesdk/GooglePayFragment;", "googlePayReceiver", "Landroid/content/BroadcastReceiver;", "initGooglePayPromise", "initPaymentSheetPromise", "mActivityEventListener", "com/reactnativestripesdk/StripeSdkModule$mActivityEventListener$1", "Lcom/reactnativestripesdk/StripeSdkModule$mActivityEventListener$1;", "mPaymentSheetReceiver", "paymentLauncherFragment", "Lcom/reactnativestripesdk/PaymentLauncherFragment;", "paymentSheetFragment", "Lcom/reactnativestripesdk/PaymentSheetFragment;", "presentGooglePayPromise", "presentPaymentSheetPromise", "publishableKey", "stripe", "Lcom/stripe/android/Stripe;", "stripeAccountId", "urlScheme", "collectBankAccount", "", "isPaymentIntent", "", "clientSecret", "params", "Lcom/facebook/react/bridge/ReadableMap;", "promise", "configure3dSecure", "confirmPayment", "paymentIntentClientSecret", "options", "confirmPaymentSheetPayment", "confirmSetupIntent", "setupIntentClientSecret", "createGooglePayPaymentMethod", "createPaymentMethod", "data", "createToken", "createTokenForCVCUpdate", "cvc", "createTokenFromBankAccount", "createTokenFromCard", "getCurrentActivityOrResolveWithError", "Landroidx/appcompat/app/AppCompatActivity;", "getName", "handleNextAction", "initGooglePay", "initPaymentSheet", "initialise", "isGooglePaySupported", "onFpxPaymentMethodResult", "result", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result;", "payWithFpx", "presentGooglePay", "presentPaymentSheet", "retrievePaymentIntent", "retrieveSetupIntent", "verifyMicrodeposits", "Companion", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ReactModule(name = "StripeSdk")
/* compiled from: StripeSdkModule.kt */
public final class StripeSdkModule extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NAME = "StripeSdk";
    private CardFieldView cardFieldView;
    private CardFormView cardFormView;
    private String confirmPaymentClientSecret;
    /* access modifiers changed from: private */
    public Promise confirmPaymentSheetPaymentPromise;
    private Promise confirmPromise;
    /* access modifiers changed from: private */
    public GooglePayFragment googlePayFragment;
    private final BroadcastReceiver googlePayReceiver = new StripeSdkModule$googlePayReceiver$1(this);
    /* access modifiers changed from: private */
    public Promise initGooglePayPromise;
    /* access modifiers changed from: private */
    public Promise initPaymentSheetPromise;
    private final StripeSdkModule$mActivityEventListener$1 mActivityEventListener;
    private final BroadcastReceiver mPaymentSheetReceiver = new StripeSdkModule$mPaymentSheetReceiver$1(this);
    private PaymentLauncherFragment paymentLauncherFragment;
    /* access modifiers changed from: private */
    public PaymentSheetFragment paymentSheetFragment;
    /* access modifiers changed from: private */
    public Promise presentGooglePayPromise;
    /* access modifiers changed from: private */
    public Promise presentPaymentSheetPromise;
    private String publishableKey;
    private final ReactApplicationContext reactContext;
    /* access modifiers changed from: private */
    public Stripe stripe;
    /* access modifiers changed from: private */
    public String stripeAccountId;
    private String urlScheme;

    public String getName() {
        return NAME;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StripeSdkModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        this.reactContext = reactApplicationContext;
        StripeSdkModule$mActivityEventListener$1 stripeSdkModule$mActivityEventListener$1 = new StripeSdkModule$mActivityEventListener$1(this);
        this.mActivityEventListener = stripeSdkModule$mActivityEventListener$1;
        reactApplicationContext.addActivityEventListener(stripeSdkModule$mActivityEventListener$1);
    }

    public final CardFieldView getCardFieldView() {
        return this.cardFieldView;
    }

    public final void setCardFieldView(CardFieldView cardFieldView2) {
        this.cardFieldView = cardFieldView2;
    }

    public final CardFormView getCardFormView() {
        return this.cardFormView;
    }

    public final void setCardFormView(CardFormView cardFormView2) {
        this.cardFormView = cardFormView2;
    }

    private final void configure3dSecure(ReadableMap readableMap) {
        PaymentAuthConfig.Stripe3ds2Config.Builder builder = new PaymentAuthConfig.Stripe3ds2Config.Builder();
        if (readableMap.hasKey("timeout")) {
            builder.setTimeout(readableMap.getInt("timeout"));
        }
        PaymentAuthConfig.Companion.init(new PaymentAuthConfig.Builder().set3ds2Config(builder.setUiCustomization(MappersKt.mapToUICustomization(readableMap)).build()).build());
    }

    @ReactMethod
    public final void initialise(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String valOr = MappersKt.getValOr(readableMap, "publishableKey", (String) null);
        Objects.requireNonNull(valOr, "null cannot be cast to non-null type kotlin.String");
        ReadableMap mapOrNull = MappersKt.getMapOrNull(readableMap, "appInfo");
        Objects.requireNonNull(mapOrNull, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
        this.stripeAccountId = MappersKt.getValOr(readableMap, NamedConstantsKt.STRIPE_ACCOUNT_ID, (String) null);
        String valOr2 = MappersKt.getValOr(readableMap, "urlScheme", (String) null);
        if (!MappersKt.getBooleanOrFalse(readableMap, "setReturnUrlSchemeOnAndroid")) {
            valOr2 = null;
        }
        this.urlScheme = valOr2;
        ReadableMap mapOrNull2 = MappersKt.getMapOrNull(readableMap, "threeDSecureParams");
        if (mapOrNull2 != null) {
            configure3dSecure(mapOrNull2);
        }
        this.publishableKey = valOr;
        String valOr3 = MappersKt.getValOr(mapOrNull, "name", "");
        Objects.requireNonNull(valOr3, "null cannot be cast to non-null type kotlin.String");
        Stripe.Companion.setAppInfo(AppInfo.Companion.create(valOr3, MappersKt.getValOr(mapOrNull, "version", ""), MappersKt.getValOr(mapOrNull, "url", ""), MappersKt.getValOr(mapOrNull, "partnerId", "")));
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
        this.stripe = new Stripe((Context) reactApplicationContext, valOr, this.stripeAccountId, false, (Set) null, 24, (DefaultConstructorMarker) null);
        PaymentConfiguration.Companion companion = PaymentConfiguration.Companion;
        ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "reactApplicationContext");
        companion.init(reactApplicationContext2, valOr, this.stripeAccountId);
        Stripe stripe2 = this.stripe;
        if (stripe2 != null) {
            this.paymentLauncherFragment = new PaymentLauncherFragment(stripe2, valOr, this.stripeAccountId);
            AppCompatActivity currentActivityOrResolveWithError = getCurrentActivityOrResolveWithError(promise);
            if (currentActivityOrResolveWithError != null) {
                FragmentTransaction beginTransaction = currentActivityOrResolveWithError.getSupportFragmentManager().beginTransaction();
                PaymentLauncherFragment paymentLauncherFragment2 = this.paymentLauncherFragment;
                if (paymentLauncherFragment2 != null) {
                    beginTransaction.add((Fragment) paymentLauncherFragment2, "payment_launcher_fragment").commit();
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(getReactApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(instance, "getInstance(reactApplicationContext)");
                    instance.registerReceiver(this.mPaymentSheetReceiver, new IntentFilter(ConstantsKt.getON_PAYMENT_RESULT_ACTION()));
                    instance.registerReceiver(this.mPaymentSheetReceiver, new IntentFilter(ConstantsKt.getON_PAYMENT_OPTION_ACTION()));
                    instance.registerReceiver(this.mPaymentSheetReceiver, new IntentFilter(ConstantsKt.getON_CONFIGURE_FLOW_CONTROLLER()));
                    instance.registerReceiver(this.mPaymentSheetReceiver, new IntentFilter(ConstantsKt.getON_INIT_PAYMENT_SHEET()));
                    instance.registerReceiver(this.googlePayReceiver, new IntentFilter(ConstantsKt.getON_INIT_GOOGLE_PAY()));
                    instance.registerReceiver(this.googlePayReceiver, new IntentFilter(ConstantsKt.getON_GOOGLE_PAY_RESULT()));
                    instance.registerReceiver(this.googlePayReceiver, new IntentFilter(ConstantsKt.getON_GOOGLE_PAYMENT_METHOD_RESULT()));
                    promise.resolve((Object) null);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("paymentLauncherFragment");
                throw null;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stripe");
        throw null;
    }

    @ReactMethod
    public final void initPaymentSheet(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        AppCompatActivity currentActivityOrResolveWithError = getCurrentActivityOrResolveWithError(promise);
        if (currentActivityOrResolveWithError != null) {
            this.initPaymentSheetPromise = promise;
            PaymentSheetFragment paymentSheetFragment2 = new PaymentSheetFragment();
            paymentSheetFragment2.setArguments(MappersKt.toBundleObject(readableMap));
            Unit unit = Unit.INSTANCE;
            this.paymentSheetFragment = paymentSheetFragment2;
            FragmentTransaction beginTransaction = currentActivityOrResolveWithError.getSupportFragmentManager().beginTransaction();
            PaymentSheetFragment paymentSheetFragment3 = this.paymentSheetFragment;
            Intrinsics.checkNotNull(paymentSheetFragment3);
            beginTransaction.add((Fragment) paymentSheetFragment3, "payment_sheet_launch_fragment").commit();
        }
    }

    @ReactMethod
    public final void presentPaymentSheet(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.presentPaymentSheetPromise = promise;
        PaymentSheetFragment paymentSheetFragment2 = this.paymentSheetFragment;
        if (paymentSheetFragment2 != null) {
            paymentSheetFragment2.present();
        }
    }

    @ReactMethod
    public final void confirmPaymentSheetPayment(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.confirmPaymentSheetPaymentPromise = promise;
        PaymentSheetFragment paymentSheetFragment2 = this.paymentSheetFragment;
        if (paymentSheetFragment2 != null) {
            paymentSheetFragment2.confirmPayment();
        }
    }

    private final void payWithFpx() {
        AppCompatActivity currentActivityOrResolveWithError = getCurrentActivityOrResolveWithError(this.confirmPromise);
        if (currentActivityOrResolveWithError != null) {
            new AddPaymentMethodActivityStarter((Activity) currentActivityOrResolveWithError).startForResult(new AddPaymentMethodActivityStarter.Args.Builder().setPaymentMethodType(PaymentMethod.Type.Fpx).build());
        }
    }

    /* access modifiers changed from: private */
    public final void onFpxPaymentMethodResult(AddPaymentMethodActivityStarter.Result result) {
        Promise promise;
        if (result instanceof AddPaymentMethodActivityStarter.Result.Success) {
            if (this.confirmPaymentClientSecret == null || this.confirmPromise == null) {
                Log.e("StripeReactNative", "FPX payment failed. Promise and/or client secret is not set.");
                Promise promise2 = this.confirmPromise;
                if (promise2 != null) {
                    promise2.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Failed.toString(), "FPX payment failed."));
                }
            } else {
                PaymentLauncherFragment paymentLauncherFragment2 = this.paymentLauncherFragment;
                if (paymentLauncherFragment2 != null) {
                    ConfirmPaymentIntentParams.Companion companion = ConfirmPaymentIntentParams.Companion;
                    String str = ((AddPaymentMethodActivityStarter.Result.Success) result).getPaymentMethod().id;
                    Intrinsics.checkNotNull(str);
                    String str2 = this.confirmPaymentClientSecret;
                    Intrinsics.checkNotNull(str2);
                    ConfirmPaymentIntentParams createWithPaymentMethodId$default = ConfirmPaymentIntentParams.Companion.createWithPaymentMethodId$default(companion, str, str2, (Boolean) null, (PaymentMethodOptionsParams) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, 252, (Object) null);
                    String str3 = this.confirmPaymentClientSecret;
                    Intrinsics.checkNotNull(str3);
                    Promise promise3 = this.confirmPromise;
                    Intrinsics.checkNotNull(promise3);
                    paymentLauncherFragment2.confirm(createWithPaymentMethodId$default, str3, promise3);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentLauncherFragment");
                    throw null;
                }
            }
        } else if (result instanceof AddPaymentMethodActivityStarter.Result.Failure) {
            Promise promise4 = this.confirmPromise;
            if (promise4 != null) {
                promise4.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Failed.toString(), ((AddPaymentMethodActivityStarter.Result.Failure) result).getException()));
            }
        } else if ((result instanceof AddPaymentMethodActivityStarter.Result.Canceled) && (promise = this.confirmPromise) != null) {
            promise.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Canceled.toString(), "The payment has been canceled"));
        }
        this.confirmPaymentClientSecret = null;
        this.confirmPromise = null;
    }

    @ReactMethod
    public final void createPaymentMethod(ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        ReadableMap readableMap3 = readableMap;
        Promise promise2 = promise;
        Intrinsics.checkNotNullParameter(readableMap3, "data");
        Intrinsics.checkNotNullParameter(readableMap2, "options");
        Intrinsics.checkNotNullParameter(promise2, BaseJavaModule.METHOD_TYPE_PROMISE);
        CardFieldView cardFieldView2 = this.cardFieldView;
        PaymentMethodCreateParams.Card cardParams = cardFieldView2 == null ? null : cardFieldView2.getCardParams();
        if (cardParams == null) {
            CardFormView cardFormView2 = this.cardFormView;
            cardParams = cardFormView2 == null ? null : cardFormView2.getCardParams();
            if (cardParams == null) {
                StripeSdkModule stripeSdkModule = this;
                promise2.resolve(ErrorsKt.createError("Failed", "Card details not complete"));
                return;
            }
        }
        PaymentMethodCreateParams.Card card = cardParams;
        CardFieldView cardFieldView3 = this.cardFieldView;
        Address cardAddress = cardFieldView3 == null ? null : cardFieldView3.getCardAddress();
        if (cardAddress == null) {
            CardFormView cardFormView3 = this.cardFormView;
            cardAddress = cardFormView3 == null ? null : cardFormView3.getCardAddress();
        }
        PaymentMethodCreateParams create$default = PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, card, MappersKt.mapToBillingDetails(MappersKt.getMapOrNull(readableMap3, "billingDetails"), cardAddress), (Map) null, 4, (Object) null);
        Stripe stripe2 = this.stripe;
        if (stripe2 != null) {
            Stripe.createPaymentMethod$default(stripe2, create$default, (String) null, (String) null, new StripeSdkModule$createPaymentMethod$1(promise2), 6, (Object) null);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("stripe");
            throw null;
        }
    }

    @ReactMethod
    public final void createToken(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String valOr = MappersKt.getValOr(readableMap, "type", (String) null);
        if (valOr == null) {
            promise.resolve(ErrorsKt.createError(CreateTokenErrorType.Failed.toString(), "type parameter is required"));
        } else if (Intrinsics.areEqual((Object) valOr, (Object) "BankAccount")) {
            createTokenFromBankAccount(readableMap, promise);
        } else if (Intrinsics.areEqual((Object) valOr, (Object) "Card")) {
            createTokenFromCard(readableMap, promise);
        } else {
            promise.resolve(ErrorsKt.createError(CreateTokenErrorType.Failed.toString(), Intrinsics.stringPlus(valOr, " type is not supported yet")));
        }
    }

    private final void createTokenFromBankAccount(ReadableMap readableMap, Promise promise) {
        String valOr = MappersKt.getValOr(readableMap, "accountHolderName", (String) null);
        String valOr2 = MappersKt.getValOr(readableMap, "accountHolderType", (String) null);
        String valOr3 = MappersKt.getValOr(readableMap, "accountNumber", (String) null);
        String valOr4 = MappersKt.getValOr(readableMap, "country", (String) null);
        String valOr5 = MappersKt.getValOr(readableMap, FirebaseAnalytics.Param.CURRENCY, (String) null);
        String valOr6 = MappersKt.getValOr(readableMap, "routingNumber", (String) null);
        Intrinsics.checkNotNull(valOr4);
        Intrinsics.checkNotNull(valOr5);
        Intrinsics.checkNotNull(valOr3);
        BankAccountTokenParams bankAccountTokenParams = new BankAccountTokenParams(valOr4, valOr5, valOr3, MappersKt.mapToBankAccountType(valOr2), valOr, valOr6);
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new StripeSdkModule$createTokenFromBankAccount$1(this, bankAccountTokenParams, promise, (Continuation<? super StripeSdkModule$createTokenFromBankAccount$1>) null), 3, (Object) null);
    }

    private final void createTokenFromCard(ReadableMap readableMap, Promise promise) {
        ReadableMap readableMap2 = readableMap;
        Promise promise2 = promise;
        CardFieldView cardFieldView2 = this.cardFieldView;
        PaymentMethodCreateParams.Card cardParams = cardFieldView2 == null ? null : cardFieldView2.getCardParams();
        if (cardParams == null) {
            CardFormView cardFormView2 = this.cardFormView;
            cardParams = cardFormView2 == null ? null : cardFormView2.getCardParams();
        }
        Map<String, Object> paramMap = cardParams == null ? null : cardParams.toParamMap();
        if (paramMap == null) {
            StripeSdkModule stripeSdkModule = this;
            promise2.resolve(ErrorsKt.createError(CreateTokenErrorType.Failed.toString(), "Card details not complete"));
            return;
        }
        CardFieldView cardFieldView3 = this.cardFieldView;
        Address cardAddress = cardFieldView3 == null ? null : cardFieldView3.getCardAddress();
        if (cardAddress == null) {
            CardFormView cardFormView3 = this.cardFormView;
            cardAddress = cardFormView3 == null ? null : cardFormView3.getCardAddress();
        }
        ReadableMap mapOrNull = MappersKt.getMapOrNull(readableMap2, PaymentMethod.BillingDetails.PARAM_ADDRESS);
        Object obj = paramMap.get("number");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        Object obj2 = paramMap.get("exp_month");
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj2).intValue();
        Object obj3 = paramMap.get("exp_year");
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
        int intValue2 = ((Integer) obj3).intValue();
        Object obj4 = paramMap.get("cvc");
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.String");
        CardParams cardParams2 = new CardParams((String) obj, intValue, intValue2, (String) obj4, MappersKt.getValOr(readableMap2, "name", (String) null), MappersKt.mapToAddress(mapOrNull, cardAddress), MappersKt.getValOr(readableMap2, FirebaseAnalytics.Param.CURRENCY, (String) null), (Map) null, 128, (DefaultConstructorMarker) null);
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new StripeSdkModule$createTokenFromCard$1(this, cardParams2, promise2, (Continuation<? super StripeSdkModule$createTokenFromCard$1>) null), 3, (Object) null);
    }

    @ReactMethod
    public final void createTokenForCVCUpdate(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "cvc");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Stripe stripe2 = this.stripe;
        if (stripe2 != null) {
            Stripe.createCvcUpdateToken$default(stripe2, str, (String) null, (String) null, new StripeSdkModule$createTokenForCVCUpdate$1(promise), 6, (Object) null);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stripe");
        throw null;
    }

    @ReactMethod
    public final void handleNextAction(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "paymentIntentClientSecret");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        PaymentLauncherFragment paymentLauncherFragment2 = this.paymentLauncherFragment;
        if (paymentLauncherFragment2 != null) {
            paymentLauncherFragment2.handleNextActionForPaymentIntent(str, promise);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("paymentLauncherFragment");
            throw null;
        }
    }

    @ReactMethod
    public final void confirmPayment(String str, ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "paymentIntentClientSecret");
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(readableMap2, "options");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String valOr$default = MappersKt.getValOr$default(readableMap, "type", (String) null, 4, (Object) null);
        PaymentMethod.Type mapToPaymentMethodType = valOr$default == null ? null : MappersKt.mapToPaymentMethodType(valOr$default);
        if (mapToPaymentMethodType == null) {
            StripeSdkModule stripeSdkModule = this;
            promise.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Failed.toString(), "You must provide paymentMethodType"));
            return;
        }
        boolean booleanOrFalse = MappersKt.getBooleanOrFalse(readableMap, "testOfflineBank");
        if (mapToPaymentMethodType != PaymentMethod.Type.Fpx || booleanOrFalse) {
            try {
                ConfirmPaymentIntentParams createConfirmParams = new PaymentMethodCreateParamsFactory(str, readableMap, this.cardFieldView, this.cardFormView).createConfirmParams(mapToPaymentMethodType);
                String str2 = this.urlScheme;
                if (str2 != null) {
                    createConfirmParams.setReturnUrl(MappersKt.mapToReturnURL(str2));
                }
                createConfirmParams.setShipping(MappersKt.mapToShippingDetails(MappersKt.getMapOrNull(readableMap, "shippingDetails")));
                PaymentLauncherFragment paymentLauncherFragment2 = this.paymentLauncherFragment;
                if (paymentLauncherFragment2 != null) {
                    paymentLauncherFragment2.confirm(createConfirmParams, str, promise);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentLauncherFragment");
                    throw null;
                }
            } catch (PaymentMethodCreateParamsException e) {
                promise.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Failed.toString(), (Exception) e));
            }
        } else {
            this.confirmPaymentClientSecret = str;
            this.confirmPromise = promise;
            payWithFpx();
        }
    }

    @ReactMethod
    public final void retrievePaymentIntent(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new StripeSdkModule$retrievePaymentIntent$1(this, str, promise, (Continuation<? super StripeSdkModule$retrievePaymentIntent$1>) null), 3, (Object) null);
    }

    @ReactMethod
    public final void retrieveSetupIntent(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new StripeSdkModule$retrieveSetupIntent$1(this, str, promise, (Continuation<? super StripeSdkModule$retrieveSetupIntent$1>) null), 3, (Object) null);
    }

    @ReactMethod
    public final void confirmSetupIntent(String str, ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "setupIntentClientSecret");
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(readableMap2, "options");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String valOr$default = MappersKt.getValOr$default(readableMap, "type", (String) null, 4, (Object) null);
        PaymentMethod.Type mapToPaymentMethodType = valOr$default == null ? null : MappersKt.mapToPaymentMethodType(valOr$default);
        if (mapToPaymentMethodType == null) {
            StripeSdkModule stripeSdkModule = this;
            promise.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Failed.toString(), "You must provide paymentMethodType"));
            return;
        }
        try {
            ConfirmSetupIntentParams createSetupParams = new PaymentMethodCreateParamsFactory(str, readableMap, this.cardFieldView, this.cardFormView).createSetupParams(mapToPaymentMethodType);
            String str2 = this.urlScheme;
            if (str2 != null) {
                createSetupParams.setReturnUrl(MappersKt.mapToReturnURL(str2));
            }
            PaymentLauncherFragment paymentLauncherFragment2 = this.paymentLauncherFragment;
            if (paymentLauncherFragment2 != null) {
                paymentLauncherFragment2.confirm(createSetupParams, str, promise);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("paymentLauncherFragment");
                throw null;
            }
        } catch (PaymentMethodCreateParamsException e) {
            promise.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Failed.toString(), (Exception) e));
        }
    }

    @ReactMethod
    public final void isGooglePaySupported(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        GooglePayPaymentMethodLauncherFragment googlePayPaymentMethodLauncherFragment = new GooglePayPaymentMethodLauncherFragment(this.reactContext, MappersKt.getBooleanOrFalse(readableMap, "testEnv"), MappersKt.getBooleanOrFalse(readableMap, "existingPaymentMethodRequired"), promise);
        AppCompatActivity currentActivityOrResolveWithError = getCurrentActivityOrResolveWithError(promise);
        if (currentActivityOrResolveWithError != null) {
            currentActivityOrResolveWithError.getSupportFragmentManager().beginTransaction().add((Fragment) googlePayPaymentMethodLauncherFragment, "google_pay_support_fragment").commit();
        }
    }

    @ReactMethod
    public final void initGooglePay(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        GooglePayFragment googlePayFragment2 = new GooglePayFragment();
        googlePayFragment2.setArguments(MappersKt.toBundleObject(readableMap));
        Unit unit = Unit.INSTANCE;
        this.googlePayFragment = googlePayFragment2;
        AppCompatActivity currentActivityOrResolveWithError = getCurrentActivityOrResolveWithError(promise);
        if (currentActivityOrResolveWithError != null) {
            this.initGooglePayPromise = promise;
            FragmentTransaction beginTransaction = currentActivityOrResolveWithError.getSupportFragmentManager().beginTransaction();
            GooglePayFragment googlePayFragment3 = this.googlePayFragment;
            Intrinsics.checkNotNull(googlePayFragment3);
            beginTransaction.add((Fragment) googlePayFragment3, "google_pay_launch_fragment").commit();
        }
    }

    @ReactMethod
    public final void presentGooglePay(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String valOr$default = MappersKt.getValOr$default(readableMap, "clientSecret", (String) null, 4, (Object) null);
        if (valOr$default == null) {
            StripeSdkModule stripeSdkModule = this;
            promise.resolve(ErrorsKt.createError(GooglePayErrorType.Failed.toString(), "you must provide clientSecret"));
            return;
        }
        this.presentGooglePayPromise = promise;
        if (MappersKt.getBooleanOrFalse(readableMap, "forSetupIntent")) {
            String valOr$default2 = MappersKt.getValOr$default(readableMap, "currencyCode", (String) null, 4, (Object) null);
            if (valOr$default2 == null) {
                StripeSdkModule stripeSdkModule2 = this;
                promise.resolve(ErrorsKt.createError(GooglePayErrorType.Failed.toString(), "you must provide currencyCode"));
                return;
            }
            GooglePayFragment googlePayFragment2 = this.googlePayFragment;
            if (googlePayFragment2 != null) {
                googlePayFragment2.presentForSetupIntent(valOr$default, valOr$default2);
                return;
            }
            return;
        }
        GooglePayFragment googlePayFragment3 = this.googlePayFragment;
        if (googlePayFragment3 != null) {
            googlePayFragment3.presentForPaymentIntent(valOr$default);
        }
    }

    @ReactMethod
    public final void createGooglePayPaymentMethod(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String valOr = MappersKt.getValOr(readableMap, "currencyCode", (String) null);
        if (valOr == null) {
            StripeSdkModule stripeSdkModule = this;
            promise.resolve(ErrorsKt.createError(GooglePayErrorType.Failed.toString(), "you must provide currencyCode"));
            return;
        }
        Integer intOrNull = MappersKt.getIntOrNull(readableMap, BaseSheetViewModel.SAVE_AMOUNT);
        if (intOrNull == null) {
            StripeSdkModule stripeSdkModule2 = this;
            promise.resolve(ErrorsKt.createError(GooglePayErrorType.Failed.toString(), "you must provide amount"));
            return;
        }
        int intValue = intOrNull.intValue();
        this.presentGooglePayPromise = promise;
        GooglePayFragment googlePayFragment2 = this.googlePayFragment;
        if (googlePayFragment2 != null) {
            googlePayFragment2.createPaymentMethod(valOr, intValue);
        }
    }

    @ReactMethod
    public final void collectBankAccount(boolean z, String str, ReadableMap readableMap, Promise promise) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (MappersKt.mapToPaymentMethodType(MappersKt.getValOr(readableMap, "type", (String) null)) != PaymentMethod.Type.USBankAccount) {
            promise.resolve(ErrorsKt.createError(ErrorType.Failed.toString(), "collectBankAccount currently only accepts the USBankAccount payment method type."));
            return;
        }
        ReadableMap mapOrNull = MappersKt.getMapOrNull(readableMap, "billingDetails");
        if (mapOrNull == null) {
            str2 = null;
        } else {
            str2 = mapOrNull.getString("name");
        }
        CharSequence charSequence = str2;
        if (charSequence == null || charSequence.length() == 0) {
            promise.resolve(ErrorsKt.createError(ErrorType.Failed.toString(), "You must provide a name when collecting US bank account details."));
            return;
        }
        CollectBankAccountConfiguration.USBankAccount uSBankAccount = new CollectBankAccountConfiguration.USBankAccount(str2, mapOrNull.getString("email"));
        ReactApplicationContext reactApplicationContext = this.reactContext;
        String str3 = this.publishableKey;
        if (str3 != null) {
            CollectBankAccountLauncherFragment collectBankAccountLauncherFragment = new CollectBankAccountLauncherFragment(reactApplicationContext, str3, str, z, uSBankAccount, promise);
            AppCompatActivity currentActivityOrResolveWithError = getCurrentActivityOrResolveWithError(promise);
            if (currentActivityOrResolveWithError != null) {
                currentActivityOrResolveWithError.getSupportFragmentManager().beginTransaction().add((Fragment) collectBankAccountLauncherFragment, "collect_bank_account_launcher_fragment").commit();
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("publishableKey");
        throw null;
    }

    @ReactMethod
    public final void verifyMicrodeposits(boolean z, String str, ReadableMap readableMap, Promise promise) {
        Unit unit;
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(readableMap, "params");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        ReadableArray array = readableMap.getArray("amounts");
        String string = readableMap.getString("descriptorCode");
        if ((array == null || string == null) && !(array == null && string == null)) {
            StripeSdkModule$verifyMicrodeposits$paymentCallback$1 stripeSdkModule$verifyMicrodeposits$paymentCallback$1 = new StripeSdkModule$verifyMicrodeposits$paymentCallback$1(promise);
            StripeSdkModule$verifyMicrodeposits$setupCallback$1 stripeSdkModule$verifyMicrodeposits$setupCallback$1 = new StripeSdkModule$verifyMicrodeposits$setupCallback$1(promise);
            if (array == null) {
                unit = null;
            } else if (array.size() != 2) {
                promise.resolve(ErrorsKt.createError(ErrorType.Failed.toString(), Intrinsics.stringPlus("Expected 2 integers in the amounts array, but received ", Integer.valueOf(array.size()))));
                return;
            } else {
                if (z) {
                    Stripe stripe2 = this.stripe;
                    if (stripe2 != null) {
                        stripe2.verifyPaymentIntentWithMicrodeposits(str, array.getInt(0), array.getInt(1), stripeSdkModule$verifyMicrodeposits$paymentCallback$1);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("stripe");
                        throw null;
                    }
                } else {
                    Stripe stripe3 = this.stripe;
                    if (stripe3 != null) {
                        stripe3.verifySetupIntentWithMicrodeposits(str, array.getInt(0), array.getInt(1), stripeSdkModule$verifyMicrodeposits$setupCallback$1);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("stripe");
                        throw null;
                    }
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null && string != null) {
                if (z) {
                    Stripe stripe4 = this.stripe;
                    if (stripe4 != null) {
                        stripe4.verifyPaymentIntentWithMicrodeposits(str, string, stripeSdkModule$verifyMicrodeposits$paymentCallback$1);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("stripe");
                        throw null;
                    }
                } else {
                    Stripe stripe5 = this.stripe;
                    if (stripe5 != null) {
                        stripe5.verifySetupIntentWithMicrodeposits(str, string, stripeSdkModule$verifyMicrodeposits$setupCallback$1);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("stripe");
                        throw null;
                    }
                }
            }
        } else {
            promise.resolve(ErrorsKt.createError(ErrorType.Failed.toString(), "You must provide either amounts OR descriptorCode, not both."));
        }
    }

    private final AppCompatActivity getCurrentActivityOrResolveWithError(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        AppCompatActivity appCompatActivity = currentActivity instanceof AppCompatActivity ? (AppCompatActivity) currentActivity : null;
        if (appCompatActivity != null) {
            return appCompatActivity;
        }
        if (promise != null) {
            promise.resolve(ErrorsKt.createMissingActivityError());
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reactnativestripesdk/StripeSdkModule$Companion;", "", "()V", "NAME", "", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: StripeSdkModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
