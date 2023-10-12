package com.stripe.android.paymentsheet;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetViewModel.kt */
final class PaymentSheetViewModel$showTopContainer$1$1$1<T> implements Observer {
    final /* synthetic */ MediatorLiveData<Boolean> $this_apply;
    final /* synthetic */ PaymentSheetViewModel this$0;

    PaymentSheetViewModel$showTopContainer$1$1$1(MediatorLiveData<Boolean> mediatorLiveData, PaymentSheetViewModel paymentSheetViewModel) {
        this.$this_apply = mediatorLiveData;
        this.this$0 = paymentSheetViewModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003d, code lost:
        if ((r0 == null ? null : (com.stripe.android.paymentsheet.model.FragmentConfig) r0.peekContent()) != null) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(java.lang.Object r4) {
        /*
            r3 = this;
            androidx.lifecycle.MediatorLiveData<java.lang.Boolean> r4 = r3.$this_apply
            com.stripe.android.paymentsheet.PaymentSheetViewModel r0 = r3.this$0
            androidx.lifecycle.LiveData r0 = r0.isLinkEnabled$paymentsheet_release()
            java.lang.Object r0 = r0.getValue()
            r1 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x0027
            com.stripe.android.paymentsheet.PaymentSheetViewModel r0 = r3.this$0
            androidx.lifecycle.LiveData r0 = r0.isGooglePayReady$paymentsheet_release()
            java.lang.Object r0 = r0.getValue()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0040
        L_0x0027:
            com.stripe.android.paymentsheet.PaymentSheetViewModel r0 = r3.this$0
            androidx.lifecycle.LiveData r0 = r0.getFragmentConfigEvent()
            java.lang.Object r0 = r0.getValue()
            com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel$Event r0 = (com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel.Event) r0
            if (r0 != 0) goto L_0x0037
            r0 = 0
            goto L_0x003d
        L_0x0037:
            java.lang.Object r0 = r0.peekContent()
            com.stripe.android.paymentsheet.model.FragmentConfig r0 = (com.stripe.android.paymentsheet.model.FragmentConfig) r0
        L_0x003d:
            if (r0 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r4.setValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentSheetViewModel$showTopContainer$1$1$1.onChanged(java.lang.Object):void");
    }
}
