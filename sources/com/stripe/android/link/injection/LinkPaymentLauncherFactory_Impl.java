package com.stripe.android.link.injection;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkPaymentLauncher;
import com.stripe.android.link.LinkPaymentLauncher_Factory;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

public final class LinkPaymentLauncherFactory_Impl implements LinkPaymentLauncherFactory {
    private final LinkPaymentLauncher_Factory delegateFactory;

    LinkPaymentLauncherFactory_Impl(LinkPaymentLauncher_Factory linkPaymentLauncher_Factory) {
        this.delegateFactory = linkPaymentLauncher_Factory;
    }

    public LinkPaymentLauncher create(ActivityResultLauncher<LinkActivityContract.Args> activityResultLauncher) {
        return this.delegateFactory.get(activityResultLauncher);
    }

    public static Provider<LinkPaymentLauncherFactory> create(LinkPaymentLauncher_Factory linkPaymentLauncher_Factory) {
        return InstanceFactory.create(new LinkPaymentLauncherFactory_Impl(linkPaymentLauncher_Factory));
    }
}
