package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.state.ConstraintReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/constraintlayout/core/state/ConstraintReference;", "floatValue", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstrainScope.kt */
final class ConstrainScope$translationX$1 extends Lambda implements Function2<ConstraintReference, Float, Unit> {
    public static final ConstrainScope$translationX$1 INSTANCE = new ConstrainScope$translationX$1();

    ConstrainScope$translationX$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ConstraintReference) obj, ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ConstraintReference constraintReference, float f) {
        Intrinsics.checkNotNullParameter(constraintReference, "$this$addFloatTransformFromDp");
        constraintReference.translationX(f);
    }
}
