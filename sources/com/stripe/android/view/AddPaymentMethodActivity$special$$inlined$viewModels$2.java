package com.stripe.android.view;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "androidx/activity/ActivityViewModelLazyKt$viewModels$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityViewModelLazy.kt */
public final class AddPaymentMethodActivity$special$$inlined$viewModels$2 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddPaymentMethodActivity$special$$inlined$viewModels$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
