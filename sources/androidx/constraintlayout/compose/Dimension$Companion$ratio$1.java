package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.state.Dimension;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/core/state/Dimension;", "Landroidx/constraintlayout/compose/SolverDimension;", "it", "Landroidx/constraintlayout/compose/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class Dimension$Companion$ratio$1 extends Lambda implements Function1<State, Dimension> {
    final /* synthetic */ String $ratio;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Dimension$Companion$ratio$1(String str) {
        super(1);
        this.$ratio = str;
    }

    public final Dimension invoke(State state) {
        Intrinsics.checkNotNullParameter(state, "it");
        Dimension suggested = Dimension.Ratio(this.$ratio).suggested(Dimension.SPREAD_DIMENSION);
        Intrinsics.checkNotNullExpressionValue(suggested, "Ratio(ratio).suggested(SPREAD_DIMENSION)");
        return suggested;
    }
}
