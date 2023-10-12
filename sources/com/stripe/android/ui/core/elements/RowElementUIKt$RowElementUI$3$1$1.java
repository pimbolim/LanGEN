package com.stripe.android.ui.core.elements;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
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
final class RowElementUIKt$RowElementUI$3$1$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ List<ConstrainedLayoutReference> $dividerRefs;
    final /* synthetic */ int $index;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RowElementUIKt$RowElementUI$3$1$1(int i, List<ConstrainedLayoutReference> list) {
        super(1);
        this.$index = i;
        this.$dividerRefs = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConstrainScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ConstrainScope constrainScope) {
        Intrinsics.checkNotNullParameter(constrainScope, "$this$constrainAs");
        if (this.$index == 0) {
            VerticalAnchorable.DefaultImpls.m4214linkToVpY3zN4$default(constrainScope.getStart(), constrainScope.getParent().getStart(), 0.0f, 0.0f, 6, (Object) null);
        } else {
            VerticalAnchorable.DefaultImpls.m4214linkToVpY3zN4$default(constrainScope.getStart(), this.$dividerRefs.get(this.$index - 1).getEnd(), 0.0f, 0.0f, 6, (Object) null);
        }
        HorizontalAnchorable.DefaultImpls.m4175linkToVpY3zN4$default(constrainScope.getTop(), constrainScope.getParent().getTop(), 0.0f, 0.0f, 6, (Object) null);
    }
}
