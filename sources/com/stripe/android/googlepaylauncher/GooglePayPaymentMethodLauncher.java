package com.stripe.android.googlepaylauncher;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.LifecycleOwnerKt;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.injection.WeakMapInjectorRegistry;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import com.stripe.android.googlepaylauncher.injection.DaggerGooglePayPaymentMethodLauncherComponent;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherComponent;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.Set;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationTarget;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001/\b\u0007\u0018\u0000 >2\u00020\u0001:\u0007=>?@ABCB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rB7\b\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0014B¿\u0001\b\u0001\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b\u0012\u000e\b\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u000e\b\u0001\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"\u0012\u0010\b\u0001\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\"\u0012\b\b\u0003\u0010$\u001a\u00020\u0019\u0012\b\b\u0003\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020(\u0012\b\b\u0002\u0010)\u001a\u00020*\u0012\b\b\u0002\u0010+\u001a\u00020,¢\u0006\u0002\u0010-J&\u00107\u001a\u0002082\u0006\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010 H\u0007R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0004¢\u0006\u0004\n\u0002\u00100R\u0016\u00101\u001a\u00020 8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b2\u00103R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\"X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher;", "", "activity", "Landroidx/activity/ComponentActivity;", "config", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "readyCallback", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ReadyCallback;", "resultCallback", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ResultCallback;", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ReadyCallback;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ResultCallback;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ReadyCallback;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ResultCallback;)V", "context", "Landroid/content/Context;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Landroidx/activity/result/ActivityResultCaller;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ReadyCallback;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ResultCallback;)V", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "skipReadyCheck", "", "googlePayRepositoryFactory", "Lkotlin/Function1;", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "productUsage", "", "", "publishableKeyProvider", "Lkotlin/Function0;", "stripeAccountIdProvider", "enableLogging", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ReadyCallback;Landroidx/activity/result/ActivityResultLauncher;ZLandroid/content/Context;Lkotlin/jvm/functions/Function1;Ljava/util/Set;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/coroutines/CoroutineContext;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/StripeRepository;)V", "injector", "com/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$injector$1", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$injector$1;", "injectorKey", "getInjectorKey$annotations", "()V", "isReady", "launcherComponent", "Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherComponent;", "present", "", "currencyCode", "amount", "", "transactionId", "BillingAddressConfig", "Companion", "Config", "ErrorCode", "ReadyCallback", "Result", "ResultCallback", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncher.kt */
public final class GooglePayPaymentMethodLauncher {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEVELOPER_ERROR = 2;
    public static final int INTERNAL_ERROR = 1;
    public static final int NETWORK_ERROR = 3;
    public static final String PRODUCT_USAGE_TOKEN = "GooglePayPaymentMethodLauncher";
    private final ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> activityResultLauncher;
    /* access modifiers changed from: private */
    public final Config config;
    private final boolean enableLogging;
    /* access modifiers changed from: private */
    public final Function1<GooglePayEnvironment, GooglePayRepository> googlePayRepositoryFactory;
    private final GooglePayPaymentMethodLauncher$injector$1 injector;
    private final String injectorKey;
    private final CoroutineContext ioContext;
    /* access modifiers changed from: private */
    public boolean isReady;
    /* access modifiers changed from: private */
    public final GooglePayPaymentMethodLauncherComponent launcherComponent;
    private final Set<String> productUsage;
    private final Function0<String> publishableKeyProvider;
    /* access modifiers changed from: private */
    public final ReadyCallback readyCallback;
    private final boolean skipReadyCheck;
    private final Function0<String> stripeAccountIdProvider;

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ErrorCode;", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: GooglePayPaymentMethodLauncher.kt */
    public @interface ErrorCode {
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ReadyCallback;", "", "onReady", "", "isReady", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncher.kt */
    public interface ReadyCallback {
        void onReady(boolean z);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$ResultCallback;", "", "onResult", "", "result", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncher.kt */
    public interface ResultCallback {
        void onResult(Result result);
    }

