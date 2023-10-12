package com.stripe.android.link.injection;

import android.content.Context;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.UIContext;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkActivityViewModel;
import com.stripe.android.link.ui.signup.SignUpViewModel;
import com.stripe.android.link.ui.verification.VerificationViewModel;
import com.stripe.android.link.ui.wallet.WalletViewModel;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

@Component(modules = {LinkPaymentLauncherModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/link/injection/LinkPaymentLauncherComponent;", "", "()V", "inject", "", "factory", "Lcom/stripe/android/link/LinkActivityViewModel$Factory;", "Lcom/stripe/android/link/ui/signup/SignUpViewModel$Factory;", "Lcom/stripe/android/link/ui/verification/VerificationViewModel$Factory;", "Lcom/stripe/android/link/ui/wallet/WalletViewModel$Factory;", "Builder", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkPaymentLauncherComponent.kt */
public abstract class LinkPaymentLauncherComponent {

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H'J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH'J\u0012\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\fH'J\u0012\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'J\u0018\u0010\u0010\u001a\u00020\u00002\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H'J\u0018\u0010\u0013\u001a\u00020\u00002\u000e\b\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H'J\u001a\u0010\u0017\u001a\u00020\u00002\u0010\b\u0001\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014H'J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H'J\u0012\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u001a\u001a\u00020\u000fH'¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/link/injection/LinkPaymentLauncherComponent$Builder;", "", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "analyticsRequestFactory", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "build", "Lcom/stripe/android/link/injection/LinkPaymentLauncherComponent;", "context", "Landroid/content/Context;", "enableLogging", "", "ioContext", "workContext", "Lkotlin/coroutines/CoroutineContext;", "productUsage", "", "", "publishableKeyProvider", "Lkotlin/Function0;", "starterArgs", "Lcom/stripe/android/link/LinkActivityContract$Args;", "stripeAccountIdProvider", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "uiContext", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: LinkPaymentLauncherComponent.kt */
    public interface Builder {
        @BindsInstance
        Builder analyticsRequestExecutor(AnalyticsRequestExecutor analyticsRequestExecutor);

        @BindsInstance
        Builder analyticsRequestFactory(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory);

        LinkPaymentLauncherComponent build();

        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder enableLogging(@Named("enableLogging") boolean z);

        @BindsInstance
        Builder ioContext(@IOContext CoroutineContext coroutineContext);

        @BindsInstance
        Builder productUsage(@Named("productUsage") Set<String> set);

        @BindsInstance
        Builder publishableKeyProvider(@Named("publishableKey") Function0<String> function0);

        @BindsInstance
        Builder starterArgs(LinkActivityContract.Args args);

        @BindsInstance
        Builder stripeAccountIdProvider(@Named("stripeAccountId") Function0<String> function0);

        @BindsInstance
        Builder stripeRepository(StripeRepository stripeRepository);

        @BindsInstance
        Builder uiContext(@UIContext CoroutineContext coroutineContext);
    }

    public abstract void inject(LinkActivityViewModel.Factory factory);

    public abstract void inject(SignUpViewModel.Factory factory);

    public abstract void inject(VerificationViewModel.Factory factory);

    public abstract void inject(WalletViewModel.Factory factory);
}
