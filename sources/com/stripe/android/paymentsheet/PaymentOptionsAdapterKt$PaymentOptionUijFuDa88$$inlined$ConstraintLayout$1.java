package com.stripe.android.paymentsheet;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.compose.Measurer;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi-jFuDa88$$inlined$ConstraintLayout$1  reason: invalid class name */
/* compiled from: ConstraintLayout.kt */
public final class PaymentOptionsAdapterKt$PaymentOptionUijFuDa88$$inlined$ConstraintLayout$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ Measurer $measurer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentOptionsAdapterKt$PaymentOptionUijFuDa88$$inlined$ConstraintLayout$1(Measurer measurer) {
        super(1);
        this.$measurer = measurer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, this.$measurer);
    }
}
