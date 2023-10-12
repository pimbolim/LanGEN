package com.stripe.android.paymentsheet.injection;

import androidx.lifecycle.ViewModelStoreOwner;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class FlowControllerModule_Companion_ProvideViewModelFactory implements Factory<FlowControllerViewModel> {
    private final Provider<ViewModelStoreOwner> viewModelStoreOwnerProvider;

    public FlowControllerModule_Companion_ProvideViewModelFactory(Provider<ViewModelStoreOwner> provider) {
        this.viewModelStoreOwnerProvider = provider;
    }

    public FlowControllerViewModel get() {
        return provideViewModel(this.viewModelStoreOwnerProvider.get());
    }

    public static FlowControllerModule_Companion_ProvideViewModelFactory create(Provider<ViewModelStoreOwner> provider) {
        return new FlowControllerModule_Companion_ProvideViewModelFactory(provider);
    }

    public static FlowControllerViewModel provideViewModel(ViewModelStoreOwner viewModelStoreOwner) {
        return (FlowControllerViewModel) Preconditions.checkNotNullFromProvides(FlowControllerModule.Companion.provideViewModel(viewModelStoreOwner));
    }
}
