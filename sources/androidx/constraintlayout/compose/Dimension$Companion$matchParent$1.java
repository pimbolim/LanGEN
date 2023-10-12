package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.state.Dimension;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/core/state/Dimension;", "Landroidx/constraintlayout/compose/SolverDimension;", "it", "Landroidx/constraintlayout/compose/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class Dimension$Companion$matchParent$1 extends Lambda implements Function1<State, Dimension> {
    public static final Dimension$Companion$matchParent$1 INSTANCE = new Dimension$Companion$matchParent$1();

    Dimension$Companion$matchParent$1() {
        super(1);
    }

    public final Dimension invoke(State state) {
        Intrinsics.checkNotNullParameter(state, "it");
        Dimension Parent = Dimension.Parent();
        Intrinsics.checkNotNullExpressionValue(Parent, "Parent()");
        return Parent;
    }
}
