package com.stripe.android.payments.paymentlauncher;

import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.Injector;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.injection.UIContext;
import com.stripe.android.core.injection.WeakMapInjectorRegistry;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.core.injection.DaggerPaymentLauncherComponent;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.payments.core.injection.PaymentLauncherComponent;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import java.util.Set;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\b\u0001\u0012\u000e\b\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u000e\b\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0014\u0010%\u001a\u00020\u001e2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u00020\u00058\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/StripePaymentLauncher;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "Lcom/stripe/android/core/injection/Injector;", "publishableKeyProvider", "Lkotlin/Function0;", "", "stripeAccountIdProvider", "hostActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "context", "Landroid/content/Context;", "enableLogging", "", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "uiContext", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "productUsage", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/activity/result/ActivityResultLauncher;Landroid/content/Context;ZLkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Ljava/util/Set;)V", "injectorKey", "getInjectorKey$annotations", "()V", "paymentLauncherComponent", "Lcom/stripe/android/payments/core/injection/PaymentLauncherComponent;", "confirm", "", "params", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "handleNextActionForPaymentIntent", "clientSecret", "handleNextActionForSetupIntent", "inject", "injectable", "Lcom/stripe/android/core/injection/Injectable;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripePaymentLauncher.kt */
public final class StripePaymentLauncher implements PaymentLauncher, Injector {
    public static final int $stable = 8;
    private final boolean enableLogging;
    private final ActivityResultLauncher<PaymentLauncherContract.Args> hostActivityLauncher;
    private final String injectorKey;
    private final PaymentLauncherComponent paymentLauncherComponent;
    private final Set<String> productUsage;
    private final Function0<String> publishableKeyProvider;
    private final Function0<String> stripeAccountIdProvider;

    @InjectorKey
    private static /* synthetic */ void getInjectorKey$annotations() {
    }

    @AssistedInject
    public StripePaymentLauncher(@Assisted("publishableKey") Function0<String> function0, @Assisted("stripeAccountId") Function0<String> function02, @Assisted ActivityResultLauncher<PaymentLauncherContract.Args> activityResultLauncher, Context context, @Named("enableLogging") boolean z, @IOContext CoroutineContext coroutineContext, @UIContext CoroutineContext coroutineContext2, StripeRepository stripeRepository, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, @Named("productUsage") Set<String> set) {
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(function02, "stripeAccountIdProvider");
        Intrinsics.checkNotNullParameter(activityResultLauncher, "hostActivityLauncher");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "ioContext");
        Intrinsics.checkNotNullParameter(coroutineContext2, "uiContext");
        Intrinsics.checkNotNullParameter(stripeRepository, "stripeRepository");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        this.publishableKeyProvider = function0;
        this.stripeAccountIdProvider = function02;
        this.hostActivityLauncher = activityResultLauncher;
        this.enableLogging = z;
        this.productUsage = set;
        this.paymentLauncherComponent = DaggerPaymentLauncherComponent.builder().context(context).enableLogging(z).ioContext(coroutineContext).uiContext(coroutineContext2).stripeRepository(stripeRepository).analyticsRequestFactory(paymentAnalyticsRequestFactory).publishableKeyProvider(function0).stripeAccountIdProvider(function02).productUsage(set).build();
        WeakMapInjectorRegistry weakMapInjectorRegistry = WeakMapInjectorRegistry.INSTANCE;
        String simpleName = Reflection.getOrCreateKotlinClass(PaymentLauncher.class).getSimpleName();
        if (simpleName != null) {
            String nextKey = weakMapInjectorRegistry.nextKey(simpleName);
            this.injectorKey = nextKey;
            WeakMapInjectorRegistry.INSTANCE.register(this, nextKey);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void inject(Injectable<?> injectable) {
        Intrinsics.checkNotNullParameter(injectable, "injectable");
        if (injectable instanceof PaymentLauncherViewModel.Factory) {
            this.paymentLauncherComponent.inject((PaymentLauncherViewModel.Factory) injectable);
            return;
        }
        throw new IllegalArgumentException("invalid Injectable " + injectable + " requested in " + this);
    }

    public void confirm(ConfirmPaymentIntentParams confirmPaymentIntentParams) {
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "params");
        this.hostActivityLauncher.launch(new PaymentLauncherContract.Args.IntentConfirmationArgs(this.injectorKey, this.publishableKeyProvider.invoke(), this.stripeAccountIdProvider.invoke(), this.enableLogging, this.productUsage, confirmPaymentIntentParams, (Integer) null, 64, (DefaultConstructorMarker) null));
    }

    public void confirm(ConfirmSetupIntentParams confirmSetupIntentParams) {
        Intrinsics.checkNotNullParameter(confirmSetupIntentParams, "params");
        this.hostActivityLauncher.launch(new PaymentLauncherContract.Args.IntentConfirmationArgs(this.injectorKey, this.publishableKeyProvider.invoke(), this.stripeAccountIdProvider.invoke(), this.enableLogging, this.productUsage, confirmSetupIntentParams, (Integer) null, 64, (DefaultConstructorMarker) null));
    }

    public void handleNextActionForPaymentIntent(String str) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        this.hostActivityLauncher.launch(new PaymentLauncherContract.Args.PaymentIntentNextActionArgs(this.injectorKey, this.publishableKeyProvider.invoke(), this.stripeAccountIdProvider.invoke(), this.enableLogging, this.productUsage, str, (Integer) null, 64, (DefaultConstructorMarker) null));
    }

    public void handleNextActionForSetupIntent(String str) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        this.hostActivityLauncher.launch(new PaymentLauncherContract.Args.SetupIntentNextActionArgs(this.injectorKey, this.publishableKeyProvider.invoke(), this.stripeAccountIdProvider.invoke(), this.enableLogging, this.productUsage, str, (Integer) null, 64, (DefaultConstructorMarker) null));
    }
}
