package com.stripe.android.paymentsheet.injection;

import com.stripe.android.paymentsheet.flowcontroller.FlowControllerViewModel;
import com.stripe.android.paymentsheet.model.ClientSecret;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class FlowControllerModule_Companion_ProvideClientSecretFactory implements Factory<ClientSecret> {
    private final Provider<FlowControllerViewModel> viewModelProvider;

    public FlowControllerModule_Companion_ProvideClientSecretFactory(Provider<FlowControllerViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public ClientSecret get() {
        return provideClientSecret(this.viewModelProvider.get());
    }

    public static FlowControllerModule_Companion_ProvideClientSecretFactory create(Provider<FlowControllerViewModel> provider) {
        return new FlowControllerModule_Companion_ProvideClientSecretFactory(provider);
    }

    public static ClientSecret provideClientSecret(FlowControllerViewModel flowControllerViewModel) {
        return (ClientSecret) Preconditions.checkNotNullFromProvides(FlowControllerModule.Companion.provideClientSecret(flowControllerViewModel));
    }
}
