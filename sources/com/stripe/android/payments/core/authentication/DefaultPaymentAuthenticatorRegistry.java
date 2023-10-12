package com.stripe.android.payments.core.authentication;

import android.content.Context;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.PaymentRelayContract;
import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.Injector;
import com.stripe.android.core.injection.WeakMapInjectorRegistry;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.model.Source;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModelFactory;
import com.stripe.android.payments.core.injection.AuthenticationComponent;
import com.stripe.android.payments.core.injection.DaggerAuthenticationComponent;
import com.stripe.android.payments.core.injection.IntentAuthenticatorMap;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Singleton
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B@\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012'\b\u0001\u0010\u0007\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r0\b¢\u0006\u0002\u0010\u000eJ!\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\u000b\"\u0004\b\u0000\u0010(2\u0006\u0010)\u001a\u0002H(H\u0016¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u00020,2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u001e\u00100\u001a\u00020,2\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0016R*\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u000b0\u00108\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R-\u0010\u0007\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r0\bX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/stripe/android/payments/core/authentication/DefaultPaymentAuthenticatorRegistry;", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticatorRegistry;", "Lcom/stripe/android/core/injection/Injector;", "noOpIntentAuthenticator", "Lcom/stripe/android/payments/core/authentication/NoOpIntentAuthenticator;", "sourceAuthenticator", "Lcom/stripe/android/payments/core/authentication/SourceAuthenticator;", "paymentAuthenticatorMap", "", "Ljava/lang/Class;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Lcom/stripe/android/model/StripeIntent;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Lcom/stripe/android/payments/core/authentication/NoOpIntentAuthenticator;Lcom/stripe/android/payments/core/authentication/SourceAuthenticator;Ljava/util/Map;)V", "allAuthenticators", "", "Lcom/stripe/android/core/model/StripeModel;", "getAllAuthenticators$payments_core_release$annotations", "()V", "getAllAuthenticators$payments_core_release", "()Ljava/util/List;", "authenticationComponent", "Lcom/stripe/android/payments/core/injection/AuthenticationComponent;", "getAuthenticationComponent", "()Lcom/stripe/android/payments/core/injection/AuthenticationComponent;", "setAuthenticationComponent", "(Lcom/stripe/android/payments/core/injection/AuthenticationComponent;)V", "paymentBrowserAuthLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "getPaymentBrowserAuthLauncher$payments_core_release", "()Landroidx/activity/result/ActivityResultLauncher;", "setPaymentBrowserAuthLauncher$payments_core_release", "(Landroidx/activity/result/ActivityResultLauncher;)V", "paymentRelayLauncher", "Lcom/stripe/android/PaymentRelayStarter$Args;", "getPaymentRelayLauncher$payments_core_release", "setPaymentRelayLauncher$payments_core_release", "getAuthenticator", "Authenticatable", "authenticatable", "(Ljava/lang/Object;)Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "inject", "", "injectable", "Lcom/stripe/android/core/injection/Injectable;", "onLauncherInvalidated", "onNewActivityResultCaller", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "activityResultCallback", "Landroidx/activity/result/ActivityResultCallback;", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultPaymentAuthenticatorRegistry.kt */
public final class DefaultPaymentAuthenticatorRegistry implements PaymentAuthenticatorRegistry, Injector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<PaymentAuthenticator<? extends StripeModel>> allAuthenticators;
    public AuthenticationComponent authenticationComponent;
    private final NoOpIntentAuthenticator noOpIntentAuthenticator;
    private final Map<Class<? extends StripeIntent.NextActionData>, PaymentAuthenticator<StripeIntent>> paymentAuthenticatorMap;
    private ActivityResultLauncher<PaymentBrowserAuthContract.Args> paymentBrowserAuthLauncher;
    private ActivityResultLauncher<PaymentRelayStarter.Args> paymentRelayLauncher;
    private final SourceAuthenticator sourceAuthenticator;

    public static /* synthetic */ void getAllAuthenticators$payments_core_release$annotations() {
    }

    @Inject
    public DefaultPaymentAuthenticatorRegistry(NoOpIntentAuthenticator noOpIntentAuthenticator2, SourceAuthenticator sourceAuthenticator2, @IntentAuthenticatorMap Map<Class<? extends StripeIntent.NextActionData>, PaymentAuthenticator<StripeIntent>> map) {
        Intrinsics.checkNotNullParameter(noOpIntentAuthenticator2, "noOpIntentAuthenticator");
        Intrinsics.checkNotNullParameter(sourceAuthenticator2, "sourceAuthenticator");
        Intrinsics.checkNotNullParameter(map, "paymentAuthenticatorMap");
        this.noOpIntentAuthenticator = noOpIntentAuthenticator2;
        this.sourceAuthenticator = sourceAuthenticator2;
        this.paymentAuthenticatorMap = map;
        this.allAuthenticators = CollectionsKt.flatten(SetsKt.setOf(CollectionsKt.listOf(noOpIntentAuthenticator2, sourceAuthenticator2), map.values()));
    }

    public final List<PaymentAuthenticator<? extends StripeModel>> getAllAuthenticators$payments_core_release() {
        return this.allAuthenticators;
    }

    public final AuthenticationComponent getAuthenticationComponent() {
        AuthenticationComponent authenticationComponent2 = this.authenticationComponent;
        if (authenticationComponent2 != null) {
            return authenticationComponent2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("authenticationComponent");
        return null;
    }

    public final void setAuthenticationComponent(AuthenticationComponent authenticationComponent2) {
        Intrinsics.checkNotNullParameter(authenticationComponent2, "<set-?>");
        this.authenticationComponent = authenticationComponent2;
    }

    public final ActivityResultLauncher<PaymentRelayStarter.Args> getPaymentRelayLauncher$payments_core_release() {
        return this.paymentRelayLauncher;
    }

    public final void setPaymentRelayLauncher$payments_core_release(ActivityResultLauncher<PaymentRelayStarter.Args> activityResultLauncher) {
        this.paymentRelayLauncher = activityResultLauncher;
    }

    public final ActivityResultLauncher<PaymentBrowserAuthContract.Args> getPaymentBrowserAuthLauncher$payments_core_release() {
        return this.paymentBrowserAuthLauncher;
    }

    public final void setPaymentBrowserAuthLauncher$payments_core_release(ActivityResultLauncher<PaymentBrowserAuthContract.Args> activityResultLauncher) {
        this.paymentBrowserAuthLauncher = activityResultLauncher;
    }

    public <Authenticatable> PaymentAuthenticator<Authenticatable> getAuthenticator(Authenticatable authenticatable) {
        PaymentAuthenticator<Authenticatable> paymentAuthenticator;
        if (authenticatable instanceof StripeIntent) {
            StripeIntent stripeIntent = (StripeIntent) authenticatable;
            if (!stripeIntent.requiresAction()) {
                return this.noOpIntentAuthenticator;
            }
            StripeIntent.NextActionData nextActionData = stripeIntent.getNextActionData();
            if (nextActionData == null) {
                paymentAuthenticator = null;
            } else {
                PaymentAuthenticator<StripeIntent> paymentAuthenticator2 = this.paymentAuthenticatorMap.get(nextActionData.getClass());
                if (paymentAuthenticator2 == null) {
                    paymentAuthenticator2 = this.noOpIntentAuthenticator;
                }
                paymentAuthenticator = paymentAuthenticator2;
            }
            if (paymentAuthenticator == null) {
                return this.noOpIntentAuthenticator;
            }
            return paymentAuthenticator;
        } else if (authenticatable instanceof Source) {
            return this.sourceAuthenticator;
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("No suitable PaymentAuthenticator for ", authenticatable).toString());
        }
    }

    public void onNewActivityResultCaller(ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback) {
        Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
        Intrinsics.checkNotNullParameter(activityResultCallback, "activityResultCallback");
        for (PaymentAuthenticator onNewActivityResultCaller : this.allAuthenticators) {
            onNewActivityResultCaller.onNewActivityResultCaller(activityResultCaller, activityResultCallback);
        }
        this.paymentRelayLauncher = activityResultCaller.registerForActivityResult(new PaymentRelayContract(), activityResultCallback);
        this.paymentBrowserAuthLauncher = activityResultCaller.registerForActivityResult(new PaymentBrowserAuthContract(), activityResultCallback);
    }

    public void onLauncherInvalidated() {
        for (PaymentAuthenticator onLauncherInvalidated : this.allAuthenticators) {
            onLauncherInvalidated.onLauncherInvalidated();
        }
        ActivityResultLauncher<PaymentRelayStarter.Args> activityResultLauncher = this.paymentRelayLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
        ActivityResultLauncher<PaymentBrowserAuthContract.Args> activityResultLauncher2 = this.paymentBrowserAuthLauncher;
        if (activityResultLauncher2 != null) {
            activityResultLauncher2.unregister();
        }
        this.paymentRelayLauncher = null;
        this.paymentBrowserAuthLauncher = null;
    }

    public void inject(Injectable<?> injectable) {
        Intrinsics.checkNotNullParameter(injectable, "injectable");
        if (injectable instanceof Stripe3ds2TransactionViewModelFactory) {
            getAuthenticationComponent().inject((Stripe3ds2TransactionViewModelFactory) injectable);
            return;
        }
        throw new IllegalArgumentException("invalid Injectable " + injectable + " requested in " + this);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jv\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u0019\u001a\u00020\u000e¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/payments/core/authentication/DefaultPaymentAuthenticatorRegistry$Companion;", "", "()V", "createInstance", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticatorRegistry;", "context", "Landroid/content/Context;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "enableLogging", "", "workContext", "Lkotlin/coroutines/CoroutineContext;", "uiContext", "threeDs1IntentReturnUrlMap", "", "", "publishableKeyProvider", "Lkotlin/Function0;", "productUsage", "", "isInstantApp", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultPaymentAuthenticatorRegistry.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaymentAuthenticatorRegistry createInstance(Context context, StripeRepository stripeRepository, AnalyticsRequestExecutor analyticsRequestExecutor, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, boolean z, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Map<String, String> map, Function0<String> function0, Set<String> set, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(stripeRepository, "stripeRepository");
            Intrinsics.checkNotNullParameter(analyticsRequestExecutor, "analyticsRequestExecutor");
            Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory, "paymentAnalyticsRequestFactory");
            Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
            Intrinsics.checkNotNullParameter(coroutineContext2, "uiContext");
            Intrinsics.checkNotNullParameter(map, "threeDs1IntentReturnUrlMap");
            Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
            Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
            WeakMapInjectorRegistry weakMapInjectorRegistry = WeakMapInjectorRegistry.INSTANCE;
            String simpleName = Reflection.getOrCreateKotlinClass(PaymentAuthenticatorRegistry.class).getSimpleName();
            if (simpleName != null) {
                String nextKey = weakMapInjectorRegistry.nextKey(simpleName);
                AuthenticationComponent build = DaggerAuthenticationComponent.builder().context(context).stripeRepository(stripeRepository).analyticsRequestExecutor(analyticsRequestExecutor).analyticsRequestFactory(paymentAnalyticsRequestFactory).enableLogging(z).workContext(coroutineContext).uiContext(coroutineContext2).threeDs1IntentReturnUrlMap(map).injectorKey(nextKey).publishableKeyProvider(function0).productUsage(set).isInstantApp(z2).build();
                DefaultPaymentAuthenticatorRegistry registry = build.getRegistry();
                registry.setAuthenticationComponent(build);
                WeakMapInjectorRegistry.INSTANCE.register(registry, nextKey);
                return registry;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }
}
