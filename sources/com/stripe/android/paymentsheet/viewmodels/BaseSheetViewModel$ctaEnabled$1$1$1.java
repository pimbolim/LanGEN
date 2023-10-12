package com.stripe.android.paymentsheet.viewmodels;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "TransitionTargetType", "it", "", "onChanged"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSheetViewModel.kt */
final class BaseSheetViewModel$ctaEnabled$1$1$1<T> implements Observer {
    final /* synthetic */ MediatorLiveData<Boolean> $this_apply;
    final /* synthetic */ BaseSheetViewModel<TransitionTargetType> this$0;

    BaseSheetViewModel$ctaEnabled$1$1$1(MediatorLiveData<Boolean> mediatorLiveData, BaseSheetViewModel<TransitionTargetType> baseSheetViewModel) {
        this.$this_apply = mediatorLiveData;
        this.this$0 = baseSheetViewModel;
    }

    public final void onChanged(Object obj) {
        MediatorLiveData<Boolean> mediatorLiveData = this.$this_apply;
        boolean z = true;
        if (!Intrinsics.areEqual((Object) this.this$0.getButtonsEnabled().getValue(), (Object) true) || this.this$0.getSelection$paymentsheet_release().getValue() == null) {
            z = false;
        }
        mediatorLiveData.setValue(Boolean.valueOf(z));
    }
}
