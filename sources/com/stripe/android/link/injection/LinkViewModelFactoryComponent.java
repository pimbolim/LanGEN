package com.stripe.android.link.injection;

import android.content.Context;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkActivityViewModel;
import com.stripe.android.link.ui.signup.SignUpViewModel;
import com.stripe.android.link.ui.verification.VerificationViewModel;
import com.stripe.android.link.ui.wallet.WalletViewModel;
import com.stripe.android.payments.core.injection.StripeRepositoryModule;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Component(modules = {LinkPaymentLauncherModule.class, CoroutineContextModule.class, StripeRepositoryModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/stripe/android/link/injection/LinkViewModelFactoryComponent;", "", "inject", "", "factory", "Lcom/stripe/android/link/LinkActivityViewModel$Factory;", "Lcom/stripe/android/link/ui/signup/SignUpViewModel$Factory;", "Lcom/stripe/android/link/ui/verification/VerificationViewModel$Factory;", "Lcom/stripe/android/link/ui/wallet/WalletViewModel$Factory;", "Builder", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkViewModelFactoryComponent.kt */
public interface LinkViewModelFactoryComponent {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\u00020\u00002\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J\u0018\u0010\u000b\u001a\u00020\u00002\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH'J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH'J\u001a\u0010\u000f\u001a\u00020\u00002\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fH'¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/link/injection/LinkViewModelFactoryComponent$Builder;", "", "build", "Lcom/stripe/android/link/injection/LinkViewModelFactoryComponent;", "context", "Landroid/content/Context;", "enableLogging", "", "productUsage", "", "", "publishableKeyProvider", "Lkotlin/Function0;", "starterArgs", "Lcom/stripe/android/link/LinkActivityContract$Args;", "stripeAccountIdProvider", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: LinkViewModelFactoryComponent.kt */
    public interface Builder {
        LinkViewModelFactoryComponent build();

        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder enableLogging(@Named("enableLogging") boolean z);

        @BindsInstance
        Builder productUsage(@Named("productUsage") Set<String> set);

        @BindsInstance
        Builder publishableKeyProvider(@Named("publishableKey") Function0<String> function0);

        @BindsInstance
        Builder starterArgs(LinkActivityContract.Args args);

        @BindsInstance
        Builder stripeAccountIdProvider(@Named("stripeAccountId") Function0<String> function0);
    }

    void inject(LinkActivityViewModel.Factory factory);

    void inject(SignUpViewModel.Factory factory);

    void inject(VerificationViewModel.Factory factory);

    void inject(WalletViewModel.Factory factory);
}
