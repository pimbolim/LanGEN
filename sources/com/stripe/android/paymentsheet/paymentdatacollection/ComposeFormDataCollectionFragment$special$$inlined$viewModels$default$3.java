package com.stripe.android.paymentsheet.paymentdatacollection;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$3"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FragmentViewModelLazy.kt */
public final class ComposeFormDataCollectionFragment$special$$inlined$viewModels$default$3 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Function0 $ownerProducer;
    final /* synthetic */ Fragment $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeFormDataCollectionFragment$special$$inlined$viewModels$default$3(Function0 function0, Fragment fragment) {
        super(0);
        this.$ownerProducer = function0;
        this.$this_viewModels = fragment;
    }

    public final ViewModelProvider.Factory invoke() {
        Object invoke = this.$ownerProducer.invoke();
        ViewModelProvider.Factory factory = null;
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = invoke instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) invoke : null;
        if (hasDefaultViewModelProviderFactory != null) {
            factory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory();
        }
        if (factory == null) {
            factory = this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
        Intrinsics.checkNotNullExpressionValue(factory, "(ownerProducer() as? Has…tViewModelProviderFactory");
        return factory;
    }
}
