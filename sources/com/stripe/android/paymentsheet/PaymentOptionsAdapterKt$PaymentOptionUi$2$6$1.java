package com.stripe.android.paymentsheet;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
final class PaymentOptionsAdapterKt$PaymentOptionUi$2$6$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Boolean> $openDialog;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsAdapterKt$PaymentOptionUi$2$6$1(MutableState<Boolean> mutableState) {
        super(0);
        this.$openDialog = mutableState;
    }

    public final void invoke() {
        this.$openDialog.setValue(true);
    }
}
