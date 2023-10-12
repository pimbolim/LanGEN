package com.stripe.android.paymentsheet;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
final class PaymentOptionsAdapterKt$PaymentOptionUi$2$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    public static final PaymentOptionsAdapterKt$PaymentOptionUi$2$1 INSTANCE = new PaymentOptionsAdapterKt$PaymentOptionUi$2$1();

    PaymentOptionsAdapterKt$PaymentOptionUi$2$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConstrainScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ConstrainScope constrainScope) {
        Intrinsics.checkNotNullParameter(constrainScope, "$this$constrainAs");
        HorizontalAnchorable.DefaultImpls.m4175linkToVpY3zN4$default(constrainScope.getTop(), constrainScope.getParent().getTop(), 0.0f, 0.0f, 6, (Object) null);
        VerticalAnchorable.DefaultImpls.m4214linkToVpY3zN4$default(constrainScope.getStart(), constrainScope.getParent().getStart(), 0.0f, 0.0f, 6, (Object) null);
        VerticalAnchorable.DefaultImpls.m4214linkToVpY3zN4$default(constrainScope.getEnd(), constrainScope.getParent().getEnd(), 0.0f, 0.0f, 6, (Object) null);
    }
}
