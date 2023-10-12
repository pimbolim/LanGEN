package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.state.Dimension;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/core/state/Dimension;", "Landroidx/constraintlayout/compose/SolverDimension;", "state", "Landroidx/constraintlayout/compose/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class Dimension$Companion$preferredValue$1 extends Lambda implements Function1<State, Dimension> {
    final /* synthetic */ float $dp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Dimension$Companion$preferredValue$1(float f) {
        super(1);
        this.$dp = f;
    }

    public final Dimension invoke(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        Dimension suggested = Dimension.Suggested(state.convertDimension(Dp.m3857boximpl(this.$dp))).suggested(Dimension.SPREAD_DIMENSION);
        Intrinsics.checkNotNullExpressionValue(suggested, "Suggested(state.convertDimension(dp)).suggested(SPREAD_DIMENSION)");
        return suggested;
    }
}
