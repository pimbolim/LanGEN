package com.stripe.android.ui.core.elements;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RowElementUI.kt */
final class RowElementUIKt$RowElementUI$3$1$2 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ List<ConstrainedLayoutReference> $fieldRefs;
    final /* synthetic */ int $index;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RowElementUIKt$RowElementUI$3$1$2(List<ConstrainedLayoutReference> list, int i) {
        super(1);
        this.$fieldRefs = list;
        this.$index = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConstrainScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ConstrainScope constrainScope) {
        Intrinsics.checkNotNullParameter(constrainScope, "$this$constrainAs");
        VerticalAnchorable.DefaultImpls.m4214linkToVpY3zN4$default(constrainScope.getStart(), this.$fieldRefs.get(this.$index).getEnd(), 0.0f, 0.0f, 6, (Object) null);
        HorizontalAnchorable.DefaultImpls.m4175linkToVpY3zN4$default(constrainScope.getTop(), constrainScope.getParent().getTop(), 0.0f, 0.0f, 6, (Object) null);
        HorizontalAnchorable.DefaultImpls.m4175linkToVpY3zN4$default(constrainScope.getBottom(), constrainScope.getParent().getBottom(), 0.0f, 0.0f, 6, (Object) null);
        constrainScope.setHeight(Dimension.Companion.getFillToConstraints());
    }
}
