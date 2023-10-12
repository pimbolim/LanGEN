package com.stripe.android.paymentsheet;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
final class PaymentOptionsAdapterKt$PaymentOptionUi$2$7$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ ConstrainedLayoutReference $card;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsAdapterKt$PaymentOptionUi$2$7$1(ConstrainedLayoutReference constrainedLayoutReference) {
        super(1);
        this.$card = constrainedLayoutReference;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConstrainScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ConstrainScope constrainScope) {
        Intrinsics.checkNotNullParameter(constrainScope, "$this$constrainAs");
        HorizontalAnchorable.DefaultImpls.m4175linkToVpY3zN4$default(constrainScope.getTop(), this.$card.getBottom(), 0.0f, 0.0f, 6, (Object) null);
        VerticalAnchorable.DefaultImpls.m4214linkToVpY3zN4$default(constrainScope.getStart(), this.$card.getStart(), 0.0f, 0.0f, 6, (Object) null);
    }
}
