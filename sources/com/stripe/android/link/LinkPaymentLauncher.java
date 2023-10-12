package com.stripe.android.link;

import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.injection.UIContext;
import com.stripe.android.core.injection.WeakMapInjectorRegistry;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.injection.DaggerLinkPaymentLauncherComponent;
import com.stripe.android.link.injection.LinkPaymentLauncherComponent;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import java.util.Set;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\u0010\b\u0001\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\tJ\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u00020\t8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/stripe/android/link/LinkPaymentLauncher;", "", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/link/LinkActivityContract$Args;", "context", "Landroid/content/Context;", "productUsage", "", "", "publishableKeyProvider", "Lkotlin/Function0;", "stripeAccountIdProvider", "enableLogging", "", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "uiContext", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "(Landroidx/activity/result/ActivityResultLauncher;Landroid/content/Context;Ljava/util/Set;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/StripeRepository;)V", "injectorKey", "getInjectorKey$annotations", "()V", "launcherComponentBuilder", "Lcom/stripe/android/link/injection/LinkPaymentLauncherComponent$Builder;", "present", "", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "merchantName", "customerEmail", "setupInjector", "args", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkPaymentLauncher.kt */
public final class LinkPaymentLauncher {
    public static final int $stable = 8;
    private final ActivityResultLauncher<LinkActivityContract.Args> activityResultLauncher;
    private final boolean enableLogging;
    private final String injectorKey;
    private final LinkPaymentLauncherComponent.Builder launcherComponentBuilder;
    private final Set<String> productUsage;
    private final Function0<String> publishableKeyProvider;
    private final Function0<String> stripeAccountIdProvider;

    @InjectorKey
    private static /* synthetic */ void getInjectorKey$annotations() {
    }

    @AssistedInject
    public LinkPaymentLauncher(@Assisted ActivityResultLauncher<LinkActivityContract.Args> activityResultLauncher2, Context context, @Named("productUsage") Set<String> set, @Named("publishableKey") Function0<String> function0, @Named("stripeAccountId") Function0<String> function02, @Named("enableLogging") boolean z, @IOContext CoroutineContext coroutineContext, @UIContext CoroutineContext coroutineContext2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, AnalyticsRequestExecutor analyticsRequestExecutor, StripeRepository stripeRepository) {
        Intrinsics.checkNotNullParameter(activityResultLauncher2, "activityResultLauncher");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(function02, "stripeAccountIdProvider");
        Intrinsics.checkNotNullParameter(coroutineContext, "ioContext");
        Intrinsics.checkNotNullParameter(coroutineContext2, "uiContext");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(stripeRepository, "stripeRepository");
        this.activityResultLauncher = activityResultLauncher2;
        this.productUsage = set;
        this.publishableKeyProvider = function0;
        this.stripeAccountIdProvider = function02;
        this.enableLogging = z;
        this.launcherComponentBuilder = DaggerLinkPaymentLauncherComponent.builder().context(context).ioContext(coroutineContext).uiContext(coroutineContext2).analyticsRequestFactory(paymentAnalyticsRequestFactory).analyticsRequestExecutor(analyticsRequestExecutor).stripeRepository(stripeRepository).enableLogging(z).publishableKeyProvider(function0).stripeAccountIdProvider(function02).productUsage(set);
        WeakMapInjectorRegistry weakMapInjectorRegistry = WeakMapInjectorRegistry.INSTANCE;
        String simpleName = Reflection.getOrCreateKotlinClass(LinkPaymentLauncher.class).getSimpleName();
        if (simpleName != null) {
            this.injectorKey = weakMapInjectorRegistry.nextKey(simpleName);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void present$default(LinkPaymentLauncher linkPaymentLauncher, StripeIntent stripeIntent, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        linkPaymentLauncher.present(stripeIntent, str, str2);
    }

    public final void present(StripeIntent stripeIntent, String str, String str2) {
        Intrinsics.checkNotNullParameter(stripeIntent, "stripeIntent");
        Intrinsics.checkNotNullParameter(str, "merchantName");
        LinkActivityContract.Args args = new LinkActivityContract.Args(stripeIntent, str, str2, new LinkActivityContract.Args.InjectionParams(this.injectorKey, this.productUsage, this.enableLogging, this.publishableKeyProvider.invoke(), this.stripeAccountIdProvider.invoke()));
        setupInjector(args);
        this.activityResultLauncher.launch(args);
    }

    private final void setupInjector(LinkActivityContract.Args args) {
        WeakMapInjectorRegistry.INSTANCE.register(new LinkPaymentLauncher$setupInjector$injector$1(this.launcherComponentBuilder.starterArgs(args).build()), this.injectorKey);
    }
}
