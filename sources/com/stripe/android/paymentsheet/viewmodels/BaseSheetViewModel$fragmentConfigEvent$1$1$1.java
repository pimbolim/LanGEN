package com.stripe.android.paymentsheet.viewmodels;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.stripe.android.paymentsheet.model.FragmentConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "TransitionTargetType", "it", "", "onChanged"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSheetViewModel.kt */
final class BaseSheetViewModel$fragmentConfigEvent$1$1$1<T> implements Observer {
    final /* synthetic */ MediatorLiveData<FragmentConfig> $this_apply;
    final /* synthetic */ BaseSheetViewModel<TransitionTargetType> this$0;

    BaseSheetViewModel$fragmentConfigEvent$1$1$1(MediatorLiveData<FragmentConfig> mediatorLiveData, BaseSheetViewModel<TransitionTargetType> baseSheetViewModel) {
        this.$this_apply = mediatorLiveData;
        this.this$0 = baseSheetViewModel;
    }

    public final void onChanged(Object obj) {
        this.$this_apply.setValue(this.this$0.createFragmentConfig());
    }
}
