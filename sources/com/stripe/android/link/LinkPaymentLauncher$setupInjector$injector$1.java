package com.stripe.android.link;

import com.stripe.android.core.injection.Injectable;
import com.stripe.android.link.LinkActivityViewModel;
import com.stripe.android.link.injection.LinkPaymentLauncherComponent;
import com.stripe.android.link.injection.NonFallbackInjector;
import com.stripe.android.link.ui.signup.SignUpViewModel;
import com.stripe.android.link.ui.verification.VerificationViewModel;
import com.stripe.android.link.ui.wallet.WalletViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/stripe/android/link/LinkPaymentLauncher$setupInjector$injector$1", "Lcom/stripe/android/link/injection/NonFallbackInjector;", "inject", "", "injectable", "Lcom/stripe/android/core/injection/Injectable;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkPaymentLauncher.kt */
public final class LinkPaymentLauncher$setupInjector$injector$1 implements NonFallbackInjector {
    final /* synthetic */ LinkPaymentLauncherComponent $launcherComponent;

    LinkPaymentLauncher$setupInjector$injector$1(LinkPaymentLauncherComponent linkPaymentLauncherComponent) {
        this.$launcherComponent = linkPaymentLauncherComponent;
    }

    public void inject(Injectable<?> injectable) {
        Intrinsics.checkNotNullParameter(injectable, "injectable");
        if (injectable instanceof LinkActivityViewModel.Factory) {
            this.$launcherComponent.inject((LinkActivityViewModel.Factory) injectable);
        } else if (injectable instanceof SignUpViewModel.Factory) {
            this.$launcherComponent.inject((SignUpViewModel.Factory) injectable);
        } else if (injectable instanceof VerificationViewModel.Factory) {
            this.$launcherComponent.inject((VerificationViewModel.Factory) injectable);
        } else if (injectable instanceof WalletViewModel.Factory) {
            this.$launcherComponent.inject((WalletViewModel.Factory) injectable);
        } else {
            throw new IllegalArgumentException("invalid Injectable " + injectable + " requested in " + this);
        }
    }
}