    @InjectorKey
    private static /* synthetic */ void getInjectorKey$annotations() {
    }

    public final void present(String str) {
        Intrinsics.checkNotNullParameter(str, "currencyCode");
        present$default(this, str, 0, (String) null, 6, (Object) null);
    }

    public final void present(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "currencyCode");
        present$default(this, str, i, (String) null, 4, (Object) null);
    }

    @AssistedInject
    public GooglePayPaymentMethodLauncher(@Assisted CoroutineScope coroutineScope, @Assisted Config config2, @Assisted ReadyCallback readyCallback2, @Assisted ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> activityResultLauncher2, @Assisted boolean z, Context context, Function1<GooglePayEnvironment, GooglePayRepository> function1, @Named("productUsage") Set<String> set, @Named("publishableKey") Function0<String> function0, @Named("stripeAccountId") Function0<String> function02, @Named("enableLogging") boolean z2, @IOContext CoroutineContext coroutineContext, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, AnalyticsRequestExecutor analyticsRequestExecutor, StripeRepository stripeRepository) {
        Config config3 = config2;
        ReadyCallback readyCallback3 = readyCallback2;
        ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> activityResultLauncher3 = activityResultLauncher2;
        boolean z3 = z;
        Context context2 = context;
        Function1<GooglePayEnvironment, GooglePayRepository> function12 = function1;
        Set<String> set2 = set;
        Function0<String> function03 = function0;
        Function0<String> function04 = function02;
        boolean z4 = z2;
        CoroutineContext coroutineContext2 = coroutineContext;
        PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2 = paymentAnalyticsRequestFactory;
        AnalyticsRequestExecutor analyticsRequestExecutor2 = analyticsRequestExecutor;
        StripeRepository stripeRepository2 = stripeRepository;
        Intrinsics.checkNotNullParameter(coroutineScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(config3, "config");
        Intrinsics.checkNotNullParameter(readyCallback3, "readyCallback");
        Intrinsics.checkNotNullParameter(activityResultLauncher3, "activityResultLauncher");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function12, "googlePayRepositoryFactory");
        Intrinsics.checkNotNullParameter(set2, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(function03, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(function04, "stripeAccountIdProvider");
        Intrinsics.checkNotNullParameter(coroutineContext2, "ioContext");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        this.config = config3;
        this.readyCallback = readyCallback3;
        this.activityResultLauncher = activityResultLauncher3;
        this.skipReadyCheck = z3;
        this.googlePayRepositoryFactory = function12;
        this.productUsage = set2;
        this.publishableKeyProvider = function03;
        this.stripeAccountIdProvider = function04;
        boolean z5 = z2;
        this.enableLogging = z5;
        this.ioContext = coroutineContext2;
        this.launcherComponent = DaggerGooglePayPaymentMethodLauncherComponent.builder().context(context2).ioContext(coroutineContext2).analyticsRequestFactory(paymentAnalyticsRequestFactory2).stripeRepository(stripeRepository2).googlePayConfig(config3).enableLogging(z5).publishableKeyProvider(function03).stripeAccountIdProvider(function04).build();
        WeakMapInjectorRegistry weakMapInjectorRegistry = WeakMapInjectorRegistry.INSTANCE;
        String simpleName = Reflection.getOrCreateKotlinClass(GooglePayPaymentMethodLauncher.class).getSimpleName();
        if (simpleName != null) {
            String nextKey = weakMapInjectorRegistry.nextKey(simpleName);
            this.injectorKey = nextKey;
            GooglePayPaymentMethodLauncher$injector$1 googlePayPaymentMethodLauncher$injector$1 = new GooglePayPaymentMethodLauncher$injector$1(this);
            this.injector = googlePayPaymentMethodLauncher$injector$1;
            WeakMapInjectorRegistry.INSTANCE.register(googlePayPaymentMethodLauncher$injector$1, nextKey);
            analyticsRequestExecutor2.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.GooglePayPaymentMethodLauncherInit, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
            if (!z3) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass5(this, (Continuation<AnonymousClass5>) null), 3, (Object) null);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GooglePayPaymentMethodLauncher(kotlinx.coroutines.CoroutineScope r23, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Config r24, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.ReadyCallback r25, androidx.activity.result.ActivityResultLauncher r26, boolean r27, android.content.Context r28, kotlin.jvm.functions.Function1 r29, java.util.Set r30, kotlin.jvm.functions.Function0 r31, kotlin.jvm.functions.Function0 r32, boolean r33, kotlin.coroutines.CoroutineContext r34, com.stripe.android.networking.PaymentAnalyticsRequestFactory r35, com.stripe.android.core.networking.AnalyticsRequestExecutor r36, com.stripe.android.networking.StripeRepository r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r22 = this;
            r10 = r28
            r0 = r38
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x000b
            r1 = 0
            r5 = 0
            goto L_0x000d
        L_0x000b:
            r5 = r33
        L_0x000d:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x001a
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r17 = r1
            goto L_0x001c
        L_0x001a:
            r17 = r34
        L_0x001c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            java.lang.String r2 = "GooglePayPaymentMethodLauncher"
            if (r1 == 0) goto L_0x0038
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r1 = new com.stripe.android.networking.PaymentAnalyticsRequestFactory
            com.stripe.android.PaymentConfiguration$Companion r3 = com.stripe.android.PaymentConfiguration.Companion
            com.stripe.android.PaymentConfiguration r3 = r3.getInstance(r10)
            java.lang.String r3 = r3.getPublishableKey()
            java.util.Set r4 = kotlin.collections.SetsKt.setOf(r2)
            r1.<init>((android.content.Context) r10, (java.lang.String) r3, (java.util.Set<java.lang.String>) r4)
            r18 = r1
            goto L_0x003a
        L_0x0038:
            r18 = r35
        L_0x003a:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0048
            com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor r1 = new com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor
            r1.<init>()
            com.stripe.android.core.networking.AnalyticsRequestExecutor r1 = (com.stripe.android.core.networking.AnalyticsRequestExecutor) r1
            r19 = r1
            goto L_0x004a
        L_0x0048:
            r19 = r36
        L_0x004a:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007b
            com.stripe.android.networking.StripeApiRepository r20 = new com.stripe.android.networking.StripeApiRepository
            r0 = r20
            r3 = 0
            com.stripe.android.core.Logger$Companion r1 = com.stripe.android.core.Logger.Companion
            com.stripe.android.core.Logger r4 = r1.getInstance(r5)
            java.util.Set r6 = kotlin.collections.SetsKt.setOf(r2)
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 15812(0x3dc4, float:2.2157E-41)
            r16 = 0
            r1 = r28
            r2 = r31
            r21 = r5
            r5 = r17
            r10 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r20
            com.stripe.android.networking.StripeRepository r0 = (com.stripe.android.networking.StripeRepository) r0
            r15 = r0
            goto L_0x007f
        L_0x007b:
            r21 = r5
            r15 = r37
        L_0x007f:
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r32
            r11 = r21
            r12 = r17
            r13 = r18
            r14 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.<init>(kotlinx.coroutines.CoroutineScope, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$ReadyCallback, androidx.activity.result.ActivityResultLauncher, boolean, android.content.Context, kotlin.jvm.functions.Function1, java.util.Set, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, boolean, kotlin.coroutines.CoroutineContext, com.stripe.android.networking.PaymentAnalyticsRequestFactory, com.stripe.android.core.networking.AnalyticsRequestExecutor, com.stripe.android.networking.StripeRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GooglePayPaymentMethodLauncher(ComponentActivity componentActivity, Config config2, ReadyCallback readyCallback2, ResultCallback resultCallback) {
        this(componentActivity, LifecycleOwnerKt.getLifecycleScope(componentActivity), componentActivity, config2, readyCallback2, resultCallback);
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(readyCallback2, "readyCallback");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GooglePayPaymentMethodLauncher(androidx.fragment.app.Fragment r9, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Config r10, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.ReadyCallback r11, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.ResultCallback r12) {
        /*
            r8 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "readyCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "resultCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            android.content.Context r2 = r9.requireContext()
            java.lang.String r0 = "fragment.requireContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            androidx.lifecycle.LifecycleOwner r0 = r9.getViewLifecycleOwner()
            java.lang.String r1 = "fragment.viewLifecycleOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r0)
            r3 = r0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            r4 = r9
            androidx.activity.result.ActivityResultCaller r4 = (androidx.activity.result.ActivityResultCaller) r4
            r1 = r8
            r5 = r10
            r6 = r11
            r7 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.<init>(androidx.fragment.app.Fragment, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$ReadyCallback, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$ResultCallback):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private GooglePayPaymentMethodLauncher(android.content.Context r19, kotlinx.coroutines.CoroutineScope r20, androidx.activity.result.ActivityResultCaller r21, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Config r22, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.ReadyCallback r23, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.ResultCallback r24) {
        /*
            r18 = this;
            r5 = r19
            r0 = r18
            r6 = r19
            r1 = r20
            r2 = r22
            r3 = r23
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract r4 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract
            r4.<init>()
            androidx.activity.result.contract.ActivityResultContract r4 = (androidx.activity.result.contract.ActivityResultContract) r4
            com.stripe.android.googlepaylauncher.-$$Lambda$GooglePayPaymentMethodLauncher$cOJ5z4UwqLi5ZvnSWiL0359pl54 r7 = new com.stripe.android.googlepaylauncher.-$$Lambda$GooglePayPaymentMethodLauncher$cOJ5z4UwqLi5ZvnSWiL0359pl54
            r8 = r24
            r7.<init>()
            r8 = r21
            androidx.activity.result.ActivityResultLauncher r7 = r8.registerForActivityResult(r4, r7)
            r4 = r7
            java.lang.String r8 = "activityResultCaller.reg…ck.onResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$2 r7 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$2
            r8 = r22
            r7.<init>(r5, r8)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.String r8 = "GooglePayPaymentMethodLauncher"
            java.util.Set r8 = kotlin.collections.SetsKt.setOf(r8)
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$3 r9 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$3
            r9.<init>(r5)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$4 r10 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$4
            r10.<init>(r5)
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r5 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 31744(0x7c00, float:4.4483E-41)
            r17 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.<init>(android.content.Context, kotlinx.coroutines.CoroutineScope, androidx.activity.result.ActivityResultCaller, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$ReadyCallback, com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$ResultCallback):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4295_init_$lambda0(ResultCallback resultCallback, Result result) {
        Intrinsics.checkNotNullParameter(resultCallback, "$resultCallback");
        Intrinsics.checkNotNullExpressionValue(result, "it");
        resultCallback.onResult(result);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$5", f = "GooglePayPaymentMethodLauncher.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$5  reason: invalid class name */
    /* compiled from: GooglePayPaymentMethodLauncher.kt */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ GooglePayPaymentMethodLauncher this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ReadyCallback readyCallback;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ReadyCallback access$getReadyCallback$p = this.this$0.readyCallback;
                this.L$0 = access$getReadyCallback$p;
                this.label = 1;
                obj = FlowKt.first(((GooglePayRepository) this.this$0.googlePayRepositoryFactory.invoke(this.this$0.config.getEnvironment())).isReady(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                readyCallback = access$getReadyCallback$p;
            } else if (i == 1) {
                readyCallback = (ReadyCallback) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Boolean bool = (Boolean) obj;
            this.this$0.isReady = bool.booleanValue();
            readyCallback.onReady(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void present$default(GooglePayPaymentMethodLauncher googlePayPaymentMethodLauncher, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        googlePayPaymentMethodLauncher.present(str, i, str2);
    }

    public final void present(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "currencyCode");
        if (this.skipReadyCheck || this.isReady) {
            this.activityResultLauncher.launch(new GooglePayPaymentMethodLauncherContract.Args(this.config, str, i, str2, new GooglePayPaymentMethodLauncherContract.Args.InjectionParams(this.injectorKey, this.productUsage, this.enableLogging, this.publishableKeyProvider.invoke(), this.stripeAccountIdProvider.invoke())));
            return;
        }
        throw new IllegalStateException("present() may only be called when Google Pay is available on this device.".toString());
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020%HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020%HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0014\"\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u00060"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "Landroid/os/Parcelable;", "environment", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "merchantCountryCode", "", "merchantName", "isEmailRequired", "", "billingAddressConfig", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig;", "existingPaymentMethodRequired", "(Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;Ljava/lang/String;Ljava/lang/String;ZLcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig;Z)V", "getBillingAddressConfig", "()Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig;", "setBillingAddressConfig", "(Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig;)V", "getEnvironment", "()Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "getExistingPaymentMethodRequired", "()Z", "setExistingPaymentMethodRequired", "(Z)V", "setEmailRequired", "isJcbEnabled", "isJcbEnabled$payments_core_release", "getMerchantCountryCode", "()Ljava/lang/String;", "getMerchantName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncher.kt */
    public static final class Config implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Config> CREATOR = new Creator();
        private BillingAddressConfig billingAddressConfig;
        private final GooglePayEnvironment environment;
        private boolean existingPaymentMethodRequired;
        private boolean isEmailRequired;
        private final String merchantCountryCode;
        private final String merchantName;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncher.kt */
        public static final class Creator implements Parcelable.Creator<Config> {
            public final Config createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Config(GooglePayEnvironment.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, BillingAddressConfig.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
            }

            public final Config[] newArray(int i) {
                return new Config[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Config(GooglePayEnvironment googlePayEnvironment, String str, String str2) {
            this(googlePayEnvironment, str, str2, false, (BillingAddressConfig) null, false, 56, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Config(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z) {
            this(googlePayEnvironment, str, str2, z, (BillingAddressConfig) null, false, 48, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Config(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2) {
            this(googlePayEnvironment, str, str2, z, billingAddressConfig2, false, 32, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
            Intrinsics.checkNotNullParameter(billingAddressConfig2, "billingAddressConfig");
        }

        public static /* synthetic */ Config copy$default(Config config, GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                googlePayEnvironment = config.environment;
            }
            if ((i & 2) != 0) {
                str = config.merchantCountryCode;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = config.merchantName;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                z = config.isEmailRequired;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                billingAddressConfig2 = config.billingAddressConfig;
            }
            BillingAddressConfig billingAddressConfig3 = billingAddressConfig2;
            if ((i & 32) != 0) {
                z2 = config.existingPaymentMethodRequired;
            }
            return config.copy(googlePayEnvironment, str3, str4, z3, billingAddressConfig3, z2);
        }

        public final GooglePayEnvironment component1() {
            return this.environment;
        }

        public final String component2() {
            return this.merchantCountryCode;
        }

        public final String component3() {
            return this.merchantName;
        }

        public final boolean component4() {
            return this.isEmailRequired;
        }

        public final BillingAddressConfig component5() {
            return this.billingAddressConfig;
        }

        public final boolean component6() {
            return this.existingPaymentMethodRequired;
        }

        public final Config copy(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2, boolean z2) {
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
            Intrinsics.checkNotNullParameter(billingAddressConfig2, "billingAddressConfig");
            return new Config(googlePayEnvironment, str, str2, z, billingAddressConfig2, z2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return this.environment == config.environment && Intrinsics.areEqual((Object) this.merchantCountryCode, (Object) config.merchantCountryCode) && Intrinsics.areEqual((Object) this.merchantName, (Object) config.merchantName) && this.isEmailRequired == config.isEmailRequired && Intrinsics.areEqual((Object) this.billingAddressConfig, (Object) config.billingAddressConfig) && this.existingPaymentMethodRequired == config.existingPaymentMethodRequired;
        }

        public int hashCode() {
            int hashCode = ((((this.environment.hashCode() * 31) + this.merchantCountryCode.hashCode()) * 31) + this.merchantName.hashCode()) * 31;
            boolean z = this.isEmailRequired;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.billingAddressConfig.hashCode()) * 31;
            boolean z3 = this.existingPaymentMethodRequired;
            if (!z3) {
                z2 = z3;
            }
            return hashCode2 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "Config(environment=" + this.environment + ", merchantCountryCode=" + this.merchantCountryCode + ", merchantName=" + this.merchantName + ", isEmailRequired=" + this.isEmailRequired + ", billingAddressConfig=" + this.billingAddressConfig + ", existingPaymentMethodRequired=" + this.existingPaymentMethodRequired + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.environment.name());
            parcel.writeString(this.merchantCountryCode);
            parcel.writeString(this.merchantName);
            parcel.writeInt(this.isEmailRequired ? 1 : 0);
            this.billingAddressConfig.writeToParcel(parcel, i);
            parcel.writeInt(this.existingPaymentMethodRequired ? 1 : 0);
        }

        public Config(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2, boolean z2) {
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
            Intrinsics.checkNotNullParameter(billingAddressConfig2, "billingAddressConfig");
            this.environment = googlePayEnvironment;
            this.merchantCountryCode = str;
            this.merchantName = str2;
            this.isEmailRequired = z;
            this.billingAddressConfig = billingAddressConfig2;
            this.existingPaymentMethodRequired = z2;
        }

        public final GooglePayEnvironment getEnvironment() {
            return this.environment;
        }

        public final String getMerchantCountryCode() {
            return this.merchantCountryCode;
        }

        public final String getMerchantName() {
            return this.merchantName;
        }

        public final boolean isEmailRequired() {
            return this.isEmailRequired;
        }

        public final void setEmailRequired(boolean z) {
            this.isEmailRequired = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Config(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(googlePayEnvironment, str, str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? new BillingAddressConfig(false, (BillingAddressConfig.Format) null, false, 7, (DefaultConstructorMarker) null) : billingAddressConfig2, (i & 32) != 0 ? true : z2);
        }

        public final BillingAddressConfig getBillingAddressConfig() {
            return this.billingAddressConfig;
        }

        public final void setBillingAddressConfig(BillingAddressConfig billingAddressConfig2) {
            Intrinsics.checkNotNullParameter(billingAddressConfig2, "<set-?>");
            this.billingAddressConfig = billingAddressConfig2;
        }

        public final boolean getExistingPaymentMethodRequired() {
            return this.existingPaymentMethodRequired;
        }

        public final void setExistingPaymentMethodRequired(boolean z) {
            this.existingPaymentMethodRequired = z;
        }

        public final boolean isJcbEnabled$payments_core_release() {
            return StringsKt.equals(this.merchantCountryCode, Locale.JAPAN.getCountry(), true);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig;", "Landroid/os/Parcelable;", "isRequired", "", "format", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig$Format;", "isPhoneNumberRequired", "(ZLcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig$Format;Z)V", "getFormat", "()Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig$Format;", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Format", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncher.kt */
    public static final class BillingAddressConfig implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<BillingAddressConfig> CREATOR = new Creator();
        private final Format format;
        private final boolean isPhoneNumberRequired;
        private final boolean isRequired;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncher.kt */
        public static final class Creator implements Parcelable.Creator<BillingAddressConfig> {
            public final BillingAddressConfig createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                boolean z = true;
                boolean z2 = parcel.readInt() != 0;
                Format valueOf = Format.valueOf(parcel.readString());
                if (parcel.readInt() == 0) {
                    z = false;
                }
                return new BillingAddressConfig(z2, valueOf, z);
            }

            public final BillingAddressConfig[] newArray(int i) {
                return new BillingAddressConfig[i];
            }
        }

        public BillingAddressConfig() {
            this(false, (Format) null, false, 7, (DefaultConstructorMarker) null);
        }

        public BillingAddressConfig(boolean z) {
            this(z, (Format) null, false, 6, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public BillingAddressConfig(boolean z, Format format2) {
            this(z, format2, false, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(format2, "format");
        }

        public static /* synthetic */ BillingAddressConfig copy$default(BillingAddressConfig billingAddressConfig, boolean z, Format format2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = billingAddressConfig.isRequired;
            }
            if ((i & 2) != 0) {
                format2 = billingAddressConfig.format;
            }
            if ((i & 4) != 0) {
                z2 = billingAddressConfig.isPhoneNumberRequired;
            }
            return billingAddressConfig.copy(z, format2, z2);
        }

        public final boolean component1() {
            return this.isRequired;
        }

        public final Format component2() {
            return this.format;
        }

        public final boolean component3() {
            return this.isPhoneNumberRequired;
        }

        public final BillingAddressConfig copy(boolean z, Format format2, boolean z2) {
            Intrinsics.checkNotNullParameter(format2, "format");
            return new BillingAddressConfig(z, format2, z2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BillingAddressConfig)) {
                return false;
            }
            BillingAddressConfig billingAddressConfig = (BillingAddressConfig) obj;
            return this.isRequired == billingAddressConfig.isRequired && this.format == billingAddressConfig.format && this.isPhoneNumberRequired == billingAddressConfig.isPhoneNumberRequired;
        }

        public int hashCode() {
            boolean z = this.isRequired;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int hashCode = (((z ? 1 : 0) * true) + this.format.hashCode()) * 31;
            boolean z3 = this.isPhoneNumberRequired;
            if (!z3) {
                z2 = z3;
            }
            return hashCode + (z2 ? 1 : 0);
        }

        public String toString() {
            return "BillingAddressConfig(isRequired=" + this.isRequired + ", format=" + this.format + ", isPhoneNumberRequired=" + this.isPhoneNumberRequired + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isRequired ? 1 : 0);
            parcel.writeString(this.format.name());
            parcel.writeInt(this.isPhoneNumberRequired ? 1 : 0);
        }

        public BillingAddressConfig(boolean z, Format format2, boolean z2) {
            Intrinsics.checkNotNullParameter(format2, "format");
            this.isRequired = z;
            this.format = format2;
            this.isPhoneNumberRequired = z2;
        }

        public final boolean isRequired() {
            return this.isRequired;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BillingAddressConfig(boolean z, Format format2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? Format.Min : format2, (i & 4) != 0 ? false : z2);
        }

        public final Format getFormat() {
            return this.format;
        }

        public final boolean isPhoneNumberRequired() {
            return this.isPhoneNumberRequired;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig$Format;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "Min", "Full", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncher.kt */
        public enum Format {
            Min("MIN"),
            Full("FULL");
            
            private final String code;

            private Format(String str) {
                this.code = str;
            }

            public final String getCode$payments_core_release() {
                return this.code;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "Landroid/os/Parcelable;", "()V", "Canceled", "Completed", "Failed", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result$Completed;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result$Failed;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result$Canceled;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncher.kt */
    public static abstract class Result implements Parcelable {
        public static final int $stable = 0;

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result$Completed;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "(Lcom/stripe/android/model/PaymentMethod;)V", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncher.kt */
        public static final class Completed extends Result {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Completed> CREATOR = new Creator();
            private final PaymentMethod paymentMethod;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: GooglePayPaymentMethodLauncher.kt */
            public static final class Creator implements Parcelable.Creator<Completed> {
                public final Completed createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Completed(PaymentMethod.CREATOR.createFromParcel(parcel));
                }

                public final Completed[] newArray(int i) {
                    return new Completed[i];
                }
            }

            public static /* synthetic */ Completed copy$default(Completed completed, PaymentMethod paymentMethod2, int i, Object obj) {
                if ((i & 1) != 0) {
                    paymentMethod2 = completed.paymentMethod;
                }
                return completed.copy(paymentMethod2);
            }

            public final PaymentMethod component1() {
                return this.paymentMethod;
            }

            public final Completed copy(PaymentMethod paymentMethod2) {
                Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
                return new Completed(paymentMethod2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Completed) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) ((Completed) obj).paymentMethod);
            }

            public int hashCode() {
                return this.paymentMethod.hashCode();
            }

            public String toString() {
                return "Completed(paymentMethod=" + this.paymentMethod + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                this.paymentMethod.writeToParcel(parcel, i);
            }

            public final PaymentMethod getPaymentMethod() {
                return this.paymentMethod;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Completed(PaymentMethod paymentMethod2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
                this.paymentMethod = paymentMethod2;
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result$Failed;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "error", "", "errorCode", "", "(Ljava/lang/Throwable;I)V", "getError", "()Ljava/lang/Throwable;", "getErrorCode", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncher.kt */
        public static final class Failed extends Result {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Failed> CREATOR = new Creator();
            private final Throwable error;
            private final int errorCode;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: GooglePayPaymentMethodLauncher.kt */
            public static final class Creator implements Parcelable.Creator<Failed> {
                public final Failed createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Failed((Throwable) parcel.readSerializable(), parcel.readInt());
                }

                public final Failed[] newArray(int i) {
                    return new Failed[i];
                }
            }

            public static /* synthetic */ Failed copy$default(Failed failed, Throwable th, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    th = failed.error;
                }
                if ((i2 & 2) != 0) {
                    i = failed.errorCode;
                }
                return failed.copy(th, i);
            }

            public final Throwable component1() {
                return this.error;
            }

            public final int component2() {
                return this.errorCode;
            }

            public final Failed copy(Throwable th, @ErrorCode int i) {
                Intrinsics.checkNotNullParameter(th, ReactVideoView.EVENT_PROP_ERROR);
                return new Failed(th, i);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Failed)) {
                    return false;
                }
                Failed failed = (Failed) obj;
                return Intrinsics.areEqual((Object) this.error, (Object) failed.error) && this.errorCode == failed.errorCode;
            }

            public int hashCode() {
                return (this.error.hashCode() * 31) + this.errorCode;
            }

            public String toString() {
                return "Failed(error=" + this.error + ", errorCode=" + this.errorCode + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeSerializable(this.error);
                parcel.writeInt(this.errorCode);
            }

            public final Throwable getError() {
                return this.error;
            }

            public final int getErrorCode() {
                return this.errorCode;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failed(Throwable th, @ErrorCode int i) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(th, ReactVideoView.EVENT_PROP_ERROR);
                this.error = th;
                this.errorCode = i;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result$Canceled;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncher.kt */
        public static final class Canceled extends Result {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Canceled> CREATOR = new Creator();
            public static final Canceled INSTANCE = new Canceled();

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: GooglePayPaymentMethodLauncher.kt */
            public static final class Creator implements Parcelable.Creator<Canceled> {
                public final Canceled createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return Canceled.INSTANCE;
                }

                public final Canceled[] newArray(int i) {
                    return new Canceled[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }

            private Canceled() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Companion;", "", "()V", "DEVELOPER_ERROR", "", "INTERNAL_ERROR", "NETWORK_ERROR", "PRODUCT_USAGE_TOKEN", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
