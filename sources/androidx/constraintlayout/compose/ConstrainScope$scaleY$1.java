package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.state.ConstraintReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/constraintlayout/core/state/ConstraintReference;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstrainScope.kt */
final class ConstrainScope$scaleY$1 extends Lambda implements Function1<ConstraintReference, Unit> {
    final /* synthetic */ float $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstrainScope$scaleY$1(float f) {
        super(1);
        this.$value = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConstraintReference) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ConstraintReference constraintReference) {
        Intrinsics.checkNotNullParameter(constraintReference, "$this$addTransform");
        constraintReference.scaleY(this.$value);
    }
}
