package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class ConstraintSetForInlineDsl$onCommitAffectingConstrainLambdas$1 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ ConstraintSetForInlineDsl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintSetForInlineDsl$onCommitAffectingConstrainLambdas$1(ConstraintSetForInlineDsl constraintSetForInlineDsl) {
        super(1);
        this.this$0 = constraintSetForInlineDsl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Unit) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "$noName_0");
        this.this$0.setKnownDirty(true);
    }
}
